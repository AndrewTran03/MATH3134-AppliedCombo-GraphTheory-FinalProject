package appiledcombofinalproject;

public class MainDriver {

    public MainDriver() {
        // Constructor left intentionally empty
    }

    //Source: https://www.geeksforgeeks.org/detect-cycle-undirected-graph/
    public static void main(String[] args) {
        GraphAlgorithms graph1 = new GraphAlgorithms(3);
        graph1.addGraphEdge(0, 1);
        graph1.addGraphEdge(1, 2);
        graph1.addGraphEdge(2, 0);
        System.out.println(graph1.toString());
        System.out.println(graph1.displayHasCycleResults());
        
        GraphAlgorithms graph2 = new GraphAlgorithms(4);
        graph2.addGraphEdge(0, 1);
        graph2.addGraphEdge(1, 2);
        graph2.addGraphEdge(1, 3);
        System.out.println(graph2.toString());
        System.out.println(graph2.displayHasCycleResults());
        
        GraphAlgorithms graph3 = new GraphAlgorithms(2);
        graph3.addGraphEdge(0, 1);
        graph3.addGraphEdge(1, 0);
        System.out.println(graph3.toString());
        System.out.println(graph3.displayHasCycleResults());
        
        GraphAlgorithms graph4 = new GraphAlgorithms(11);
        graph4.addGraphEdge(0, 1);
        graph4.addGraphEdge(2, 0);
        graph4.addGraphEdge(9, 10);
        graph4.addGraphEdge(10, 0);
        graph4.addGraphEdge(0, 9);
        System.out.println(graph4.toString());
        System.out.println(graph4.displayHasCycleResults());
    }
}
