/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 * Exception thrown when return date is less than due date
 *
 * @author Ashwith Gundu
 */
public class NoFineException extends Exception {

    /**
     * Creates a new instance of NoFineException without detail message.
     */
    public NoFineException() {
    }

    /**
     * * Constructs an instance of NoFineException with the specified detail
     * message.
     *
     * @param message - the detail message.
     */
    public NoFineException(String message) {
        super(message);
    }

}
