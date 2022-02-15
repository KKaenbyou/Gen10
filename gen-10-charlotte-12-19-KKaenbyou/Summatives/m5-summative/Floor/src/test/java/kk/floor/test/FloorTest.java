package kk.floor.test;

import kk.floor.serv.FloorServ;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FloorTest {
    
    private FloorServ service;
    
    public FloorTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        service = ctx.getBean("service", FloorServ.class);
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @org.junit.jupiter.api.Test
    public void testAssert() {
        assert (true);
    }
    
    @org.junit.jupiter.api.Test
    public void testAssert2() {
        assert (true);
    }
    
    @org.junit.jupiter.api.Test
    public void testAssert3() {
        assert (true);
    }
    
    @org.junit.jupiter.api.Test
    public void testAssert4() {
        assert (true);
    }
}
