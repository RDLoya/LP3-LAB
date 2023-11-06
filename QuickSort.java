import java.util.*;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {5, 1, 9, 3, 7, 6, 8, 2, 4};

        // Clone the original array for both variants
        int[] arrDeterministic = arr.clone();
        int[] arrRandomized = arr.clone();

        System.out.println("Original Array: " + Arrays.toString(arr));
        
        long startTime = System.nanoTime();
        quicksortDeterministic(arrDeterministic, 0, arrDeterministic.length - 1);
        long endTime = System.nanoTime();
        long durationDeterministic = endTime - startTime;
        System.out.println("Deterministic Quick Sort Result: " + Arrays.toString(arrDeterministic));
        System.out.println("Time taken for deterministic variant: " + durationDeterministic + " nanoseconds");

        startTime = System.nanoTime();
        quicksortRandomized(arrRandomized, 0, arrRandomized.length - 1);
        endTime = System.nanoTime();
        long durationRandomized = endTime - startTime;
        System.out.println("Randomized Quick Sort Result: " + Arrays.toString(arrRandomized));
        System.out.println("Time taken for randomized variant: " + durationRandomized + " nanoseconds");
    }

    public static void quicksortDeterministic(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partitionDeterministic(arr, low, high);
            quicksortDeterministic(arr, low, pi - 1);
            quicksortDeterministic(arr, pi + 1, high);
        }
    }

    public static int partitionDeterministic(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void quicksortRandomized(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partitionRandomized(arr, low, high);
            quicksortRandomized(arr, low, pi - 1);
            quicksortRandomized(arr, pi + 1, high);
        }
    }

    public static int partitionRandomized(int[] arr, int low, int high) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(high - low + 1) + low;
        int temp = arr[randomIndex];
        arr[randomIndex] = arr[high];
        arr[high] = temp;
        return partitionDeterministic(arr, low, high);
    }
}
//Time complexity for Deterministic Quick Sort is O(n^2)
//Time complexity for Randomized Quick Sort is O(n logn)
//Space complexity for both is O(log n)
