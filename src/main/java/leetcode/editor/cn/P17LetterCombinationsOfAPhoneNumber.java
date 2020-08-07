//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Java：电话号码的字母组合
public class P17LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new P17LetterCombinationsOfAPhoneNumber().new Solution();
        // TO TEST
        List<String> list = solution.letterCombinations("23");
        list.forEach(System.out::println);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        String[] a = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        public List<String> letterCombinations(String digits) {
            List<String> list = new ArrayList<>();
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < digits.length(); i++) {
                String str = a[digits.charAt(i) - '2'];
                for (int j = 0; j < str.length(); j++) {
                    if (list.isEmpty())
                    stack.push(str.charAt(j));

                    stack.pop();
                }
                list = letterCombinations(list, a[digits.charAt(i) - '2']);
            }
            return list;
        }

        private List<String> letterCombinations(List<String> list, String s) {
            List<String> result = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                if (list.isEmpty()) {
                    result.add("" + s.charAt(i));
                } else {
                    for (String str : list) {
                        result.add(str + s.charAt(i));
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}