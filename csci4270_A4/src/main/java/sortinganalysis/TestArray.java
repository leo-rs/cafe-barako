
package sortinganalysis;

public class TestArray {

    static int msCalls;
    static int qsCalls;
    
    public static void main(String[] args) {
        
        RandomArray n = new RandomArray();
        
        //n.printArrays();
        //n.copyToFile();
        
//        for (int x:n.getArray(2)) {
//            System.out.println(x);
            
            
        int[] array = n.getArray(0);
        mergeSort(array,1000);
        
//        for (int x:array) 
//            System.out.println(x);
        
        
        System.out.println("Total time (unsorted): " + msCalls);
        msCalls = 0;
        
        mergeSort(array,1000);
        System.out.println("Total time (sorted): " + msCalls);
        
        
        int[] array2 = n.getArray(1);
        quickSort(array2,0,999);
        System.out.println("Total time (unsorted): " + qsCalls);
        qsCalls = 0;
        
        quickSort(array2,0,999);
        System.out.println("Total time (sorted): " + qsCalls);
    }
        
    
    
    public static void mergeSort(int[] arr, int size ) {
        
        //msCalls++;
        
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
                main[a]=left[l];
                l++;
                
                msCalls++;
            } else {
                main[a]=right[r];
                r++;
                
                msCalls++;
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
    
    public static void quickSort(int[] arr, int start, int end) {
        
        int pivotIndex;
        
        if (start<end) {
            
            pivotIndex = partition(arr,start,end);
            quickSort(arr,start, pivotIndex-1);
            quickSort(arr, pivotIndex+1,end);
        }
    }
    
    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int pIndex = start;
        int temp;
        
        for(int i=start+1;i<end;i++) {
            if (arr[i]<pivot) {
                temp = arr[i];
                arr[i] = arr[pIndex];
                arr[pIndex] = temp;
                pIndex++;
                
            qsCalls++;
            }
        }
        temp = pivot;
        arr[start] = arr[pIndex];
        arr[pIndex] = temp;
        
        return pIndex;
    }
    
}

   
