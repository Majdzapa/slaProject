package com.config.sla.common;

import lombok.experimental.SuperBuilder;

import java.util.TreeMap;

@SuperBuilder
public class AbstractSlaRequest<T> extends AbstractSlaContext<T> {


    public AbstractSlaRequest(TreeMap<String, Object> context, T slaLineInstance) {
        super(context,slaLineInstance);

    }
}
