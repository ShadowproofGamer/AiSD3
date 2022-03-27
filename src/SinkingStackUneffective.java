public class SinkingStackUneffective<T> extends Stack<T>{
    @Override
    public void push(T elem) throws FullStackException {
        if(isFull()){
            for(int i=1;i<topIndex;i++){
                array[i-1]=array[i];
            }
            array[topIndex-1]=elem;
        }else{
            array[topIndex++]=elem;
        }

    }


}
