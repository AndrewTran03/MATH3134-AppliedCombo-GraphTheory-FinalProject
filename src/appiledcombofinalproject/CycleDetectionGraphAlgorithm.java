package appiledcombofinalproject;

import java.util.*;

// -------------------------------------------------------------------------
/**
 * A Depth-First Search (DFS) implementation for a cycle detection algorithm
 * on undirected graphs.
 * 
 * @author Andrew Tran (andrewt03)
 * @version 2022.05.03
 */
// -------------------------------------------------------------------------
public class CycleDetectionGraphAlgorithm {

    /**
     * Fields
     */
    private int numVertices;
    private LinkedList<Integer>[] adjacencyList;
    private String stringResult;
    private HashMap<Integer, String> intToStrConversionTable;

    /**
     * Instantiates a instance of CycleDetectionGraphAlgorithm
     * (1-argument).
     *
     * @param numVertices
     *            the total number of vertices in the graph
     */
    @SuppressWarnings("unchecked")
    public CycleDetectionGraphAlgorithm(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyList = new LinkedList[this.numVertices];
        for (int i = 0; i < this.adjacencyList.length; i++) {
            adjacencyList[i] = new LinkedList<Integer>();
        }
        this.stringResult = "";
    }


    /**
     * Instantiates a instance of CycleDetectionGraphAlgorithm
     * (3-arguments).
     *
     * @param numVertices
     *            the total number of vertices in the graph
     * @param strToIntConversionTable
     *            a letter to integer HashMap conversion table
     * @param intToStrConversionTable
     *            an integer to string HashMap conversion table
     */
    @SuppressWarnings("unchecked")
    public CycleDetectionGraphAlgorithm(int numVertices, HashMap<Integer, String> intToStrConversionTable) {
        this.numVertices = numVertices;
        this.intToStrConversionTable = intToStrConversionTable;
        this.adjacencyList = new LinkedList[this.numVertices];
        for (int i = 0; i < this.adjacencyList.length; i++) {
            adjacencyList[i] = new LinkedList<Integer>();
        }
        this.stringResult = "";
    }


    /**
     * Accesses and returns the expected number of vertices in the
     * graph.
     */
    public int getNumberOfGraphVertices() {
        return this.numVertices;
    }


    /**
     * Adds an edge to the graph (2-arguments).
     *
     * @param first
     *            the first vertex of an edge
     * @param second
     *            the other vertex of an edge
     */
    public void addGraphEdge(int first, int second) {
        this.stringResult += "(" + first + ", " + second + "), ";
        adjacencyList[first].add(second);
        adjacencyList[second].add(first);
    }
    
    
    /**
     * Adds an edge to the graph (3-arguments).
     *
     * @param first
     *            the first vertex of an edge
     * @param second
     *            the other vertex of an edge
     * @param vertexType
     *            the vertex type ("Number": integer, "Letter": string)
     */
    public void addGraphEdge(int first, int second, String vertexType) {
        if (vertexType.equals("Letter")) { // Letter Vertices Input
            String firstResult = "";
            String secondResult = "";
            firstResult = this.intToStrConversionTable.get(first);
            secondResult = this.intToStrConversionTable.get(second);
            this.stringResult += "(" + firstResult + ", " + secondResult
                + "), ";
        }
        else { // Numeric Digit Vertices Input
            this.stringResult += "(" + first + ", " + second + "), ";
        }
        adjacencyList[first].add(second);
        adjacencyList[second].add(first);
    }


    /**
     * Public method to access the Cycle Detection Algorithm by initializing the
     * boolean[] array to false (indicating visited nodes) and then calling the
     * helper method to begin the algorithm.
     *
     * @return true; a cycle has been detected
     *         false; a cycle has NOT been detected
     */
    public Boolean hasCycle() {
        Boolean[] visitedVertices = new Boolean[this.numVertices];
        for (int i = 0; i < this.numVertices; i++) {
            visitedVertices[i] = false;
        }

        for (int j = 0; j < this.numVertices; j++) {
            if (visitedVertices[j] == false) {
                if (hasCycleHelper(j, visitedVertices, -1) == true) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * Actual Cycle Detection Algorithm: Determines if there is a cycle in the
     * graph, simulating Depth-First Search (DFS) through employing recursive
     * checking. Note: A cycle is detected once the algorithm has reached a
     * particular node ("currentItem") in the graph which has been visited
     * but is not the parent of the current node ("current").
     *
     * @param current
     *            the current node that is being visited
     * @param visitedVertices
     *            the array indication for vertices (determining whether if they
     *            have been visited or not)
     * @param parent
     *            the previous node visited (the relative "parent" node)
     * 
     * @return true; a cycle has been detected
     *         false; a cycle has NOT been detected
     */
    private Boolean hasCycleHelper(int current,Boolean[] visitedVertices, int parent) {
        visitedVertices[current] = true;
        Iterator<Integer> iter = this.adjacencyList[current].iterator();
        while (iter.hasNext()) {
            Integer newNode = iter.next();
            if (visitedVertices[newNode] == false) {
                if (hasCycleHelper(newNode, visitedVertices, current) == true) {
                    return true;
                }
            }
            else if (newNode != parent) {
                return true;
            }
        }
        return false;
    }


    /**
     * Displays the results of running the Cycle Detection Algorithm to the
     * program user.
     *
     * @return stringResults
     *         the cycle detection results (whether a cycle has been detected)
     */
    public String displayHasCycleResults() {
        String stringResult = "";
        if (this.hasCycle() == true) {
            stringResult =
                "The graph that you entered DOES contains a cycle!";
        }
        else {
            stringResult =
                "The graph that you entered DOESN'T contain a cycle!";
        }
        return stringResult;
    }


    /**
     * Returns the string representation of the Graph, in particular, the edges
     * (along with the vertices) contained within the graph.
     *
     * @return the string representation of the Graph.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Edge Connections: ");
        sb.append(stringResult.substring(0, stringResult.length() - 2));
        return sb.toString();
    }
}
