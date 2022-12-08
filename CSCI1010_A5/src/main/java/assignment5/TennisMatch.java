package assignment5;

import java.lang.Math.*;

public class TennisMatch {
    
    private int setsToWin;
    private double p1WinProb, p2WinProb;
    private int pServing;
    private int p1GamesWon, p2GamesWon;
    private int p1SetsWon, p2SetsWon;
    private String setResults;
    
    public TennisMatch(int sets, double p1prob, double p2prob) {
        setsToWin = sets;
        p1WinProb = p1prob;
        p2WinProb = p2prob;
        pServing = 1;
        p1GamesWon = p2GamesWon = p1SetsWon = p2SetsWon = 0;
        setResults = "";       
    }
    
    public void playMatch() {
        String winner = "";
        
        while(!this.matchOver()) {
            this.playSet();
        }
        
        if (p1SetsWon == setsToWin)
            winner = "Player 1 wins: ";
        else
            winner = "Player 2 wins: ";
            
        System.out.println(winner + setResults);
    }
    
    private void playSet() {
        p1GamesWon = p2GamesWon = 0;
        
        while (!this.setOver()) {
            this.playGame();
        }
        
        if (setOver() && p1GamesWon - p2GamesWon >= 2)
            p1SetsWon += 1;
        else
            p2SetsWon += 1;
        
        setResults += " " + p1GamesWon + "-" + p2GamesWon + " ";
    }
    
    private void playGame() {
        double randomNum = Math.random();
        
        if (pServing == 1) {
            if (randomNum <= p1WinProb)
                p1GamesWon += 1;
            else
                p2GamesWon += 1;
        }
        else {
            if (randomNum <= p2WinProb)
                p2GamesWon += 1;
            else
                p1GamesWon += 1;
        }
        
        if (pServing == 1)
            pServing = 2;
        else
            pServing = 1;
    }
    
    private boolean matchOver() {
        return (p1SetsWon == setsToWin) || (p2SetsWon == setsToWin);
    }
    
    private boolean setOver() {
        return (p1GamesWon >= 6 && (p1GamesWon - p2GamesWon >= 2)) ||
                (p2GamesWon >= 6 && (p2GamesWon - p1GamesWon >= 2));
    }
}
