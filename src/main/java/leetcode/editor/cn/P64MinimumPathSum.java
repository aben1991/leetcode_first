//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 示例: 
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
// 
// Related Topics 数组 动态规划


package leetcode.editor.cn;

//Java：最小路径和
public class P64MinimumPathSum {

    public static void main(String[] args) {
        Solution solution = new P64MinimumPathSum().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minPathSum(int[][] grid) {
            if (grid.length == 0) {
                return 0;
            }
            int[] dp = new int[grid[0].length + 1];
            for (int j = 0; j < grid[0].length; j++) {
                dp[j + 1] = dp[j] + grid[0][j];
            }
            for (int i = 1; i < grid.length; i++) {
                dp[0] = dp[1];
                for (int j = 1; j <= grid[0].length; j++) {
                    dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j - 1];
                }
            }

            return dp[grid[0].length];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}