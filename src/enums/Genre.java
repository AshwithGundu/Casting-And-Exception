/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

/**
 * This enum contains the genre of a book with age assigned to it.
 *
 * @author Ashwith Gundu
 */
public enum Genre {

    /**
     *
     * age restriction with value 3
     */
    BIOGRAPHY(3),
    /**
     * age restriction with value 5
     */
    DRAMA(5),
    /**
     * age restriction with value 3
     */
    FANTASY(3),
    /**
     * age restriction with value 17
     */
    HORROR(17),
    /**
     * age restriction with value 10
     */
    MYSTERY(10),
    /**
     * age restriction with value 1
     */
    POETRY(1),
    /**
     * age restriction with value 12
     */
    ROMANCE(12),
    /**
     * age restriction with value 8
     */
    SCIENCE_FICTION(8);
    /**
     * Specifies the age restriction for the constants
     */
    private int age;

    private Genre(int age) {
        this.age = age;
    }

    /**
     * This getter method is used to access the age
     *
     * @return - This returns age restriction
     */
    public double getAge() {
        return age;
    }
}
