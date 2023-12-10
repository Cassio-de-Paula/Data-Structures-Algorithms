
public class AVLTree {
    Node root;

    public Node insert(int value) {
        root = recursiveInsert(root, new Node(value));

        if (root == null) {
            System.out.println("Este valor já existe na árvore");
            return null;
        }

        return root;
    }

    public Node search(int value) {
        Node res = recursiveSearch(root, value);

        if (res != null) {
            System.out.println("O nó " + res.value + " pertence a árvore");
            return res;
        } else {
            System.out.println("O nó " + value + " não pertence à árvore");
        }

        return null;
    }

    public Node remove(int value) {

        if (search(value) != null) {
            recursiveRemove(value, this.root);
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

    private Node recursiveRemove(int value, Node root) {

        if (value > root.value) {
            // Busca pelo nó a partir da raíz
            root.right = recursiveRemove(value, root.right);
        } else if (value < root.value) {
            // Busca pelo nó a partir da raíz
            root.left = recursiveRemove(value, root.left);
        } else {
            // Analisa os casos após encontrar o nó
            if (root.left == null && root.right == null) {
                // Caso 1: Nó é uma folha
                return null;
            } else if (root.right == null) {
                // Caso 2: Nó possui filho à esquerda
                return root.left;
            } else if (root.left == null) {
                // Caso 3: Nó possui filho à direita
                return root.right;
            } else {
                // Caso 4: nó possui filhos à direita e esquerda
                if (root.value < this.root.value) {
                    // Caso A: Nó a ser removido é menor que a raíz da árvore
                    root.value = nextValue(root);
                    root.right = recursiveRemove(root.value, root.right);
                } else if (root.value > this.root.value || root.value == this.root.value) {
                    // Caso B: Nó a ser removido é maior ou igual à raíz da árvore
                    root.value = previousValue(root);
                    root.left = recursiveRemove(root.value, root.left);
                }
            }
        }

        root.height = 1 + max(height(root.left), height(root.right));

        int balance = getBalance(root);

        // Realiza as rotações

        // Giro para direita, pois o lado esquerdo está gerando desequilíbrio
        if (balance > 1 && value < root.left.value) {
            root = rightRotate(root);
        }
        // Giro para esquerda, pois o lado direito está gerando desequilíbrio
        if (balance < -1 && value > root.right.value) {
            root = leftRotate(root);
        }
        // Lado esquerdo gera desequilibrio, mas o valor será inserido a esquerda do nó
        // filho (Giro para esquerda redefinindo a esquerda do nó em desequilíbrio e
        // depois giro para direita)
        if (balance > 1 && value > root.left.value) {
            root.left = leftRotate(root.left);
            root = rightRotate(root);
        }
        // Lado direito gera desequilibrio, mas o valor será inserido a direita do nó
        // filho (Giro para direita redefinindo a direita do nó em desequilíbrio e
        // depois giro para esquerda)
        if (balance < -1 && value < root.right.value) {
            root.right = rightRotate(root.right);
            root = leftRotate(root);
        }

        return root;
    }

    private int previousValue(Node root) {
        while (root.left != null) {
            root = root.left;
        }

        return root.value;
    }

    private int nextValue(Node root) {
        while (root.right != null) {
            root = root.right;
        }

        return root.value;
    }

    private Node recursiveSearch(Node root, int value) {
        if (root.value == value) {
            return root;
        } else if (value > root.value) {
            return recursiveSearch(root.right, value);
        } else if (value < root.value) {
            return recursiveSearch(root.left, value);
        }
        return null;
    }

    private Node recursiveInsert(Node root, Node node) {
        // Inserção padrão da BST, o que é maior vai pra direita, o que é menor, pra
        // esquerda.
        if (root == null) {
            root = node;
        } else if (node.value > root.value) {
            root.right = recursiveInsert(root.right, node);
        } else if (node.value < root.value) {
            root.left = recursiveInsert(root.left, node);
        } else {
            return null;
        }

        // Atribuir altura do nó
        root.height = 1 + max(height(root.left), height(root.right));

        // Verifica o fator de balanceamento da árvore
        int balance = getBalance(root);

        // Realiza as rotações

        // Giro para direita, pois o lado esquerdo está gerando desequilíbrio
        if (balance > 1 && node.value < root.left.value) {
            root = rightRotate(root);
        }
        // Giro para esquerda, pois o lado direito está gerando desequilíbrio
        if (balance < -1 && node.value > root.right.value) {
            root = leftRotate(root);
        }
        // Lado esquerdo gera desequilibrio, mas o valor será inserido a esquerda do nó
        // filho (Giro para esquerda redefinindo a esquerda do nó em desequilíbrio e
        // depois giro para direita)
        if (balance > 1 && node.value > root.left.value) {
            root.left = leftRotate(root.left);
            root = rightRotate(root);
        }
        // Lado direito gera desequilibrio, mas o valor será inserido a direita do nó
        // filho (Giro para direita redefinindo a direita do nó em desequilíbrio e
        // depois giro para esquerda)
        if (balance < -1 && node.value < root.right.value) {
            root.right = rightRotate(root.right);
            root = leftRotate(root);
        }

        return root;
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
