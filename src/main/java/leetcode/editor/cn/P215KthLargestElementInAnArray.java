//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法


package leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

//Java：数组中的第K个最大元素
public class P215KthLargestElementInAnArray {

    public static void main(String[] args) {
        Solution solution = new P215KthLargestElementInAnArray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int findKthLargest(int[] nums, int k) {
            if (k <= 0 || k > nums.length) {
                return -1;
            }
            int start = 0;
            int end = nums.length - 1;
            int index = -1;
            while (index != k - 1) {
                index = partition(nums, start, end);
                if (index >= k) {
                    end = index - 1;
                } else {
                    start = index + 1;
                }
            }
            return nums[index];
        }

        private int partition(int[] nums, int start, int end) {
            int i = start + 1;
            int j = end;
            while (i <= j) {
                while (i <= end && nums[i] > nums[start]) {
                    i++;
                }
                while (nums[j] < nums[start]) {
                    j--;
                }
                if (j <= i) {
                    break;
                }
                swap(nums, i, j);
                i++;
                j--;
            }
            swap(nums, start, j);
            return j;
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        public int findKthLargest1(int[] nums, int k) {
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k,
                Comparator.comparingInt(Integer::intValue));
            for (int i : nums) {
                if (priorityQueue.size() < k) {
                    priorityQueue.add(i);
                } else {
                    Integer peek = priorityQueue.peek();
                    if (i > peek) {
                        priorityQueue.poll();
                        priorityQueue.add(i);
                    }
                }
            }
            return priorityQueue.peek();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}