/**
 * A visual representation of a {@link GameOfLife.World}.
 */

package GameOfLife.Display;

import GameOfLife.Generation;
import javax.swing.*;
import java.awt.*;

class Grid extends JPanel {
    final int GAP = 2;
    int size;
    JPanel[][] cells;
    GridLayout layout;

    /**
     * Constructs a grid.
     * @param size
     * @param dimensions
     */
    public Grid(int size, int dimensions) {
        // Sets the window's general appearance:
        super();
        this.size = size;
        this.cells = new JPanel[this.size][this.size];
        this.layout = new GridLayout(this.size, this.size);
        setLayout(layout);
        setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, this.GAP));
        setBackground(Color.DARK_GRAY);
        int cellSize = (int) size / dimensions - 2 * size;

        // Initializes the cells:
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                this.cells[i][j] = new JPanel();
                this.cells[i][j].setSize(cellSize, cellSize);
                this.cells[i][j].setBorder(BorderFactory.createLineBorder(Color.WHITE, this.GAP/2));  // The GAP is divided by 2 since the gap between cells is 2 * cell[i][j].thickness.
                add(this.cells[i][j]);
            }
        }

    }

    /**
     * Updates the grid to display the currentGeneration.
     * @param currentGeneration
     */
    public void update(Generation currentGeneration) {
        for(int i = 0; i < this.size; i++) {
            for(int j = 0; j < this.size; j++) {
                if(currentGeneration.isAlive(i,j)) {
                    this.cells[i][j].setBackground(Color.ORANGE);
                }
                else {
                    this.cells[i][j].setBackground(Color.WHITE);
                }
            }
        }
    }
}
