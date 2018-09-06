import java.util.Iterator;
import java.util.Objects;

public class DoubleLinkedList<T> implements Iterator{
    private class Node<T> {
        T c;
        Node<T> next;
        Node<T> priv;
        public Node(T c) {
            this.c = c;
        }
        @Override
        public String toString() {
            return c.toString();
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node<T> node = (Node) o;
            return Objects.equals(c, node.c);
        }

        public void setPriv(Node priv){
            this.priv = priv;
        }
    }

    private Node<T> head;

    public DoubleLinkedList() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insert(T c) {
        Node<T> n = new Node<T>(c);
        n.next = head; // if (head == null) n.next = null;
        head = n;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public T next() {
        return null;
    }

    public T remove() {
        if (isEmpty())
            return null;
        T temp = head.c;
        head = head.next;
        return temp;
    }

    public boolean contains(T c) {
        Node<T> n = new Node<T>(c);
        Node<T> current = head;
        while (!current.equals(n)) {
            if (current.next == null)
                return false;
            else
                current = current.next;
        }
        return true;
    }

    public T delete(String name) {
        Node<T> current = head;
        Node<T> previous = head;
        while (!(((Cat)current.c).getName()).equals(name)) {
            if (current.next == null)
                return null;
            else {
                previous = current;
                current = current.next;
            }
        }
        if (current == head)
            head = head.next;
        else
            previous.next = current.next;

        return current.c;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        Node<T> current = head;
        StringBuilder sb = new StringBuilder("[");
        while (current != null) {
            sb.append(current);
            current = current.next;
            sb.append((current == null) ? "]" : ", ");
        }
        return sb.toString();
    }
}