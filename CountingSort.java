package ie.atu.sw;

public class CountingSort extends Algorithm {
    public CountingSort() {
        algorithm = "CountingSort";
    }

    public int[] run(int[] arr) {

        int maxValue = getMaxValue(arr); // helper function that finds the maximum value in the input array arr.
        int[] SortedArray = new int[arr.length]; 
        int[] tempArray = new int[maxValue + 1]; 

        
        for (int i = 0; i < arr.length; i++) { //iterates through the input array arr and counts the occurrences of each element
            tempArray[arr[i]] = tempArray[arr[i]] + 1; //updates the tempArray by incrementing the count for each element
        }
        
        for (int i = 1; i < maxValue + 1; i++) { //calculates the cumulative sum of the counts in tempArray
            tempArray[i] = tempArray[i] + tempArray[i - 1];
        }
        
        for (int i = (arr.length - 1); i >= 0; i--) { //iterates in reverse order through the input array arr
            SortedArray[tempArray[arr[i]] - 1] = arr[i]; //places each element in its sorted position in the SortedArray
            tempArray[arr[i]] = tempArray[arr[i]] - 1;
        }
        return SortedArray; //return result
    }

    private int getMaxValue(int[] arrayToSort) {
        int maxVal = Integer.MIN_VALUE; // initialise variable maxVal to minimum possible value
        for (int i : arrayToSort) { // for loop that iterates through each element i in the input array arrayToSort.
            if (i > maxVal) { //If the element i is greater than the current maxVal, it means i is the new maximum value found so far.
                maxVal = i; // maxVal is updated to store the new maximum value.
            }
        }
        return maxVal; // maxVal result
    }
}
