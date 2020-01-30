import java.util.Random;

public class Main {
    public static Random random = new Random();
    public static void main(String[] args) {
        ChainingHashMap<Integer, String> chainingHashMap = new ChainingHashMap<>();
        chainingHashMap.put(1, "one");
        chainingHashMap.put(2, "two");
        chainingHashMap.put(3, "three");
        chainingHashMap.put(4, "four");
        chainingHashMap.put(5, "five");
        chainingHashMap.put(6, "six");
        chainingHashMap.put(536, "delusional");
        chainingHashMap.put(1234, "delusional");
        for (int i = 0; i < 20; i++) {
            chainingHashMap.put(random.nextInt(1000), "empty");
        }
        System.out.println(chainingHashMap);
        System.out.println(chainingHashMap.removeNode(536));
        System.out.println(chainingHashMap);
    }
}
