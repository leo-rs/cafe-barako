/*  Jan Leo Ras
 *   CSCI 3250-05 Fall 2021
 *   Dr. Samadidana
 *   Assignment 2 - LinkedLists
 */

package library;

import java.util.Scanner;
import linkedlist.exception.InvalidMagazineException;
import linkedlist.exception.ListEmptyException;
import linkedlist.exception.ListException;

public class LibraryManagement {

    public static void main(String[] args) throws InvalidMagazineException, ListEmptyException, ListException {

        Library magLib = new Library();
        Scanner in = new Scanner(System.in);
        int choice;

        System.out.println("Welcome to my magazine library!");
        displayOptions();
        choice = in.nextInt();

        while (choice != 6) {
            switch (choice) {
                case 1:
                    try {
                    magLib.addMagazine(newMagazine());
                    System.out.println("\nMagazine added succesfully.");
                } catch (InvalidMagazineException ex) {
                    System.out.println(ex.getMessage());
                }
                break;
                case 2:
                    System.out.println("\nThere are "
                            + magLib.getCount() + " magazine(s) in this library.");
                    break;
                case 3:
                    try {
                    System.out.println(magLib.getMagazineWithHighestNumberOfPages().toString());
                } catch (ListEmptyException ex) {
                    System.out.println(ex.getMessage());
                }
                break;
                case 4:
                    System.out.println("\nEnter page count: ");
                    int num = in.nextInt();
                    if (num < 0) {
                        System.out.println("Error: Page count cannot be negative.");
                    } else {
                        try {
                            System.out.println("\n" + magLib.getNumberOfMagazinesThatHavePagesMoreThan(num)
                                    + " magazine(s) have more than " + num + " pages.");
                        } catch (ListException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                    break;
                case 5:
                    try {
                    magLib.printAllMagazines();
                } catch (ListException ex) {
                    System.out.println(ex.getMessage());
                }
                break;
                default:
                    System.out.println("\nOption unavailable. Try again.");
            }
            displayOptions();
            choice = in.nextInt();
        }
        System.out.println("\nThank you for using my magazine library!"
                + "\nExiting...");
    }

/*  This method returns a Magazine object created from user input.
 */
    public static Magazine newMagazine() throws InvalidMagazineException {

        Scanner magIn = new Scanner(System.in);

        String name;
        int ed, py, pgs;

        System.out.println("\nEnter magazine's name: ");
        name = magIn.nextLine();

        System.out.println("Enter magazine's edition: ");
        ed = magIn.nextInt();

        System.out.println("Enter magazine publication year: ");
        py = magIn.nextInt();

        System.out.println("Enter magazine's number of pages: ");
        pgs = magIn.nextInt();

        Magazine newMag = new Magazine(name, ed, py, pgs);
        return newMag;
    }

/*  This method displays the menu options.
 */
    public static void displayOptions() {
        System.out.println("\nChoose an option from 1 - 6: "
                + "\n1 - Add magazine."
                + "\n2 - Get count."
                + "\n3 - Get the magazine with the highest number of pages."
                + "\n4 - Get number of magazines that have pages more than N."
                + "\n5 - Print all."
                + "\n6 - Quit.");
    }

}
    

