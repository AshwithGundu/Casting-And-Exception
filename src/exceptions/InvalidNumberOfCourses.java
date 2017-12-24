/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 * - int This returns item limit
 *
 * @author Ashwith Gundu
 */
public class InvalidNumberOfCourses extends Exception {

    /**
     * Creates a new instance of InvalidNumberOfCourses without detail message.
     */
    public InvalidNumberOfCourses() {
    }

    /**
     * Constructs an instance of InvalidNumberOfCourses with the specified
     * detail message.
     *
     * @param message - the detail message.
     */
    public InvalidNumberOfCourses(String message) {
        super(message);
    }

}
