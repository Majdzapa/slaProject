package com.config.sla.utility;

import com.config.sla.common.AbstractSlaLine;
import com.config.sla.common.ReflectionUtils;
import com.config.sla.example.ModelSlaExample;
import com.config.sla.example.ResultTypeExample;
import com.config.sla.example.SlaLineExample;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class SlaUtility {

    public static SlaLineExample createSlaLineExample(String name , String nationality , Integer age , String res){

        ResultTypeExample rs = ResultTypeExample.builder()
                .notificationName(res)
                .build();


        AbstractSlaLine.ResultSla<ResultTypeExample> result = AbstractSlaLine.ResultSla.<ResultTypeExample>builder()
                .result(rs)
                .build();

        ModelSlaExample model = ModelSlaExample.builder()
                .name(name)
                .age(age)
                .Nationality(nationality)
                .build();

        return new SlaLineExample(
                result,
                ModelSlaExample.class,
                ReflectionUtils.getAllFields(model)
        );
    }




}
