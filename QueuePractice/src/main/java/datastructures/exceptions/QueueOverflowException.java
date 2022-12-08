/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.exceptions;

/**
 *
 * @author leo
 */
public class QueueOverflowException extends Exception {

    /**
     * Creates a new instance of <code>QueueOverflowException</code> without
     * detail message.
     */
    public QueueOverflowException() {
        super();
    }

    /**
     * Constructs an instance of <code>QueueOverflowException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public QueueOverflowException(String msg) {
        super(msg);
    }
}
