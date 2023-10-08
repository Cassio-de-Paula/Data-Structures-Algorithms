public class BubbleSort {
    public static void main(String[] args) {
        int[] array = { 9, 1, 3, 5, 7, 6, 2, 0, 8, 4 };

        System.out.println("Array:");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        int[] orderedArray = bubbleSort(array);

        System.out.println("\nOrdered array: ");

        for (int i = 0; i < orderedArray.length; i++) {
            System.out.print(orderedArray[i] + " ");
        }

    }

    private static int[] bubbleSort(int[] array) {
        int temp;

        for (int j = 0; j < array.length - 1; j++) {
            for (int i = 0; i < array.length - j - 1; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }

        return array;
    }
}
