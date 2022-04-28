package appiledcombofinalproject;

import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class GraphNodeUndirected {

    /**
     * Fields
     */
    private String data;
    private GraphNodeUndirected[] relativeRoots;
    private GraphNodeUndirected[] relativeNextConnections;

    public GraphNodeUndirected(
        String data,
        GraphNodeUndirected[] relRoots,
        GraphNodeUndirected[] nextConnections) {
        this.data = data;
        this.relativeRoots = relRoots;
        this.relativeNextConnections = nextConnections;
    }


    public String getGraphNodeData() {
        return this.data;
    }


    public GraphNodeUndirected[] getGraphNodeRelativeRoots() {
        return this.relativeRoots;
    }


    public GraphNodeUndirected[] getGraphNodeRelativeNextConnections() {
        return this.relativeNextConnections;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        return sb.toString();
    }
}
