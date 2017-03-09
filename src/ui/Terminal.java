package ui;

import java.util.Scanner;
import game.Game;

public class Terminal {

	private Game game;
	private Scanner scanner;

	public void run() {
		game = new Game();
		scanner = new Scanner(System.in);
		while(!game.isEnd()){
			System.out.println(game.getCurrentPlayerName() + "'s turn");
			
			System.out.println("Row: ");
			int row = scanner.nextInt();
			System.out.println("Col: ");
			int col = scanner.nextInt();
			
			game.currentPlayerTakesAction(row, col);
		}
	}

	private void renderBoard(Game game) {
		int size = game.getBoardSize();
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				String s = game.getSymbolOnBoard(row, col);
				if(s == null) {
					s = "_";
				}
				System.out.print(s);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Terminal ui = new Terminal();
		ui.run();
	}

}
