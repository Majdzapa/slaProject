package com.config.sla.common;

import lombok.Builder;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SuperBuilder
@Slf4j
@Getter
public abstract class AbstractSlaLine<T ,R> {

    private final TreeMap<String,Object> context;
    private final Integer weight ;
    private final ResultSla<R> result;
    private final Class<T> type;

    public AbstractSlaLine( ResultSla<R> result, Class<T> type,TreeMap<String,Object> context) {
        this.type = type;
        this.result = result;
        this.context = context;
        this.weight = calculateWeight(context);
    }

    @SneakyThrows
    public TreeMap<String, Object> getAllFields(T object) {
        TreeMap<String, Object> fieldMap = new TreeMap<>() ;
        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {
            Object value = field.get(object);
            fieldMap.put(field.getName(),value);
        }
        return fieldMap;
    }

    public  Integer calculateWeight(TreeMap<String,Object> contextFields){

        List<Integer> propRanks = getFilledPropRankList(contextFields);

        return  propRanks.stream()
                .map(rank -> rank + 200)
                .toList()
                .stream()
                .reduce(0, Integer::sum);
    }


    private static List<Integer> getFilledPropRankList(TreeMap<String,Object> contextFields) {

        Set<String> keySet = contextFields.keySet();
        int n = keySet.size();
        String[] arr = new String[n];

        return IntStream.range(0, contextFields.size())
                .filter(index -> contextFields.get(keySet.toArray(arr)[index]) != null)
                .mapToObj(index -> index + 1)
                .collect(Collectors.toList());
    }

    @Value
    @Builder
    public static class ResultSla<R> {
        private final R result;
    }
}
