
package com.config.sla.common;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SuperBuilder
@Slf4j
@Getter
public abstract class AbstractSlaLine<T, R> extends AbstractSlaContext<T> {

    private final TreeMap<String, Object> context;
    private final Integer weight;
    private final ResultSla<R> result;
    private final Class<T> type;

    public AbstractSlaLine(ResultSla<R> result, Class<T> type, T slaLineInstance) {
        super(null, slaLineInstance);
        this.type = type;
        this.result = result;
        this.context = getAllFields(slaLineInstance);
        this.weight = calculateWeight(context);
    }

    public Integer calculateWeight(TreeMap<String, Object> contextFields) {
        List<Integer> propRanks = getFilledPropRankList(contextFields);
        return propRanks.stream()
                .map(rank -> rank + 200)
                .reduce(0, Integer::sum);
    }

    private static List<Integer> getFilledPropRankList(TreeMap<String, Object> contextFields) {
        Set<String> keySet = contextFields.keySet();
        String[] arr = keySet.toArray(new String[0]);
        
        return IntStream.range(0, contextFields.size())
                .filter(index -> contextFields.get(arr[index]) != null)
                .mapToObj(index -> index + 1)
                .collect(Collectors.toList());
    }

    public boolean matches(TreeMap<String, Object> inputContext) {
        return inputContext.entrySet().stream()
                .filter(entry -> entry.getValue() != null)
                .allMatch(entry -> {
                    Object slaValue = context.get(entry.getKey());
                    Object inputValue = entry.getValue();
                    return slaValue == null || slaValue.equals(inputValue);
                });
    }

    @Value
    @Builder
    public static class ResultSla<R> {
        private final R result;
    }
}
