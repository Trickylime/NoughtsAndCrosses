import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private Board board;
    private Player playerOne;
    private Player playerTwo;

    @BeforeEach
    void setUp() {
        playerOne = new Player("Jack");
        playerOne.setNoughtsOrCrosses("X");
        playerTwo = new Player("Dean");
        playerTwo.setNoughtsOrCrosses("O");

        board = new Board(playerOne.getName(), playerOne.getNoughtsOrCrosses(),
                playerTwo.getName(), playerTwo.getNoughtsOrCrosses());
    }

    @Test
    void testUpdateBoard() {
        assertTrue(board.updateBoard(5, playerOne));
        assertFalse(board.updateBoard(5, playerTwo));
    }

    @Test
    void testHorizontalWin() {
        board.updateBoard(1, playerOne);
        board.updateBoard(2, playerOne);
        board.updateBoard(3, playerOne);

        assertTrue(board.horizontalWin(playerOne.getNoughtsOrCrosses()));
    }

    @Test
    void testVerticalWin() {
        board.updateBoard(1, playerOne);
        board.updateBoard(4, playerOne);
        board.updateBoard(7, playerOne);

        assertTrue(board.verticalWin(playerOne.getNoughtsOrCrosses()));
    }

    @Test
    void testDiagonalWin() {
        board.updateBoard(1, playerOne);
        board.updateBoard(5, playerOne);
        board.updateBoard(9, playerOne);

        assertTrue(board.diagonalWin(playerOne.getNoughtsOrCrosses()));
    }

    @Test
    void testDraw() {
        board.updateBoard(5, playerOne);
        board.updateBoard(1, playerTwo);
        board.updateBoard(3, playerOne);
        board.updateBoard(7, playerTwo);
        board.updateBoard(4, playerOne);
        board.updateBoard(6, playerTwo);
        board.updateBoard(2, playerOne);
        board.updateBoard(8, playerTwo);
        board.updateBoard(9, playerOne);

        assertFalse(board.checkForWinner(playerOne));
        assertFalse(board.checkForWinner(playerTwo));
    }


}
