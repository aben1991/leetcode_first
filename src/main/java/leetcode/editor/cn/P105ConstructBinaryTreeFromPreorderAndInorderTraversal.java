//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组


package leetcode.editor.cn;

import com.aben.TreeNode;

//Java：从前序与中序遍历序列构造二叉树
public class P105ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static void main(String[] args) {
        Solution solution = new P105ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
     * right; TreeNode(int x) { val = x; } }
     */
    class Solution {

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return buildTreeNode(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        private TreeNode buildTreeNode(int[] preorder, int pstart, int pend, int[] inorder,
            int istart, int iend) {
            if (pstart > pend) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[pstart]);
            int index = -1;
            for (int i = istart; i <= iend; i++) {
                if (preorder[pstart] == inorder[i]) {
                    index = i;
                    break;
                }
            }
            int leftLength = index - istart;
            root.left = buildTreeNode(preorder, pstart + 1, pstart + leftLength, inorder,
                istart, index - 1);
            root.right = buildTreeNode(preorder, pstart + leftLength + 1, pend, inorder,
                index + 1, iend);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}