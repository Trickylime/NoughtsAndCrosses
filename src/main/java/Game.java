import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private final Scanner scanner;
    private Player playerOne;
    private Player playerTwo;
    private Player currentPlayer;
    private Board gameBoard;
    private boolean gameOver = false;

    public Game(Scanner scanner) {
        this.scanner = scanner;
    }

    public void createPlayers() {
        System.out.println("-".repeat(30));

        System.out.println("Please Enter Player One's name");
        playerOne = new Player(scanner.nextLine());

        System.out.printf("Please Enter Player Two's name%n");
        playerTwo = new Player(scanner.nextLine());

        System.out.println("-".repeat(30));
    }

    public Board initializeGame() {

        // Select a random player to go first and choose which piece they would like to play as
        Random random = new Random();
        int select = random.nextInt(0, 2);
        currentPlayer = List.of(playerOne, playerTwo).get(select);

        System.out.printf("%s please select if you want X's or O's%n", currentPlayer.getName());
        while (true) {
            String input = scanner.nextLine().toUpperCase();

            if (input.equals("X") || input.equals("O")) {
                currentPlayer.setNoughtsOrCrosses(input);
                String opposite = input.equals("X") ? "O" : "X";

                if (currentPlayer == playerOne)
                    playerTwo.setNoughtsOrCrosses(opposite);
                else
                    playerOne.setNoughtsOrCrosses(opposite);
                break;
            } else {
                System.out.println("Invalid input. Please enter either X or O.");
            }
        }

        return new Board(playerOne.getName(),
                playerOne.getNoughtsOrCrosses(),
                playerTwo.getName(),
                playerTwo.getNoughtsOrCrosses());
    }

    public void startGame() {

        gameBoard = initializeGame();
        gameOver = false;
        int turnCount = 0;

        while (!gameOver) {

            turnCount++;

            //Check for a draw
            if (turnCount > 9) {
                gameOver = true;
                break;
            }

            System.out.println(gameBoard.printBoard());
            System.out.printf("It's %s's turn! Please enter a number of where you like to make your move%n", currentPlayer.getName());

            inputBoardPosition(turnCount);
        }
    }

    public void inputBoardPosition(int turnCount) {

        while(true) {
            try {
                //Take inputs and add them to the board while there isn't a winner
                int input = scanner.nextInt();

                if (input > 0 && input < 10) {
                    if (gameBoard.updateBoard(input, currentPlayer)) {
                        if (turnCount >= 5) {
                            if (gameBoard.checkForWinner(currentPlayer)) {
                                gameOver = true;
                                gameBoard.setWinner(currentPlayer);
                            }
                        }
                        currentPlayer = currentPlayer == playerOne ? playerTwo : playerOne;
                        break;
                    } else System.out.println("Invalid input. That position has already been used. " +
                            "Please enter a number that's available on the board.");

                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and 9 and is currently available on the board.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 9 and is currently available on the board.");
                scanner.next();  // Clear the invalid input from the scanner
            }
        }

    }

    public boolean endGame() {

        System.out.println(gameBoard.printBoard());

        if (gameBoard.getWinner() != null) {
            gameBoard.getWinner().setScore(1);
            System.out.printf("""
                Congratulations! %s is the winner!
                """, gameBoard.getWinner().getName());
        } else
            System.out.println("Surprise, surprise... It's a draw!");

        System.out.printf("""
                The Score is
                %s - %d
                %s - %d
                """, playerOne.getName(), playerOne.getScore(), playerTwo.getName(), playerTwo.getScore());

        // Consume any leftover newline character
        scanner.nextLine();

        while (true) {
            System.out.println("Would you like to play again? (y/n)");
            String input = scanner.nextLine().toUpperCase();
            if (input.equals("Y") || input.equals("YES")) {
                return false;
            } else if (input.equals("N") || input.equals("NO")){
                System.out.println("Game Over, Thanks for playing!");
                break;
            } else {
                System.out.println("Invalid Input");
            }
        }

        return true;
    }

}
