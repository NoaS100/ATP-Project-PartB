package algorithms.search;

import java.util.ArrayList;

public interface ISearchable {
    /**
     * get start state of problem
     * @return AState represents the start state of problem
     */
    AState getStartState();

    /***
     * get goal state of problem
     * @return AState represents the goal state of problem
     */
    AState getGoalState();

    /***
     * get all legal successors from state in problem
     * @param state state to check from
     * @return ArrayList<AState> all possible moves from state
     */
    ArrayList<AState> getAllSuccessors(AState state);
}
