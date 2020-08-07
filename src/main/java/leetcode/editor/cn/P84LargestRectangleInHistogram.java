//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组


package leetcode.editor.cn;

import java.util.Stack;

//Java：柱状图中最大的矩形
public class P84LargestRectangleInHistogram {

    public static void main(String[] args) {
        Solution solution = new P84LargestRectangleInHistogram().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int largestRectangleArea(int[] heights) {
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);
            int index = 0;
            int max = 0;
            while (!stack.isEmpty()) {
                if (index < heights.length) {
                    while (stack.peek() != -1 && heights[stack.peek()] > heights[index]) {
                        Integer pop = stack.pop();
                        int area = heights[pop] * (index - 1 - stack.peek());
                        max = Math.max(max, area);
                    }
                    stack.push(index);
                    index++;
                } else {
                    Integer pop = stack.pop();
                    if (!stack.isEmpty()) {
                        int area = heights[pop] * (heights.length - 1 - stack.peek());
                        max = Math.max(max, area);
                    }
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}