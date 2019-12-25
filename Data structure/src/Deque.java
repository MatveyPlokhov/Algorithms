import java.util.EmptyStackException;

public class Deque<T> {

    private T[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;
    private int begin = 0;
    private int end = 0;

    public Deque(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        list = (T[]) new Object[capacity];
    }

    public Deque() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void insertLeft(T value) {
        if (isFull()) throw new StackOverflowError();
        size++;
        begin = previousIndex(begin);
        list[begin] = value;
    }

    public void insertRight(T value) {
        if (isFull()) throw new StackOverflowError();
        list[end] = value;
        size++;
        end = nextIndex(end);
    }

    public T removeLeft() {
        if (isEmpty()) throw new EmptyStackException();
        T temp = list[begin];
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
        return temp;
    }

    public T removeRight() {
        if (isEmpty()) throw new EmptyStackException();

        end = previousIndex(end);
        T temp = list[end];
        size--;
        list[end] = null;
        return temp;
    }

    private int previousIndex(int index) {
        return (list.length + index - 1) % list.length;
    }

    private int nextIndex(int index) {
        return (index + 1) % list.length;
    }

    public boolean isFull() {
        return size == list.length;
    }

    public boolean isEmpty() {
        return size <= 0;
    }

    public int size() {
        return size;
    }
}
