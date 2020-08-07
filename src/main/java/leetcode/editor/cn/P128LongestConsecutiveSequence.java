//给定一个未排序的整数数组，找出最长连续序列的长度。 
//
// 要求算法的时间复杂度为 O(n)。 
//
// 示例: 
//
// 输入: [100, 4, 200, 1, 3, 2]
//输出: 4
//解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。 
// Related Topics 并查集 数组


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：最长连续序列
public class P128LongestConsecutiveSequence {

    public static void main(String[] args) {
        Solution solution = new P128LongestConsecutiveSequence().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int longestConsecutive(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    nums[i] = i;
                    continue;
                }
                map.put(nums[i], i);
                int pre = nums[i] - 1;
                int next = nums[i] + 1;
                Integer preIndex = map.get(pre);
                if (preIndex != null) {
                    nums[preIndex] = i;
                }
                Integer nextIndex = map.get(next);
                if (nextIndex != null) {
                    nums[i] = nextIndex;
                } else {
                    nums[i] = i;
                }
            }
            int max = 0;
            int[] count = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                count[i] = getCount(nums, i, count);
                if (count[i] > max) {
                    max = count[i];
                }
            }
            return max;
        }

        private int getCount(int[] nums, int i, int[] count) {
            if (nums[i] == i) {
                return 1;
            }
            if (count[i] != 0) {
                return count[i];
            }
            return getCount(nums, nums[i], count) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}