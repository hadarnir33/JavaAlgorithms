// Author: Hadar Nir

package Ex12;

public class Ex12 {

    /**
     * Finds the length of the longest sequence of identical digits in a positive integer.
     *
     * Time Complexity: O(n), where n is the number of digits in the integer.
     *   - The method iterates through the digits once to find the longest sequence.
     *
     * Space Complexity: O(n), where n is the number of digits in the integer.
     *   - The recursion depth is proportional to the number of digits in the integer.
     *
     * @param num A positive integer.
     * @return The length of the longest sequence of identical digits.
     */
    public static int equalDigits(int num) {
        return equalDigitsHelper(Integer.toString(num), 0, 1, 0);
    }

    /**
     * Recursive helper method to find the length of the longest sequence of identical digits.
     *
     * This method uses recursion to iterate through the digits of the integer represented as a string,
     * tracking the length of the current sequence of identical digits and updating the maximum length found so far.
     *
     * Time Complexity: O(n), where n is the length of the input string.
     *   - The method iterates through the characters of the string once.
     *
     * Space Complexity: O(n), where n is the length of the input string.
     *   - The recursion depth is proportional to the length of the input string.
     *
     * @param numStr The string representation of the positive integer.
     * @param index  The current index in the string.
     * @param currentLength The current length of the identical digit sequence.
     * @param maxLength The maximum length found so far.
     * @return The length of the longest sequence of identical digits.
     */
    private static int equalDigitsHelper(String numStr, int index, int currentLength, int maxLength) {
        if (index == numStr.length() - 1) {
            // Base case: reached the end of the string
            return Math.max(maxLength, currentLength);
        } else if (numStr.charAt(index) == numStr.charAt(index + 1)) {
            // If the current digit is equal to the next one, increment currentLength
            return equalDigitsHelper(numStr, index + 1, currentLength + 1, Math.max(maxLength, currentLength));
        } else {
            // If the current digit is not equal to the next one, reset currentLength to 1
            return equalDigitsHelper(numStr, index + 1, 1, Math.max(maxLength, currentLength));
        }
    }


    /**
     * Returns a subnumber of a positive integer where each digit is divisible by a given digit.
     *
     * Time Complexity: O(n), where n is the number of digits in the integer.
     *   - The method iterates through the digits once to find and construct the subnumber.
     *
     * Space Complexity: O(n), where n is the number of digits in the integer.
     *   - The recursion depth is proportional to the number of digits in the integer.
     *
     * @param num   A positive integer.
     * @param digit The digit used as a divisor to filter the subnumber.
     * @return The subnumber where each digit is divisible by the given digit.
     */
    public static int subNumber(int num, int digit) {
        // Start the recursion with initial index 1
        return findSubNumber(num, digit, 1);
    }

    /**
     * Recursive helper method to find and construct the subnumber where each digit is divisible by a given digit.
     *
     * Time Complexity: O(n), where n is the number of digits in the remaining positive integer.
     *   - The method processes each digit once during each recursive call.
     *
     * Space Complexity: O(n), where n is the number of digits in the remaining positive integer.
     *   - The recursion depth is proportional to the number of digits in the remaining positive integer.
     *
     * @param num    The remaining positive integer to process.
     * @param digit  The digit used as a divisor to filter the subnumber.
     * @param index  The current place value for constructing the subnumber.
     * @return The subnumber where each digit is divisible by the given digit.
     */
    public static int findSubNumber(int num, int digit, int index) {
        if (num == 0) {
            // Base case: reached the end of the number
            return 0;
        } else {
            int currentDigit = num % 10;
            if (currentDigit % digit == 0) {
                // If the current digit is divisible by the given digit, include it in the subnumber
                return currentDigit * index + findSubNumber(num / 10, digit, index * 10);
            } else {
                // If the current digit is not divisible, skip it
                return findSubNumber(num / 10, digit, index);
            }
        }
    }

    /**
     * Determines if a given integer is a special number based on a specific deletion pattern.
     *
     * Time Complexity: O(n), where n is the given integer.
     *   - The method iteratively calls the helper method with decreasing numbersBeforeN.
     *
     * Space Complexity: O(1).
     *
     * @param n The integer to check for special number status.
     * @return true if the number is a special number, false otherwise.
     */
    public static boolean isSpecial(int n) {
        // Start the recursion with initial jump value 2 and numbersBeforeN set to n-1
        return isSpecialHelper(2, n - 1);
    }

    /**
     * Recursive helper method to determine if a given integer is a special number based on a specific deletion pattern.
     *
     * Time Complexity: O(n), where n is the count of numbers before the given integer in the sequence.
     *   - The method iteratively processes decreasing numbersBeforeN in each recursive call.
     *
     * Space Complexity: O(1).
     *
     * @param jump            The current jump value in the deletion pattern.
     * @param numbersBeforeN The count of numbers before the given integer in the sequence.
     * @return true if the number is a special number, false otherwise.
     */
    public static boolean isSpecialHelper(int jump, int numbersBeforeN) {
        if (jump > numbersBeforeN + 1) {
            // Base case: jump exceeds the count of numbers before N
            return true;
        } else {
            // If (numbersBeforeN + 1) is divisible by the jump, the number is not special
            if ((numbersBeforeN + 1) % jump == 0) {
                return false;
            }
            // Recursively call the helper method with updated parameters
            return isSpecialHelper(jump + 1, numbersBeforeN - (numbersBeforeN / jump));
        }
    }

}
