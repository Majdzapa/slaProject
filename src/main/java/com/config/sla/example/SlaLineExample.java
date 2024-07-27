package com.config.sla.example;

import com.config.sla.common.AbstractSlaLine;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.TreeMap;

@SuperBuilder
@ToString
public  class SlaLineExample extends AbstractSlaLine<ModelSlaExample,ResultTypeExample> {

    public SlaLineExample(ResultSla<ResultTypeExample> result, Class<ModelSlaExample> type, TreeMap<String, Object> context) {
        super(result, type, context);


    }


}
