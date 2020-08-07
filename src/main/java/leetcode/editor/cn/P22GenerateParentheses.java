//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：括号生成
public class P22GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new P22GenerateParentheses().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> list = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            generateParenthesis("", n, n);
            return list;
        }

        private void generateParenthesis(String s, int n, int m) {
            if (n == 0 && m == 0) {
                list.add(s);
            }
            if (n == m) {
                generateParenthesis(s + '(', n - 1, m);
            } else {
                if (n > 0) {
                    generateParenthesis(s + '(', n - 1, m);
                }
                generateParenthesis(s + ')', n, m - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}