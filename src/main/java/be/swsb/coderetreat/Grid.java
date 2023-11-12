package be.swsb.coderetreat;

import be.swsb.coderetreat.boat.Boat;
import be.swsb.coderetreat.slot.Slot;
import be.swsb.coderetreat.slot.SlotType;

import java.util.*;

public class Grid {

    private static final int X_SIZE = 10, Y_SIZE = 10;

    private final List<Boat> boats = new ArrayList<>();

    private final List<Slot> misses = new ArrayList<>();


    public String render() {
        String[][] grid = new String[Y_SIZE][X_SIZE];

        // Initialize grid with waves
        for (int y = 0; y < Y_SIZE; y++) {
            for (int x = 0; x < X_SIZE; x++) {
                grid[y][x] = SlotType.WAVE.icon;
            }
        }

        // Place boats on the grid
        for (Boat boat : this.boats) {
            for (Slot boatSlot : boat.getSlots()) {
                grid[boatSlot.y][boatSlot.x] = boatSlot.getType().icon;
            }
        }

        // Place misses on the grid
        for (Slot missedShot : this.misses) {
            grid[missedShot.y][missedShot.x] = missedShot.getType().icon;
        }

        // Convert grid to string
        StringBuilder result = new StringBuilder();
        for (int y = 0; y < Y_SIZE; y++) {
            for (int x = 0; x < X_SIZE; x++) {
                result.append(grid[y][x]);
            }
            result.append("\n");
        }

        return result.toString();
    }


    public void placeBoat(Boat newBoat) throws Exception {
        // Get slots this boat would occupy
        Set<Slot> newBoatSlots = newBoat.getSlots();

        // Verify that all slots are inside grid
        for (Slot slot : newBoatSlots) {
            if (isOutsideGrid(slot.x, slot.y)) {
                throw new Exception("Boat would be placed outside of the grid at slot " + slot + ".");
            }
        }

        // Verify that all slots are unoccupied
        for (Boat existingBoat : this.boats) {
            if (Util.hasCommonElement(existingBoat.getSlots(), newBoatSlots)) {
                throw new Exception("Boats cannot occupy the same slot.");
            }
        }

        this.boats.add(newBoat);
    }

    private boolean isOutsideGrid(int x, int y) {
        return x >= X_SIZE || y >= Y_SIZE;
    }

    public void receiveShot(int x, int y) throws Exception {
        // Verify that slot is inside grid
        if (isOutsideGrid(x, y)) {
            throw new Exception("Shot is fired outside of the grid at x=" + x + ", y=" + y + ".");
        }

        // Fire at boats
        for (Boat boat : this.boats) {
            if (boat.potentialHit(x, y)) {
                // Stop early since only one boat can be hit
                return;
            }
        }

        // Record miss
        misses.add(new Slot(x, y, SlotType.SPLASH));
    }

    public boolean hasRemainingBoats() {
        for (Boat boat: this.boats) {
            if (!boat.isDestroyed()) {
                return true;
            }
        }
        return false;
    }
}
