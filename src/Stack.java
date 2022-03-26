public class Stack<T> implements IStack<T> {
    private static final int DEFAULT_CAPACITY = 16;
    T array[];
    int topIndex;
    // klasy generyczne w zasadzie są typu Object
    // pozwalają jednak już na etapie kompilacji sprawdzać poprawność typów
    @SuppressWarnings("unchecked")
    public Stack (int initialSize){
        array=(T[])(new Object[initialSize]);
        topIndex=0;
    }
    public Stack (){
        this(DEFAULT_CAPACITY);
    }
    @Override
    public boolean isEmpty() {
        return topIndex==0;}
    @Override
    public boolean isFull() {
        return topIndex==array.length;}
    @Override
    public T pop() throws EmptyStackException {
        if(isEmpty())
            throw new EmptyStackException();
        return array[--topIndex];}
    @Override
    public void push(T elem) throws FullStackException {
        if(isFull())
            throw new FullStackException();
        array[topIndex++]=elem;}
    @Override
    public int size() {
        return topIndex;}
    @Override
    public T top() throws EmptyStackException {
        if(isEmpty())
            throw new EmptyStackException();
        return array[topIndex-1];}

    }
