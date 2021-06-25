
package exercisemyftreepatterns;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alagh
 */
public class ExerciseMyFTreePatterns {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TreeStringIntSet tree=new TreeStringIntSet();
        try {
            tree.add("dd", 20);
            tree.add("dd", 50);

            tree.add("ff", 40);
            tree.add("jj", 50);
            tree.add("ff", 50);
            System.out.println( tree.containsKey("dd"));
            List<String> list=new ArrayList<String>();
            list=tree.getKeysContainingValue(40);
            for(var v:list)
            {
                System.out.println("ff"+v);
            }
            list=tree.getAllKeys();
            for(var v:list)
            {
                System.out.println("travers"+v);
            }
            System.out.println(tree.toString());
            // System.out.println("by 50"+tree.getKeysByValuetoString(50)+"       end");
        } catch (DuplicateValueException ex) {
            Logger.getLogger(ExerciseMyFTreePatterns.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    }
    
