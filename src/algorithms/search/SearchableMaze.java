package algorithms.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class SearchableMaze implements ISearchable {

    protected Maze maze; // the maze -> the problem
    protected boolean[][] visitedMaze; // to keep track of where we already visited

    /***
     * constructor for SearchableMaze -> maze with implementation of ISearchable
     * @param maze the maze to build around
     */
    public SearchableMaze(Maze maze) {
        this.maze = maze;
        this.visitedMaze = new boolean[maze.getRows()][maze.getColumns()];
        initVisits();
    }

    /***
     * helper function - initializes visits maze to all false.
     */
    private void initVisits(){
        for(int i = 0; i< visitedMaze.length; i++){
            for(int j = 0; j< visitedMaze[0].length; j++){
                visitedMaze[i][j] = false;
            }
        }
    }

    /**
     * get start state of problem
     * @return AState represents the start state of problem
     */
    @Override
    public AState getStartState() {
        return new MazeState(maze.getStartPosition());
    }

    /***
     * get goal state of problem
     * @return AState represents the goal state of problem
     */
    @Override
    public AState getGoalState() {
        return new MazeState(maze.getGoalPosition());
    }

    /***
     * get all legal successors from state in problem
     * @param state state to check from
     * @return ArrayList<AState> all possible moves from state
     */
    @Override
    public ArrayList<AState> getAllSuccessors(AState state) {
        ArrayList<AState> res = new ArrayList<>(); // al the successors of state
        Position position = Position.fromString(state.state); // get position from state

        if (state.getCameFrom() == null) // the state is a start state -> we need to initialize visits array
            initVisits();

        // for on the square around the state
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                Position currPos = new Position((position.getRowIndex() + i), (position.getColumnIndex() + j));
                if (maze.checkPosition(currPos) && !visitedMaze[currPos.getRowIndex()][currPos.getColumnIndex()]) {
                    // currPosition is a valid position in maze and not a 1 and was not visited be fore.
                    if ((i * i) + (j * j) == 2) { // corner -> check if there's a diagonal
                        if (maze.checkPosition((position.getRowIndex() + i), (position.getColumnIndex())) ||
                                maze.checkPosition((position.getRowIndex()), (position.getColumnIndex() + j))) {
                            // there's a diagonal
                            visitedMaze[currPos.getRowIndex()][currPos.getColumnIndex()] = true; // mark the diagonal as visited
                            res.add(new MazeState(currPos, state, state.getCost() + 15)); // add to successors with cost of diagonal
                        }
                    } else if ((i * i) + (j * j) == 1) { // not a corner and not self (0,0)
                        visitedMaze[currPos.getRowIndex()][currPos.getColumnIndex()] = true; // mark the diagonal as visited
                        res.add(new MazeState(currPos, state, state.getCost() + 10)); // add to successors with regular cost
                    }
                }
            }
        }

        return res; // return result
    }
}
