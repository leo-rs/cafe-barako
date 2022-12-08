
package knapsack;

public class KnapsackProblem {
    
    static int knapsackCapacity = 10;

    public static void main(String[] args) {
        
        int[] price = {700, 400, 200, 300, 600};
        int[] weight = {5, 1, 3, 2, 4};
        
        //rows = number of items, indexed 0 to size-1
        //columns = weight capacity of knapsack, incremented by 1, from 0 to knapsackCapacity+1
        int[][] knapsackMatrix = new int[price.length][knapsackCapacity+1];
        
        dynamicProg(price, weight, knapsackMatrix);
        
        
    }
    
    public static void dynamicProg(int[] price, int[] weight, int[][] ksMatrix) {
        int numItems = ksMatrix.length;
        int currItemWeight, currItemPrice;
        
        for (int i=0; i<numItems; i++) {
            currItemWeight = weight[i];
            currItemPrice = price[i];
            for (int w=0; w<=knapsackCapacity; w++) {
                //at weight=0, no items can be considered
                if (w==0)
                    ksMatrix[i][w] = 0;
                else {
                    //check if this item can be considered at the current weight limit
                    int diff = w-currItemWeight;
                    //check if this item has another item before it
                    int bound = i-1;
                    if (bound < 0)
                        bound = 0;
                    //if item cannot be considered due to weight;
                    //take max between value of the previous items
                    if (diff<0) 
                        ksMatrix[i][w] = ksMatrix[bound][w];//check this
                    //if item can be considered;
                    //take max between value when not taking and when taking item
                    else
                        ksMatrix[i][w] = max(ksMatrix[bound][w], ksMatrix[bound][diff] + currItemPrice);
                }
            }
        }
        
        System.out.println("Knapsack Problem using Dynamic Programming");
        System.out.print("---------|items|-------- ");
        for (int i=0; i<=knapsackCapacity; i++) {
            System.out.printf("|%5d|", i);
        }
        System.out.println("")    ;
        for (int i=0; i<ksMatrix.length; i++) {
            System.out.printf("Price: $%4d, Weight: %2d ", price[i], weight[i]);
            for (int x:ksMatrix[i]) {
                System.out.printf("|$%4d|", x);
            }
            System.out.println("");
        }
    }
    
    //not complete
    public static void fractionalKnapsack(int[] price, int[] weight) {
        double[] valueRatio = new double[price.length];
        
        for (int i=0; i<valueRatio.length; i++) {
            valueRatio[i] = price[i]/weight[i];
            System.out.println(valueRatio[i]);
        }
        
        quickSort(valueRatio, 0, valueRatio.length-1);
        
    }
    
    public static void quickSort(double arr[], int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }
    
    public static int partition(double arr[], int low, int high) {

        double pivot = arr[high];
        int pivotIndex = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                pivotIndex++;
                double temp = arr[pivotIndex];
                arr[pivotIndex] = arr[j];
                arr[j] = temp;
            }
        }
        double temp = arr[pivotIndex + 1];
        arr[pivotIndex+ 1] = arr[high];
        arr[high] = temp;

        return pivotIndex + 1;
    }
        
    public static int max(int firstVal, int secondVal) {
        if (firstVal >= secondVal)
            return firstVal;
        else
            return secondVal;
    }
    
}
