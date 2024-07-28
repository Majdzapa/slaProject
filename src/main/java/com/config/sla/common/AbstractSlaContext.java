package com.config.sla.common;

import lombok.SneakyThrows;
import lombok.experimental.SuperBuilder;

import java.lang.reflect.Field;
import java.util.TreeMap;

@SuperBuilder
public class AbstractSlaContext <T>{

    private final TreeMap<String,Object> context;
    private final T slaLineInstance;

    public AbstractSlaContext(TreeMap<String, Object> context, T slaLineInstance) {

        this.slaLineInstance = slaLineInstance;
        this.context = getAllFields(slaLineInstance);
    }

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
