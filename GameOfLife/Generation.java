/**
 * A generation in the {@link GameOfLife.World}.
 */
package GameOfLife;

import java.util.Random;

public class Generation {

    private final boolean alive = true;
    private final boolean dead = false;
    private final int size;

    private boolean[][] cells;

    // Constructors:

    /**
     * Constructs the first Generation.
     * @param size
     */
    public Generation(int size) {
        this.size = size;
        this.cells = new boolean[this.size][this.size];

        // Initialize cells' state to be alive or dead using random:
        Random random = new Random();
        for(int i = 0; i < this.size; i++) {
            for(int j = 0; j < this.size; j++) {
                if(random.nextBoolean()) {
                    this.cells[i][j] = alive;
                }
                else {
                    this.cells[i][j] = dead;
                }
            }
        }
    }

    /**
     * Constructs a generation according to the previous Generation's state and to the Game of Life's rules.
     * @param previousGeneration
     */
    public Generation(Generation previousGeneration) {
        this.size = previousGeneration.getSize();
        this.cells = new boolean[this.size][this.size];
        //updateWindow the cells
        for(int i = 0; i < this.size; i++) {
            for(int j = 0; j < this.size; j++) {
                this.cells[i][j] = previousGeneration.nextGenCellVal(i, j);
            }
        }
    }

    /**
     * @return The nember of alive cells in this Generation.
     */
    public int numberOfAliveCells() {
        int counter = 0;
        for(int i = 0; i<this.size; i++) {
            for(int j = 0; j<this.size; j++) {
                if(this.isAlive(i,j)) {
                    counter++;
                }
            }
        }
        return counter;
    }

    /**
     * @return size.
     */
    public int getSize() {
        return size;
    }

    /**
     * @param cellValue
     * @return ture if cellValue represents alive cell, false if represents a dead cell.
     */
    public boolean isAlive(boolean cellValue) {
        return cellValue;
    }

    /**
     * @param row
     * @param col
     * @return ture if cell[row][col] is alive, false if it is a dead cell.
     */
    public boolean isAlive(int row, int col) {
        return this.cells[row][col];
    }

    /**
     * @param coordinate x or y
     * @return the (x or y) coordinate of the previous cell.
     */
    public int decreaseCoordinate(int coordinate) {
        return ((coordinate == 0) ? (this.size - 1) : (coordinate - 1));
    }

    /**
     * @param coordinate x or y
     * @return the (x or y) coordinate of the next cell.
     */
    public int increaseCoordinate(int coordinate) {
        return ((coordinate == (this.size - 1)) ? (0) : (coordinate + 1));
    }

    /**
     * @param row
     * @param col
     * @return true if cells[row][col] is alive in the next Generation, false if dead.
     */
    public boolean nextGenCellVal(int row, int col) {
        int aliveNeighbors = this.numberOfAliveNeighbors(row, col);
        boolean nextVal;
        if(this.isAlive(this.cells[row][col])) {
            if((aliveNeighbors == 2) || (aliveNeighbors == 3)) {
                nextVal = alive;
            }
            else {
                nextVal = dead;
            }
        }
        else {
            if(aliveNeighbors == 3) {
                nextVal = alive;
            }
            else {
                nextVal = dead;
            }
        }
        return nextVal;
    }

    /**
     * @param row
     * @param col
     * @return The number of alive neighbors of cells[row][col].
     */
    public int numberOfAliveNeighbors(int row, int col) {
        int counter = 0;
        if(this.isAlive(row, col)) {
            counter = -1;
        }

        int neighborRow = this.decreaseCoordinate(row);
        int neighborColStart = this.decreaseCoordinate(col);
        for(int i =0; i <3; i++){
            int neighborCol = neighborColStart;
            for(int j=0; j<3;j++) {
                if(this.isAlive(neighborRow, neighborCol)) {
                    counter++;
                }
                neighborCol = this.increaseCoordinate(neighborCol);
            }
            neighborRow = this.increaseCoordinate(neighborRow);
        }

        return counter;
    }

}
