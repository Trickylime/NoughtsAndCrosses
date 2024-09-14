import java.util.Scanner;

public class NoughtsAndCrossesApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Game game = new Game(scanner);
        boolean gameOver = false;
        boolean firstGame = true;

        while (!gameOver) {
            if (firstGame) {
                game.createPlayers();
                firstGame = false;
            }
            game.startGame();
            gameOver = game.endGame();
        }

    }
}
