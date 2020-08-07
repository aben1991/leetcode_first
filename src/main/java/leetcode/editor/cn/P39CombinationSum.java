//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [2,3,6,7], target = 7,
//所求解集为:
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,3,5], target = 8,
//所求解集为:
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
// Related Topics 数组 回溯算法

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//Java：组合总和
public class P39CombinationSum {
    public static void main(String[] args) {
        Solution solution = new P39CombinationSum().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            Stack<Integer> stack = new Stack<>();
            combination(candidates, target, 0, stack);
            return result;
        }

        private void combination(int[] candidates, int target, int start, Stack<Integer> stack) {
            if (target == 0) {
                result.add(new ArrayList<>(stack));
                return;
            }
            for (int i = start; i < candidates.length; i++) {
                if (target < candidates[i]) {
                    break;
                }
                stack.push(candidates[i]);
                combination(candidates, target - candidates[i], i, stack);
                stack.pop();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}