package be.swsb.coderetreat;

import be.swsb.coderetreat.boat.Boat;
import be.swsb.coderetreat.boat.Orientation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {


    @Test
    void emptyGrid() {
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
        String grid = new Grid().render();
        assertEquals(expectedGrid, grid);
    }

    @Test
    void addShipHorizontally() {
        String expectedField = """
                🚢🚢🚢🚢🚢🌊🌊🌊🌊🌊
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
        testBoatPlacement(expectedField,
                new Boat(Orientation.HORIZONTAL, 0, 0, 5));
    }

    @Test
    void addShipHorizontallyAtNextColumn() {
        String expectedField = """
                🌊🚢🚢🚢🚢🚢🌊🌊🌊🌊
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
        testBoatPlacement(expectedField,
                new Boat(Orientation.HORIZONTAL,1, 0, 5));
    }

    @Test
    void addShipHorizontallyAtNextRow() {
        String expectedField = """
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🚢🚢🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                """;
        testBoatPlacement(expectedField,
                new Boat(Orientation.HORIZONTAL, 0, 1, 2));
    }

    @Test
    void addShipVertically() {
        String expectedField = """           
                🚢🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🚢🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🚢🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🚢🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🚢🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                """;
        testBoatPlacement(expectedField,
                new Boat(Orientation.VERTICAL, 0, 0, 5));
    }

    @Test
    void addShipVerticallyAtNextColumn() {
        String expectedField = """
                🌊🚢🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🚢🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🚢🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🚢🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🚢🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🚢🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                """;
        testBoatPlacement(expectedField,
                new Boat(Orientation.VERTICAL, 1, 0, 6));
    }

    @Test
    void addShipVerticallyAtNextRow() {
        String expectedField = """
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🚢🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🚢🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🚢🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🚢🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                """;
        testBoatPlacement(expectedField,
                new Boat(Orientation.VERTICAL, 0, 1, 4));
    }

    @Test
    void addTwoShips() {
        String expectedField = """
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🚢🚢🚢
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🚢🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🚢🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🚢🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🚢🌊🌊🌊🌊🌊🌊🌊🌊🌊
                """;
        testBoatPlacement(expectedField,
                new Boat(Orientation.HORIZONTAL, 7, 1, 3),
                new Boat(Orientation.VERTICAL, 0, 6, 4));
    }

    @Test
    void addMultipleShips() {
        String expectedField = """
                🚢🚢🚢🚢🚢🚢🚢🚢🚢🚢
                🚢🌊🌊🌊🌊🚢🌊🌊🌊🚢
                🚢🌊🌊🌊🌊🚢🌊🌊🌊🌊
                🚢🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🚢🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                """;
        testBoatPlacement(expectedField,
                new Boat(Orientation.VERTICAL, 0, 0, 5),
                new Boat(Orientation.HORIZONTAL, 1, 0, 4),
                new Boat(Orientation.VERTICAL, 5, 0, 3),
                new Boat(Orientation.HORIZONTAL, 6, 0, 3),
                new Boat(Orientation.VERTICAL, 9, 0, 2));
    }

    private void testBoatPlacement(String expectedField, Boat... boats) {
        try {
            Grid grid = new Grid();
            for (Boat boat : boats) {
                grid.placeBoat(boat);
            }
            String actualField = grid.render();

            assertEquals(expectedField, actualField);
        } catch (Exception e) {
            fail(e);
        }
    }


    @Test
    void placeShipOutsideGridHorizontally() {
        try {
            Grid grid = new Grid();
            Boat boat = new Boat(Orientation.HORIZONTAL, 7, 0, 4);
            grid.placeBoat(boat);

            fail("No exception thrown: " + boat.getSlots());
        } catch (Exception expected) {}
    }

    @Test
    void placeShipOutsideGridVertically() {
        try {
            Grid grid = new Grid();
            Boat boat = new Boat(Orientation.VERTICAL, 0, 7, 4);
            grid.placeBoat(boat);

            fail("No exception thrown: " + boat.getSlots());
        } catch (Exception expected) {}
    }

    @Test
    void placeShipOnTopOfOtherShip() {
        try {
            Grid grid = new Grid();
            Boat boat1 = new Boat(Orientation.HORIZONTAL, 0, 0, 4);
            Boat boat2 = new Boat(Orientation.VERTICAL, 0, 0, 4);
            grid.placeBoat(boat1);
            grid.placeBoat(boat2);

            fail("No exception thrown: " + boat1.getSlots() + ", " + boat2.getSlots());
        } catch (Exception expected) {}
    }
}