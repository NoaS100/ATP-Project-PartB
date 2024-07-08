package algorithms.mazeGenerators;

public abstract class AMazeGenerator implements IMazeGenerator{

    /***
     *measuring the time the algorithm took
     * @param rows
     * @param columns
     * @return time it took creating the maze
     */
    @Override
    public long measureAlgorithmTimeMillis(int rows, int columns) {
        long startTime = System.currentTimeMillis();
        generate(rows, columns);
        return System.currentTimeMillis() - startTime;
    }
}

