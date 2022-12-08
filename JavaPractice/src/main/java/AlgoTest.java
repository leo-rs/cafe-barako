
public class AlgoTest {

    
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println(sums(1,10));
        
        int[] a = { 1, 0, 0, 0};
        int[] b = { 0, 0, 0, 1};
        int[] c = { 0, 0, 0, 1};
        int[] d = { 1, 0, 0, 1};
        
        int[][] m = {a, b, c, d};
        
        System.out.println(checkFunc(m));
    }
    
    
    public static int sums(int a, int b) {
        int sum = 0;
        while (a<=b) {
            sum +=a;
            a++;
    }
        return sum;
    }
        
    public static boolean checkRef(int[][] a) {
        boolean ref = true;
        for (int i = 0; i< a.length; i++) { 
                if (a[i][i]==0)
                    return false;
        }
        return ref;
    }
    
    public static boolean checkFunc(int[][] a) {
       
        int sum = 0;
        for (int i=0; i<a.length; i++) {
            for (int j=0; j<a[0].length; j++) {
                sum += a[i][j];
                System.out.println(sum);
                if (sum>1)
                    return false;
                
            }
            if (sum==0)
                return false;
            sum = 0;
        }
        return true;
    }
            
                
            
}
