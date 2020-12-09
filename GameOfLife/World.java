/**
 *  <h1>World</h1>
 *  A 2D world that follow Conway's Game of Life rules.
 */

package GameOfLife;

public class World {
    Generation currentGeneration;
    private int currentGenerationNumber;
    private final int maxGeneration;

    /**
     * Constructs a World, starting generation number 1.
     * @param size          Number of cells in the World = size * size.
     * @param maxGeneration
     */
    public World(int size, int maxGeneration) {
        this.currentGeneration = new Generation(size);
        this.maxGeneration = maxGeneration;
        this.currentGenerationNumber = 1;
    }

    // Getters:
    /**
     * @return currentGeneration
     */
    public Generation getCurrentGeneration() {
        return currentGeneration;
    }

    /**
     * @return maxGeneration
     */
    public int getMaxGeneration() {
        return maxGeneration;
    }

    /**
     * @return The number of the current generation.
     */
    public int getCurrentGenerationNumber() {
        return currentGenerationNumber;
    }

    /**
     * @return The number of alive cells.
     */
    public int getNumberOfAliveCells() {
        return currentGeneration.numberOfAliveCells();
    }

    /**
     * Updates the generation.
     */
    public void updateGeneration() {
        this.currentGenerationNumber++;
        this.currentGeneration = new Generation(currentGeneration);
    }

}

