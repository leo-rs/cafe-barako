/*  Jan Leo Ras
/   CSCI 3250-05 Fall 2021
/   Dr. Samadidana
/   Assignment 2 - LinkedLists
*/

package linkedlist.exception;

/*  Exception class for LinkedList class.
 *  Thrown when popBack()/popFront() methods are called for an empty list.
 */
public class ListEmptyException extends Exception{

    public ListEmptyException() {
        super();
    }

    public ListEmptyException(String msg) {
        super(msg);
    }
}
