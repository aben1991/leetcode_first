//在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。 
//
// 示例 1: 
//
// 输入: 4->2->1->3
//输出: 1->2->3->4
// 
//
// 示例 2: 
//
// 输入: -1->5->3->4->0
//输出: -1->0->3->4->5 
// Related Topics 排序 链表


package leetcode.editor.cn;

//Java：排序链表
public class P148SortList {

    public static void main(String[] args) {
        Solution solution = new P148SortList().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list. public class ListNode { int val; ListNode next;
     * ListNode(int x) { val = x; } }
     */
    class Solution {

        public ListNode sortList(ListNode head) {
            return sortList(head, null);
        }

        private ListNode sortList(ListNode head, ListNode nextHead) {
            if (head == null) {
                return null;
            }
            if (head.next == nextHead) {
                return head;
            }
            ListNode fast = new ListNode(-1);
            fast.next = head;
            ListNode slow = new ListNode(-1);
            slow.next = head;
            while (fast != nextHead && fast.next != nextHead) {
                fast = fast.next.next;
                slow = slow.next;
            }
            slow = slow.next;
            ListNode listNode1 = sortList(head, slow);
            ListNode listNode2 = sortList(slow, nextHead);
            return merge(listNode1, slow, listNode2, nextHead);
        }

        private ListNode merge(ListNode listNode1, ListNode nextHead1, ListNode listNode2,
            ListNode nextHead2) {
            ListNode preHead = new ListNode(-1);
            ListNode tail = preHead;
            while (listNode1 != nextHead1 && listNode2 != nextHead2) {
                if (listNode1.val < listNode2.val) {
                    tail.next = listNode1;
                    tail = listNode1;
                    listNode1 = listNode1.next;
                } else {
                    tail.next = listNode2;
                    tail = listNode2;
                    listNode2 = listNode2.next;
                }
            }
            while (listNode1 != nextHead1) {
                tail.next = listNode1;
                tail = listNode1;
                listNode1 = listNode1.next;
            }
            tail.next = nextHead2;
            if (listNode2 != nextHead2) {
                tail.next = listNode2;
            }
            return preHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}