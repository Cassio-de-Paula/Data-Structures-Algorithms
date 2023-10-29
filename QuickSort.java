import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[10];

        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();

        int[] sortedArray = quickSort(array);

        for (int i = 0; i < sortedArray.length; i++) {
            System.out.print(sortedArray[i] + " ");
        }

    }

    private static int[] quickSort(int[] array) {
        int start = 0;
        int end = array.length - 1;

        pivot(array, start, end);

        return array;
    }

    private static int[] pivot(int[] array, int start, int end) {

        if (end - start > 0) {
            int pivot = array[end];
            int temp;
            int i = start - 1;

            for (int j = start; j < end + 1; j++) {
                if (array[j] <= pivot) {
                    i++;
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }

            }

            pivot(array, start, i - 1);
            pivot(array, i + 1, end);
        }

        return array;
    }
}