import java.util.Scanner;

public class Fibby {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("This program prints all fibonacci numbers up to fibonacci(n).");
        System.out.println("Enter a number:");

        int n = Integer.parseInt(in.nextLine());
        in.close();

        for (int i=1; i<=n; i++) {
            System.out.println("The fibonacci number at fibonacci(" + i+ ") is " + plainFib(i));
        }
    }

    public static int plainFib(int n) {
        if (n==1 || n==2)
            return 1;
        else

            return plainFib(n-1) + plainFib(n-2);
    }
}