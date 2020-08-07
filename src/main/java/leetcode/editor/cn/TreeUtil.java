package leetcode.editor.cn;

import com.aben.TreeNode;
import java.util.LinkedList;

/**
 * @author sjp
 * @date 2020/07/30
 */
public class TreeUtil {


    public static TreeNode buildTree(Integer[] arr) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        TreeNode root = new TreeNode(arr[0]);
        linkedList.addLast(root);
        int i = 1;
        while (!linkedList.isEmpty() && i < arr.length) {
            TreeNode node = linkedList.pollFirst();
            if (arr[i] == null) {
                node.left = null;
            } else {
                node.left = new TreeNode(arr[i]);
                linkedList.addLast(node.left);
            }
            i++;
            if (arr[i] == null) {
                node.right = null;
            } else {
                node.right = new TreeNode(arr[i]);
                linkedList.addLast(node.right);
            }
            i++;
        }
        return root;
    }
}
