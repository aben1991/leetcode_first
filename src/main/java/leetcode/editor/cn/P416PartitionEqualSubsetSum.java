//给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 注意: 
//
// 
// 每个数组中的元素不会超过 100 
// 数组的大小不会超过 200 
// 
//
// 示例 1: 
//
// 输入: [1, 5, 11, 5]
//
//输出: true
//
//解释: 数组可以分割成 [1, 5, 5] 和 [11].
// 
//
// 
//
// 示例 2: 
//
// 输入: [1, 2, 3, 5]
//
//输出: false
//
//解释: 数组不能分割成两个元素和相等的子集.
// 
//
// 
// Related Topics 动态规划


package leetcode.editor.cn;

//Java：分割等和子集
public class P416PartitionEqualSubsetSum {

    public static void main(String[] args) {
        Solution solution = new P416PartitionEqualSubsetSum().new Solution();
        // TO TEST
        int[] a = new int[]{1, 5, 2, 11, 2, 5};
        boolean b = solution.canPartition(a);
        System.out.println(b);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean canPartition(int[] nums) {
            int sum = 0;
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                max = Math.max(max, nums[i]);
            }
            if (sum % 2 != 0) {
                return false;
            }
            sum = sum / 2;
            if (max > sum) {
                return false;
            }
            if (max == sum) {
                return true;
            }
            return canPartition(nums, sum);
        }

        private boolean canPartition(int[] nums, int sum) {
            if (sum < 0) {
                return false;
            }
            if (sum == 0) {
                return true;
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == -1) {
                    continue;
                }
                int tmp = nums[i];
                nums[i] = -1;
                boolean b = canPartition(nums, sum - tmp);
                if (b) {
                    return true;
                }
                nums[i] = tmp;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}