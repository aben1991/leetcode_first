//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。 
//
// 示例 1: 
//
// 输入: "(()"
//输出: 2
//解释: 最长有效括号子串为 "()"
// 
//
// 示例 2: 
//
// 输入: ")()())"
//输出: 4
//解释: 最长有效括号子串为 "()()"
// 
// Related Topics 字符串 动态规划


package leetcode.editor.cn;

import java.util.Stack;

//Java：最长有效括号
public class P32LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new P32LongestValidParentheses().new Solution();
        // TO TEST
        int i = solution.longestValidParentheses("()()(()()()(()()()())");
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int longestValidParentheses(String s) {
            Stack<Integer> stack = new Stack<>();
            int[] a = new int[s.length()];
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                } else if (s.charAt(i) == ')' && !stack.isEmpty()) {
                    Integer pop = stack.pop();
                    a[pop] = i - pop + 1;
                }
            }
            int max = 0;
            int length = 0;
            int i = 0;
            while (i < s.length()) {
                if (a[i] == 0) {
                    if (length > max) {
                        max = length;
                    }
                    length = 0;
                    i++;
                } else {
                    length = length + a[i];
                    i = i + a[i];
                }
            }

            return Math.max(max, length);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}