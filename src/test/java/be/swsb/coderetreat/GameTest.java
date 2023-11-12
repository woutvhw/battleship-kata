package be.swsb.coderetreat;

import be.swsb.coderetreat.boat.Boat;
import be.swsb.coderetreat.boat.Orientation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    @Test
    void initGamePlayersHaveEmptyGrids() {
        String expectedGrid = """
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                """;
        Game game = Game.startNew();

        assertEquals(expectedGrid, game.getP1().renderGrid());
        assertEquals(expectedGrid, game.getP2().renderGrid());
    }

    @Test
    void playersPlaceBoats() throws Exception {
        String expectedP1Grid = """
                🌊🌊🌊🌊🌊🚢🚢🚢🌊🌊
                🚢🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🚢🌊🌊🌊🌊🌊🌊🌊🚢🌊
                🚢🌊🌊🌊🌊🌊🌊🌊🚢🌊
                🚢🌊🌊🌊🌊🌊🌊🌊🚢🌊
                🚢🌊🌊🌊🌊🌊🌊🌊🚢🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🚢🚢🚢🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🚢🚢🌊
                """;
        String expectedP2Grid = """
                🚢🚢🚢🚢🚢🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🚢🚢🚢🚢🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🚢🚢🚢🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🚢🚢🚢🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🚢🚢🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                """;

        Game game = getTestGame();
        assertEquals(expectedP1Grid, game.getP1().renderGrid());
        assertEquals(expectedP2Grid, game.getP2().renderGrid());
    }

    @Test
    void playersFireShots() throws Exception {
        String expectedP1Grid = """
                🌊🌊🌊🌊🌊🚢🚢🚢🌊🌊
                🚢🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🚢🌊💦🌊🌊🌊🌊🌊🚢🌊
                🚢🌊🌊💦🌊🌊🌊🌊🚢🌊
                🚢🌊🌊🌊🌊🌊🌊🌊🚢🌊
                🚢🌊🌊🌊🌊🌊🌊🌊🚢🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🚢🚢🚢🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🚢🚢🌊
                """;
        String expectedP2Grid = """
                💥🚢🚢🚢🚢🌊🌊🌊🌊🌊
                💦🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🚢🚢🚢🚢🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🚢🚢🚢🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🚢🚢🚢🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🚢🚢🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                """;

        Game game = getTestGame();
        game = game.shootAt(0, 0);
        game = game.shootAt(2, 2);
        game = game.shootAt(0, 1);
        game = game.shootAt(3, 3);

        assertEquals(expectedP1Grid, game.getP1().renderGrid());
        assertEquals(expectedP2Grid, game.getP2().renderGrid());
    }

    @Test
    void boatSunk() throws Exception {
        String expectedP2Grid = """
                🚢🚢🚢🚢🚢🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🚢🚢🚢🚢🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🚢🚢🚢🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🚢🚢🚢🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🔥🔥🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                """;

        Game game = getTestGame();
        game = game.shootAt(0, 8)
                .shootAt(0, 0)
                .shootAt(1, 8);

        assertEquals(expectedP2Grid, game.getP2().renderGrid());
    }

    @Test
    void gameEnd() throws Exception {
        String expectedP2Grid = """
                🔥🔥🔥🔥🔥🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🔥🔥🔥🔥🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🔥🔥🔥🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🔥🔥🔥🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🔥🔥🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                """;

        Game game = getTestGame();

        // Destroy carrier
        game = game.shootAt(0, 0).shootAt(0, 0)
                .shootAt(1, 0).shootAt(0, 0)
                .shootAt(2, 0).shootAt(0, 0)
                .shootAt(3, 0).shootAt(0, 0)
                .shootAt(4, 0).shootAt(0, 0);
        assertNull(game.winner());

        // Destroy battleship
        game = game.shootAt(0, 2).shootAt(0, 0)
                .shootAt(1, 2).shootAt(0, 0)
                .shootAt(2, 2).shootAt(0, 0)
                .shootAt(3, 2).shootAt(0, 0);
        assertNull(game.winner());

        // Destroy destroyer
        game = game.shootAt(0, 4).shootAt(0, 0)
                .shootAt(1, 4).shootAt(0, 0)
                .shootAt(2, 4).shootAt(0, 0);
        assertNull(game.winner());

        // Destroy submarine
        game = game.shootAt(0, 6).shootAt(0, 0)
                .shootAt(1, 6).shootAt(0, 0)
                .shootAt(2, 6).shootAt(0, 0);
        assertNull(game.winner());

        // Destroy patrol boat
        game = game.shootAt(0, 8).shootAt(0, 0)
                .shootAt(1, 8);
        assertEquals(game.winner(), game.getP1());

        assertEquals(expectedP2Grid, game.getP2().renderGrid());
    }

    private Game getTestGame() throws Exception {
        Game game = Game.startNew();
        Player p1 = game.getP1();
        p1.placeBoat(new Boat(Orientation.HORIZONTAL, 5, 0, 3));
        p1.placeBoat(new Boat(Orientation.VERTICAL, 0, 1, 5));
        p1.placeBoat(new Boat(Orientation.VERTICAL, 8, 2, 4));
        p1.placeBoat(new Boat(Orientation.HORIZONTAL, 4, 7, 3));
        p1.placeBoat(new Boat(Orientation.HORIZONTAL, 7, 9, 2));

        Player p2 = game.getP2();
        p2.placeBoat(new Boat(Orientation.HORIZONTAL, 0, 0, 5));
        p2.placeBoat(new Boat(Orientation.HORIZONTAL, 0, 2, 4));
        p2.placeBoat(new Boat(Orientation.HORIZONTAL, 0, 4, 3));
        p2.placeBoat(new Boat(Orientation.HORIZONTAL, 0, 6, 3));
        p2.placeBoat(new Boat(Orientation.HORIZONTAL, 0, 8, 2));

        return game;
    }
}
