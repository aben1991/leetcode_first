//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Java：字母异位词分组
public class P49GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new P49GroupAnagrams().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            long[] arr = new long[]{2, 3, 5, 7, 11,
                    13, 17, 19, 23, 29,
                    31, 37, 41, 43, 47,
                    53, 59, 61, 67, 71,
                    73, 79, 83, 89, 97,101};
            Map<Long, List<String>> map = new HashMap<>();
            List<List<String>> result = new ArrayList<>();
            for (int i = 0; i < strs.length; i++) {
                long tmp = 1;
                for (int j = 0; j < strs[i].length(); j++) {
                    char c = strs[i].charAt(j);
                    tmp = tmp * arr[c - 'a'];
                }
                List<String> list = map.get(tmp);
                if (list == null) {
                    list = new ArrayList<>();
                    result.add(list);
                    map.put(tmp, list);
                }
                list.add(strs[i]);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}