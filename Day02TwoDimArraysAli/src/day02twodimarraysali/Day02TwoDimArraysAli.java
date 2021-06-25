/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day02twodimarraysali;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class ValAtRowCol {

    public ValAtRowCol(int val, int row, int col) {
        this.val = val;
        this.row = row;
        this.col = col;
    }
    
    int val, row, col;
        
    @Override
    public String toString() {
        return String.format("[%d,%d:%d]", row, col, val);
    }
        
}
    
class Pair {
        
    public Pair(ValAtRowCol a, ValAtRowCol b) {
        this.a = a;
        this.b = b;
    }
        
    ValAtRowCol a, b;
    
    @Override
    public String toString() {
        return String.format("(%s,%s)", a, b);
    }
    
    @Override
    public boolean equals(Object o) {
        Pair other = (Pair) o;
        if (this.a.val == other.a.val && this.b.val == other.b.val) {
            return (this.a.col == other.a.col && this.a.row == other.a.row &&
                    this.b.col == other.b.col && this.b.row == other.b.row);
        }
        if (this.a.val == other.b.val && this.b.val == other.a.val) {
            return (this.a.col == other.b.col && this.a.row == other.b.row &&
                    this.b.col == other.a.col && this.b.row == other.a.row);
        }
        return false;
    }
    
}

public class Day02TwoDimArraysAli {
    
    static boolean isPrime(int num) {
        // by definition, 1 is not a prime number, 0 and negatives are not prime numbers either
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    // 1) Sum of all numbers in the array
    static int sumOfAll(int [][] data) {
        int sum = 0;
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                sum += data[row][col];
            }
        }
        return sum;
    }
    // 2) Sum of each of the row of the array
    static int [] sumOfEachRow(int [][] data) {
        // one result entry per rowA
        int [] rowSums = new int[data.length];
        for (int row = 0; row < data.length; row++) {
            int sum = 0;
            for (int col =0; col < data[row].length; col++) {
                sum += data[row][col];
            }
            rowSums[row] = sum;
        }
        return rowSums;
    }
    
    // 3) Sum of each of the column of the array
    static int [] sumOfEachColumn(int[][] data) {
        // one result entry per rowA
        int [] colSums = new int[data[0].length];
        for (int col = 0; col < data[0].length; col++) {
            int sum = 0;
            for (int row = 0; row < data.length; row++) {
                sum += data[row][col];
            }
            colSums[col] = sum;
        }
        return colSums;
    }
    
    static double computeStdDev(int [][] data) {
        // NOTE: this only works for rectangular arrays
        int valCount = (data.length * data[0].length);
        double avg = (double) sumOfAll(data) / valCount;
        int sumOfSquareDiff = 0;
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                int val = data[row][col];
                sumOfSquareDiff += (val - avg) * (val - avg);
            }
        }
        double stdDev = Math.sqrt(sumOfSquareDiff / valCount);
        return stdDev;
    }
    
    
    
    static void printPrimeNumberPairs(int [][] data) {
        // marker A
        for (int rowA = 0; rowA < data.length; rowA++) {
            for (int colA = 0; colA < data[rowA].length; colA++) {
                // marker B - starts at RowA, after the cell pointed to by marker
                for (int rowB = rowA; rowB < data.length; rowB++) {
                    int startColB = (rowA == rowB) ? colA + 1 : 0;
                    for (int colB = startColB; colB < data[rowB].length; colB++) {
                        // is the sum a prime number?
                        int sum = data[rowA][colA] + data[rowB][colB];
                        if (isPrime(sum)) {
                            System.out.printf("Prime sum %d at [%d][%d] val %d and [%d][%d] val %d\n",
                                    sum, rowA, colA, data[rowA][colA], rowB, colB, data[rowB][colB]);
                        }
                    }
                }
            }
        }
    }
    
    
    
    static ArrayList<Pair> getPrimeNumberPairs(int [][] data) {
        ArrayList<Pair> resultPairs = new ArrayList<>();
         // marker A
        for (int rowA = 0; rowA < data.length; rowA++) {
            for (int colA = 0; colA < data[rowA].length; colA++) {
                // marker B - starts at RowA, after the cell pointed to by marker
                for (int rowB = rowA; rowB < data.length; rowB++) {
                    int startColB = (rowA == rowB) ? colA + 1 : 0;
                    for (int colB = startColB; colB < data[rowB].length; colB++) {
                        // is the sum a prime number?
                        int sum = data[rowA][colA] + data[rowB][colB];
                        if (isPrime(sum)) {
                            ValAtRowCol a = new ValAtRowCol(data[rowA][colA], rowA, colA);
                            ValAtRowCol b = new ValAtRowCol(data[rowB][colB], rowB, colB);
                            Pair pair = new Pair(a,b);
                            resultPairs.add(pair);
                        }
                    }
                }
            }
        }
        return resultPairs;
    }

    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        // Ask user for size of the array to create, it must be 1 or greater.
        int width = 0, height = 0;
        try {
            System.out.print("Array height? ");
            height = input.nextInt();
            System.out.print("Array width? ");
            width = input.nextInt();
            
            // Show an error and end program if it's invalid.
            // Also do not allow the program to crash if the entered value is not numerical.
            // In such case also show an error and end program.
            if (width < 1 || height < 1) {
                throw new InputMismatchException();
            }
        } catch (InputMismatchException ex) {
            System.out.println("Error: size must be a number 1 or greater");
            System.exit(1);
        }
        
        // put random numbers into the array
        int[][] dataArray = new int[height][width];
        for (int row = 0; row < dataArray.length; row++) {
            for (int col = 0; col <dataArray[row].length; col++) {
                dataArray[row][col] = (int)(Math.random()*199 - 99);
            }
        }
        
        // display array in user-friendly manner
        for (int row = 0; row < dataArray.length; row++) {
            for (int col = 0; col < dataArray[row].length; col++) {
                int val = dataArray[row][col];
                System.out.printf("%s%d", col == 0 ? "" : ", ", val);
            }
            System.out.println();
        }
        // print Sum of all numbers in the array
        int sum = sumOfAll(dataArray);
        System.out.println("Sum of all items: " + sum);
        // print Sum of each of the row of the array
        int [] sumRows = sumOfEachRow(dataArray);
        System.out.println("Sum of rows: ");
        for (int row = 0; row < sumRows.length; row++) {
            System.out.printf("Row #%d has sum %d\n", row, sumRows[row]);
        }
        // print Sum of each of the column of the array
        int [] sumCols = sumOfEachColumn(dataArray);
        System.out.println("Sums of cols: ");
        for (int row = 0; row < sumCols.length; row++) {
            System.out.printf("Col #%d has sum %d\n", row, sumCols[row]);
        }
        // Standard deviation
        System.out.printf("Standard deviation is: %.3f\n", computeStdDev(dataArray));
        // TODO: use getPrimeNumberPairs() and display the result
        
        System.out.println("=== Pairs using list of...");
        ArrayList<Pair> pairs = getPrimeNumberPairs(dataArray);
        for (Pair p : pairs) {
            System.out.printf("Prime sum %d at [%d][%d] val %d and [%d][%d] val %d\n",
                    p.a.val + p.b.val,
                    p.a.row, p.a.col, p.a.val,
                    p.b.row, p.b.col, p.b.val);
        }

    }
    
}
