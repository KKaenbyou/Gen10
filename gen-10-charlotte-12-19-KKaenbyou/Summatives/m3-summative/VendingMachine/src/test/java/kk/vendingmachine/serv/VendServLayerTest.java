package kk.vendingmachine.serv;

import java.util.List;
import kk.vendingmachine.dao.VendEx;
import kk.vendingmachine.dto.Vend;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class VendServLayerTest {

    private VendServLayer service;

    public VendServLayerTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        service = ctx.getBean("service", VendServLayer.class);
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

    /**
     * Test of daoChange method, of class VendServLayer.
     */
    @Test
    public void testDaoChange() throws Exception {
    }

    /**
     * Test of boughtVend method, of class VendServLayer.
     */
    @Test
    public void testBoughtVend() throws Exception {
    }

    /**
     * Test of getAllVend method, of class VendServLayer.
     */
    @Test
    public void testGetAllVend() throws Exception {
    }

    public class VendServLayerImpl implements VendServLayer {

        public void daoChange(String vend, String money) throws VendEx, LowFundsEx, NoItemEx {
        }

        public void boughtVend(String vend) throws VendEx {
        }

        public List<Vend> getAllVend() throws VendEx {
            return null;
        }
    }
}