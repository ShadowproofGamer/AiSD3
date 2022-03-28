public class SinkingStackEffective<T> extends Stack<T> {
    private int size = 0;
    public SinkingStackEffective(int initialSize){
        super(initialSize);
    }
    public SinkingStackEffective(){
        super();
    }
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
        else if (topIndex==0) {
            topIndex = array.length;
        }
        size--;
        return array[--topIndex];
    }

}
