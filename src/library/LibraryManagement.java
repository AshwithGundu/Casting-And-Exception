/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import exceptions.NoFineException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Library Management represents check-in and check-out dates of items by a
 * member
 *
 * @author Ashwith Gundu
 */
public class LibraryManagement {

    /**
     * library member object
     */
    private Member member;
    /**
     * Due date of an Item in "MM/dd/yyyy HH:mm:ss"
     */

    private String dueDate;
    /**
     * Return date of an Item in "MM/dd/yyyy HH:mm:ss"
     */

    private String actualReturnDate;
    /**
     * List of members
     */

    private List<Member> memberList = new ArrayList<>();

    /**
     * Initializes the memberList with ArrayList
     */
    public LibraryManagement() {
    }

    /**
     * Initializes the variables of this class and initializes the memberList
     * with ArrayList.
     *
     * @param member - Library member object
     * @param dueDate - Due date of an Item in "MM/dd/yyyy HH:mm:ss"
     * @param actualReturnDate - Return date of an Item in "MM/dd/yyyy HH:mm:ss"
     */
    public LibraryManagement(Member member, String dueDate, String actualReturnDate) {
        this.member = member;
        this.dueDate = dueDate;
        this.actualReturnDate = actualReturnDate;
    }

    /**
     * This method add members to the memberList
     *
     * @param member - Library member object
     */
    public void addMembers(Member member) {
        memberList.add(member);
    }

    /**
     * Returns the members list of library
     *
     * @return - List member list
     */
    public List<Member> getMemberList() {
        return memberList;
    }

    /**
     * This method returns the total fine by calculating individual fine for
     * each item checked out by library member.
     *
     * @return - double Total fine payable to library
     */
    public double totalFine() {
        double fine = 0;
        for (Item i : member.getItems()) {
            try {
                if (i != null) {
                    fine = fine + i.calculateFine(dueDate, actualReturnDate);
                } else {
                    throw new NoFineException();
                }
            } catch (NoFineException ex) {
                System.out.println("");
            }
        }
        return fine;
    }

    /**
     * Returns all the private instance variables and total fine. For example:
     * member.toString() + "Due Date: 12/30/2017 10:00:00 Return Date:
     * 12/30/2017 10:05:00 Fine Amount: 0.0"
     *
     * @return - String
     */
    @Override
    public String toString() {
        return member.toString() + "\nDue Date: " + this.dueDate + " Return Date: " + this.actualReturnDate + " Fine Amount: " + totalFine();
    }
}
