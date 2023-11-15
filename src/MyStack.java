import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStack<E> {
    private Object[] data;
    private int size;

    public MyStack(Object[] initial, int size) {
        this.data = Arrays.copyOf(initial, initial.length);
        this.size = size;
    }
    public MyStack(int capacity) {
        this.data = new Object[capacity];
        this.size = 0;
    }
    public MyStack() {
        this.data = new Object[2];
        this.size = 0;
    }
    public MyStack(MyStack<E> other) {
        this.data = Arrays.copyOf(other.data, other.data.length);
        this.size = other.size;
    }

    public void push(E obj) {
        if(this.size == this.data.length) {
            Object[] newData = new Object[this.data.length * 2];
            System.arraycopy(data, 0, newData, 0, this.data.length);
            this.data = newData;
        }
        this.data[this.size++] = obj;
    }
    public E pop() throws EmptyStackException {
        if(this.size == 0) {
            throw new EmptyStackException();
        }
        return (E)this.data[--this.size];
    }
    public E get(int index) throws IndexOutOfBoundsException {
        if(index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException(index + " is out of bounds for " + this.size);
        }
        return (E)this.data[index];
    }
    public boolean contains(E item) {
        for (int i = 0; i < this.size; i++) {
            if(this.data[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return this.size;
    }
    public boolean isEmpty() {
        return this.size == 0;
    }

    public String toString() {
        if(this.isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < this.size - 1; i++) {
            sb.append(this.data[i].toString() + ", ");
        }
        sb.append(this.data[this.size - 1] + "]");
        return sb.toString();
    }

}
