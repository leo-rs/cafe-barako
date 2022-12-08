/*   Jan Leo Ras
 *   CSCI 3250-05 Fall 2021
 *   Dr. Samadidana
 *   Assignment 5 - Hash Table
 */
package hashtable;

import java.util.Scanner;

public class HashTableDemo {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the table size: ");
        int htSize = input.nextInt();
        HashTable ht = new HashTable(htSize);
        
        
        System.out.println("\nChoose an option: "
            + "\n1- Insert a key"
            + "\n2- Delete a key"
            + "\n3- Display the table"
            + "\n4- Exit");
        
        int choice = input.nextInt();
        int key;
        while (choice!=4) {
            switch (choice) {
                case 1: System.out.println("\nInsert the key: ");
                        key = input.nextInt();
                        ht.insert(key);
                        break;
                case 2: System.out.println("\nEnter the key to delete: ");
                        key = input.nextInt();
                        ht.delete(key);
                        break;
                case 3: ht.display();
                        break;
                default: System.out.println("\nOption not available.");
            }
            displayOptions();
            choice = input.nextInt();
        }
        System.out.println("\nExiting program...");
    }
    
    public static void displayOptions(){
        System.out.println("\nChoose an option: "
            + "\n1- Insert a key"
            + "\n2- Delete a key"
            + "\n3- Display the table"
            + "\n4- Exit");
    }
}
