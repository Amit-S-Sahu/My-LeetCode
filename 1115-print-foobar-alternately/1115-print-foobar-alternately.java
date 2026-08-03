class FooBar {
    private int n;
    private static boolean current;
    private static boolean first;

    public FooBar(int n) {
        this.n = n;
        current = false;
        first = true;
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (current) wait();
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
            first = false;
            current = true;
            notifyAll();
        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {
        while (first) wait();
        for (int i = 0; i < n; i++) {
            while (!current) wait();
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            current = false;
            notifyAll();
        }
    }
}