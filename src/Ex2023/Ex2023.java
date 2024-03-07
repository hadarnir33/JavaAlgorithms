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
                // Recursively check for more circles and increment the count
                return friend3Helper(mat, i, j, k + 1) + 1;
            }
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
     * Main method for testing the FriendCircleCounter class.
     *
     * @param args Command line arguments (not used in this example).
     */
    public static void main(String[] args) {
        // Example usage of the friend3 method
        int[][] matrix = {
                {0, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 0}
        };

        int result = friend3(matrix);
        System.out.println("Number of circles: " + result);
    }
}
