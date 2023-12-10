package Trees;

public class Main {
    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();

        tree.insertNode(5);
        tree.insertNode(9);
        tree.insertNode(2);
        tree.insertNode(1);
        tree.insertNode(4);
        tree.insertNode(6);
        tree.insertNode(11);
        tree.insertNode(3);
        tree.insertNode(7);
        tree.insertNode(12);

        tree.display();

        tree.removeNode(9);

        System.out.println();

        tree.display();

        System.out.println();

        System.out.println(tree.root.right.value);

    }
}
