package com.config.sla;

import com.config.sla.example.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

import static com.config.sla.utility.SlaUtility.createSlaLineExample;
import static com.config.sla.utility.SlaUtility.createSlaModelExample;

@SpringBootApplication
@Slf4j
public class SlaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SlaApplication.class, args);

		// Example 1: Basic SLA processing
		log.info("Example 1: Basic SLA processing");
		SlaLineExample l1 = createSlaLineExample("MAJD", null, 20, "notif1");
		SlaLineExample l2 = createSlaLineExample("MAJD", "TUN", 20, "notif2");
		SlaLineExample l3 = createSlaLineExample(null, null, 20, "notif3");

		SlaProcessorExample processor = new SlaProcessorExample(List.of(l1, l2, l3));
		ResultTypeExample rt = processor.calculateResult();
		log.info("Result 1: {}", rt);

		// Example 2: SLA Context with Model
		log.info("Example 2: SLA Context with Model");
		ModelSlaExample model = createSlaModelExample("MAJD", "TUN", 25, "notif4");
		SlaContextExample context = new SlaContextExample(null, model);
		log.info("Context fields: {}", context.getContext());

		// Example 3: Custom SLA Line
		log.info("Example 3: Custom SLA Line");
		CustomSlaLine<ModelSlaExample, ResultTypeExample> customLine = new CustomSlaLine<>(
			AbstractSlaLine.ResultSla.<ResultTypeExample>builder()
				.result(ResultTypeExample.builder().notificationName("custom_notif").build())
				.build(),
			ModelSlaExample.class,
			model
		);
		log.info("Custom line: {}", customLine);
	}

}

