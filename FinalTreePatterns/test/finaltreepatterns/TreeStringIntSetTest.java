/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finaltreepatterns;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/* @author ali alaghbandrad */

public class TreeStringIntSetTest {
    
    public TreeStringIntSetTest() {
    }

    /* Test of add method, of class TreeStringIntSet. */
    @Test
    public void testAdd() throws DuplicateValueException {
        System.out.println("Add");
        TreeStringIntSet tree = new TreeStringIntSet();
        tree.add("Larry", 66);
        tree.add("Jerry", 32);
        tree.add("Marry", 21);
        tree.add("Eva", 42);
        tree.add("Karry", 27);
        // if it does not throw an exception we'll assume the test is passed
    }

    /* Test of containsKey method, of class TreeStringIntSet. */
    @Test
    public void testContainsKey() throws DuplicateValueException {
        System.out.println("ContainsKey");
        TreeStringIntSet tree = new TreeStringIntSet();
        tree.add("Larry", 66);
        tree.add("Jerry", 32);
        tree.add("Marry", 21);
        assertTrue(tree.containsKey("Larry"));
        assertTrue(tree.containsKey("Jerry"));
        assertTrue(tree.containsKey("Marry"));
        assertFalse(tree.containsKey("Adam"));
    }

    /* Test of getValuesOfKey method, of class TreeStringIntSet. */
    @Test
    public void testGetValuesOfKey() throws DuplicateValueException  {
        System.out.println("GetValuesOfKey");
        TreeStringIntSet tree = new TreeStringIntSet();
        tree.add("Larry", 66);
        tree.add("Jerry", 32);
        tree.add("Marry", 21);
        assertArrayEquals(new int[]{32}, tree.getValuesOfKey("Jerry").stream().mapToInt(Integer::intValue).toArray());
    }

    /* Test of getKeysContainingValue method, of class TreeStringIntSet. */
    @Test
    public void testGetKeysContainingValue() throws DuplicateValueException {
        System.out.println("getKeysContainingValue");
        TreeStringIntSet tree = new TreeStringIntSet();
        tree.add("Larry", 66);
        tree.add("Jerry", 32);
        tree.add("Marry", 21);
        assertArrayEquals(new String[]{"Larry"}, tree.getKeysContainingValue(66).toArray());
    }

    /* Test of getAllKeys method, of class TreeStringIntSet. */
    @Test
    public void testGetAllKeys() throws DuplicateValueException {
        System.out.println("GetAllKeys");
        TreeStringIntSet tree = new TreeStringIntSet();
        tree.add("Larry", 66);
        tree.add("Jerry", 32);
        tree.add("Marry", 21);
        List<String> expectedList = new ArrayList();
        expectedList.add("Jerry");
        expectedList.add("Larry");
        expectedList.add("Marry");
        assertEquals(tree.getAllKeys(), expectedList);
    }

    /**
     * Test of iterator method, of class TreeStringIntSet.
     */
    /*
    @Test
    public void testIterator() throws DuplicateValueException {
        System.out.println("iterator");
        TreeStringIntSet tree = new TreeStringIntSet();
        tree.add("Larry", 66);
        tree.add("Jerry", 32);
        tree.add("Marry", 21);
        tree.add("Eva", 42);
        tree.add("Karry", 27);
        for (Pair<String,Integer> pair : tree) );
    }
    */
    
}
