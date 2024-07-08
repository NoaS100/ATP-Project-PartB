package algorithms.search;

public abstract class ASearchingAlgorithm implements ISearchingAlgorithm{

    protected int numberOfNodesEvaluated; // number of nodes evaluated during the searching algorithm

    /***
     constructor for abstract searching algorithm
     */
    public ASearchingAlgorithm(){
        numberOfNodesEvaluated = 0;
    }

    /***
     the method that will solve the problem using a specific searching algorithm.
     * @param problem ISearchable problem.
     * @return the Solution for the problem, null if there isn't one.
     */
    @Override
    public Solution solve(ISearchable problem) {
        return null;
    }

    /***
     get the number of nodes evaluated during the searching algorithm
     * @return number of nodes evaluated
     */
    @Override
    public int getNumberOfNodesEvaluated() {
        return this.numberOfNodesEvaluated;
    }

    /***
     get name of the algorithm
     * @return the name of algorithm
     */
    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
