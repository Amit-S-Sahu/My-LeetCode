class ZeroEvenOdd {
    private int n;
    private int curr = 1;
    private boolean zero = true;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            while (!zero && curr <= n) wait();
            if (curr > n) {
                notifyAll();
                return;
            }
            printNumber.accept(0);
            zero = false;
            notifyAll();
        }
    }

    public synchronized void even(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            while ((zero || (curr & 1) == 1) && curr <= n) wait();
            if (curr > n) {
                notifyAll();
                return;
            }
            printNumber.accept(curr++);
            zero = true;
            notifyAll();
        }
    }

    public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            while ((zero || (curr & 1) == 0) && curr <= n) wait();
            if (curr > n) {
                notifyAll();
                return;
            }
            printNumber.accept(curr++);
            zero = true;
            notifyAll();
        }
    }
}