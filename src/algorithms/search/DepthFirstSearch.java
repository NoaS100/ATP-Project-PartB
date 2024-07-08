package algorithms.search;

import java.util.*;

public class DepthFirstSearch extends ASearchingAlgorithm{

    /***
     * constructor for DFS, will go to super()
     */
    public DepthFirstSearch() {
        super();
    }

    /**
     * will solve ISearchable problem with the DFS algorithm.
     * @param problem ISearchable problem.
     * @return Solution of AStates to the problem.
     */
    @Override
    public Solution solve(ISearchable problem) {
        Stack<AState> stateStack = new Stack<>(); // new stack for AStates to evaluate
        this.numberOfNodesEvaluated = 0;

        stateStack.push(problem.getStartState()); // add the start state
        numberOfNodesEvaluated++;

        while(!stateStack.isEmpty()){

            AState currState = stateStack.pop(); // get the state to evaluate
            if (currState.isSameState(problem.getGoalState()))
                return new Solution(currState); // got to goal state -> returns Solution with the curren state as the final one.

            for (AState state: problem.getAllSuccessors(currState)) { // state is not goal -> get all successors for state
                numberOfNodesEvaluated++;
                stateStack.push(state); // add them to stack for check
            }

        }
        return null; // there is no solution -> return null
    }

}
