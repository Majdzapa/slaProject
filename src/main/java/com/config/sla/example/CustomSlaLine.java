
package com.config.sla.example;

import com.config.sla.common.AbstractSlaLine;
import lombok.ToString;

@ToString
public class CustomSlaLine<T, R> extends AbstractSlaLine<T, R> {
    
    public CustomSlaLine(ResultSla<R> result, Class<T> type, T slaLineInstance) {
        super(result, type, slaLineInstance);
    }
}
