package be.swsb.coderetreat;

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

}