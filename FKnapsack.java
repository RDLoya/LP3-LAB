import java.util.*;
public class FKnapsack
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the value: ");
        int n = sc.nextInt();

        //values
        int[] v = new int[n];
        System.out.print("Please enter " + n + " values separated by spaces: ");
        for(int i=0; i<n; i++)
        {
            v[i] = sc.nextInt();
        }

        //weights
        int[] w = new int[n];
        System.out.print("Please enter " + n + " weights separated by spaces: ");
        for(int i=0; i<n; i++)
        {
            w[i] = sc.nextInt();
        }

        //capacity
        System.out.print("Please enter the capacity: ");
        int cap = sc.nextInt();
        Item[] items = new Item[n];
        for(int i=0; i<n; i++)
        {
            double r = (v[i] * 1.0)/ w[i];
            Item item = new Item(v[i], w[i], r);
            items[i] = item;
        }
        //ascending order sort on basis of ratios -> r
        Arrays.sort(items);

        double vib = 0;
    int rc = cap;

    //main traversal
    for(int i=n-1; i>=0; i--)
    {
        if(rc == 0)
        {
            break;
        }
        if(items[i].wt <= rc)
        {
            vib += items[i].val;
            rc -= items[i].wt;
        }
        else
        {
            vib += items[i].val * ((double)rc / items[i].wt);
            rc = 0;
            break;
        }
    }
    System.out.println(vib);
    }

    
    public static class Item implements Comparable<Item>
    {
        int val;
        int wt;
        double r;

        Item(int val, int wt, double r)
        {
            this.val = val;
            this.wt = wt;
            this.r = r; 
        }

        public int compareTo(Item o)
        {
            if(this.r > o.r)
            {
                return 1;
            }
            else if(this.r < o.r)
            {
                return -1;
            }
            else
            {
                return 0;
            }
        }
    }    
}

//Time complexity is O(n) and space complexity is O(n^2)

// Please enter the value: 10
// Please enter 10 values separated by spaces: 33 14 50 9 8 11 6 40 2 15
// Please enter 10 weights separated by spaces: 7 2 5 9 3 2 1 10 3 3
// Please enter the capacity: 5
// 50.0
