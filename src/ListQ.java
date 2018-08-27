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
        if(head == null)
            return null;

        ListNode pre = null;

        while(head != null){
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
}
