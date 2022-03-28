public class Main {
    public static void main(String[] args) {

        //zad124();
        //zad3();
        zad5(41, 3);


    }
    public static void zad124(){
        System.out.println("Stacks test:");
        int _n = 6;
        Stack<Integer> st1 = new Stack<>(_n);
        SinkingStackEffective<Integer> st2 = new SinkingStackEffective<>(_n);
        SinkingStackUneffective<Integer> st3 = new SinkingStackUneffective<>(_n);
        try {
            for (int i = 0; i < _n; i++) {
                st1.push(i);
                st2.push(i);
                st3.push(i);
            }
            for (int i = _n; i < _n+4; i++) {
                st2.push(i);
                st3.push(i);
            }
            for (int i = 0; i < _n; i++) {
                System.out.println(st1.pop());
                System.out.println(st2.pop());
                System.out.println(st3.pop());
            }
        } catch (FullStackException e1) {
            System.out.println("FullStackException");
        } catch (EmptyStackException e2) {
            System.out.println("EmptyStackException");
        }
    }
    public static void zad3(){
        int num = 10;
        System.out.println("Two Stack Queue test:");
        TwoStackQueue<Integer> tsq = new TwoStackQueue<>(num);
        try {
            for (int i = 0; i < num; i++) {
                tsq.enqueue(i);
            }
            System.out.println(tsq.dequeue());
            System.out.println(tsq.dequeue());
            tsq.enqueue(431);
            tsq.enqueue(967);
            while (!tsq.isEmpty()){
                System.out.println(tsq.dequeue());
            }
        } catch (FullQueueException | EmptyQueueException e) {
            e.printStackTrace();
            System.out.println("QueueException");
        }
    }
    public static void zad5(int n, int k){
        FlawiusQueue fq = new FlawiusQueue(n, k);
    }
}
