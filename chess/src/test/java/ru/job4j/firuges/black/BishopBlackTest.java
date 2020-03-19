package ru.job4j.firuges.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {
    @Test
    public void whenBishopInPosition() {
        BishopBlack bb = new BishopBlack(Cell.C1);
        assertThat(bb.position(), is(Cell.C1));
    }

    @Test
    public void whenBishopCopy() {
        BishopBlack bb = new BishopBlack(Cell.C1);
        Figure b = bb.copy(Cell.E3);
        assertThat(b.position(), is(Cell.E3));
    }

    @Test
    public void whenBishopWay() {
        BishopBlack bb = new BishopBlack(Cell.C1);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Cell[] steps = bb.way(Cell.C1, Cell.G5);
        assertThat(steps, is(expected));
    }

    @Test
    public void whenIsDiagonal() {
        BishopBlack bb = new BishopBlack(Cell.C1);
        boolean steps = bb.isDiagonal(Cell.C1, Cell.G5);
        assertThat(steps, is(true));
    }

    @Test(expected = IllegalStateException.class)
    public void whenBishopWay1() {
        BishopBlack bb = new BishopBlack(Cell.C1);
        bb.way(Cell.C1, Cell.D3);
    }


}
