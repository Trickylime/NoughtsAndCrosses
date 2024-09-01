import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {

    static Scanner scanner = new Scanner(System.in);
    private static Player playerOne;
    private static Player playerTwo;
    private static Player currentPlayer;
    private static boolean firstGame = true;

    public static void main(String[] args) {

        if (firstGame) {
            createPlayers();
            firstGame = false;
        }

        int[][] gameBoard = initializeGame();


    }

    private static void createPlayers() {
        System.out.println("-".repeat(30));

        System.out.println("Please Enter Player One's name");
        playerOne = new Player(scanner.nextLine());

        System.out.printf("Player one is: %s! \nPlease Enter Player Two's name%n", playerOne);
        playerTwo = new Player(scanner.nextLine());

        System.out.printf("Player two is: %s%n", playerTwo);

        System.out.println("-".repeat(30));
    }

    public static int[][] initializeGame() {

        Random random = new Random();
        int select = random.nextInt(0, 2);
        System.out.println(select);
        currentPlayer = List.of(playerOne, playerTwo).get(select);

        System.out.printf("%s please select if you want X's or O's%n", currentPlayer.getName());
        while (true) {
            String input = scanner.nextLine().toUpperCase();

            if (input.equals("X") || input.equals("O")) {
                System.out.printf("%s is %s's", currentPlayer.getName(), input);
                break;
            } else {
                System.out.println("Invalid input. Please enter either X or O.");
            }
        }

        return new int[3][3];
    }

    public static void startGame() {

    }
}
