/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

/**
 *
 * @author leo
 */
public class TestA3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int[][] arraySet2;
//
        int[] s1 = {1,4,4,4,1};
        int[] s2 = {2, 3};
        int[] s3 = {5, 2, 3};
        int[] s4 = {5, 2, 2};
        int[] s5 = {1, 1, 1, 1, 1, 1};
        int[] s6 = {1, 1, 1, 1, 1};
        int[] s7 = {};
        int[] s8 = {1};
        int[] s9 = {3, 5};
        int[] s10 = {5, 3, 2};
        int[] s11 = {2, 2, 10, 10, 1, 1};
        int[] s12 = {1, 2, 2, 10, 10, 1, 1};
        int[] s13 = {1, 2, 3, 10, 10, 1, 1};
//
        arraySet2 = new int[][]{s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13};

        //Problem 4: Split the Array
        //Part 1 - Get the sum
        System.out.println("\nFind sum of array.");
        for (int i = 0; i < arraySet2.length; i++) {
            System.out.print(i + 1 + ". {");
            for (int x : arraySet2[i]) {
                System.out.print(" " + x + " ");
            }
            System.out.println("} = " + getSum(arraySet2[i], 0, 0));
        }

        System.out.println("\nCan the array be split?");
        for (int i = 0; i < arraySet2.length; i++) {
            System.out.println(i + 1 + ". " + splitArray2(arraySet2[i], 0, getSum(arraySet2[i], 0, 0) / 2));
        }

    for(int x:s1)
        System.out.print(x + " ");
    System.out.print(" = " + getSum(s1,0,0) + "\n");
    System.out.println(splitTheArray(s1,0,getSum(s1,0,0)/2));
    }

    //this method returns the sum of a given array using recursion
    //array = array to be calculated, index = starting index, sum = totals, after every iteration
    public static int getSum(int[] array, int index, int sum) {
        if (array.length == 0)                  //base case: return 0 for an empty array
        {
            return 0;
        } else if (index == array.length - 1)   //base case: if the last item is reached, add the last item to the sum
        {
            return sum + array[index];
        } else {                                //recursive case: add the next item in the array, array[index +1] and call the function again
            return getSum(array, index + 1, sum + array[index]);
        }
    }
    
    //SOLVED
    public static boolean splitArray2(int[] array, int index, int remaining) {
        if (getSum(array,0,0)%2>0)
            return false;
        if (remaining==0)
            return true;
        if (index==array.length-1 && remaining !=0)
            return false;
        else
            return splitArray2(array, index+1, remaining) || splitArray2(array, index+1, remaining-array[index+1]);
    }
            

    //this method returns the largest item in a given array using recursion
    //array = given array, n = index counter, largest = current largest item, target = upper bound of largest item
    public static int getLargestItem(int[] array, int n, int largest, int target) {
        if (array.length == 0) {                                //base case: if array is empty, return 0
            return 0;
        }
        if (n == array.length) //base case: if the entire array has been searched, return the current largest item
        {
            return largest;
        } 
        else if (array[n] <= target && array[n] > largest) 
        //during traversing, check that the current array item is larger than the current largest, but less than the target
        //if array = {2,2,10,10,1,1} starting index = 0 and target = 13, first largest item is 10
        //if array = {2,2,10,10,1,1} starting index = 1 and target = 13-10 = 3, largest item is 2
        {
            largest = array[n];
            //array[n]=0;******
        }

        return getLargestItem(array, n + 1, largest, target);     //recursive case: check next item in array

    }

    //    Given an array of integers, can you evenly divide the list into two arrays, 
    //    each with a sum equal to half of the original? 
    //    You don’t have return the two smaller arrays. 
    //    You need to return true if it can be done and false otherwise. 
    public static boolean splitTheArray(int[] array, int n, int target) {

        //if the sum of the array is odd 
        //or, the target(half of the sum of array) becomes less than 0, 
        //meaning, the array does not contain a subarray that equals to half of original,
        //then, the array cannot be split, return false
        int sum = target;
        if (getSum(array, 0, 0) % 2 > 0 || target < 0 || n > array.length) {
            //System.out.println("Array cannot be split.");
            return false;
        }

        //if the last largest integer in the array can be used to reduce the target to 0,
        //there exists a subarray that is half of the original
        if (target == 0) {
            return true;
        } //recursive case: reduce the target by the next largest integer
        else {
            int largest = getLargestItem(array,n,0,target);
            
            System.out.println("index = " + n + ", subtract " + largest + " from " + sum);
            
            target = target - getLargestItem(array, n, 0, target);
        }
        return (splitTheArray(array, n + 1, target));
    }
}
