//给出一个区间的集合，请合并所有重叠的区间。 
//
// 示例 1: 
//
// 输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
// Related Topics 排序 数组

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//Java：合并区间
public class P56MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new P56MergeIntervals().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals.length <= 1) {
                return intervals;
            }
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
            int current = 0;
            int next = 1;
            int start = intervals[current][0];
            int end = intervals[current][1];
            int num = 0;
            while (next < intervals.length) {
                int secondStart = intervals[next][0];
                int secondEnd = intervals[next][1];
                if (secondStart > end) {
                    intervals[num] = new int[]{start, end};
                    num++;
                    current = next;
                    start = intervals[current][0];
                    end = intervals[current][1];
                } else {
                    end = Math.max(end, secondEnd);
                }
                next++;
            }
            int[][] result = new int[num + 1][];
            intervals[num] = new int[]{start, end};
            System.arraycopy(intervals, 0, result, 0, num + 1);
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}