package day07binarytreeali;

import java.util.Iterator;

/* @author alagh */
public class BinaryTreeOfInts implements Iterable<Integer> {

    // STEP 4.2
    class SimplisticBinaryTreeIterator implements Iterator<Integer> {

        private int[] valuesInOrder;
        private int currIndex;

        public SimplisticBinaryTreeIterator(int[]valuesInOrder) {
            this.valuesInOrder = valuesInOrder;
        }
        
        @Override
        public boolean hasNext() {
            return currIndex < valuesInOrder.length;
        }

        @Override
        public Integer next() {
            return valuesInOrder[currIndex++];
        }
        
    }
    
    // STEP 4.1: Iterator
    @Override
    public Iterator<Integer> iterator() {
        return new SimplisticBinaryTreeIterator(getValuesInOrder());
    }
    
    // STEP 0: Given class
    private class NodeOfInt {
        int value; // could also be key,value pair
        NodeOfInt left, right;
    }
    
    private NodeOfInt root;
    private int nodesCount;
    
    // STEP 1: Create PUT
    // throws exception if put attempts to insert value that already exists (a duplicate)
    void put(int value) throws IllegalArgumentException { 
        NodeOfInt newNode = new NodeOfInt();
        newNode.value = value;
        if (root == null) {
            root = newNode;
            nodesCount++;
            return;
        }
        NodeOfInt currNode = root;
        while (true) {
            if (currNode.value == value) {
                throw new IllegalArgumentException("Duplicates are not allowed");
            }
            if (value < currNode.value) { // go left
                if (currNode.left == null) {
                    // found the spot - put it here
                    currNode.left = newNode;
                    nodesCount++;
                    return;
                } else { // follow to the left on the next iteration
                    currNode = currNode.left;
                }
            } else { // go right
                if (currNode.right == null) {
                    // found the spot - put it here
                    currNode.right = newNode;
                    nodesCount++;
                    return;
                } else { // follow to the right on the next iteration
                    currNode = currNode.right;
                }
            }
            // the loop will continue to the next iteration
        }  
    }
    
    // STEP 2.1: Create sum of all values in tree
    // uses compute the sum of all values in the entire tree using the recursive method below
    public int getSumOfAllValues() { 
        return getSumOfThisAndNodesBelow(root);
    }
    
    // STEP 2.2: private helper recursive method to implement the above method
    // recursive method
    private int getSumOfThisAndNodesBelow(NodeOfInt node) {
        // recursion must end at some point
        if (node == null) {
            return 0;
        }
        // sum of values
        int result = node.value;
        result += getSumOfThisAndNodesBelow(node.left);
        result += getSumOfThisAndNodesBelow(node.right);
        return result;
    }
    
    // STEP 3.1:
    // uses recursion to collect all values from largest to smallest
    int [] getValuesInOrder() { // from largest to smallest
        resultArray = new int[nodesCount];
        resultIndex = 0;
        collectValuesInOrder(root);
        return resultArray;
		
    }
    
    // STEP 3.2:
    // private helper recursive method to implement the above method
    private void collectValuesInOrder(NodeOfInt node) {
        // recursion must end at some point
        if (node == null) {
            return;
        }
        // handle recursion
        collectValuesInOrder(node.right);   // right has larger values, then comes first
        resultArray[resultIndex++] = node.value;    // current value
        collectValuesInOrder(node.left);    // left has smaller values, then comes last
    }
    
    // data structures used to make collecting values in order easier
    private int[] resultArray;
    private int resultIndex;
    
    
}
