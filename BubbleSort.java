package ie.atu.sw;

public class BubbleSort extends Algorithm { 
    public BubbleSort() {
        algorithm = "BubbleSort";
    }

    public int[] run(int[] arr) { //The run method takes an array (arr) as input and performs a bubble sort on it
        int n = arr.length; 
        int temp = 0; 
        for (int i = 0; i < n; i++) { //outer loop that iterates from the beginning of the array (i = 0) to the end.
            for (int j = 1; j < (n - i); j++) { //inner loop that iterates from the second element (j = 1) to the last unsorted element in the array (n - i)
                if (arr[j - 1] > arr[j]) { //each iteration of the inner loop, the algorithm compares adjacent elements arr[j - 1] and arr[j]
                    temp = arr[j - 1]; //swap is done by storing the value of arr[j - 1] in a temporary variable (temp)
                    arr[j - 1] = arr[j]; //assign the value of arr[j] to arr[j - 1]
                    arr[j] = temp; //assign the value of temp to arr[j]
                }
            }
        }
        return arr; // sorted array is returned as the output of the run method
    }
}
