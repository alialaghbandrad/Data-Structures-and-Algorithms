package day01arraysali;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author alagh
 */
public class Day01ArraysAli {

    static Scanner input = new Scanner(System.in);
    
    static boolean isPrime(int num) {
        if (num == 1) return false; // by definition, 1 is not a prime number
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
       System.out.println("How big do you want the array to be?");  
       int size = 0;
       try {
           size = input.nextInt();
           if (size < 1) {
               throw new InputMismatchException();
           }
       } catch (InputMismatchException ex) {
           System.out.println("Error: size must be a number 1 or greater");
           System.exit(1);
       }
       // put random numbers into the array
       int[] data = new int[size];
       for (int i = 0; i < data.length; i++) {
           int val = (int) (Math.random() * 100 + 1);
           data[i] = val;
       }
       // display
       for (int i = 0; i < data.length; i++) {
           System.out.printf("%s%d", i == 0 ? "" : ", ", data[i]);
       }
       System.out.println();
       // 
       System.out.print("Prime numbers: ");
       boolean anyPrimeFound = false;
       for (int i = 0; i < data.length; i++) {
           int val = data[i];
           if (isPrime(val)) {
               System.out.printf("%s%d", !anyPrimeFound ? "" : ", ", val);
               anyPrimeFound = true;
           }
       }
       System.out.println();
       
      /* alternative
        try {
            size = input.nextInt();
        } catch (InputMismatchException ex) {
            size = -1;
        }
        if (size < 1) {
            System.out.println("Error: size must be a number 1 or greater");
            System.exit(1);
        } */
    }
    
}
