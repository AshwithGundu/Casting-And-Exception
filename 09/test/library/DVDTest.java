/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import enums.MPAA_Rating;
import exceptions.NoFineException;
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
public class DVDTest {
    
    private DVD dvd;
    
    public DVDTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        dvd = new DVD(MPAA_Rating.PG_13, 2.6, "divergent");
    }

    @After
    public void tearDown() {
        dvd = null;
    }

    /**
     * Test of toString method, of class DVD.
     */
    @Test
    public void testToString() {
        DVD instance = new DVD(MPAA_Rating.G, 2.5, "Captain America");
        String expResult = "Title: captain america, Available: false, DVD ID: NWM_DVD_2, Rating: G, Storage Capacity: 2.5\n";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of generateUniqueID method, of class DVD.
     */
    @Test
    public void testGenerateRackID() {
        String[] expResult = {"ansayj.1.2",  "catdog.1.2",
            "hocolctea.1.2", "abxabxabxabxabxabxabx.1.2", 
            };
        String[] input = {"sanjay","tcagdo","chocolate","xabxabxabxabxabxabxab",
            };
        String result[] = new String[input.length];
        for (int i = 0; i < expResult.length; i++) {
            DVD instance = new DVD(MPAA_Rating.G, 1.2, input[i]);
            result[i] = instance.generateRackID();
            System.out.println(result[i]);
        }
        assertArrayEquals(expResult, result);
    }

    
    /**
     * Test of getRating method, of class DVD.
     */
    @Test
    public void testGetRating() {
        MPAA_Rating expResult = MPAA_Rating.PG_13;
        MPAA_Rating result = dvd.getRating();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRating method, of class DVD.
     */
    @Test
    public void testSetRating() {
        MPAA_Rating expResult = MPAA_Rating.R;
        dvd.setRating(MPAA_Rating.R);
        MPAA_Rating result = dvd.getRating();
       assertEquals(expResult, result);
    }

    /**
     * Test of getStorageCapacity method, of class DVD.
     */
    @Test
    public void testGetStorageCapacity() {
        double expResult = 2.6;
        double result = dvd.getStorageCapacity();
        assertEquals(expResult, result, 0);
    }

    /**
     * Test of setStorageCapacity method, of class DVD.
     */
    @Test
    public void testSetStorageCapacity() {
        double storageCapacity = 2.4;
        dvd.setStorageCapacity(storageCapacity);
        double result = dvd.getStorageCapacity();
        assertEquals(storageCapacity, result, 0);
    }

    /**
     * Test of generateUniqueID method, of class DVD.
     */
    @Test
    public void testGenerateUniqueID() {
        String expResult = "NWM_DVD_3";
        String result = dvd.generateUniqueID();
        assertEquals(expResult, result);
    }
     /**
     * Test of calculateFine method, of class Item.
     * @throws exceptions.NoFineException
     */
    @Test 
    public void testCalculateFine() throws NoFineException{
        double result = dvd.calculateFine("12/30/2017 10:00:00"
                , "12/30/2017 10:05:00");
        System.out.println(result);
        double expectedResult = 0.0;
        assertEquals(expectedResult, result, 0.0);
    }
    
}
