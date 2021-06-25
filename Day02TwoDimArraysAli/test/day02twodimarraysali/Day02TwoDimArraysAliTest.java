/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day02twodimarraysali;

import java.util.ArrayList;
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
public class Day02TwoDimArraysAliTest {
    
    /**
     * Test of isPrime method, of class Day02TwoDimArraysAli.
     */
    @Test
    public void testIsPrime() {
        System.out.println("isPrime");
        int num = 0;
        boolean expResult = false;
        boolean result = Day02TwoDimArraysAli.isPrime(num);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sumOfAll method, of class Day02TwoDimArraysAli.
     */
    @Test
    public void testSumOfAll() {
        System.out.println("sumOfAll");
        int[][] data = { { -99,   2,  22},  { 15, -71,   5} };
        int expResult = -126;
        int result = Day02TwoDimArraysAli.sumOfAll(data);
        assertEquals(expResult, result);
    }

    /**
     * Test of sumOfEachRow method, of class Day02TwoDimArraysAli.
     */
    @Test
    public void testSumOfEachRow() {
        System.out.println("sumOfEachRow");
        int[][] data = { { -99,   2,  22},  { 15, -71,   5} };
        int[] expResult = { -75, -51 };
        int[] result = Day02TwoDimArraysAli.sumOfEachRow(data);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of sumOfEachColumn method, of class Day02TwoDimArraysAli.
     */
    @Test
    public void testSumOfEachColumn() {
        System.out.println("sumOfEachColumn");
        int[][] data = { { -99,   2,  22},  { 15, -71,   5} };
        int[] expResult = { -84, -69,  27};
        int[] result = Day02TwoDimArraysAli.sumOfEachColumn(data);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of computeStdDev method, of class Day02TwoDimArraysAli.
     */
    @Test
    public void testComputeStdDev() {
        System.out.println("computeStdDev");
        int[][] data = { { -99,   2,  22},  { 15, -71,   5} };
        double expResult = 46.4219;
        double result = Day02TwoDimArraysAli.computeStdDev(data);
        assertEquals(expResult, result, 0.0001);
    }


    /**
     * Test of getPrimeNumberPairs method, of class Day02TwoDimArraysAli.
     */
    @Test
    public void testGetPrimeNumberPairs() {
        System.out.println("getPrimeNumberPairs");
        int[][] data = { { -99,   2,  22},  { 15, -71,   5}, { -33, -5, -7 } };
        String expResult = "[[([0,1:2],[1,0:15]), ([0,1:2],[1,2:5]), ([0,2:22],[1,0:15]), ([0,2:22],[2,1:-5])]]";
        ArrayList<Pair> result = Day02TwoDimArraysAli.getPrimeNumberPairs(data);
        assertEquals(expResult, result.toString());
    }
}
