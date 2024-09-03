public class Board {

    private String playerOne;
    private String playerOnePiece;
    private String playerTwo;
    private String playerTwoPiece;
    private String[][] board = new String[3][3];

    public Board(String playerOne, String playerOnePiece, String playerTwo, String playerTwoPiece) {
        this.playerOne = playerOne;
        this.playerOnePiece = playerOnePiece;
        this.playerTwo = playerTwo;
        this.playerTwoPiece = playerTwoPiece;
        this.board = populateBoard();
    }

    public String[][] populateBoard() {

        int count = 1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = String.valueOf(count++);
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

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].equals(String.valueOf(input))) {
                    board[i][j] = currentPlayer.getNoughtsOrCrosses();
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
        if (diagonalWin(playerPiece)) return true;

        return false;
    }

    public boolean horizontalWin(String playerPiece) {

        for (int i = 0; i < board.length; i++) {
            int count = 0;
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].equals(playerPiece)) count++;
            }
            return count == 3;
        }
        return false;
    }

    public boolean verticalWin(String playerPiece) {

        for (int i = 0; i < board.length; i++) {
            int count = 0;
            for (int j = 0; j < board.length; j++) {
                if (board[j][i].equals(playerPiece)) count++;
            }
            return count == 3;
        }
        return false;
    }

    public boolean diagonalWin(String playerPiece) {


        return false;
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
