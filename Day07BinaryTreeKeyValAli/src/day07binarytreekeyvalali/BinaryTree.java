package day07binarytreekeyvalali;

import java.lang.reflect.Array;

/* @author alagh */
public class BinaryTree<K extends Comparable,V> {
    // STEP 0: Given class
    private class Node {
	public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        K key;
        V value;
        Node left, right;
    }

    class Pair {
	K key;
	V value;
    }

    private Node root;
    private int nodesCount;
	
    // STEP 1: create PUT
    // if put attempts to put a key that already exists then value is updated (no exception is thrown)
    // values may be duplicates but keys may not
    void put(K key, V value) { 
         if (root == null) {
            root = new Node(key, value);
            nodesCount++;
            return;
        }
        Node currNode = root;
        while (true) {
            if (currNode.key.equals(key)) { // key exists, replace the value
                currNode.value = value;
                return;
            }
            if (key.compareTo(currNode.key) < 0) { // go left
                if (currNode.left == null) { // found the spot, put it here
                    currNode.left = new Node(key, value);
                    nodesCount++;
                    return;
                } else { // follow to the left
                    currNode = currNode.left;
                    // the loop will continue to another iteration
                }
            } else { // go right
                if (currNode.right == null) { // found the spot, put it here
                    currNode.right = new Node(key, value);
                    nodesCount++;
                    return;
                } else { // follow to the right
                    currNode = currNode.right;
                    // the loop will continue to another iteration
                }
            }
        }
    }
    
    
    // STEP 4: Part C
    // implement method that fetched value by key
    public V getValByKey(K key) throws RuntimeException {
        Node currNode = root;
        while (true) {
            if (currNode == null) {
                throw new RuntimeException("Key not found");
            }
            if (currNode.key.equals(key)) { // key found, return value
                return currNode.value;
            }
            if (key.compareTo(currNode.key) < 0) { // go left
                    currNode = currNode.left;
            } else { // go right
                    currNode = currNode.right;
            }
        }
    }
    
    // STEP 2.1: Print all key-value pairs from small to large
    // print out all key-value pairs (one per line) from the smallest key to the largest
    void printAllKeyValPairs() { 
         printNodeAndAllBelow(root);    
    }
    
    // STEP 2.2: Helper method
    private void printNodeAndAllBelow(Node node) {
        if (node == null) {
            return; // recursion must end
        }
        printNodeAndAllBelow(node.left);
        System.out.printf("%s => %s\n", node.key, node.value);
        printNodeAndAllBelow(node.right);
    }
    
    // STEP 3.1: 
    // return all keys from smallest to largest (alphabetically)
    K[] getKeysInOrder() { // (Node nodeTemplate) {
        resultKeysArray = (K[]) Array.newInstance(root.key.getClass(), nodesCount); // BUG: throws NullPointerException on empty tree
        // resultKeysArray = (K[]) Array.newInstance(nodeTemplate.key.getClass(), nodesCount);
        // resultKeysArray = (K[]) new Comparable[nodesCount];
        resultKeysIndex = 0;
        collectKeysInOrder(root);
        return resultKeysArray; 
    }
    
    // STEP 3.2: Helper method    
    // private helper recursive method to implement the above method
    private void collectKeysInOrder(Node node) {
        // recursion must end at some point
        if (node == null) {
            return;
        }
        // handle recursion
        collectKeysInOrder(node.left);
        resultKeysArray[resultKeysIndex++] = node.key;
        collectKeysInOrder(node.right);
    }

    private K[] resultKeysArray;
    private int resultKeysIndex;

    /*
    // return pairs of key-value in order of keys
    Pair[] getKeyValuePairsInOrder() {
    } */
}
