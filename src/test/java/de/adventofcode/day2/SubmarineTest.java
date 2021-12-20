package de.adventofcode.day2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubmarineTest {

    private Submarine submarine = new Submarine();

    @Test
    void testCreateSubmarineWithDefaultPosition_shouldReturn_ZeroValues() {
        assertEquals(0, submarine.getHorizontalPosition());
        assertEquals(0, submarine.getDepth());
        assertEquals(0, submarine.getAim());
    }

    @Test
    void testMoveSubmarineForward_ShouldReturnMovedPosition() {
        submarine.move(new Movement(Direction.DOWN, 5));
        submarine.move(new Movement(Direction.FORWARD, 5));

        assertEquals(5, submarine.getHorizontalPosition());
        assertEquals(5, submarine.getAim());
        assertEquals(25, submarine.getDepth());

        submarine.move(new Movement(Direction.FORWARD, 3));

        assertEquals(8, submarine.getHorizontalPosition());
        assertEquals(5, submarine.getAim());
        assertEquals(40, submarine.getDepth());
    }

    @Test
    void testMoveSubmarineDownward_ShouldReturnMovedPosition() {
        submarine.move(new Movement(Direction.DOWN, 5));

        assertEquals(0, submarine.getDepth());
        assertEquals(5, submarine.getAim());
    }

    @Test
    void testMoveSubmarineUpward_ShouldReturnMovedPosition() {
        submarine.move(new Movement(Direction.DOWN, 5));
        submarine.move(new Movement(Direction.UP, 3));

        assertEquals(2, submarine.getAim());
        assertEquals(0, submarine.getDepth());
    }

    @Test
    void testCalculateTotalMovement_ShouldReturnTheMultiplicationOfXandY() {
        submarine.move(new Movement(Direction.DOWN, 5));
        submarine.move(new Movement(Direction.FORWARD, 3));

        assertEquals(45, submarine.getTotalMovement());

        submarine.move(new Movement(Direction.FORWARD, 3));

        assertEquals(180, submarine.getTotalMovement());
    }
}
