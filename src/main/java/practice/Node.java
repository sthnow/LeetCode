package practice;

public class Node {
    public Object data;
    public Node next = null;

    public Node() {
    }

    public Node(Object data) {
        this.data = data;
    }

    public Node(Object data, Node node) {
        this.data = data;
        this.next = node;
    }

    /**
     以下方法均使用递归的方式
     */

    /**
     * 添加结点
     *
     * @param data
     */
//    public void addNode(Object data) {
//
//        if (this.next == null) {
//            this.next = new Node(data, null);
//        } else {
//            this.next.addNode(data);
//        }
//    }
//
//
//    public int length() {
//        if (this == null) return 0;
//        int count = 1;
//        if (this.next != null) {
//            count = this.next.length() + 1;
//        }
//        return count;
//    }


    /**
     * 以下方法均使用循环方法
     */

    /**
     * 使用循环的方式增加结点
     * @param data
     */
    public void addNode(Object data) {
        if (this.next == null)
            this.next = new Node(data);

        Node currentNode = this.next;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = new Node(data);
    }


    /**
     * 使用循环方法计算链表长度
     * @return
     */
    public int length(){
        //定义计数器
        int count = 0;
        Node currentNode = this;
        while(currentNode.next != null){
            currentNode = currentNode.next;
            count++;
        }
        return count;
    }
}
