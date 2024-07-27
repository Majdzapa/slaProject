package com.config.sla.example;

import com.config.sla.common.AbstractSlaLine;
import com.config.sla.common.AbstractSlaProcessor;
import com.config.sla.common.ReflectionUtils;

import java.util.List;

import static com.config.sla.utility.SlaUtility.createSlaLineExample;


public class SlaProcessorExample extends AbstractSlaProcessor<ModelSlaExample,ResultTypeExample> {



    private final List<AbstractSlaLine<ModelSlaExample,ResultTypeExample>> slaList ;

    public SlaProcessorExample(List<AbstractSlaLine<ModelSlaExample, ResultTypeExample>> slaList) {
        this.slaList = slaList;
    }

    public ResultTypeExample calculateResult(){
      return getSlaResultFomEntryContext(slaList).getResult();

    }

}
