
package com.config.sla.common;

import lombok.experimental.SuperBuilder;
import lombok.SneakyThrows;
import java.lang.reflect.Field;
import java.util.TreeMap;

@SuperBuilder
public abstract class AbstractSlaContext<T> {

    private final TreeMap<String, Object> context;
    private final T slaLineInstance;

    public AbstractSlaContext(TreeMap<String, Object> context, T slaLineInstance) {
        this.slaLineInstance = slaLineInstance;
        this.context = context != null ? context : getAllFields(slaLineInstance);
    }

    @SneakyThrows
    public static <T> TreeMap<String, Object> getAllFields(T instance) {
        TreeMap<String, Object> fieldMap = new TreeMap<>();
        if (instance == null) return fieldMap;
        
        Class<?> clazz = instance.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            fieldMap.put(field.getName(), field.get(instance));
        }
        return fieldMap;
    }

    public TreeMap<String, Object> getContext() {
        return context;
    }
}
