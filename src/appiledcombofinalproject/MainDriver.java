package appiledcombofinalproject;

public class MainDriver {

    public MainDriver() {
        // Constructor left intentionally empty
    }

    //Source: https://www.geeksforgeeks.org/detect-cycle-undirected-graph/
    public static void main(String[] args) {
        System.out.println("First Edit");
        GraphAlgorithms graph1 = new GraphAlgorithms(3);
        graph1.addGraphEdge("0", "1");
        graph1.addGraphEdge("1", "2");
        graph1.addGraphEdge("2", "0");
        System.out.println(graph1.toString());
        System.out.println(graph1.displayHasCycleResults());
    }
}
