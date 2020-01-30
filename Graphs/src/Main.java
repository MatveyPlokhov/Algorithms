import java.util.LinkedList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(10);

        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 6);
        graph.addEdge(4, 5);
        graph.addEdge(5, 8);
        graph.addEdge(6, 5);
        graph.addEdge(6, 7);
        graph.addEdge(7, 8);

        BreadthFirstPath bfp = new BreadthFirstPath(graph, 0);
        LinkedList<Integer> path = bfp.shortPath(graph, 1, 8);
        System.out.println("короткий путь = " + path);
    }
}
