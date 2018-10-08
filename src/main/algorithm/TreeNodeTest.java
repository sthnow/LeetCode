public class TreeNodeTest {
    public static <T> void main(String[] args) {
        TreeNode<T> treeNode = new TreeNode<T>();
        treeNode.val = 2;
        treeNode.left = new TreeNode<T>(3);
        treeNode.right = new TreeNode<T>(3);
 //       treeNode.left.left = new TreeNode<T>(4);
        Soultion soultion = new Soultion();

//        soultion.inOrder(treeNode);
//        soultion.preOrder(treeNode);
//        soultion.postOrder(treeNode);
//        soultion.PrintBinaryTreePreUnrecur(treeNode);
//        soultion.PrintBinaryTreeMidUnrecur(treeNode);
//        soultion.PrintBinaryTreeLayerUnrecur(treeNode);
        soultion.isSymmetric(treeNode);
    }


}








