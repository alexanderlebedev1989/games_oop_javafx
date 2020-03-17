package ru.job4j.firuges.black;

import org.junit.Test;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.KingBlack;
import ru.job4j.chess.firuges.black.PawnBlack;
import ru.job4j.chess.firuges.black.RookBlack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LogicTest {
    @Test
    public void whenMove1() {
        Logic logic = new Logic();
        Figure b = new BishopBlack(Cell.C1);
        logic.add(b);
        boolean rsl = logic.move(Cell.C1, Cell.G5);
        assertThat(rsl, is(true));
    }

    @Test(expected = IllegalStateException.class)
    public void whenMove2() {
        Logic logic = new Logic();
        Figure b = new BishopBlack(Cell.C1);
        Figure c = new RookBlack(Cell.E3);
        logic.add(b);
        logic.add(c);
        logic.move(Cell.C1, Cell.G5);
    }
}

