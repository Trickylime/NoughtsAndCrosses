import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    @Test
    void testSetAndGetScore() {
        Player player = new Player("Dean");
        player.setScore(1);
        assertEquals(1, player.getScore());

        player.setScore(2);
        assertEquals(3, player.getScore());  // score accumulates
    }

    @Test
    void testSetAndGetName() {
        Player player = new Player("Jack");
        assertEquals("Jack", player.getName());
    }

    @Test
    void testSetAndGetNoughtsOrCrosses() {
        Player player = new Player("Dean");
        player.setNoughtsOrCrosses("X");
        assertEquals("X", player.getNoughtsOrCrosses());
    }
}
