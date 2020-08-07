//给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？ 
//
// 示例: 
//
// 输入: 3
//输出: 5
//解释:
//给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3 
// Related Topics 树 动态规划


package leetcode.editor.cn;

//Java：不同的二叉搜索树
public class P96UniqueBinarySearchTrees {

    public static void main(String[] args) {
        Solution solution = new P96UniqueBinarySearchTrees().new Solution();
        // TO TEST
        int i = solution.numTrees(3);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int[][] dp;

        public int numTrees(int n) {
            dp = new int[n][n];
            for (int i = 0; i < n; i++) {
                dp[i][i] = 1;
            }
            int num = 0;
            for (int i = 0; i < n; i++) {
                int left = numTrees(0, i - 1);
                int right = numTrees(i + 1, n - 1);
                num = num + left * right;
            }
            return num;
        }

        private int numTrees(int start, int end) {
            if (start > end) {
                return 1;
            }
            if (dp[start][end] != 0) {
                return dp[start][end];
            }

            int num = 0;
            for (int i = start; i <= end; i++) {
                int left = numTrees(start, i - 1);
                int right = numTrees(i + 1, end);
                num = num + left * right;
            }
            dp[start][end] = num;
            return num;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}