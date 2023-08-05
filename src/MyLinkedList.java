
class MyLinkedList<E> {
    private Node<E> head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public void add(E element) {
        Node<E> newNode = new Node<>(element);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public int size() {
        return size;
    }

    // Method to add all elements from another collection to this list
    public void addAll(MyLinkedList<? extends E> collection) {
        Node<E> current = (Node<E>) collection.head;
        while (current != null) {
            this.add(current.data);
            current = current.next;
        }
    }
}
