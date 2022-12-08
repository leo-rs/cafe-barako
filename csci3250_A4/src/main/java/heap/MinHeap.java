/*  Jan Leo Ras
 *   CSCI 3250-05 Fall 2021
 *   Dr. Samadidana
 *   Assignment 4 - Min Heap
 */
package heap;

import java.util.Vector;

public class MinHeap {

    private Vector<Integer> mVector;
    long calls;

    public MinHeap() {
        mVector = new Vector<>();
    }

    //return this node's parent's index
    public int parent(int nodeIndex) {
        if ((nodeIndex - 1) / 2 <= 0) {
            return 0;
        } else {
            return (nodeIndex - 1) / 2;
        }
    }

    //return this node's left child's index
    public int leftChild(int nodeIndex) {
        return (2 * nodeIndex) + 1;
    }

    //return this node's right child's index
    public int rightChild(int nodeIndex) {
        return (2 * nodeIndex) + 2;
    }

    //return true if this node does not have a left child
    public boolean isLeaf(int nodeIndex) {
        return leftChild(nodeIndex) > mVector.size() - 1;
    }

    //returns index of the last non-leaf node
    //based on the formula n-1/2, where n is the index of the last element
    public int lastNonLeafNode() {
        return (mVector.size() - 2) / 2;
    }

    //compare the value of elements at firstIndex and secondIndex
    //return the index of the smaller element
    public int findMinimum(int firstIndex, int secondIndex) {
        if (secondIndex > this.getSize() - 1) {
            return firstIndex;
        } else {
            int result = mVector.get(firstIndex) - mVector.get(secondIndex);
            if (result <= 0) {
                return firstIndex;
            } else {
                return secondIndex;
            }
        }
    }

    //insert values at the end and compare to parents as the array is built
    public void insert(int value) {
        mVector.add(value);
        int curr = this.getSize() - 1; //current element = index of last element

        //while current node is not the root node and the inserted value is less than the parent's
        //swap values with parent
        while (value < mVector.get(parent(curr))) {
            swap(curr, parent(curr));
            curr = parent(curr);
        }
    }

    //heapifies one subtree
    //recursively called to the smallest child
    private int heapifyNode(int nodeIndex) {
        calls++;
        int minElementIndex = nodeIndex;

        //if this node is a leaf, return the index of its parent
        if (isLeaf(nodeIndex)) {
            return parent(nodeIndex);
        } //else, compare this node's value to its children
        else {
            //if a LEFT child exists, do a comparison
            if (leftChild(nodeIndex) < this.getSize()) {
                minElementIndex = findMinimum(nodeIndex, leftChild(nodeIndex));
            }
            //if a RIGHT child exists, do a comparison
            if (rightChild(nodeIndex) < this.getSize() && mVector.get(minElementIndex) > mVector.get(rightChild(nodeIndex))) {
                minElementIndex = rightChild(nodeIndex);
            }
            //swap elements if the minimum element isn't the parent node
            //heapify the child node
            if (nodeIndex != minElementIndex) {
                swap(nodeIndex, minElementIndex);
                heapifyNode(minElementIndex);
            }
        }
        return nodeIndex;
    }

    //rebuilds an array into a heap
    public void buildHeap() {
        for (int i = lastNonLeafNode(); i >= 0; i--) {
            heapifyNode(i);
        }
        System.out.println("Heap size = " + this.getSize());
    }

    //adds elements into the vector
    public void addToVector(int value) {
        mVector.add(value);
    }

    //swaps the elements of two nodes
    private void swap(int firstNodeIndex, int secondNodeIndex) {
        int data1 = mVector.elementAt(firstNodeIndex);
        int data2 = mVector.elementAt(secondNodeIndex);

        mVector.setElementAt(data2, firstNodeIndex);
        mVector.setElementAt(data1, secondNodeIndex);
    }

    //remove root and replace with last leaf, then 
    //compare this node to its children, swap until heap is rebuilt
    public int remove() {
        int rootElement = this.peek();
        this.swap(0, mVector.size() - 1);
        mVector.removeElementAt(this.getSize() - 1);

        heapifyNode(0);
        return rootElement;
    }

    //returns true if the heap has no elements
    public boolean isEmpty() {
        return mVector.isEmpty();
    }

    //returns the value of the root
    public int peek() {
        return mVector.firstElement();
    }

    //method size() returns number of elements currently in vector
    public int getSize() {
        return mVector.size();
    }

    @Override
    public String toString() {
        String m = "\nHeapify calls = " + calls;
        return m;
    }
}
