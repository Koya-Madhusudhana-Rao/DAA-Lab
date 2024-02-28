class Knapsack {
    // A utility function that returns maximum of two integers
    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Returns the maximum value that can
    // be put in a knapsack of capacity W
    static int knapSack(int W, int wt[], int val[], int n, int[][] memo) {
        // Base Case
        if (n == 0 || W == 0)
            return 0;

        // If the result is already computed, return it
        if (memo[n][W] != -1)
            return memo[n][W];

        // If weight of the nth item is more
        // than Knapsack capacity W, then
        // this item cannot be included in the optimal solution
        if (wt[n - 1] > W)
            memo[n][W] = knapSack(W, wt, val, n - 1, memo);
        else
            // Return the maximum of two cases:
            // (1) nth item included
            // (2) not included
            memo[n][W] = max(val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1, memo),
                             knapSack(W, wt, val, n - 1, memo));

        return memo[n][W];
    }

    public static void main(String args[]) {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int W = 50;
        int n = val.length;

        // Initialize memoization table with -1
        int[][] memo = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                memo[i][j] = -1;
            }
        }

        System.out.println("maximum value that can be put is " + knapSack(W, wt, val, n, memo));
    }
}
