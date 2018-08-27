public class ListQ {

    /* public ListNode printList(ListNode listNode){
         if(listNode == null)
             return null;
         while(listNode != null){
             System.out.println(listNode.data);
             listNode = listNode.next;
         }
     }
 */
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;

        ListNode pre = null;

        while (head != null) {
            //将下一个结点给tem
            ListNode tem = head.next;
            //将头结点指向null
            head.next = pre;
            //将当前结点给pre
            pre = head;
            //将下一个结点作为头结点
            head = tem;
        }
        return pre;
    }

    /**
     * 删除链表的倒数第N个节点
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     *
     * 示例：
     *
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     *
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     * 说明：
     *
     * 给定的 n 保证是有效的。
     *
     * 进阶：
     *
     * 你能尝试使用一趟扫描实现吗？
     * @param head
     * @param n
     * @return
     */
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//
//
//        if ( n <= 0) {
//            System.out.println("超出链表范围");
//            return null;
//        }
//        for (int i = 0; i < n; i++) {
//
//        }
//        return null;
//    }

    /**
     * 删除链表中的节点
     * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
     * <p>
     * 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
     * <p>
     * 4 -> 5 -> 1 -> 9
     * 示例 1:
     * <p>
     * 输入: head = [4,5,1,9], node = 5
     * 输出: [4,1,9]
     * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     * 示例 2:
     * <p>
     * 输入: head = [4,5,1,9], node = 1
     * 输出: [4,5,9]
     * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
     * 说明:
     * <p>
     * 链表至少包含两个节点。
     * 链表中所有节点的值都是唯一的。
     * 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
     * 不要从你的函数中返回任何结果。
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }


    /**
     * 环形链表
     * 给定一个链表，判断链表中是否有环。
     * <p>
     * 进阶：
     * 你能否不使用额外空间解决此题？
     */
    public boolean hasCycle(ListNode head) {
        //  if(head == null){
        //      return false;
        //  }
        //  int n = 0;
        //  ListNode first = head;
        // boolean flag = false;
        //  while(head.next != null  ){

        //
        //      if(head.next == first){
        //          flag = true;
        //          return flag;
        //      }
        //      head.next = head.next.next;
        //      if(n++ > 10000) return true;
        //  }
        //  return flag;

        ListNode fast = head, slow = head;
        if (head == null || head.next == null)
            return false;
        //使用快慢指针，如果存在环形链表，则快指针总会追上慢指针
        while (slow.next != null && fast.next.next != null) {
            //快指针在每次循环中总比慢指针多走一步
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        return false;
    }
}
