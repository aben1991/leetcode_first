//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import org.omg.PortableInterceptor.INACTIVE;

//Java：子集
public class P78Subsets {

    public static void main(String[] args) {
        Solution solution = new P78Subsets().new Solution();
        // TO TEST
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> subsets = solution.subsets(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

//        List<List<Integer>> result = new ArrayList<>();
//
//        public List<List<Integer>> subsets(int[] nums) {
//            Stack<Integer> stack = new Stack<>();
//            for (int i = 0; i < nums.length; i++) {
//                stack.push(nums[i]);
//                subsets(stack, nums, i + 1);
//                stack.pop();
//            }
//            result.add(new ArrayList<Integer>());
//            return result;
//        }
//
//        private void subsets(Stack<Integer> stack, int[] nums, int start) {
//            if (start >= nums.length) {
//                result.add(new ArrayList<>(stack));
//                return;
//            }
//            for (int i = start; i <= nums.length; i++) {
//                if (i < nums.length) {
//                    stack.push(nums[i]);
//                }
//                subsets(stack, nums, i + 1);
//                if (i < nums.length) {
//                    stack.pop();
//                }
//            }
//        }

        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<Integer>());
            int length;
            for (int i = nums.length - 1; i >= 0; i--) {
                length = result.size();
                for (int j = 0; j < length; j++) {
                    List<Integer> list = result.get(j);
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.addAll(list);
                    result.add(tmp);
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}