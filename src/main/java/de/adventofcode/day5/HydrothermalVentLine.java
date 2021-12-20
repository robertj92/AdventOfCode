package de.adventofcode.day5;

import java.util.ArrayList;
import java.util.List;

public record HydrothermalVentLine(Position position1, Position position2) {

    public List<Position> calculatePositionsInLine() {
        final List<Position> positionsInLine = new ArrayList<>();

        if (position1.x() == position2().x()) {
            for (int i = Math.min(position1.y(), position2.y()); i <= Math.max(position1.y(), position2. y()); i++) {
                positionsInLine.add(new Position(position1.x(), i));
            }
        } else if (position1.y() == position2.y()) {
            for (int i = Math.min(position1.x(), position2.x()); i <= Math.max(position1.x(), position2. x()); i++) {
                positionsInLine.add(new Position(i, position1.y()));
            }
        } else if (Math.abs(position1.x() - position2.x()) == Math.abs(position1.y() - position2.y())) {
            final Position startPosition = position1.x() > position2.x() ? position2 : position1;
            final Position endPosition = position1.x() > position2.x() ? position1 : position2;
            boolean moveUp = endPosition.y() < startPosition.y();

            positionsInLine.add(startPosition);

            Position currentPosition = startPosition;
            while (!currentPosition.equals(endPosition)) {
                currentPosition = new Position(currentPosition.x() + 1, moveUp ? currentPosition.y() - 1 : currentPosition.y() + 1);
                positionsInLine.add(currentPosition);
            }
        }

        return positionsInLine;
    }
}
