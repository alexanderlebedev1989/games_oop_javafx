package ru.job4j.firuges.black;

import org.junit.Test;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;
import ru.job4j.chess.firuges.black.RookBlack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LogicTest {
    @Test
    public void whenMoveFalse() {
        Logic logic = new Logic();
        Figure bb = new BishopBlack(Cell.C1);
        Figure two = new PawnBlack(Cell.E3);
        logic.add(bb);
        logic.add(two);
        boolean rsl = logic.move(Cell.C1, Cell.G5);
        assertThat(rsl, is(false));
    }

    @Test
    public void whenMoveTrue() {
        Logic logic = new Logic();
        Figure bb = new BishopBlack(Cell.C1);
        logic.add(bb);
        boolean rsl = logic.move(Cell.C1, Cell.G5);
        assertThat(rsl, is(true));
    }

    @Test
    public void isWayFree() {
        Logic logic = new Logic();
        Figure one = new BishopBlack(Cell.C1);
        logic.add(one);
        boolean result = logic.isWayFree(Cell.C1, Cell.G5);
        assertThat(result, is(true));
    }

    @Test(expected = IllegalStateException.class)
    public void isWayFreeException() {
        Logic logic = new Logic();
        Figure one = new BishopBlack(Cell.C1);
        Figure two = new PawnBlack(Cell.E3);
        logic.add(one);
        logic.add(two);
        logic.isWayFree(Cell.C1, Cell.G5);
    }
}

