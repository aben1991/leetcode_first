//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 注意: 
//不能使用代码库中的排序函数来解决这道题。 
//
// 示例: 
//
// 输入: [2,0,2,1,1,0]
//输出: [0,0,1,1,2,2] 
//
// 进阶： 
//
// 
// 一个直观的解决方案是使用计数排序的两趟扫描算法。 
// 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
// Related Topics 排序 数组 双指针


package leetcode.editor.cn;

//Java：颜色分类
public class P75SortColors {

    public static void main(String[] args) {
        Solution solution = new P75SortColors().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public void sortColors(int[] nums) {
            int i = 0;
            int j = nums.length - 1;
            while (i < nums.length && nums[i] == 0) {
                i++;
            }
            while (j >= i && nums[j] == 2) {
                j--;
            }
            int k = i;
            while (k <= j) {
                if (nums[k] == 2) {
                    swap(nums, k, j);
                    j--;
                } else if (nums[k] == 0) {
                    swap(nums, k, i);
                    i++;
                    k++;
                } else {
                    k++;
                }
            }
        }

        private void swap(int[] nums, int i, int j) {
            if (i == j) {
                return;
            }
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}