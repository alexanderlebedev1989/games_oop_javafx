package job4j.tictactoe;

import java.util.Arrays;
import java.util.function.Predicate;


public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }


    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean isWinnerX() {
        return isWin(Figure3T::hasMarkX);
    }

    public boolean isWinnerO() {
        return isWin(Figure3T::hasMarkO);
    }

    public boolean isWin(Predicate<Figure3T> winCondition) {
        boolean result = false;
        for (int i = 0; i < this.table.length; i++) {
            if (fillBy(winCondition, i, 0, 0, 1) ||
                    fillBy(winCondition, 0, i, 1, 0) ||
                    fillBy(winCondition, 0, 0, 1, 1) ||
                    fillBy(winCondition, this.table.length - 1, 0, -1, 1)) {
                result = true;
                break;
            }
        }
        return result;
    }


    public boolean hasGap() {
        boolean result = false;
        Figure3T cell = Arrays.stream(table).flatMap(Arrays::stream).
                filter(a -> !a.hasMarkX() && !a.hasMarkO()).findAny().orElse(null);
       if (cell != null) result = true;
       return result;
    }
}
