package lk.ac.jfn.eng.ec4070.lab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class finds the local minimum of a N*N matrix.
 *
 * @author Thanuja U. <thanuja@eng.jfn.ac.lk>
 */
public class LocalMinimum {

    private int[][] array;
    private int n;

    public int[][] getArray() {
        return array;
    }

    public void setArray(int[][] array) {
        this.array = array;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public static void main(String[] args) throws IOException {

        LocalMinimum lm = new LocalMinimum();

        // Giving an Introduction to the user
        System.out.print("This program will find local minimum(s) of a N * N "
                + "array.\n N - number of rows/columns in the input array.\n");

        // Read input from user
        lm.setArray(lm.readInput());

        //Print input array
        System.out.println("Entered array : ");
        lm.printArray();

        System.out.println("Local minimum(s) of given array: ");
        lm.findLocalMin(lm.getArray());
    }

    /**
     * Method to read N*N matrix as a space separated integer value sequence.
     *
     * @return int[][] read as user input
     * @throws IOException
     */
    public int[][] readInput() throws IOException {
        System.out.print("Enter number of rows/columns in the array (N): ");
        // Getting input size from user
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                System.in));
        n = Integer.parseInt(reader.readLine());

        String input;
        int inputSize;

        do {
            System.out.print(
                    "Enter " + n * n + " integers, separated using space, to sort (n1 n2 n3 ...): ");
            input = reader.readLine();
            inputSize = input.split(" ").length;
        } while (inputSize != n * n);

        String[] numbers = input.split(" ");

        array = new int[n][n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = Integer.parseInt(numbers[count++]);
            }
        }
        return array;
    }

    /**
     * Method to print array.
     */
    public void printArray() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(" " + array[i][j] + "\t");
            }
            System.out.println();
        }

    }

    /**
     * Method to find the local minimum of a N*N matrix.
     *
     * @param matrix N*N integer array as input.
     */
    public void findLocalMin(int[][] matrix) {

        int[] tempArray = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int current = matrix[i][j];
                if (i + 1 < matrix.length && current >= matrix[i + 1][j]
                        || i - 1 >= 0 && current >= matrix[i - 1][j]
                        || j + 1 < matrix[i].length && current >= matrix[i][j + 1]
                        || j - 1 >= 0 && current >= matrix[i][j - 1]) {

                } else {
                    System.out.println(current);
                }

            }
        }
    }
}
