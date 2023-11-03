package Trees;

public class BinarySearchTree {
    Node root;

    public void insertNode(int value) {
        root = recursiveInsert(root, new Node(value));
    }

    private Node recursiveInsert(Node root, Node node) {
        int value = node.value;

        if (root == null) {
            root = node;
        } else if (value <= root.value) {
            root.left = recursiveInsert(root.left, node);
        } else {
            root.right = recursiveInsert(root.right, node);
        }
        return root;
    }

    public void display() {
        recursiveDisplay(this.root);
    }

    private void recursiveDisplay(Node root) {
        if (root != null) {
            recursiveDisplay(root.left);
            System.out.print(root.value + " ");
            recursiveDisplay(root.right);
        }
    }

    public boolean searchNode(int target) {
        if (recursiveSearch(root, target) != null) {
            return true;
        }

        return false;

    }

    private Node recursiveSearch(Node root, int target) {

        if (root == null) {
            return null;
        } else if (target < root.value) {
            return recursiveSearch(root.left, target);
        } else if (target > root.value) {
            return recursiveSearch(root.right, target);
        } else {
            return root;
        }

    }

    public void removeNode(int target) {
        recursiveSearch(root, target);

        if (recursiveSearch(root, target) == null) {
            System.out.println("O valor " + target + " não faz parte da árvore.");
        } else {
            recursiveRemove(target, root);
        }
    }

    private Node recursiveRemove(int target, Node root) {

        if (target < root.value) {
            root.left = recursiveRemove(target, root.left);
        } else if (target > root.value) {
            root.right = recursiveRemove(target, root.right);
        } else {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.right != null) { // find a successor to replace this node
                root.value = nextValue(root);
                root.right = recursiveRemove(root.value, root.right);
            } else { // find a predecessor to replace this node
                root.value = previousValue(root);
                root.left = recursiveRemove(root.value, root.right);
            }
        }

        return root;
    }

    private int nextValue(Node root) {
        // Encontrar o menor valor abaixo do filho da direita do nó
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.value;
    }

    private int previousValue(Node root) {
        // Encontrar o maior valor abaixo do filho da esquerda do nó
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root.value;
    }
}
