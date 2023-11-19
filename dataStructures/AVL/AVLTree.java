
public class AVLTree {
    Node root;

    public Node insert(int value) {
        Node node = recursiveInsert(root, value);

        if (node == null) {
            System.out.println("Este valor já existe na árvore");
            return null;
        }

        return node;
    }

    public void search(int value) {
        Node res = recursiveSearch(root, value);

        if (res != null) {
            System.out.println("O nó " + res.value + " pertence a árvore");
        } else {
            System.out.println("O nó " + value + " não pertence à árvore");
        }
    }

    private Node recursiveSearch(Node node, int value) {
        if (node.value == value) {
            return node;
        } else if (value > node.value) {
            return recursiveSearch(node.right, value);
        } else if (value < node.value) {
            return recursiveInsert(node.left, value);
        }
        return null;
    }

    private Node recursiveInsert(Node root, int value) {
        Node node = new Node(value);

        // Inserção padrão da BST, o que é maior vai pra direita, o que é menor, pra
        // esquerda.
        if (root == null)
            root = node;
        else if (node.value > root.value)
            root.right = recursiveInsert(root.right, value);
        else if (node.value < root.value)
            root.left = recursiveInsert(root.left, value);
        else
            return null;

        // Atribuir altura do nó
        node.height = 1 + max(height(node.left), height(node.right));

        // Verifica o fator de balanceamento da árvore
        int balance = getBalance(node);

        // Realiza as rotações

        // Giro para direita, pois o lado esquerdo está gerando desequilíbrio
        if (balance > 1 && value < node.left.value) {
            rightRotate(node);
        }
        // Giro para esquerda, pois o lado direito está gerando desequilíbrio
        if (balance < -1 && value > node.right.value) {
            leftRotate(node);
        }
        // Lado esquerdo gera desequilibrio, mas o valor será inserido a esquerda do nó
        // filho
        if (balance > 1 && value > node.left.value) {
            node.right = rightRotate(node.right);
            leftRotate(node);
        }
        // Lado direito gera desequilibrio, mas o valor será inserido a direita do nó
        // filho
        if (balance < -1 && value < node.right.value) {
            node.left = leftRotate(node.left);
            rightRotate(node);
        }

        return node;
    }

    private Node leftRotate(Node node) {
        Node x = node.right;
        Node y = x.left;

        x.left = node;
        node.right = y;

        node.height = 1 + max(height(node.left), height(node.right));
        x.height = 1 + max(height(x.left), height(x.right));

        return x;
    }

    private Node rightRotate(Node node) {
        Node x = node.left;
        Node y = x.right;

        x.right = node;
        node.left = y;

        node.height = 1 + max(height(node.left), height(node.right));
        x.height = 1 + max(height(x.left), height(x.right));

        return x;
    }

    // Retorna o fator de equilíbrio do nó, calculando altura esq - altura dir
    private int getBalance(Node node) {
        if (node == null)
            return 0;

        return height(node.left) - height(node.right);
    }

    private int max(int height, int height2) {
        if (height > height2)
            return height;
        else if (height2 > height)
            return height;
        else
            return height;
    }

    private int height(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }
}
