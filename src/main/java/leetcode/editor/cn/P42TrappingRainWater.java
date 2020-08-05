//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Mar
//cos 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针

package leetcode.editor.cn;

//Java：接雨水
public class P42TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new P42TrappingRainWater().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            if (height.length<3) {
                return 0;
            }
            int result = 0;
            int maxIndex = 0;
            int start = 0;
            int i;
            while (true) {
                while (height[start] == 0) {
                    start++;
                }
                i = start + 1;
                while (i < height.length && height[i] < height[start]) {
                    i++;
                }
                if (i >= height.length) {
                    break;
                }
                maxIndex = i;
                for (int j = start + 1; j < i; j++) {
                    result += height[start] - height[j];
                }
                start = i;
            }
            int end = height.length - 1;
            while (true) {
                while (height[end] == 0) {
                    end--;
                }
                i = end - 1;
                while (i >= maxIndex && height[i] < height[end]) {
                    i--;
                }
                if (i < maxIndex) {
                    break;
                }
                for (int j = i + 1; j < end; j++) {
                    result += height[end] - height[j];
                }
                end = i;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}