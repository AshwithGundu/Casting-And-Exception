/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import enums.Limit;

/**
 * Faculty represents the teaching staff of a university or college
 *
 * @author Ashwith Gundu
 */
public class Faculty extends Member {

    /**
     * Department of the faculty
     */
    private String department;

    /**
     * Initializes the variables of this class and the super class. Initialize
     * the Item array with itemLimit as its size from Limit enum and set it to
     * the items of the super class.
     *
     * @param department - Department of the faculty
     * @param name - Name of the faculty
     * @param age - age of the faculty
     */
    public Faculty(String department, String name, int age) {
        super(name, age);
        this.department = department;
        this.setItems(new Item[Limit.Faculty.getItemLimit()]);
    }

    /**
     * Sets the department of Faculty
     *
     * @return department of string type
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Returns department of faculty
     *
     * @param department of type string
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public int compareTo(Member t) {
        if (this.getName().compareTo(t.getName()) < 0) {
            return -1;
        } else if (0 == this.getName().compareTo(t.getName())) {
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * Invoke super.toString() and concatenate the department
     *
     * @return - String representation of Faculty in the given format. <br>For
     * example:<br> MemberID: 919649853 <br>Name: Mike Husser <br>Age: 34
     * <br>Title: THE HUNGER GAMES, Available: false, BookID: NWM_B_1, RackNo:
     * SH.1.2011, Edition: 2.0, Authors: Arml, D. L., Tan, P., Teck, T.<br>
     * Title: THE GIVER, Available: false, BookID: NWM_B_2, RackNo: GY.2.2010,
     * Edition: 4.0, Authors: Sierra, K., Goss, J., tek, L.<br> Title: android
     * charger, Available: false, DeviceID: NWM_D_3, RackNo: droid Charger_D_7
     * Department: MSACS
     */
    @Override
    public String toString() {
        return super.toString() + "Department: " + this.department;
    }
}
