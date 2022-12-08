/*  Jan Leo Ras
 *   CSCI 3250-05 Fall 2021
 *   Dr. Samadidana
 *   Assignment 2 - LinkedLists
 */

package linkedlist;

import linkedlist.exception.ListEmptyException;
import linkedlist.exception.ListException;

public class LinkedList<T> {

    private Node<T> head;   //first Node in this LinkedList
    private Node<T> tail;   //last Node in this LinkedList
    private int size;       //number of Nodes in this LinkedList

    //  Constructor sets pointers to null and initializes size to 0.
    public LinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    //  Getter for size property
    public int size() {
        return size;
    }

/*  This method is used to add a new Node(d) at the end of this LinkedList.
 *  If LinkedList is empty, a new Node is created and is assigned as the head Node.
 *  Otherwise, A pointer traverses the LinkedList to find the tail Node.
 *  The new Node is created and linked to tail Node, tail is reassigned, and lastly,
 *  size of the LinkedList is increased by 1.
 */
    public void pushBack(T d) {
        if (head == null) {
            head = new Node(d);
            tail = head;
            size++;
        } else {
            Node<T> ref = head;
            while (ref != tail) { //changed from (ref.getNext()!=null)
                ref = ref.getNext();
            }
            Node<T> newTail = new Node(d);
            ref.setNext(newTail);
            newTail.setPrev(ref);
            tail = newTail;
            size++;
        }
    }

/*  This method is used to add a new Node(d) at the beginning of this LinkedList.
 *  If LinkedList is empty, a new Node is created and is assigned as the head Node.
 *  A new Node is created and linked to the head Node, head Node is reassigned,
 *  and size increased by 1.
 */
    public void pushFront(T d) {
        if (head == null) {
            head = new Node(d);
            size++;
        } else {
            Node<T> newHead = new Node(d, head);
            head.setPrev(newHead);
            head = newHead;
            size++;
        }
    }

/*  This method returns the data of the last Node and removes the Node from this LinkedList.
 *  Throws exception if LL is empty.
 */
    public T popBack() throws ListEmptyException {
        if (head == null) {
            throw new ListEmptyException("Error: List is empty.");
        } else {
            T lastData = tail.getData();
            Node<T> newTail = tail.getPrev();
            newTail.setNext(null);
            tail = newTail;
            size--;
            return lastData;
        }
    }

/*  This method returns the data of the first Node and removes the Node from this LinkedList.
 *  Throws exception if LL is empty.
 */
    public T popFront() throws ListEmptyException {
        if (head == null) {
            throw new ListEmptyException("Error: List is empty.");
        } else {
            T headData = head.getData();
            Node<T> newHead = head.getNext();
            newHead.setPrev(null);
            head = newHead;
            size--;
            return headData;
        }
    }

/*  This method returns the data in the Node at LinkedList index d. 
 *  Throws exception if the index is out of bounds [0, size-1].
 *  Operates at O(1) for the first and last item of the LL, and O(n) 
 *  for everything else.
 */
    public T at(int d) throws ListException {
        if (d < 0 || d >= size) {
            throw new ListException("Error: Index out of bounds.");
        } else if (d == 0) {
            return head.getData();
        } else if (d == size - 1) {
            return tail.getData();
        } else {
            Node<T> ph = head;
            for (int i = 0; i != d; i++) {
                ph = ph.getNext();
            }
            return ph.getData();
        }
    }

/*  This method returns the data in the first Node.
 *  Throws exception if the list is empty.
 */
    public T front() throws ListEmptyException {
        if (head == null) {
            throw new ListEmptyException("Error: List is empty.");
        } else {
            return head.getData();
        }
    }

/*  This method returns the data in the last Node.
 *  Throws exception if the list is empty.
 */
    public T back() throws ListEmptyException {
        if (head == null) {
            throw new ListEmptyException("Error: List is empty.");
        } else {
            return tail.getData();
        }
    }

    public void printAll() {
        Node<T> ph = head;
        int count = 0;
        while (ph != null) {
            count++;
            System.out.println("\n(" + count + ")"
                    + ph.getData());
            ph = ph.getNext();
        }
    }
}
