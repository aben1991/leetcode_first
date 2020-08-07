package com.aben;

import java.util.Stack;

/**
 * @author sjp
 * @date 2020/07/15
 */
public class TreeTravel {

    public static void preTravel(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val);
        System.out.print(",");
        preTravel(head.left);
        preTravel(head.right);
    }

    public static void midTravel(TreeNode head) {
        if (head == null) {
            return;
        }
        midTravel(head.left);
        System.out.print(head.val);
        System.out.print(",");
        midTravel(head.right);
    }

    public static void backTravel(TreeNode head) {
        if (head == null) {
            return;
        }
        backTravel(head.left);
        backTravel(head.right);
        System.out.print(head.val);
        System.out.print(",");
    }

    public static void preTravelNoRepeat(TreeNode head) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            System.out.print(pop.val);
            System.out.print(",");
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
    }

    public static void midTravelNoRepeat(TreeNode head) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        TreeNode left = head.left;
        while (left != null || !stack.isEmpty()) {
            if (left != null) {
                stack.push(left);
                left = left.left;
                continue;
            }
            TreeNode pop = stack.pop();
            System.out.print(pop.val);
            System.out.print(",");
            if (pop.right != null) {
                stack.push(pop.right);
                left = pop.right.left;
            }
        }
    }

    public static void backTravelNoRepeat(TreeNode head) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        TreeNode left = head.left;
        while (left != null || !stack.isEmpty()) {
            if (left != null) {
                stack.push(left);
                left = left.left;
                continue;
            }
            TreeNode peek = stack.peek();
            if (peek.right != null) {
                stack.push(peek.right);
                left = peek.right.left;
                peek.right = null;
            } else {
                TreeNode pop = stack.pop();
                System.out.print(pop.val);
                System.out.print(",");
            }
        }
    }

    /**
     * @return
     * @ *        1
     * @ *     2       4
     * @ * 3         5   6
     * @ *   7
     */
    public static TreeNode initTree() {
        TreeNode head = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode leftleft = new TreeNode(3);
        TreeNode right = new TreeNode(4);
        TreeNode rightleft = new TreeNode(5);
        TreeNode rightright = new TreeNode(6);
        TreeNode leftleftright = new TreeNode(7);
        head.left = left;
        left.left = leftleft;
        leftleft.right = leftleftright;

        head.right = right;
        right.left = rightleft;
        right.right = rightright;
        return head;
    }

    public static void main(String[] args) {
        TreeNode treeNode = initTree();
        preTravel(treeNode);
        System.out.println("---------");
        treeNode = initTree();
        preTravelNoRepeat(treeNode);
        System.out.println("---------");
        treeNode = initTree();
        midTravel(treeNode);
        System.out.println("---------");
        treeNode = initTree();
        midTravelNoRepeat(treeNode);
        System.out.println("---------");
        treeNode = initTree();
        backTravel(treeNode);
        System.out.println("---------");
        treeNode = initTree();
        backTravelNoRepeat(treeNode);
        System.out.println("---------");
    }

}
