/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsackproblem.datastructures;


public class Node implements Comparable<Node>{
    private int level;
    private int profit;
    private int weight;
    private float bound;
    
    public Node(int l, int p, int w) {
        level = l;
        profit = p;
        weight = w;
    }
    
    public Node() {}
    
    
    public void setLevel(int l) {
        level = l;
    }
    
    public void setProfit(int p) {
        profit = p;
    }
    
    public void setWeight(int w) {
        weight = w;
    }
    
    public void setBound(int w) {
        bound = w;
    }
    
    public int getLevel(){
        return level;
    }
    
    public int getProfit(){
        return profit;
    }
    
    public int getWeight(){
        return weight;
    }
    
    public float getBound(){
        return bound;
    }
    
    @Override
    public int compareTo(Node n) {
        if (this.bound > n.bound)
                return 1;
        else if (this.bound < n.bound)
                return -1;
        return 0;
    }
}
