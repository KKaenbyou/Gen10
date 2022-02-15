package kk.VendingMachineUnitTests;

import kk.vendingmachine.dao.AuditDao;
import kk.vendingmachine.dao.VendDao;
import kk.vendingmachine.dto.Vend;
import kk.vendingmachine.serv.VendServLayer;
import kk.vendingmachine.serv.VendServLayerImp;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class VendTest {

    private VendDao dao;
    private VendServLayer service;

    public VendTest() {
        // ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        // VendTest test = ctx.getBean("vendTest", VendTest.class);
        VendDao dao = new VendDaoStub();
        AuditDao audit = new AuditStub();
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

    @Test
    public void testBoughtVend() throws Exception {
        Vend testVend = new Vend("testDrink");
        testVend.setPrice("1.00");
        testVend.setAmount(1);
        int amount = testVend.getAmount();
        testVend.setAmount(testVend.getAmount() - 1);
        int amount2 = testVend.getAmount();
        assert (amount2 == amount - 1);
    }

    @Test
    public void testAssert() {
        assert (true);
    }
}
