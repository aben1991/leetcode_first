//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 如果数组中不存在目标值，返回 [-1, -1]。 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4] 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1] 
// Related Topics 数组 二分查找

package leetcode.editor.cn;

//Java：在排序数组中查找元素的第一个和最后一个位置
public class P34FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new P34FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int index = findOne(nums, target);
            if (index == -1) {
                return new int[]{-1, -1};
            }
            int max = findFirstBigger(nums, index + 1, nums.length - 1, target);
            int min = findFirstSmaller(nums, 0, index - 1, target);
            return new int[]{min + 1, max - 1};
        }

        private int findFirstSmaller(int[] nums, int lo, int hi, int target) {
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (nums[mid] == target) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            return hi;
        }

        private int findFirstBigger(int[] nums, int lo, int hi, int target) {
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (nums[mid] == target) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            return lo;
        }

        private int findOne(int[] nums, int target) {
            int lo = 0;
            int hi = nums.length - 1;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[mid] < target) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}