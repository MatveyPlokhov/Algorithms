public class Main {
    public static void main(String[] args) {
        LinkedStack<String> stack = new LinkedStack<>();
        stack.push("Hello ");
        stack.push("World ");
        stack.push("!");
        System.out.println(stack.peek());
        System.out.println(stack.size());
        stack.pop();
        System.out.println(stack.peek());
        System.out.println(stack.size());
        System.out.println(stack.search("World "));
    }
}