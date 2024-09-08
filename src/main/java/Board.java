public class Board {

    private final String playerOne;
    private final String playerOnePiece;
    private final String playerTwo;
    private final String playerTwoPiece;
    private Player winner;
    private String[][] board = new String[3][3];

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public Board(String playerOne, String playerOnePiece, String playerTwo, String playerTwoPiece) {
        this.playerOne = playerOne;
        this.playerOnePiece = playerOnePiece;
        this.playerTwo = playerTwo;
        this.playerTwoPiece = playerTwoPiece;
        this.board = populateBoard();
    }

    public String[][] populateBoard() {

        int count = 1;
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board.length; x++) {
                board[y][x] = String.valueOf(count++);
            }
        }

        return board;
    }

    public String printBoard() {
        return """
                --------------------------------------
                       Player 1        Player 2
                      %s - %s's       %s - %s's
                             _%s_|_%s_|_%s_
                             _%s_|_%s_|_%s_
                              %s | %s | %s
                --------------------------------------
                """.formatted(playerOne, playerOnePiece, playerTwo, playerTwoPiece,
                board[0][0], board[0][1], board[0][2],
                board[1][0], board[1][1], board[1][2],
                board[2][0], board[2][1], board[2][2]);
    }

    public boolean updateBoard(int input, Player currentPlayer) {

        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board.length; x++) {
                if (board[y][x].equals(String.valueOf(input))) {
                    board[y][x] = currentPlayer.getNoughtsOrCrosses();
                    return true;
                }
            }
        }

        return false;
    }

    public boolean checkForWinner(Player currentPlayer) {

        String playerPiece = currentPlayer.getNoughtsOrCrosses();
        if (horizontalWin(playerPiece)) return true;
        if (verticalWin(playerPiece)) return true;
        return diagonalWin(playerPiece);
    }

    public boolean horizontalWin(String playerPiece) {

        int count = 0;
        for (String[] y : board) {
            count = 0;
            for (int x = 0; x < board.length; x++) {
                if (y[x].equals(playerPiece)) {
                    count++;
                } else
                    break;
                if (count == 3) return true;
            }
        }
        return false;
    }

    public boolean verticalWin(String playerPiece) {

        int count = 0;
        for (int y = 0; y < board.length; y++) {
            count = 0;
            for (String[] x : board) {
                if (x[y].equals(playerPiece)) count++;
                else break;
                if (count == 3) return true;
            }
        }
        return false;
    }

    public boolean diagonalWin(String playerPiece) {

        //Check top left to bottom right
        int x = 0;
        int count = 0;
        for (String[] y : board) {
            if (y[x].equals(playerPiece)) {
                count++;
                x++;
                if (count == 3) return true;
            } else break;
        }

        //Check top right to bottom left
        x = 2;
        count = 0;
        for (String[] y : board) {
            if (y[x].equals(playerPiece)) {
                count++;
                x--;
            } else break;
        }
        return count == 3;
    }


    public String getPlayerOne() {
        return playerOne;
    }

    public String getPlayerOnePiece() {
        return playerOnePiece;
    }

    public String getPlayerTwo() {
        return playerTwo;
    }

    public String getPlayerTwoPiece() {
        return playerTwoPiece;
    }

}
