/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author leo
 */
public class LinkedListDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        PracticeLinkedList<Integer> slist=new PracticeLinkedList();
        
        slist.pushBack(9);
        slist.pushBack(8);
        slist.pushFront(5);
        slist.pushFront(6);
        slist.pushFront(7);
        
        slist.print();
        
        
    }
    
}
