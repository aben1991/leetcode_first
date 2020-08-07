//给定一个经过编码的字符串，返回它解码后的字符串。 
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 
//
// 示例 1： 
//
// 输入：s = "3[a]2[bc]"
//输出："aaabcbc"
// 
//
// 示例 2： 
//
// 输入：s = "3[a2[c]]"
//输出："accaccacc"
// 
//
// 示例 3： 
//
// 输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
// 
//
// 示例 4： 
//
// 输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
// 
// Related Topics 栈 深度优先搜索


package leetcode.editor.cn;

import java.util.Stack;

//Java：字符串解码
public class P394DecodeString {

    public static void main(String[] args) {
        Solution solution = new P394DecodeString().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String decodeString(String s) {
            int i = 0;
            int count = 0;
            Stack<CharSequence> stack = new Stack<>();
            Stack<Integer> numStack = new Stack<>();

            StringBuilder stringBuilder = new StringBuilder();
            while (i < s.length()) {
                if (Character.isDigit(s.charAt(i))) {
                    while (s.charAt(i) != '[') {
                        count = count * 10 + s.charAt(i) - '0';
                        i++;
                    }
                    numStack.push(count);
                    count = 0;

                    stringBuilder.append(s.charAt(i));
                    stack.push(stringBuilder);
                    stringBuilder = new StringBuilder();
                } else if (s.charAt(i) == ']') {
                    while (stack.peek().charAt(0) != '[') {
                        stringBuilder.append(stack.pop());
                    }
                    stack.pop();
                    Integer pop = numStack.pop();
                    int length = stringBuilder.length();
                    for (int num = 0; num < pop - 1; num++) {
                        stringBuilder.append(stringBuilder, 0, length);
                    }
                    stack.push(stringBuilder);
                    stringBuilder = new StringBuilder();
                } else {
                    stringBuilder.append(s.charAt(i));
                    stack.push(stringBuilder);
                    stringBuilder = new StringBuilder();
                }
                i++;
            }
            while (!stack.isEmpty()) {
                stringBuilder.append(stack.pop());
            }
            return stringBuilder.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}