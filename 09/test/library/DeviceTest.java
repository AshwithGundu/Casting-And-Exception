/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ashwith Gundu
 */
public class DeviceTest {
    
    private Device device;
    
    public DeviceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        device=new Device("Android Charger");
    }
    
    @After
    public void tearDown() {
        device=null;
    }

    /**
     * Test of generateUniqueID method, of class Device.
     */
    @Test
    public void testGenerateUniqueID() {
        System.out.println("generateUniqueID");
        Device instance = device;
        String expResult = "NWM_D_2";
        String result = instance.generateUniqueID();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of calculateFine method, of class Device.
     */
    @Test
    public void testCalculateFine() throws Exception {
        String dueDate = "12/30/2017 10:00:00";
        String returnDate = "12/30/2017 11:05:00";
        Device instance = device;
        double expResult = 5.0;
        double result = instance.calculateFine(dueDate, returnDate);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of generateRackID method, of class Device.
     */
    @Test
    public void testGenerateRackID() {
        System.out.println("generateRackID");
        Device instance = device;
        String expResult = "droid Charger_D_7";
        String result = instance.generateRackID();
        assertEquals(expResult, result);
    }


    /**
     * Test of toString method, of class Device.
     */
    @Test
    public void testToString() {
        Device instance = device;
        String expResult = "Title: android charger, Available: false, "
                + "DeviceID: NWM_D_1, RackNo: droid Charger_D_7";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
