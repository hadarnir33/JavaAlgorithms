package Ex2023;

/**
 * A class for questions from year 2023.
 */
public class Ex2023 {

    /**
     * Helper method to recursively find friend circles in a matrix.
     *
     * @param mat The matrix representing friendships.
     * @param i   The first index for checking friendship.
     * @param j   The second index for checking friendship.
     * @param k   The third index for checking friendship.
     * @return The count of friend circles found.
     */
    private static int friend3Helper(int[][] mat, int i, int j, int k) {
        int isCircle = 0;
        // Check boundaries to avoid IndexOutOfBoundsException
        if (i < mat.length - 2) {
            // Check if j exceeds the valid range
            if (j > mat.length - 2)
                return friend3Helper(mat, i + 1, i + 2, i + 3);

            // Check if k exceeds the valid range
            if (k > mat.length - 1)
                return friend3Helper(mat, i, j + 1, j + 2);

            // Check if friends at indices i, j, and k form a circle
            if (mat[i][j] == 1 && mat[i][k] == 1 && mat[j][k] == 1) {
                System.out.println(i + " " + j + " " + k);
                isCircle = 1;
            }
            // Recursively check for more circles and increment the count
            return friend3Helper(mat, i, j, k + 1) + isCircle;
        }
        return 0;
    }

    /**
     * Method to find and count friend circles in a matrix.
     *
     * @param mat The matrix representing friendships.
     * @return The total count of friend circles found.
     */
    public static int friend3(int[][] mat) {
        int countFriendsCircles = 0, i = 0, j = 1, k = 2;
        countFriendsCircles = friend3Helper(mat, i, j, k);
        return countFriendsCircles;
    }

    /**
     * Finds a peak element in an array. A peak element is an element that is greater
     * than or equal to its neighbors.
     *
     * @param arr The input array in which the peak element needs to be found.
     * @return The peak element if found, otherwise -1.
     */
    public static int findPeak(int[] arr) {
        // Check if the first element is a peak.
        if (arr[0] > arr[1]) {
            return arr[0];
        }

        // Check if the last element is a peak.
        if (arr[arr.length - 1] > arr[arr.length - 2]) {
            return arr[arr.length - 1];
        }

        // Iterate through the array to find a peak element.
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                return arr[i];
            }
        }

        // No peak element found.
        return -1;
    }

    /**
     * Finds the minimal string formed by interleaving the characters of two strings starting from specified indices.
     * If one of the strings is exhausted, it appends the remaining characters from the other string.
     *
     * @param st1 The first string.
     * @param st2 The second string.
     * @param i   The index in the first string from which to start interleaving.
     * @param j   The index in the second string from which to start interleaving.
     * @return The minimal interleaved string.
     */
    public static String minimalSt(String st1, String st2, int i, int j) {
        // Base case: if both strings are exhausted, return an empty string.
        if (i >= st1.length() && j >= st2.length()) {
            return "";
        }

        // If one string is exhausted, return the remaining characters from the other string.
        if (i >= st1.length()) {
            return st2.substring(j);
        }
        if (j >= st2.length()) {
            return st1.substring(i);
        }

        // If the characters at current indices are the same, include one of them and proceed.
        if (st1.charAt(i) == st2.charAt(j)) {
            return st1.charAt(i) + minimalSt(st1, st2, i + 1, j + 1);
        } else {
            // If the characters are different, explore both options and choose the shorter one.
            String minimalStI = st2.charAt(j) + minimalSt(st1, st2, i, j + 1);
            String minimalStJ = st1.charAt(i) + minimalSt(st1, st2, i + 1, j);
            return minimalStI.length() < minimalStJ.length() ? minimalStI : minimalStJ;
        }
    }

    /**
     * Finds the minimal string formed by interleaving the characters of two strings.
     *
     * @param st1 The first string.
     * @param st2 The second string.
     * @return The minimal interleaved string.
     */
    public static String minimalSt(String st1, String st2) {
        // Start interleaving from the beginning of both strings.
        return minimalSt(st1, st2, 0, 0);
    }


    /**
     * Finds the length of the smallest sub array in the given array 'arr' whose sum is greater than or equal to 'num'.
     *
     * Time Complexity: O(n^2)
     *   - The outer loop runs 'n' times, where 'n' is the length of the input array 'arr'.
     *   - The inner loop may also run up to 'n' times in the worst case.
     *   - Therefore, the overall time complexity is O(n^2).
     *
     * Space Complexity: O(1)
     *   - The algorithm uses a constant amount of extra space regardless of the size of the input array.
     *
     * @param arr The input array of integers.
     * @param num The target sum to compare against the sums of subarrays.
     * @return The length of the smallest subarray whose sum is greater than or equal to 'num'. If no such subarray exists, returns 0.
     */
    public static int findSmallestSubArrayLen(int[] arr, int num) {
        // Initialize variables to track the smallest sub array and its indices
        int smallestSubArrayFirstIndex = -1, smallestSubArrayLastIndex = -1;
        // Initialize variables to compute sub array sum and length
        int subArraySum = 0, subArrayLen, smallestSubArrayLen = 0;

        // Iterate over each element in the array
        for (int i = 0; i < arr.length; i++) {
            int j;
            // Find sub arrays starting from index 'i' whose sum is greater than or equal to 'num'
            for (j = i; j < arr.length && subArraySum <= num; j++) {
                subArraySum += arr[j];
            }
            j--; // Adjust 'j' to point to the last element of the sub array
            // If the sum of the current sub array is greater than 'num'
            if (subArraySum > num) {
                // Printing the sub array found
                System.out.println("SubArray found [" + i + ", " + j + "]");
                // Calculate the length of the current sub array
                subArrayLen = j - i;
                // Update the smallest sub array length and its indices
                if (smallestSubArrayLen == 0 || subArrayLen < smallestSubArrayLen) {
                    smallestSubArrayLen = subArrayLen;
                    smallestSubArrayFirstIndex = i;
                    smallestSubArrayLastIndex = j;
                }
            }
            // Reset sub array sum for the next iteration
            subArraySum = 0;
        }

        // Check if a valid sub array exists
        if (smallestSubArrayFirstIndex == -1 || smallestSubArrayLastIndex == -1)
            System.out.println("No subArray exists");
        else
            // Printing the smallest sub array found
            System.out.println("Smallest subArray found [" + smallestSubArrayFirstIndex + ", " + smallestSubArrayLastIndex + "]");

        // Return the length of the smallest sub array
        return smallestSubArrayLen;
    }

    public static void main(String[] args) {

    }
}
