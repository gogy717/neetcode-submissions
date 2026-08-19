

class LRUCache {
    private Map<Integer, Integer> map = new HashMap<>();
    private Queue<Integer> queue = new LinkedList<>();
    private int cacheSize;

    public LRUCache(int capacity) {
        cacheSize = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        // key 刚刚被访问，移动到队尾
        queue.remove(key);
        queue.offer(key);

        return map.get(key);
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            queue.remove(key);
        }

        map.put(key, value);
        queue.offer(key);

        if (queue.size() > cacheSize) {
            int removed = queue.poll();
            map.remove(removed);
        }
    }
}