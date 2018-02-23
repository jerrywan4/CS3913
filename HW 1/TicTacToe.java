import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;

/*
Programmer: Jerry Wan
jw36503650
N12474893
TicTacToe.java

Description:
A simple 2 player tic tac toe game written in Java
*/

public class TicTacToe {
	static String[] board; //Board initialized as array of strings
	static String turn; //Turn tracker initialized as string
	static Scanner in; //Scanner initialized

	//MAIN
	public static void main(String[] args) {
		board = new String[9];
		turn = "X";
		String goal_state = null;
		in = new Scanner(System.in);
		generateBoard();
		System.out.println("Welcome to Tic-Tac-Toe.");
		System.out.println("-----------------------");
		displayBoard();
		System.out.println("Player X will go first. Please enter the position you would like to play: ");

		while (goal_state == null) {
			int playerInput;
			try {
				playerInput = in.nextInt();
				//Sanitize input
				if (!(playerInput >= 1 && playerInput <= 9)) {
					System.out.println("Invalid move! Please re-enter position: ");
					continue;
				}
			} catch (InputMismatchException e) {
				//Sanitize input
				System.out.println("Invalid move! Please re-enter position: ");
				continue;
			}
			//check if position number exists on board
			if (board[playerInput-1].equals(String.valueOf(playerInput))) {
				board[playerInput-1] = turn;
				//Next turn is O if current turn is X
				if (turn.equals("X")) {
					turn = "O";
				} else { //Next turn is X if current turn is O
					turn = "X";
				}
				displayBoard();
				goal_state = checkGoalState();
			} else {
				//Check if position is taken by an X or O already
				System.out.println("Position is already taken! Please re-enter position: ");
				continue;
			}
		}
		//Check for draw goal state
		if (goal_state.equals("draw")) {
			System.out.println("The game ended in a draw. Please try again.");
		} else { //Check for player win state
			System.out.println("Congratulations! Player " + goal_state + " has won! Thanks for playing.");
		}
	}

	//Function to generate board with ints as strings
	static void generateBoard() {
		for (int a = 0; a < 9; a++) {
			board[a] = String.valueOf(a+1);
		}
	}

	//Function to display board to console
	static void displayBoard() {
		System.out.println("|-----------|");
		System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
		System.out.println("|-----------|");
	}

	//Function to check if there is a goal state reached, i.e. there is a goal_state or draw
	static String checkGoalState() {
		for (int a = 0; a < 8; a++) {
			String line = null;
			switch (a) { //All player win cases
			case 0:
				line = board[0] + board[1] + board[2];
				break;
			case 1:
				line = board[3] + board[4] + board[5];
				break;
			case 2:
				line = board[6] + board[7] + board[8];
				break;
			case 3:
				line = board[0] + board[3] + board[6];
				break;
			case 4:
				line = board[1] + board[4] + board[7];
				break;
			case 5:
				line = board[2] + board[5] + board[8];
				break;
			case 6:
				line = board[0] + board[4] + board[8];
				break;
			case 7:
				line = board[2] + board[4] + board[6];
				break;
			}
			if (line.equals("XXX")) {
				return "X";
			} else if (line.equals("OOO")) {
				return "O";
			}
		}

		//Draw case
		for (int a = 0; a < 9; a++) {
			if (Arrays.asList(board).contains(String.valueOf(a+1))) {
				break;
			}
			else if (a == 8) return "draw";
		}

		System.out.println("Player " + turn + "'s turn! Please enter a position to place " + turn + " in: ");
		return null;
	}
}