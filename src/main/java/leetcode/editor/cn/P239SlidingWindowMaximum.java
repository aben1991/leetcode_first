//给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。 
//
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 进阶： 
//
// 你能在线性时间复杂度内解决此题吗？ 
//
// 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// -10^4 <= nums[i] <= 10^4 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Stack;

//Java：滑动窗口最大值
public class P239SlidingWindowMaximum {

    public static void main(String[] args) {
        Solution solution = new P239SlidingWindowMaximum().new Solution();
        // TO TEST
        int[] a = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] ints = solution.maxSlidingWindow(a, 2);
        System.out.println(1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums.length == 0 || k <= 1) {
                return nums;
            }
            int[] result = new int[nums.length - k + 1];
            LinkedList<Integer> linkedList = new LinkedList<>();
            int maxIndex = nums.length - 1;
            for (int i = nums.length - 2; i >= nums.length - k; i--) {
                if (nums[i] > nums[maxIndex]) {
                    maxIndex = i;
                    linkedList.clear();
                    continue;
                }
                while (linkedList.size() > 0 && nums[linkedList.peekLast()] < nums[i]) {
                    linkedList.pollLast();
                }
                linkedList.addLast(i);
            }
            result[nums.length - k] = nums[maxIndex];
            for (int i = nums.length - k - 1; i >= 0; i--) {
                if (nums[i] > nums[maxIndex]) {
                    maxIndex = i;
                    result[i] = nums[i];
                    linkedList.clear();
                    continue;
                }
                while (linkedList.size() > 0 && nums[linkedList.peekLast()] < nums[i]) {
                    linkedList.pollLast();
                }
                linkedList.addLast(i);
                if (maxIndex - i == k) {
                    maxIndex = linkedList.pollFirst();
                }
                result[i] = nums[maxIndex];
            }
            return result;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
