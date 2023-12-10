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
            // Nó é uma folha
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.right == null) {
                return root.left;
            } else if (root.left == null) {
                return root.right;
            } else {
                if (root.value < this.root.value) {
                    root.value = nextValue(root);
                    root.right = recursiveRemove(root.value, root.right);
                } else if (root.value > this.root.value) {
                    root.value = previousValue(root);
                    root.left = recursiveRemove(root.value, root.left);
                }
            }
        }

        return root;
    }

    private int previousValue(Node root) {
        // Encontra o menor valor que seja menor que o nó a ser removido
        while (root.left != null) {
            root = root.left;
        }
        return root.value;
    }

    private int nextValue(Node root) {
        // Encontra o maior valor que seja maior que o nó a ser removido
        while (root.right != null) {
            root = root.right;
        }
        return root.value;
    }
}
