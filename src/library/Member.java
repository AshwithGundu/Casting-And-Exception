/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import exceptions.MaximumItemsReachedException;
import exceptions.UnderAgeException;
import java.util.Random;

/**
 * Member represents a library member
 *
 * @author Ashwith Gundu
 */
public abstract class Member implements Comparable<Member> {

    /**
     * Static integer variable that is initialized to 900000
     */
    private static int _919_counter = 900000;
    /**
     * Age of the member
     */

    private int age;
    /**
     * Holds the number of items that a member checked out from the Library.
     */

    private Item[] items;
    /**
     * It counts the number of items added to the array.
     */

    private int itemsCount;
    /**
     * Unique ID of member
     */

    private String memberID;
    /**
     * Name of the member
     */

    private String name;

    /**
     * Initializes itemsCount to 0. Assign generateMemberID() to memberID and
     * initializes other instance variable of class
     *
     * @param name - Name of the member
     * @param age - Age of the member
     */
    public Member(String name, int age) {
        this.age = age;
        this.name = name;
        memberID = this.generateMemberID();
    }

    /**
     * This method add items to items array. If itemsCount is less than length
     * of the array then add items to array, else throw
     * MaximumItemsReachedException with message "memberID : You have reached
     * your maximum limit".      <br><br>
     * If item is a Book, Check age of the member with age specified in Genre.
     * If member's age is greater than or equal to age specified in Genre, then
     * convert the book title to uppercase and update the book title, set the
     * item available to false and then add the book to items array. Increment
     * the itemsCount. Else, throw UnderAgeException with message "memberID :
     * Not allowed to check out this book".      <br><br>
     * If item is a DVD, Check age of the member with age specified in
     * MPAA_Rating of DVD. If member's age is greater than age specified in
     * MPAA_Rating, then convert the DVD title to lowercase and update the DVD
     * title, set the item available to false and then add the DVD to items
     * array. Increment the itemsCount. Else, throw UnderAgeException with
     * message "memberID : The DVD has a MPAA_rating description rating, Your
     * are not allowed to check out this item".      <br><br>
     * If item is a device, Convert the device title to lower case and update
     * the device title, set the item available to false and then add device to
     * items array. Increment the itemsCount.
     *
     * @param item of Item type
     * @throws MaximumItemsReachedException - if items array is full.
     * @throws UnderAgeException - if age of member is less than the specified
     * age.
     */
    public void addItems(Item item)
            throws MaximumItemsReachedException,
            UnderAgeException {
        if (itemsCount < items.length) {
            if (item instanceof Book) {
                if (this.age >= ((Book) item).getGenre().getAge()) {
                    item.setTitle(item.getTitle().toUpperCase());
                    item.setAvailable(false);
                    items[itemsCount] = item;
                    itemsCount++;
                } else {
                    throw new UnderAgeException(this.getMemberID() + " : Not allowed to check out this book");
                }
            }
            if (item instanceof DVD) {
                if (this.age > (((DVD) item).getRating().getAge())) {
                    item.setTitle(item.getTitle());
                    item.setAvailable(false);
                    items[itemsCount] = item;
                    itemsCount++;
                } else {
                    throw new UnderAgeException(this.getMemberID() + " : The DVD has a " + ((DVD) item).getRating().getDescription()
                            + ",Your are not allowed to check out this item\n");
                }
            }
            if (item instanceof Device) {
                item.setTitle(item.getTitle());
                item.setAvailable(false);
                items[itemsCount] = item;
                itemsCount++;
            }
        } else {
            throw new MaximumItemsReachedException(this.getMemberID() + " : You have reached your maximum limit");
        }
    }

    /**
     * Returns age of the member
     *
     * @return Age of the member
     */
    public int getAge() {
        return age;
    }

    /**
     * Return an item array
     *
     * @return - Items array
     */
    public Item[] getItems() {
        return items;
    }

    /**
     * Returns MemberID of member
     *
     * @return - String MemberID of member
     */
    public String getMemberID() {
        return memberID;
    }

    /**
     * Returns name of the member
     *
     * @return - String Name of the member
     */
    public String getName() {
        return name;
    }

    /**
     * Sets age of the member
     * @param age - Age of the member
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Sets an item array
     *
     * @param items - An array of items
     */
    public void setItems(Item[] items) {
        this.items = items;
    }

    /**
     * This is the setter method for Name
     *
     * @param name of String type
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method returns a unique ID. It generates a 6 digit random number
     * followed by "919" using seed value 20L. <br>Increment the _919_couner
     * before returning the String. Examples: 919649853 919656567
     *
     * @return - String Unique member ID
     */
    public String generateMemberID() {
        Random random = new Random();
        random.setSeed(20L);
        int counterId = _919_counter;
        this.memberID = "919" + random.nextInt(_919_counter);

        _919_counter++;

        return this.memberID;
    }

    /**
     * String representation of Member in given format. <br>For example:<br>
     * MemberID: 919649853<br> Name: Mike Husser <br>Age: 18 <br>Title: THE
     * HUNGER GAMES, Available: false, BookID: NWM_B_1, RackNo: SH.1.2011,
     * Edition: 2.0, Authors: Arml, D. L., Tan, P., Teck, T. <br>Title: THE
     * GIVER, Available: false, BookID: NWM_B_2, RackNo: GY.2.2010, Edition:
     * 4.0, Authors: Sierra, K., Goss, J., tek, L. <br>Title: android charger,
     * Available: false, DeviceID: NWM_D_3, RackNo: droid Charger_D_7
     *
     * @return - String representation of Member
     */
    @Override
    public String toString() {
        String string = "MemberID: " + this.getMemberID() + "\nName: " + name + "\nAge: " + this.getAge() + "\n";
        String ss = "";
        for (Item i : items) {

            if (i != null) {
                string = string + ss + i;
                ss = "\n";

            }
        }
        return string;
    }
}
