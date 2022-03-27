public class SinkingStackEffective<T> extends Stack<T> {
    private int size;

    @Override
    public boolean isEmpty() {
        return size==0;
    }
    @Override
    public void push(T elem) throws FullStackException {
        if (isFull()) {
            topIndex = 0;
        }else{
            size++;
        }
        array[topIndex++] = elem;
    }

    @Override
    public T pop() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException();
        if (topIndex==0 && !isEmpty()) {
            topIndex = array.length;
        }
        return array[--topIndex];
    }

}
