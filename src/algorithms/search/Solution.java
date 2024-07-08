package algorithms.search;

import java.io.Serializable;
import java.util.ArrayList;

public class Solution implements Serializable {

    protected AState finalState; // the goalState of the problem with the option to retrace the solution

    /***
     * constructor for Solution
     * @param finalState the goalState of the problem with the option to retrace the solution
     */
    public Solution(AState finalState) {
        this.finalState = finalState;
    }

    /***
     * retrace the solution
     * @return ArrayList<AState> of the solution path
     */
    public ArrayList<AState> getSolutionPath(){
        ArrayList<AState> res = new ArrayList<>();
        AState currState = finalState;
        while (currState != null){
            res.add(0,currState);
            currState = currState.getCameFrom();
        }
        return res;
    }

    /***
     * get finalState
     * @return AState finalState
     */
    public AState getFinalState() {
        return finalState;
    }
}
