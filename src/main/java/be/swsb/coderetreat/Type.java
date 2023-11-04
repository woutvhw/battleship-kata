package be.swsb.coderetreat;

public enum Type {

    WAVE("🌊"),
    BOAT("🚢"),
    EXPLODE("💥"),
    SUNK("😢")
    ;

    public final String icon;

    Type(String icon) {
        this.icon = icon;
    }

}
