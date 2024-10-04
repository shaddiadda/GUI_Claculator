package level2;

import java.util.Scanner;

public class TicTacToe {
	private static char[][] board = new char[3][3];
	private static char currentPlayer = 'X';

	public static void main(String[] args) {
		initializeBoard();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			printBoard();
			System.out.println("Player " + currentPlayer + ", enter your move (1-9): ");
			int move = scanner.nextInt();
			if (board[(move - 1) / 3][(move - 1) % 3] != ' ') {
				System.out.println("Invalid move, try again.");
				continue;
			}
			board[(move - 1) / 3][(move - 1) % 3] = currentPlayer;
			if (isWinner()) {
				printBoard();
				System.out.println("Player " + currentPlayer + " wins! ");
				playAgain(scanner);
			} else if (isBoardFull()) {
				printBoard();
				System.out.println("The game is a tie!");
				playAgain(scanner);
			} else {
				currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
			}
		}
	}

	private static void initializeBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = ' ';
			}
		}
	}

	private static void printBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
			if (i < 2) {
				System.out.println("---------");
			}
		}
	}

	private static boolean isWinner() {
		// Check rows
		for (int i = 0; i < 3; i++) {
			if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') {
				return true;
			}
		}
		// Check columns
		for (int i = 0; i < 3; i++) {
			if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ') {
				return true;
			}
		}
		// Check diagonals
		if ((board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ')
				|| (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ')) {
			return true;
		}
		return false;
	}

	private static boolean isBoardFull() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == ' ') {
					return false;
				}
			}
		}
		return true;
	}

	private static void playAgain(Scanner scanner) {
		System.out.println("Do you want to play again? (y/n)");
		char response = scanner.next().charAt(0);
		if (response == 'y') {
			initializeBoard();
			currentPlayer = 'X';
		} else {
			System.exit(0);
		}
	}
}
