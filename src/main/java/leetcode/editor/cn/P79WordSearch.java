//给定一个二维网格和一个单词，找出该单词是否存在于网格中。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例: 
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false 
//
// 
//
// 提示： 
//
// 
// board 和 word 中只包含大写和小写英文字母。 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 1 <= word.length <= 10^3 
// 
// Related Topics 数组 回溯算法


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：单词搜索
public class P79WordSearch {

    public static void main(String[] args) {
        Solution solution = new P79WordSearch().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        boolean[][] marked;

        public boolean exist(char[][] board, String word) {
            if (board.length == 0) {
                return false;
            }
            if (board.length * board[0].length < word.length()) {
                return false;
            }
            marked = new boolean[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    boolean r = dfs(board, i, j, word, 0);
                    if (r) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(char[][] board, int i, int j, String word, int index) {
            if (index >= word.length()) {
                return true;
            }
            if (board[i][j] != word.charAt(index)) {
                return false;
            }
            if (index == word.length() - 1) {
                return true;
            }
            marked[i][j] = true;
            List<int[]> list = getBoardList(board, i, j);
            for (int[] tmp : list) {
                if (!marked[tmp[0]][tmp[1]]) {
                    marked[tmp[0]][tmp[1]] = true;
                    boolean r = dfs(board, tmp[0], tmp[1], word, index + 1);
                    if (r) {
                        return r;
                    }
                    marked[tmp[0]][tmp[1]] = false;
                }
            }
            marked[i][j] = false;
            return false;
        }

        private List<int[]> getBoardList(char[][] board, int i, int j) {
            List<int[]> list = new ArrayList<>();
            if (i - 1 >= 0) {
                list.add(new int[]{i - 1, j});
            }
            if (j + 1 < board[0].length) {
                list.add(new int[]{i, j + 1});
            }
            if (i + 1 < board.length) {
                list.add(new int[]{i + 1, j});
            }
            if (j - 1 >= 0) {
                list.add(new int[]{i, j - 1});
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}