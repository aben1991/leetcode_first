//给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。 
//
// 示例: 
//
// 输入:
//[
//  ["1","0","1","0","0"],
//  ["1","0","1","1","1"],
//  ["1","1","1","1","1"],
//  ["1","0","0","1","0"]
//]
//输出: 6 
// Related Topics 栈 数组 哈希表 动态规划


package leetcode.editor.cn;

import java.util.Stack;

//Java：最大矩形
public class P85MaximalRectangle {

    public static void main(String[] args) {
        Solution solution = new P85MaximalRectangle().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maximalRectangle(char[][] matrix) {
            if (matrix.length == 0) {
                return 0;
            }
            int[] a = new int[matrix[0].length];
            int max = 0;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == '0') {
                        a[j] = 0;
                    } else {
                        a[j] = a[j] + 1;
                    }
                }
                int area = getArea(a);
                max = Math.max(max, area);
            }
            return max;
        }

        private int getArea(int[] a) {
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);
            int index = 0;
            int max = 0;
            while (!stack.isEmpty()) {
                if (index < a.length) {
                    while (stack.peek() != -1 && a[stack.peek()] > a[index]) {
                        Integer pop = stack.pop();
                        int area = a[pop] * (index - 1 - stack.peek());
                        max = Math.max(max, area);
                    }
                    stack.push(index);
                    index++;
                } else {
                    Integer pop = stack.pop();
                    if (!stack.isEmpty()) {
                        int area = a[pop] * (a.length - 1 - stack.peek());
                        max = Math.max(max, area);
                    }
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}