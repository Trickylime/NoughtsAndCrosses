import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class GameTest {


    private Game game;
    private Scanner mockScanner;
    private Player playerOne;
    private Player playerTwo;

    @BeforeEach
    void setUp() throws NoSuchFieldException, IllegalAccessException {
        // Create a mock Scanner
        mockScanner = Mockito.mock(Scanner.class);
        // Pass the mock Scanner to the Game constructor
        game = new Game(mockScanner);

        // Mock user input for player names
        when(mockScanner.nextLine()).thenReturn("Jack", "Dean");

        // Call createPlayers() to set playerOne and playerTwo
        game.createPlayers();

        // Use reflection to access the private fields
        Field playerOneField = Game.class.getDeclaredField("playerOne");
        Field playerTwoField = Game.class.getDeclaredField("playerTwo");

        // Make the private fields accessible
        playerOneField.setAccessible(true);
        playerTwoField.setAccessible(true);

        // Set the playerOne and playerTwo fields for reuse in other tests
        playerOne = (Player) playerOneField.get(game);
        playerTwo = (Player) playerTwoField.get(game);
    }

    @Test
    void testCreatePlayersUsingReflection() {
        // Assert the player names
        assertEquals("Jack", playerOne.getName());
        assertEquals("Dean", playerTwo.getName());
    }

    @Test
    void testInitializeGame() {
        // Simulate user input for choosing X or O
        when(mockScanner.nextLine()).thenReturn("X");

        // Call initializeGame()
        Board board = game.initializeGame();

        // Verify the board is correctly initialized with players and their chosen symbols
        assertNotNull(board);

        // Since the starting player is random, we need to determine which player chose "X"
        if ("X".equals(playerOne.getNoughtsOrCrosses())) {
            assertEquals("X", playerOne.getNoughtsOrCrosses());
            assertEquals("O", playerTwo.getNoughtsOrCrosses());
        } else {
            assertEquals("X", playerTwo.getNoughtsOrCrosses());
            assertEquals("O", playerOne.getNoughtsOrCrosses());
        }
    }


}
