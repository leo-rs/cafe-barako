/**
 *
 * @author leo
 * @param <T>
 */
public class PracticeLinkedList<T> {
    
    private Node<T> head;
    
    public PracticeLinkedList() {
        head = null;
    }
    
    public PracticeLinkedList (T headValue) {
        head = new Node(headValue);
    } 
    
    public void pushFront(T value) {
        head = new Node(value, head);
    }
    
    public void pushBack(T value) {
        
        if (head==null) {
            head = new Node(value);
        } else {
            Node<T> curr = head;
            while (curr.getNextNode() != null) {
                curr = curr.getNextNode();
            }
            
    //add new node to end of the list
            curr.setNextNode(new Node(value));
        }
    }
    
    public void print() {
        
        Node<T> curr = head;
        
        while(curr!=null) {
            System.out.println(curr.getData());
            curr=curr.getNextNode();
        }
    }
    
    
}
