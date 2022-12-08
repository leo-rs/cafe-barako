/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import datastructures.exceptions.QueueOverflowException;

/**
 *
 * @author leo
 */
public class TestQueue {

    /**
     * @param args the command line arguments
     * @throws datastructures.exceptions.QueueOverflowException
     */
    public static void main(String[] args) throws QueueOverflowException {
        // TODO code application logic here
        
        Queue pq = new Queue();
        
        try {
            
        pq.enqueue(5);
        pq.enqueue(10);
        pq.enqueue(15);
        pq.printQueue();
        System.out.println("\nFirst item is at index " + (pq.fIndex));
        System.out.println("Last item is at index " + (pq.eIndex-1) +
                "\nNew size = " + pq.size);
        System.out.println("\nPushing more stuff into queue...");
        
        pq.enqueue(20);
        pq.enqueue(25);
        pq.printQueue();
        System.out.println("\nFirst item is at index " + (pq.fIndex));
        System.out.println("Last item is at index " + (pq.eIndex-1) +
                "\nNew size = " + pq.size);
        
        System.out.println("\n\nDequeuing index "+ (pq.fIndex) + " = " +pq.dequeue());
        System.out.println("Dequeuing index "+ (pq.fIndex) + " = " +pq.dequeue());
        pq.printQueue();
        System.out.println("\nFirst item is at index " + (pq.fIndex));
        System.out.println("Last item is at index " + (pq.eIndex-1) +
                "\nNew size = " + pq.size);
        
        System.out.println("\nPushing more stuff into queue...");
        pq.enqueue(30);
        pq.enqueue(35);
        pq.printQueue();
        //pq.enqueue(45); //Trigger Enqueue error
        
        System.out.println("\nFirst item is at index " + (pq.fIndex));
        System.out.println("Last item is at index " + (pq.eIndex-1) +
                "\nNew size = " + pq.size);
        
        System.out.println("\n\nDequeuing index "+ (pq.fIndex) + " = " +pq.dequeue());
        System.out.println("Dequeuing index "+ (pq.fIndex) + " = " +pq.dequeue());
        System.out.println("Dequeuing index "+ (pq.fIndex) + " = " +pq.dequeue());
        //System.out.println("Dequeuing index "+ (pq.fIndex) + " = " +pq.dequeue());
        pq.printQueue();
        
        System.out.println("\nFirst item is at index " + (pq.fIndex));
        System.out.println("Last item is at index " + (pq.eIndex-1) +
                "\nNew size = " + pq.size);
        
        System.out.println("\n\nDequeuing index "+ (pq.fIndex) + " = " +pq.dequeue());
        System.out.println("Dequeuing index "+ (pq.fIndex) + " = " +pq.dequeue());
        pq.printQueue();
        
        System.out.println("\nFirst item is at index " + (pq.fIndex));
        System.out.println("Last item is at index " + (pq.eIndex-1) +
                "\nNew size = " + pq.size);
        
        System.out.println("\n\nDequeuing index "+ (pq.fIndex) + " = " +pq.dequeue());
        System.out.println("Dequeuing index "+ (pq.fIndex) + " = " +pq.dequeue());
        pq.printQueue();
        System.out.println("\nFirst item is at index " + (pq.fIndex));
        System.out.println("Last item is at index " + (pq.eIndex-1) +
                "\nNew size = " + pq.size);
        pq.dequeue(); //Trigger dequeue error
//        
//        System.out.println("\nDequeuing index "+ (pq.fIndex) + " = " +pq.dequeue());
//        System.out.println("\nDequeuing index "+ (pq.fIndex) + " = " +pq.dequeue());
//        pq.printQueue();        
//        System.out.println("\nLast item is at index " + (pq.eIndex-1));
//        
//        pq.enqueue(40);
//
//        pq.printQueue();
//        System.out.println("\nLast item is at index " + (pq.eIndex-1));
//        
//        pq.enqueue(45);
//        pq.printQueue();
//        System.out.println("\nLast item is at index " + (pq.eIndex-1) +
//                "\nNew size = " + pq.size);
//        
//        pq.enqueue(50);
        
        
        } catch (QueueOverflowException ex) {
            System.out.println(ex.getMessage());
        }
    }   
    
}
