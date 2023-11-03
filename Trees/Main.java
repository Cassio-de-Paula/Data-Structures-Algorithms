package Trees;

public class Main {
    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();

        tree.insertNode(5);
        tree.insertNode(7);
        tree.insertNode(4);
        tree.insertNode(3);
        tree.insertNode(8);

        tree.display();

        tree.removeNode(8);

        System.out.println();

        tree.display();

    }
}
