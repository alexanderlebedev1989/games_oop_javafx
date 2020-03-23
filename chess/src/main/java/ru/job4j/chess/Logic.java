package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Arrays;
import java.util.Optional;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) {
        boolean rst = false;
        int index = findBy(source);
            try {
                if (index != -1) {
                    Cell[] steps = this.figures[index].way(source, dest);
                    if (isWayFree(steps)) {
                        this.figures[index] = this.figures[index].copy(dest);
                        rst = true;
                    }
                }
            } catch (Exception e) {
                System.out.println(Arrays.toString(e.getStackTrace()));
            }
            return rst;
    }

    public boolean isWayFree(Cell[] way) {
        boolean rst = true;
        for (Cell cell : way) {
            if (findBy(cell) != -1) {
                rst = false;
                break;
            }
        }
        if (!rst) {
            throw new IllegalStateException("Way is not free");
        }
        return rst;
    }


    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    @Override
    public String toString() {
        return "Logic{" +
                "figures=" + Arrays.toString(this.figures) +
                '}';
    }
}
