package algorithm.greed._402;

import java.util.Stack;

/**
 * 402. 移掉K位数字
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 * 注意:
 *
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 *
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 *
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 :
 *
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 */
public class RemoveKDigits {
    /*
    贪心+递归，
        最终结果的第一位一定在前k+1位，因为如果把前k位全部删了，那么结果就是以第k+1位开头的字符串。
        否则，前k位一定会剩下一些。因此结果集的首位一定在s[0..k]中。到底是几呢？当然是最小值咯。
     */
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<num.length(); i++)
        {
            int n = num.charAt(i) - '0';
            // 如果栈不空，且高位stack.peek()大于低位n，且可删除=>删除
            while (!stack.isEmpty() && n < stack.peek() && k!=0)
            {
                stack.pop();
                k--;
            }
            // 如果n!=0，入栈；如果n==0，但是栈不空，入栈
            if (n!=0 || !stack.isEmpty())
                stack.push(n);
        }

        // 遍历完，但是还没去掉k个数字
        while (!stack.isEmpty() && k!=0)
        {
            stack.pop();
            k--;
        }
        //如果刚好去掉k个数字后stack为空
        if (stack.isEmpty()) stack.push(0);

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<stack.size(); i++) sb.append(stack.get(i));

        return sb.toString();
    }
}
