package structures.node;

import java.util.List;
import java.util.Map;

public class Node<T> {

    private T value;
    private Node<T> left;
    private Node<T> right;

    // Listado de los nodos conocidos
    private List<Node<T>> conocidos;

    // 2da Forma
    private Map<Node<T>, List<Node<T>>> adjList;

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getLeft() {
        return left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "N [" + value + "]";
    }

}