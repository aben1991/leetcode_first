//给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。 
//
// 说明： 
//
// 
// 拆分时可以重复使用字典中的单词。 
// 你可以假设字典中没有重复的单词。 
// 
//
// 示例 1： 
//
// 输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
// 
//
// 示例 2： 
//
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
// Related Topics 动态规划


package leetcode.editor.cn;

import java.util.List;

//Java：单词拆分
public class P139WordBreak {

    public static void main(String[] args) {
        Solution solution = new P139WordBreak().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int[][] dp;

        public boolean wordBreak(String s, List<String> wordDict) {
            dp = new int[s.length()][wordDict.size()];
            return wordBreak(s, 0, s.length(), wordDict);
        }

        private boolean wordBreak(String s, int start, int end, List<String> wordDict) {
            if (start >= end) {
                return true;
            }
            boolean flag = true;
            for (int i = 0; i < wordDict.size(); i++) {
                if (dp[start][i] == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return false;
            }
            int index = -1;
            label:
            for (String word : wordDict) {
                index++;
                if (dp[start][index] == -1) {
                    continue;
                }
                if (dp[start][index] == 1) {
                    if (wordBreak(s, start + word.length(), end, wordDict)) {
                        return true;
                    }
                    continue;
                }
                if (word.length() > end - start) {
                    dp[start][index] = -1;
                    continue;
                }
                int tmp = start;
                for (int i = 0; i < word.length(); ) {
                    if (word.charAt(i) == s.charAt(tmp)) {
                        i++;
                        tmp++;
                    } else {
                        dp[start][index] = -1;
                        continue label;
                    }
                }
                dp[start][index] = 1;
                if (wordBreak(s, start + word.length(), end, wordDict)) {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}