/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author leo
 * @param <T>
 */
public class Node<T> {
    
    private T data;
    private Node<T> next;
    
    public Node(T value){
        this.data=value;
        this.next=null;
    }
    
    public Node(T value, Node<T> nextNode){
        this.data=value;
        this.next=nextNode;
    }
    
    public Node<T> getNextNode(){
        return next;
    }
    
    public void setNextNode(Node<T> nextNode){
        this.next=nextNode;
    }
    
    public T getData(){
        return this.data;
    }
    
    public void setData(T data){
        this.data=data;
    }
}
