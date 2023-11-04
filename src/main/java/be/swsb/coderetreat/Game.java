package be.swsb.coderetreat;

public class Game {

    private Grid grid;


    public Game() {
        grid = new Grid();
    }

    public static Game startNew() {
        return new Game();
    }


    public String renderGrid() {
        return this.grid.render();
    }

    public Game addShipHorizontally(int x, int y) {
        for (int i = 0; i < 5; i++) {
            grid.setAtPos(x + i, y, Type.BOAT);
        }
        return this;
    }
}
