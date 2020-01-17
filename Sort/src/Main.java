import java.util.Random;

public class Main {
    static final int SIZE = 1000000;
    static Random random = new Random();

    public static void main(String[] args) {
        long timeStart;
        long timeEnd;
        int[] array1 = new int[SIZE];
        int[] array2 = new int[SIZE];
        int[] array3 = new int[SIZE];

        timeStart = System.currentTimeMillis();
        arrayFilling(array1, array2, array3);
        timeEnd = System.currentTimeMillis() - timeStart;
        System.out.println("Заполнение = " + timeEnd);

        timeStart = System.currentTimeMillis();
        bubbleSort(array1);
        timeEnd = System.currentTimeMillis() - timeStart;
        System.out.println("Сортировка пузырьком = " + timeEnd);

        timeStart = System.currentTimeMillis();
        selectionSort(array2);
        timeEnd = System.currentTimeMillis() - timeStart;
        System.out.println("Сортировка выбором = " + timeEnd);

        timeStart = System.currentTimeMillis();
        insertionSort(array3);
        timeEnd = System.currentTimeMillis() - timeStart;
        System.out.println("Сортировка вставками = " + timeEnd);
    }

    private static void arrayFilling(int[] array1, int[] array2, int[] array3) {
        for (int i = 0, r; i < SIZE; i++) {
            r = random.nextInt(1000);
            array1[i] = r;
            array2[i] = r;
            array3[i] = r;
        }
    }

    private static void bubbleSort(int[] array) {
        boolean isSwap;
        for (int i = 0; i < array.length - 1; i++) {
            isSwap = false;
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    isSwap = true;
                }
            }
            if (!isSwap) {
                break;
            }
        }
    }

    private static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int iMin = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[iMin]) {
                    iMin = j;
                }
            }
            swap(array, i, iMin);
        }
    }

    private static void insertionSort(int[] array) {
        for(int i = 1; i < array.length; i++){
            int currElem = array[i];
            int prevKey = i - 1;
            while(prevKey >= 0 && array[prevKey] > currElem){
                array[prevKey+1] = array[prevKey];
                array[prevKey] = currElem;
                prevKey--;
            }
        }
    }

    private static void swap(int[] array, int pos1, int pos2) {
        int temp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = temp;
    }
}
