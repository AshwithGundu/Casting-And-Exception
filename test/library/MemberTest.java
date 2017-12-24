/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import enums.MPAA_Rating;
import exceptions.UnderAgeException;
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
public class MemberTest {
    
      public MemberTest() {
    }
    
    private Member member;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        member=new Student("Android,PM,ITM",15,"Vamsi Ravva");
    }
    
    @After
    public void tearDown() {
        member=null;
    }

    /**
     * Test of generateMemberID method, of class Member.
     */
    @Test
    public void testGenerateMemberID() {
        System.out.println("generateMemberID");
        Member instance = member;
        String expResult = "919648107";
        String result = instance.getMemberID();
        assertEquals(expResult, result);
    }

    /**
     * Test of addItems method, of class Member.
     */
    @Test(expected = UnderAgeException.class)
    public void testAddItems() throws Exception {
        Item item = new DVD(MPAA_Rating.R, 0, "HarryPoter1");
        Member instance = member;
        instance.addItems(item);
    }

    
}
