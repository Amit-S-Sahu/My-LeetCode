class LRUCache extends LinkedHashMap<Integer,Integer> {
    private final int cap;
    public LRUCache(int capacity){ 
        super(capacity, 0.75f, true); 
        this.cap = capacity; 
    }
    @Override protected boolean removeEldestEntry(Map.Entry<Integer,Integer> e){ 
        return size() > cap; 
    }

    public int get(int k){ 
        return super.getOrDefault(k, -1); 
    }

    public void put(int k, int v){ 
        super.put(k, v); 
    }
}
