

package sortinganalysis;

import java.util.Random;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RandomArray {
    Random r = new Random();
    
    int arrayHeight = 10000;
    int arrayLength = 1000;
    int[][] randomArray = new int[arrayHeight][arrayLength];
    
    public RandomArray() {
        for (int i=0;i<randomArray.length;i++) {
            for (int j=0;j<randomArray[0].length;j++) {
                randomArray[i][j] = r.nextInt(5000);
            }
        }
    }
    
    public int[] getArray(int index) {
        return randomArray[index];
    }
    
    public void printArrays() {
        int count = 0;
        for (int i=0;i<randomArray.length;i++) {
            for (int j=0;j<randomArray[0].length;j++) {
                System.out.println(randomArray[i][j]);
                count++;
            }
        }
        System.out.println("\n\n" + count);
    }
    
    public void copyToFile() {
        try {
            File f = new File("randomarrays.txt");
            FileWriter fw = new FileWriter("randomarrays.txt");
                
            for (int i=0;i<randomArray.length;i++) {
                for (int j=0;j<randomArray[0].length;j++) {
                    fw.write(randomArray[i][j] + " ");
                }
            }
        }
        catch (IOException e) {
            System.out.println("File error.");
        }
        
    }
}
    
    
    
        

