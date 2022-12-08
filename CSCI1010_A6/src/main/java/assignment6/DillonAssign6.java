
package assignment6;

import java.util.Scanner;

public class DillonAssign6 {

    public static void main(String[] args) {
        final int numTracks = 12;
        int trackLength, shortestTrack, longestTrack, totalLength, shortestTrackIndex, longestTrackIndex;
        trackLength = longestTrack = totalLength = shortestTrackIndex = longestTrackIndex = 0;
        shortestTrack = 1000;
        
        int[] trackLengths = new int[numTracks];
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Welcome to Shamarcus Dillon's Album Length Calculator");
        System.out.println("Please enter all track lengths in minutes and seconds, separated by a space.");
        
        for (int i = 0; i < numTracks; i++) {
            System.out.println("Track " + (i + 1) + ": ");
            trackLength = (keyboard.nextInt() * 60) + keyboard.nextInt();
            keyboard.nextLine();
            
            if (trackLength <= shortestTrack) {
                shortestTrackIndex = i + 1;
                shortestTrack = trackLength;
            } 
            if (trackLength >= longestTrack) {
                longestTrackIndex = i + 1;
                longestTrack = trackLength;
            }
            
            trackLengths[i] = trackLength;
        }
          
        System.out.println("\nThe shortest track is track #" + shortestTrackIndex + " at ");
        displayTime(shortestTrack);
        
        System.out.println("\nThe longest track is #" + longestTrackIndex + " at ");
        displayTime(longestTrack);
        
        System.out.println("\nThe total length of the album is: ");
        for (int i = 0; i < numTracks; i++) {
            totalLength += trackLengths[i];
        }
        displayTime(totalLength);
        
        System.out.println("\nThe average length of a track is: ");
        displayTime(totalLength/numTracks);
        
    }
    
    private static void displayTime(int totalSeconds) {
        String time = "";
        int minutes = totalSeconds/60;
        int seconds = totalSeconds%60;
        
        if (seconds < 10)
            System.out.print(minutes + ":0" + seconds);
        else
            System.out.print(minutes + ":" + seconds);
    }
}
