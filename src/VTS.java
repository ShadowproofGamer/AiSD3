public class VTS<T> extends Stack<T>{
    public VTS(){
        super();
    }
    public VTS(int initialSize){
        super(initialSize);
    }
    int cursor;
    @Override
    public T pop() throws EmptyStackException {
        if(isEmpty())
            throw new EmptyStackException();
        cursor = --topIndex-1;
        return array[topIndex];
    }
    @Override
    public void push(T elem) throws FullStackException {
        if(isFull())
            throw new FullStackException();
        array[topIndex++]=elem;
        cursor = topIndex-1;
    }
    public boolean down(){
        if (cursor==0)
            return false;
        --cursor;
        return true;
    }
    public T peek() throws EmptyStackException{
        if(isEmpty())
            throw new EmptyStackException();
        return array[cursor];
    }
}
