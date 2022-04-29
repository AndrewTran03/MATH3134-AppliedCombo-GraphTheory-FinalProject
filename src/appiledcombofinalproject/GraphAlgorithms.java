package appiledcombofinalproject;

import java.util.LinkedList;

public class GraphAlgorithms {

    /**
     * Fields
     */
    private int numVertices;
    private LinkedList<Integer>[] adjacencyList;
    private String result;
    // private String graphAlgoType;

    @SuppressWarnings("unchecked")
    public GraphAlgorithms(int numGraphVertices) {
        // this.graphAlgoType = graphAlgoType;
        this.numVertices = numGraphVertices;
        this.adjacencyList = new LinkedList[numGraphVertices];
        for (int i = 0; i < this.numVertices; i++) {
            adjacencyList[i] = new LinkedList();
        }
        this.result = "";
    }


    @SuppressWarnings("unchecked")
    public void addGraphEdge(int first, int second) {
        this.result += "(" + first + ", " + second + "), ";
        adjacencyList[first].add(second);
        adjacencyList[second].add(first);
    }


    public void performCycleDetection() {

    }


    public void performBFS() {

    }


    public void performDFS() {

    }


    public void performDijsktra() {

    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Edge Connections: ");
        sb.append(result.substring(0, result.length() - 2));
        return sb.toString();
    }
}
