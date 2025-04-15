package com.config.sla.example;

import com.config.sla.common.AbstractSlaLine;
import com.config.sla.common.AbstractSlaProcessor;
import com.config.sla.common.ReflectionUtils;

import java.util.List;
import java.util.TreeMap;

import static com.config.sla.utility.SlaUtility.createSlaLineExample;


public class SlaProcessorExample extends AbstractSlaProcessor<ModelSlaExample,ResultTypeExample> {



    private final List<AbstractSlaLine<ModelSlaExample,ResultTypeExample>> slaList ;

    public SlaProcessorExample(List<AbstractSlaLine<ModelSlaExample, ResultTypeExample>> slaList) {
        this.slaList = slaList;
    }

    public ResultTypeExample calculateResult(TreeMap<String, Object> inputContext) {
        List<AbstractSlaLine<ModelSlaExample, ResultTypeExample>> matchingSlas = slaList.stream()
                .filter(sla -> sla.matches(inputContext))
                .toList();

        if (matchingSlas.isEmpty()) {
            return null;
        }

        return getSlaResultFomEntryContext(matchingSlas).getResult();
    }

    public ResultTypeExample calculateResult() {
        return calculateResult(new TreeMap<>());
    }

}