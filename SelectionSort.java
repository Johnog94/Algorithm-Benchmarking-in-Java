package ie.atu.sw;

public class SelectionSort extends Algorithm {
    public SelectionSort() {
        algorithm = "SelectionSort";
    }

    public int[] run(int[] arr) {
        int outer = 0, inner = 0, min = 0; //initialise variables to 0
        for (outer = 0; outer < arr.length - 1; outer++) { //iterates through the array arr from the first element to the second-to-last element (arr.length - 1). 
            min = outer; //variable min is initially set to outer, assuming that the current position holds the minimum value.
            for (inner = outer + 1; inner < arr.length; inner++) { //inner loop starts from the next element after the outer position and iterates through the remaining elements of the array.
                if (arr[inner] < arr[min]) { //If the value at index inner is less than the value at index min
                    min = inner; //the min variable is updated to store the index of the new minimum value found.
                }
            }
            //outer loop continues until all elements have been iterated and swapped, resulting in a sorted array
            int temp = arr[outer];
            arr[outer] = arr[min]; 
            arr[min] = temp; 
        }
        return arr; //return result
    }
}