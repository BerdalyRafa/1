class MyArrayList<E> {
    private static final int INITIAL_CAPACITY = 10;
    private Object[] data;
    private int size;

    public MyArrayList() {
        data = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    public void add(E element) {
        if (size == data.length) {
            increaseCapacity();
        }
        data[size++] = element;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (E) data[index];
    }

    public int size() {
        return size;
    }

    private void increaseCapacity() {
        int newCapacity = data.length * 2;
        Object[] newData = new Object[newCapacity];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }

    // Method to add all elements from another collection to this list
    public void addAll(MyArrayList<? extends E> collection) {
        for (int i = 0; i < collection.size(); i++) {
            this.add(collection.get(i));
        }
    }
}

class Node<E> {
    E data;
    Node<E> next;

    public Node(E data) {
        this.data = data;
        this.next = null;
    }
}
