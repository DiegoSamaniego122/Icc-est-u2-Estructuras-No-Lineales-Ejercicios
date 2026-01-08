
import java.util.List;

import models.Person;
import structures.graphs.Graph;
import structures.node.Node;
import structures.trees.IntTree;
import structures.trees.Tree;

public class App {

    public static void main(String[] args) {
        showPersonTree();
        showIntTree(); // ← añadido aquí
        runGraph();
    }

    private static void showPersonTree() {

        Tree<Person> tree = new Tree<>();

        tree.insert(new Person("Pablo", 21));
        tree.insert(new Person("Maria", 23));
        tree.insert(new Person("Ana", 25));
        tree.insert(new Person("Pedro", 23));
        tree.insert(new Person("Luis", 19));

        System.out.println("Persons in order:");
        tree.inOrder();

        Person findPerson = tree.searchByAge(23);
        if (findPerson != null) {
            System.out.println("Found: " + findPerson);
        } else {
            System.out.println("Person not found");
        }
    }

    private static void showIntTree() {

        IntTree tree = new IntTree();

        tree.insert(10);
        tree.insert(5);
        tree.insert(3);
        tree.insert(15);

        System.out.println("\nInteger Tree Traversals");

        System.out.println("Pre Order:");
        tree.preOrder();

        System.out.println("Post Order:");
        tree.posOrder();

        System.out.println("In Order:");
        tree.inOrder();

        System.out.println("Size: " + tree.size());
    }

    private static void runGraph() {

        Graph<String> graph = new Graph<>();

        Node<String> nA = new Node<>("A");
        Node<String> nB = new Node<>("B");
        Node<String> nC = new Node<>("C");
        Node<String> nD = new Node<>("D");

        graph.addEdge(nA, nB);
        graph.addEdge(nA, nC);
        graph.addEdge(nB, nD);

        graph.printGraph();

        System.out.println("Neighbors de A:");

        List<Node<String>> neighbors = graph.getNeighbors(nA);
        for (Node<String> n : neighbors) {
            System.out.println(n + " ");
        }
    }
}
