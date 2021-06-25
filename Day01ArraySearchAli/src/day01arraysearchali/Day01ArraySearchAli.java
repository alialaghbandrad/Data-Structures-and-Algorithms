/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day01arraysearchali;

/**
 *
 * @author alagh
 */
public class Day01ArraySearchAli {

    static int getIfExists(int[][] data, int row, int col) {
	     // If exists, return the element, otherwise return 0
             if (data.length <= row || row < 0) {
                 return 0;
             }
             if (data[row].length <= col || col < 0) {
                 return 0;
             }
             return data[row][col];
    }

    static int sumOfCross(int[][] data, int row, int col) {
	    // return sum of the element at row/col
        // plus (if they exist) element above, below, to the left and right of it
        return getIfExists(data, row, col)
                + getIfExists(data, row, col - 1) + getIfExists(data, row, col + 1)
                + getIfExists(data, row - 1, col) + getIfExists(data, row + 1, col);
    }
    
    // later: static void print2D(int[][] data) { ... }
    static void print2D(int[][] data) {
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                int val = data[row][col];
                System.out.printf("%s%2d", col == 0 ? "" : ", ", val);
            }
            System.out.println();
        }
    }
    
    // find and print out the element with the lowest cross value
    static void findLowestCrossValue(int[][] data) {
        int minCrossVal = sumOfCross(data, 0, 0);
        int minCrossRow = 0, minCrossCol = 0;
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                int sum = sumOfCross(data, row, col);
                // System.out.printf("Debug: Cross value is %d at [%d, %d]\n", sum, row, col);
                if (sum < minCrossVal) {
                    minCrossVal = sum;
                    minCrossRow = row;
                    minCrossCol = col;
                }
            }
        }
        System.out.printf("Minimum cross value is %d at [%d, %d]\n", minCrossVal, minCrossRow, minCrossCol);
    }
    
    // static int[][] duplicateArray2D(int[][] orig2d) {   }
    
    static int [][] createSumOfCrossArray(int[][] data) {
        // this only works for rectangular arrays
        int[][]result =  new int[data.length][data[0].length];
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                int sum = sumOfCross(data, row, col);
                result[row][col] = sum;
            }
        }
        return result;
    }
	
	
    // later: static int[][] duplicateArray2D(int[][] orig2d) { ... }
    public static void main(String[] args) {
        int[][] data2D = {
            {1, 3, 6, 8},
            {7, 1, 2, 3},
            {8, 3, 2, 1},
            {1, 7, 1, 9},};
        System.out.println("====== ORIGINAL");
        print2D(data2D);
        findLowestCrossValue(data2D);
        System.out.println("====== SUM OF CROSS VALUES");
        int [][]sum2D = createSumOfCrossArray(data2D);
        print2D(sum2D);
    }
    
}
