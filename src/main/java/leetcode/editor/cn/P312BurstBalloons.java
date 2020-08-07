//有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。 
//
// 现在要求你戳破所有的气球。如果你戳破气球 i ，就可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 lef
//t 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。 
//
// 求所能获得硬币的最大数量。 
//
// 说明: 
//
// 
// 你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。 
// 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100 
// 
//
// 示例: 
//
// 输入: [3,1,5,8]
//输出: 167 
//解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
//     coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
// 
// Related Topics 分治算法 动态规划


package leetcode.editor.cn;

//Java：戳气球
public class P312BurstBalloons {

    public static void main(String[] args) {
        Solution solution = new P312BurstBalloons().new Solution();
        // TO TEST
        int[] a = new int[]{3, 1, 5, 7, 4, 7};
        int i = solution.maxCoins(a);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        class Node {

            int val;
            Node pre;
            Node next;

            public Node(int v) {
                val = v;
            }

        }

        int max = 0;
        Node first = null;
        Node last = null;

        public int maxCoins(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return nums[0];
            }
            first = new Node(nums[0]);
            last = new Node(nums[nums.length - 1]);
            if (nums.length == 2) {
                return first.val * last.val + Math.max(first.val, last.val);
            }
            Node pre = first;
            for (int i = 1; i < nums.length - 1; i++) {
                Node node = new Node(nums[i]);
                node.pre = pre;
                pre.next = node;
                pre = node;
            }
            pre.next = last;
            last.pre = pre;
            calculate(first.next, last.pre, 0);
            max += first.val * last.val + Math.max(first.val, last.val);
            return max;
        }

        private void calculate(Node head, Node tail, int sum) {
            if (head == tail) {
                sum += this.first.val * head.val * this.last.val;
                if (sum > max) {
                    max = sum;
                }
                return;
            }
            Node current = head;
            while (current != this.last) {
                if (current == head) {
                    int val = this.first.val * current.val * current.next.val;
                    head = current.next;
                    head.pre = null;
                    calculate(head, tail, sum + val);
                    head.pre = current;
                    head = current;
                } else if (current == tail) {
                    int val = this.last.val * current.val * current.pre.val;
                    tail = current.pre;
                    tail.next = this.last;
                    calculate(head, tail, sum + val);
                    tail.next = current;
                    tail = current;
                } else {
                    Node pre = current.pre;
                    int val = pre.val * current.val * current.next.val;
                    pre.next = current.next;
                    current.next.pre = pre;
                    calculate(head, tail, sum + val);
                    pre.next.pre = current;
                    pre.next = current;
                }
                current = current.next;
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}