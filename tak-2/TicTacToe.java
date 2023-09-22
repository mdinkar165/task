import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            char[][] board = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
            };
            boolean playerX = true;
            boolean gameWon = false;
            int moves = 0;

            System.out.println("Welcome to Tic-Tac-Toe!");

            while (!gameWon && moves < 9) {
                printBoard(board);
                char currentPlayer = playerX ? 'X' : 'O';
                System.out.println("Player " + currentPlayer + ", enter your move (row and column): ");
                int row = scanner.nextInt();
                int col = scanner.nextInt();

                if (isValidMove(board, row, col)) {
                    board[row][col] = currentPlayer;
                    moves++;
                    gameWon = checkWin(board, currentPlayer);
                    playerX = !playerX;
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            }

            printBoard(board);

            if (gameWon) {
                char winner = playerX ? 'O' : 'X';
                System.out.println("Player " + winner + " wins!");
            } else {
                System.out.println("It's a draw!");
            }

            System.out.print("Play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();
            playAgain = playAgainResponse.equals("yes");
        }

        System.out.println("Thanks for playing Tic-Tac-Toe!");
        scanner.close();
    }

    public static void printBoard(char[][] board) {
        System.out.println("   0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + "  ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("  -------");
            }
        }
    }

    public static boolean isValidMove(char[][] board, int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }

    public static boolean checkWin(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true; // Horizontal win
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true; // Vertical win
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true; // Diagonal win (top-left to bottom-right)
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true; // Diagonal win (top-right to bottom-left)
        }
        return false;
    }
}
