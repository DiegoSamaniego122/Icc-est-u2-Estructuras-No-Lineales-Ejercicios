package structures.graphs;

import java.util.*;

import structures.node.Node;

public class Graph<T> {

    private Map<Node<T>, List<Node<T>>> mapa;

    public Graph() {
        this.mapa = new HashMap<>();
    }

    public void addNode(Node<T> node) {
        mapa.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(Node<T> n1, Node<T> n2) {
        addNode(n1);
        addNode(n2);

        mapa.get(n1).add(n2);
        mapa.get(n2).add(n1);
    }

    public List<Node<T>> getNeighbors(Node<T> node) {
        return mapa.getOrDefault(node, new ArrayList<>());
    }

    public void printGraph() {
        for (Node<T> node : mapa.keySet()) {
            System.out.print(node + " -> ");
            for (Node<T> neighbor : mapa.get(node)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}
