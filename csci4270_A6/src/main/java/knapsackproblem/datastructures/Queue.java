
package knapsackproblem.datastructures;

public class Queue<T> {
    private Node[] queue = new Node[10];
    private int size;
    private int fI;
    private int eI;
    
    
    public Queue() {
        size = 0;
        fI = 0;
        eI = 0;
    }
    
    public int length() {
        return queue.length;
    }
    
    public void enqueue(Node n){
        queue[eI%queue.length]=n;
        eI=eI%queue.length+1; 
        size++;
    }
    
    public Node dequeue() {
        Node n;
        n = queue[fI]; //access the data and hold temporarily 
        queue[fI] = null; //reset data at index...
        fI = (fI+1)%queue.length; //new index using modulus ****SECOND ELSE CASE, needed?*****
        size--; //decrease size
        return n;
    }
    
    
    public boolean isFull(){
        return size>0 && eI%queue.length==fI;
    }
    
    public boolean isEmpty(){
        return size==0;
    }
    
}
