package per.chowhound.bot.register;

import cn.hutool.core.util.ClassUtil;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import per.chowhound.bot.event.Event;
import per.chowhound.bot.filter.AlwaysTrueFilter;
import per.chowhound.bot.filter.EventFilter;
import per.chowhound.bot.register.utils.EventUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;


/**
 * 事件监听扫描，由于事件监听依赖SpringBoot，直接扫描启动类所在包即可
 */
@Slf4j
@Component
public class EventScanner implements ApplicationListener<ApplicationStartedEvent> {
    public Map<Class<? extends Event>, List<EventMethod>> EVENT_MAP;

    private final Comparator<Method> methodComparator = Comparator.comparing(
            method -> method.getAnnotation(Listener.class).priority());


    @Override
    public void onApplicationEvent(@NonNull ApplicationStartedEvent event) {
        if (EVENT_MAP != null) return;
        String startAppClassName = event.getSpringApplication().getMainApplicationClass().getName();
        String basePackage = startAppClassName.substring(0, startAppClassName.lastIndexOf('.'));
        log.info("开始注册事件监听器，basePackage: {}", basePackage);

        ConfigurableApplicationContext context = event.getApplicationContext();
        EVENT_MAP = getEventMethods(basePackage, context::getBean);

        StringBuilder builder = new StringBuilder();
        EVENT_MAP.forEach((key, value) -> builder.append(key.getSimpleName()).append(" : ").append(value.size()).append(",  "));
        log.info("事件监听器注册完成: {}", builder);
    }



    public Map<Class<? extends Event>, List<EventMethod>> getEventMethods(String basePackage, Function<Class<?>, Object> eventClassFilter) {
        Map<Class<? extends Event>, List<Method>> eventMethods = new HashMap<>();
        ClassUtil.scanPackage(basePackage).stream()
                 .filter(clazz -> eventClassFilter.apply(clazz) != null)
                 .forEach(eventClass -> {
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
                                 List<Method> methodList = eventMethods.computeIfAbsent(
                                         parameterType.asSubclass(Event.class), key -> new ArrayList<>());
                                 addMethodIntoProprietyList(methodList, method);
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
                                 EVENT_FILTER_MAP.put(method, filter);
                                 break;
                             }
                         }
                     }
                 });
        return eventMethods;
    }

    public void addMethodIntoProprietyList(List<Method> methodList, Method method) {
        for (int i = 0; i < methodList.size(); i++) {
            if (methodComparator.compare(methodList.get(i), method) > 0) {
                methodList.add(i, method);
                return;
            }
        }
        methodList.add(0, method);
    }



}
