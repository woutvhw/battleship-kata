package be.swsb.coderetreat;

import java.util.*;

public class Util {

    public static boolean hasCommonElement(Collection<?> col1, Collection<?> col2) {
        for (Object element : col1) {
            for (Object element2 : col2) {
                if (element.equals(element2)) {
                    return true;
                }
            }
        }
        return false;
    }

}
