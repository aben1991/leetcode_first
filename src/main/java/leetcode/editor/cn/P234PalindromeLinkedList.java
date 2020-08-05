//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针


package leetcode.editor.cn;

//Java：回文链表
public class P234PalindromeLinkedList {

    public static void main(String[] args) {
        Solution solution = new P234PalindromeLinkedList().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list. public class ListNode { int val; ListNode next;
     * ListNode(int x) { val = x; } }
     */
    class Solution {

        public boolean isPalindrome(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            ListNode pre = null;
            ListNode tmp;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                tmp = slow.next;
                slow.next = pre;
                pre = slow;
                slow = tmp;
            }
            if (fast != null) {
                slow = slow.next;
            }
            while (slow != null && pre != null) {
                if (slow.val != pre.val) {
                    return false;
                }
                slow = slow.next;
                pre = pre.next;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}