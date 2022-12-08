/*  Jan Leo Ras
 *   CSCI 3250-05 Fall 2021
 *   Dr. Samadidana
 *   Assignment 2 - LinkedLists
 */

package library;

import linkedlist.LinkedList;
import linkedlist.exception.ListEmptyException;
import linkedlist.exception.ListException;

public class Library {

    private LinkedList<Magazine> magazines;

    public Library() {
        magazines = new LinkedList<>();
    }

    public void addMagazine(Magazine m) {    //adds Magazine at the end of the LL
        magazines.pushBack(m);
    }

    public int getCount() {
        return magazines.size();
    }

/*  This method returns the Magazine object with the highest number of pages. 
 *  If there are multiple Magazine objects with the same highest number of pages, 
 *  only the first Magazine in the list is returned.
 *  Exceptions are thrown if the list is empty.
 */
    public Magazine getMagazineWithHighestNumberOfPages() throws ListEmptyException, ListException {
        if (magazines.size() == 0) {
            throw new ListEmptyException("\nError: This library is empty.");
        } else {
            Magazine bigMag = magazines.front();
            for (int i = 1; i < magazines.size(); i++) {
                Magazine ref = magazines.at(i);
                if (ref.getPages() > bigMag.getPages()) {
                    bigMag = ref;
                }
            }
            return bigMag;
        }
    }

/*  This method takes returns the Magazine containing pages greater than the parameter. 
 *  Exceptions are thrown if the list is empty.
 */
    public int getNumberOfMagazinesThatHavePagesMoreThan(int pages) throws ListException {
        if (magazines.size() == 0) {
            throw new ListException("\nError: This library is empty.");
        } else {
            int count = 0;
            for (int i = 0; i < magazines.size(); i++) {
                if (magazines.at(i).getPages() > pages) {
                    count++;
                }
            }
            return count;
        }
    }

    public void printAllMagazines() throws ListException {
        if (magazines.size() == 0) {
            throw new ListException("\nThis library is empty.");
        } else {
            magazines.printAll();
        }
    }

}
