package com.nhnacademy.yunhwa.Exercise4_7;

import javafx.scene.paint.Color;
/**
 * This program opens a window full of randomly colored squares. A "disturbance"
 * moves randomly around in the window, randomly changing the color of each
 * square that it visits. The program runs until the user closes the window.
 */

public class RandomMosaicWalk {

    static int currentRow; // Row currently containing the disturbance.
    static int currentColumn; // Column currently containing disturbance.

    static final int ROWS = 80;
    static final int COLUMNS = 80;
    static final int SQUARE_SIZE = 5;

    /**
     * The main program creates the window, fills it with random colors,
     * and then moves the disturbance in a random walk around the window
     * as long as the window is open.
     */
    public static void main(String[] args) {
//        int rows = 16;
//        int columns = 20;
//        int blockHeight = 25;
//        int blockWidth = 25;

        Mosaic.setUse3DEffect(false);
        Mosaic.open(ROWS, COLUMNS, SQUARE_SIZE, SQUARE_SIZE);
        fillWithRandomColors();
        while (true) {
            setCurrentRowAndColRandom();
            beforehandMoveAndFillSameColorOnIt();
            // Mosaic.delay(10); // Remove this line to speed things up!
        }
    } // end main

    static void setCurrentRowAndColRandom() {
        currentRow = (int) (ROWS * Math.random());
        currentColumn = (int) (COLUMNS * Math.random());
    }

    /**
     * Fills the window with randomly colored squares.
     * Precondition: The mosaic window is open.
     * Postcondition: Each square has been set to a random color.
     */
    static void fillWithRandomColors() {
        int row, column;
        for (row = 0; row < ROWS; row++) {
            for (column = 0; column < COLUMNS; column++) {
                changeToRandomColor(row, column);
            }
        }
    } // end fillWithRandomColors

    static void fillWithBlackColor() {
        int row, column;
        for (row = 0; row < ROWS; row++) {
            for (column = 0; column < COLUMNS; column++) {
                changeToBlackColor(row, column);
            }
        }
    } // end fillWithBlackColor

    /**
     * Changes one square to a new randomly selected color.
     * Precondition: The specified rowNum and colNum are in the valid range
     * of row and column numbers.
     * Postcondition: The square in the specified row and column has
     * been set to a random color.
     * 
     * @param rowNum the row number of the square, counting rows down
     *               from 0 at the top
     * @param colNum the column number of the square, counting columns over
     *               from 0 at the left
     */
    static void changeToRandomColor(int rowNum, int colNum) {
        int red = (int) (256 * Math.random()); // Choose random levels in range
        int green = (int) (256 * Math.random()); // 0 to 255 for red, green,
        int blue = (int) (256 * Math.random()); // and blue color components.
        Mosaic.setColor(rowNum, colNum, red, green, blue);
    } // end changeToRandomColor

    static void changeToBlackColor(int rowNum, int colNum) {
        // black's R.G.B
        int red = 0;
        int green = 0;
        int blue = 0;

        Mosaic.setColor(rowNum, colNum, red, green, blue);
    } // end changeToBlackColor

    static void addLittleGreen(int rowNum, int colNum) {

        int red = Mosaic.getRed(rowNum, colNum);
        int green = Mosaic.getGreen(rowNum, colNum) + 25;
        int blue = Mosaic.getBlue(rowNum, colNum);

        if (green <= 255) {
            Mosaic.setColor(rowNum, colNum, red, green, blue);
        }
        
    }

    static void beforehandMoveAndFillSameColorOnIt() {
        Color myColor = Mosaic.getColor(currentRow, currentColumn);

        int directionNum; // Randomly set to 0, 1, 2, or 3 to choose direction.
        directionNum = (int) (4 * Math.random());
        switch (directionNum) {
            case 0: { // move up
                int besideRow = currentRow - 1;
                if (besideRow < 0) // besideRow is outside the mosaic;
                    besideRow = ROWS - 1; // move it to the opposite edge.
                Mosaic.setColor(besideRow, currentColumn, myColor);
                break;
            }
            case 1: { // move right
                int besideColumn = currentColumn + 1;
                if (besideColumn >= COLUMNS)
                    besideColumn = 0;
                Mosaic.setColor(currentRow, besideColumn, myColor);
                break;
            }
            case 2: { // move down
                int besideRow = currentRow + 1;
                if (besideRow >= ROWS)
                    besideRow = 0;
                Mosaic.setColor(besideRow, currentColumn, myColor);
                break;
            }
            case 3: { // move left
                int besideColumn = currentColumn - 1;
                if (besideColumn < 0)
                    besideColumn = COLUMNS - 1;
                Mosaic.setColor(currentRow, besideColumn, myColor);
                break;
            }
        }
    } // end beforehandMoveAndFillSameColorOnIt


    /**
     * Move the disturbance.
     * Precondition: The global variables currentRow and currentColumn
     * are within the legal range of row and column numbers.
     * Postcondition: currentRow or currentColumn is changed to one of the
     * neighboring positions in the grid -- up, down, left, or
     * right from the current position. If this moves the
     * position outside of the grid, then it is moved to the
     * opposite edge of the grid.
     */
    static void randomMove() {
        int directionNum; // Randomly set to 0, 1, 2, or 3 to choose direction.
        directionNum = (int) (4 * Math.random());
        switch (directionNum) {
            case 0: { // move up
                currentRow--;
                if (currentRow < 0) // CurrentRow is outside the mosaic;
                    currentRow = ROWS - 1; // move it to the opposite edge.
                break;
            }
            case 1: { // move right
                currentColumn++;
                if (currentColumn >= COLUMNS)
                    currentColumn = 0;
                break;
            }
            case 2: { // move down
                currentRow++;
                if (currentRow >= ROWS)
                    currentRow = 0;
                break;
            }
            case 3: { // move left
                currentColumn--;
                if (currentColumn < 0)
                    currentColumn = COLUMNS - 1;
                break;
            }
        }
    } // end randomMove

} // end class RandomMosaicWalk