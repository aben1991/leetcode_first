//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划


package leetcode.editor.cn;

//Java：乘积最大子数组
public class P152MaximumProductSubarray {

    public static void main(String[] args) {
        Solution solution = new P152MaximumProductSubarray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxProduct(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int[][] dp = new int[nums.length][2];
            dp[0][0] = nums[0];
            dp[0][1] = nums[0];
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int a = dp[i - 1][0] * nums[i];
                int b = dp[i - 1][1] * nums[i];
                if (a >= nums[i] && a >= b) {
                    dp[i][0] = a;
                    if (b > nums[i]) {
                        dp[i][1] = nums[i];
                    } else {
                        dp[i][1] = b;
                    }
                } else if (b >= nums[i] && b >= a) {
                    dp[i][0] = b;
                    if (a > nums[i]) {
                        dp[i][1] = nums[i];
                    } else {
                        dp[i][1] = a;
                    }
                } else {
                    dp[i][0] = nums[i];
                    if (a > b) {
                        dp[i][1] = b;
                    } else {
                        dp[i][1] = a;
                    }
                }
                if (dp[i][0] > max) {
                    max = dp[i][0];
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}