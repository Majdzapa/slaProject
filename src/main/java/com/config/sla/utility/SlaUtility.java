package com.config.sla.utility;

import com.config.sla.common.AbstractSlaLine;
import com.config.sla.example.ModelSlaExample;
import com.config.sla.example.ResultTypeExample;
import com.config.sla.example.SlaLineExample;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SlaUtility {

    public static SlaLineExample createSlaLineExample(String name , String nationality , Integer age , String res){

        ResultTypeExample rs = ResultTypeExample.builder()
                .notificationName(res)
                .build();


        AbstractSlaLine.ResultSla<ResultTypeExample> result = AbstractSlaLine.ResultSla.<ResultTypeExample>builder()
                .result(rs)
                .build();

        ModelSlaExample model = createSlaModelExample(name,nationality,age,res);

        return new SlaLineExample(
                result,
                ModelSlaExample.class,
                model
        );
    }



    public static ModelSlaExample createSlaModelExample(String name , String nationality , Integer age , String res){

        return ModelSlaExample.builder()
                .name(name)
                .age(age)
                .Nationality(nationality)
                .build();

    }




}
