/**
 * <h1>Game of Life</h1>
 * The GameOfLife program implements an application that
 * displays Conway's Game of Life visually.
 * <p>
 * The rules are:
 * 1. An alive cell stays alive if it has 2-3 alive neighbors.
 * 2. A dead cell becomes alive if it has 3 alive neighbors.
 * 3. Any other cell will die.
 *
 * @author Lihi V
 * @version 1.0
 * @since DEC.2020
 */

package GameOfLife;

import GameOfLife.Display.Window;

public class GameOfLife {

    final static int SIZE = 40;
    final static int SPEED = 2000;
    final static int MAX_GENERATION = 1000;
    static String TITLE = "Game of Life";

    /**
     * Starts Game of Life.
     * @param args
     */
    public static void main(String[] args) {
        runTheWorld(new World(SIZE, MAX_GENERATION), new Window(TITLE, SPEED, SIZE));
    }

    /**
     * Run the Game of Life.
     * @param world    The model
     * @param window   The display
     */
    private static void runTheWorld(World world, Window window) {
        for(int i = 1; i <= world.getMaxGeneration(); i++) {
            world.updateGeneration();
                window.updateWindow(world.getNumberOfAliveCells(), world.currentGeneration);
        }
    }
}
