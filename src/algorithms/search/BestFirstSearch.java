package algorithms.search;

import jdk.jshell.execution.Util;

import java.util.*;

public class BestFirstSearch extends BreadthFirstSearch{
    /***
     * constructor for Best search -> will act the exact same as BFS, just uses a PriorityQueue instead a regular queue
     */
    public BestFirstSearch() {
        this.stateQueue = new PriorityQueue<>();

    }

}
