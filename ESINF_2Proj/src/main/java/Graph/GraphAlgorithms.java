/*
 * A collection of graph algorithms.
 */
package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author DEI-ESINF & Tiago Pinto
 *
 */
public class GraphAlgorithms {

    /**
     * Performs breadth-first search of a Graph starting in a Vertex
     *
     * @param <V>
     * @param <E>
     * @param g    Graph instance vInf information of the Vertex that will be the
     *             source of the search
     * @param vert
     * @return qbfs a queue with the vertices of breadth-first search
     */
    public static <V, E> LinkedList<V> BreadthFirstSearch(Graph<V, E> g, V vert) {
        if (!g.validVertex(vert)) {
            return null;
        }

        LinkedList<V> resultQueue = new LinkedList<>();

        boolean[] knownVertices = new boolean[g.numVertices()];
        Arrays.fill(knownVertices, Boolean.FALSE);

        LinkedList<V> auxQueue = new LinkedList<>();

        resultQueue.add(vert);
        auxQueue.add(vert);

        knownVertices[g.getKey(vert)] = true;

        while (!auxQueue.isEmpty()) {
            V currentVert = auxQueue.remove();

            Iterable<Edge<V, E>> edges = g.outgoingEdges(currentVert);

            for (Edge<V, E> edge : edges) {

                V destVert = edge.getVDest();

                if (!knownVertices[g.getKey(destVert)]) {
                    knownVertices[g.getKey(destVert)] = true;
                    resultQueue.add(destVert);
                    auxQueue.add(destVert);
                }
            }
        }

        return resultQueue;
    }

    /**
     * Performs depth-first search starting in a Vertex
     *
     * @param g       Graph instance
     * @param vOrig   Vertex of graph g that will be the source of the search
     * @param visited set of discovered vertices
     * @param qdfs    queue with vertices of depth-first search
     */
    private static <V, E> void DepthFirstSearch(Graph<V, E> g, V vOrig, boolean[] visited, LinkedList<V> qdfs) {
        visited[g.getKey(vOrig)] = true;
        qdfs.add(vOrig);

        Iterable<Edge<V, E>> edges = g.outgoingEdges(vOrig);

        for (Edge<V, E> edge : edges) {

            V destVert = edge.getVDest();

            if (!visited[g.getKey(destVert)]) {
                DepthFirstSearch(g, destVert, visited, qdfs);
            }
        }

    }

    /**
     * @param <V>
     * @param <E>
     * @param g    Graph instance vInf information of the Vertex that will be the
     *             source of the search
     * @param vert
     * @return qdfs a queue with the vertices of depth-first search
     */
    public static <V, E> LinkedList<V> DepthFirstSearch(Graph<V, E> g, V vert) {

        if (!g.validVertex(vert)) {
            return null;
        }
        boolean[] visited = new boolean[g.numVertices()];
        Arrays.fill(visited, Boolean.FALSE);

        LinkedList<V> qdfs = new LinkedList<>();

        DepthFirstSearch(g, vert, visited, qdfs);
        return qdfs;
    }

    /**
     * Returns all paths from vOrig to vDest
     *
     * @param g       Graph instance
     * @param vOrig   Vertex that will be the source of the path
     * @param vDest   Vertex that will be the end of the path
     * @param visited set of discovered vertices
     * @param path    stack with vertices of the current path (the path is in
     *                reverse order)
     * @param paths   ArrayList with all the paths (in correct order)
     */
    private static <V, E> void allPaths(Graph<V, E> g, V vOrig, V vDest, boolean[] visited,
                                        LinkedList<V> path, ArrayList<LinkedList<V>> paths) {
        path.push(vOrig);
        int vKey = g.getKey(vOrig);
        visited[vKey] = true;

        for (V vAdj : g.adjVertices(vOrig)) {

            if (vAdj.equals(vDest)) {
                path.push(vAdj);
                LinkedList<V> revpath = revPath(path);
                paths.add(new LinkedList(revpath));
                path.pop();

            } else {
                vKey = g.getKey(vAdj);
                if (!visited[vKey]) {
                    allPaths(g, vAdj, vDest, visited, path, paths);

                }
            }
        }
        V vElem = path.pop();
        vKey = g.getKey(vElem);
        visited[vKey] = false;
    }

    /**
     * @param <V>
     * @param <E>
     * @param g     Graph instance
     * @param vOrig
     * @param vDest
     * @return paths ArrayList with all paths from voInf to vdInf
     */
    public static <V, E> ArrayList<LinkedList<V>> allPaths(Graph<V, E> g, V vOrig, V vDest) {
        LinkedList<V> path = new LinkedList<>();
        ArrayList<LinkedList<V>> paths = new ArrayList<>();
        boolean[] visited = new boolean[g.numVertices()];

        if (g.validVertex(vOrig) && g.validVertex(vDest)) {
            allPaths(g, vOrig, vDest, visited, path, paths);

        }

        return paths;
    }

    /**
     * Computes shortest-path distance from a source vertex to all reachable
     * <p>
     * vertices of a graph g with nonnegative edge weights
     * <p>
     * This implementation uses Dijkstra's algorithm
     *
     * @param g        Graph instance
     * @param vOrig    Vertex that will be the source of the path
     * @param visited  set of discovered vertices
     * @param pathKeys minimum path vertices keys      *
     * @param dist     minimum distances
     */
     protected static <V, E> void shortestPathLength(Graph<V, E> g, V vOrig,
                                                    boolean[] visited, int[] pathKeys, double[] dist) {

        dist[g.getKey(vOrig)] = 0;
        while (vOrig != null) {
            visited[g.getKey(vOrig)] = true;
            for (V vAdj : g.adjVertices(vOrig)) {
                Edge e = g.getEdge(vOrig, vAdj);
                if (!visited[g.getKey(vAdj)] && dist[g.getKey(vAdj)] > (dist[g.getKey(vOrig)] + e.getWeight())) {
                    dist[g.getKey(vAdj)] = dist[g.getKey(vOrig)] + e.getWeight();
                    pathKeys[g.getKey(vAdj)] = g.getKey(vOrig);
                }
            }
            vOrig = null;
            Double minDistance = Double.MAX_VALUE;
            for (V vert : g.allkeyVerts()) {
                if (!visited[g.getKey(vert)] && dist[g.getKey(vert)] < minDistance) {
                    vOrig = vert;
                    minDistance = dist[g.getKey(vert)];
                }
            }
        }

    }

    /**
     * Extracts from pathKeys the minimum path between voInf and vdInf
     * <p>
     * The path is constructed from the end to the beginning
     *
     * @param g        Graph instance
     * @param vOrig    information of the Vertex origin
     * @param vDest    information of the Vertex destination
     * @param pathKeys minimum path vertices keys      *
     * @param path     stack with the minimum path (correct order)
     */
    private static <V, E> void getPath(Graph<V, E> g, V vOrig, V vDest, V[] verts, int[] pathKeys, LinkedList<V> path) {

        if (!vOrig.equals(vDest)) {

            path.push(vDest);

            int vKey = g.getKey(vDest);

            int prevVKey = pathKeys[vKey];

            vDest = verts[prevVKey];

            getPath(g, vOrig, vDest, verts, pathKeys, path);

        } else {
            path.push(vOrig);
        }

    }

    //shortest-path between voInf and vdInf
    public static <V, E> double shortestPath(Graph<V, E> g, V vOrig, V vDest, LinkedList<V> shortPath) {
        
        if (!g.validVertex(vOrig) || !g.validVertex(vDest))
            return 0;
        shortPath.clear();
        int nverts = g.numVertices();
        boolean[] visited = new boolean[nverts]; //default value: false
        int[] pathKeys = new int[nverts];
        double[] dist = new double[nverts];
        V[] vertices = g.allkeyVerts();

        for (int i = 0; i < nverts; i++) {
            dist[i] = Double.MAX_VALUE;
            pathKeys[i] = -1;
        }

        shortestPathLength(g, vOrig, visited, pathKeys, dist);
        if (dist[g.getKey(vDest)] != Double.MAX_VALUE) {
            getPath(g, vOrig, vDest, vertices, pathKeys, shortPath);
        }
        return shortPath.isEmpty() ? 0 : dist[g.getKey(vDest)];

    }


    /**
     * Reverses the path
     *
     * @param path stack with path
     */
    private static <V, E> LinkedList<V> revPath(LinkedList<V> path) {

        LinkedList<V> pathcopy = new LinkedList<>(path);

        LinkedList<V> pathrev = new LinkedList<>();

        while (!pathcopy.isEmpty()) {
            pathrev.push(pathcopy.pop());
        }

        return pathrev;

    }


}
