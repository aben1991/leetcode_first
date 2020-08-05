//给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。 
//
// 示例 1: 
//
// 输入: n = 12
//输出: 3 
//解释: 12 = 4 + 4 + 4. 
//
// 示例 2: 
//
// 输入: n = 13
//输出: 2
//解释: 13 = 4 + 9. 
// Related Topics 广度优先搜索 数学 动态规划


package leetcode.editor.cn;

//Java：完全平方数
public class P279PerfectSquares {

    public static void main(String[] args) {
        Solution solution = new P279PerfectSquares().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int numSquares(int n) {
            int[] dp = new int[n + 1];
            dp[1] = 1;
            return numSquares(dp, n);
        }

        private int numSquares(int[] dp, int n) {
            if (dp[n] != 0) {
                return dp[n];
            }
            int m = (int) Math.sqrt(n);
            if (m * m == n) {
                dp[n] = 1;
                return dp[n];
            }
            int min = Integer.MAX_VALUE;
            for (int i = m; i >= 1; i--) {
                int tmp = numSquares(dp, n - i * i);
                if (tmp < min) {
                    min = tmp;
                }
            }
            dp[n] = min + 1;
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}