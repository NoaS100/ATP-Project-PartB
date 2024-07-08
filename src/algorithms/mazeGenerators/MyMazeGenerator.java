package algorithms.mazeGenerators;

import java.util.*;

public class MyMazeGenerator extends AMazeGenerator {

    private static final int WALL = 1;
    private static final int EMPTY = 0;
    private Random random;

    /***
     * Prim's algorithm for maze generation
     * @param rows
     * @param columns
     * @return random maze
     */
    @Override
    public Maze generate(int rows, int columns) {
        if(rows < 1 || columns < 1)
            return null;
        Maze maze = new Maze(rows, columns);
        maze.makeStartPosition();
        this.random = new Random();
        // Initialize maze with walls
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                maze.setMazeArray(i, j, WALL);
            }
        }

        // Generate maze
        generateMaze(maze.getStartPosition().getRowIndex(), maze.getStartPosition().getColumnIndex(), maze);

        maze.makeGoalPosition();
        return maze;
    }

    /***
     * auxiliary function to generate paving the way
     * @param startRow
     * @param startCol
     * @param maze
     */
    private void generateMaze(int startRow, int startCol, Maze maze) {
        Position curr;
        int count; //counting the visited neighbors for current cell

        //frontiers list , candidates to be selected as the next cell in the maze.
        List<Position> frontier= new ArrayList<>();
        frontier.add(new Position(startRow, startCol));

        while (!frontier.isEmpty()) {
            curr=frontier.remove(random.nextInt(frontier.size()));
            count=neighborsVisited(maze,curr);

            if(count<=1){
                maze.setMazeArray(curr.getRowIndex(), curr.getColumnIndex(), EMPTY);
                //down
                addValidPath(curr.getRowIndex()+1, curr.getColumnIndex(), maze,frontier);
                //up
                addValidPath(curr.getRowIndex()-1, curr.getColumnIndex(), maze,frontier);
                //left
                addValidPath(curr.getRowIndex(), curr.getColumnIndex()-1, maze,frontier);
                //right
                addValidPath(curr.getRowIndex(), curr.getColumnIndex()+1, maze,frontier);
            }
        }

    }

    /***
     *
     * @param maze
     * @param curr
     * @return the count of visited neighbors for a cell
     */
    private int neighborsVisited(Maze maze, Position curr){
        int Ncount=0;
        //down
        if(curr.getRowIndex()+1< maze.getRows() && maze.getMazeArray()[curr.getRowIndex()+1][curr.getColumnIndex()]==0)
            Ncount++;
        //up
        if(curr.getRowIndex()-1>=0 && maze.getMazeArray()[curr.getRowIndex()-1][curr.getColumnIndex()]==0)
            Ncount++;
        //right
        if(curr.getColumnIndex()+1<maze.getColumns() && maze.getMazeArray()[curr.getRowIndex()][curr.getColumnIndex()+1]==0)
            Ncount++;
        //left
        if(curr.getColumnIndex()-1>=0 && maze.getMazeArray()[curr.getRowIndex()][curr.getColumnIndex()-1]==0)
            Ncount++;
        return Ncount;}

    /***
     * checking if we can pave a path by checking boundaries and if there is a wall- then we can break the wall
     * @param x
     * @param y
     * @param maze
     * @param frontiers
     */
    private void addValidPath(int x, int y, Maze maze, List<Position> frontiers) {
        if (x >= 0 && x < maze.getRows() && y >= 0 && y < maze.getColumns() && maze.getMazeArray()[x][y] == WALL){
            frontiers.add(new Position(x, y));
        }
    }
}

