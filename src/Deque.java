public class Deque {
    private int size;
    private int[] deque;
    private int head;
    private int tail;
    private int items;

    public Deque(int size) {
        this.size = size;
        deque = new int[size];
        head = 0;
        tail = -1;
    }

    public boolean isEmpty() {
        return items == 0;
    }

    public boolean isFull() {
        return items == size;
    }

    public int size() {
        return items;
    }

    public void insertToTail(int i) {
        if (isFull()) {
            increaseDeque();
        }
        if (tail == size - 1)
            tail = -1;
        deque[++tail] = i;
        items++;
    }

    public void insertToHead(int i){
        if (isFull()) {
            increaseDeque();
        }
        if (head == 0)
            head = size;
        deque[--head] = i;
        items++;
    }

    private void increaseDeque(){
        size *= 2;
        int[] temp = new int[size];
        if (tail >= head) {
            System.arraycopy(deque, 0, temp, 0, deque.length);
        } else {
            System.arraycopy(deque, 0, temp, 0, tail + 1);
            System.arraycopy(deque, head,
                    temp, size - (deque.length - head),
                    deque.length - head);
            head = size - (deque.length - head);
        }
        deque = temp;
    }

    public int removeFromHead() {
        if (isEmpty())
            throw new RuntimeException("Deque is empty");
        int temp = deque[head++];
        head %= size;
        items--;
        return temp;
    }

    public int removeFromTail(){
        if (isEmpty())
            throw new RuntimeException("Deque is empty");
        int temp = deque[tail--];
        if (tail < 0)
            tail = size - 1;
        items--;
        return temp;
    }

    public int peek() {
        if (isEmpty())
            throw new RuntimeException("Deque is empty");
        return deque[head];
    }

    @Override
    public String toString() {
        if (items == 0)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = head; ; i++) {
            b.append(deque[i]);
            if (i == tail)
                return b.append(']').toString();
            b.append(", ");
            if (i == size - 1)
                i = -1;
        }
    }

    public void printDeque(){
        for (int i = 0; i < size; i++) {
            System.out.print(deque[i] + " ");
        }
        System.out.println("\nhead = " + head + " tail = " +
                tail + " items " + items + " size = " + size);
    }
}