package be.swsb.coderetreat;

import be.swsb.coderetreat.boat.Boat;
import be.swsb.coderetreat.boat.Orientation;
import be.swsb.coderetreat.slot.Slot;
import be.swsb.coderetreat.slot.SlotType;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ExtraTest {


    @Test
    void slotEqualExcludeType() {
        Slot slot1 = new Slot(0, 0, SlotType.BOAT);
        Slot slot2 = new Slot(0, 0, SlotType.WAVE);
        Slot slot3 = new Slot(0, 1, SlotType.EXPLODE);

        assertEquals(slot1, slot2);
        assertTrue(Util.hasCommonElement(List.of(slot1, slot3), List.of(slot2)));
    }

    @Test
    void horizontalBoatSlotTest() {
        Boat boat = new Boat(Orientation.HORIZONTAL, 0, 0, 3);

        Set<Slot> expectedBoatSlots = new HashSet<>();
        expectedBoatSlots.add(new Slot(0, 0, SlotType.BOAT));
        expectedBoatSlots.add(new Slot(1, 0, SlotType.BOAT));
        expectedBoatSlots.add(new Slot(2, 0, SlotType.BOAT));

        assertEquals(boat.getSlots(), expectedBoatSlots);
    }

    @Test
    void verticalBoatSlotTest() {
        Boat boat = new Boat(Orientation.VERTICAL, 0, 0, 3);

        Set<Slot> expectedBoatSlots = new HashSet<>();
        expectedBoatSlots.add(new Slot(0, 0, SlotType.BOAT));
        expectedBoatSlots.add(new Slot(0, 1, SlotType.BOAT));
        expectedBoatSlots.add(new Slot(0, 2, SlotType.BOAT));

        assertEquals(boat.getSlots(), expectedBoatSlots);
    }
}