/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day07binarytreeali;

/**
 *
 * @author alagh
 */
public class Day07BinaryTreeAli {
    
    private static String arrayToString(int [] data) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < data.length; i++) {
            sb.append(i == 0 ? "": ",");
            sb.append(data[i]);
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinaryTreeOfInts tree = new BinaryTreeOfInts();
        tree.put(5);
        tree.put(2);
        tree.put(3);
        tree.put(7);
        tree.put(9);
        tree.put(4);
        System.out.println("Sum of all values: " + tree.getSumOfAllValues());
        System.out.println("Values in order: " + arrayToString(tree.getValuesInOrder()));
        /// tree.put(9); // duplicate, causes exception
        
        for (Integer val : tree) {
            System.out.println("Using iterator: " + val);
        }
    }
    
}
