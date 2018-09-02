import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ListQTest {
    @Before
    public void setUp() {
        //实例化listQ对象
        ListQ listQ = new ListQ();

        //实例化ListQTest对象
        ListQTest listQTest = new ListQTest();
        //实例化listnode对象，并添加结点
        ListQ.ListNode listNode = new ListQ.ListNode(1);
        listNode.addNode(2);
        listNode.addNode(3);


        ListQ.ListNode listNode1 = new ListQ.ListNode(5);
        listNode1.addNode(6);
        listNode1.addNode(4);


//        ListQ.ListNode l1 = new ListQ.ListNode(1);
//        l1.addNode(2);
//        l1.addNode(3);
//
//        ListQ.ListNode l2 = new ListQ.ListNode(1);

//        l2.addNode(3);
//        l2.addNode(4);


        /*
        * 以下都是调用的方法
        *
        * */

//        listQ.mergeTwoLists(l1,l2).printList();

//奇偶链表
//        listQ.oddEvenList(listNode).printList();

//        两数相加
        listQ.addTwoNumbers(listNode,listNode1).printList();

////        打印链表
//
//        listNode.printList();
//        System.out.println();
//
//        /*
//        * 判断是否是回文字符串
//        *
//        * */
//        System.out.println(listQ.isPalindrome(listNode));
//


        //翻转链表
//        System.out.print("翻转之前：");
//        listNode.printList();
//        System.out.println();
//        System.out.print("翻转之后：");
//        listQ.reverseList(listNode).printList();

//        //链表的长度
//        System.out.println(listNode.length());


//        listQ.deleteNode(listNode);
//        listQ.removeNthFromEnd(listNode,2).printList();
 }

    @Test
    public void reverseList() {
    }


    @Test
    public void mergeTwoLists() {
    }

    @Test
    public void oddEvenList() {
    }

    @Test
    public void addTwoNumbers() {
    }
}