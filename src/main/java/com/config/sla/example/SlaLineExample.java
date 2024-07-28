package com.config.sla.example;

import com.config.sla.common.AbstractSlaLine;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.TreeMap;

@SuperBuilder
@ToString
public  class SlaLineExample extends AbstractSlaLine<ModelSlaExample,ResultTypeExample> {

    public SlaLineExample(ResultSla<ResultTypeExample> result, Class<ModelSlaExample> type, ModelSlaExample slaLineInstance) {
        super(result, type,slaLineInstance);


    }


}
