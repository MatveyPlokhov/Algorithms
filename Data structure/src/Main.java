import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Character> deque = new Deque<>();
        String text = scanner.nextLine();
        for (int i = 0; i < text.length(); i++) {
            deque.insertLeft(text.charAt(i));
        }
        for (int i = 0; i < text.length(); i++) {
            System.out.print(deque.removeLeft());
        }
    }
}
