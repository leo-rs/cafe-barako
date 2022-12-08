/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsack;

/**
 *
 * @author leo
 */
public class ValuableItem {
    private String name;
    private int weight;
    private int value;
    
    public ValuableItem() {
        name = "";
        weight = value = 0;
    }
    
    public ValuableItem(String n, int w, int v) {
        name = n;
        weight = w;
        value = v;
    }
    
    public String getName() {
        return name;
    }
    
    public int getWeight() {
        return weight;
    }
    
    public int getValue() {
        return value;
    }
    
    @Override
    public String toString() {
        return "Name: " + name +
                "\nWeight: " + weight +
                "\nValue: " + value;
    }
    
}
