/*   Jan Leo Ras
 *   CSCI 4270-05 Spring 2022
 *   Dr. Samadidana
 *   Assignment 5 - Dynamic Programming
 */
package sequence;

import java.util.Scanner;

public class SequenceAlignment {

    public static void main(String[] args) {
        System.out.println("This program reports the alignment cost of two strings of genetic code.");
        System.out.println("The input strings must contain one of the four nucleotide bases (A, C, T, G).\n");
        
        Scanner in = new Scanner(System.in);
        boolean validSeq;
        
        //Asks for and validates string input
        System.out.println("Enter first nucleotide sequence: ");
        String seq1 = in.nextLine();
        validSeq = validate(seq1);
        
        while (!validSeq) {
            System.out.println("\nInvalid sequence; try again.");
            System.out.println("Enter first nucleotide sequence: ");
            seq1 = in.nextLine();
            validSeq = validate(seq1);
        }
        
        //Asks for and validates string input
        System.out.println("\nEnter second nucleotide sequence: ");
        String seq2 = in.nextLine();
        validSeq = validate(seq2)     ;
        
        while (!validSeq) {
            System.out.println("\nInvalid sequence; try again.");
            System.out.println("Enter second nucleotide sequence: ");
            seq2 = in.nextLine();
            validSeq = validate(seq2);
        }
        
        int n = seq1.length();
        int m = seq2.length();
        
        int[][] sm = new int[n+1][m+1];
        sm[n][m] = 0;
        
        //Sets initial values for last column of matrix
        //These values reflect the penalty for a gap
        for (int i=n-1; i>=0; i--)
            sm[i][m] = 2 + sm[i+1][m];
        
        //Sets initial values for last row of matrix
        //These values reflect the penalty for a gap
        for (int i=m-1; i>=0; i--)
            sm[n][i] = 2 + sm[n][i+1];
        
        //Using DP, sets the rest of the values of the matrix
        //A mismatch adds 1 to the cost, and a gap adds 2
        for (int j=m-1; j>=0; j--) {
            for (int i=n-1; i>=0; i--) {
                if (seq1.charAt(i)==seq2.charAt(j)) {
                    sm[i][j] = sm[i+1][j+1];
                }
                else
                    sm[i][j] = min(2 + sm[i+1][j], 2 + sm[i][j+1], 1 + sm[i+1][j+1]);
            }
        }
        
        printMatrix(sm);
        System.out.println("First Sequence = " + seq1);
        System.out.println("Second Sequence = " + seq2);
        System.out.println("Optimal Alignment Distance = " + sm[0][0]);
        
    }
    
    public static void printMatrix(int[][] m) {
        System.out.println("\nDP Matrix for Seq 1 and Seq 2:");
        for (int i = 0; i<m.length; i++) {
            for (int j = 0; j<m[i].length; j++) {
                System.out.printf("[%2d] ", m[i][j]);
            }
            System.out.println("\n");
        }
    }
    
    public static int min(int a, int b, int c) {
        int min = a;
        if (b<min)
            min = b;
        if (c<min)
            min = c;
        return min;
    }
    
    public static boolean validate(String s) {
        if (s.isEmpty())
            return false;
        
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i)!='A' && s.charAt(i)!='C' && s.charAt(i)!='T' && s.charAt(i)!='G')
                return false;
        }
        return true;
    }
    
}
