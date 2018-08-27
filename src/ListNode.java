public class ListNode {
    //结点的属性
    public Object data;
    public ListNode next = null;

    //三个构造器
    public ListNode(Object data){this.data = data;}
    public ListNode(){}
    public ListNode(Object data,ListNode next){
        this.data = data;
        this.next = next;
    }

    //添加结点的方法
    public void addNode(Object data){
        if(this.next == null){
            this.next = new ListNode(data,null);
        }else{
            this.next.addNode(data);
        }
    }

    public void printList(){
        System.out.print(this.data);
        if(this.next != null){
            System.out.print("->");
            this.next.printList();

        }
    }
}
