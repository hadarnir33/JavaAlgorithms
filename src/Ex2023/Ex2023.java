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


    public static void main(String[] args) {

    }
}
