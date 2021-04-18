import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 * 
 * @author 2018/E/073
 *
 */
public class Identity {
	
	/**
	 * search for the indexes which are equal to element 
	 * @param i - index
	 * @param r - last element (assumed it is a sorted array, then r is the largest element)
	 * @param arr - input sorted array
	 * 
	 */
	static void findIdentity( int[] arr,int i, int r) {
	
			if (arr[i]==i && i<=r) {
				System.out.print(i+" ");	
			}
			
			if(arr[i]<r) {
				findIdentity(arr,i+1,r);
			}
	}
	
	/**
	 * Drives code
	 * @param args
	 * @throws IOException
	 */
    public static void main(String[] args) throws IOException  {
    	
    	System.out.print("This program will find an index i such that a[i] = i if it exists in a given sorted array.\n" + "n - " +
                "number of integers in input sorted array.\n" + "Enter input soted array size(n): ");

        // Getting input size from user
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        int array[] = new int[n];
        int inputSize = 0;
        String input;
       
        do {
        	 System.out.print("Enter sorted " + n + " integers, separated using space (n1 n2 n3 ...): ");
            input = reader.readLine();
            inputSize = input.split(" ").length;
        } while (inputSize != n);

        String[] numbers = input.split(" ");
        for (int j = 0; j < n; j++) {
            array[j] = Integer.parseInt(numbers[j]);    
        }
        
    	System.out.print("\nSorted array: "+Arrays.toString(array)+"\nThe elemets that equal to the index value are :\n\t");
    	findIdentity(array,0,array[n-1]);		
    }
	
}
