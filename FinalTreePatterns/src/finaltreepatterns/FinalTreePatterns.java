/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finaltreepatterns;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* @author ali alaghbandrad */

public class FinalTreePatterns {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TreeStringIntSet tree=new TreeStringIntSet();
        try {
            tree.add("Larry", 66);
            tree.add("Jerry", 32);
            tree.add("Marry", 21);
            tree.add("Eva", 42);
            tree.add("Karry", 27);
            System.out.println("List of all Key-Value pairs: ");
            tree.printAllKeyValPairs();
            System.out.println(tree.containsKey("Eva"));
            System.out.println("Key containing value: " + tree.getKeysContainingValue(21));
            System.out.println("List of all keys: " + tree.getAllKeys());
            
        } catch (DuplicateValueException ex) {
            Logger.getLogger(FinalTreePatterns.class.getName()).log(Level.SEVERE, null, ex);
        }    
    } 
}
