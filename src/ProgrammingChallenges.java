/**
 * Name: Jack Kai Lim
 * PID: A16919063
 */


import java.util.*;

/**
 * PA1
 * @author Jack Kai Lim
 * @since 3/28/2022
 */
public class ProgrammingChallenges {

    ///////// Practice 1 /////////

    /**
     * Counts number of even numbers in the array. Then adds all even numbers in to a new array.
     * Which then gets reversed and all even numbers in the main array gets replaced with it's
     * reversed counterpart.
     * @param arr an integer array
     * @return arr with evens reversed
     */
    public static int[] reverseEvenNumber(int[] arr) {
        int half = 2;
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
        for(int i = 0; i < evens_arr.length / half; i++)
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

    /**
     * Loops through th string to check if the string passes the criteria required for a good
     * password and returns how good depending on how many checks were passed
     * @param input a string of any length which is the password to be checked
     * @return How good the password if based of the number os checks it passed
     */
    public static String checkPasswordStrength(String input) {
        /**/
        int checks = 0;
        int min_len = 8;
        int weak = 2;
        char[] chars = input.toCharArray();
        for (int i = 0;i < input.length(); i++) {
            if (Character.isUpperCase(input.charAt(i))) {
                for (int j = 0;j<input.length();j++){
                    if (Character.isLowerCase(input.charAt(j))) {
                        checks += 1;
                        break;
                    }
                }

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
        if (input.length() >= min_len){
            checks += 1;
        }
        if (checks == 0){
            return "Not Acceptable";
        } else if (checks <= weak) {
            return "Weak";
        } else {
            return "Strong";
        }
    }

    ///////// Practice 3 /////////

    /**
     * Iterates through each coordinates and then again while calculating the distance between
     * the 2 points and replacing it if the next distance is shorter and returns the shortest
     * distances.
     * @param x double array of x-coords
     * @param y double array of y-coords
     * @return double array with the min distances for all points.
     */
    public static double[] findShortestDistance(double[] x, double[] y){
        int square = 2;
        double[] distances = new double[x.length];
        for (int i = 0;i<x.length;i++){
            double dist = 0;
            for (int j = 0;j<x.length;j++){
                double temp_dist = Math.sqrt(Math.pow(x[i] - x[j], square)
                        + Math.pow(y[i] - y[j], square));
                if ((dist > temp_dist) && (i != j)){
                    dist = temp_dist;
                } else if (dist == 0) dist = temp_dist;
            }
            distances[i] = dist;
        }
        return distances;
    }

    ///////// Practice 4.1 /////////

    /**
     * Creates an array of nulls in the length of the input, then changes the values in order
     * of each unique value encountered.
     * @param arr array of strings
     * @return array with the one of each unique element and nulls for each repeated one.
     */
    public static String[] getUnique(String[] arr) {
        /**/
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

    /**
     * Iterates through the arr based on the number of unique values that the arr has. Then
     * creates a new array of length of the number of unique values where each element is an
     * array of the 1s and 0s where the 1s represent the unique value.
     * @param arr array of strings
     * @return array of arrays with each unique value shown as 1
     */
    public static int[][] oneHotEncode(String[] arr) {
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

    /**
     * This takes in an array and multiplies that value of the integer at each index by it's
     * index. Then moves all items in an array one to the left and reduces the array size to
     * correspond to the decrease in power.
     * @param polyArr array of integer that represents a polynomial
     * @return An array that represents the derivative of the polynomial.
     */
    public static int[] calculateDerivative(int[] polyArr){
        /**/
        int[] temp_array = new int[polyArr.length];
        for (int i=0;i<polyArr.length;i++){
            temp_array[i] = polyArr[i]*i;
        }
        int[] final_array = new int[polyArr.length - 1];
        if (temp_array.length == 1){
            final_array = temp_array;
        } else {
            System.arraycopy(temp_array, 1, final_array, 0, polyArr.length - 1);
        }
        return final_array;
    }

    ///////// Practice 5.2 /////////

    /**
     * Calculates the value of t if the derivative of both poly1 and poly2 are quadratic as it
     * gives a linear equation. But if there is division by 0, a positive or negative infinity
     * is returned instead. Or if the value is invalid, eg the value is negative, a -1 is
     * returned. Else it calculates the value of t and returns the value of it.
     * @param poly1 Array of a polynomial
     * @param poly2 Array of a polynomial
     * @return The intersection point between the derivative of te 2 polynomials.
     */
    public static Double getIntersection(int[] poly1, int[] poly2){
        /**/
        int linear_len = 2;
        int[] deri1 = calculateDerivative(poly1);
        int[] deri2 = calculateDerivative(poly2);
        int deri1_pow = deri1.length;
        int deri2_pow = deri2.length;
        double ans;

        if (deri1_pow == linear_len && deri2_pow == linear_len){
            if (deri1[1] - deri2[1] == 0){
                if (deri2[0] - deri1[0] < 0){
                    ans = Double.NEGATIVE_INFINITY;
                } else {
                    ans = Double.POSITIVE_INFINITY;
                }
            } else {
                ans = (deri2[0] - deri1[0])/(deri1[1] - deri2[1]);
            }
        } else if (deri1_pow == 1 && deri2_pow == linear_len){
            if (deri2[1] == 0){
                if (deri1[0] - deri2[0] < 0){
                    ans = Double.NEGATIVE_INFINITY;
                } else {
                    ans =  Double.POSITIVE_INFINITY;
                }
            } else {
                ans = (deri1[0] - deri2[0])/deri2[1];
            }
        } else if (deri1_pow == linear_len && deri2_pow == 1){
            if (deri1[1] == 0){
                if (deri2[0] - deri1[0] < 0){
                    ans = Double.NEGATIVE_INFINITY;
                } else {
                    ans = Double.POSITIVE_INFINITY;
                }
            } else {
                ans = (deri2[0] - deri1[0])/deri1[1];
            }
        } else {
            ans = 0;
        }
        return ans;
    }

}

