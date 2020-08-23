package com.xwtec.dataSource;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2020/8/23.
 */
public class DynamicDataSourceAspect {
    public void intercept(JoinPoint joinpoint) throws NoSuchMethodException {
        Class<?> targetClass = joinpoint.getTarget().getClass();
        MethodSignature signature = (MethodSignature) joinpoint.getSignature();

        Class<?>[] interfaces = targetClass.getInterfaces();
        for (Class<?> clazz : interfaces) {
            resolveDataSource(clazz, signature.getMethod());
        }
        resolveDataSource(targetClass, signature.getMethod());
    }

    /**
     * @param clazz  解析@DataSource注解
     * @param method
     */
    private void resolveDataSource(Class<?> clazz, Method method) throws NoSuchMethodException {
        Class<?>[] parameterTypes = method.getParameterTypes();
        // 类上的@DataSource
        if (clazz.isAnnotationPresent(DataSource.class)) {
            DataSource dataSource = clazz.getAnnotation(DataSource.class);
            DynamicDataSourceHolder.setDataSource(dataSource.value());
        }
        // 方法上的@DataSource，如果有则覆盖类上的
        Method clazzMethod = clazz.getMethod(method.getName(), parameterTypes);
        if (clazzMethod != null && clazzMethod.isAnnotationPresent(DataSource.class)) {
            DataSource annotation = clazzMethod.getAnnotation(DataSource.class);
            DynamicDataSourceHolder.setDataSource(annotation.value());
        }
    }
}