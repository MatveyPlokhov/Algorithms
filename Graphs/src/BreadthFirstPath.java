import java.util.LinkedList;

public class BreadthFirstPath {
    private boolean[] marked;
    private int[] edgeTo;
    private int source;

    public BreadthFirstPath(Graph g, int source) {
        this.source = source;
        marked = new boolean[g.getVertexCount()];
        edgeTo = new int[g.getVertexCount()];
        bfs(g, source);
    }

    private void bfs(Graph g, int source) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(source);
        marked[source] = true;

        while (!queue.isEmpty()) {
            int vertex = queue.removeFirst();
            for (int w : g.getAdjList(vertex)) {
                if (!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = vertex;
                    queue.addLast(w);
                }
            }
        }
    }

    LinkedList<Integer> shortPath(Graph graph, int from, int to) {
        LinkedList<Integer> deque = new LinkedList<>();
        int[] array = new int[graph.getVertexCount()];
        boolean[] marked = new boolean[graph.getVertexCount()];
        deque.addLast(from);
        marked[from] = true;
        while (!deque.isEmpty()) {
            int vertex = deque.removeFirst();
            for (int i : graph.getAdjList(vertex)) {
                if (!marked[i]) {
                    marked[i] = true;
                    array[i] = vertex;
                    if (i == to) {
                        LinkedList<Integer> stack = new LinkedList<>();
                        while (vertex != from) {
                            stack.push(vertex);
                            vertex = array[vertex];
                        }
                        stack.addFirst(from);
                        stack.addLast(to);
                        return stack;
                    }
                    deque.addLast(i);
                }
            }
        }
        return new LinkedList<>();
    }

    public boolean hasPathTo(int dist) {
        return marked[dist];
    }

    public LinkedList<Integer> pathTo(int dist) {
        if (!hasPathTo(dist)) {
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int vertex = dist;
        while (vertex != source) {
            stack.push(vertex);
            vertex = edgeTo[vertex];
        }
        return stack;
    }
}
