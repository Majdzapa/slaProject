package com.config.sla.common;

import lombok.experimental.SuperBuilder;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

//@SuperBuilder
public abstract class AbstractSlaProcessor<T,R> {

    protected List<AbstractSlaLine<T,R>> slaList;

    protected AbstractSlaLine.ResultSla<R> getSlaResultFomEntryContext(List<AbstractSlaLine<T,R>> slaList) {

        Optional<AbstractSlaLine<T, R>> maxSlaLine = slaList.stream()
                .max(Comparator.comparing(AbstractSlaLine::getWeight)) ;

       return maxSlaLine.map(AbstractSlaLine::getResult).orElse(null);

    }
}
