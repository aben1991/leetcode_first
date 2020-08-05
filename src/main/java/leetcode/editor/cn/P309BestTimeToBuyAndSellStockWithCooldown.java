//给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 示例: 
//
// 输入: [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
// Related Topics 动态规划


package leetcode.editor.cn;

//Java：最佳买卖股票时机含冷冻期
public class P309BestTimeToBuyAndSellStockWithCooldown {

    public static void main(String[] args) {
        Solution solution = new P309BestTimeToBuyAndSellStockWithCooldown().new Solution();
        // TO TEST
        int[] a = new int[]{1, 2, 3, 0, 2};
        int i = solution.maxProfit(a);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //0入1出2入休3出休
        public int maxProfit(int[] prices) {
            if (prices.length == 0) {
                return 0;
            }
            int pre0 = -prices[0];
            int pre1 = 0;
            int pre2 = -prices[0];
            int pre3 = 0;
            int current0 = 0;
            int current1 = 0;
            int current2 = 0;
            int current3 = 0;
            for (int i = 1; i < prices.length; i++) {
                current0 = pre3 - prices[i];
                current2 = Math.max(pre0, pre2);
                current1 = current2 + prices[i];
                current3 = Math.max(pre1, pre3);
                pre0 = current0;
                pre1 = current1;
                pre2 = current2;
                pre3 = current3;
            }
            return Math.max(current0, Math.max(current1, Math.max(current2, current3)));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}