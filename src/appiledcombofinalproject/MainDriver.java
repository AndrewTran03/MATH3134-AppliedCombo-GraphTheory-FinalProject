package appiledcombofinalproject;

public class MainDriver {

    public MainDriver() {
        // Constructor left intentionally empty
    }


    public static void main(String[] args) {
        System.out.println("First Edit");
        /*
         * GraphNode<Integer> first = new GraphNode<Integer>(0);
         * GraphNode<Integer> second = new GraphNode<Integer>(1);
         * GraphNode<Integer> third = new GraphNode<Integer>(2);
         */
        GraphAlgorithms graph1 = new GraphAlgorithms(3);
        graph1.addGraphEdge(0, 1);
        graph1.addGraphEdge(1, 2);
        graph1.addGraphEdge(2, 0);
        System.out.println(graph1.toString());
        System.out.println(graph1.displayHasCycleResults());
    }
}
