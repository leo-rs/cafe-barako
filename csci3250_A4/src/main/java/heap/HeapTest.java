/*  Jan Leo Ras
 *   CSCI 3250-05 Fall 2021
 *   Dr. Samadidana
 *   Assignment 4 - Min Heap
 */
package heap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class HeapTest {

    public static void main(String[] args) throws IOException {

        Scanner inputScan = new Scanner(System.in);
        System.out.println("\nHow do you wish to insert into the heap?\n"
                + "[R]ead from the nums.txt file or "
                + "[I]nsert numbers? "
                + "Use any other key to exit...");
        String choice = inputScan.nextLine();
        switch (choice) {
            case "R":
                System.out.println("\nHeapifying file...");
                heapFromFile(inputScan);
                break;
            case "I":
                System.out.println("How many number do you wish to insert? ");
                int n = new Integer(inputScan.nextLine());
                heapFromUser(n, inputScan);
                break;
            default:
                System.out.println("Exiting...");
        }
    }

    public static void heapFromFile(Scanner s) {
        File file = new File("nums.txt");
        MinHeap v = new MinHeap();
        try {
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNext()) {
                v.addToVector(inputStream.nextInt());
            }
            v.buildHeap();
            printHeap(v);
        } catch (FileNotFoundException ex) {
            System.out.println("File not found.");
            System.exit(0);
        }
    }

    public static void heapFromUser(int n, Scanner s) {
        MinHeap m = new MinHeap();
        int index = 0;
        while (index < n) {
            System.out.println(" [" + (index + 1) + "] ");
            m.insert(Integer.parseInt(s.nextLine()));
            index++;
        }
        m.buildHeap();
        System.out.println(m.toString());
        printHeap(m);
    }

    //While the heap is not empty, print and remove root
    public static void printHeap(MinHeap h) {
        System.out.println("\nPrinting heap...");
        while (!h.isEmpty()) {
            System.out.println(h.remove());
        }
        System.out.println(h.toString());
    }
}
