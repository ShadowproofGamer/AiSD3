public class FlawiusQueue {
    Queue<Integer> q1;
    Queue<Integer> q2;
    int temp = 0;
    int step = 0;

    public FlawiusQueue(int n, int k) {
        q1 = new Queue<>(n);
        q2 = new Queue<>(n);
        try {
            for (int i = 1; i <= n; i++) {
                q1.enqueue(i);
                System.out.println(i);
            }
            while (!q1.isEmpty() || !q2.isEmpty()) {
                int steptmp = 0;
                int s = q1.size();
                if (q1.size()<k){
                    for (int i = 1; i < s; i++) {
                        if ((i+step) % k == 0) {
                            temp = q1.dequeue();
                            steptmp = 0;
                        } else {
                            q2.enqueue(temp = q1.dequeue());
                            steptmp += 1;
                        }
                        temp = q1.dequeue();
                    }
                    break;
                }
                for (int i = 1 + step; i <= s + step; i++) {
                    if (i % k == 0) {
                        temp = q1.dequeue();
                        steptmp = 0;
                    } else {
                        q2.enqueue(temp = q1.dequeue());
                        steptmp += 1;
                    }
                    System.out.println(temp+" : "+steptmp+" : "+ q2.size());
                }
                q1 = q2;
                q2 = new Queue<>(n);
                step = steptmp;
            }
            System.out.println("Zostanie osoba nr: "+temp);
        } catch(FullQueueException | EmptyQueueException e){
            e.printStackTrace();
            System.out.println("Queue exception");
        }


    }
}
