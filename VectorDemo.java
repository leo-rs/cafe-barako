

package mainp;



/**
 *
 * @author Saeid SamadiDana
 */
public class VectorDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        MyVector<Integer> intV= new MyVector(Integer.class);
        
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
