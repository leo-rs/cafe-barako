/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heap;

import java.util.Vector;

public class MinHeap2 {

    // Vector object to store elements
    private Vector<Integer> mv; 
    long callsToHeapify;
    long callsToSwap;
    
    // Constructor
    public MinHeap2(){
        mv = new Vector<>();
        callsToHeapify = 0;
        callsToSwap = 0;
        
    }
    
    public int parent(int index) {
        if ((index-1)/2<0)
            System.out.println("Root node reached.");
        return ((index-1)/2);
    }
    
    public int leftChild(int index) {
        return (2*index)+1;
    }
    
    public int rightChild(int index) {
        return (2*index)+2; 
    }
    
    // Good
    public boolean isLeaf(int index) {
        return leftChild(index)>mv.size()-1;
    }
    
    public int lastNonLeafNode() {
        return (mv.size()-2)/2;
    }
    
    // Good
    public int compareForMinimum (int firstIndex, int secondIndex) {
        if (secondIndex>mv.size()-1) {
            //System.out.println("No second value exists.");
            return firstIndex;
        } else {
            int result = mv.get(firstIndex) - mv.get(secondIndex);
                if (result<=0)
                    return firstIndex;
                else
                    return secondIndex;
            }
    }
    
    // heapify one subtree (ensures parent is smaller than children)
    // recursively called on the smallest child, starting at last non-leaf Node
    // runs in O(log n)
    //returns index of smallest child?
    private int heapifyNode(int index) {
        callsToHeapify++;
        int minElementIndex = index;
        
        if (isLeaf(index))
            return 0;
        else {
            //check that left child exists, and compare, remember minElement index
            if ((leftChild(index)<mv.size())) //Can I remove this? A non-leaf node has at least one child, will leftChild method throw an error?
                minElementIndex = compareForMinimum(index, leftChild(index));
            if ((rightChild(index)<mv.size() && mv.get(minElementIndex)>mv.get(rightChild(index)))) //check for right child, then compare with last minElement
                minElementIndex = rightChild(index);
            
            //if the minElement is a child, swap values with the child, then COMPARE UP (percolate method?)
            if (minElementIndex!=index) {
                
                swap(minElementIndex, index); //swapping values, minimum is now the current index(parent node)
                int currentIndex = index; //initialize variable for percolate UP
                
                while (mv.get(currentIndex)<mv.get(parent(currentIndex))) { //while currentElement is smaller, swap up
                    swap(currentIndex, parent(currentIndex));
                    currentIndex = parent(currentIndex); //new current index is the parent, keep comparing up
                }
                
                return heapifyNode(minElementIndex);
            }
            else return 0;
        
        }
    }
    
    private void swap(int first, int second) {
        int data1 = mv.elementAt(first);
        int data2 = mv.elementAt(second);
        
        mv.setElementAt(data2, first);
        mv.setElementAt(data1, second);
        
        
            callsToSwap++;
    }
    
    public void addToVector(int n) {
        mv.add(n);
    }
    
    public void buildHeap() {
        System.out.println("Heap size = " + mv.size());
        System.out.println("Last non-leaf index = " + lastNonLeafNode());
        for (int i = 0; i<lastNonLeafNode(); i++)
            this.heapifyNode(i);
    }
    
    
    // Inserts, always maintaining a heap
    // runs in O(log n)
    public void insert(int value) {  
        mv.add(value);
        int curr = mv.size()-1;
        
        //traverse heap towards the root;
        while (value<mv.get(parent(curr))) {
            //System.out.println("Swapping minimum values... ");
            swap(curr, parent(curr));
            curr = parent(curr);
            
            callsToSwap++;
        }
        //System.out.println(mv.toString());
    }
    

    // Removes the top element, replaces root with last element in Vector, and
    // rechecks integrity of heap using heapify method
    // runs in O(n + n log n)
    public int remove() {
        
        int rootElement = this.peek();
        
        swap(0, mv.size()-1);
        mv.removeElementAt(mv.size()-1);
        //buildHeap();
        heapifyNode(0);
        
        return rootElement;
    }

    // Returns true if heap is empty
    public boolean isEmpty() {
        return mv.isEmpty();
    }

    // Returns the top element at 0
    public int peek() {
        return mv.firstElement();
    }
    
    public String toString() {
        String m = " | Heapify calls = " + callsToHeapify + " | Swap calls = " + callsToSwap;
        return m;
    }
}


