public class Main {
    public static void main(String args[]) {
        AVLTree avl = new AVLTree();

        avl.insert(8);
        avl.insert(12);
        avl.insert(7);
        avl.insert(11);
        avl.insert(15);
        avl.insert(17);
        avl.insert(16);

        avl.display();

        avl.search(11);

        avl.remove(11);

        avl.display();

    }
}