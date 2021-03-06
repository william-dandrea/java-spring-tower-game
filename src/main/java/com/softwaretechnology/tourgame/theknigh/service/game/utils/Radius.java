package com.softwaretechnology.tourgame.theknigh.service.game.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author D'Andréa William
 *
 * The
 */
public class Radius {

    private final int radius;
    private final int initialX;
    private final int initialY;

    public Radius(int radius, int initialX, int initialY) {
        this.radius = radius;
        this.initialX = initialX;
        this.initialY = initialY;
    }

    public Radius(int radius, Position positionCenter) {
        this.radius = radius;
        this.initialX = positionCenter.getX();
        this.initialY = positionCenter.getY();
    }


    public List<Position> getPositions() {

        List<Position> positionsWith0 = getPositionsWhenZero();
        List<Position> positions = new ArrayList<>();

        for (Position position: positionsWith0) {

            positions.add(new Position(position.getX() + initialX, position.getY() + initialY));

        }

        return positions;

    }


    public List<Position> getPositionsWhenZero() {

        int yInit = - (this.radius - 1);
        List<Position> positions = new ArrayList<>();


        for (int elem :  generateRows()) {


            int middle = elem / 2;
            int startX = -middle;

            for (int x = startX; x <= middle; x++) {
                positions.add(new Position(x, yInit));
            }


            yInit += 1;
        }


        return positions ;

    }


    /**
     * Generating the unit scale on the board
     * @return
     * the list of the width of the unit at each row
     */
    List<Integer> generateRows() {

        List<Integer> rows = new ArrayList<>();
        rows.add(1);

        if (this.radius == 1) {
            return rows;
        }

        int dLine = 1;
        boolean increase = true;

        for (int i = -(this.radius - 1); i < (this.radius - 1); i++) {

            if (increase)
                dLine += 2;
            else
                dLine -= 2;

            if (dLine == (2*(this.radius - 1) + 1)) {
                increase = false;
            }

            rows.add(dLine);
        }

        return rows;
    }







}
