package be.swsb.coderetreat.boat;

import be.swsb.coderetreat.slot.Slot;
import be.swsb.coderetreat.slot.SlotType;

import java.util.*;

public class Boat {

    private final Set<Slot> slots = new HashSet<>();

    public Boat(Orientation orientation, int x, int y, int length) {
        Slot slot = new Slot(x, y, SlotType.BOAT);
        for (int i = 0; i < length; i++) {
            slots.add(slot);
            slot = orientation.getNext.apply(slot);
        }
    }

    public Set<Slot> getSlots() {
        return new HashSet<>(this.slots);
    }

    public boolean isDestroyed() {
        for (Slot slot: this.slots) {
            if (slot.getType() == SlotType.BOAT) {
                return false;
            }
        }
        return true;
    }

    public boolean potentialHit(int x, int y) {
        for (Slot slot : this.slots) {
            if (slot.x == x && slot.y == y) {
                slot.setType(SlotType.EXPLODE);
                potentialSink();
                return true;
            }
        }
        return false;
    }

    private void potentialSink() {
        if (isDestroyed()) {
            for (Slot slot : this.slots) {
                slot.setType(SlotType.SUNK);
            }
        }
    }
}
