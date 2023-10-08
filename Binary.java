public class Binary {
    public static void main(String[] args) {

        int[] array = new int[200000];

        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        int index = myBinary(array, 300000);

        System.out.println(index);

    }

    public static int myBinary(int[] array, int value) {
        int halfIndex = (int) array.length / 2;

        for (int length = halfIndex; length > 0;) {
            if (value == array[halfIndex]) {
                return halfIndex;
            } else if (value > array[halfIndex]) {
                length = (length / 2);
                halfIndex += length;
            } else {
                length = (length / 2);
                halfIndex -= length;
            }
        }

        return -1;
    }
}