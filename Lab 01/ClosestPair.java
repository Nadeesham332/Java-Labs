package lk.ac.jfn.eng.ec4070.lab1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

/**
 * This class will find the closest pair(s) in a given sequence of double  values.
 * @author ASUS
 */
public class ClosestPair {

    /**
     * Method to print the unsorted and sorted array.
     * @param algoName Name of the algorithm used for sorting.
     * @param unsorted Unsorted double array
     * @param sorted  Sorted double array
     */
    public void printResult(String algoName, double[] unsorted, double[] sorted) {
        System.out.println("\n" + "Algorithm of : " + algoName);
        System.out.println("Unsorted Array : " + Arrays.toString(unsorted));
        System.out.println("Sorted Array : " + Arrays.toString(sorted));

    }
    
    /**
     * Optimized bubble sort technique with swapped flag and newLimit variable.
     * swapped flag - to track changes when comparing adjacent elements.
     * newLimit - to track the point upto which elements are swapped to sort.
     * @param arr input array to  sort
     * @return sorted double array
     */
    public double[] optimizedBubbleSort(double[] arr) {
        int n = arr.length - 1;
        boolean swapped;
        int newLimit = n;
        do {
            swapped = false;
            for (int i = 1; i <= n; i++) {
                if (arr[i - 1] > arr[i]) {
                    double temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                    swapped = true;
                    newLimit = i - 1;
                }
            }
            n = newLimit;
        } while (swapped);
        return arr;
    }

    /**
     * Method to find closest pair in a sorted sequence using ArrayList.
     * @param sortedArr sorted array as input
     */
    public void closestPair(double[] sortedArr) {
        int n = sortedArr.length;
        List<List<Double>> res = new ArrayList<>();

        double min = sortedArr[1] - sortedArr[0];
        res.add(Arrays.asList(sortedArr[0], sortedArr[1]));

        for (int k = 2; k < n; k++) {

            if (sortedArr[k] - sortedArr[k - 1] == min) {
                res.add(Arrays.asList(sortedArr[k - 1], sortedArr[k]));
            } else if (sortedArr[k] - sortedArr[k - 1] < min) {
                res.clear();
                res.add(Arrays.asList(sortedArr[k - 1], sortedArr[k]));
                min = sortedArr[k] - sortedArr[k - 1];
            }
        }
        System.out.println(res.toString());
    }

    /**
     * Method to find closest pair in a sorted sequence using Array.
     * @param sortedArr sorted array as input
     */
    public void closestPairV2(double[] sortedArr) {
        int n = sortedArr.length;
        int[][] res = new int[n - 1][2];
        int noOfPairs = 0;

        double min = sortedArr[1] - sortedArr[0];
        res[noOfPairs][0] = 0;
        res[noOfPairs][1] = 1;
        for (int k = 2; k < n; k++) {

            if (sortedArr[k] - sortedArr[k - 1] == min) {
                noOfPairs++;
                res[noOfPairs][0] = k - 1;
                res[noOfPairs][1] = k;

            } else if (sortedArr[k] - sortedArr[k - 1] < min) {
                res = new int[n - 1][2];
                noOfPairs = 0;
                res[noOfPairs][0] = k - 1;
                res[noOfPairs][1] = k;
                min = sortedArr[k] - sortedArr[k - 1];
            }
        }
        System.out.print("[");
        int firstElementIndex, secondElementIndex;
        for (int i = 0; i <= noOfPairs; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            firstElementIndex = res[i][0];
            secondElementIndex = res[i][1];
            System.out.print("[" + sortedArr[firstElementIndex] + ", "
                    + sortedArr[secondElementIndex] + "]");
        }
        System.out.println("]");

    }

    /**
     * Method to read input as a space separated double value sequence.
     * @return double array read as user input
     * @throws IOException 
     */
    public double[] readInput() throws IOException {
        System.out.print("Enter input array size(n): ");

        // Getting input size from user
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        // Gettng the unsorted array from the user
        double array[] = new double[n];
        int inputSize = 0;
        String input;
        do {
            System.out.print("Enter " + n + " integers, separated using space, to sort (n1 n2 n3 ...): ");
            input = reader.readLine();
            inputSize = input.split(" ").length;
        } while (inputSize != n);

        String[] numbers = input.split(" ");
        for (int j = 0; j < n; j++) {
            array[j] = Double.parseDouble(numbers[j]);
        }
        return array;
    }

    public static void main(String[] args) throws IOException {

        ClosestPair cp = new ClosestPair();

        // Giving an Introduction to the user
        System.out.print("This program will print closest pair(s) in a given array.\n"
                + "n - number of integers in input array.\n");

        // Getting user input
        double[] array = cp.readInput();
        // Declaring a new array to assign the sorted array
        double[] sortedArr;

        // Calling & printing results
        // sort the input sequence
        sortedArr = cp.optimizedBubbleSort(array.clone());
        
        // priint unsorted and sorted sequence.
        cp.printResult("Sorted array", array, sortedArr);  
        cp.closestPair(sortedArr);
       // cp.closestPairV2(sortedArr);
    }

}
