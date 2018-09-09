package lists;

import java.util.Iterator;

public class DoubleLinkedListIterator implements Iterator{
    private DoubleLinkedList list;
    private DoubleLinkedList.Node currentNode;

    DoubleLinkedListIterator(DoubleLinkedList list){
        if (list.isEmpty()){
            throw new RuntimeException("List is empty!");
        } else {
            this.list = list;
            currentNode = list.head;
        }
    }

    @Override
    public boolean hasNext() {
        return currentNode.next != null;
    }

    public boolean hasPrevious(){
        return currentNode.previous != null;
    }

    @Override
    public Object next() {
        if (hasNext()) {
            currentNode = currentNode.next;
            return currentNode.c;
        }
        return null;
    }

    public Object previous(){
        if (hasPrevious()){
            currentNode = currentNode.previous;
            return currentNode.c;
        }
        return null;
    }

    public Object get(){
        return currentNode.c;
    }

    @Override
    public void remove() {
        if (hasPrevious()) {
            DoubleLinkedList.Node next = currentNode.next;
            DoubleLinkedList.Node previous = currentNode.previous;
            previous.next = next;
            if (next != null)
                next.previous = previous;
            currentNode = previous;
        }
        if (hasNext()){
            currentNode = currentNode.next;
            list.remove();
        }
    }

    public void reset(){
        currentNode = list.head;
    }
}
