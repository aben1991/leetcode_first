//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：三数之和
public class P15ThreeSum {
    public static void main(String[] args) {
        Solution solution = new P15ThreeSum().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> list;
            Arrays.sort(nums);
            int sum;
            for (int i = 0, j = i + 1, k = nums.length - 1; j < k; i = nextIndex(nums, i), j = i + 1, k = nums.length - 1) {
                if (nums[i] + nums[j] > 0) {
                    return result;
                }
                while (j < k) {
                    sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0) {
                        list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        result.add(list);
                        j = nextIndex(nums, j);
                        k--;
                    } else if (sum < 0) {
                        j = nextIndex(nums, j);
                    } else {
                        k--;
                    }
                }
            }
            return result;
        }

        private int nextIndex(int[] nums, int i) {
            int num = nums[i];
            for (i = i + 1; i < nums.length; i++) {
                if (nums[i] != num) {
                    return i;
                }
            }
            return i;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}