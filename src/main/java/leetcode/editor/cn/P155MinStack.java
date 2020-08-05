//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) —— 将元素 x 推入栈中。 
// pop() —— 删除栈顶的元素。 
// top() —— 获取栈顶元素。 
// getMin() —— 检索栈中的最小元素。 
// 
//
// 
//
// 示例: 
//
// 输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// pop、top 和 getMin 操作总是在 非空栈 上调用。 
// 
// Related Topics 栈 设计


package leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeMap;

//Java：最小栈
public class P155MinStack {

    public static void main(String[] args) {
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {

        class Node {

            int val;

            public Node(int v) {
                val = v;
            }

            public int getVal() {
                return val;
            }
        }

        Stack<Node> stack = new Stack<>();
        PriorityQueue<Node> priorityQueue = new PriorityQueue(
            Comparator.comparingInt(Node::getVal));

        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        public void push(int x) {
            Node node = new Node(x);
            stack.push(node);
            priorityQueue.add(node);
        }

        public void pop() {
            if (stack.isEmpty()) {
                return;
            }
            Node node = stack.pop();
            priorityQueue.remove(node);
        }

        public int top() {
            if (stack.isEmpty()) {
                return -1;
            }
            Node peek = stack.peek();
            return peek.val;
        }

        public int getMin() {
            if (stack.isEmpty()) {
                return -1;
            }
            return priorityQueue.peek().val;
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}