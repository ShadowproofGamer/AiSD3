public class VTS<T> extends Stack<T>{
    int cursor;
    @Override
    public T pop() throws EmptyStackException {
        if(isEmpty())
            throw new EmptyStackException();
        cursor = topIndex-1;
        return array[--topIndex];
    }
    public boolean down(){
        if (cursor==0)
            return false;
        --cursor;
        return true;
    }
    @Override
    public void push(T elem) throws FullStackException {
        if(isFull())
            throw new FullStackException();
        array[topIndex++]=elem;
        cursor = topIndex-1;
    }
    public T peek() throws EmptyStackException{
        if(isEmpty())
            throw new EmptyStackException();
        return array[cursor];
    }
}
