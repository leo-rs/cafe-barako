package assignment4_2;

/**
 *
 * @author Shamarcus Dillon
 */

import java.util.Scanner;

public class DillonAssign4 {

    public static void main(String[] args) {
        
        double launchAngle, initVel, initHeight, timeInt;
        Ball myBall = new Ball();
        
        System.out.println("Welcome to Shamarcus Dillon's ball simulator!");
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Please enter the angle in degrees: ");
        launchAngle = Double.parseDouble(keyboard.nextLine());
        
        System.out.println("Please enter the initial velocity: ");
        initVel = Double.parseDouble(keyboard.nextLine());
        
        System.out.println("Please enter the initial height: ");
        initHeight = Double.parseDouble(keyboard.nextLine());
        
        System.out.println("Please enter the time interval: ");
        timeInt = Double.parseDouble(keyboard.nextLine());
        
        myBall.initialize(launchAngle, initVel, initHeight);
        
        while(myBall.getVDist() > 0) {
            myBall.update(timeInt);
        }
        
        System.out.println("Distance traveled: " + myBall.getHDist());
    }
}
