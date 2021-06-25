
package day07binarytreeali;

import java.util.Iterator;
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
public class BinaryTreeOfIntsTest {
    
    /* TEST 4 */
    @Test
    public void testIterator() {
        System.out.println("iterator");
        BinaryTreeOfInts tree = new BinaryTreeOfInts();
        tree.put(5);
        tree.put(2);
        tree.put(3);
        int [] expected = {5,3,2};
        int i = 0;
        for (Integer val : tree) {
            int v = val;
            assertEquals(expected[i++], v);
        }
        assertEquals(expected.length, i); // make sure the loop executed exactly 3 times
    }

    /* TEST 1: Test of put method, of class BinaryTreeOfInts. */
    @Test
    public void testManyPutsAlone() {
        System.out.println("testManyPutsAlone");
        BinaryTreeOfInts tree = new BinaryTreeOfInts();
        tree.put(5);
        tree.put(2);
        tree.put(3);
        tree.put(7);
        tree.put(9);
        tree.put(4);
        // if it does not throw an exception we'll assume the test is passed
    }

    /* TEST 2: Test of getSumOfAllValues method, of class BinaryTreeOfInts.*/
    @Test
    public void testGetSumOfAllValues() {
        System.out.println("getSumOfAllValues");
        BinaryTreeOfInts tree = new BinaryTreeOfInts();
        tree.put(5);
        tree.put(2);
        tree.put(3);
        assertEquals(10, tree.getSumOfAllValues());
        tree.put(7);
        tree.put(9);
        tree.put(4);
        assertEquals(30, tree.getSumOfAllValues());
    }

    /* TEST 3: Test of getValuesInOrder method, of class BinaryTreeOfInts.*/
    @Test
    public void testGetValuesInOrder() {
        System.out.println("getValuesInOrder");
        BinaryTreeOfInts tree = new BinaryTreeOfInts();
        tree.put(5);
        tree.put(2);
        tree.put(3);
        assertArrayEquals(new int [] {5,3,2}, tree.getValuesInOrder());
        tree.put(7);
        tree.put(9);
        tree.put(4);
        assertArrayEquals(new int [] {9,7,5,4,3,2}, tree.getValuesInOrder());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testPutDuplicateFails() {
        System.out.println("getValuesInOrder");
        BinaryTreeOfInts tree = new BinaryTreeOfInts();
        tree.put(5);
        tree.put(2);
        tree.put(3);
        tree.put(7);
        tree.put(9);
        tree.put(4);
        tree.put(7); // duplicate!
    }
    
}
