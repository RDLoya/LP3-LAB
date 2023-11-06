import java.util.*;
public class Fibonacci_Iterative
{
    public static void main(String args[])
    {
        int n, i, n1=0, n2=1, n3;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter nth value of fibonacci number");
        n = sc.nextInt();
        System.out.print(n1+" "+n2);
        for(i=2; i<n; ++i)
        {
            n3 = n1 + n2;
            System.out.print(" "+n3);
            n1 = n2;
            n2 = n3;
        }
    }
}