package Ex2017;

public class Ex2017 {

    /**
     * Checks if the specified coordinates (i, j) are within the bounds of the given matrix.
     *
     * @param mat The boolean matrix to check.
     * @param i   The row index.
     * @param j   The column index.
     * @return True if the coordinates are legal (within bounds), false otherwise.
     */
    public static boolean isLegal(boolean[][] mat, int i, int j) {
        return i >= 0 && i <= mat.length - 1 && j >= 0 && j <= mat[0].length - 1;
    }

    /**
     * Modifies neighboring cells of the given coordinates (i, j) to false recursively.
     *
     * @param mat The boolean matrix.
     * @param i   The row index.
     * @param j   The column index.
     */
    public static void modifyNeighborsToFalse(boolean[][] mat, int i, int j) {
        if (mat[i][j]) {
            mat[i][j] = false;
            if (isLegal(mat, i, j - 1))
                modifyNeighborsToFalse(mat, i, j - 1);
            if (isLegal(mat, i, j + 1))
                modifyNeighborsToFalse(mat, i, j + 1);
            if (isLegal(mat, i - 1, j))
                modifyNeighborsToFalse(mat, i - 1, j);
            if (isLegal(mat, i + 1, j))
                modifyNeighborsToFalse(mat, i + 1, j);
        }
    }

    /**
     * Counts the number of true regions in the matrix starting from the specified coordinates (i, j).
     *
     * @param mat The boolean matrix to analyze.
     * @param i   The current row index.
     * @param j   The current column index.
     * @return The count of true regions.
     */
    public static int cntTrueReg(boolean[][] mat, int i, int j) {
        if (i > mat.length - 1)
            return 0;
        else if (j > mat[0].length - 1)
            return cntTrueReg(mat, i + 1, 0);
        else {
            if (mat[i][j]) {
                modifyNeighborsToFalse(mat, i, j);
                return cntTrueReg(mat, i, j + 1) + 1;
            }
            return cntTrueReg(mat, i, j + 1);
        }
    }

    /**
     * Counts the number of true regions in the matrix.
     *
     * @param mat The boolean matrix to analyze.
     * @return The count of true regions.
     */
    public static int cntTrueReg(boolean[][] mat) {
        return cntTrueReg(mat, 0, 0);
    }

    /**
     * Main method to test the functionality with a sample matrix.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Test your method here with the provided matrix
        boolean[][] testMatrix = {
                {false, false, false, false, true},
                {false, true, true, true, false},
                {false, false, true, true, false},
                {true, false, false, false, false},
                {true, true, false, false, false}
        };
        int trueRegions = cntTrueReg(testMatrix);
        System.out.println("Number of true regions: " + trueRegions);
    }
}
