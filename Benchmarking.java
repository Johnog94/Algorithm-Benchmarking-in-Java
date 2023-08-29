package ie.atu.sw;


import java.util.Arrays;
import java.util.List;

//A class to implement Benchmarking of Algorithms and print its output to the console
public class Benchmarking {
	final int No_of_Tests = 10; // Number of test to be run on each algorithm
    //The input sizes to be tested are specified in the list below
    private List<Integer> inputSizes = Arrays.asList(100, 500, 1000, 2000, 5000, 10000, 20000, 50000);

    private List<Algorithm> algorithms =
            Arrays.asList(
                    new BubbleSort(), //Call the Bubble Sort Algorithm
                    new CountingSort(), //Call the Counting Sort Algorithm
                    new InsertionSort(), //Call the Insertion Sort Algorithm
                    new QuickSort(), //Call the Quick Sort Algorithm
                    new SelectionSort() //Call the Selection Sort Algorithm
            );

    public void runTests() throws Exception {
        System.out.println("Name-----, size----, time----"); //Output to console

        for (int i = 0; i < inputSizes.size(); i++) {
            int inputSize = inputSizes.get(i);
            int[] array = randomArray(inputSize); //Put the input size into the random array

            for (int j = 0; j < algorithms.size(); j++) {
                Algorithm algo = algorithms.get(j); //Apply the algorithm

                long totalRunningTime = 0L;
                for (int k = 0; k < No_of_Tests; k++) {
                    int[] testArray = array.clone(); //Clone ensures an exact copy of input array for each algorithm
                    Timer timer = new Timer();

                    timer.startTimer(); //Start timer
                    int[] sortedArray = algo.run(testArray); //Sort array
                    timer.endTimer(); //End timer

                    long elapsedTime = timer.elapsedTime(); //Calculate the elapsed time
                    totalRunningTime += elapsedTime;
                    confirmSorted(sortedArray);

                }

                String result = algo.algorithm + "---" +
                        inputSize + "-------" +
                        totalRunningTime / No_of_Tests;
                System.out.println(result); //Output the average result
            }
        }
    }
    
    private void confirmSorted(int[] sortedArray) throws Exception {
        for (int i = 0; i < sortedArray.length - 1; i++) {
            if (sortedArray[i] > sortedArray[i + 1]) {
                throw new Exception("Array not sorted");
            }
        }
    }
    //The method randomArray() takes as input a value n and returns an array
    // of n randomly generated integers with values between 0 and 99.
    // Sourced from Computational Thinking with Algorithms - Benchmarking in Java lecture notes - Dominic Carr
    private int[] randomArray(int n) {
        int[] array = new int[n]; //Create an array of size n
        for (int i = 0; i < n; i++) { //Loop over the above array
            array[i] = (int) (Math.random() * 100); //Math.random returns a random number
        }
        return array;
    }


}