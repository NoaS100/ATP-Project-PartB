package algorithms.search;

public interface ISearchingAlgorithm {

    /***
     the method that will solve the problem using a specific searching algorithm.
     * @param problem ISearchable problem.
     * @return the Solution for the problem, null if there isn't one.
     */
    Solution solve(ISearchable problem);

    /***
     get the number of nodes evaluated during the searching algorithm
     * @return number of nodes evaluated
     */
    int getNumberOfNodesEvaluated();

    /***
     get name of the algorithm
     * @return name of algorithm
     */
    String getName();
}
