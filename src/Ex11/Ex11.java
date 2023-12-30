package Ex11;

public class Ex11 {
    /**
     * This method calculates the maximum possible product of three integers
     * from an array of integers.
     *
     * Time Complexity: O(n), where n is the length of the input array.
     *   - The method iterates through the array once to find the smallest and largest numbers.
     *
     * Space Complexity: O(1)
     *   - The algorithm uses only a constant amount of extra space.
     *   - Space requirements do not depend on the size of the input array.
     *
     * @param arr An array of integers.
     * @return The maximum possible product of three integers.
     */
    public static int maxMult3(int[] arr) {
        // Initialize variables to store the two smallest and three largest numbers
        int minNumber = Integer.MAX_VALUE,
                minNumber2 = Integer.MAX_VALUE,
                maxNumber = Integer.MIN_VALUE,
                maxNumber2 = Integer.MIN_VALUE,
                maxNumber3 = Integer.MIN_VALUE,
                minNumbersMult, maxNumbersMult;

        // Check if the array has less than three elements
        if (arr.length < 3)
            return Integer.MIN_VALUE;

        // Extract the 3 biggest and 2 smallest numbers from the array
        for (int num : arr) {
            if (num < minNumber) {
                minNumber2 = minNumber;
                minNumber = num;
            } else if (num < minNumber2) {
                minNumber2 = num;
            }

            if (num > maxNumber) {
                maxNumber2 = maxNumber;
                maxNumber = num;
            } else if (num > maxNumber2) {
                maxNumber3 = maxNumber2;
                maxNumber2 = num;
            } else if (num > maxNumber3) {
                maxNumber3 = num;
            }
        }

        // Calculate the products of the smallest and largest numbers
        minNumbersMult = minNumber2 * minNumber;
        maxNumbersMult = maxNumber2 * maxNumber;

        // Checks if the multiplication of the smallest numbers is
        // bigger than the multiplication of the 2 biggest numbers
        // (This is only possible when the numbers are negative)
        if (minNumbersMult > maxNumbersMult)
            return minNumbersMult * maxNumber;
        else
            return maxNumbersMult * maxNumber3;
    }

    /**
     * Finds the median of two sorted arrays of the same size.
     *
     * Time Complexity: O(log(min(N, M)))
     *   - The time complexity is determined by the binary search in the findKthElement method.
     *   - Each recursive call reduces the problem size by half.
     *
     * Space Complexity: O(1)
     *   - The algorithm uses a constant amount of extra space for variables, regardless of the input size.
     *
     * @param arr1 The first sorted array.
     * @param arr2 The second sorted array.
     * @return The median of the combined sorted arrays.
     */
    public static int findMedian(int[] arr1, int[] arr2) {
        int totalLength = arr1.length + arr2.length;

        if (totalLength % 2 == 0) {
            // If the total length is even, return the average of two middle elements
            int mid1 = findKthElement(arr1, 0, arr2, 0, totalLength / 2);
            int mid2 = findKthElement(arr1, 0, arr2, 0, totalLength / 2 + 1);
            return (mid1 + mid2) / 2;
        } else {
            // If the total length is odd, return the middle element
            return findKthElement(arr1, 0, arr2, 0, totalLength / 2 + 1);
        }
    }

    /**
     * Finds the kth element in the merged sorted array of two arrays.
     *
     * @param arr1   The first sorted array.
     * @param start1 The starting index of the first array.
     * @param arr2   The second sorted array.
     * @param start2 The starting index of the second array.
     * @param k      The index of the element to find.
     * @return The kth element in the merged sorted array.
     */
    private static int findKthElement(int[] arr1, int start1, int[] arr2, int start2, int k) {
        if (start1 >= arr1.length) {
            return arr2[start2 + k - 1];
        }
        if (start2 >= arr2.length) {
            return arr1[start1 + k - 1];
        }
        if (k == 1) {
            return Math.min(arr1[start1], arr2[start2]);
        }

        int mid1 = start1 + k / 2 - 1 < arr1.length ? arr1[start1 + k / 2 - 1] : Integer.MAX_VALUE;
        int mid2 = start2 + k / 2 - 1 < arr2.length ? arr2[start2 + k / 2 - 1] : Integer.MAX_VALUE;

        if (mid1 < mid2) {
            return findKthElement(arr1, start1 + k / 2, arr2, start2, k - k / 2);
        } else {
            return findKthElement(arr1, start1, arr2, start2 + k / 2, k - k / 2);
        }
    }
}
