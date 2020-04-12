package GraphOperations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Graph{

    private int numberOfVertices;
    private LinkedList<EdgeAndVertices> listOfEdges[];
    private EdgeAndVertices edge;
    private List<EdgeAndVertices> edges;

    public LinkedList<EdgeAndVertices>[] getListOfEdges() {
        return listOfEdges;
    }

    // Constructor to initialize graph with number of vertices and list of edges
    public Graph(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;

        listOfEdges = new LinkedList[numberOfVertices];

        // Initializing the list of vertices
        for (int i = 0; i < this.numberOfVertices; i++) {
            listOfEdges[i] = new LinkedList<>();
        }
    }

    /**
     * This method is used  to add edges in graph in case of weighted undirected graph
     * 
     * @param source
     * @param destination
     * @param 
     */
    public void addEdge(int source, int destination, int weight) {
        // source is connected to destination
        edge = new EdgeAndVertices(source, destination, weight);
        listOfEdges[source].addFirst(edge);
        // destination is also connected to source
        edge = new EdgeAndVertices(destination, source, weight);
        listOfEdges[destination].addFirst(edge);
    }

    /**
     * This method is used for Helper function to print a graph
     */
    public void printGraph() {
        for (int count_i = 0; count_i < numberOfVertices; count_i++) {
            edges = listOfEdges[count_i];
            for (int count_j = 0; count_j < edges.size(); count_j++) {
                System.out.println("vertex-" + count_i + " is connected to "
                        + edges.get(count_j).getDestination() + " with weight "
                        + edges.get(count_j).getWeight());
            }
        }
    }

    /**
     * This method is used to find DFS of graph
     * 
     * @param v
     * @param state
     */
    public void dfs(int v, boolean state[]) {

        state[v] = true;
        // Recur for all the vertices adjacent to this vertex
        Iterator<EdgeAndVertices> iterator = listOfEdges[v].listIterator();
        while (iterator.hasNext()) {
            EdgeAndVertices n = iterator.next();
            if (!state[n.getDestination()])
                dfs(n.getDestination(), state);
        }

    }

    public boolean isConnected() {
        boolean result;
        boolean state[] = new boolean[this.numberOfVertices];
        dfs(0, state);
        for (int index = 0; index < numberOfVertices; index++) {

            if (state[index] == false)
                result =  false;
        }
        result =  true;
        return result;
    }

    public List<Integer> reachable(int vertex) {

        if (vertex >= numberOfVertices) {
            throw new AssertionError("Vertex not in graph");
        }
        List<Integer> listOfReachableVertex = new ArrayList<Integer>();

        boolean state[] = new boolean[this.numberOfVertices];

        dfs(vertex, state);
        for (int index = 0; index < numberOfVertices; index++) {

            if (state[index] == true)
                listOfReachableVertex.add(index);
        }

        if (listOfReachableVertex.size() == 0) {
            return null;
        }
        return listOfReachableVertex;
    }

    
    
    
    public static void main(String args[]) {

        Scanner inputObj = new Scanner(System.in);

        int vertices, edges;
        System.out.println("Enter the number of vertices in graph :");
        vertices = inputObj.nextInt();
        System.out.println("Enter the number of edges in graph :");
        edges = inputObj.nextInt();

        Graph graph = new Graph(vertices);

        int source, destination, weight;

        for (int count_i = 0; count_i < edges; count_i++) {
            System.out.println("Enter details of edge : " + count_i);
            System.out.print("source : ");
            source = inputObj.nextInt();
            System.out.print("destination : ");
            destination = inputObj.nextInt();
            System.out.print("weight : ");
            weight = inputObj.nextInt();
            graph.addEdge(source, destination, weight);
        }

        System.out.println("Graph created.. ");

        graph.printGraph();

        System.out.println("\nIs graph connected ? " + "\nAnswer : "
                + graph.isConnected());

        System.out
                .println("\nchecking reachable vertices from given vertex ..");

        System.out.println("enter vertex : ");
        source = inputObj.nextInt();
        List<Integer> listOfReachable = graph.reachable(source);
        System.out.println("reachable vertices are : "
                + listOfReachable.toString());

    }
}