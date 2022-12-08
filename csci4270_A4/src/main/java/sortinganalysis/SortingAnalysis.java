package sortinganalysis;

import java.lang.Math;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class SortingAnalysis {
    
    static int mergeSortCalls;
    static int quickSortCalls;
    static int totalCalls;
    

    public static void main(String[] args) {
        
        RandomArray ms = new RandomArray();
        RandomArray qs = new RandomArray();
        Vector dataArr = new Vector();
        
        try {
            File qsArray = new File("quicksortarrays.txt");
            File msArray = new File("mergesortarrays.txt");
            
            FileWriter qsw = new FileWriter("quicksortarrays.txt");
            FileWriter msw = new FileWriter("mergesortarrays.txt");
            
            for (int i=0;i<10000;i++) {
                qsw.write("\n["+i+"]\n");
                for (int x: qs.getArray(i)) {
                    qsw.write(x + "\n");
                }
            }
            
            for (int i=0;i<10000;i++) {
                msw.write("\n["+i+"]\n");
                for (int x: ms.getArray(i)) {
                    msw.write(x + "\n");
                }
            }
            
            mergeSortCalls = 0;
            totalCalls = 0;
            
            int maxTime, minTime, currTime;
            int maxIndex, minIndex;
            
            maxIndex = minIndex = maxTime = currTime = 0;
            minTime = 10706;
            
            int[] dataPoints = new int[10000];
            
            for (int i=0;i<10000;i++) {
                mergeSort(ms.getArray(i), 1000);

                totalCalls += mergeSortCalls;
                currTime = mergeSortCalls;

                if (currTime>=maxTime) {
                    maxTime = currTime;
                    maxIndex = i;
                }
                if (currTime<minTime) {
                    minTime = currTime;
                    minIndex = i;
                }
                
                dataPoints[i] = currTime;
                mergeSortCalls = 0;
            }   
            
            System.out.println("\n------MERGE SORT------");
            System.out.println("Minimum runtime: " + minTime + " index[" + minIndex + "]");
            System.out.println("Maximum runtime: " + maxTime+ " index[" + maxIndex + "]");
            System.out.println("Average runtime: " + totalCalls/10000);
            System.out.println("Standard deviation: " + calculateSD(dataPoints));
            
            
            ////////////////////////////////////////////////////////////////////
            
            totalCalls = 0;
            maxIndex = minIndex = maxTime = currTime = 0;
            minTime = 10706;
            int[] dataPoints2 = new int[10000];
            
            for (int i=0;i<10000;i++) {
                quickSort(qs.getArray(i),0, 999);
                
                totalCalls += quickSortCalls;
                currTime = quickSortCalls;
 
                if (currTime>=maxTime) {
                    maxTime = currTime;
                    maxIndex = i;
                }
                if (currTime<minTime) {
                    minTime = currTime;
                    minIndex = i;
                }
                
                dataPoints[i] = currTime;
                quickSortCalls = 0;
            }
            
            quickSort(qs.getArray(0),0,999);
            
            System.out.println("\n------QUICK SORT------");
            System.out.println("Minimum runtime: " + minTime + " index[" + minIndex + "]");
            System.out.println("Maximum runtime: " + maxTime+ " index[" + maxIndex + "]");
            System.out.println("Worst-case runtime: " + quickSortCalls + " (sorted array)");
            System.out.println("Average runtime: " + totalCalls/10000);
            System.out.println("Standard deviation: " + calculateSD(dataPoints));
            System.out.println("\n");
            
            qsw.flush();
            msw.flush();
            qsw.close();
            msw.close();
        }
        catch (IOException e) {
            System.out.println("File error.");
        }

    }
    
    public static void mergeSort(int[] arr, int size ) {
        
        mergeSortCalls++;
        if (size<2) //array with one element, do nothing
            return;
        
        //divide array into two parts (middle split) by:
        //a) initializing two arrays
        //b) copying left side to array1, right side to array2
        
        int half = size/2;
        int[] left = new int[half];
        int[] right = new int[size-half];
        
        //copy array contents into respective halves
        
        for (int i=0;i<half;i++)
            left[i] = arr[i];
        for (int j=0;j<size-half;j++)
            right[j] = arr[half+j];
        
              
        //divide further
        mergeSort(left,half);
        mergeSort(right,size-half);
        
        //merge current array - array at the smallest allowed size
        merge(left, right, arr, half, size-half);
    }
    
    public static void merge(int[] left, int[] right, int[] main, int l_sz, int r_sz) {
        //initialize counters
        //l = counter for left array
        //r = counter for right array
        //a = counter for main array
        
        int a, l, r;
        a = l = r = 0;
        
        //compare arrays
        //lesser element takes position on main array
        while (l<l_sz && r<r_sz) {
            if (left[l]<right[r]) { 
                mergeSortCalls++;
                main[a]=left[l];
                l++;
            } else {
                main[a]=right[r];
                r++;
            }
            a++;
        }
        //add remaining elements (left or right) to main array
        while (l<l_sz) {
            main[a++]=left[l++];
        }
        while (r<r_sz) {
            main[a++]=right[r++];
        }
    }
    
    public static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }
    
    public static int partition(int arr[], int low, int high) {

        int pivot = arr[high];
        int pivotIndex = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                quickSortCalls++;
                pivotIndex++;
                int temp = arr[pivotIndex];
                arr[pivotIndex] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[pivotIndex + 1];
        arr[pivotIndex+ 1] = arr[high];
        arr[high] = temp;

        return pivotIndex + 1;
    }

    public static double calculateSD(int[] valArr)
    {
        double sum = 0.0, standardDeviation = 0.0;
        int length = valArr.length;
        for(int num : valArr) {
            sum += num;
        }
        double mean = sum/length;
        for(int num: valArr) {
            standardDeviation += Math.pow(num - mean, 2);
        }
        return Math.sqrt(standardDeviation/length);
    }
}
    

    

