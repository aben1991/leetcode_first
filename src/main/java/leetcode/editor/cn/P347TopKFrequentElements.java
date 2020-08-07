//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。 
// 你可以按任意顺序返回答案。 
// 
// Related Topics 堆 哈希表


package leetcode.editor.cn;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.PriorityQueue;

//Java：前 K 个高频元素
public class P347TopKFrequentElements {

    public static void main(String[] args) {
        Solution solution = new P347TopKFrequentElements().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        class Node implements Comparable {

            int key;
            int count;

            public Node(int k, int c) {
                this.key = k;
                this.count = c;
            }

            @Override
            public int compareTo(Object o) {
                Node node = (Node) o;
                return this.count - node.count;
            }
        }

        public int[] topKFrequent(int[] nums, int k) {
            if (k >= nums.length) {
                return nums;
            }
            Map<Integer, Node> countMap = new HashMap<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                Node node = countMap.get(nums[i]);
                if (node == null) {
                    node = new Node(nums[i], 0);
                    countMap.put(nums[i], node);
                }
                node.count = node.count + 1;
            }
            PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
            for (Node node : countMap.values()) {
                if (priorityQueue.size() == k) {
                    if (node.count > priorityQueue.peek().count) {
                        priorityQueue.poll();
                        priorityQueue.add(node);
                    }
                } else {
                    priorityQueue.add(node);
                }
            }
            int[] result = new int[k];
            for (int i = 0; i < k; i++) {
                result[i] = priorityQueue.poll().key;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}