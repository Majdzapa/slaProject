package com.config.sla.example;

import com.config.sla.common.AbstractSlaRequest;
import lombok.experimental.SuperBuilder;

import java.util.TreeMap;

@SuperBuilder
public class SlaContextExample extends AbstractSlaRequest<ModelSlaExample> {

    public SlaContextExample(TreeMap<String, Object> context, ModelSlaExample slaLineInstance) {
       super(context,slaLineInstance);
    }
}
