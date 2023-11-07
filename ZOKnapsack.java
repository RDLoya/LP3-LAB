import java.util.*;
public class ZOKnapsack 
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n = sc.nextInt();
        int[] vals = new int[n];
        int[] wts = new int[n];

        System.out.print("Enter the values of the items:");
        for(int i=0; i<vals.length; i++)
        {
            vals[i] = sc.nextInt();
        }

        System.out.print("Enter the weights of the items:");
        for(int i=0; i<wts.length; i++)
        {
            wts[i] = sc.nextInt();
        }

        System.out.print("Enter the capacity of the knapsack: ");
        int cap = sc.nextInt();

        int[][] dp = new int[n+1][cap+1];
        for(int i=1; i<dp.length; i++)
        {
            for(int j=1; j<dp[0].length; j++)
            {
                if(j >= wts[i-1])
                {
                    int rCap = j - wts[i-1];

                    if(dp[i-1][rCap] + vals[i-1] > dp[i-1][j])
                    {
                        dp[i][j] = dp[i-1][rCap] + vals[i-1];
                    }
                    else
                    {
                        dp[i][j] = dp[i-1][j];  //when i doesn't bat
                    }
                }
                else
                {
                    dp[i][j] = dp[i-1][j]; //when i doesn't bat
                }
            }
        }
        System.out.println("The maximum value that can be obtained is: " + dp[n][cap]);
    }
}


//Time and Space complexity is O(n*cap)

// Enter the number of items: 5
// Enter the values of the items:15 14 10 45 30
// Enter the weights of the items:2 5 1 3 4
// Enter the capacity of the knapsack: 7
// The maximum value that can be obtained is: 75
