/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import enums.Limit;
import exceptions.InvalidNumberOfCourses;

/**
 * A person who is studying at a school or college.
 *
 * @author Ashwith Gundu
 */
public class Student extends Member {

    /**
     * Courses taken by a student in a semester.
     */
    private String coursesTaken;

    /**
     * Initializes the variables of this class and the super class. Initialize
     * the Item array with itemLimit as its size from Limit enum and set it to
     * the items of the super class.
     *
     * @param coursesTaken - Courses taken by student
     * @param age - Age of the student
     * @param name - Name of the student
     */
    public Student(String coursesTaken, int age, String name) {
        super(name, age);
        this.coursesTaken = coursesTaken;
        this.setItems(new Item[Limit.Student.getItemLimit()]);
    }

    /**
     * This method returns true if the number of courses taken by a student is
     * less than or equal to 3. Else, throw InvalidNumberOfCourses exception
     *
     * @return boolean
     * @throws InvalidNumberOfCourses - If number of courses taken is greater
     * than 3
     */
    public boolean checkCoursesTaken() throws InvalidNumberOfCourses {
        String[] NumberOfCourses = coursesTaken.split(",");
        if (NumberOfCourses.length <= 3) {
            return true;
        } else {
            throw new InvalidNumberOfCourses();
        }
    }

    @Override
    public int compareTo(Member t) {
        if (Integer.parseInt(this.getMemberID()) < Integer.parseInt(t.getMemberID())) {
            return -1;
        } else if (Integer.parseInt(this.getMemberID()) == Integer.parseInt(t.getMemberID())) {
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * Invoke super.toString() and concatenate the coursesTaken
     *
     * @return - String representation of Student in the given format.
     */
    @Override
    public String toString() {
        return super.toString() + "\nCourses Taken: " + this.coursesTaken;
    }

}
