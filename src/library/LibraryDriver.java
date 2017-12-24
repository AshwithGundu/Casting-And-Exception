/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import enums.Genre;
import enums.MPAA_Rating;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import exceptions.MaximumItemsReachedException;
import exceptions.UnderAgeException;
import java.io.File;



/**
 * Application launches from this class
 *
 * @author Ashwith Gundu
 */
public class LibraryDriver {

    /*  @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * @throws exceptions.MaximumItemsReachedException
     * @throws exceptions.UnderAgeException
     */
    public static void main(String[] args) throws FileNotFoundException, MaximumItemsReachedException, UnderAgeException {
        Scanner sc = new Scanner(new File("library.txt"));
        LibraryManagement lmList = new LibraryManagement();
       
        ArrayList<Student> studentList = new ArrayList<>();
        ArrayList<Device> deviceList = new ArrayList<>();
        ArrayList<Book> bookList = new ArrayList<>();

        while (sc.hasNext()) {
            String details = sc.next();
            if (details.toLowerCase().trim().equals("student")) {
                String str1, str2;
                str1 = sc.next();
                int i = sc.nextInt();
                sc.nextLine();
                str2 = sc.nextLine();
                Student student = new Student(str1, i, str2);

                while (sc.hasNext()) {
                    String type = sc.next();
                    if (type.toLowerCase().equals("book")) {
                        sc.nextLine();
                        String[] book1 = sc.nextLine().split(",");
                        String[] book2;
                        Author[] author = new Author[book1.length];
                        String firstName, lastName, middleName;
                        int index = 0;
                        for (String author1 : book1) {
                            book2 = author1.split(" ");
                            if (book2.length == 3) {
                                author[index] = new Author(book2[0], book2[1], book2[2]);
                            } else if (book2.length == 2) {
                                author[index] = new Author(book2[0], book2[1]);
                            }
                            index++;
                        }
                        String title, genre;
                        int copyRight = sc.nextInt(),
                                edition = sc.nextInt();
                        genre = sc.next().toUpperCase();
                        sc.nextLine();
                        title = sc.nextLine();
                        try {
                            Book book = new Book(author, copyRight, edition, Genre.valueOf(genre), title);
                            student.addItems(book);
                            bookList.add(book);
                        } catch (MaximumItemsReachedException mire) {
                            System.out.println(mire);
                        } catch (UnderAgeException uae) {
                            System.out.println(uae);
                        }

                    } else if (type.toLowerCase().equals("dvd")) {
                        MPAA_Rating mpp = MPAA_Rating.valueOf(sc.next().toUpperCase());
                        double storage = sc.nextDouble();
                        sc.nextLine();
                        String title = sc.nextLine();

                        try {
                            DVD dvd = new DVD(mpp, storage, title);
                            student.addItems(dvd);
                        } catch (MaximumItemsReachedException mire) {
                            System.out.println(mire);
                        } catch (UnderAgeException uae) {
                            System.out.println(uae);
                        }
                    } else if (type.toLowerCase().equals("device")) {
                        sc.nextLine();
                        String title = sc.nextLine();
                        try {
                            Device device = new Device(title);
                            student.addItems(device);
                        } catch (MaximumItemsReachedException mire) {
                            System.out.println(mire);
                        } catch (UnderAgeException uae) {
                            System.out.println(uae);
                        }

                    } else if (type.toLowerCase().equals("dates")) {
                        sc.nextLine();
                        String dueDate = sc.nextLine(), returnDate = sc.nextLine();
                        LibraryManagement libman = new LibraryManagement(student, dueDate, returnDate);
                        System.out.println("**********************************");
                        System.out.println(libman);
                        System.out.println("**********************************");
                        lmList.addMembers(student);
                        System.out.print("\n");
                        studentList.add(student);
                        break;
                    }
                }
            } else if (details.trim().toLowerCase().equals("faculty")) {
                sc.nextLine();
                String dep = sc.nextLine(), name = sc.nextLine();
                int age = sc.nextInt();
                Faculty faculty = new Faculty(dep, name, age);
                while (sc.hasNext()) {
                    String type = sc.next();
                    if (type.toLowerCase().equals("book")) {
                        sc.nextLine();
                        String[] b1 = sc.nextLine().split(",");
                        String[] b2;
                        Author[] author = new Author[b1.length];
                        String fName, lName, mName;
                        int index = 0;
                        for (String author1 : b1) {
                            b2 = author1.split(" ");
                            if (b2.length == 3) {
                                author[index] = new Author(b2[0], b2[1], b2[2]);
                            } else if (b2.length == 2) {
                                author[index] = new Author(b2[0], b2[1]);
                            }
                            index++;
                        }

                        String title,
                                genre;
                        int copyRight = sc.nextInt(),
                                edition = sc.nextInt();
                        genre = sc.next().toUpperCase();
                        sc.nextLine();
                        title = sc.nextLine();
                        try {
                            Book book = new Book(author, copyRight, edition, Genre.valueOf(genre), title);
                            faculty.addItems(book);
                        } catch (MaximumItemsReachedException mire) {
                            System.out.println(mire);
                        } catch (UnderAgeException ex) {
                            System.out.println(ex);
                        }

                    } else if (type.toLowerCase().equals("dvd")) {
                        MPAA_Rating mpp = MPAA_Rating.valueOf(sc.next().toUpperCase());
                        double storage = sc.nextDouble();
                        sc.nextLine();
                        String title = sc.nextLine();

                        try {
                            DVD dvd = new DVD(mpp, storage, title);
                            faculty.addItems(dvd);
                        } catch (MaximumItemsReachedException m) {
                            System.out.println(m);
                        } catch (UnderAgeException ex) {
                            System.out.println(ex);
                        }
                    } else if (type.toLowerCase().equals("device")) {
                        sc.nextLine();
                        String title = sc.nextLine();

                        try {
                            Device device = new Device(title);
                            faculty.addItems(device);
                            deviceList.add(device);

                        } catch (MaximumItemsReachedException max) {
                            System.out.println(max);
                        } catch (UnderAgeException ex) {
                            System.out.println(ex);
                        }

                    } else if (type.toLowerCase().equals("dates")) {
                        sc.nextLine();
                        String dueDate = sc.nextLine(), returnDate = sc.nextLine();
                        LibraryManagement libman = new LibraryManagement(faculty, dueDate, returnDate);
                        System.out.println("**********************************");
                        System.out.println(libman);
                        System.out.println("**********************************");
                        System.out.println("\n");
                        lmList.addMembers(faculty);
                      
                        break;
                    }
                }
            }
        }
        System.out.println("--------------------------------------\n"
                + "Printing Student details\n"
                + "--------------------------------------");
        for (Member member : lmList.getMemberList()) {
            if (member instanceof Student) {
                System.out.println(member);
            }
        }
        System.out.println("--------------------------------------\n"
                + "Printing Faculty details\n"
                + "--------------------------------------");
        for (Member member : lmList.getMemberList()) {
            if (member instanceof Faculty) {
                System.out.println(member);
            }
        }
    }
}
