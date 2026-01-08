package structures.trees;

import structures.node.Node;

public class IntTree {

    private Node<Integer> root;

    public void insert(int number) {
        if (root == null) {
            root = new Node<>(number);
        } else {
            add(root, number);
        }
    }

    private void add(Node<Integer> node, int number) {
        if (number <= node.getValue()) {
            if (node.getLeft() == null) {
                node.setLeft(new Node<>(number));
            } else {
                add(node.getLeft(), number);
            }
        } else {
            if (node.getRight() == null) {
                node.setRight(new Node<>(number));
            } else {
                add(node.getRight(), number);
            }
        }
    }

    /* ===== PRE ORDER ===== */
    public void preOrder() {
        preOrderRec(root);
        System.out.println();
    }

    private void preOrderRec(Node<Integer> node) {
        if (node == null)
            return;

        System.out.print(node.getValue() + " ");
        preOrderRec(node.getLeft());
        preOrderRec(node.getRight());
    }

    /* ===== IN ORDER ===== */
    public void inOrder() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node<Integer> node) {
        if (node == null)
            return;

        inOrderRec(node.getLeft());
        System.out.print(node.getValue() + " ");
        inOrderRec(node.getRight());
    }

    /* ===== POST ORDER ===== */
    public void posOrder() {
        posOrderRec(root);
        System.out.println();
    }

    private void posOrderRec(Node<Integer> node) {
        if (node == null)
            return;

        posOrderRec(node.getLeft());
        posOrderRec(node.getRight());
        System.out.print(node.getValue() + " ");
    }

    public int size() {
        return count(root);
    }

    private int count(Node<Integer> node) {
        return (node == null)
                ? 0
                : 1 + count(node.getLeft()) + count(node.getRight());
    }
}