import java.io.*;
import java.util.*;

public class Main {

    public static class Node {
        int key;
        Node left, right;

        public Node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    public static class BST {
        Node root;

        public BST() {
            root = null;
        }

        public void insert(int key) {
            root = insertRec(root, key);
        }

        private Node insertRec(Node node, int key) {
            if (node == null) {
                node = new Node(key);
                return node;
            }

            if (key < node.key) {
                node.left = insertRec(node.left, key);
            } else if (key > node.key) {
                node.right = insertRec(node.right, key);
            }

            return node;
        }

        public void postOrder() {
            postOrderRec(root);
        }

        private void postOrderRec(Node node) {
            if (node != null) {
                postOrderRec(node.left);
                postOrderRec(node.right);
                System.out.println(node.key);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int key;
        BST tree = new BST();

        while ((line = br.readLine()) != null) {
            key = Integer.parseInt(line);
            tree.insert(key);
        }

        tree.postOrder();
    }
}
