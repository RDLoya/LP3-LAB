import java.util.*;
public class NQueen {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();

        char[][] board = new char[n][n];

        // Assuming the first queen is placed at (0, 0)
        board[0][0] = 'Q';

        if (solveNQueens(board, 1)) {
            System.out.println("Solution found:");
            printBoard(board);
        } else {
            System.out.println("No solution exists.");
        }
    }

    // Rest of the code remains the same...
    public static boolean isSafe(char[][] board, int row, int col) {
        int i, j;

        for (i = 0; i < col; i++) {
            if (board[row][i] == 'Q') {
                return false;
            }
        }

        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (i = row, j = col; j >= 0 && i < board.length; i++, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static boolean solveNQueens(char[][] board, int col) {
        if (col >= board.length) {
            return true;
        }

        for (int i = 0; i < board.length; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 'Q';

                if (solveNQueens(board, col + 1)) {
                    return true;
                }

                board[i][col] = '.'; // Backtrack
            }
        }

        return false;
    }


    public static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'Q') {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}
