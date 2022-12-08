
package assignment5;
import java.util.Scanner;

public class DillonAssign5 {

    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Welcome to Shamarcus Dillon's Tennis Match calculator. \n");
        
        int setsToWin;
        double p1prob, p2prob;
        char choice = 'Y';
        
        while (choice == 'Y') {
        
            System.out.println("Please enter the number of sets needed to win a match: ");
            setsToWin = Integer.parseInt(keyboard.nextLine());

            System.out.println("Please enter the probability of player 1 winning: ");
            p1prob = Double.parseDouble(keyboard.nextLine());

            System.out.println("Please enter the probability of player 2 winning: ");
            p2prob = Double.parseDouble(keyboard.nextLine());

            TennisMatch newMatch = new TennisMatch(setsToWin, p1prob, p2prob);
            newMatch.playMatch();
            
            System.out.println("Would you like to run another simulation? (Y/N): ");
            String stringChoice = keyboard.nextLine();
            while (!stringChoice.equals("Y") && !stringChoice.equals("N")) {
                System.out.println("\nPlease enter 'Y' for yes, 'N' for no. \nWould you like to run another simulation? (Y/N): ");
                stringChoice = keyboard.nextLine();
            }
            
            if (stringChoice.equals("Y"))
                choice = 'Y';
            else 
                choice = 'N';
                
        }
        
        System.out.println("\nThank you for using the tennis match simulator!");
        
    }
    
}
