//在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。 
//
// 示例: 
//
// 输入: 
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//
//输出: 4 
// Related Topics 动态规划


package leetcode.editor.cn;

import java.util.Stack;

//Java：最大正方形
public class P221MaximalSquare {

    public static void main(String[] args) {
        Solution solution = new P221MaximalSquare().new Solution();
        // TO TEST
        char[][] a = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        int i = solution.maximalSquare(a);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maximalSquare(char[][] matrix) {
            if (matrix.length == 0) {
                return 0;
            }
            int length = matrix[0].length;
            int[] a = new int[length];
            int max = 0;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < length; j++) {
                    if (matrix[i][j] == '0') {
                        a[j] = 0;
                    } else {
                        a[j] = a[j] + 1;
                    }
                }
                int area = getMaxArea(a);
                if (area > max) {
                    max = area;
                }
            }
            return max;
        }

        private int getMaxArea(int[] a) {
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);
            int max = 0;
            for (int i = 0; i < a.length; i++) {
                if (stack.peek() == -1 || a[i] >= a[stack.peek()]) {
                    stack.push(i);
                    continue;
                }
                while (stack.peek() != -1 && a[i] < a[stack.peek()]) {
                    Integer pop = stack.pop();
                    int length = Math.min(a[pop], i - 1 - stack.peek());
                    int area = length * length;
                    if (area > max) {
                        max = area;
                    }
                }
                stack.push(i);
            }
            while (stack.peek() != -1) {
                Integer pop = stack.pop();
                int length = Math.min(a[pop], a.length - 1 - stack.peek());
                int area = length * length;
                if (area > max) {
                    max = area;
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}