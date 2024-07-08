package algorithms.mazeGenerators;

public interface IMazeGenerator {

    /***
     * generating a maze
     * @param rows
     * @param columns
     * @return maze created
     */
    Maze generate(int rows, int columns);

    /***
     * measuring the time the algorithm took
     * @param rows
     * @param columns
     * @return time it took creating the maze
     */
    long measureAlgorithmTimeMillis(int rows, int columns);

}
