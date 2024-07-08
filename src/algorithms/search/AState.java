package algorithms.search;

import java.io.Serializable;

public abstract class AState implements Comparable<AState>, Serializable {
    protected String state; // representing the state in the game
    protected double cost; // cost to get to this state
    protected AState cameFrom; // this state was created from

    /***
     * constructor for AState. represents a current state in the game
     * @param state string representing the state in the game
     * @param cameFrom AState that this state was created from
     * @param cost double the cost to get to this state
     */
    public AState(String state, AState cameFrom, double cost){
        this.state = state;
        this.cameFrom = cameFrom;
        this.cost = cost;
    }


    /***
     * constructor for AState. fewer parameters -> will be used for the start state.
     * represents a current state in the game
     * @param state string representing the state in the game
     */
    public AState(String state){
        this(state,null,0);
    }

    /**
     * get the string that represents state in the game
     * @return string state
     */
    public String getState() {
        return state;
    }

    /***
     * set the string that represents state in the game
     * @param state string to set the state to
     */
    public void setState(String state) {
        this.state = state;
    }

    /***
     * get the cost to get to this state in the game
     * @return the cost
     */
    public double getCost() {
        return cost;
    }

    /***
     * set the cost to get to this state in the game
     * @param cost the cost to set to
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /***
     * get the AState that this state came from.
     * @return the field came from
     */
    public AState getCameFrom() {
        return cameFrom;
    }

    /***
     * set the AState that this state came from.
     * @param cameFrom the AState to set it to
     */
    public void setCameFrom(AState cameFrom) {
        this.cameFrom = cameFrom;
    }

    /***
     * checks if the state on the board is the same without consideration of cost.
     * @param other other to check against
     * @return true if the strings are equal false otherwise.
     */
    public boolean isSameState(AState other) {
        return this.state.equals(other.getState());
    }

    /****
     * compareTo on the cost of two AStates
     * @param o the object to be compared.
     * @return 0 if equal, 1 this is more than o, -1 if this is less than o.
     */
    @Override
    public int compareTo(AState o) {
        if (this.cost > o.cost)
            return 1;
        else if (this.cost < o.cost)
            return -1;
        return 0;
    }

    /***
     * to string
     * @return string representing state.
     */
    @Override
    public String toString() {
        return "AState{" +
                "state='" + state + '\'' +
                '}';
    }
}
