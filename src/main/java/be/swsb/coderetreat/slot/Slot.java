package be.swsb.coderetreat.slot;

public class Slot {

    public final int x, y;

    private SlotType slotType;

    public Slot(int x, int y, SlotType slotType) {
        this.x = x;
        this.y = y;
        this.slotType = slotType;
    }


    public SlotType getType() {
        return slotType;
    }

    public void setType(SlotType slotType) {
        this.slotType = slotType;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Slot other)) {
            return false;
        }
        return this.hashCode() == other.hashCode();
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(x + "" + y);
    }
}