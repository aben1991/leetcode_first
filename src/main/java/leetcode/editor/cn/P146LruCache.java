//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。 
//
// 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。 
//写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在
//写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
//
// 
//
// 进阶: 
//
// 你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例: 
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得关键字 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得关键字 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
// 
// Related Topics 设计


package leetcode.editor.cn;

import java.util.HashMap;

//Java：LRU缓存机制
public class P146LruCache {

    public static void main(String[] args) {
        // TO TEST
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class LRUCache {

        class Node {

            int key;
            int val;
            Node pre;
            Node next;

            Node(int k, int x) {
                key = k;
                val = x;
                next = null;
            }
        }

        HashMap<Integer, Node> hashMap;
        int size = 0;
        int capacity;
        Node head = new Node(-1, -1);
        Node tail = head;

        public LRUCache(int capacity) {
            hashMap = new HashMap<>(capacity);
            this.capacity = capacity;
        }

        public int get(int key) {
            Node node = hashMap.get(key);
            if (node == null) {
                return -1;
            }
            moveToFirst(node);
            return node.val;
        }

        public void put(int key, int value) {
            if (capacity == 0) {
                return;
            }
            Node node = hashMap.get(key);
            if (node == null) {
                if (size == capacity) {
                    hashMap.remove(tail.key);
                    Node tmp = tail.pre;
                    tail.pre = null;
                    tail = tmp;
                    tail.next = null;
                } else {
                    size++;
                }
                node = new Node(key, value);
                node.pre = head;
                node.next = head.next;
                head.next = node;
                if (tail == head) {
                    tail = node;
                } else {
                    node.next.pre = node;
                }
                hashMap.put(key, node);
                return;
            }
            node.val = value;
            moveToFirst(node);
        }

        private void moveToFirst(Node node) {
            if (node.pre == head) {
                return;
            }
            if (tail == node) {
                tail = node.pre;
                tail.next = null;
            } else {
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }

            node.pre = head;
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}