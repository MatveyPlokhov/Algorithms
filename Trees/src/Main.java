import java.util.Random;

public class Main {
    static Random random = new Random();
    final static int TREES = 20;
    final static int HEIGHT = 6;
    static int balance = 0, unbalance = 0;

    public static void main(String[] args) {
        createTrees();
        System.out.println("Сбалансированные: " + (float) (balance * 100) / TREES + "%");
        System.out.println("Несбалансированные: " + (float) (unbalance * 100) / TREES + "%");
    }

    private static void createTrees() {
        for (int i = 0; i < TREES; i++) {
            MyTreeMap<Integer, Integer> myTreeMap = new MyTreeMap<>();
            while (myTreeMap.height() <= HEIGHT) {
                int key = random.nextInt(201) - 100;
                int value = random.nextInt(201) - 100;
                myTreeMap.put(key, value);
            }
            if (myTreeMap.balance())
                balance++;
            else
                unbalance++;
        }
    }
}
