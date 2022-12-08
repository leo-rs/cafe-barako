/*  Jan Leo Ras
 *   CSCI 3250-05 Fall 2021
 *   Dr. Samadidana
 *   Assignment 2 - LinkedLists
 */

package library;

import linkedlist.exception.InvalidMagazineException;

public class Magazine {

    private String name;            // name of magazine
    private int edition;            // edition number of magazine
    private int publicationYear;    // year magazine was published
    private int pages;              // number of pages of magazine

    //  Constructor for magazine object, 
    //  Throws exceptions for each invalid field based on requirements.
    public Magazine(String n, int ed, int py, int pgs) throws InvalidMagazineException {
        if (n.isBlank()) {
            throw new InvalidMagazineException("Error: Magazine name cannot be blank.");
        } else if (ed < 1) {
            throw new InvalidMagazineException("Error: Magazine edition cannot be less than 1.");
        } else if (py <= 2000) {
            throw new InvalidMagazineException("Error: Magazine's publication date cannot be older than 2001.");
        } else if (pgs <= 0) {
            throw new InvalidMagazineException("Error: Magazine cannot have 0 or negative # of pages.");
        } else {
            name = n;
            edition = ed;
            publicationYear = py;
            pages = pgs;
        }
    }

    //  Getters for magazine properties
    public String getName() {
        return name;
    }

    public int getEdition() {
        return edition;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public int getPages() {
        return pages;
    }

    //  Override object's toString method for formatting
    @Override
    public String toString() {
        return "\nName: " + name + "\nEdition: " + edition + "\nPublication Year: "
                + publicationYear + "\nPages: " + pages;
    }
}
