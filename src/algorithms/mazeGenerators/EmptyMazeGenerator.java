package algorithms.mazeGenerators;


public class EmptyMazeGenerator extends AMazeGenerator {

    /***
     * generating empty maze with no walls
     * @param rows
     * @param columns
     * @return empty maze with no walls
     */
    @Override
    public Maze generate(int rows, int columns) {
        if(rows < 1 || columns < 1)
            return null;
        Maze emptyMaze = new Maze(rows, columns);
        emptyMaze.makeStartPosition();
        emptyMaze.makeGoalPosition();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                emptyMaze.setMazeArray(i, j, 0);
            }
        }

        return emptyMaze;
    }

}
