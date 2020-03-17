package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(
                    String.format("Could not move by diagonal from %s to %s", source, dest)
            );
        }
        int size = dest.x - source.x;
        Cell[] steps = new Cell[size];
        int deltaX = source.x;
        int deltaY = source.y;
        for (int index = 0; index < size; index++) {
            deltaX = dest.x > deltaX ? ++deltaX : --deltaX;
            deltaY = dest.y > deltaY ? ++deltaY : --deltaY;
            steps[index] = Cell.findBy(deltaX, deltaY);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        boolean found = false;
        if (source.x != dest.x && source.y != dest.y) {
            found = true;
        }
        return found;

    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
