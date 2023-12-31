
public class Fibonacci_Recursive
{
    public static int fib(int n)
    {
        if(n == 0 || n == 1)
        {
            return n;
        }

        int fnm1 = fib(n-1);
        int fnm2 = fib(n-2);
        int fn = fnm1 + fnm2;
        return fn;
    }
    public static void main(String args[])
    {
        int n = 6;
        for(int i=0; i<=n; i++)
        {
            System.out.println("The fibonacci numbers are: " +fib(i));
        }
    }
}

// Time complexity is O(2^n)
// Space Complexity is O(n)

// Enter the nth value
// 5
//  0 1 1 2 3 5
