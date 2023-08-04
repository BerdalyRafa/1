// MyList interface
interface MyList<T> {
    int size();
    boolean contains(Object o);
    void add(T item);
    void add(T item, int index);
    boolean remove(T item);
    T remove(int index);
    void clear();
    T get(int index);
    int indexOf(Object o);
    int lastIndexOf(Object o);
    void sort();
}

// MyArrayList implementation
public class MyArrayList<T> implements MyList<T> {
    private Object[] arr;
    private int size;

    public MyArrayList() {
        this.arr = new Object[5];
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public void add(T item) {
        if (size == arr.length) {
            increaseBuffer();
        }
        arr[size++] = item;
    }

    private void increaseBuffer() {
        Object[] newArr = new Object[arr.length * 2];
        System.arraycopy(arr, 0, newArr, 0, size);
        arr = newArr;
    }

    @Override
    public void add(T item, int index) {
        checkIndex(index);
        if (size == arr.length) {
            increaseBuffer();
        }
        System.arraycopy(arr, index, arr, index + 1, size - index);
        arr[index] = item;
        size++;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index does not exist");
        }
    }

    @Override
    public boolean remove(T item) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (arr[i] == item) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public T remove(int index) {
        checkIndex(index);
        T temp = (T) arr[index];
        System.arraycopy(arr, index + 1, arr, index, size - index - 1);
        size--;
        return temp;
    }

    @Override
    public void clear() {
        this.arr = new Object[5];
        this.size = 0;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) arr[index];
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (arr[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void sort() {
        // Add sorting logic if needed
    }
}
