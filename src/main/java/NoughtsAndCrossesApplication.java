public class NoughtsAndCrossesApplication {

    public static void main(String[] args) {

        Game game = new Game();
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
