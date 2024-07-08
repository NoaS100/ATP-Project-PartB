package algorithms.mazeGenerators;

import java.util.Random;

public class SimpleMazeGenerator extends AMazeGenerator {

    /***
     * generating simple random maze
     * @param rows
     * @param columns
     * @return  simple random maze
     */
    @Override
    public Maze generate(int rows, int columns) {
        if(rows < 1 || columns < 1)
            return null;
        Maze maze = new Maze(rows, columns);
        Random random = new Random();
        int[][] newMazeArr = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                newMazeArr[i][j] = random.nextInt(2);
            }
        }

        maze.setMazeArray(newMazeArr);

        // choosing random start and end point
        maze.makeStartPosition();
        maze.makeGoalPosition();
        makingAPath(maze);
        return maze;
    }

    /***
     * auxiliary function to generate helping pave the way
     * @param maze
     */
    private void makingAPath(Maze maze) {
        Position start = maze.getStartPosition();
        Position goal = maze.getGoalPosition();
        int startRow = start.getRowIndex();
        int startCol = start.getColumnIndex();
        int goalRow = goal.getRowIndex();
        int goalCol = goal.getColumnIndex();

        int currentRow = startRow;
        int currentCol = startCol;

        // Create a path to the goal
        while (currentRow != goalRow || currentCol != goalCol) {
            maze.setMazeArray(currentRow, currentCol, 0);

            if (currentRow < goalRow) {
                currentRow++;
            } else if (currentRow > goalRow) {
                currentRow--;
            } else if (currentCol < goalCol) {
                currentCol++;
            } else {
                currentCol--;
            }
        }

        maze.setMazeArray(goalRow, goalCol, 0);
    }
}
