//合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。 
//
// 示例: 
//
// 输入:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//输出: 1->1->2->3->4->4->5->6 
// Related Topics 堆 链表 分治算法


package leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

//Java：合并K个排序链表
public class P23MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new P23MergeKSortedLists().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length, Comparator.comparingInt(o -> o.val));
            ListNode preHead = new ListNode(-1);
            ListNode node = preHead;
            for (ListNode listNode : lists) {
                if (listNode != null) {
                    priorityQueue.add(listNode);
                }
            }
            ListNode poll;
            while (!priorityQueue.isEmpty()) {
                poll = priorityQueue.poll();
                node.next = poll;
                node = node.next;
                if (poll.next != null) {
                    priorityQueue.add(poll.next);
                }
            }
            return preHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}