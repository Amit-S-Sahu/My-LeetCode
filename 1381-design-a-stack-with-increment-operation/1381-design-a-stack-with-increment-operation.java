class CustomStack {
    int stack[];
    static int max;
    int size;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        this.size = -1;
        this.max = maxSize;
    }
    
    public void push(int x) {
        if (size == max - 1) return;
        stack[++size] = x;
    }
    
    public int pop() {
        if (size == -1) return -1;
        return stack[size--];
    }
    
    public void increment(int k, int val) {
        if (k > size + 1) k = size + 1;
        for (int i = 0; i < k; i++) {
            stack[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */