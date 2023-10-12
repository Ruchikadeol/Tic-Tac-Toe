import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };
        
        char currentPlayer = 'X';
        boolean isGameFinished = false;
        
        Scanner scanner = new Scanner(System.in);
        
        while (!isGameFinished) {
            // Display the current board
            displayBoard(board);
            
            // Get the current player's move
            System.out.println("Player " + currentPlayer + ", enter your move (row [0-2] and column [0-2]): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            
            // Check if the move is valid
            if (isValidMove(board, row, col)) {
                board[row][col] = currentPlayer;
                
                // Check if the current player wins
                if (isWin(board, currentPlayer)) {
                    displayBoard(board);
                    System.out.println("Player " + currentPlayer + " wins!");
                    isGameFinished = true;
                } else {
                    // Check if the board is full (tie)
                    if (isBoardFull(board)) {
                        displayBoard(board);
                        System.out.println("It's a tie!");
                        isGameFinished = true;
                    } else {
                        // Switch players
                        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                    }
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
        
        scanner.close();
    }
    
    public static void displayBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---------");
            }
        }
    }
    
    public static boolean isValidMove(char[][] board, int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }
    
    public static boolean isWin(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true; // Check rows
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true; // Check columns
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true; // Check diagonal
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true; // Check reverse diagonal
        }
        return false;
    }
    
    public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
