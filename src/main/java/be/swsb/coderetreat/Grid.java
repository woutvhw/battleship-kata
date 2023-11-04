package be.swsb.coderetreat;

import java.util.ArrayList;
import java.util.List;

public class Grid {

    private final int xSize = 10, ySize = 10;

    private List<List<Type>> grid;

    public Grid() {
        grid = new ArrayList<>();

        for (int x = 0; x < xSize; x++) {
            List<Type> row = new ArrayList<>();
            for (int y = 0; y < ySize; y++) {
                row.add(Type.WAVE);
            }
            grid.add(row);
        }
    }
    public String render() {
        StringBuilder result = new StringBuilder();

        for (int x = 0; x < xSize; x++) {
            for (int y = 0; y < ySize; y++) {
                result.append(getAtPos(x, y).icon);
            }
            result.append('\n');
        }

        return result.toString();
    }

    private Type getAtPos(int x, int y) {
        return grid.get(x).get(y);
    }

    public void setAtPos(int x, int y, Type type) {
        grid.get(y).set(x, type);
    }

}
