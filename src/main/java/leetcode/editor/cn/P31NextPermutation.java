//实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须原地修改，只允许使用额外常数空间。 
//
// 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。 
//1,2,3 → 1,3,2 
//3,2,1 → 1,2,3 
//1,1,5 → 1,5,1 
// Related Topics 数组


package leetcode.editor.cn;

//Java：下一个排列
public class P31NextPermutation {
    public static void main(String[] args) {
        Solution solution = new P31NextPermutation().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            for (int i = nums.length - 2; i >= 0; i--) {
                if (nums[i] < nums[i + 1]) {
                    int index = findIndex(nums, i + 1, nums.length - 1, nums[i]);
                    swap(nums, i, index);
                    sort(nums, i + 1, nums.length - 1);
                    return;
                }
            }
            sort(nums, 0, nums.length - 1);
        }

        private int findIndex(int[] nums, int i, int j, int num) {
            while (i < j) {
                int mid = (i + j) / 2;
                if (nums[mid] <= num) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            }
            if (nums[i] > num) {
                return i;
            }
            return i - 1;
        }

        private void sort(int[] nums, int i, int j) {
            while (i < j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}