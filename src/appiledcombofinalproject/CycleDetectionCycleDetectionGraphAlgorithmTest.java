package appiledcombofinalproject;

import junit.framework.*;

// -------------------------------------------------------------------------
/**
 * Testing class for CycleDetectionCycleDetectionGraphAlgorithm.
 *
 * @author Andrew Tran (andrewt03)
 * @version 2022.05.03
 */
// -------------------------------------------------------------------------
public class CycleDetectionCycleDetectionGraphAlgorithmTest extends TestCase {

    /**
     * Fields
     */
    private int numVertices;
    private CycleDetectionGraphAlgorithm graph1;
    private CycleDetectionGraphAlgorithm graph2;
    private CycleDetectionGraphAlgorithm graph3;
    private CycleDetectionGraphAlgorithm graph4;
    private CycleDetectionGraphAlgorithm graph5;
    private CycleDetectionGraphAlgorithm graph6;

    /**
     * Sets up the test cases by creating new objects of
     * CycleDetectionCycleDetectionGraphAlgorithm.
     */
    public void setUp() {
        this.numVertices = 3;

        this.graph1 = new CycleDetectionGraphAlgorithm(this.numVertices);
        graph1.addGraphEdge(0, 1);
        graph1.addGraphEdge(1, 2);
        graph1.addGraphEdge(2, 0);

        this.graph2 = new CycleDetectionGraphAlgorithm(4);
        graph2.addGraphEdge(0, 1);
        graph2.addGraphEdge(1, 2);
        graph2.addGraphEdge(1, 3);

        this.graph3 = new CycleDetectionGraphAlgorithm(2);
        graph3.addGraphEdge(0, 1);
        graph3.addGraphEdge(1, 0);

        this.graph4 = new CycleDetectionGraphAlgorithm(11);
        graph4.addGraphEdge(0, 1);
        graph4.addGraphEdge(2, 0);
        graph4.addGraphEdge(9, 10);
        graph4.addGraphEdge(10, 0);
        graph4.addGraphEdge(0, 9);

        this.graph5 = new CycleDetectionGraphAlgorithm(22);
        graph5.addGraphEdge(0, 1);
        graph5.addGraphEdge(1, 2);

        this.graph6 = new CycleDetectionGraphAlgorithm(47);
        graph6.addGraphEdge(0, 1);
    }


    /**
     * Tests getNumberOfVertices().
     */
    public void testGetNumberOfVertices() {
        assertEquals(this.graph1.getNumberOfGraphVertices(), 3);
        assertEquals(this.graph1.getNumberOfGraphVertices(), this.numVertices);
        assertEquals(this.graph2.getNumberOfGraphVertices(), 4);
        assertEquals(this.graph3.getNumberOfGraphVertices(), 2);
        assertEquals(this.graph4.getNumberOfGraphVertices(), 11);
        assertEquals(this.graph5.getNumberOfGraphVertices(), 22);
        assertEquals(this.graph6.getNumberOfGraphVertices(), 47);
    }


    /**
     * Tests hasCycle().
     */
    public void testHasCycle() {
        assertTrue(this.graph1.hasCycle());
        assertEquals(this.graph1.hasCycle(), Boolean.TRUE);
        assertFalse(this.graph2.hasCycle());
        assertEquals(this.graph2.hasCycle(), Boolean.FALSE);
        assertTrue(this.graph3.hasCycle());
        assertEquals(this.graph3.hasCycle(), Boolean.TRUE);
        assertTrue(this.graph4.hasCycle());
        assertEquals(this.graph4.hasCycle(), Boolean.TRUE);
        assertFalse(this.graph5.hasCycle());
        assertEquals(this.graph5.hasCycle(), Boolean.FALSE);
        assertFalse(this.graph6.hasCycle());
        assertEquals(this.graph6.hasCycle(), Boolean.FALSE);
    }


    /**
     * Tests displayHasCycleResults().
     */
    public void testDisplayHasCycleResults() {
        assertEquals(this.graph1.displayHasCycleResults(),
            "The graph that you entered DOES contains a cycle!");
        assertEquals(this.graph2.displayHasCycleResults(),
            "The graph that you entered DOESN'T contain a cycle!");
        assertEquals(this.graph3.displayHasCycleResults(),
            "The graph that you entered DOES contains a cycle!");
        assertEquals(this.graph4.displayHasCycleResults(),
            "The graph that you entered DOES contains a cycle!");
        assertEquals(this.graph5.displayHasCycleResults(),
            "The graph that you entered DOESN'T contain a cycle!");
        assertEquals(this.graph6.displayHasCycleResults(),
            "The graph that you entered DOESN'T contain a cycle!");
    }


    /**
     * Tests toString().
     */
    public void testToString() {
        assertEquals(this.graph1.toString(),
            "Edge Connections: (0, 1), (1, 2), (2, 0)");
        assertEquals(this.graph2.toString(),
            "Edge Connections: (0, 1), (1, 2), (1, 3)");
        assertEquals(this.graph3.toString(),
            "Edge Connections: (0, 1), (1, 0)");
        assertEquals(this.graph4.toString(),
            "Edge Connections: (0, 1), (2, 0), (9, 10), (10, 0), (0, 9)");
        assertEquals(this.graph5.toString(),
            "Edge Connections: (0, 1), (1, 2)");
        assertEquals(this.graph6.toString(), "Edge Connections: (0, 1)");
    }
}
