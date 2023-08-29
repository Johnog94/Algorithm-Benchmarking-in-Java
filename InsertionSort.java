package ie.atu.sw;

public class InsertionSort extends Algorithm {
    public InsertionSort() {
        algorithm = "InsertionSort";
    }

    public int[] run(int[] arr) { //The run method takes an array (arr) as input and performs an insertion sort on it.
        for (int i = 1; i < arr.length; i++) { //The algorithm iterates through the array starting from the second element (i = 1) up to the last element
            int key = arr[i]; //For each iteration, the current element (key) is stored 
            int j = i - 1; //variable (j) is set to the index of the previous element (i - 1).
            while (j >= 0 && arr[j] > key) { //while loop which continues as long as j is greater than or equal to 0 and the element at index j is greater than the key element
                arr[j + 1] = arr[j]; //Inside the while loop, the element at index j is shifted one position to the right (arr[j + 1] = arr[j]), effectively making space for the key element
                j = j - 1; //The value of j is decremented (j = j - 1) to continue comparing the key element with the previous elements
            }
            arr[j + 1] = key; //Once the while loop ends, the key element is inserted into its correct position by assigning it to arr[j + 1]
        }
        return arr; //sorted array is returned as the output of the run method
    }
}
