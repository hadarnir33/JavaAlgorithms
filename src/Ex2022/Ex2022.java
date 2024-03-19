package Ex2022;

public class Ex2022 {
    /**
     * Calculates expressions using addition, subtraction, multiplication, and division operations
     * to reach a target result with a given number and maximum number of operations.
     *
     * @param num The number to use in the calculations.
     * @param result The target result to achieve.
     * @param maxOp The maximum number of operations allowed.
     * @param expression The current expression being evaluated.
     * @param currentResult The current result of the expression.
     * @return The number of valid expressions that reach the target result.
     */
    public static int calculateExpression(int num, int result, int maxOp, String expression, int currentResult) {
        // Base case: current result matches the target result
        if (currentResult == result) {
            System.out.println(expression + "=" + result);
            return 1;
        }
        // Base case: maximum operations reached
        else if (maxOp == 0)
            return 0;
        // Recursive calls for addition, subtraction, multiplication, and division
        int sumResult = calculateExpression(num, result, maxOp - 1, expression + "+" + num, currentResult + num);
        int differenceResult = calculateExpression(num, result, maxOp - 1, expression + "-" + num, currentResult - num);
        int mulResult = calculateExpression(num, result, maxOp - 1, expression + "*" + num, currentResult * num);
        int divisionResult = calculateExpression(num, result, maxOp - 1, expression + "/" + num, currentResult / num);
        return sumResult + differenceResult + mulResult + divisionResult;
    }

    /**
     * Helper method to initiate the calculation with a default starting expression.
     *
     * @param num The number to use in the calculations.
     * @param result The target result to achieve.
     * @param maxOp The maximum number of operations allowed.
     * @return The number of valid expressions that reach the target result.
     */
    public static int calculateExpression(int num, int result, int maxOp) {
        return calculateExpression(num, result, maxOp, "3", 3);
    }

    /**
     * Finds the index of the first positive number to the right of the given index in the array.
     * @param a The input array.
     * @param index The index to start searching from.
     * @return The index of the first positive number, or -1 if not found.
     */
    public static int findPositiveNumberFromRight(int[] a, int index) {
        for (int i = index; i < a.length; i++) {
            if (a[i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Finds the index of the first positive number to the left of the given index in the array.
     * @param a The input array.
     * @param index The index to start searching from.
     * @return The index of the first positive number, or -1 if not found.
     */
    public static int findPositiveNumberFromLeft(int[] a, int index) {
        while (index >= 0) {
            if (a[index] > 0) {
                return index;
            }
            index--;
        }
        return -1;
    }

    /**
     * Searches for a number in an array using k-almost search.
     * @param a The input array.
     * @param num The number to search for.
     * @param low The lower index bound.
     * @param high The upper index bound.
     * @return The index of the number if found, or -1 otherwise.
     */
    public static int kAlmostSearch(int[] a, int num, int low, int high) {
        int mid, positiveFromRight, positiveFromLeft;
        while (low < high) {
            mid = (low + high) / 2;
            if (a[mid] == num) {
                return mid;
            }
            if (a[mid] == 0) {
                positiveFromRight = findPositiveNumberFromRight(a, mid + 1);
                if(positiveFromRight != -1){
                    if (a[positiveFromRight] == num) {
                        return positiveFromRight;
                    }
                    if (a[positiveFromRight] < num) {
                        low = positiveFromRight;
                    }
                }
                positiveFromLeft = findPositiveNumberFromLeft(a, mid - 1);
                if(positiveFromLeft != -1 && low != positiveFromRight){
                    if (a[positiveFromLeft] == num) {
                        return positiveFromLeft;
                    }
                    if (a[positiveFromLeft] > num) {
                        high = positiveFromLeft;
                    } else {
                        return -1;
                    }
                }
            } else if (a[mid] < num) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return -1;
    }

    /**
     * Searches for a number in an array using k-almost search.
     * @param a The input array.
     * @param num The number to search for.
     * @return The index of the number if found, or -1 otherwise.
     */
    public static int kAlmostSearch(int[] a, int num) {
        return kAlmostSearch(a, num, 0, a.length - 1);
    }


    public static void main(String[] args) {

    }
}
