package appiledcombofinalproject;

import java.util.LinkedList;
import java.util.Iterator;

public class GraphAlgorithms {

    /**
     * Fields
     */
    private int numVertices;
    private LinkedList<Integer>[] adjacencyList;
    private String result;
    private GraphAlgorithmsGUI visualizationWindow;

    @SuppressWarnings("unchecked")
    public GraphAlgorithms(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyList = new LinkedList[this.numVertices];
        for (int i = 0; i < this.adjacencyList.length; i++) {
            adjacencyList[i] = new LinkedList<Integer>();
        }
        this.result = "";
    }


    @SuppressWarnings("unchecked")
    public void addGraphEdge(int first, int second) {
        this.result += "(" + first + ", " + second + "), ";
        adjacencyList[first].add(second);
        adjacencyList[second].add(first);
    }


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


    public Boolean hasCycleHelper(int current, Boolean[] visitedVertices, int parent) {
        visitedVertices[current] = true;
        Iterator<Integer> iter = this.adjacencyList[current].iterator();
        while (iter.hasNext()) {
            Integer currentItem = iter.next();
            if (visitedVertices[currentItem] == false) {
                if (hasCycleHelper(currentItem, visitedVertices, current) == true) {
                    return true;
                }
            }
            else if (currentItem != parent) {
                return true;
            }
        }
        return false;
    }


    public String displayHasCycleResults() {
        String result = "";
        if (this.hasCycle()) {
            result = "Graph Contains a Cycle";
        }
        else {
            result = "Graph Doesn't Contain a Cycle";
        }
        return result;
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Edge Connections: ");
        sb.append(result.substring(0, result.length() - 2));
        return sb.toString();
    }
}
