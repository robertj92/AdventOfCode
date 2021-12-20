package de.adventofcode.day2;

public class Submarine {

    private int horizontalPosition = 0;
    private int depth = 0;
    private int aim = 0;

    public int getHorizontalPosition() {
        return horizontalPosition;
    }

    public int getDepth() {
        return depth;
    }

    public int getAim() {
        return aim;
    }

    public int getTotalMovement() {
        return horizontalPosition * depth;
    }

    public void move(Movement movement) {
        if (Direction.FORWARD.equals(movement.direction())) {
            horizontalPosition += movement.distance();
            depth += movement.distance() * aim;
        } else if (Direction.DOWN.equals(movement.direction()))
            aim += movement.distance();
        else if (Direction.UP.equals(movement.direction()))
            aim -= movement.distance();
    }
}
