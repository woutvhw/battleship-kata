package be.swsb.coderetreat.boat;

import be.swsb.coderetreat.slot.Slot;

import java.util.function.Function;

public enum Orientation {

    HORIZONTAL(slot -> new Slot(slot.x + 1, slot.y, slot.getType())),
    VERTICAL(slot -> new Slot(slot.x, slot.y + 1, slot.getType())),

    ;

    public final Function<Slot, Slot> getNext;

    Orientation(Function<Slot, Slot> getNext) {
        this.getNext = getNext;
    }
}
