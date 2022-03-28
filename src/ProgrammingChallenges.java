/**
 * Name: Jack Kai Lim
 * PID: A16919063
 */


import sun.security.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * TODO
 * @author Jack Kai Lim
 * @since TODO
 */
public class ProgrammingChallenges {

    ///////// Practice 1 /////////

    public static int[] reverseEvenNumber(int[] arr) {
        /*TODO*/
        int size = arr.length;
        int no_evens = 0;
        for (int j : arr) {
            if (j % 2 == 0) {
                no_evens += 1;
            }
        }
        int[] evens_arr = new int[no_evens];
        for (int i = 0;i < size; i++){
            if(arr[i] % 2 == 0) {
                evens_arr[i] = arr[i];
            }
        }
        for(int i = 0; i < evens_arr.length / 2; i++)
        {
            int temp = evens_arr[i];
            evens_arr[i] = evens_arr[evens_arr.length - i - 1];
            evens_arr[evens_arr.length - i - 1] = temp;
        }
        int pos = 0;
        for (int i = 0;i < size; i++) {
            if (arr[i] % 2 == 0) {
                arr[i] = evens_arr[pos];
                pos += 1;
            }
        }
        return arr;
    }

    ///////// Practice 2 /////////

    public static String checkPasswordStrength(String input) {
        /*TODO*/
        return null;
    }

    ///////// Practice 3 /////////

    public static double[] findShortestDistance(double[] x, double[] y){
        /*TODO*/
        return null;
    }

    ///////// Practice 4.1 /////////

    public static String[] getUnique(String[] arr) {
        /*TODO*/
        return null;
    }

    /**
     * Find the number of unique Element in an array with only unique element
     * (PROVIDED)
     * @param arr arr
     * @return the number of unique element.
     */
    public static int getNumOfUniqueElements(String[] arr) {
        int counter = 0;
        arr = getUnique(arr);
        for (String s : arr) {
            if (s != null) counter++;
            else break;
        }
        return counter;
    }

    ///////// Practice 4.2 /////////

    public static int[][] oneHotEncode(String[] arr) {
        /*TODO*/
        return null;
    }

    ///////// Practice 5.1 /////////

    public static int[] calculateDerivative(int[] polyArr){
        /*TODO*/
        return null;
    }

    ///////// Practice 5.2 /////////

    public static double getIntersection(int[] poly1, int[] poly2){
        /*TODO*/
        return 0;
    }

}