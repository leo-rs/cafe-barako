/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author leo
 */
public class PracticeVectors {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        PracticeVectorsClass<Integer> intV = new PracticeVectorsClass(Integer.class);
        
        intV.push_back(5);
        intV.push_back(10);
        intV.push_back(10);
        intV.push_back(10);
        intV.push_back(10);
        intV.push_back(10);
        intV.push_back(10);
        intV.push_back(10);
        intV.push_back(10);
        intV.push_back(10);
        intV.push_back(10);
        intV.push_back(10);
        intV.push_back(10);
        intV.push_back(10);
        intV.push_back(10);
        intV.push_back(10);
        intV.push_back(20);
        
        
        for(int i=0;i<intV.getSize();i++){
            System.out.println(intV.at(i));
        }
        
        
        
    }
    
}
