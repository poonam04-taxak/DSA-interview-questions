
import java.util.*;

// LRU Cache class
class LRUCache {
    class Node {
        int key, val;
        Node prev, next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private final int capacity;
    private Map<Integer, Node> map;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    private void addNode(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        Node before = node.prev;
        Node after = node.next;
        before.next = after;
        after.prev = before;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    private Node removeTail() {
        Node res = tail.prev;
        removeNode(res);
        return res;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            moveToHead(node);
        } else {
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addNode(newNode);

            if (map.size() > capacity) {
                Node tailNode = removeTail();
                map.remove(tailNode.key);
            }
        }
    }
}

public class TestLRUCache {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1); // cache: {1=1}
        cache.put(2, 2); // cache: {2=2, 1=1}
        System.out.println(cache.get(1)); // 1, moves 1 to front => {1=1, 2=2}

        cache.put(3, 3); // evicts 2, cache: {3=3, 1=1}
        System.out.println(cache.get(2)); // -1 (not found)

        cache.put(4, 4); // evicts 1, cache: {4=4, 3=3}
        System.out.println(cache.get(1)); // -1 (not found)
        System.out.println(cache.get(3)); // 3, moves 3 to front => {3=3, 4=4}
        System.out.println(cache.get(4)); // 4, moves 4 to front => {4=4, 3=3}
    }
}
