package year2017.day5.exo;

public class MyLinkedList<E> {
    public class Node {
        E value;
        Node next;
        Node previous;

        Node(E value) {
            this.value = value;
            this.next = null;
            this.previous = null;
        }

        public E getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setValue(E value) {
            this.value = value;
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

    public void add(E element) {
        Node newNode = new Node(element);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        size++;
    }

    public E next(E element) {
        Node current = head;
        while (current != null) {
            if (current.value.equals(element)) {
                return current.next != null ? current.next.value : null;
            }
            current = current.next;
        }
        return null;
    }

    public E previous(E element) {
        Node current = head;
        while (current != null) {
            if (current.value.equals(element)) {
                return current.previous != null ? current.previous.value : null;
            }
            current = current.next;
        }
        return null;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node current = head;
        while (current != null) {
            sb.append(current.value);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}

