
import java.util.Scanner;

/**
 * 
 * @author Shamarcus Dillon
 */
class Customer {

private String firstName;
private String lastName;
private String email;

public Customer()
{
    firstName = "";
    lastName = "";
    email = "";
}


public String getFirstName()
    {
        return firstName;
        
    }
public String getLastName()
    {
        return lastName;      
    
    }    
public String getEmail()
    {
        return email;
    }

public void setfirstName(String newFirstName)
   {
       firstName = newFirstName;
   }
public void setLastName(String newLastName)
   {
       lastName = newLastName;
   }     

public void setEmail (String newEmail)
   {
       email = newEmail;  
   }   

public void readInput()
   {
        
       Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the Customer's First Name:");
        firstName = keyboard.nextLine();
        System.out.println("Enter the Customer's Last Name:");
        lastName = keyboard.nextLine();
        System.out.println("Enter the Customer's Email Name:");
        email = keyboard.nextLine();
        
   }     

public void writeOutput()
   {
       System.out.println();
       System.out.println("First Name" + firstName);
       System.out.println("Last Name" + lastName);
       System.out.println("Email:" + email);        
   }
        
 private boolean hasSameNameAs(Customer othercustomer)
   {
       return firstName.equalsIgnoreCase(othercustomer.getFirstName())
               && lastName.equalsIgnoreCase(othercustomer.getLastName());
   }      
        
 private boolean hasSameEmailAs(Customer othercustomer)     
   {
       return email.equalsIgnoreCase(othercustomer.getEmail());
       
   }     

 public boolean equals(Customer othercustomer)
   {
 return this.hasSameNameAs(othercustomer) && this.hasSameEmailAs(othercustomer);
 
   }
 
 
 
 
 
 
 
 
}


