public class ListQ {

    /* public ListQ.ListNode printList(ListQ.ListNode listNode){
         if(listNode == null)
             return null;
         while(listNode != null){
             System.out.println(listNode.data);
             listNode = listNode.next;
         }
     }
 */

    /**
     * 反转链表
     * 反转一个单链表。
     * <p>
     * 示例:
     * <p>
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * 进阶:
     * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
//        if (head == null)
//            return null;
//
//        ListNode pre = null;
//
//        while (head != null) {
//            //将下一个结点给tem
//            ListNode tem = head.next;
//            //将头结点指向null
//            head.next = pre;
//            //将当前结点给pre
//            pre = head;
//            //将下一个结点作为头结点
//            head = tem;
//        }
//        return pre;

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 删除链表的倒数第N个节点
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     * <p>
     * 示例：
     * <p>
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     * <p>
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     * 说明：
     * <p>
     * 给定的 n 保证是有效的。
     * <p>
     * 进阶：
     * <p>
     * 你能尝试使用一趟扫描实现吗？
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {


        if (n <= 0) {
            System.out.println("超出链表范围");
            return null;
        }

        ListNode preNode = new ListNode(0, head);
        ListNode tem = preNode;
        for (int i = 0; i < n; i++) {
            tem = tem.next;
        }

//      如果删除的是第一个结点
        if (tem.next == null) {
            head = head.next;
        }
        while (tem.next != null) {
            preNode = preNode.next;
            tem = tem.next;
        }
        preNode.next = preNode.next.next;

        return head;
    }

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
        /*
         * 通过循环判断
         * */
        //  if(head == null){
        //      return false;
        //  }
        //  int n = 0;
        //  ListQ.ListNode first = head;
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

        /*
         * 通过快慢指针判断
         * */
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

    /**
     * 合并两个有序链表
     * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * <p>
     * 示例：
     * <p>
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode head = null;
        ListNode cur = head;
        if ((int) l1.val <= (int) l2.val) {
            head = l1;
            cur = head;
            l1 = l1.next;
        } else {
            head = l2;
            cur = head;
            l2 = l2.next;
        }

        while (l1 != null && l2 != null) {
            /*注意这里的判断
             * 如果while中是或的关系，那么在if语句中必须先判断l1是否为null。
             * 如果在if中先判断的是l1的值，那么当l1为null的时候还比较值，就会发生空指针异常！！！*/
            if ((int) l1.val <= (int) l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }

        }
        while (l1 != null) {
            cur.next = l1;
            cur = cur.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            cur.next = l2;
            cur = cur.next;
            l2 = l2.next;
        }
        return head;

    }


    /**
     * 回文链表
     * 请判断一个链表是否为回文链表。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 1->2
     * 输出: false
     * 示例 2:
     * <p>
     * 输入: 1->2->2->1
     * 输出: true
     * 进阶：
     * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     *
     * @param head
     * @return
     */
    /*
     * 验证回文链表
     * 使用一个快指针，一个慢指针
     * 快指针一次走两步，慢指针一次走一步
     * 当快指针遍历完链表后，慢指针正好在链表的中间
     * */
    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null)
            return true;

        ListNode fast = head;
        ListNode slow = fast;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //将slow以后的链表翻转

        ListNode pre = null;

//      这句话很关键，如果这里slow没有next
        ListNode cur = slow.next;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

//      如果slow没有next，会在while这里报错
//        原因是头节点的指向本应是下一个结点，但是因为没有next的原因，将head结点也反向了
//         使得head结点成为翻转链表后的最后一个结点，head的next指向了null
//        而pre结点是反转后链表的头结点，一个头结点和尾结点遍历比较，很定会出现空指针异常
        while (pre != null) {
            if (pre.val != head.val) {
                return false;
            }
            pre = pre.next;
            head = head.next;
        }
        return true;
    }


    /**
     * 奇偶链表
     * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
     * <p>
     * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 1->2->3->4->5->NULL
     * 输出: 1->3->5->2->4->NULL
     * 示例 2:
     * <p>
     * 输入: 2->1->3->5->6->4->7->NULL
     * 输出: 2->3->6->7->1->5->4->NULL
     * 说明:
     * <p>
     * 应当保持奇数节点和偶数节点的相对顺序。
     * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
     *
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHeader = even;

        while(odd.next != null &&even.next != null  ){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
            odd.next = evenHeader;
        return head;

    }

















    /**
     * 单向链表静态内部类
     * 静态内部类可以访问外部类中除了private修饰的其他成员
     * 非静态内部类可以访问外部类中的一切成员
     */
    public static class ListNode {
        //结点的属性
        Object val;
        ListNode next = null;


        //三个构造器
        public ListNode(Object data) {
            this.val = data;
        }

        public ListNode() {
        }

        public ListNode(Object data, ListNode next) {
            this.val = data;
            this.next = next;
        }

        //添加结点的方法
        public void addNode(Object data) {
            if (this.next == null) {
                this.next = new ListNode(data, null);
            } else {
                this.next.addNode(data);
            }
        }

        public void printList() {
            System.out.print(this.val);
            if (this.next != null) {
                System.out.print("->");
                this.next.printList();
            }
        }

        public int length() {
            //第一种方法
            //如果传入的对象为null，返回长度0
            if (this == null)
                return 0;
            //如果不为null，起码链表的长度为1，如果该结点指向不为null，则长度+1
            int count = 1;
            if (this.next != null) {

                count = this.next.length();
            }


            return count + 1;


            //        int length = 0;
            //        ListQ.ListNode currentNode = this;
            //        if (this == null)
            //            return 0;
            //        while (currentNode != null) {
            //            length++;
            //            currentNode = currentNode.next;
            //        }
            //        return length;
        }


    }
}
