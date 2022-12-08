/*  Jan Leo Ras
 *   CSCI 3250-05 Fall 2021
 *   Dr. Samadidana
 *   Assignment 3 - Recursion
 */
package recursion;

public class JanRasA3 {

    public static void main(String[] args) {

        //Problem 1: Double or Nothing
        int[][] arraySet;

        int[] array1 = {1};
        int[] array2 = {1, 2};
        int[] array3 = {0, 0, 1};
        int[] array4 = {2, 3, 4};
        int[] array5 = {1, 3, 5, 10};
        int[] array6 = {1, 3, 5, 11};
        int[] array7 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] array8 = {9, 8, 7, 6, 12, 4, 3, 2, 1};

        arraySet = new int[][]{array1, array2, array3, array4, array5, array6, array7, array8};

        System.out.println("Problem 1: Double or Nothing.");
        for (int i = 0; i < arraySet.length; i++) {
            System.out.print((i + 1) + ". ");
            for (int x : arraySet[i]) {
                System.out.print(x + " ");
            }
            System.out.println(doubleOrNothing(arraySet[i], 0));
        }

        //Problem 2: Word Separator
        System.out.println("\nProblem 2: Word Separator. )");
        System.out.println("1. count = 4: " + wordSeparator("[Y]", "X", 4));
        System.out.println("2. count = 2: " + wordSeparator("[Y]", "X", 2));
        System.out.println("3. count = 1: " + wordSeparator("[Y]", "X", 1));
        System.out.println("4. count = 0: " + wordSeparator("[Y]", "X", 0));

        //Problem 3: McNugget Number
        System.out.println("\nProblem 3: McNugget Number.");
        for (int i = 0; i <= 16; i++) {
            System.out.println((i + 1) + ". " + i + " = " + mcNuggetNumber(i));
        }

        //Problem 4: Split the Array
        int[][] arraySet2;

        int[] s1 = {5,5,4,1,1};
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

        arraySet2 = new int[][]{s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13};

        //Problem 4: Split the Array
        //Part 1 - Get the sum
        System.out.println("\nProblem 4: Split the Array\n\n1 - Find sum of array.");
        for (int i = 0; i < arraySet2.length; i++) {
            System.out.print(i + 1 + ". {");
            for (int x : arraySet2[i]) {
                System.out.print(" " + x + " ");
            }
            System.out.println("} = " + getSum(arraySet2[i], 0, 0));
        }
        //Part 2 - Attempt to find subarray
        System.out.println("\n2 - Can the array be split?");
        for (int i = 0; i < arraySet2.length; i++) {
            System.out.println(i + 1 + ". " + splitTheArray(arraySet2[i], 0, getSum(arraySet2[i], 0, 0) / 2));
        }
    }

//    Suppose we have an array of integers. Write a method which returns true 
//    if the array contains somewhere a value and the next value is doubled.
//    The value could exist anywhere in the list and there could be multiple instances.
//    You need to detect if there is at least one instance of 
//    this circumstance. At a minimum , the list will contain one integer.
    public static boolean doubleOrNothing(int[] array, int index) {
        int maxIndex = array.length - 1;
        int firstItem = array[index];
        int nextIndex = index + 1;

        if (index == maxIndex) 
            return false;
        if (firstItem * 2 == array[nextIndex])
            return true;
        else 
            return doubleOrNothing(array, nextIndex);
    }

//    Given two strings , word and a separator sep, return a big string 
//    made of count occurrences of the word, separated by the separator string.
//    If the count is 0, return an empty string.If the count is 1, return word.     
    public static String wordSeparator(String word, String sep, int count) {
        if (count == 0) 
            return "";
        if (count == 1) 
            return word;
        else 
            return word + sep + wordSeparator(word, sep, count - 1);
    }

//    A McNugget Number is a number of Chicken McNuggets which can be purchased at McDonalds. 
//    In a fictional McDonald’s somewhere in the Universe, 
//    you can purchase the following orders of McNuggets:
//    •	3-piece
//    •	7-piece
//    For example, 10 is a McNugget Number because you can buy a 3-piece and a 7-piece McNuggets.
//    Your task is to write a recursive method which will report of a number is a McNugget number.
    public static boolean mcNuggetNumber(int n) {
        if (n < 3) 
            return false;
        if (n == 3 || n == 7) 
            return true;
        else 
            return (mcNuggetNumber(n - 7) || mcNuggetNumber(n - 3));
    }
    
//    Given an array of integers, can you evenly divide the list into two arrays, 
//    each with a sum equal to half of the original? 
//    You don’t have return the two smaller arrays. 
//    You need to return true if it can be done and false otherwise. 
     public static int getSum(int[] array, int index, int sum) {
        if (array.length == 0)                  //base case: return 0 for an empty array
            return 0;
        else if (index == array.length - 1)     //base case: if the last item is reached, add the last item to the sum
            return sum + array[index];
        else                                    //recursive case: add the next item in the array, array[index +1] and call the function again
            return getSum(array, index + 1, sum + array[index]);
    }
    
    public static int getLargestItem(int[] array, int n, int largest, int target) {
        if (array.length == 0)                  //base case: if array is empty, return 0
            return 0;
        if (n == array.length)                  //base case: if the entire array has been searched, return the current largest item
            return largest;
        else if (array[n] <= target && array[n] > largest) 
        //during traversing, check that the current array item is larger than the current largest, but less than the target
        //if array = {2,2,10,10,1,1} starting index = 0 and target = 13, first largest item is 10
        //if array = {2,2,10,10,1,1} starting index = 1 and target = 13-10 = 3, largest item is 2
            largest = array[n];
        //recursive case: check next item in array
        return getLargestItem(array, n + 1, largest, target);    
    }

    public static boolean splitTheArray(int[] array, int n, int target) {
        
        //  if the sum of the array is odd 
        //  or the iteration is completed without reducing reaching the next base case
        //  the array does not contain a subarray that equals to half of original,
        //  and the array cannot be split
        if (getSum(array, 0, 0) % 2 > 0 || n > array.length)
            return false;
        //  if the last largest integer in the subarray can be used to reduce the target to 0,
        //  there exists a subarray that is half of the original
        if (target == 0)
            return true;
        //  recursive case: reduce the target by the next largest integer
        else 
            target = target - getLargestItem(array, n, 0, target);
        return (splitTheArray(array, n + 1, target));
    }
}
