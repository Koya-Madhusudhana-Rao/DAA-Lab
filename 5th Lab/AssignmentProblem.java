import java.util.ArrayList;
import java.util.Arrays;

public class AssignmentProblem {

    public static int calculateTotalCost(int[] assignment, int[][] costMatrix) {
        int totalCost = 0;
        for (int i = 0; i < assignment.length; i++) {
            totalCost += costMatrix[i][assignment[i]];
        }
        return totalCost;
    }

    public static int[] bruteForceAssignment(int[][] costMatrix) {
        int n = costMatrix.length;
        int[] assignment = new int[n];
        for (int i = 0; i < n; i++) {
            assignment[i] = i; // Initial assignment as [0, 1, 2, ..., n-1]
        }

        int[] optimalAssignment = Arrays.copyOf(assignment, n);
        int minCost = Integer.MAX_VALUE;

        do {
            int totalCost = calculateTotalCost(assignment, costMatrix);
            if (totalCost < minCost) {
                minCost = totalCost;
                optimalAssignment = Arrays.copyOf(assignment, n);
            }
        } while (nextPermutation(assignment));

        return optimalAssignment;
    }

    public static boolean nextPermutation(int[] array) {
        int i = array.length - 1;
        while (i > 0 && array[i - 1] >= array[i]) {
            i--;
        }

        if (i <= 0) {
            return false;
        }

        int j = array.length - 1;
        while (array[j] <= array[i - 1]) {
            j--;
        }

        int temp = array[i - 1];
        array[i - 1] = array[j];
        array[j] = temp;

        j = array.length - 1;
        while (i < j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] costMatrix = {
                {3, 2, 7},
                {2, 4, 6},
                {1, 3, 5}
        };

        int[] optimalAssignment = bruteForceAssignment(costMatrix);

        System.out.println("Optimal Assignment: " + Arrays.toString(optimalAssignment));
    }
}
