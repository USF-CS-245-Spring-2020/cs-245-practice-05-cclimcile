/**
 *
 * This program sorts 1 million elements worth of data using CountSort.
 *
 * @author Chiara Lim
 *
 */

import java.util.*;
import java.io.*;

public class MegaSort {

    public static void main(String[] args) throws FileNotFoundException {

        int [] arr = new int[1000000];

        File input_file = new File("1m-ints.txt");
        Scanner scanner = new Scanner(input_file);

        int index = 0;
        while(scanner.hasNextLine()){

            String number = scanner.nextLine();
            int result = Integer.parseInt(number);
            arr[index++] = result;

        }

        megaSort(arr);

        /* Output the sorted list to standard out (the terminal) */
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
        System.out.println("MegaSort Completed.");
    }

    /**
     * This function finds the largest element in the given array to
     * help initialize the size of the temp array
     *
     * @param a
     * @return
     */
    public static int findMax(int [] a){

        int max = a[0];
        for(int i = 1; i < a.length; i++){
            if(a[i] > max){
                max = a[i];
            }
        }
        return max;

    }

    /**
     * This function implements CountSort
     *
     * @param arr
     */
    public static void megaSort(int [] arr){

        int [] index_arr = new int[findMax(arr) + 1];

        /* Appends everything to a temporary array */
        for(int i = 0; i < arr.length; i++){
            index_arr[arr[i]] += 1;
        }

        /* Now that the array has been sorted, it copies over the original array */
        int counter = 0;
        for(int j = 0; j < index_arr.length; j++){
            while(index_arr[j] > 0){
                arr[counter++] = j;
                index_arr[j] -= 1;
            }
        }

    }

}