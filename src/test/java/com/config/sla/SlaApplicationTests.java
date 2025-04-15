
package com.config.sla;

import com.config.sla.example.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static com.config.sla.utility.SlaUtility.createSlaLineExample;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SlaApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testSlaProcessor() {
        // Create test SLA lines
        SlaLineExample l1 = createSlaLineExample("John", null, 25, "notification1");
        SlaLineExample l2 = createSlaLineExample("Jane", "USA", 30, "notification2");
        
        // Create processor with test lines
        SlaProcessorExample processor = new SlaProcessorExample(List.of(l1, l2));
        
        // Calculate result
        ResultTypeExample result = processor.calculateResult();
        
        // Assert results
        assertNotNull(result);
        assertEquals("notification1", result.getNotificationName());
    }

    @Test
    void testSlaContext() {
        // Create test model
        ModelSlaExample model = ModelSlaExample.builder()
                .name("Test")
                .age(20)
                .Nationality("FRA")
                .build();
                
        // Create context
        SlaContextExample context = new SlaContextExample(null, model);
        
        // Assert context
        assertNotNull(context.getContext());
        assertEquals("Test", context.getContext().get("name"));
        assertEquals(20, context.getContext().get("age"));
        assertEquals("FRA", context.getContext().get("Nationality"));
    }
}
