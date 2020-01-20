import java.util.Collections;
import java.util.Random;

public class Main {
    final static int size = 1000000;

    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
        }
        qSort(array, 0, array.length - 1);
        System.out.println("#1");
        //1
        System.out.println(recDegree(2, 6));
        System.out.println(recDegree(2, 10));
        System.out.println(recDegree(2, 12));

        System.out.println("#2");
        //2
        int backpackWight = 80;
        Item[] items = {
                new Item(15, 60),
                new Item(30, 90),
                new Item(50, 100)
        };
        System.out.println(optimalBackpack(items, items.length - 1, backpackWight));
    }

    public static void qSort(int[] array, int low, int high) {
        if (high <= low) {
            return;
        }
        int middle = low + (high - low) / 2;
        int middleNum = array[middle];

        int i = low;
        int j = high;

        while (i <= j) {
            while (array[i] < middleNum)
                i++;
            while (array[j] > middleNum)
                j--;
            if (i <= j) {
                int k = array[i];
                array[i] = array[j];
                array[j] = k;
                i++;
                j--;
            }
        }
        if (low < j) {
            qSort(array, low, j);
        }
        if (high > i) {
            qSort(array, i, high);
        }
    }

    public static long recDegree(int num, int degree) {
        if (degree == 1)
            return num;
        return recDegree(num, degree - 1) * num;
    }

    public static int optimalBackpack(Item[] items, int i, int backpackWight) {
        if (i < 0) {
            return 0;
        }
        if (items[i].weight > backpackWight)
            return optimalBackpack(items, i - 1, backpackWight);
        else
            return Math.max(optimalBackpack(items, i - 1, backpackWight),
                    optimalBackpack(items, i - 1, backpackWight - items[i].weight) + items[i].price);
    }

    static class Item {
        int weight, price;

        Item(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
    }
}
