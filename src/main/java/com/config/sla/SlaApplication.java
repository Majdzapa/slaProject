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

		//that will be changed with using database
		SlaLineExample l1 = createSlaLineExample("MAJD",null,20,"notif1");
		SlaLineExample l2 = createSlaLineExample("MAJD","TUN",20,"notif2");
		SlaLineExample l3 = createSlaLineExample(null,null,20, "notif3");

		SlaProcessorExample processor = new SlaProcessorExample(List.of(l1,l2,l3));

		ResultTypeExample rt = processor.calculateResult();


		ModelSlaExample model = createSlaModelExample("MAJD",null,20,"notif1") ;
		SlaContextExample context = new SlaContextExample(null,model);
		System.out.println(rt.toString());
	}

}

