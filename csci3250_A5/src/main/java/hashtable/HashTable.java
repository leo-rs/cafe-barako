/*   Jan Leo Ras
 *   CSCI 3250-05 Fall 2021
 *   Dr. Samadidana
 *   Assignment 5 - Hash Table
 */

package hashtable;

import java.util.LinkedList;

public class HashTable {
    LinkedList<Integer>[] hashTable;
    
    public HashTable(int m) {
        hashTable = new LinkedList[m];
    }
    
    //This function must use the modulus method to return the hash code for the given Key.
    public int hashCode(int k) {
       return k%hashTable.length;
    }
    
    
    //This function first finds the hash code and inserts the item at the found location. 
    //If the location is empty it must create a LinkedList and adds it to the new LinkedList. 
    //If the location already has a LinkedList (Collision has occurred) then add the new key to the end of the LinkedList.
    public void insert(int k) {
        int index = hashCode(k);
        
        if (hashTable[index]==null) {
            hashTable[index] = new LinkedList();
            hashTable[index].add(k);
            System.out.println("Key inserted successfully.");
        }
        else {
            hashTable[index].add(k);
            System.out.println("Key inserted successfully.");
        }
    }
    
    
    //This function searches for a key k and if it finds the key, deletes it. 
    //Keep in mind that you need to use the hashCode function to find the possible location of the item.
    public void delete(int k) {
        int index = hashCode(k);
        
        if (hashTable[index]!=null) {
            if (hashTable[index].contains(k)) {
                hashTable[index].removeFirstOccurrence(k);
                System.out.println("Key deleted successfully.");
            }
            else
                System.out.println("This key does not exist in the table.");
        }
        else
            System.out.println("This key does not exist in the table.");
    }
    
    //This function must show the values of the hash table.
    public void display() {
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i]!=null && hashTable[i].size()>0) {
                System.out.print("[" + i + "] " + hashTable[i].get(0));
                if(hashTable[i].size()>1) {
                    for (int k = 1; k < hashTable[i].size(); k++)
                        System.out.print( " -> " + hashTable[i].get(k));
                    System.out.print("\n");
                }
                else
                    System.out.print("\n");
            }
            else
                System.out.println("[" + i + "] is empty");
        }
    }
}
