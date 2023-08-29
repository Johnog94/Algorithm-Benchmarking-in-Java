package ie.atu.sw;

public class QuickSort extends Algorithm {
    public QuickSort() {
        algorithm = "QuickSort";
    }

    public int[] run(int[] arr) {
        quickSort(arr, 0, arr.length - 1); // Call Quicksort operation, The range of the initial partition is from index 0 to arr.length - 1
        return arr;
    }

    private void quickSort(int[] arr, int p, int r) {
        if (p < r) { //checks if there are at least two elements in the partition
            int q = partition(arr, p, r); //partitions the array around a pivot element
            quickSort(arr, p, q - 1); //sorts the left subarray from index p to q - 1
            quickSort(arr, q + 1, r); //sorts the right subarray from index q + 1 to r
        }
    }

    private int partition(int[] a, int p, int r) {
        int temp; //temporarily store values during to be swapped
        int pivot = a[r]; //pivot element is chosen as the element at index r, which is the rightmost element of the current partition.
        int i = p - 1; // i is initialized to p - 1, which represents the index of the smaller elements
        for (int j = p; j < r; j++) { // for loop that iterates from index p to r-1.
            if (a[j] <= pivot) { // check a[j] is less than or equal to the pivot
                i++; //increment variable i
                temp = a[i]; //The elements at indices i and j are swapped by using the temporary variable temp
                a[i] = a[j];
                a[j] = temp;
            }
        }
        i++; //increment variable i
        temp = a[i]; //pivot element (a[r]) is swapped with the element at index i
        a[i] = a[r];
        a[r] = temp;
        return i; //return result
    }
}
