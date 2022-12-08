/*  Jan Leo Ras
 *   CSCI 3250-05 Fall 2021
 *   Dr. Samadidana
 *   Assignment 2 - LinkedLists
 */

package linkedlist;

public class Node<T> {

    private T data;         //  data in this Node
    private Node<T> next;   //  next Node in the chain
    private Node<T> prev;   //  previous Node in the chain

    //  Constructors for the Node
    public Node(T value) {
        data = value;
    }

    public Node(T value, Node<T> nextNode) {
        data = value;
        next = nextNode;
    }

    public Node(T value, Node<T> nextNode, Node<T> prevNode) {
        data = value;
        next = nextNode;
        prev = prevNode;
    }

    //  Setters and getters for Node properties
    public void setNext(Node<T> n) {
        next = n;
    }

    public void setPrev(Node<T> p) {
        prev = p;
    }

    public void setData(T d) {
        data = d;
    }

    public T getData() {
        return data;
    }

    public Node<T> getNext() {
        return next;
    }

    public Node<T> getPrev() {
        return prev;
    }
}
