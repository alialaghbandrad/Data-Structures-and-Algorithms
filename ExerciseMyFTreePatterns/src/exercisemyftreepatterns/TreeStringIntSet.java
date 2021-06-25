
package exercisemyftreepatterns;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author alagh
 */

class DuplicateValueException extends Exception {
}

public class TreeStringIntSet implements Iterable<TreeStringIntSet.Pair> {
    
    
    protected class Pair<String,Integer> {

        public Pair(String key, Integer value) {
            this.key = key;
            this.value = value;
        }

        
        String key;
        Integer value;
    }

    private class TreeStringIntSetIterator implements Iterator<TreeStringIntSet.Pair> {
        
        private Pair[] arrayOfPairs;
        private int currIndex;

        public TreeStringIntSetIterator() {
            this.arrayOfPairs = getValuesInOrder();
        }

        @Override
        public boolean hasNext() {
            return currIndex < arrayOfPairs.length;
        }

        @Override
        public Pair<String, Integer> next() {
            return arrayOfPairs[currIndex++];
        }
    }

    @Override
    public Iterator<Pair> iterator() {
        return new TreeStringIntSetIterator();
    }
    
    class Node {
        
        String key; // keys are unique
        // HashSet is like ArrayList except it does not hold duplicates
        HashSet<Integer> valuesSet = new HashSet<>(); // unique only
        
        Node(){
            this.key = "";
            this.valuesSet = new HashSet<>();
        }
        
        Node left, right;
    }

    private Node root;
    private int nodesCount;
    
    // throws DuplicateValueException if this key already contains such value
    void add(String key, int value) throws DuplicateValueException {
        //Tree is empty
        if (root == null) {
            root = new Node();
            root.key = key;
            root.valuesSet.add(value);
            nodesCount++;
            return;
        }

        //find a parent for new node
        var current = root;
        while (true) {
            if (current.key.equals(key)) {
                for (int v : current.valuesSet) {
                    if (v == value) {
                        throw new DuplicateValueException();
                    } else {
                        current.valuesSet.add(value);
                        return;
                    }
                }

            }
            if (key.compareTo(current.key) < 0) { //go left
                if (current.left == null) {
                    current.left = new Node();
                    current.left.key = key;
                    current.left.valuesSet.add(value);
                    return;
                } else {
                    current = current.left;
                }
            } else {
                if (current.right == null) {
                    current.right = new Node();
                    current.right.key = key;
                    current.right.valuesSet.add(value);
                    nodesCount++;
                    return;
                } else {
                    current = current.right;

                }
            }
        }
    }
    
    private Pair[] arrayOfPairs;
    private int resultIndex;
    private List<Integer> valueList;
    
    private Pair[] getValuesInOrder() {
        arrayOfPairs = new Pair[nodesCount];
        resultIndex = 0;
        collectValuesInOrder(root);  // execute the recursive method to refresh array with value
        return arrayOfPairs;
    }
    
    private void collectValuesInOrder(Node node) {
        if(node == null) return;
        collectValuesInOrder(node.right);
        for(int value : node.valuesSet){
            arrayOfPairs[resultIndex++] = new Pair(node.key, value);
        }
        collectValuesInOrder(node.left);
    }
    
    public boolean containsKey(String key) {
        return getAllKeys().contains(key);
    }

    public List<Integer> getValuesByKey(String key) {
        valueList = new ArrayList<Integer>();
        getValuesByKey(root, key);
        return valueList;
    } // return empty list if key not found
    
    private void getValuesByKey(Node node, String key) {
        if(node == null) return;
        getValuesByKey(node.right, key);
        if(node.key.equals(key)){
            valueList = new ArrayList<Integer>(node.valuesSet);
        }
        getValuesByKey(node.left, key);
    }

    public List<String> getKeysContainingValue(int value) {
        List<String> keyList = new ArrayList<String>();
        for(int i=0; i< getValuesInOrder().length; i++){
            if(arrayOfPairs[i].value.equals(value)){
                keyList.add(arrayOfPairs[i].key.toString());
            }
        }
        return keyList;
    }

    public List<String> getAllKeys() {
    
        List<String> keyList = new ArrayList<String>();
        for(int i=0; i< getValuesInOrder().length; i++){
            if(!keyList.contains(arrayOfPairs[i].key.toString())){
                keyList.add(arrayOfPairs[i].key.toString());
            }
        }
        return keyList;
    }
    
    @Override
    public String toString() {
        List<String> allKeys = new ArrayList<String>();
        allKeys = getAllKeys();
        StringBuilder str = new StringBuilder();
        for (int i=0;i<allKeys.size();i++) {
            str.append(i==0?"":",");
            str.append(allKeys.get(i));
        }
        return str.toString();
    }
    
}
