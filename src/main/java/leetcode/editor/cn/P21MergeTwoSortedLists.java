//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表


package leetcode.editor.cn;

//Java：合并两个有序链表
public class P21MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new P21MergeTwoSortedLists().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode preHead = new ListNode(-1);
            ListNode node = preHead;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    node.next = l1;
                    node = node.next;
                    l1 = l1.next;
                } else {
                    node.next = l2;
                    node = node.next;
                    l2 = l2.next;
                }
            }
            if (l1 != null) {
                node.next = l1;
            } else {
                node.next = l2;
            }
            return preHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}