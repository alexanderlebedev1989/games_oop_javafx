package job4j.tictactoe;

import java.util.function.Predicate;

public class Logic3T {
    /*
    переменная класса
    конструктор,который прнимает параметр в виде двухмерного массива
     */
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
            if (!predicate.test(cell)) {// это правда, что в этом месте есть X?
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean isWinnerX() {
        return fillBy(Figure3T::hasMarkX, 0, 0, 0, 1) ||
                fillBy(Figure3T::hasMarkX, 1, 0, 0, 1) ||
                fillBy(Figure3T::hasMarkX, 2, 0, 0, 1) ||
                fillBy(Figure3T::hasMarkX, 0, 0, 1, 0) ||
                fillBy(Figure3T::hasMarkX, 0, 1, 1, 0) ||
                fillBy(Figure3T::hasMarkX, 0, 2, 1, 0) ||
                fillBy(Figure3T::hasMarkX, 0, 0, 1, 1) ||
                fillBy(Figure3T::hasMarkX, this.table.length - 1, 0, -1, 1);
    }

    public boolean isWinnerO() {
        return fillBy(Figure3T::hasMarkO, 0, 0, 0, 1) ||
                fillBy(Figure3T::hasMarkO, 1, 0, 0, 1) ||
                fillBy(Figure3T::hasMarkO, 2, 0, 0, 1) ||
                fillBy(Figure3T::hasMarkO, 0, 0, 1, 0) ||
                fillBy(Figure3T::hasMarkO, 0, 1, 1, 0) ||
                fillBy(Figure3T::hasMarkO, 0, 2, 1, 0) ||
                fillBy(Figure3T::hasMarkO, 0, 0, 1, 1) ||
                fillBy(Figure3T::hasMarkO, this.table.length - 1, 0, -1, 1);
    }

    public boolean hasGap() {
        boolean result = false;
        for (int i = 0; i != table.length; i++) {
            for (int j = 0; j != table.length; j++) {
                Figure3T cell = this.table[i][j];
                if (!cell.hasMarkX() && !cell.hasMarkO()) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}
