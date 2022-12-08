
/**
 *
 * @author Shamarcus Dillon
 */
public class Assignment1_1010 {

    public static void main(String[] args) {
        //System.out.println("Hello World!");
    
    Customer customer1 = new Customer();
    Customer customer2 = new Customer();
    
    customer1.readInput();
    customer1.writeOutput();
    
    customer2.readInput();
    customer2.writeOutput();
    
    //test == methods
    
    if (customer1 == customer2)
    {
        System.out.println("Customer1 is equal to customer2 using the == operator");
    }
    else
    {
        System.out.println("Customer1 is not equal to customer2 using the == operator");
    }    
    
    //Tests equals that we built
    
    if (customer1.equals(customer2))
    {
        System.out.println("Customer1 is equal to customer2 using the equals method");
    }
    else
    {
        System.out.println("Customer1 is not equal to customer2 using the equals method");
    }        
    
    // Step 9
    if (customer1 == customer2)
    {
        System.out.println("Customer1 is equal to customer2 using the == operator");
    }
    else
    {
        System.out.println("Customer1 is not equal to customer2 using the == operator");
    }    
    
    customer2.setEmail("nobody@nowhere.com");
    
    customer1.writeOutput();
    
    
    
    }
}
