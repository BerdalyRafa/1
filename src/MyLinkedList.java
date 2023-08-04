
// MyLinkedList implementation
class MyLinkedList<T> implements MyList<T> {
    private class Node {
        T element;
        Node next;
        Node previous;

        public Node(T element) {
            this.element = element;
            this.next = null;
            this.previous = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        // Add implementation if needed
        return false;
    }

    @Override
    public void add(T item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void add(T item, int index) {
        checkIndex(index);
        if (index == size) {
            add(item);
            return;
        }
        Node newNode = new Node(item);
        if (index == 0) {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        } else {
            Node current = getNode(index);
            newNode.next = current;
            newNode.previous = current.previous;
            current.previous.next = newNode;
            current.previous = newNode;
        }
        size++;
    }

    private Node getNode(int index) {
        checkIndex(index);
        Node current;
        if (index <= size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.previous;
            }
        }
        return current;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index does not exist");
        }
    }

    @Override
    public boolean remove(T item) {
        int index = indexOf(item);
        if (index >= 0) {
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public T remove(int index) {
        checkIndex(index);
        Node current = getNode(index);
        if (current == head) {
            head = current.next;
        } else if (current == tail) {
            tail = current.previous;
        } else {
            current.previous.next = current.next;
            current.next.previous = current.previous;
        }
        size--;
        return current.element;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public T get(int index) {
        return getNode(index).element;
    }

    @Override
    public int indexOf(Object o) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.element.equals(o)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node current = tail;
        int index = size - 1;
        while (current != null) {
            if (current.element.equals(o)) {
                return index;
            }
            current = current.previous;
            index--;
        }
        return -1;
    }

    @Override
    public void sort() {
        // Add sorting logic if needed
    }
}
