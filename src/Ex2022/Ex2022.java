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

    public static void main(String[] args) {
        System.out.println(calculateExpression(3, 36, 4));
    }
}
