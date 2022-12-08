/*  Jan Leo Ras
/   CSCI 3250-05 Fall 2021
/   Dr. Samadidana
/   Assignment 2 - LinkedLists
*/

package linkedlist.exception;

/*  Exception class for Magazine class.
 *  Thrown when Magazine object has invalid fields.
 */
public class InvalidMagazineException extends Exception{

    public InvalidMagazineException(){
        super();
    }
    
    public InvalidMagazineException(String msg){
        super(msg);
    }
}
