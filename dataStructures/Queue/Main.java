public class Main {
    public static void main(String args[]) {
        Queue queue = new Queue();

        for (int i = 0; i < 10; i++) {
            queue.add(i);
        }

        queue.print();

        for (int i = 0; i < 5; i++) {
            queue.remove();
        }

        queue.print();

    }
}