/*   Jan Leo Ras
 *   CSCI 4270 Spring 2022
 *   Dr. Samadidana
 *   Assignment 6 - Knapsack Problem
 */


package knapsackproblem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Vector;
import knapsackproblem.datastructures.*;

public class Knapsack {
    
    static int numItems = 5;
    static int maxWeight;
    static int maxProfit;
    
    static int[] profit = new int[5];
    static int[] weight = new int[5];
    static int[] sorted = new int[5];
    
    static int numbest;
    
    static int breadthfirstcounter = 100;
    static int bestfirstcounter = 1;
    
    static int maxop;
    static int minop = 14;
    static int currop = 1;
    static Vector<Integer> dataPoints = new Vector();
    
    public static void main(String[] args) {
        
        createKnapsackProblems(100);
        readProblems(100);
        
        System.out.println("\n\n--- 0-1 Knapsack Using Breadth-First Branch and Bound (100 Knapsacks) ---");
        System.out.println("Minimum operations: " + minop);
        System.out.println("Maximum operations: " + maxop);
        System.out.println("Average operations: " + breadthfirstcounter/100);
        System.out.println("Standard deviation: " + calculateSD(dataPoints));
        
        //System.out.println("Max (Best-First) = " + knapsackBestFirst(profit, weight, maxWeight));
        //System.out.println(bestfirstcounter);
    }
    
    public static void createKnapsackProblems(int n) {
        Random r = new Random();
        int[][] pwTable = new int[numItems][2];
        int maxW;
        
        try {
            File f = new File("knapsackproblems.txt");
            FileWriter fw = new FileWriter("knapsackproblems.txt");

            for (int j = 0; j < n; j++ ) {
                maxW = 20 + r.nextInt(6);
                fw.write(maxW + "\n");
                
                for (int i = 0; i < pwTable.length; i++ ) 
                {
                    pwTable[i][1] = r.nextInt(10) + 1;
                    pwTable[i][0] = pwTable[i][1] * (20 - 2 * i);
                    
                    fw.write(pwTable[i][0] + "," + pwTable[i][1] + "\n");
                }
                //fw.write("\n");
            }
            fw.close();
        } catch (IOException ex) {
            System.out.println("File not found.");
        }
    }
    
    public static void readProblems(int n) {
        String pw;
        String[] pws;
        int totalp;
        int totalw;
        
        try {
            File f = new File("knapsackproblems.txt");
            Scanner scan = new Scanner(f);
            for (int i = 0; i < n; i++) {
                maxWeight = Integer.parseInt(scan.nextLine());
                totalp = totalw = 0;
                for (int j = 0; j < 5; j++) {
                    pw = scan.nextLine();
                    pws = pw.split(",");
                    profit[j] = Integer.parseInt(pws[0]);
                    weight[j] = Integer.parseInt(pws[1]);
                }
                System.out.println("W = " + maxWeight);
                for (int k = 0; k < 5; k++) {
                    
                    totalp += profit[k];
                    totalw += weight[k];
                    System.out.print("p = " + profit[k] + ", w = " + weight[k] + "\n");
                }
                System.out.println("Total = " + totalp + ", " + totalw);
                System.out.println("Max (Breadth-First) = " + knapsackBreadthFirst(profit, weight, maxWeight));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }
    }
    
    public static int knapsackBreadthFirst(int[] p, int[] w, int max) {
        //initialize maxProfit to 0
        int maxValue = 0;
        
        //create empty Queue
        Queue q = new Queue();
        
        //create root of decision tree and enqueue
        Node v = new Node(0,0,0);
        q.enqueue(v);
        
        Node u = new Node();
        
        while(!q.isEmpty()) {
            v = q.dequeue();
            
            if (v.getLevel() == 5)
                break;
            
            //compute profit of the next level node
            u.setLevel(v.getLevel() + 1);
            u.setWeight(v.getWeight() + w[u.getLevel() - 1]);
            u.setProfit(v.getProfit() + p[u.getLevel() - 1]);
            
            //if profit is more than current max, update max
            if (u.getWeight() <= max && u.getProfit() > maxValue)
                maxValue = u.getProfit();
            
            //check bound of this node, if more than max -- queue
            if (maxValue < bound(w, p, max, u)) {
                q.enqueue(u);
                breadthfirstcounter++;
                currop++;
            }
            
            u = new Node();
            
            //consider when this node is not considered -- queue
            u.setWeight(v.getWeight());
            u.setProfit(v.getProfit());
            
            if (maxValue < bound(w, p, max, u)) {
                q.enqueue(u);
                breadthfirstcounter++;
                currop++;
            }
        }
        System.out.println("Operations = " + currop);
        dataPoints.add(currop);
        
        if (currop > maxop)
            maxop = currop;
        if (currop < minop)
            minop = currop;
        currop = 1;
   
        return maxValue;
    }
    
    public static int bound(int[] w, int[] p, int max, Node n) {
        int result, totalWeight;
        int j = 0;
        
        if (n.getWeight() >= max)
            return 0;
        else {
            result = n.getProfit();
            j = n.getLevel() + 1;
            totalWeight = n.getWeight();
            while (j <= p.length-1 && totalWeight + w[j] <= max) {
                totalWeight += w[j];
                result += p[j];
                j++;
            }
            if (j <= p.length-1)
                result += (max - totalWeight) * p[j]/w[j];
            return result;
        }
    }
    
    public static int knapsackBestFirst(int[] p, int[] w, int max) {
        PriorityQueue<Node> pq = new PriorityQueue();
        
        Node u = new Node();
        Node v = new Node(0, 0, 0);
        
        int maxValue = 0;
        
        v.setBound(bound(w, p, max, v));
        
        pq.add(v);
        
        while(!pq.isEmpty()) {
            pq.remove(v);
            if (v.getBound() > maxValue) {
                u.setLevel(v.getLevel() + 1);
                u.setWeight(v.getWeight() + w[u.getLevel()]);
                u.setProfit(v.getProfit() + p[u.getLevel()]);
                
                if (u.getWeight() <= max && u.getProfit() > maxValue)
                    maxValue = u.getProfit();
                u.setBound(bound(w, p, max, u));
                
                if (u.getBound() > maxValue) {
                    pq.add(u);
                    bestfirstcounter++;
                }
                u = new Node();
                u.setWeight(v.getWeight());
                u.setProfit(v.getProfit());
                u.setBound(bound(w, p, max, u));
                
                if (u.getBound() > maxValue) {
                    pq.add(u);
                    bestfirstcounter++;
                }
            }
        }
        return maxValue;
    }
    
    public static double calculateSD(Vector<Integer> valArr)
    {
        int sum = 0;
        double standardDeviation = 0.0;
        int length = valArr.size();
        
        for (int i = 0; i < length; i++)
            sum += valArr.elementAt(i);
        
        double mean = sum/length;
        
        for(int num: valArr) {
            standardDeviation += Math.pow(num - mean, 2);
        }
        return Math.sqrt(standardDeviation/length);
    }
    
}
