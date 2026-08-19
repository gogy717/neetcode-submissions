class LRUCache {
    private Map<Integer, Integer> map = new HashMap<>();
    private Queue<Integer> queue = new LinkedList<>();
    private int cacheSize;
    public LRUCache(int capacity) {
        cacheSize = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            queue.remove(key);
            queue.offer(key);
        }
        return map.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            queue.remove(key);
        }
        queue.offer(key);
        map.put(key, value);

        if (queue.size() > cacheSize) {
            int removed = queue.poll();
            map.remove(removed);
        }
    }
}
