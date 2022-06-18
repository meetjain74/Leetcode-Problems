class Node {
    int key,val;
    Node next,prev;
    
    public Node(int key,int val) {
        this.key = key;
        this.val = val;
    }
}

class DoubleList {
    Node head,tail;
    int size;
    
    public DoubleList() {
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    void addLast(Node x) {
        x.prev = tail.prev;
        x.next = tail;
        tail.prev.next = x;
        tail.prev = x;
        size++;
    }

    public void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }

    public Node removeFirst() {
        if (head.next == tail) {
            return null;
        }
        Node first = head.next;
        remove(first);
        return first;
    }

    public int getSize() {
        return size;
    }

}

class LRUCache {
    HashMap<Integer,Node> map;
    DoubleList cache;
    int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)){
            return -1;
        }
        Node temp = map.get(key);
        cache.remove(temp);
        cache.addLast(temp);
        return temp.val;
    }
    
    public void put(int key, int value) { 
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            cache.remove(temp);
        }
        else if (capacity == cache.getSize()){
            Node temp = cache.removeFirst();
            map.remove(temp.key);
        }
        
        Node curr = new Node(key,value);
        cache.addLast(curr);
        map.put(key,curr);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */