import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {

    static Scanner scanner = new Scanner(System.in);
    private static Player playerOne;
    private static Player playerTwo;
    private static Player currentPlayer;
    private static boolean firstGame = true;
    private static Board gameBoard;

    public static void main(String[] args) {

        if (firstGame) {
            createPlayers();
            firstGame = false;
        }

        gameBoard = initializeGame();

        startGame();


    }

    private static void createPlayers() {
        System.out.println("-".repeat(30));

        System.out.println("Please Enter Player One's name");
        playerOne = new Player(scanner.nextLine());

        System.out.printf("Please Enter Player Two's name%n");
        playerTwo = new Player(scanner.nextLine());

        System.out.println("-".repeat(30));
    }

    public static Board initializeGame() {

        // Select a random player to go first and choose which piece they would like to play as
        Random random = new Random();
        int select = random.nextInt(0, 2);
        currentPlayer = List.of(playerOne, playerTwo).get(select);

        //TODO: store which piece the current random player has selected to add to the Board class
        System.out.printf("%s please select if you want X's or O's%n", currentPlayer.getName());
        while (true) {
            String input = scanner.nextLine().toUpperCase();

            if (input.equals("X") || input.equals("O")) {
                break;
            } else {
                System.out.println("Invalid input. Please enter either X or O.");
            }
        }

        return new Board(playerOne.getName(), "X", playerTwo.getName(), "O");
    }

    public static void startGame() {

        boolean gameOver = false;
        while (!gameOver) {
            System.out.println(gameBoard.printBoard());
            System.out.printf("It's %s's turn! Please enter a number of where you like to make your move%n", currentPlayer.getName());
            while (true) {
                int input = scanner.nextInt();
                if (input > 0 && input < 10) {
                    System.out.printf("%s has chosen %s%n", currentPlayer.getName(), input);

                    if (gameBoard.updateBoard(input)) {
                        if (currentPlayer == playerOne) currentPlayer = playerTwo;
                        else currentPlayer = playerOne;
                        break;
                    }
                    else System.out.println("Invalid input. That position has already been used. " +
                            "Please enter a number that's available on the board.");

                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and 9 and is currently available on the board.");
                }
            }


        }
    }
}
