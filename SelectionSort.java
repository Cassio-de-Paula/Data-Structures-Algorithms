import java.util.Random;

public class SelectionSort {
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

        int[] orderedArray = selectionSort(array);

        System.out.println("\nOrdered array: ");

        for (int i = 0; i < orderedArray.length; i++) {
            System.out.print(orderedArray[i] + " ");
        }
    }

    private static int[] selectionSort(int[] array) {
        int temp;
        int min;

        for (int i = 0; i < array.length; i++) {
            min = array[i];

            for (int j = i; j < array.length; j++) {
                if (min > array[j]) {
                    temp = min;
                    min = array[j];
                    array[j] = temp;
                }
            }

            array[i] = min;

            System.out.println();

            System.out.println(min);

            for (int k = 0; k < array.length; k++) {
                System.out.print(array[k] + " ");
            }
        }
        return array;
    }
}
