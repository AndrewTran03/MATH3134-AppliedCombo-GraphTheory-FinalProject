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
        GraphAlgorithms graphAlgo = new GraphAlgorithms(3);
        graphAlgo.addGraphEdge(0, 1);
        graphAlgo.addGraphEdge(1, 2);
        graphAlgo.addGraphEdge(2, 0);
        System.out.println(graphAlgo.toString());
    }
}
