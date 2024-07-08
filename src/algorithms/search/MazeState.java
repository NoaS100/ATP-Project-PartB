package algorithms.search;

import algorithms.mazeGenerators.Position;

public class MazeState extends AState{

    /***
     * constructor for MaeState
     * @param position Position representing the position in the maze
     * @param cameFrom AState that this state was created from
     * @param cost double the cost to get to this state
     */
    public MazeState(Position position, AState cameFrom, double cost) {
        super(position.toString(), cameFrom, cost);
    }

    /***
     * constructor for MaeState. fewer parameters -> will be used for the start position.
     * @param position Position representing the position in the maze
     */
    public MazeState(Position position) {
        super(position.toString());
    }

    /***
     * get position of this state in maze
     * @return Position of the state in maze
     */
    public Position getPosition(){
        return Position.fromString(this.state);
    }
}
