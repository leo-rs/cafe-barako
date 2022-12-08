/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursiontest;

/**
 *
 * @author leo
 */
public class RecursionPracticeTest {

    /**
     * @param args the command line arguments
     * 
     * 
     * 
     */
    
    private static long calls=0;
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        int n = 50;
        for(int i=1;i<n;i++){
            calls = 0;
            System.out.printf("fibDP(%d)=%d\n", i, fibDP(i));
            System.out.println("calls=" + calls);
                    
        }
        System.out.printf("Sum of first %d natural numbers=%d", n, sum(n));
        System.out.printf("\nSum of first %d natural numbers=%d", n, sumR(n));
        
        int x = 9;
        System.out.println("\nThe fibonacci number at x = "+ x + " is " + fib(x));
    }
    
    private static int sum(int n){
        int sum=0;
        for(int i=1;i<=n;i++){
            
            sum+=i;
        }
        return sum;
    }
        
    private static int sumR(int n){
        if (n==1){
            return 1;
        }
        else {
            return n + sumR(n-1);
        }      
    }
    
    private static long fib(int n){
        calls++;
        if(n==1||n==2)
            return 1;
        else{
            return fib(n-1) + fib(n-2); 
            }
    }
    
    private static long fibDP(int n){
        if(n==1 || n==2)
            return 1;
        long[] data=new long[n];
        data[0]=1;
        data[1]=1;
        for(int i=2; i<n; i++){
            data[i]=data[i-1]+data[i-2];
            calls++;
        }
        return data[n-1];
    }
    
    //dynamic programming = store values as they are computed
    
    
    
}
