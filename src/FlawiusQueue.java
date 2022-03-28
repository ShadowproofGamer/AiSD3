public class FlawiusQueue {
    Queue<Integer> q1;
    Queue<Integer> q2;
    int temp = 0;
    int step = 0;
    int k;

    public FlawiusQueue(int n, int k) {
        q1 = q2 = new Queue<>(n);
        this.k=k;
        try {
            for (int i = 1; i <= n; i++) {
                q1.enqueue(i);
                System.out.println(i);
            }
            while (!q1.isEmpty() || !q2.isEmpty()) {
                int steptmp = 0;
                for (int i = 1 + step; i <= q1.size() + step; i++) {
                    if (i % k == 0) {
                        temp = q1.dequeue();
                        steptmp = 0;
                    } else {
                        q2.enqueue(temp = q1.dequeue());
                        steptmp += 1;
                    }
                    System.out.println(temp+" : "+steptmp);
                }
                q1 = q2;
                q2 = new Queue<>(q1.size());
                step = steptmp;
            }
            System.out.println("Zostanie osoba nr: "+temp);
        } catch(FullQueueException | EmptyQueueException e){
            e.printStackTrace();
            System.out.println("Queue exception");
        }


    }
}
