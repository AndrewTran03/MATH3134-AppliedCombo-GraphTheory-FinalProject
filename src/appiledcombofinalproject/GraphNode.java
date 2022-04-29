package appiledcombofinalproject;

public class GraphNode {

    /**
     * Fields
     */
    private String data;

    public GraphNode(String data) {
        this.data = data;
    }


    public String getGraphNodeData() {
        return this.data;
    }


    public boolean isValidGraphNode() {
        return (this.data != null);
    }


    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }

        if (this.getClass() == obj.getClass()) {
            GraphNode other = (GraphNode)obj;
            return this.getGraphNodeData().equals(other.getGraphNodeData());
        }
        else {
            return false;
        }

    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.isValidGraphNode()) {
            sb.append(this.data);
        }
        else {
            sb.append("NOT A VALID NODE");
        }
        return sb.toString();
    }
}
