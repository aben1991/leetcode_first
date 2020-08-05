//给定一个二叉树，原地将它展开为一个单链表。 
//
// 
//
// 例如，给定二叉树 
//
//     1
//   / \
//  2   5
// / \   \
//3   4   6 
//
// 将其展开为： 
//
// 1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6 
// Related Topics 树 深度优先搜索


package leetcode.editor.cn;

import com.aben.TreeNode;

//Java：二叉树展开为链表
public class P114FlattenBinaryTreeToLinkedList {

    public static void main(String[] args) {
        Solution solution = new P114FlattenBinaryTreeToLinkedList().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
     * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
     * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
     */
    class Solution {

        public void flatten(TreeNode root) {
            flattenNode(root);
        }

        private TreeNode[] flattenNode(TreeNode root) {
            TreeNode[] nodes = new TreeNode[2];
            if (root == null) {
                return nodes;
            }
            TreeNode[] nodes1 = flattenNode(root.left);
            TreeNode[] nodes2 = flattenNode(root.right);
            if (nodes1[0] != null) {
                root.right = nodes1[0];
                nodes1[1].right = nodes2[0];
                root.left = null;
            }
            nodes[0] = root;
            if (nodes2[1] != null) {
                nodes[1] = nodes2[1];
            } else if (nodes1[1] != null) {
                nodes[1] = nodes1[1];
            } else {
                nodes[1] = root;
            }
            return nodes;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}