package structures.trees;

import models.Person;
import structures.node.Node;

public class Tree<T extends Comparable<T>> {

    protected Node<T> root;

    public void insert(T data) {
        root = place(root, data);
    }

    private Node<T> place(Node<T> node, T data) {
        if (node == null) {
            return new Node<>(data);
        }

        int cmp = data.compareTo(node.getValue());

        if (cmp <= 0) {
            node.setLeft(place(node.getLeft(), data));
        } else {
            node.setRight(place(node.getRight(), data));
        }

        return node;
    }

    public void inOrder() {
        print(root);
    }

    private void print(Node<T> node) {
        if (node == null) return;

        print(node.getLeft());
        System.out.println(node.getValue());
        print(node.getRight());
    }

    public T search(T target) {
        Node<T> current = root;

        while (current != null) {
            int cmp = target.compareTo(current.getValue());

            if (cmp == 0) return current.getValue();
            current = (cmp < 0) ? current.getLeft() : current.getRight();
        }
        return null;
    }

    public Person searchByAge(int age) {
        return findAge(root, age);
    }

    private Person findAge(Node<T> node, int age) {
        if (node == null) return null;

        Person p = (Person) node.getValue();
        if (p.getAge() == age) return p;

        Person left = findAge(node.getLeft(), age);
        return (left != null) ? left : findAge(node.getRight(), age);
    }
}