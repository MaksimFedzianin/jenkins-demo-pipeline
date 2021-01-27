package com.example.demo.pipeline;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class DemoPipelineApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void dumbTest() {
		assertTrue(true);
    }

    @Test
    void oneMoreDumbTest(){
    	assertEquals(2, 1 + 1);
	}

}
