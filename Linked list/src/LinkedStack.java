public class LinkedStack<T> {
    private LinkedList<T> stack = new LinkedList<>();

    public int size() {
        return stack.size();
    }

    public int search(T v) {
        return stack.indexOf(v);
    }

    public boolean empty() {
        return stack.isEmpty();
    }

    public void push(T v) {
        stack.insertFirst(v);
    }

    public T peek() {
        return stack.getLast();
    }

    public T pop() {
        return stack.removeLast();
    }
}
