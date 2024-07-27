package com.config.sla.common;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.TreeMap;

@RequiredArgsConstructor
public class ReflectionUtils {


    @SneakyThrows
    public static <T> TreeMap<String, Object> getAllFields(T instance) {
        TreeMap<String, Object> fieldMap = new TreeMap<>() ;
        Class<?> clazz = instance.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(instance);
            fieldMap.put(field.getName(),value);
        }
        return fieldMap;
    }
}
