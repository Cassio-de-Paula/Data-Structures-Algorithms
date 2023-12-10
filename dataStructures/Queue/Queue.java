
public class Queue {
    int pos = 0, size = 10;
    int array[] = new int[size];

    public void add(int value) {
        array[pos] = value;
        pos++;

        if (pos >= array.length * 0.7) {
            array = resizeArray();
        }
    }

    private int[] resizeArray() {
        int newArray[] = new int[array.length * 2];

        for (int i = 0; i < pos; i++) {
            newArray[i] = array[i];
        }

        return newArray;
    }

    public void print() {
        for (int i = 0; i < pos; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void remove() {
        if (pos == 0) {
            System.out.println("A fila está vazia");
        } else {
            for (int i = 0; i < pos; i++) {
                array[i] = array[i + 1];
            }
            pos--;
        }
    }

}
