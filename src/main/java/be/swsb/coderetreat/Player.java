package be.swsb.coderetreat;

import be.swsb.coderetreat.boat.Boat;

public class Player {

    private final Grid grid;

    public Player() {
        this.grid = new Grid();
    }

    public String renderGrid() {
        return this.grid.render();
    }

    public void placeBoat(Boat boat) throws Exception {
        this.grid.placeBoat(boat);
    }

    public void receiveShot(int x, int y) throws Exception {
        this.grid.receiveShot(x, y);
    }

    public boolean allBoatsDestroyed() {
        return !this.grid.hasRemainingBoats();
    }
}
