/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import exceptions.NoFineException;
import interfaces.Library;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Item represents a Book, DVD or Device
 *
 * @author Ashwith Gundu
 */
public abstract class Item implements Library {

    /**
     * Available status of an item in library
     */
    private boolean available;
    /**
     * Counter initialized to zero
     */

    static int counter = 0;
    /**
     * Title of an item
     */

    private String title;

    /**
     * Initializes the title and increments the counter by 1
     *
     * @param title - Title of an item
     */
    public Item(String title) {
        this.title = title;
        counter++;
    }

    /**
     * This is the getter method for title
     *
     * @return title of type string
     */
    public String getTitle() {
        return title;
    }

    /**
     * This is the setter method for title
     *
     * @param title of string type
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Calculates the fine a member needs to pay to the library in dollars.
     * <br>If return-date (dateTime2) is before due-date (dateTime1),
     * NoFineException is thrown with message "Return date is before due date"
     * <br>Else, If difference between dates is equal to zero then fine is 0.
     * <br>else if difference between dates is is in between [1,7] then fine is
     * $5 <br>else if, difference between dates is in between (7,14] then fine
     * is $10 <br> else if, difference between dates is in between (14,28] then
     * fine is $20 <br>else fine is $100
     *
     * @param dateTime1 - Due date of an item in format "MM/dd/yyyy HH:mm:ss"
     * @param dateTime2 - Actual return date of an item in format "MM/dd/yyyy
     * HH:mm:ss"
     * @return double - Payable amount to library
     * @throws NoFineException - if return date(dateTime2) is less than due
     * date(dateTime1)
     */
    @Override
    public double calculateFine(String dateTime1, String dateTime2) throws NoFineException {
        Date d = new Date(dateTime1);//due date
        Date c = new Date(dateTime2);//return date
        if (c.before(d)) {
            throw new NoFineException("Return date is before due date");
        } else if (((c.getTime() / 86400000) - (d.getTime() / 86400000)) == 0) {
            return 0;
        } else if (((c.getTime() / 86400000) - (d.getTime() / 86400000)) >= 1 && ((c.getTime() / 86400000) - (d.getTime() / 86400000)) <= 7) {
            return 5;
        } else if (((c.getTime() / 86400000) - (d.getTime() / 86400000)) >= 8 && ((c.getTime() / 86400000) - (d.getTime() / 86400000)) <= 14) {
            return 10;
        } else if (((c.getTime() / 86400000) - (d.getTime() / 86400000)) > 14 && ((c.getTime() / 86400000) - (d.getTime() / 86400000)) < 29) {
            return 20;
        } else {
            return 100;
        }
    }

    /**
     * An abstract method to generate rack ID for an item
     *
     * @return - String Rack ID
     */
    public abstract String generateRackID();

    /**
     * An abstract method to generate unique ID for an item
     *
     * @return - String Unique ID
     */
    public abstract String generateUniqueID();

    /**
     * Returns the availability status of an item
     *
     * @return - boolean availability status
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Sets the availability status of an item
     *
     * @param available - Availability status of an item
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * String representation of Item in given format. For example: Title: The
     * Mummy, Available: true
     *
     * @return - String Item details
     */
    @Override
    public String toString() {
        return "Title: " + this.getTitle() + ", Available: " + this.isAvailable();
    }
}
