

public class TreeNodeTest {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        treeNode.val = 2;
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(3);

        Soultion soultion = new Soultion();

//        soultion.inOrder(treeNode);
//        soultion.preOrder(treeNode);
        soultion.postOrder(treeNode);
    }



}
