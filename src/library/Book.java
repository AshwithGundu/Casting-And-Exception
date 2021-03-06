/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import enums.Genre;
import java.util.Random;

/**
 *
 * Book represents a written or printed work consisting of pages glued together
 * along one side and bound in covers
 *
 * @author Ashwith Gundu
 */
public class Book extends Item {

    /**
     * An array of Authors
     */
    private Author[] authors;
    /**
     * Unique ID of book
     */

    private String bookID;
    /**
     * Copyright year of book
     */

    private int copyrightYear;
    /**
     * Edition of book
     */

    private double edition;
    /**
     * Genre of book
     */

    private Genre genre;
    /**
     * Rack counter initialized to 0
     */

    static int rackCounter = 0;
    /**
     * Rack Number of book in the library
     */

    private String rackNo;

    /**
     * Initializes the variables of this class and the super class. Assign
     * generateUniqueID() to bookID and generateRackID() to rackNo.
     *
     * @param authors - An array of Authors
     * @param copyrightYear - Copyright year of book
     * @param edition - Edition of book
     * @param genre - Genre of book
     * @param title - title of book
     */
    public Book(Author[] authors, int copyrightYear, double edition, Genre genre, String title) {
        super(title);
        generateUniqueID();
        this.authors = authors;
        this.copyrightYear = copyrightYear;
        this.edition = edition;
        this.genre = genre;
    }

    /**
     * Returns an array of Author
     *
     * @return - Array Author array
     */
    public Author[] getAuthors() {
        return authors;
    }

    /**
     * Sets Authors of a book
     *
     * @param authors - Author array
     */
    public void setAuthors(Author[] authors) {
        this.authors = authors;
    }

    /**
     * Returns the copyright year of the book
     *
     * @return - int copyright year
     */
    public int getCopyrightYear() {
        return copyrightYear;
    }

    /**
     * Sets the copyright year of the book
     *
     * @param copyrightYear - copyright year of the book
     */
    public void setCopyrightYear(int copyrightYear) {
        this.copyrightYear = copyrightYear;
    }

    /**
     * Returns edition of the book
     *
     * @return - double edition of the book
     */
    public double getEdition() {
        return edition;
    }

    /**
     * Sets edition of the book
     *
     * @param edition - edition of the book
     */
    public void setEdition(double edition) {
        this.edition = edition;
    }

    /**
     * Returns genre of the book
     *
     * @return - Genre genre of the book
     */
    public Genre getGenre() {
        return genre;
    }

    /**
     * Sets genre of the book
     *
     * @param genre - genre of the book
     */
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    /**
     * This method generates rack identification number to keep the book at a
     * particular location in the library. <br>The rack ID is generated by using
     * the following algorithm.      <br>
     * Generate any two random alphabets in
     * uppercase.rackCounter.copyrightYear<br>
     * Then increment the rackCounter.
     *
     * <h3>Examples</h3>
     *
     *
     * <table summary="Examples" border="1px">
     * <tr>
     * <th>Copyright year</th>
     * <th>RackID</th>
     * </tr>
     * <tr>
     * <td>2011</td>
     * <td>AT.0.2011</td>
     * </tr>
     * <tr>
     * <td>2014</td>
     * <td>PW.1.2104</td></tr>
     *
     * </table>
     *
     * @return - String RackNo of book
     */
    @Override
    public String generateRackID() {
        Random r = new Random();
        rackCounter++;
        String rd = Character.toString((char) (r.nextInt(26) + 'A'));
        String r2 = Character.toString((char) (r.nextInt(26) + 'A'));
        rackNo = rd + r2 + "." + rackCounter + "." + this.getCopyrightYear();
        return rackNo;
    }

    /**
     * This method concatenates LIBRARY_CODE, "_B_", counter and returns it.
     *
     * @return - String Unique ID of Book
     */
    @Override
    public String generateUniqueID() {
        bookID = LIBRARY_CODE + "_B_" + counter;
        return bookID;
    }

    /**
     * Invoke super.toString() and concatenate bookID, rackNo, edition and
     * authors. <br>For Example: <br>Title: THE HUNGER GAMES, Available: false,
     * BookID: NWM_B_1, RackNo: EB.1.2011, Edition: 2.0, Authors: Arml, D. L.,
     * Tan, P., Teck, T.
     *
     * @return - String representation of Book
     */
    @Override
    public String toString() {
        String s = "", ss = "";
        for (Author author : authors) {
            if (author != null) {
                s = s + ss + author.toString();
                ss = ", ";
            }
        }
        return super.toString() + ", BookID: " + bookID + ", RackNo: " + this.generateRackID() + ", Edition: " + this.edition
                + ", Authors: " + s;
    }
}
