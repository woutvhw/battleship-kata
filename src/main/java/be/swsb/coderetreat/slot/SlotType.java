package be.swsb.coderetreat.slot;

public enum SlotType {

    WAVE("🌊"),
    BOAT("🚢"),
    EXPLODE("💥"),
    SUNK("🔥"),
    SPLASH("💦")
    ;

    public final String icon;

    SlotType(String icon) {
        this.icon = icon;
    }

}
