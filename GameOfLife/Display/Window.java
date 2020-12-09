/**
 * <h1>Display</h1>
 * Displaying the Game of Life to the user through a window.
 */

package GameOfLife.Display;

import GameOfLife.Generation;
import javax.swing.*;
import java.awt.*;


public class Window extends JFrame {

    final int WINDOW_WIDTH = 500;
    final int WINDOW_HEIGHT = 550;

    int time;  //Wait time in milliseconds.
    int generationNumber = 0;

    JPanel top;
    Label generation;
    Label aliveCells;
    Label space;
    Grid grid;

    /**
     * Constructor for class Window.
     * @param title     Window's title.
     * @param time      Time period of each generation in milliseconds.
     * @param gridSize  Number of cells in a row and in a column.
     */
    public Window(String title, int time, int gridSize) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(this.WINDOW_WIDTH, this.WINDOW_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);    // Center the window
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        this.time = time;

        // Labels:
        add(top = new JPanel());
        top.setBackground(Color.DARK_GRAY);
        this.top.add(this.generation = new Label("Generation: ", Color.WHITE));
        this.top.add(this.space = new Label ("  |  ", Color.GRAY));
        this.top.add(this.aliveCells = new Label ("Alive: ", Color.ORANGE));
        // Grid:
        add(this.grid = new Grid(gridSize, Math.min(this.WINDOW_HEIGHT, this.WINDOW_WIDTH)));

        setVisible(true);
    }

    /**
     * Updates the display.
     * @param alive
     * @param currentGeneration
     */
    public void updateWindow(int alive, Generation currentGeneration) {
        this.generation.update(++this.generationNumber);
        this.aliveCells.update(alive);
        this.grid.update(currentGeneration);
        revalidate();
        repaint();
        sleep();
    }

    /**
     * Wait during this.time (milliseconds).
     */
    private void sleep() {
        try {
            Thread.sleep(this.time);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}




