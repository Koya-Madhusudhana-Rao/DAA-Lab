import java.util.Arrays;

public class SimplexMethod {

    // Function to apply the simplex algorithm
    // Function to apply the simplex algorithm
public static double[] simplex(double[][] tableau) {
    int m = tableau.length - 1; // Number of constraints
    int n = tableau[0].length - 1; // Number of variables

    // Continue until no negative entries in the bottom row
    while (true) {
        // Find the entering variable (pivot column)
        int q = 0;
        for (int j = 1; j < n; j++) {
            if (tableau[m][j] < tableau[m][q]) {
                q = j;
            }
        }
        if (tableau[m][q] >= 0) {
            break; // Optimal solution found
        }

        // Find the leaving variable (pivot row)
        int p = -1;
        double minRatio = Double.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            if (tableau[i][q] > 0) {
                double ratio = tableau[i][n] / tableau[i][q];
                if (ratio < minRatio) {
                    minRatio = ratio;
                    p = i;
                }
            }
        }
        if (p == -1) {
            throw new ArithmeticException("Unbounded solution");
        }

        // Perform pivot operation
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i != p && j != q) {
                    tableau[i][j] -= tableau[p][j] * tableau[i][q] / tableau[p][q];
                }
            }
        }
        for (int i = 0; i <= m; i++) {
            if (i != p) {
                tableau[i][q] = 0;
            }
        }
        for (int j = 0; j <= n; j++) {
            if (j != q) {
                tableau[p][j] /= tableau[p][q];
            }
        }
        tableau[p][q] = 1;
    }

    // Extract solution
    double[] solution = new double[n];
    Arrays.fill(solution, 0);
    for (int i = 0; i < m; i++) {
        if (tableau[i][n] >= 0) {
            continue;
        }
        boolean found = false;
        for (int j = 0; j < n; j++) {
            if (tableau[i][j] == 1) {
                if (!found) {
                    found = true;
                } else {
                    throw new ArithmeticException("Degenerate solution");
                }
                solution[j] = tableau[i][n];
            }
        }
    }

    return solution;
}

    // Function to print the solution
    public static void printSolution(double[] solution) {
        System.out.print("Optimal Solution: ");
        for (int i = 0; i < solution.length; i++) {
            System.out.print("x" + (i + 1) + " = " + solution[i]);
            if (i < solution.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example problem: Maximize Z = 3x1 + 4x2 subject to constraints
        // 2x1 + 3x2 <= 12
        // 4x1 + x2 <= 16
        // x1, x2 >= 0
        double[][] tableau = {
            {2, 3, 1, 0, 12},
            {4, 1, 0, 1, 16},
            {-3, -4, 0, 0, 0}
        };

        double[] solution = simplex(tableau);
        printSolution(solution);
    }
}
