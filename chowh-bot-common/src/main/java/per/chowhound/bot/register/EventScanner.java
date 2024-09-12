package per.chowhound.bot.register;

import cn.hutool.core.util.ClassUtil;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import per.chowhound.bot.event.Event;

import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Predicate;


/**
 * 事件监听扫描，由于事件监听依赖SpringBoot，直接扫描启动类所在包即可
 */
@Slf4j
@Component
public class EventScanner implements ApplicationListener<ApplicationStartedEvent> {
    public Map<Class<? extends Event>, List<Method>> EVENT_MAP;
    private final Comparator<Method> methodComparator = Comparator.comparing(
            method -> method.getAnnotation(Listener.class).priority());


    @Override
    public void onApplicationEvent(@NonNull ApplicationStartedEvent event) {
        if (EVENT_MAP != null) return;
        String startAppClassName = event.getSpringApplication().getMainApplicationClass().getName();
        String basePackage = startAppClassName.substring(0, startAppClassName.lastIndexOf('.'));
        log.info("开始注册事件监听器，basePackage: {}", basePackage);

        ConfigurableApplicationContext context = event.getApplicationContext();
        EVENT_MAP = getEventMethods(basePackage,
                eventClass -> context.getBeanNamesForType(eventClass).length > 0);

        StringBuilder builder = new StringBuilder();
        EVENT_MAP.forEach((key, value) -> builder.append(key.getSimpleName()).append(" : ").append(value.size()).append(",  "));
        log.info("事件监听器注册完成: {}", builder);
    }



    public Map<Class<? extends Event>, List<Method>> getEventMethods(String basePackage, Predicate<Class<?>> eventClassFilter) {
        Map<Class<? extends Event>, List<Method>> eventMethods = new HashMap<>();
        ClassUtil.scanPackage(basePackage).stream()
                 .filter(eventClassFilter)
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
