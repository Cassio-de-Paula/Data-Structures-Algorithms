import java.util.Random;

public class InsertionSort {
    public static void main(String[] args) {
        Random random = new Random();

        int[] array = new int[10];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }

        System.out.println("Array:");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();

        int[] orderedArray = insertionSort(array);

        System.out.println("\nOrdered array: ");

        for (int i = 0; i < orderedArray.length; i++) {
            System.out.print(orderedArray[i] + " ");
        }
    }

    private static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp;
            int cont = i;
            if (array[cont] < array[cont - 1]) {
                temp = array[cont];
                while (cont > 0 && temp < array[cont - 1]) {
                    array[cont] = array[cont - 1];
                    array[cont - 1] = temp;
                    cont--;
                }
            }

            for (int j = 0; j < array.length; j++) {
                System.out.print(array[j] + " ");
            }
            System.out.println();
        }
        return array;
    }
}
