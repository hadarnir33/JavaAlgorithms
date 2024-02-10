// Author: Hadar Nir

package Ex14;

public class IntList {
    private IntNode _head;

    // Constructor to initialize an empty list
    public IntList() {
        _head = null;
    }

    // Adds a new node with the given number to the end of the list
    public void addToEnd(int num) {
        // creates a new node
        IntNode node = new IntNode(num);

        // checks if the list is empty
        if (_head == null)
            _head = node;
        else {
            // traverses the list to find the last node
            IntNode ptr = _head;
            while (ptr.getNext() != null)
                ptr = ptr.getNext();
            // appends the new node to the end of the list
            ptr.setNext(node);
        }
    }

    // Returns a string representation of the list
    public String toString() {
        String s = "";
        IntNode temp = _head;
        // traverses the list to create a string representation
        while (temp != null) {
            s = s + temp.getValue() + " --> ";
            temp = temp.getNext();
        }
        s += " null";
        return s;
    }

    /**
     * This function searches for a sequence of nodes in the list that their sum is num.
     *
     * Time complexity: O(n^2), where n is the length of the list.
     * The function iterates through each element of the array once in a single for-loop.
     * In the for-loop, the function performs a constant number of comparisons and assignments.
     *
     * Space complexity: O(1), the function uses a fixed number of integer variables (1).
     * These variables don't depend on the size of the input array.
     *
     * @param num: The number that is the wanted sum.
     * @return boolean: True if there is a streak of nodes that their sum is num, false otherwise.
     **/
    public boolean subListSum(int num) {
        int sum = 0;

        for (IntNode originNode = _head; originNode != null; originNode = originNode.getNext()) {
            sum = 0;

            for (IntNode currentNode = originNode; currentNode != null && sum < num; currentNode = currentNode.getNext()) {
                sum += currentNode.getValue();
            }

            if (sum == num)
                return true;
        }
        return false;
    }

    /**
     * This function finds the node in the linked list that maximizes the absolute difference
     * between the averages of the numbers in the two parts of the list divided by this node.
     * The left part includes all nodes up to and including the current node,
     * and the right part includes all nodes after the current node.
     *
     * Time complexity: O(n), where n is the length of the list.
     * The function traverses the list three times - once for calculating the total length of the list,
     * and again for populating the prefix sums.
     * The final iteration for finding the maximum difference also takes linear time.
     *
     * Space Complexity: O(n), due to the additional array used to store prefix sums.
     * The space required for this array scales linearly with the number of nodes in the list.
     *
     * @return IntNode: The node that maximizes the absolute difference of averages.
     * If the list is empty or has only one node, the function returns null.
     */
    public IntNode averageNode() {
        IntNode current = _head;
        IntNode maxDiffNode = _head;
        double prefixAvg = 0, postfixAvg = 0, currentDiff = 0, maxDiff = 0;
        int length = 0, sum = 0, index = 0;

        // Checks if the list is empty or has only one node
        if (_head == null || _head.getNext() == null) {
            return null;
        }

        // Finds the list length
        while (current != null) {
            length++;
            current = current.getNext();
        }

        // An array that will contain the prefix sum for each node
        int[] prefixSums = new int[length];

        // Calculate the prefix sums
        for (current = _head; current != null; current = current.getNext()) {
            sum += current.getValue();
            prefixSums[index++] = sum;
        }

        index = 0;

        // Finds the node with the biggest difference between its prefix average and postfix average
        for (current = _head; current.getNext() != null; current = current.getNext()) {
            prefixAvg = (double) prefixSums[index] / (index + 1);
            postfixAvg = (double) (prefixSums[length - 1] - prefixSums[index]) / (length - index - 1);
            currentDiff = Math.abs(prefixAvg - postfixAvg);
            if (currentDiff >= maxDiff) {
                maxDiff = currentDiff;
                maxDiffNode = current;
            }

            index++;
        }

        return maxDiffNode;
    }
}
