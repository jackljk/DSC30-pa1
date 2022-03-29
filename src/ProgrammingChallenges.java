/**
 * Name: Jack Kai Lim
 * PID: A16919063
 */


import sun.security.util.ArrayUtil;

import java.util.*;

/**
 * TODO
 * @author Jack Kai Lim
 * @since TODO
 */
public class ProgrammingChallenges {

    ///////// Practice 1 /////////

    public static int[] reverseEvenNumber(int[] arr) {
        /*Counts number of even numbers in the array. Then adds all even numbers in to a new
        array. Which then gets reversed and all even numbers in the main array gets replaced with
         it's reversed counterpart.*/
        int size = arr.length;
        int no_evens = 0;
        for (int j : arr) {
            if (j % 2 == 0) {
                no_evens += 1;
            }
        }
        int[] evens_arr = new int[no_evens];
        int pos1 = 0;
        for (int j : arr) {
            if (j % 2 == 0) {
                evens_arr[pos1] = j;
                pos1 += 1;
            }
        }
        for(int i = 0; i < evens_arr.length / 2; i++)
        {
            int temp = evens_arr[i];
            evens_arr[i] = evens_arr[evens_arr.length - i - 1];
            evens_arr[evens_arr.length - i - 1] = temp;
        }
        int pos2 = 0;
        for (int i = 0;i < size; i++) {
            if (arr[i] % 2 == 0) {
                arr[i] = evens_arr[pos2];
                pos2 += 1;
            }
        }
        return arr;
    }
    ///////// Practice 2 /////////

    public static String checkPasswordStrength(String input) {
        /*Loops through th string to check if the string passes the criteria required for a good
         password and returns how good depending on how many checks were passed*/
        int checks = 0;
        char[] chars = input.toCharArray();
        for (int i = 0;i < input.length(); i++) {
            if (Character.isUpperCase(input.charAt(i)) && Character.isLowerCase(input.charAt(i))) {
                checks += 1;
                break;
            }
        }
        for (int i = 0;i < input.length(); i++){
            if (Character.isDigit(input.charAt(i))){
                checks += 1;
                break;
            }
        }
        for (int i = 0;i < input.length(); i++){
            if (!Character.isDigit(input.charAt(i)) && !Character.isAlphabetic(input.charAt(i))){
                checks += 1;
                break;
            }
        }
        if (input.length() >= 8){
            checks += 1;
        }
        if (checks == 0){
            return "Not Acceptable";
        } else if (checks <= 2) {
            return "Weak";
        } else {
            return "Strong";
        }
    }

    ///////// Practice 3 /////////

    public static double[] findShortestDistance(double[] x, double[] y){
        /*Iterates through each coordinates and then again while calculating the distance between
         the 2 points and replacing it if the next distance is shorter and returns the shortest
         distances.*/
        double[] distances = new double[x.length];
        for (int i = 0;i<x.length;i++){
            double dist = 0;
            for (int j = 0;j<x.length;j++){
                double temp_dist;
                temp_dist = Math.sqrt(Math.pow(x[i] - x[j], 2) + Math.pow(y[i] - y[j], 2));
                if ((dist > temp_dist) && (i != j)){
                    dist = temp_dist;
                } else if (dist == 0) dist = temp_dist;
            }
            distances[i] = dist;
        }
        return distances;
    }

    ///////// Practice 4.1 /////////

    public static String[] getUnique(String[] arr) {
        /*Creates an array of nulls in the length of the input, then changes the values in order
        of each unique value encountered.*/
        int arr_size = arr.length;
        int pos = 0;
        String[] final_arr = new String[arr_size];
        for (int i = 0;i<arr_size; i++) {
            final_arr[i] = null;
        }
        for (String s : arr) {
            if (!Arrays.asList(final_arr).contains(s)) {
                final_arr[pos] = s;
                pos += 1;
            }
        }
        return final_arr;
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
        /*Iterates through the arr based on the number of unique values that the arr has. Then
        creates a new array of length of the number of unique values where each element is an
        array of the 1s and 0s where the 1s represent the unique value.*/
        int no_of_unique = getNumOfUniqueElements(arr);
        String[] unique_arr = getUnique(arr);
        int[][] final_arr = new int[no_of_unique][arr.length];
        for (int i = 0;i<no_of_unique;i++){
            String unique= unique_arr[i];
            int[] temp_arr = new int[arr.length];
            for (int j = 0;j<arr.length;j++){
                if (Objects.equals(arr[j], unique)){
                    temp_arr[j] = 1;
                } else {
                    temp_arr[j] = 0;
                }
            }
            final_arr[i] = temp_arr;
        }
        return final_arr;
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

