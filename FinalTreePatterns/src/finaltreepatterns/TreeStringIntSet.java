package finaltreepatterns;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* @author ali alaghbandrad */

class DuplicateValueException extends Exception {
    public DuplicateValueException(String errorMessage) {   
        super(errorMessage);
    }
}

public class TreeStringIntSet implements Iterable<Pair<String,Integer>> {


    private class Node {
		Node left, right;
		String key; // ListOfKeys are unique
		// HashSet is like ArrayList except it does not hold duplicates
		HashSet<Integer> valuesSet = new HashSet<>(); // unique only
	}

    public class TreeIterator implements Iterator<Pair<String,Integer>> {
       List<String> list=new ArrayList<>();
        public TreeIterator() {
            list=getAllKeys();
        }

        @Override
        public boolean hasNext() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Pair next() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }   
   }
    
    @Override
    public Iterator<Pair<String, Integer>> iterator() {
        return new TreeIterator();
    }
    
    private Node root;
    private int nodesCount;
    private List<String> ListOfKeys;
    
    // throws DuplicateValueException if this key already contains such value
    public void add(String key, int value) throws DuplicateValueException {
        
        if (root == null) {
            root = new Node();
            root.key = key;
            root.valuesSet.add(value);
            nodesCount++;
            return;
        }

        Node currentNode = root;
        while (true) {
            if (currentNode.key.equals(key)) {
                for (int v : currentNode.valuesSet) {
                    if (v == value) {
                        throw new DuplicateValueException("Duplicate not acceptable");
                    } else {
                        currentNode.valuesSet.add(value);
                        return;
                    }
                }
            }
            if (key.compareTo(currentNode.key) < 0) { //go left
                if (currentNode.left == null) {
                    currentNode.left = new Node();
                    currentNode.left.key = key;
                    currentNode.left.valuesSet.add(value);
                    return;
                } else {
                    currentNode = currentNode.left;
                }
            } else {    // go right
                if (currentNode.right == null) {
                    currentNode.right = new Node();
                    currentNode.right.key = key;
                    currentNode.right.valuesSet.add(value);
                    nodesCount++;
                    return;
                } else {
                    currentNode = currentNode.right;

                }
            }
        }
    }
    
    public boolean containsKey(String key) {
        Node currentNode = root;
        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                return true;
            } else if (key.compareTo(currentNode.key) < 0) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }
        return false;
    }
    
    // return empty list if key not found
    // returns ListOfValues sorted
    public List<Integer> getValuesOfKey(String key) {
       List<Integer> ListOfValues = new ArrayList<>();
        var currentNode = root;
        while (currentNode != null) {
            if (key.compareTo(currentNode.key) < 0) {
                currentNode = currentNode.left;
            } else if (key.compareTo(currentNode.key) > 0) {
                currentNode = currentNode.right;
            } else {
                for (int v : currentNode.valuesSet) {
                    ListOfValues.add(v);
                }
                return ListOfValues;
            }
        }
        return ListOfValues;     
    }
    
    // use traversal of all nodes to collect ListOfKeys that have this value in valuesSet
    public List<String> getKeysContainingValue(int value) {
        ListOfKeys = new ArrayList<>();
        getKey(root, value);
        return ListOfKeys;
    }
    
    //  Recursive helper method to implement the above method
    private void getKey(Node node, int value) {
        if (node == null) {
            return;
        }
        getKey(node.left, value);
            getKey(node.right, value);
        for (int v : node.valuesSet) {
            if (v == value) {
                ListOfKeys.add(node.key);
            }
        }
    }
    
    // use traversal to collect all ListOfKeys
    public List<String> getAllKeys() {
        ListOfKeys = new ArrayList<String>();
        OrderedKeys(root);
        return ListOfKeys;
    }
    
    //  Recursive helper method to implement the above method
    private void OrderedKeys(Node node) {
        if (node == null) {
            return;
        }
        OrderedKeys(node.left);
        ListOfKeys.add(node.key);
        OrderedKeys(node.right);
    }
    
    // print out all key-value pairs (one per line) from the smallest key to the largest
    void printAllKeyValPairs() { 
         printNodeAndAllBelow(root);    
    }
    
    // Helper method
    private void printNodeAndAllBelow(Node node) {
        if (node == null) {
            return; // recursion must end
        }
        printNodeAndAllBelow(node.left);
        System.out.printf("%s => %s\n", node.key, node.valuesSet);
        printNodeAndAllBelow(node.right);
    }

}

class Pair<K,V> {
    K key;
    V value;
    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    @Override
    public String toString() {
        return String.format("(%s=>%s)", key.toString(), value.toString());
    }
}
