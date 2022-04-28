package appiledcombofinalproject;

import java.util.Comparator;

public class GraphNodeComparator implements Comparator<GraphNodeUndirected> {

    /**
     * Empty constructor (not used).
     */
    public GraphNodeComparator() {
        // Constructor left intentionally empty
    }


    @Override
    public int compare(GraphNodeUndirected first, GraphNodeUndirected second) {
        if (first.getGraphNodeData().compareTo(second.getGraphNodeData()) < 0) {
            return -1;
        }
        else if (first.getGraphNodeData().compareTo(second  
            .getGraphNodeData()) > 0) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
