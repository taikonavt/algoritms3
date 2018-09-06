public class QueuePrioritized {
    int[] array;
    int tail;

    QueuePrioritized(int size){
        array = new int[size];
        tail = -1;
    }

    public void put(int value){
        try {
            tail++;
            array[tail] = value;
        } catch (ArrayIndexOutOfBoundsException e){
            throw new RuntimeException("Queue is full");
        }
    }

    public int get(){
        if (tail < 0)
            throw new RuntimeException("Queue is empty");

        int j = 0;
        int temp = array[j];
        for (int i = 1; i <= tail; i++) {
            if (array[i] < temp){
                temp = array[i];
                j = i;
            }
        }
        delete(j);
        return temp;
    }

    private void delete(int index) {
        if (index >= array.length || index < 0)
            throw new ArrayIndexOutOfBoundsException("" + index);
        System.arraycopy(array, index + 1, array, index, tail - index);
        tail--;
    }
}
