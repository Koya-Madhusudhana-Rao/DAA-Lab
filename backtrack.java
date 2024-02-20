import java.util.Arrays;

class HelloWorld {

    static final int N = 8;

    public static void main(String[] args) {
        int[][] board = new int[N][N]; // Initialize the board
        if (!solveNQueens(board, 0))
            System.out.println("No solution found");
    }

    static boolean isSafe(int[][] board, int row, int col) {
        // check if there is a queen in the same row to the left
        for (int x = 0; x < col; x++)
            if (board[row][x] == 1)
                return false;

        // check if there is a queen in the upper left diagonal
        for (int x = row, y = col; x >= 0 && y >= 0; x--, y--)
            if (board[x][y] == 1)
                return false;

        // check if there is a queen in the lower left diagonal
        for (int x = row, y = col; x < N && y >= 0; x++, y--)
            if (board[x][y] == 1)
                return false;

        // if there is no queen in any of the above positions, then it is safe to place a queen
        return true;
    }

    static boolean solveNQueens(int[][] board, int col) {
        if (col == N) {
            for (int[] row : board)
                System.out.println(Arrays.toString(row));
            System.out.println();
            return true;
        }

        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;
                if (solveNQueens(board, col + 1))
                    return true;
                board[i][col] = 0;
            }
        }

        return false;
    }
}
