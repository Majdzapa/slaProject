package com.config.sla.example;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ModelSlaExample {

    private final String name ;
    private final Integer age ;
    private final String Nationality;
}
