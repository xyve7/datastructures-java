import java.util.Arrays;

public class MyVector<E> {
    private Object[] data;
    private int size;

    public MyVector(Object[] initial, int size) {
        this.data = Arrays.copyOf(initial, initial.length);
        this.size = size;
    }
    public MyVector(int capacity) {
        this.data = new Object[capacity];
        this.size = 0;
    }
    public MyVector() {
        this.data = new Object[2];
        this.size = 0;
    }
    public MyVector(MyVector<E> other) {
        this.data = Arrays.copyOf(other.data, other.data.length);
        this.size = other.size;
    }

    public void add(E obj) {
        if(this.size == this.data.length) {
            Object[] newData = new Object[this.data.length * 2];
            System.arraycopy(data, 0, newData, 0, this.data.length);
            this.data = newData;
        }
        this.data[this.size] = obj;
        this.size++;
    }
    public E get(int index) throws IndexOutOfBoundsException {
        if(index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException(index + " is out of bounds for " + this.size);
        }
        return (E)this.data[index];
    }
    public void set(int index, E item) {
        if(index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException(index + " is out of bounds for " + this.size);
        }
        this.data[index] = item;
    }
    public E remove(int index) {
        if(index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException(index + " is out of bounds for " + this.size);
        }
        if(index == (this.size - 1)) {
            E retObj = (E)this.data[this.size - 1];
            this.size--;
            return retObj;
        }
        E retObj = (E)this.data[index];
        System.arraycopy(data, index + 1, data, index, this.size - 1 );
        this.size--;
        return retObj;
    }
    public int find(E item) {
        for (int i = 0; i < this.size; i++) {
            if(this.data[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }
    public boolean contains(E item) {
        return this.find(item) != -1;
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
