package appiledcombofinalproject;

import java.util.Comparator;

public class GraphNodeComparator implements Comparator<GraphNode> {

    /**
     * Empty constructor (not used).
     */
    public GraphNodeComparator() {
        // Constructor left intentionally empty
    }


    @Override
    public int compare(GraphNode first, GraphNode second) {
        String firstData = String.valueOf(first.getGraphNodeData());
        String secondData = String.valueOf(second.getGraphNodeData());
        if (firstData.compareTo(secondData) < 0) {
            return -1;
        }
        else if (firstData.compareTo(secondData) > 0) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
