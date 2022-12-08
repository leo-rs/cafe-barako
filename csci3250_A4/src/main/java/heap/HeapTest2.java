/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HeapTest2 {

    public static void main(String[] args) {
        MinHeap2 mh = new MinHeap2();
        int n = 5000001;
        heapFromFile(mh, n);
        
        
        
        //mh.insert(3);
        //mh.insert(2);
        //mh.insert(1);
        //mh.insert(6);
        //mh.insert(9);
        
        while(!mh.isEmpty())
            System.out.println(mh.remove());
        
        System.out.println("\nMin-Heap empty.\n " 
                + "Heap size = " + n + mh.toString());
    }
    
     public static void heapFromFile(MinHeap2 v, int i){
        File file = new File("nums.txt");
            try {
                Scanner inputStream = new Scanner(file);
                while(inputStream.hasNext() && i>0) {
                    v.addToVector(inputStream.nextInt());
                    i--;
                }
                v.buildHeap();
                    
            } catch (FileNotFoundException ex) {
                System.out.println("File not found.");
                System.exit(0);
            }
    }
    
}
