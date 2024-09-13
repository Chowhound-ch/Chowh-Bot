package per.chowhound.bot.register;

import cn.hutool.core.util.ClassUtil;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.context.event.*;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import per.chowhound.bot.event.Event;
import per.chowhound.bot.filter.AlwaysTrueFilter;
import per.chowhound.bot.filter.EventFilter;
import per.chowhound.bot.register.utils.EventUtil;

import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Function;


/**
 * 事件监听扫描，由于事件监听依赖SpringBoot，直接扫描启动类所在包即可
 */
@Slf4j
@Component
public class EventScanner implements ApplicationListener<ApplicationReadyEvent> {
    public Map<Class<? extends Event>, List<EventMethod>> EVENT_MAP;

    private final Comparator<EventMethod> methodComparator = Comparator.comparing(
            method -> method.getMethod().getAnnotation(Listener.class).priority());


    @Override
    public void onApplicationEvent(@NonNull ApplicationReadyEvent event) {
        if (EVENT_MAP != null) return;
        String startAppClassName = event.getSpringApplication().getMainApplicationClass().getName();
        String basePackage = startAppClassName.substring(0, startAppClassName.lastIndexOf('.'));
        log.info("开始注册事件监听器，basePackage: {}", basePackage);

        ConfigurableApplicationContext context = event.getApplicationContext();
        EVENT_MAP = getEventMethods(basePackage, clazz -> {
            try {
                return context.getBean(clazz);
            } catch (NoSuchBeanDefinitionException e) {
                return null;
            }
        });

        StringBuilder builder = new StringBuilder();
        EVENT_MAP.forEach((key, value) -> builder.append(key.getSimpleName()).append(" : ").append(value.size()).append(",  "));
        log.info("事件监听器注册完成: {}", builder);
    }



    public Map<Class<? extends Event>, List<EventMethod>> getEventMethods(String basePackage, Function<Class<?>, Object> eventClassFilter) {
        Map<Class<? extends Event>, List<EventMethod>> eventMethods = new HashMap<>();
        ClassUtil.scanPackage(basePackage).forEach(eventClass -> {
            Object target = eventClassFilter.apply(eventClass);
             if (target == null) {
                 return;
             }
             Method[] methods = eventClass.getDeclaredMethods();
             // 遍历方法
             for (Method method : methods) {
                 method.setAccessible(true);
                 if (!method.isAnnotationPresent(Listener.class)) {
                     continue;
                 }
                 // 遍历参数
                 Class<?>[] parameterTypes = method.getParameterTypes();
                 for (Class<?> parameterType : parameterTypes) {
                     if (Event.class.isAssignableFrom(parameterType)) {
                         List<EventMethod> methodList = eventMethods.computeIfAbsent(
                                 parameterType.asSubclass(Event.class), key -> new ArrayList<>());
                         Listener annotation = method.getAnnotation(Listener.class);
                         EventFilter filter = null;
                         try {
                             filter = annotation.filter().getConstructor(Listener.class).newInstance(annotation);
                         } catch (Exception e) {
                             log.error("事件{}过滤器实例化失败: {}",
                                     EventUtil.getEventName(annotation, method.getName()), e.getMessage());
                         }

                         if (filter == null) {
                             log.info("事件{}将使用always-true过滤器", EventUtil.getEventName(annotation, method.getName()));
                             filter = new AlwaysTrueFilter(annotation);
                         } else if (log.isDebugEnabled()) {
                             log.debug("事件{}注册过滤器: {}", EventUtil.getEventName(annotation, method.getName()), filter.getClass().getSimpleName());
                         }
                         addMethodIntoProprietyList(methodList, new EventMethod(method, filter, target));
                         break;
                     }
                 }
             }
             });
        return eventMethods;
    }

    public void addMethodIntoProprietyList(List<EventMethod> methodList, EventMethod method) {
        for (int i = 0; i < methodList.size(); i++) {
            if (methodComparator.compare(method, methodList.get(i)) < 0) {
                methodList.add(i, method);
                return;
            }
        }
        methodList.add(method);
    }

}
