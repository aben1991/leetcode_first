//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//Java：全排列
public class P46Permutations {
    public static void main(String[] args) {
        Solution solution = new P46Permutations().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            Stack<Integer> stack = new Stack<>();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            permute(list, stack);
            return result;
        }

        private void permute(LinkedList<Integer> list, Stack<Integer> stack) {
            if (list.size() == 0) {
                result.add(new ArrayList<>(stack));
                return;
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Integer num = list.removeFirst();
                stack.push(num);
                permute(list, stack);
                num = stack.pop();
                list.addLast(num);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}