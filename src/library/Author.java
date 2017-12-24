/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

/**
 * Author represents a writer of a book
 *
 * @author Ashwith Gundu
 */
public class Author {

    /**
     * First name of the Author
     */
    private String firstName;
    /**
     * Last name of the Author
     */

    private String lastName;
    /**
     * Middle name of the Author
     */

    private String middleName = "";

    /**
     * Initializes the variables of Author
     *
     * @param firstName - first name of the Author
     * @param lastName - last name of the Author
     */
    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Initializes the variables of Author
     *
     * @param firstName - first name of the Author
     * @param middleName - middle name of the Author
     * @param lastName - last name of the Author
     */
    public Author(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    /**
     * Returns the first name of the Author
     *
     * @return - String first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the Author
     *
     * @param firstName - first name of the Author
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the last name of the Author
     *
     * @return - String last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the Author
     *
     * @param lastName - last name of the Author
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the Middle name of the Author
     *
     * @return - String Middle name
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Sets the middle name of the Author
     *
     * @param middleName - middle name of the Author
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * Returns private instance variables in given format. For example: If
     * firstName is "Alfred", middleName is "Lord" and lastName is "Tennyson" it
     * returns "Tennyson, A. L." If there is no middleName, it returns
     * "Tennyson, A."
     *
     * @return - String representation of Author name
     */
    @Override
    public String toString() {
        if (getMiddleName().trim().length() != 0) {
            return getLastName() + ", " + getFirstName().trim().toUpperCase().charAt(0) + ". "
                    + getMiddleName().trim().toUpperCase().charAt(0) + ".";
        } else {
            return getLastName() + ", " + getFirstName().trim().toUpperCase().charAt(0) + ".";
        }
    }
}
