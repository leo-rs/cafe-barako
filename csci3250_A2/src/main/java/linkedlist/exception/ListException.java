/*  Jan Leo Ras
/   CSCI 3250-05 Fall 2021
/   Dr. Samadidana
/   Assignment 2 - LinkedLists
*/

package linkedlist.exception;
    
/*  Exception class for LinkedList class.
 *  Thrown when at() method is called for an empty list.s
 */
public class ListException extends Exception{

    public ListException() {
        super();
    }

    public ListException(String msg) {
        super(msg);
    }
}
