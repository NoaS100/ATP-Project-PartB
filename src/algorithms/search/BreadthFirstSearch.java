package algorithms.search;

import java.util.*;

public class BreadthFirstSearch extends ASearchingAlgorithm{
    protected Queue<AState> stateQueue; // the data structure to use during the algorithm

    /***
     * constructor for BFS, will go to super() and initialize this queue
     */
    public BreadthFirstSearch() {
        this.stateQueue = new LinkedList<>();
    }

    /**
     * will solve ISearchable problem with the BFS algorithm.
     * @param problem ISearchable problem.
     * @return Solution of AStates to the problem.
     */
    @Override
    public Solution solve(ISearchable problem) {
        stateQueue.clear(); // empty queue
        this.numberOfNodesEvaluated = 0;

        ArrayList<AState> allSuccessors = problem.getAllSuccessors(problem.getStartState());// all successors for start state in problem
        stateQueue.addAll(allSuccessors); // adding successors for queue
        this.numberOfNodesEvaluated += allSuccessors.size();
        while(!stateQueue.isEmpty()){
            AState state = stateQueue.poll(); // get next state to handle

            if(state.isSameState(problem.getGoalState()))
                return new Solution(state); // got to goal state -> returns Solution with the curren state as the final one.

            for (AState CurrState: problem.getAllSuccessors(state)) { // state is not goal -> get all successors for state
                numberOfNodesEvaluated++;
                stateQueue.add(CurrState);  // add them to queue for check
            }
        }
        return null; // there is no solution -> return null
    }


}
