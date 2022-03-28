public class TwoStackQueue<T> implements IQueue<T>{
    private Stack<T> st1;
    private Stack<T> st2;
    private int size = 16;
    public TwoStackQueue(int size){
        this.size=size;
        st1 = new Stack<>(size);
        st2 = new Stack<>(size);
    }
    public TwoStackQueue(){
        st1 = new Stack<>(size);
        st2 = new Stack<>(size);
    }
    @Override
    public boolean isEmpty() {
        return st1.isEmpty()&&st2.isEmpty();
    }

    @Override
    public boolean isFull() {
        return st1.isFull()||st2.isFull();
    }

    @Override
    public T dequeue() throws EmptyQueueException {
        try{
            stackToReverse();
            return st2.pop();
        }catch (FullStackException | EmptyStackException e){
            throw new EmptyQueueException();
        }
    }

    @Override
    public void enqueue(T elem) throws FullQueueException {
        try{
            stackToNormal();
            st1.push(elem);
        }catch (FullStackException | EmptyStackException e){
            throw new FullQueueException();
        }
    }

    @Override
    public int size() {
        return Math.max(st1.size(), st2.size());
    }

    @Override
    public T first() throws EmptyQueueException {
        return null;
    }
    private void stackToReverse() throws EmptyStackException, FullStackException {
        while (!st1.isEmpty()){
            st2.push(st1.pop());
        }
    }
    private void stackToNormal() throws EmptyStackException, FullStackException {
        while (!st2.isEmpty()){
            st1.push(st2.pop());
        }
    }
}
