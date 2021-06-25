/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day07binarytreekeyvalali;

/**
 *
 * @author alagh
 */
public class Day07BinaryTreeKeyValAli {
    
    private static String arrayToString(String [] data) {
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
        BinaryTreeStringInt tree = new BinaryTreeStringInt();
        tree.put("Jerry", 33);
        tree.put("Eva", 22);
        tree.put("Adam", 11);
        tree.put("Maria", 43);
        tree.put("Terry", 3);
        tree.put("Peter", 67);
        tree.printAllKeyValPairs();
        System.out.println("Keys in order: " + arrayToString(tree.getKeysInOrder()));
        System.out.println("get of Eva: " + tree.getValByKey("Eva"));
        // System.out.println("get of Eva2: " + tree.getValByKey("Eva2")); // not found
        
        System.out.println("generic");
        BinaryTree<String, Double> treeGen = new BinaryTree<>();
        treeGen.put("Jerry", 1.82);
        treeGen.put("Berry", 1.72);
        treeGen.put("Lerry", 1.62);
        treeGen.put("Merry", 1.52);
        treeGen.put("Cerry", 1.92);
        treeGen.put("Kerry", 1.88);
        treeGen.printAllKeyValPairs();
        System.out.println("Keys in order: " + arrayToString(treeGen.getKeysInOrder()));
    }
    
}
