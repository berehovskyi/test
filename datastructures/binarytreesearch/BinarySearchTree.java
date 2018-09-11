package datastructures.binarytreesearch;

class BinarySearchTree {
    private Node root;

    BinarySearchTree() {
        root = null;
    }

    void insert(int key) {
        root = insertRecursive(root, key);
    }

    private Node insertRecursive(Node root, int key) {

        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key) {
            root.leftChild = insertRecursive(root.leftChild, key);
        } else {
            root.rightChild = insertRecursive(root.rightChild, key);
        }
        return root;
    }

    void delete(int key) {
        root = deleteRecursive(root, key);
    }

    private Node deleteRecursive(Node root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.key) {
            root.leftChild = deleteRecursive(root.leftChild, key);
        } else {
            if (root.leftChild == null) {
                return root.rightChild;
            } else if (root.rightChild == null) {
                return root.leftChild;
            }
            root.key = getMinValue(root.rightChild);
            root.rightChild = deleteRecursive(root.rightChild, key);
        }
        return root;
    }

    private int getMinValue(Node root) {
        int minValue = root.key;
        while (root.leftChild != null) {
            minValue = root.leftChild.key;
            root = root.leftChild;
        }
        return minValue;
    }

    void inorder() {
        inorderRecursive(root);
    }

    private void inorderRecursive(Node root) {
        if (root != null) {
            inorderRecursive(root.leftChild);
            System.out.println(root.key + " ");
            inorderRecursive(root.rightChild);
        }
    }
}

class Node {
    int key;
    Node leftChild;
    Node rightChild;

    Node(int key) {
        this.key = key;
        this.leftChild = null;
        this.rightChild = null;
    }
}