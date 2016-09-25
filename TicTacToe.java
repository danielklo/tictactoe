import java.util.Random;

/**
 * The program plays ticTacToe
 * ===========================
 * The player picks between X or O. Who starts first is decided with a coin flip.
 * Your opponent uses a random number generator to pick grid references.
 * After each match you'll get the option to play again, wins, losses, draws,
 * win streaks and total amount of matches will be counted and displayed.
 */
class TicTacToe {
 	public static void main(String[] args) {
 		/* Loop Conditions */
		boolean characterLoop = true;
		boolean coinFlipLoop;
		boolean coinFlipResultLoop;
		boolean gameLoop = true;
		/* Playable Characters */
		char playerChar = 0;
		char computerChar = 0;
		/* Board Grid References */
		char a1;
		char a2;
		char a3;
		char b1;
		char b2;
		char b3;
		char c1;
		char c2;
		char c3;
		/* Game Data */
		int continuePlaying = 1; // Consider removal
		int coinFlip;
		int coinFlipResult;
		int playerTurn = 1; // Consider removal
		int playAgain = 1; // Consider removal
		int playerStart = 0; //1 = Player start, 2 = Computer start
		/* Game Statistics */
		int match = 0;
		int defeat = 0;
		int victory = 0;
		int draw = 0;
		int winStreak = 0;
		/* Player Input */
		String inputPlayAgain = "";
		String inputPlayerChar;
		String inputCoinFlip;

		/*
		 * The character selection is to make the player pick between X or O.
		 * The character selected will represent the player through out the game. 
		 */
		System.out.print(" Tic - Tac - Toe!\n==================\n\n");
		do {
			System.out.print("Enter a your symbol X or O: ");
			inputPlayerChar = System.console().readLine();
			if (inputPlayerChar.toLowerCase().contains("x") || inputPlayerChar.contains("1")) { //Checks input for valid player characters
				characterLoop = false;
				computerChar = 'O';
				playerChar = 'X';
			} else if (inputPlayerChar.toLowerCase().contains("o") || inputPlayerChar.contains("2")) { //Checks input for valid player characters
				characterLoop = false;
				computerChar = 'X';
				playerChar = 'O';
			} else {
				System.out.print("ERROR! Pick a valid character!\n");
			}
		} while (characterLoop);
		System.out.print("You picked " + playerChar + ".\n\n");

		/*
		 * The coin flip selection is there to interactivly decide who gets to
		 * start first. The player picks a coin side.
		 */
		playAgainDraw: // Consider removal
		do {
			System.out.print("A coin flip will decide who starts first.\n");
			coinFlip = 0;
			coinFlipLoop = true;
			do {
				System.out.print("Enter Heads or Tails: ");
				inputCoinFlip = System.console().readLine();
				if (inputCoinFlip.toLowerCase().contains("h") || inputCoinFlip.contains("1")) { //Checks input for valid coin flip choice
					System.out.print("You picked Heads.\n\n");
					coinFlip = 1;
					coinFlipLoop = false;
				} else if (inputCoinFlip.toLowerCase().contains("t") || inputCoinFlip.contains("2")) { //Checks input for valid coin flip choice
					System.out.print("You picked Tails.\n\n");
					coinFlip = 2;
					coinFlipLoop = false;
				} else {
					System.out.print("ERROR! Pick a side of the coin!\n");
				}
			} while (coinFlipLoop);

			/*
			 * This section picks a random outcome for the coin flip and checks
			 * if it matches the players choice in the previous section.
			 * This will decide who gets to start.
			 */
			System.out.print("Flipping coin!\n");
			Random coinFlipRNG = new Random();
			coinFlipResult = coinFlipRNG.nextInt(2) + 1; //Pluss 1 as random includes 0
			coinFlipResultLoop = true;
			do {
				if (Math.abs(coinFlipResult) == 1) {
					System.out.print("Heads.\n\n");
				} else {
					System.out.print("Tails.\n\n");
				}
				if (Math.abs(coinFlipResult) == coinFlip) {
					System.out.print("You get to start first!\n");
					playerStart = 1;
					coinFlipResultLoop = false;
				} else if (Math.abs(coinFlipResult) != coinFlip) {
					System.out.print("Your opponent starts first.\n");
					playerStart = 2;
					coinFlipResultLoop = false;
				} else {
					System.out.print("ERROR! Coin flip failed!\n");
				}			
			} while (coinFlipResultLoop);
			playAgain:
			while (playAgain == 1) {
				a1 = ' ';
				a2 = ' ';
				a3 = ' ';
				b1 = ' ';
				b2 = ' ';
				b3 = ' ';
				c1 = ' ';
				c2 = ' ';
				c3 = ' ';
				int turn = 0;
				switch (playerStart) {
					case 1: { //Player starts
						do {
							// Displays current board status.
				 			System.out.print("     A   B   C\n   +---+---+---+\n 1 | " + a1 + " | " + b1 + " | " + c1 + " |\n   +---+---+---+\n 2 | " + a2 + " | " + b2 + " | " + c2 + " |\n   +---+---+---+\n 3 | " + a3 + " | " + b3 + " | " + c3 + " |\n   +---+---+---+\n");
							playerTurn = 1;
							// Player's turn: Translates input to grid reference, checks if grid is empty.
							playerTurn:
							while (playerTurn == 1) {
								System.out.print("Enter grid reference: ");
								String inputGridRef = System.console().readLine();
								if ((inputGridRef.indexOf("a1") != -1 || inputGridRef.indexOf("1a") != -1 || inputGridRef.indexOf("A1") != -1 || inputGridRef.indexOf("1A") != -1) && a1 == ' ') {
									a1 = playerChar;
									playerTurn--;
								} else if ((inputGridRef.indexOf("a2") != -1 || inputGridRef.indexOf("2a") != -1 || inputGridRef.indexOf("A2") != -1 || inputGridRef.indexOf("2A") != -1) && a2 == ' ') {
									a2 = playerChar;
									playerTurn--;
								} else if ((inputGridRef.indexOf("a3") != -1 || inputGridRef.indexOf("3a") != -1 || inputGridRef.indexOf("A3") != -1 || inputGridRef.indexOf("3A") != -1) && a3 == ' ') {
									a3 = playerChar;
									playerTurn--;
								} else if ((inputGridRef.indexOf("b1") != -1 || inputGridRef.indexOf("1b") != -1 || inputGridRef.indexOf("B1") != -1 || inputGridRef.indexOf("1B") != -1) && b1 == ' ') {
									b1 = playerChar;
									playerTurn--;
								} else if ((inputGridRef.indexOf("b2") != -1 || inputGridRef.indexOf("2b") != -1 || inputGridRef.indexOf("B2") != -1 || inputGridRef.indexOf("2B") != -1) && b2 == ' ') {
									b2 = playerChar;
									playerTurn--;
								} else if ((inputGridRef.indexOf("b3") != -1 || inputGridRef.indexOf("3b") != -1 || inputGridRef.indexOf("B3") != -1 || inputGridRef.indexOf("3B") != -1) && b3 == ' ') {
									b3 = playerChar;
									playerTurn--;
								} else if ((inputGridRef.indexOf("c1") != -1 || inputGridRef.indexOf("1c") != -1 || inputGridRef.indexOf("C1") != -1 || inputGridRef.indexOf("1C") != -1) && c1 == ' ') {
									c1 = playerChar;
									playerTurn--;
								} else if ((inputGridRef.indexOf("c2") != -1 || inputGridRef.indexOf("2c") != -1 || inputGridRef.indexOf("C2") != -1 || inputGridRef.indexOf("2C") != -1) && c2 == ' ') {
									c2 = playerChar;
									playerTurn--;
								} else if ((inputGridRef.indexOf("c3") != -1 || inputGridRef.indexOf("3c") != -1 || inputGridRef.indexOf("C3") != -1 || inputGridRef.indexOf("3C") != -1) && c3 == ' ') {
									c3 = playerChar;
									playerTurn--;
								} else {
									System.out.print("ERROR! Enter a valid grid reference!\n");
									continue playerTurn;
								}
							}
							turn++;
							// Check for victory condition
							if (turn >= 5 && a1 == playerChar && a2 == playerChar && a3 == playerChar) {
								match++;
								victory++;
								winStreak++;
								playerStart = 2;
								// Displays current board status.
				 				System.out.print("     A   B   C\n   +---+---+---+\n 1 | " + a1 + " | " + b1 + " | " + c1 + " |\n   +---+---+---+\n 2 | " + a2 + " | " + b2 + " | " + c2 + " |\n   +---+---+---+\n 3 | " + a3 + " | " + b3 + " | " + c3 + " |\n   +---+---+---+\n\n");
								System.out.print("You won!\n========\n Rounds: " + match + "\n");
								if (victory >= 1) {
									System.out.print(" Wins: " + victory + "\n");
								}
								if (defeat >= 1) {
									System.out.print(" Losses: " + defeat + "\n");
								}
								if (draw >= 1) {
									System.out.print(" Draw: " + draw + "\n");
								}
								if (winStreak >= 2) {
									System.out.print(" Win streak: " + winStreak + "\n");
								}
								System.out.print("\nPlay again? (Y/N): ");
								continuePlaying = 1;
								yesNoQuestion:
								while (continuePlaying == 1) {
									inputPlayAgain = System.console().readLine();
									if (inputPlayAgain.indexOf('Y') != -1 || inputPlayAgain.indexOf('y') != -1) {
										continuePlaying = 0;
										continue playAgain;
									} else if (inputPlayAgain.indexOf('N') != -1 || inputPlayAgain.indexOf('n') != -1) {
										System.exit(0);
									} else {
										System.out.print("ERROR! Please type Y or N: ");
										continue yesNoQuestion;
									}
								}
							} else if (turn >= 5 && b1 == playerChar && b2 == playerChar && b3 == playerChar) {
								match++;
								victory++;
								winStreak++;
								playerStart = 2;
								System.out.print("     A   B   C\n   +---+---+---+\n 1 | " + a1 + " | " + b1 + " | " + c1 + " |\n   +---+---+---+\n 2 | " + a2 + " | " + b2 + " | " + c2 + " |\n   +---+---+---+\n 3 | " + a3 + " | " + b3 + " | " + c3 + " |\n   +---+---+---+\n\n");
								System.out.print("You won!\n========\n Rounds: " + match + "\n");
								if (victory >= 1) {
									System.out.print(" Wins: " + victory + "\n");
								}
								if (defeat >= 1) {
									System.out.print(" Losses: " + defeat + "\n");
								}
								if (draw >= 1) {
									System.out.print(" Draw: " + draw + "\n");
								}
								if (winStreak >= 2) {
									System.out.print(" Win streak: " + winStreak + "\n");
								}
								System.out.print("\nPlay again? (Y/N): ");
								continuePlaying = 1;
								yesNoQuestion:
								while (continuePlaying == 1) {
									inputPlayAgain = System.console().readLine();
									if (inputPlayAgain.indexOf('Y') != -1 || inputPlayAgain.indexOf('y') != -1) {
										continuePlaying = 0;
										continue playAgain;
									} else if (inputPlayAgain.indexOf('N') != -1 || inputPlayAgain.indexOf('n') != -1) {
										System.exit(0);
									} else {
										System.out.print("ERROR! Please type Y or N: ");
										continue yesNoQuestion;
									}
								}
							} else if (turn >= 5 && c1 == playerChar && c2 == playerChar && c3 == playerChar) {
								match++;
								victory++;
								winStreak++;
								playerStart = 2;
								System.out.print("     A   B   C\n   +---+---+---+\n 1 | " + a1 + " | " + b1 + " | " + c1 + " |\n   +---+---+---+\n 2 | " + a2 + " | " + b2 + " | " + c2 + " |\n   +---+---+---+\n 3 | " + a3 + " | " + b3 + " | " + c3 + " |\n   +---+---+---+\n\n");
								System.out.print("You won!\n========\n Rounds: " + match + "\n");
								if (victory >= 1) {
									System.out.print(" Wins: " + victory + "\n");
								}
								if (defeat >= 1) {
									System.out.print(" Losses: " + defeat + "\n");
								}
								if (draw >= 1) {
									System.out.print(" Draw: " + draw + "\n");
								}
								if (winStreak >= 2) {
									System.out.print(" Win streak: " + winStreak + "\n");
								}
								System.out.print("\nPlay again? (Y/N): ");
								continuePlaying = 1;
								yesNoQuestion:
								while (continuePlaying == 1) {
									inputPlayAgain = System.console().readLine();
									if (inputPlayAgain.indexOf('Y') != -1 || inputPlayAgain.indexOf('y') != -1) {
										continuePlaying = 0;
										continue playAgain;
									} else if (inputPlayAgain.indexOf('N') != -1 || inputPlayAgain.indexOf('n') != -1) {
											System.exit(0);
									} else {
										System.out.print("ERROR! Please type Y or N: ");
										continue yesNoQuestion;
									}
								}
							} else if (turn >= 5 && a1 == playerChar && b1 == playerChar && c1 == playerChar) {
								match++;
								victory++;
								winStreak++;
								playerStart = 2;
								System.out.print("     A   B   C\n   +---+---+---+\n 1 | " + a1 + " | " + b1 + " | " + c1 + " |\n   +---+---+---+\n 2 | " + a2 + " | " + b2 + " | " + c2 + " |\n   +---+---+---+\n 3 | " + a3 + " | " + b3 + " | " + c3 + " |\n   +---+---+---+\n\n");
								System.out.print("You won!\n========\n Rounds: " + match + "\n");
								if (victory >= 1) {
									System.out.print(" Wins: " + victory + "\n");
								}
								if (defeat >= 1) {
									System.out.print(" Losses: " + defeat + "\n");
								}
								if (draw >= 1) {
									System.out.print(" Draw: " + draw + "\n");
								}
								if (winStreak >= 2) {
									System.out.print(" Win streak: " + winStreak + "\n");
								}
								System.out.print("\nPlay again? (Y/N): ");
								continuePlaying = 1;
								yesNoQuestion:
								while (continuePlaying == 1) {
									inputPlayAgain = System.console().readLine();
									if (inputPlayAgain.indexOf('Y') != -1 || inputPlayAgain.indexOf('y') != -1) {
										continuePlaying = 0;
										continue playAgain;
									} else if (inputPlayAgain.indexOf('N') != -1 || inputPlayAgain.indexOf('n') != -1) {
										System.exit(0);
									} else {
										System.out.print("ERROR! Please type Y or N: ");
										continue yesNoQuestion;
									}
								}
							} else if (turn >= 5 && a2 == playerChar && b2 == playerChar && c2 == playerChar) {
								match++;
								victory++;
								winStreak++;
								playerStart = 2;
								System.out.print("     A   B   C\n   +---+---+---+\n 1 | " + a1 + " | " + b1 + " | " + c1 + " |\n   +---+---+---+\n 2 | " + a2 + " | " + b2 + " | " + c2 + " |\n   +---+---+---+\n 3 | " + a3 + " | " + b3 + " | " + c3 + " |\n   +---+---+---+\n\n");
								System.out.print("You won!\n========\n Rounds: " + match + "\n");
								if (victory >= 1) {
									System.out.print(" Wins: " + victory + "\n");
								}
								if (defeat >= 1) {
									System.out.print(" Losses: " + defeat + "\n");
								}
								if (draw >= 1) {
									System.out.print(" Draw: " + draw + "\n");
								}
								if (winStreak >= 2) {
									System.out.print(" Win streak: " + winStreak + "\n");
								}
								System.out.print("\nPlay again? (Y/N): ");
								continuePlaying = 1;
								yesNoQuestion:
								while (continuePlaying == 1) {
									inputPlayAgain = System.console().readLine();
									if (inputPlayAgain.indexOf('Y') != -1 || inputPlayAgain.indexOf('y') != -1) {
										continuePlaying = 0;
										continue playAgain;
									} else if (inputPlayAgain.indexOf('N') != -1 || inputPlayAgain.indexOf('n') != -1) {
										System.exit(0);
									} else {
										System.out.print("ERROR! Please type Y or N: ");
										continue yesNoQuestion;
									}
								}
							} else if (turn >= 5 && a3 == playerChar && b3 == playerChar && c3 == playerChar) {
									match++;
									victory++;
									winStreak++;
									playerStart = 2;
									System.out.print("     A   B   C\n   +---+---+---+\n 1 | " + a1 + " | " + b1 + " | " + c1 + " |\n   +---+---+---+\n 2 | " + a2 + " | " + b2 + " | " + c2 + " |\n   +---+---+---+\n 3 | " + a3 + " | " + b3 + " | " + c3 + " |\n   +---+---+---+\n\n");
									System.out.print("You won!\n========\n Rounds: " + match + "\n");
									if (victory >= 1) {
										System.out.print(" Wins: " + victory + "\n");
									}
									if (defeat >= 1) {
										System.out.print(" Losses: " + defeat + "\n");
									}
									if (draw >= 1) {
										System.out.print(" Draw: " + draw + "\n");
									}
									if (winStreak >= 2) {
										System.out.print(" Win streak: " + winStreak + "\n");
									}
									System.out.print("\nPlay again? (Y/N): ");
									continuePlaying = 1;
									yesNoQuestion:
									while (continuePlaying == 1) {
										inputPlayAgain = System.console().readLine();
										if (inputPlayAgain.indexOf('Y') != -1 || inputPlayAgain.indexOf('y') != -1) {
											continuePlaying = 0;
											continue playAgain;
										} else if (inputPlayAgain.indexOf('N') != -1 || inputPlayAgain.indexOf('n') != -1) {
											System.exit(0);
										} else {
											System.out.print("ERROR! Please type Y or N: ");
											continue yesNoQuestion;
										}
									}
							} else if (turn >= 5 && a1 == playerChar && b2 == playerChar && c3 == playerChar) {
								match++;
								victory++;
								winStreak++;
								playerStart = 2;
								System.out.print("     A   B   C\n   +---+---+---+\n 1 | " + a1 + " | " + b1 + " | " + c1 + " |\n   +---+---+---+\n 2 | " + a2 + " | " + b2 + " | " + c2 + " |\n   +---+---+---+\n 3 | " + a3 + " | " + b3 + " | " + c3 + " |\n   +---+---+---+\n\n");
								System.out.print("You won!\n========\n Rounds: " + match + "\n");
								if (victory >= 1) {
									System.out.print(" Wins: " + victory + "\n");
								}
								if (defeat >= 1) {
									System.out.print(" Losses: " + defeat + "\n");
								}
								if (draw >= 1) {
									System.out.print(" Draw: " + draw + "\n");
								}
								if (winStreak >= 2) {
									System.out.print(" Win streak: " + winStreak + "\n");
								}
								System.out.print("\nPlay again? (Y/N): ");
								continuePlaying = 1;
								yesNoQuestion:
								while (continuePlaying == 1) {
									inputPlayAgain = System.console().readLine();
									if (inputPlayAgain.indexOf('Y') != -1 || inputPlayAgain.indexOf('y') != -1) {
										continuePlaying = 0;
										continue playAgain;
									} else if (inputPlayAgain.indexOf('N') != -1 || inputPlayAgain.indexOf('n') != -1) {
										System.exit(0);
									} else {
										System.out.print("ERROR! Please type Y or N: ");
										continue yesNoQuestion;
									}
								}
							} else if (turn >= 5 && a3 == playerChar && b2 == playerChar && c1 == playerChar) {
								match++;
								victory++;
								winStreak++;
								playerStart = 2;
								System.out.print("     A   B   C\n   +---+---+---+\n 1 | " + a1 + " | " + b1 + " | " + c1 + " |\n   +---+---+---+\n 2 | " + a2 + " | " + b2 + " | " + c2 + " |\n   +---+---+---+\n 3 | " + a3 + " | " + b3 + " | " + c3 + " |\n   +---+---+---+\n\n");
								System.out.print("You won!\n========\n Rounds: " + match + "\n");
								if (victory >= 1) {
									System.out.print(" Wins: " + victory + "\n");
								}
								if (defeat >= 1) {
									System.out.print(" Losses: " + defeat + "\n");
								}
								if (draw >= 1) {
									System.out.print(" Draw: " + draw + "\n");
								}
								if (winStreak >= 2) {
									System.out.print(" Win streak: " + winStreak + "\n");
								}
								System.out.print("\nPlay again? (Y/N): ");
								continuePlaying = 1;
								yesNoQuestion:
								while (continuePlaying == 1) {
									inputPlayAgain = System.console().readLine();
									if (inputPlayAgain.indexOf('Y') != -1 || inputPlayAgain.indexOf('y') != -1) {
										continuePlaying = 0;
										continue playAgain;
									} else if (inputPlayAgain.indexOf('N') != -1 || inputPlayAgain.indexOf('n') != -1) {
										System.exit(0);
									} else {
										System.out.print("ERROR! Please type Y or N: ");
										continue yesNoQuestion;
									}
								}
							} else if (turn == 9) {
								match++;
								draw++;
								winStreak = 0;
								playerStart = 0;
								System.out.print("     A   B   C\n   +---+---+---+\n 1 | " + a1 + " | " + b1 + " | " + c1 + " |\n   +---+---+---+\n 2 | " + a2 + " | " + b2 + " | " + c2 + " |\n   +---+---+---+\n 3 | " + a3 + " | " + b3 + " | " + c3 + " |\n   +---+---+---+\n\n");
								System.out.print("Draw!\n========\n Rounds: " + match + "\n");
								if (victory >= 1) {
									System.out.print(" Wins: " + victory + "\n");
								}
								if (defeat >= 1) {
									System.out.print(" Losses: " + defeat + "\n");
								}
								if (draw >= 1) {
									System.out.print(" Draw: " + draw + "\n");
								}
								System.out.print("\nPlay again? (Y/N): ");
								continuePlaying = 1;
								yesNoQuestion:
								while (continuePlaying == 1) {
									inputPlayAgain = System.console().readLine();
									if (inputPlayAgain.indexOf('Y') != -1 || inputPlayAgain.indexOf('y') != -1) {
										continuePlaying = 0;
										continue playAgainDraw;
									} else if (inputPlayAgain.indexOf('N') != -1 || inputPlayAgain.indexOf('n') != -1) {
										System.exit(0);
									} else {
										System.out.print("ERROR! Please type Y or N: ");
										continue yesNoQuestion;
									}
								}
							}

							/*
							 * Computer's turn: generate random number corresponding to grid reference, 
							 * check if grid is empty
							 */
							int computerTurn = 1;
							computerTurn:
							while (computerTurn == 1) {
								Random computerTurnRNG = new Random();
								int computerTurnResult = computerTurnRNG.nextInt(9);
								if (a1 == ' ' && Math.abs(computerTurnResult) == 0) {
									a1 = computerChar;
									computerTurn--;
								} else if (a2 == ' ' && Math.abs(computerTurnResult) == 1) {
									a2 = computerChar;
									computerTurn--;
								} else if (a3 == ' ' && Math.abs(computerTurnResult) == 2) {
									a3 = computerChar;
									computerTurn--;
								} else if (b1 == ' ' && Math.abs(computerTurnResult) == 3) {
									b1 = computerChar;
									computerTurn--;
								} else if (b2 == ' ' && Math.abs(computerTurnResult) == 4) {
									b2 = computerChar;
									computerTurn--;
								} else if (b3 == ' ' && Math.abs(computerTurnResult) == 5) {
									b3 = computerChar;
									computerTurn--;
								} else if (c1 == ' ' && Math.abs(computerTurnResult) == 6) {
									c1 = computerChar;
									computerTurn--;
								} else if (c2 == ' ' && Math.abs(computerTurnResult) == 7) {
									c2 = computerChar;
									computerTurn--;
								} else if (c3 == ' ' && Math.abs(computerTurnResult) == 8) {
									c3 = computerChar;
									computerTurn--;
								} else {
									continue computerTurn;
								}
							}
							turn++;
							// Check for victory condition.
							if (turn >= 5 && a1 == computerChar && a2 == computerChar && a3 == computerChar) {
								match++;
								defeat++;
								winStreak = 0;
								playerStart = 1;
								System.out.print("     A   B   C\n   +---+---+---+\n 1 | " + a1 + " | " + b1 + " | " + c1 + " |\n   +---+---+---+\n 2 | " + a2 + " | " + b2 + " | " + c2 + " |\n   +---+---+---+\n 3 | " + a3 + " | " + b3 + " | " + c3 + " |\n   +---+---+---+\n\n");
								System.out.print("You lost!\n========\n Rounds: " + match + "\n");
								if (victory >= 1) {
									System.out.print(" Wins: " + victory + "\n");
								}
								if (defeat >= 1) {
									System.out.print(" Losses: " + defeat + "\n");
								}
								if (draw >= 1) {
									System.out.print(" Draw: " + draw + "\n");
								}
								System.out.print("\nPlay again? (Y/N): ");
								continuePlaying = 1;
								yesNoQuestion:
								while (continuePlaying == 1) {
									inputPlayAgain = System.console().readLine();
									if (inputPlayAgain.indexOf('Y') != -1 || inputPlayAgain.indexOf('y') != -1) {
										continuePlaying = 0;
										continue playAgain;
									} else if (inputPlayAgain.indexOf('N') != -1 || inputPlayAgain.indexOf('n') != -1) {
										System.exit(0);
									} else {
										System.out.print("ERROR! Please type Y or N: ");
										continue yesNoQuestion;
									}
								}
							} else if (turn >= 5 && b1 == computerChar && b2 == computerChar && b3 == computerChar) {
								match++;
								defeat++;
								winStreak = 0;
								playerStart = 1;
								System.out.print("     A   B   C\n   +---+---+---+\n 1 | " + a1 + " | " + b1 + " | " + c1 + " |\n   +---+---+---+\n 2 | " + a2 + " | " + b2 + " | " + c2 + " |\n   +---+---+---+\n 3 | " + a3 + " | " + b3 + " | " + c3 + " |\n   +---+---+---+\n\n");
								System.out.print("You lost!\n========\n Rounds: " + match + "\n");
								if (victory >= 1) {
									System.out.print(" Wins: " + victory + "\n");
								}
								if (defeat >= 1) {
									System.out.print(" Losses: " + defeat + "\n");
								}
								if (draw >= 1) {
									System.out.print(" Draw: " + draw + "\n");
								}
								System.out.print("\nPlay again? (Y/N): ");
								continuePlaying = 1;
								yesNoQuestion:
								while (continuePlaying == 1) {
									inputPlayAgain = System.console().readLine();
									if (inputPlayAgain.indexOf('Y') != -1 || inputPlayAgain.indexOf('y') != -1) {
										continuePlaying = 0;
										continue playAgain;
									} else if (inputPlayAgain.indexOf('N') != -1 || inputPlayAgain.indexOf('n') != -1) {
										System.exit(0);
									} else {
										System.out.print("ERROR! Please type Y or N: ");
										continue yesNoQuestion;
									}
								}
							} else if (turn >= 5 && c1 == computerChar && c2 == computerChar && c3 == computerChar) {
								match++;
								defeat++;
								winStreak = 0;
								playerStart = 1;
								System.out.print("     A   B   C\n   +---+---+---+\n 1 | " + a1 + " | " + b1 + " | " + c1 + " |\n   +---+---+---+\n 2 | " + a2 + " | " + b2 + " | " + c2 + " |\n   +---+---+---+\n 3 | " + a3 + " | " + b3 + " | " + c3 + " |\n   +---+---+---+\n\n");
								System.out.print("You lost!\n========\n Rounds: " + match + "\n");
								if (victory >= 1) {
									System.out.print(" Wins: " + victory + "\n");
								}
								if (defeat >= 1) {
									System.out.print(" Losses: " + defeat + "\n");
								}
								if (draw >= 1) {
									System.out.print(" Draw: " + draw + "\n");
								}
								System.out.print("\nPlay again? (Y/N): ");
								continuePlaying = 1;
								yesNoQuestion:
								while (continuePlaying == 1) {
									inputPlayAgain = System.console().readLine();
									if (inputPlayAgain.indexOf('Y') != -1 || inputPlayAgain.indexOf('y') != -1) {
										continuePlaying = 0;
										continue playAgain;
									} else if (inputPlayAgain.indexOf('N') != -1 || inputPlayAgain.indexOf('n') != -1) {
										System.exit(0);
									} else {
										System.out.print("ERROR! Please type Y or N: ");
										continue yesNoQuestion;
									}
								}
							} else if (turn >= 5 && a1 == computerChar && b1 == computerChar && c1 == computerChar) {
								match++;
								defeat++;
								winStreak = 0;
								playerStart = 1;
								System.out.print("     A   B   C\n   +---+---+---+\n 1 | " + a1 + " | " + b1 + " | " + c1 + " |\n   +---+---+---+\n 2 | " + a2 + " | " + b2 + " | " + c2 + " |\n   +---+---+---+\n 3 | " + a3 + " | " + b3 + " | " + c3 + " |\n   +---+---+---+\n\n");
								System.out.print("You lost!\n========\n Rounds: " + match + "\n");
								if (victory >= 1) {
									System.out.print(" Wins: " + victory + "\n");
								}
								if (defeat >= 1) {
									System.out.print(" Losses: " + defeat + "\n");
								}
								if (draw >= 1) {
									System.out.print(" Draw: " + draw + "\n");
								}
								System.out.print("\nPlay again? (Y/N): ");
								continuePlaying = 1;
								yesNoQuestion:
								while (continuePlaying == 1) {
									inputPlayAgain = System.console().readLine();
									if (inputPlayAgain.indexOf('Y') != -1 || inputPlayAgain.indexOf('y') != -1) {
										continuePlaying = 0;
										continue playAgain;
									} else if (inputPlayAgain.indexOf('N') != -1 || inputPlayAgain.indexOf('n') != -1) {
										System.exit(0);
									} else {
										System.out.print("ERROR! Please type Y or N: ");
										continue yesNoQuestion;
									}
								}
							} else if (turn >= 5 && a2 == computerChar && b2 == computerChar && c2 == computerChar) {
								match++;
								defeat++;
								winStreak = 0;
								playerStart = 1;
								System.out.print("     A   B   C\n   +---+---+---+\n 1 | " + a1 + " | " + b1 + " | " + c1 + " |\n   +---+---+---+\n 2 | " + a2 + " | " + b2 + " | " + c2 + " |\n   +---+---+---+\n 3 | " + a3 + " | " + b3 + " | " + c3 + " |\n   +---+---+---+\n\n");
								System.out.print("You lost!\n========\n Rounds: " + match + "\n");
								if (victory >= 1) {
									System.out.print(" Wins: " + victory + "\n");
								}
								if (defeat >= 1) {
									System.out.print(" Losses: " + defeat + "\n");
								}
								if (draw >= 1) {
									System.out.print(" Draw: " + draw + "\n");
								}
								System.out.print("\nPlay again? (Y/N): ");
								continuePlaying = 1;
								yesNoQuestion:
								while (continuePlaying == 1) {
									inputPlayAgain = System.console().readLine();
									if (inputPlayAgain.indexOf('Y') != -1 || inputPlayAgain.indexOf('y') != -1) {
										continuePlaying = 0;
										continue playAgain;
									} else if (inputPlayAgain.indexOf('N') != -1 || inputPlayAgain.indexOf('n') != -1) {
										System.exit(0);
									} else {
										System.out.print("ERROR! Please type Y or N: ");
										continue yesNoQuestion;
									}
								}
							} else if (turn >= 5 && a3 == computerChar && b3 == computerChar && c3 == computerChar) {
								match++;
								defeat++;
								winStreak = 0;
								playerStart = 1;
								System.out.print("     A   B   C\n   +---+---+---+\n 1 | " + a1 + " | " + b1 + " | " + c1 + " |\n   +---+---+---+\n 2 | " + a2 + " | " + b2 + " | " + c2 + " |\n   +---+---+---+\n 3 | " + a3 + " | " + b3 + " | " + c3 + " |\n   +---+---+---+\n\n");
								System.out.print("You lost!\n========\n Rounds: " + match + "\n");
								if (victory >= 1) {
									System.out.print(" Wins: " + victory + "\n");
								}
								if (defeat >= 1) {
									System.out.print(" Losses: " + defeat + "\n");
								}
								if (draw >= 1) {
									System.out.print(" Draw: " + draw + "\n");
								}
								System.out.print("\nPlay again? (Y/N): ");
								continuePlaying = 1;
								yesNoQuestion:
								while (continuePlaying == 1) {
									inputPlayAgain = System.console().readLine();
									if (inputPlayAgain.indexOf('Y') != -1 || inputPlayAgain.indexOf('y') != -1) {
										continuePlaying = 0;
										continue playAgain;
									} else if (inputPlayAgain.indexOf('N') != -1 || inputPlayAgain.indexOf('n') != -1) {
										System.exit(0);
									} else {
										System.out.print("ERROR! Please type Y or N: ");
										continue yesNoQuestion;
									}
								}
							} else if (turn >= 5 && a1 == computerChar && b2 == computerChar && c3 == computerChar) {
								match++;
								defeat++;
								winStreak = 0;
								playerStart = 1;
								System.out.print("     A   B   C\n   +---+---+---+\n 1 | " + a1 + " | " + b1 + " | " + c1 + " |\n   +---+---+---+\n 2 | " + a2 + " | " + b2 + " | " + c2 + " |\n   +---+---+---+\n 3 | " + a3 + " | " + b3 + " | " + c3 + " |\n   +---+---+---+\n\n");
								System.out.print("You lost!\n========\n Rounds: " + match + "\n");
								if (victory >= 1) {
									System.out.print(" Wins: " + victory + "\n");
								}
								if (defeat >= 1) {
									System.out.print(" Losses: " + defeat + "\n");
								}
								if (draw >= 1) {
									System.out.print(" Draw: " + draw + "\n");
								}
								System.out.print("\nPlay again? (Y/N): ");
								continuePlaying = 1;
								yesNoQuestion:
								while (continuePlaying == 1) {
									inputPlayAgain = System.console().readLine();
									if (inputPlayAgain.indexOf('Y') != -1 || inputPlayAgain.indexOf('y') != -1) {
										continuePlaying = 0;
										continue playAgain;
									} else if (inputPlayAgain.indexOf('N') != -1 || inputPlayAgain.indexOf('n') != -1) {
										System.exit(0);
									} else {
										System.out.print("ERROR! Please type Y or N: ");
										continue yesNoQuestion;
									}
								}
							} else if (turn >= 5 && a3 == computerChar && b2 == computerChar && c1 == computerChar) {
								match++;
								defeat++;
								winStreak = 0;
								playerStart = 1;
								System.out.print("     A   B   C\n   +---+---+---+\n 1 | " + a1 + " | " + b1 + " | " + c1 + " |\n   +---+---+---+\n 2 | " + a2 + " | " + b2 + " | " + c2 + " |\n   +---+---+---+\n 3 | " + a3 + " | " + b3 + " | " + c3 + " |\n   +---+---+---+\n\n");
								System.out.print("You lost!\n========\n Rounds: " + match + "\n");
								if (victory >= 1) {
									System.out.print(" Wins: " + victory + "\n");
								}
								if (defeat >= 1) {
									System.out.print(" Losses: " + defeat + "\n");
								}
								if (draw >= 1) {
									System.out.print(" Draw: " + draw + "\n");
								}
								System.out.print("\nPlay again? (Y/N): ");
								continuePlaying = 1;
								yesNoQuestion:
								while (continuePlaying == 1) {
									inputPlayAgain = System.console().readLine();
									if (inputPlayAgain.indexOf('Y') != -1 || inputPlayAgain.indexOf('y') != -1) {
										continuePlaying = 0;
										continue playAgain;
									} else if (inputPlayAgain.indexOf('N') != -1 || inputPlayAgain.indexOf('n') != -1) {
										System.exit(0);
									} else {
										System.out.print("ERROR! Please type Y or N: ");
										continue yesNoQuestion;
									}
								}
							} else if (turn == 9) {
								match++;
								draw++;
								winStreak = 0;
								playerStart = 0;
								System.out.print("     A   B   C\n   +---+---+---+\n 1 | " + a1 + " | " + b1 + " | " + c1 + " |\n   +---+---+---+\n 2 | " + a2 + " | " + b2 + " | " + c2 + " |\n   +---+---+---+\n 3 | " + a3 + " | " + b3 + " | " + c3 + " |\n   +---+---+---+\n\n");
								System.out.print("Draw!\n========\n Rounds: " + match + "\n");
								if (victory >= 1) {
									System.out.print(" Wins: " + victory + "\n");
								}
								if (defeat >= 1) {
									System.out.print(" Losses: " + defeat + "\n");
								}
								if (draw >= 1) {
									System.out.print(" Draw: " + draw + "\n");
								}
								System.out.print("\nPlay again? (Y/N): ");
								continuePlaying = 1;
								yesNoQuestion:
								while (continuePlaying == 1) {
									inputPlayAgain = System.console().readLine();
									if (inputPlayAgain.indexOf('Y') != -1 || inputPlayAgain.indexOf('y') != -1) {
										continuePlaying = 0;
										continue playAgainDraw;
									} else if (inputPlayAgain.indexOf('N') != -1 || inputPlayAgain.indexOf('n') != -1) {
											System.exit(0);
									} else {
										System.out.print("ERROR! Please type Y or N: ");
										continue yesNoQuestion;
									}
								}
							}
						} while (turn <= 9);
					}
					case 2: { //Computer starts
				 		do {

				 			/*
							 * Computer's turn: generate random number corresponding to grid reference, 
							 * check if grid is empty
							 */
							int computerTurn = 1;
							computerTurn:
							while (computerTurn == 1) {
								Random computerTurnRNG = new Random();
								int computerTurnResult = computerTurnRNG.nextInt(9);
								if (a1 == ' ' && Math.abs(computerTurnResult) == 0) {
									a1 = computerChar;
									computerTurn--;
								} else if (a2 == ' ' && Math.abs(computerTurnResult) == 1) {
									a2 = computerChar;
									computerTurn--;
								} else if (a3 == ' ' && Math.abs(computerTurnResult) == 2) {
									a3 = computerChar;
									computerTurn--;
								} else if (b1 == ' ' && Math.abs(computerTurnResult) == 3) {
									b1 = computerChar;
									computerTurn--;
								} else if (b2 == ' ' && Math.abs(computerTurnResult) == 4) {
									b2 = computerChar;
									computerTurn--;
								} else if (b3 == ' ' && Math.abs(computerTurnResult) == 5) {
									b3 = computerChar;
									computerTurn--;
								} else if (c1 == ' ' && Math.abs(computerTurnResult) == 6) {
									c1 = computerChar;
									computerTurn--;
								} else if (c2 == ' ' && Math.abs(computerTurnResult) == 7) {
									c2 = computerChar;
									computerTurn--;
								} else if (c3 == ' ' && Math.abs(computerTurnResult) == 8) {
									c3 = computerChar;
									computerTurn--;
								} else {
									continue computerTurn;
								}
							}
				 			turn++;
							// Check for victory condition.
							if (turn >= 5 && a1 == computerChar && a2 == computerChar && a3 == computerChar) {
								match++;
								defeat++;
								winStreak = 0;
								playerStart = 1;
								System.out.print("     A   B   C\n   +---+---+---+\n 1 | " + a1 + " | " + b1 + " | " + c1 + " |\n   +---+---+---+\n 2 | " + a2 + " | " + b2 + " | " + c2 + " |\n   +---+---+---+\n 3 | " + a3 + " | " + b3 + " | " + c3 + " |\n   +---+---+---+\n\n");
								System.out.print("You lost!\n========\n Rounds: " + match + "\n");
								if (victory >= 1) {
									System.out.print(" Wins: " + victory + "\n");
								}
								if (defeat >= 1) {
									System.out.print(" Losses: " + defeat + "\n");
								}
								if (draw >= 1) {
									System.out.print(" Draw: " + draw + "\n");
								}
								System.out.print("\nPlay again? (Y/N): ");
								continuePlaying = 1;
								yesNoQuestion:
								while (continuePlaying == 1) {
									inputPlayAgain = System.console().readLine();
									if (inputPlayAgain.indexOf('Y') != -1 || inputPlayAgain.indexOf('y') != -1) {
										continuePlaying = 0;
										continue playAgain;
									} else if (inputPlayAgain.indexOf('N') != -1 || inputPlayAgain.indexOf('n') != -1) {
										System.exit(0);
									} else {
										System.out.print("ERROR! Please type Y or N: ");
										continue yesNoQuestion;
									}
								}
							} else if (turn >= 5 && b1 == computerChar && b2 == computerChar && b3 == computerChar) {
								match++;
								defeat++;
								winStreak = 0;
								playerStart = 1;
								System.out.print("     A   B   C\n   +---+---+---+\n 1 | " + a1 + " | " + b1 + " | " + c1 + " |\n   +---+---+---+\n 2 | " + a2 + " | " + b2 + " | " + c2 + " |\n   +---+---+---+\n 3 | " + a3 + " | " + b3 + " | " + c3 + " |\n   +---+---+---+\n\n");
								System.out.print("You lost!\n========\n Rounds: " + match + "\n");
								if (victory >= 1) {
									System.out.print(" Wins: " + victory + "\n");
								}
								if (defeat >= 1) {
									System.out.print(" Losses: " + defeat + "\n");
								}
								if (draw >= 1) {
									System.out.print(" Draw: " + draw + "\n");
								}
								System.out.print("\nPlay again? (Y/N): ");
								continuePlaying = 1;
								yesNoQuestion:
								while (continuePlaying == 1) {
									inputPlayAgain = System.console().readLine();
									if (inputPlayAgain.indexOf('Y') != -1 || inputPlayAgain.indexOf('y') != -1) {
										continuePlaying = 0;
										continue playAgain;
									} else if (inputPlayAgain.indexOf('N') != -1 || inputPlayAgain.indexOf('n') != -1) {
										System.exit(0);
									} else {
										System.out.print("ERROR! Please type Y or N: ");
										continue yesNoQuestion;
									}
								}
							} else if (turn >= 5 && c1 == computerChar && c2 == computerChar && c3 == computerChar) {
								match++;
								defeat++;
								winStreak = 0;
								playerStart = 1;
								System.out.print("     A   B   C\n   +---+---+---+\n 1 | " + a1 + " | " + b1 + " | " + c1 + " |\n   +---+---+---+\n 2 | " + a2 + " | " + b2 + " | " + c2 + " |\n   +---+---+---+\n 3 | " + a3 + " | " + b3 + " | " + c3 + " |\n   +---+---+---+\n\n");
								System.out.print("You lost!\n========\n Rounds: " + match + "\n");
								if (victory >= 1) {
									System.out.print(" Wins: " + victory + "\n");
								}
								if (defeat >= 1) {
									System.out.print(" Losses: " + defeat + "\n");
								}
								if (draw >= 1) {
									System.out.print(" Draw: " + draw + "\n");
								}
								System.out.print("\nPlay again? (Y/N): ");
								continuePlaying = 1;
								yesNoQuestion:
								while (continuePlaying == 1) {
									inputPlayAgain = System.console().readLine();
									if (inputPlayAgain.indexOf('Y') != -1 || inputPlayAgain.indexOf('y') != -1) {
										continuePlaying = 0;
										continue playAgain;
									} else if (inputPlayAgain.indexOf('N') != -1 || inputPlayAgain.indexOf('n') != -1) {
										System.exit(0);
									} else {
										System.out.print("ERROR! Please type Y or N: ");
										continue yesNoQuestion;
									}
								}
							} else if (turn >= 5 && a1 == computerChar && b1 == computerChar && c1 == computerChar) {
								match++;
								defeat++;
								winStreak = 0;
								playerStart = 1;
								System.out.print("     A   B   C\n   +---+---+---+\n 1 | " + a1 + " | " + b1 + " | " + c1 + " |\n   +---+---+---+\n 2 | " + a2 + " | " + b2 + " | " + c2 + " |\n   +---+---+---+\n 3 | " + a3 + " | " + b3 + " | " + c3 + " |\n   +---+---+---+\n\n");
								System.out.print("You lost!\n========\n Rounds: " + match + "\n");
								if (victory >= 1) {
									System.out.print(" Wins: " + victory + "\n");
								}
								if (defeat >= 1) {
									System.out.print(" Losses: " + defeat + "\n");
								}
								if (draw >= 1) {
									System.out.print(" Draw: " + draw + "\n");
								}
								System.out.print("\nPlay again? (Y/N): ");
								continuePlaying = 1;
								yesNoQuestion:
								while (continuePlaying == 1) {
									inputPlayAgain = System.console().readLine();
									if (inputPlayAgain.indexOf('Y') != -1 || inputPlayAgain.indexOf('y') != -1) {
										continuePlaying = 0;
										continue playAgain;
									} else if (inputPlayAgain.indexOf('N') != -1 || inputPlayAgain.indexOf('n') != -1) {
										System.exit(0);
									} else {
										System.out.print("ERROR! Please type Y or N: ");
										continue yesNoQuestion;
									}
								}
							} else if (turn >= 5 && a2 == computerChar && b2 == computerChar && c2 == computerChar) {
								match++;
								defeat++;
								winStreak = 0;
								playerStart = 1;
								System.out.print("     A   B   C\n   +---+---+---+\n 1 | " + a1 + " | " + b1 + " | " + c1 + " |\n   +---+---+---+\n 2 | " + a2 + " | " + b2 + " | " + c2 + " |\n   +---+---+---+\n 3 | " + a3 + " | " + b3 + " | " + c3 + " |\n   +---+---+---+\n\n");
								System.out.print("You lost!\n========\n Rounds: " + match + "\n");
								if (victory >= 1) {
									System.out.print(" Wins: " + victory + "\n");
								}
								if (defeat >= 1) {
									System.out.print(" Losses: " + defeat + "\n");
								}
								if (draw >= 1) {
									System.out.print(" Draw: " + draw + "\n");
								}
								System.out.print("\nPlay again? (Y/N): ");
								continuePlaying = 1;
								yesNoQuestion:
								while (continuePlaying == 1) {
									inputPlayAgain = System.console().readLine();
									if (inputPlayAgain.indexOf('Y') != -1 || inputPlayAgain.indexOf('y') != -1) {
										continuePlaying = 0;
										continue playAgain;
									} else if (inputPlayAgain.indexOf('N') != -1 || inputPlayAgain.indexOf('n') != -1) {
										System.exit(0);
									} else {
										System.out.print("ERROR! Please type Y or N: ");
										continue yesNoQuestion;
									}
								}
							} else if (turn >= 5 && a3 == computerChar && b3 == computerChar && c3 == computerChar) {
								match++;
								defeat++;
								winStreak = 0;
								playerStart = 1;
								System.out.print("     A   B   C\n   +---+---+---+\n 1 | " + a1 + " | " + b1 + " | " + c1 + " |\n   +---+---+---+\n 2 | " + a2 + " | " + b2 + " | " + c2 + " |\n   +---+---+---+\n 3 | " + a3 + " | " + b3 + " | " + c3 + " |\n   +---+---+---+\n\n");
								System.out.print("You lost!\n========\n Rounds: " + match + "\n");
								if (victory >= 1) {
									System.out.print(" Wins: " + victory + "\n");
								}
								if (defeat >= 1) {
									System.out.print(" Losses: " + defeat + "\n");
								}
								if (draw >= 1) {
									System.out.print(" Draw: " + draw + "\n");
								}
								System.out.print("\nPlay again? (Y/N): ");
								continuePlaying = 1;
								yesNoQuestion:
								while (continuePlaying == 1) {
									inputPlayAgain = System.console().readLine();
									if (inputPlayAgain.indexOf('Y') != -1 || inputPlayAgain.indexOf('y') != -1) {
										continuePlaying = 0;
										continue playAgain;
									} else if (inputPlayAgain.indexOf('N') != -1 || inputPlayAgain.indexOf('n') != -1) {
										System.exit(0);
									} else {
										System.out.print("ERROR! Please type Y or N: ");
										continue yesNoQuestion;
									}
								}
							} else if (turn >= 5 && a1 == computerChar && b2 == computerChar && c3 == computerChar) {
								match++;
								defeat++;
								winStreak = 0;
								playerStart = 1;
								System.out.print("     A   B   C\n   +---+---+---+\n 1 | " + a1 + " | " + b1 + " | " + c1 + " |\n   +---+---+---+\n 2 | " + a2 + " | " + b2 + " | " + c2 + " |\n   +---+---+---+\n 3 | " + a3 + " | " + b3 + " | " + c3 + " |\n   +---+---+---+\n\n");
								System.out.print("You lost!\n========\n Rounds: " + match + "\n");
								if (victory >= 1) {
									System.out.print(" Wins: " + victory + "\n");
								}
								if (defeat >= 1) {
									System.out.print(" Losses: " + defeat + "\n");
								}
								if (draw >= 1) {
									System.out.print(" Draw: " + draw + "\n");
								}
								System.out.print("\nPlay again? (Y/N): ");
								continuePlaying = 1;
								yesNoQuestion:
								while (continuePlaying == 1) {
									inputPlayAgain = System.console().readLine();
									if (inputPlayAgain.indexOf('Y') != -1 || inputPlayAgain.indexOf('y') != -1) {
										continuePlaying = 0;
										continue playAgain;
									} else if (inputPlayAgain.indexOf('N') != -1 || inputPlayAgain.indexOf('n') != -1) {
										System.exit(0);
									} else {
										System.out.print("ERROR! Please type Y or N: ");
										continue yesNoQuestion;
									}
								}
							} else if (turn >= 5 && a3 == computerChar && b2 == computerChar && c1 == computerChar) {
								match++;
								defeat++;
								winStreak = 0;
								playerStart = 1;
								System.out.print("     A   B   C\n   +---+---+---+\n 1 | " + a1 + " | " + b1 + " | " + c1 + " |\n   +---+---+---+\n 2 | " + a2 + " | " + b2 + " | " + c2 + " |\n   +---+---+---+\n 3 | " + a3 + " | " + b3 + " | " + c3 + " |\n   +---+---+---+\n\n");
								System.out.print("You lost!\n========\n Rounds: " + match + "\n");
								if (victory >= 1) {
									System.out.print(" Wins: " + victory + "\n");
								}
								if (defeat >= 1) {
									System.out.print(" Losses: " + defeat + "\n");
								}
								if (draw >= 1) {
									System.out.print(" Draw: " + draw + "\n");
								}
								System.out.print("\nPlay again? (Y/N): ");
								continuePlaying = 1;
								yesNoQuestion:
								while (continuePlaying == 1) {
									inputPlayAgain = System.console().readLine();
									if (inputPlayAgain.indexOf('Y') != -1 || inputPlayAgain.indexOf('y') != -1) {
										continuePlaying = 0;
										continue playAgain;
									} else if (inputPlayAgain.indexOf('N') != -1 || inputPlayAgain.indexOf('n') != -1) {
										System.exit(0);
									} else {
										System.out.print("ERROR! Please type Y or N: ");
										continue yesNoQuestion;
									}
								}
							} else if (turn == 9) {
								match++;
								draw++;
								winStreak = 0;
								playerStart = 0;
								System.out.print("     A   B   C\n   +---+---+---+\n 1 | " + a1 + " | " + b1 + " | " + c1 + " |\n   +---+---+---+\n 2 | " + a2 + " | " + b2 + " | " + c2 + " |\n   +---+---+---+\n 3 | " + a3 + " | " + b3 + " | " + c3 + " |\n   +---+---+---+\n\n");
								System.out.print("Draw!\n========\n Rounds: " + match + "\n");
								if (victory >= 1) {
									System.out.print(" Wins: " + victory + "\n");
								}
								if (defeat >= 1) {
									System.out.print(" Losses: " + defeat + "\n");
								}
								if (draw >= 1) {
									System.out.print(" Draw: " + draw + "\n");
								}
								System.out.print("\nPlay again? (Y/N): ");
								continuePlaying = 1;
								yesNoQuestion:
								while (continuePlaying == 1) {
									inputPlayAgain = System.console().readLine();
									if (inputPlayAgain.indexOf('Y') != -1 || inputPlayAgain.indexOf('y') != -1) {
										continuePlaying = 0;
										continue playAgainDraw;
									} else if (inputPlayAgain.indexOf('N') != -1 || inputPlayAgain.indexOf('n') != -1) {
										System.exit(0);
									} else {
										System.out.print("ERROR! Please type Y or N: ");
										continue yesNoQuestion;
									}
								}
							}
							// Display current board status.
							System.out.print("     A   B   C\n   +---+---+---+\n 1 | " + a1 + " | " + b1 + " | " + c1 + " |\n   +---+---+---+\n 2 | " + a2 + " | " + b2 + " | " + c2 + " |\n   +---+---+---+\n 3 | " + a3 + " | " + b3 + " | " + c3 + " |\n   +---+---+---+\n");
							// Player's turn: Translates input to grid reference, checks if grid is empty.
							playerTurn = 1;
							playerTurn:
							while (playerTurn == 1) {
								System.out.print("Enter grid reference: ");
								String inputGridRef = System.console().readLine();
								if ((inputGridRef.indexOf("a1") != -1 || inputGridRef.indexOf("1a") != -1 || inputGridRef.indexOf("A1") != -1 || inputGridRef.indexOf("1A") != -1) && a1 == ' ') {
									a1 = playerChar;
									playerTurn--;
								} else if ((inputGridRef.indexOf("a2") != -1 || inputGridRef.indexOf("2a") != -1 || inputGridRef.indexOf("A2") != -1 || inputGridRef.indexOf("2A") != -1) && a2 == ' ') {
									a2 = playerChar;
									playerTurn--;
								} else if ((inputGridRef.indexOf("a3") != -1 || inputGridRef.indexOf("3a") != -1 || inputGridRef.indexOf("A3") != -1 || inputGridRef.indexOf("3A") != -1) && a3 == ' ') {
									a3 = playerChar;
									playerTurn--;
								} else if ((inputGridRef.indexOf("b1") != -1 || inputGridRef.indexOf("1b") != -1 || inputGridRef.indexOf("B1") != -1 || inputGridRef.indexOf("1B") != -1) && b1 == ' ') {
									b1 = playerChar;
									playerTurn--;
								} else if ((inputGridRef.indexOf("b2") != -1 || inputGridRef.indexOf("2b") != -1 || inputGridRef.indexOf("B2") != -1 || inputGridRef.indexOf("2B") != -1) && b2 == ' ') {
									b2 = playerChar;
									playerTurn--;
								} else if ((inputGridRef.indexOf("b3") != -1 || inputGridRef.indexOf("3b") != -1 || inputGridRef.indexOf("B3") != -1 || inputGridRef.indexOf("3B") != -1) && b3 == ' ') {
									b3 = playerChar;
									playerTurn--;
								} else if ((inputGridRef.indexOf("c1") != -1 || inputGridRef.indexOf("1c") != -1 || inputGridRef.indexOf("C1") != -1 || inputGridRef.indexOf("1C") != -1) && c1 == ' ') {
									c1 = playerChar;
									playerTurn--;
								} else if ((inputGridRef.indexOf("c2") != -1 || inputGridRef.indexOf("2c") != -1 || inputGridRef.indexOf("C2") != -1 || inputGridRef.indexOf("2C") != -1) && c2 == ' ') {
									c2 = playerChar;
									playerTurn--;
								} else if ((inputGridRef.indexOf("c3") != -1 || inputGridRef.indexOf("3c") != -1 || inputGridRef.indexOf("C3") != -1 || inputGridRef.indexOf("3C") != -1) && c3 == ' ') {
									c3 = playerChar;
									playerTurn--;
								} else {
									System.out.print("ERROR! Enter a valid grid reference!\n");
									continue playerTurn;
								}
							}
							turn++;
							// Check for victory condition.
							if (turn >= 5 && a1 == playerChar && a2 == playerChar && a3 == playerChar) {
								match++;
								victory++;
								winStreak++;
								playerStart = 2;
								System.out.print("     A   B   C\n   +---+---+---+\n 1 | " + a1 + " | " + b1 + " | " + c1 + " |\n   +---+---+---+\n 2 | " + a2 + " | " + b2 + " | " + c2 + " |\n   +---+---+---+\n 3 | " + a3 + " | " + b3 + " | " + c3 + " |\n   +---+---+---+\n\n");
								System.out.print("You won!\n========\n Rounds: " + match + "\n");
								if (victory >= 1) {
									System.out.print(" Wins: " + victory + "\n");
								}
								if (defeat >= 1) {
									System.out.print(" Losses: " + defeat + "\n");
								}
								if (draw >= 1) {
									System.out.print(" Draw: " + draw + "\n");
								}
								if (winStreak >= 2) {
									System.out.print(" Win streak: " + winStreak + "\n");
								}
								System.out.print("\nPlay again? (Y/N): ");
								continuePlaying = 1;
								yesNoQuestion:
								while (continuePlaying == 1) {
									inputPlayAgain = System.console().readLine();
									if (inputPlayAgain.indexOf('Y') != -1 || inputPlayAgain.indexOf('y') != -1) {
										continuePlaying = 0;
										continue playAgain;
									} else if (inputPlayAgain.indexOf('N') != -1 || inputPlayAgain.indexOf('n') != -1) {
										System.exit(0);
									} else {
										System.out.print("ERROR! Please type Y or N: ");
										continue yesNoQuestion;
									}
								}
							} else if (turn >= 5 && b1 == playerChar && b2 == playerChar && b3 == playerChar) {
								match++;
								victory++;
								winStreak++;
								playerStart = 2;
								System.out.print("     A   B   C\n   +---+---+---+\n 1 | " + a1 + " | " + b1 + " | " + c1 + " |\n   +---+---+---+\n 2 | " + a2 + " | " + b2 + " | " + c2 + " |\n   +---+---+---+\n 3 | " + a3 + " | " + b3 + " | " + c3 + " |\n   +---+---+---+\n\n");
								System.out.print("You won!\n========\n Rounds: " + match + "\n");
								if (victory >= 1) {
									System.out.print(" Wins: " + victory + "\n");
								}
								if (defeat >= 1) {
									System.out.print(" Losses: " + defeat + "\n");
								}
								if (draw >= 1) {
									System.out.print(" Draw: " + draw + "\n");
								}
								if (winStreak >= 2) {
									System.out.print(" Win streak: " + winStreak + "\n");
								}
								System.out.print("\nPlay again? (Y/N): ");
								continuePlaying = 1;
								yesNoQuestion:
								while (continuePlaying == 1) {
									inputPlayAgain = System.console().readLine();
									if (inputPlayAgain.indexOf('Y') != -1 || inputPlayAgain.indexOf('y') != -1) {
										continuePlaying = 0;
										continue playAgain;
									} else if (inputPlayAgain.indexOf('N') != -1 || inputPlayAgain.indexOf('n') != -1) {
										System.exit(0);
									} else {
										System.out.print("ERROR! Please type Y or N: ");
										continue yesNoQuestion;
									}
								}
							} else if (turn >= 5 && c1 == playerChar && c2 == playerChar && c3 == playerChar) {
								match++;
								victory++;
								winStreak++;
								playerStart = 2;
								System.out.print("     A   B   C\n   +---+---+---+\n 1 | " + a1 + " | " + b1 + " | " + c1 + " |\n   +---+---+---+\n 2 | " + a2 + " | " + b2 + " | " + c2 + " |\n   +---+---+---+\n 3 | " + a3 + " | " + b3 + " | " + c3 + " |\n   +---+---+---+\n\n");
								System.out.print("You won!\n========\n Rounds: " + match + "\n");
								if (victory >= 1) {
									System.out.print(" Wins: " + victory + "\n");
								}
								if (defeat >= 1) {
									System.out.print(" Losses: " + defeat + "\n");
								}
								if (draw >= 1) {
									System.out.print(" Draw: " + draw + "\n");
								}
								if (winStreak >= 2) {
									System.out.print(" Win streak: " + winStreak + "\n");
								}
								System.out.print("\nPlay again? (Y/N): ");
								continuePlaying = 1;
								yesNoQuestion:
								while (continuePlaying == 1) {
									inputPlayAgain = System.console().readLine();
									if (inputPlayAgain.indexOf('Y') != -1 || inputPlayAgain.indexOf('y') != -1) {
										continuePlaying = 0;
										continue playAgain;
									} else if (inputPlayAgain.indexOf('N') != -1 || inputPlayAgain.indexOf('n') != -1) {
										System.exit(0);
									} else {
										System.out.print("ERROR! Please type Y or N: ");
										continue yesNoQuestion;
									}
								}
							} else if (turn >= 5 && a1 == playerChar && b1 == playerChar && c1 == playerChar) {
								match++;
								victory++;
								winStreak++;
								playerStart = 2;
								System.out.print("     A   B   C\n   +---+---+---+\n 1 | " + a1 + " | " + b1 + " | " + c1 + " |\n   +---+---+---+\n 2 | " + a2 + " | " + b2 + " | " + c2 + " |\n   +---+---+---+\n 3 | " + a3 + " | " + b3 + " | " + c3 + " |\n   +---+---+---+\n\n");
								System.out.print("You won!\n========\n Rounds: " + match + "\n");
								if (victory >= 1) {
									System.out.print(" Wins: " + victory + "\n");
								}
								if (defeat >= 1) {
									System.out.print(" Losses: " + defeat + "\n");
								}
								if (draw >= 1) {
									System.out.print(" Draw: " + draw + "\n");
								}
								if (winStreak >= 2) {
									System.out.print(" Win streak: " + winStreak + "\n");
								}
								System.out.print("\nPlay again? (Y/N): ");
								continuePlaying = 1;
								yesNoQuestion:
								while (continuePlaying == 1) {
									inputPlayAgain = System.console().readLine();
									if (inputPlayAgain.indexOf('Y') != -1 || inputPlayAgain.indexOf('y') != -1) {
										continuePlaying = 0;
										continue playAgain;
									} else if (inputPlayAgain.indexOf('N') != -1 || inputPlayAgain.indexOf('n') != -1) {
										System.exit(0);
									} else {
										System.out.print("ERROR! Please type Y or N: ");
										continue yesNoQuestion;
									}
								}
							} else if (turn >= 5 && a2 == playerChar && b2 == playerChar && c2 == playerChar) {
								match++;
								victory++;
								winStreak++;
								playerStart = 2;
								System.out.print("     A   B   C\n   +---+---+---+\n 1 | " + a1 + " | " + b1 + " | " + c1 + " |\n   +---+---+---+\n 2 | " + a2 + " | " + b2 + " | " + c2 + " |\n   +---+---+---+\n 3 | " + a3 + " | " + b3 + " | " + c3 + " |\n   +---+---+---+\n\n");
								System.out.print("You won!\n========\n Rounds: " + match + "\n");
								if (victory >= 1) {
									System.out.print(" Wins: " + victory + "\n");
								}
								if (defeat >= 1) {
									System.out.print(" Losses: " + defeat + "\n");
								}
								if (draw >= 1) {
									System.out.print(" Draw: " + draw + "\n");
								}
								if (winStreak >= 2) {
									System.out.print(" Win streak: " + winStreak + "\n");
								}
								System.out.print("\nPlay again? (Y/N): ");
								continuePlaying = 1;
								yesNoQuestion:
								while (continuePlaying == 1) {
									inputPlayAgain = System.console().readLine();
									if (inputPlayAgain.indexOf('Y') != -1 || inputPlayAgain.indexOf('y') != -1) {
										continuePlaying = 0;
										continue playAgain;
									} else if (inputPlayAgain.indexOf('N') != -1 || inputPlayAgain.indexOf('n') != -1) {
										System.exit(0);
									} else {
										System.out.print("ERROR! Please type Y or N: ");
										continue yesNoQuestion;
									}
								}
							} else if (turn >= 5 && a3 == playerChar && b3 == playerChar && c3 == playerChar) {
								match++;
								victory++;
								winStreak++;
								playerStart = 2;
								System.out.print("     A   B   C\n   +---+---+---+\n 1 | " + a1 + " | " + b1 + " | " + c1 + " |\n   +---+---+---+\n 2 | " + a2 + " | " + b2 + " | " + c2 + " |\n   +---+---+---+\n 3 | " + a3 + " | " + b3 + " | " + c3 + " |\n   +---+---+---+\n\n");
								System.out.print("You won!\n========\n Rounds: " + match + "\n");
								if (victory >= 1) {
									System.out.print(" Wins: " + victory + "\n");
								}
								if (defeat >= 1) {
									System.out.print(" Losses: " + defeat + "\n");
								}
								if (draw >= 1) {
									System.out.print(" Draw: " + draw + "\n");
								}
								if (winStreak >= 2) {
									System.out.print(" Win streak: " + winStreak + "\n");
								}
								System.out.print("\nPlay again? (Y/N): ");
								continuePlaying = 1;
								yesNoQuestion:
								while (continuePlaying == 1) {
									inputPlayAgain = System.console().readLine();
									if (inputPlayAgain.indexOf('Y') != -1 || inputPlayAgain.indexOf('y') != -1) {
										continuePlaying = 0;
										continue playAgain;
									} else if (inputPlayAgain.indexOf('N') != -1 || inputPlayAgain.indexOf('n') != -1) {
										System.exit(0);
									} else {
										System.out.print("ERROR! Please type Y or N: ");
										continue yesNoQuestion;
									}
								}
							} else if (turn >= 5 && a1 == playerChar && b2 == playerChar && c3 == playerChar) {
								match++;
								victory++;
								winStreak++;
								playerStart = 2;
								System.out.print("     A   B   C\n   +---+---+---+\n 1 | " + a1 + " | " + b1 + " | " + c1 + " |\n   +---+---+---+\n 2 | " + a2 + " | " + b2 + " | " + c2 + " |\n   +---+---+---+\n 3 | " + a3 + " | " + b3 + " | " + c3 + " |\n   +---+---+---+\n\n");
								System.out.print("You won!\n========\n Rounds: " + match + "\n");
								if (victory >= 1) {
									System.out.print(" Wins: " + victory + "\n");
								}
								if (defeat >= 1) {
									System.out.print(" Losses: " + defeat + "\n");
								}
								if (draw >= 1) {
									System.out.print(" Draw: " + draw + "\n");
								}
								if (winStreak >= 2) {
									System.out.print(" Win streak: " + winStreak + "\n");
								}
								System.out.print("\nPlay again? (Y/N): ");
								continuePlaying = 1;
								yesNoQuestion:
								while (continuePlaying == 1) {
									inputPlayAgain = System.console().readLine();
									if (inputPlayAgain.indexOf('Y') != -1 || inputPlayAgain.indexOf('y') != -1) {
										continuePlaying = 0;
										continue playAgain;
									} else if (inputPlayAgain.indexOf('N') != -1 || inputPlayAgain.indexOf('n') != -1) {
										System.exit(0);
									} else {
										System.out.print("ERROR! Please type Y or N: ");
										continue yesNoQuestion;
									}
								}
							} else if (turn >= 5 && a3 == playerChar && b2 == playerChar && c1 == playerChar) {
								match++;
								victory++;
								winStreak++;
								playerStart = 2;
								System.out.print("     A   B   C\n   +---+---+---+\n 1 | " + a1 + " | " + b1 + " | " + c1 + " |\n   +---+---+---+\n 2 | " + a2 + " | " + b2 + " | " + c2 + " |\n   +---+---+---+\n 3 | " + a3 + " | " + b3 + " | " + c3 + " |\n   +---+---+---+\n\n");
								System.out.print("You won!\n========\n Rounds: " + match + "\n");
								if (victory >= 1) {
									System.out.print(" Wins: " + victory + "\n");
								}
								if (defeat >= 1) {
									System.out.print(" Losses: " + defeat + "\n");
								}
								if (draw >= 1) {
									System.out.print(" Draw: " + draw + "\n");
								}
								if (winStreak >= 2) {
									System.out.print(" Win streak: " + winStreak + "\n");
								}
								System.out.print("\nPlay again? (Y/N): ");
								continuePlaying = 1;
								yesNoQuestion:
								while (continuePlaying == 1) {
									inputPlayAgain = System.console().readLine();
									if (inputPlayAgain.indexOf('Y') != -1 || inputPlayAgain.indexOf('y') != -1) {
										continuePlaying = 0;
										continue playAgain;
									} else if (inputPlayAgain.indexOf('N') != -1 || inputPlayAgain.indexOf('n') != -1) {
										System.exit(0);
									} else {
										System.out.print("ERROR! Please type Y or N: ");
										continue yesNoQuestion;
									}
								}
							} else if (turn == 9) {
								match++;
								draw++;
								winStreak = 0;
								playerStart = 0;
								System.out.print("     A   B   C\n   +---+---+---+\n 1 | " + a1 + " | " + b1 + " | " + c1 + " |\n   +---+---+---+\n 2 | " + a2 + " | " + b2 + " | " + c2 + " |\n   +---+---+---+\n 3 | " + a3 + " | " + b3 + " | " + c3 + " |\n   +---+---+---+\n\n");
								System.out.print("Draw!\n========\n Rounds: " + match + "\n");
								if (victory >= 1) {
									System.out.print(" Wins: " + victory + "\n");
								}
								if (defeat >= 1) {
									System.out.print(" Losses: " + defeat + "\n");
								}
								if (draw >= 1) {
									System.out.print(" Draw: " + draw + "\n");
								}
								System.out.print("\nPlay again? (Y/N): ");
								continuePlaying = 1;
								yesNoQuestion:
								while (continuePlaying == 1) {
									inputPlayAgain = System.console().readLine();
									if (inputPlayAgain.indexOf('Y') != -1 || inputPlayAgain.indexOf('y') != -1) {
										continuePlaying = 0;
										continue playAgainDraw;
									} else {
										if (inputPlayAgain.indexOf('N') != -1 || inputPlayAgain.indexOf('n') != -1) {
											System.exit(0);
										} else {
											System.out.print("ERROR! Please type Y or N: ");
											continue yesNoQuestion;
										}
									}
								}
							}
						} while (turn <= 9);
					}
				}
			}
		} while (gameLoop);
	}
}