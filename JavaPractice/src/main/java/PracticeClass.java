/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author leo
 */
public class PracticeClass {
    
    public static void main(String[] args){
        
       /*
        //declaring variables
        int n1, n2; 
        
        //printing Strings
        System.out.println("Hello World!"); 
        System.out.print("Leo");
        System.out.println(" " + "Ras");
        System.out.println(":)");
        
        //initialize Scanner object for input
        Scanner keyboardInput = new Scanner(System.in);
        
        n1 = keyboardInput.nextInt();
        n2 = keyboardInput.nextInt();
        
        System.out.println("The sum of these two numbers is: ");
        System.out.println(n1 + n2);
        
        String sentence = "The quick brown fox.";
        int position = sentence.indexOf("fox");
        System.out.println(sentence);
        System.out.println("fox starts at the #" + position + " character of "
                + "the above sentence.");
        
        sentence = sentence.substring(0, position) + "dog.";
        System.out.println(sentence);
        
        */
        
       /*loops
        boolean t = false;
        boolean f = false;
        
        
        if (t==true && f==false) {
            System.out.println("t = true, f = false.");
        }
        else if (t==true && f==true){
            System.out.println("t = true, f = true.");
        }
        else {
            System.out.println("t = false.");
        }
        
        for (int i = 0; i<10; i++) {
            System.out.println(i);
            for (int j = 0; j<2; j++) {
                System.out.println("(" + j + ")");
            }
        }
        */
        
        int counter = 10;
        while (counter>0) {
            System.out.println("While counter: " + counter);
            counter--;
        }
        int newCounter = 5;
        
        do {
            System.out.println("Do-while counter: " + newCounter);
            newCounter--;
        }
        while (newCounter>0);
        
    }
    
   
    
}
