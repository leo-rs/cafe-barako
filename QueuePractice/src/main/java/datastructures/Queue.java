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
public class Queue {
    int[] data = new int[5];
    int fIndex;
    int eIndex;
    int size;
    
    //push element into the end of the Array
    //(1) if "end" pointer is at the end of the queue; show error that q is full
    //(2) if "end" pointer is at the end of the queue; go back to position 0 of array
    //but check first if the front of the queue is 
    
    //place items in array until end index = front index;
    
    //THIS IS WORKING
    public void enqueue(int d) throws QueueOverflowException{ 
        
        if(queueIsFull())
            throw new QueueOverflowException("\nEnqueue error: Queue is Full.");
        else{
            data[eIndex%data.length]=d;
            eIndex=eIndex%data.length+1; 
            size++;
        }
    
//        if(!qStart && eIndex == fIndex)
//            throw new QueueOverflowException("Queue is full.");
//        else if(qStart && eIndex==fIndex) {
//            data[eIndex]=d;
//            eIndex++;
//            qStart = true;
//        }
//        else {
//            while (eIndex%data.length != fIndex%data.length){
//                data[eIndex%data.length]=d;
//                eIndex = eIndex%data.length;
//            }
//        }

    }
    
    //return the front of the queue
    //change the reset the front of queue, element remains in the array
    
    //NEEDS WORK
    public int dequeue() throws QueueOverflowException{ 
        int d;
        if(queueIsEmpty())
            throw new QueueOverflowException("\nDequeue error: Queue is Empty.");
//        else if (fIndex==data.length-1){ //if front index is at the end of the array (data.length-1)
//            d = data[fIndex]; //access the data and hold temporarily
//            data[fIndex] = 0; //delete data (replace with 0)
//            fIndex = (fIndex+1)%data.length; //reset Index to the beginning of the array ****CHECK WITH SECOND ELSE CASE****
//            size--; //decrease size var for queueIsEmpty method
//        }
        else {
            d = data[fIndex]; //access the data and hold temporarily 
            data[fIndex] = 0; //reset data at index...
            fIndex = (fIndex+1)%data.length; //new index using modulus ****SECOND ELSE CASE, needed?*****
            size--; //decrease size
        }
        //fIndex = (fIndex%data.length)+1;
        return d;  
    }
    
    public void printQueue(){
        System.out.println("\n");
        for(int i=0; i<data.length; i++)
            System.out.print("| "+ data[i] + " | ");
    }
    
    public boolean queueIsFull(){
        //reset size?
        return size>0 && eIndex%data.length==fIndex;
    }
    
    public boolean queueIsEmpty(){
        return size==0;
    }
}
