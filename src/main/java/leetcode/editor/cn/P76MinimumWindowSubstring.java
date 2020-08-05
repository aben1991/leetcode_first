//给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。 
//
// 示例： 
//
// 输入: S = "ADOBECODEBANC", T = "ABC"
//输出: "BANC" 
//
// 说明： 
//
// 
// 如果 S 中不存这样的子串，则返回空字符串 ""。 
// 如果 S 中存在这样的子串，我们保证它是唯一的答案。 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window


package leetcode.editor.cn;

//Java：最小覆盖子串
public class P76MinimumWindowSubstring {

    public static void main(String[] args) {
        Solution solution = new P76MinimumWindowSubstring().new Solution();
        // TO TEST
        String S = "ADOBECODEBANC", T = "ABC";
        String s = solution.minWindow(S, T);
        System.out.println(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String minWindow(String s, String t) {
            if (t.length() == 0) {
                return "";
            }
            int[] tArr = new int[128];
            for (int i = 0; i < t.length(); i++) {
                char c = t.charAt(i);
                tArr[c] = tArr[c] + 1;
            }
            int[] sArr = new int[128];
            int num = 0;
            int start = 0;
            int end = 0;
            int minStart = 0;
            int minEnd = -1;
            int minLength = Integer.MAX_VALUE;
            while (end < s.length()) {
                while (num < t.length() && end < s.length()) {
                    char c = s.charAt(end);
                    if (sArr[c] < tArr[c]) {
                        num++;
                    }
                    sArr[c] = sArr[c] + 1;
                    end++;
                }
                while (num == t.length()) {
                    while (start < end && tArr[s.charAt(start)] == 0) {
                        start++;
                    }
                    int length = end - start;
                    if (length < minLength) {
                        minLength = length;
                        minStart = start;
                        minEnd = end;
                    }
                    char c = s.charAt(start);
                    if (sArr[c] == tArr[c]) {
                        num--;
                    }
                    sArr[c] = sArr[c] - 1;
                    start++;
                }
            }
            if (minEnd == -1) {
                return "";
            }
            return s.substring(minStart, minEnd);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}