/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day03linkedlistarrayali;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alagh
 */
public class LinkedListArrayOfStringsTest {
    
    

    /**
     * Test of add method, of class LinkedListArrayOfStrings.
     
    @Test
    public void testAdd() {
        System.out.println("add");
        String value = "";
        LinkedListArrayOfStrings instance = new LinkedListArrayOfStrings();
        instance.add(value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get method, of class LinkedListArrayOfStrings.
     
    @Test
    public void testGet() {
        System.out.println("get");
        int index = 0;
        LinkedListArrayOfStrings instance = new LinkedListArrayOfStrings();
        String expResult = "";
        String result = instance.get(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
    
    // ** STEP 6 **
    @Test
    public void testAddGet() {
        System.out.println("add get");
        LinkedListArrayOfStrings instance = new LinkedListArrayOfStrings();
        instance.add("Jerry");
        instance.add("Terry");
        instance.add("Barry");
        instance.add("Larry");
        instance.add("Marry");
        assertEquals("Jerry", instance.get(0));
        assertEquals("Larry", instance.get(3));
        assertEquals("Marry", instance.get(4));
    }

    /**
     * Test of insertValueAtIndex method, of class LinkedListArrayOfStrings.
     
    @Test
    public void testInsertValueAtIndex() {
        System.out.println("insertValueAtIndex");
        String value = "";
        int index = 0;
        LinkedListArrayOfStrings instance = new LinkedListArrayOfStrings();
        instance.insertValueAtIndex(value, index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
    
    // ** STEP 10 **
    @Test
    public void testAddInsert() {
        System.out.println("add insert");
        LinkedListArrayOfStrings instance = new LinkedListArrayOfStrings();
        instance.add("Jerry");
        instance.add("Terry");
        instance.insertValueAtIndex("Barry",0);       
        assertEquals("[Barry,Jerry,Terry]", instance.toString());        
        instance.insertValueAtIndex("Marry",3); // really an add
        assertEquals("[Barry,Jerry,Terry,Marry]", instance.toString());        
        instance.insertValueAtIndex("Zarry",2);
        assertEquals("[Barry,Jerry,Zarry,Terry,Marry]", instance.toString());
    }

    /**
     * Test of deleteByIndex method, of class LinkedListArrayOfStrings.
     
    @Test
    public void testDeleteByIndex() {
        System.out.println("deleteByIndex");
        int index = 0;
        LinkedListArrayOfStrings instance = new LinkedListArrayOfStrings();
        instance.deleteByIndex(index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
    
    // ** STEP 8 **
    @Test
    public void testAddDelete() {
        System.out.println("add get");
        LinkedListArrayOfStrings instance = new LinkedListArrayOfStrings();
        instance.add("Jerry"); // 0
        instance.add("Terry");
        instance.add("Barry");
        instance.add("Marry"); // 3
        instance.add("Larry");
        instance.add("Zarry"); // 5
        instance.deleteByIndex(5);
        assertEquals("[Jerry,Terry,Barry,Marry,Larry]", instance.toString());
        instance.deleteByIndex(3);
        assertEquals("[Jerry,Terry,Barry,Larry]", instance.toString());
        instance.deleteByIndex(0);
        assertEquals("[Terry,Barry,Larry]", instance.toString());
    }

    /**
     * Test of deleteByValue method, of class LinkedListArrayOfStrings.
     */
    
    // ** STEP 12 **
    @Test
    public void testAddDeleteByValue() {
        System.out.println("Add and deleteByValue");
        LinkedListArrayOfStrings instance = new LinkedListArrayOfStrings();
        instance.add("Jerry"); 
        instance.add("Terry");
        instance.add("Barry");
        instance.add("Marry"); 
        instance.add("Larry");
        instance.add("Zarry"); 
        instance.deleteByValue("Zarry");
        assertEquals("[Jerry,Terry,Barry,Marry,Larry]", instance.toString());
    }

    /**
     * Test of getSize method, of class LinkedListArrayOfStrings.
     
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        LinkedListArrayOfStrings instance = new LinkedListArrayOfStrings();
        int expResult = 0;
        int result = instance.getSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
    /**
     * Test of toString method, of class LinkedListArrayOfStrings.
     
    @Test
    public void testToString() {
        System.out.println("toString");
        LinkedListArrayOfStrings instance = new LinkedListArrayOfStrings();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
     */
    
    /**
     * Test of toArray method, of class LinkedListArrayOfStrings.
     */
    
    // ** STEP 4 **
    @Test
    public void testAddToStringToArray() {
        System.out.println("add toString toArray");
        LinkedListArrayOfStrings instance = new LinkedListArrayOfStrings();
        instance.add("Jerry");
        instance.add("Terry");
        instance.add("Barry");
        instance.add("Larry");
        instance.add("Marry");
        assertEquals(5, instance.getSize());    // testGetSize()
        assertEquals("[Jerry,Terry,Barry,Larry,Marry]", instance.toString());   // testToString()
        
        String[] expResult = {"Jerry", "Terry", "Barry", "Larry", "Marry"}; // expectedArray
        String[] result = instance.toArray();
        assertArrayEquals(expResult, result);   // testToArray()
    }
    
}
