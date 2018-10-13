import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

public class TreeNodeTest {
    public static <T> void main(String[] args) {
        TreeNode<Integer> treeNode = new TreeNode<>();
        treeNode.val = 3;
        treeNode.left = new TreeNode<>(9);
        treeNode.right = new TreeNode<>(20);
        treeNode.right.left = new TreeNode<>(15);
        treeNode.right.right = new TreeNode<>(7);
        Soultion soultion = new Soultion();

//        soultion.inOrder(treeNode);
//        soultion.preOrder(treeNode);
//        soultion.postOrder(treeNode);
//        soultion.PrintBinaryTreePreUnrecur(treeNode);
//        soultion.PrintBinaryTreeMidUnrecur(treeNode);
//        soultion.PrintBinaryTreeLayerUnrecur(treeNode);
//        soultion.isSymmetric(treeNode);
//        soultion.zigzagLevelOrderList(treeNode);


    }


}








