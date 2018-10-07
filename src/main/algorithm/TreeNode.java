import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeNode<T> {
    int val;
    TreeNode<T> left;
    TreeNode<T> right;

    //有参的构造方法
    TreeNode(int x) { val = x; }

    TreeNode(){}
}


class Soultion<T> {


    /**
     * 验证二叉搜索树
     * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     * <p>
     * 假设一个二叉搜索树具有如下特征：
     * <p>
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     * 示例 1:
     * <p>
     * 输入:
     * 2
     * / \
     * 1   3
     * 输出: true
     * 示例 2:
     * <p>
     * 输入:
     * 5
     * / \
     * 1   4
     * / \
     * 3   6
     * 输出: false
     * 解释: 输入为: [5,1,4,null,null,3,6]。
     * 根节点的值为 5 ，但是其右子节点值为 4 。
     */

    //使用中序遍历的方式遍历二叉树
    public void inOrder(TreeNode<T> root, List<Integer> list){
        if(root == null) return;
        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);


    }


    public boolean isValidBST(TreeNode<T> root) {
        //将所用的数都保存到一个链表里，然后依次判断顺序

        //创建一个链表，用来保存二叉树中的所用数据
        List<Integer> list = new ArrayList<Integer>();

        //中序遍历二叉树，保存值到链表中
        inOrder(root,list);
        for (int i = 0; i < list.size() - 1; i++) {
            if(list.get(i) >= list.get(i+1)){
                return false;
            }
        }
        return true;

    }
    //在这种情况下只能比较一个节点及其子结点的大小顺序，保证这个是一个而二叉搜索树，而无法比较两个节点与其子节点的顺序，即无法保证整个树都是二叉搜索树
    //因此行不通
//        TreeNode parent = root;
//        int max = Integer.MIN_VALUE;
//        if(parent == null){
//            return true;
//        }
//        if (isValidBST(parent.left) && isValidBST(parent.right)) {
//
//            if (parent.left != null && parent.right != null) {
//                if (parent.left.val < parent.val && parent.val < parent.right.val && max < parent.left.val) {
//                    max = parent.right.val;
//                    return  true;
//                } else {
//                    return false;
//                }
//            } else if (parent.left == null && parent.right != null ) {
//                if ( parent.val < parent.right.val&& max < parent.val) {
//                    max = parent.right.val;
//                    return  true;
//                } else {
//                    return false;
//                }
//            } else if (parent.left != null && parent.right == null ) {
//                if (parent.left.val < parent.val&& max < parent.left.val ) {
//                    max = parent.val;
//                    return  true;
//                } else {
//                    return false;
//                }
//            } else {
//                return true;
//            }
//        }else{
//            return false;
//        }
//    }


    /**
     * 二叉树的最大深度
     * 给定一个二叉树，找出其最大深度。
     * <p>
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     * <p>
     * 说明: 叶子节点是指没有子节点的节点。
     * <p>
     * 示例：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回它的最大深度 3 。
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode<T> root) {

        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.left == null) return maxDepth(root.right) + 1;
        if (root.right == null) return maxDepth(root.left) + 1;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * 中序遍历二叉树
     * 中序遍历-左，根，右
     * @param root
     */
    public void inOrder(TreeNode<T> root){
        if(root == null) return;

        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }


    /**
     * 前序遍历二叉树
     * 前序遍历-根，左，右
     * @param root
     */
    public void preOrder(TreeNode<T> root){
        if(root == null) return;

        System.out.print(root.val + " ");

        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder(TreeNode<T> root){
        if(root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }





    /**
     * 二叉树的层次遍历
     * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
     * <p>
     * 例如:
     * 给定二叉树: [3,9,20,null,null,15,7],
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回其层次遍历结果：
     * <p>
     * [
     * [3],
     * [9,20],
     * [15,7]
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode<T> root) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null){
            return result;
        }
        recursion(root, result, 0);
        return result;
    }
    public void recursion(TreeNode<T> node, List<List<Integer>> list, int dep){
        if(node == null){
            return;
        }
        if(dep == list.size()){
            list.add(new ArrayList<Integer>());
        }
        list.get(dep).add(node.val);
        recursion(node.left, list, dep+1);
        recursion(node.right, list, dep+1);

    }
    //类结束括号


    /**
     *前序遍历二叉树（非递归）
     * @param root
     */
    public void PrintBinaryTreePreUnrecur(TreeNode<T> root){
        TreeNode treeNode = root;
        LinkedList<TreeNode> stack = new LinkedList<>();

        //当栈不为空，或者treenode ！= null的时候
        while(treeNode != null || !stack.isEmpty()){
            //如果当前节点不为空，压入栈中，并将左子节点给当前节点
            if(treeNode != null){
                stack.push(treeNode);
                System.out.print(treeNode.val + " ");
                treeNode = treeNode.left;
            }
            //如果当前左子节点为空，此时的栈顶元素是他的父节点
            //如果右子节点为空，此时的栈顶元素爷爷节点及以上

            //取出栈顶元素，将右子节点赋给他
            else{
                treeNode = stack.pop();
                treeNode = treeNode.right;
            }
        }
    }

    /**
     * 中序遍历二叉树
     * @param root
     */
    public void PrintBinaryTreeMidUnrecur(TreeNode<T> root){
        TreeNode<T> treeNode = root;

        //创建堆栈，用于存放遍历过程中的节点
        LinkedList<TreeNode> stack = new LinkedList<>();

        //当treenode != null 或者 stack不为空时，将左子节点给treenode

        while(treeNode != null || !stack.isEmpty()){
           if(treeNode != null){
               stack.push(treeNode);
               treeNode = treeNode.left;
           }


            //当左子节点为空时,弹出父节点
            //当右子节点为空时,弹出爷爷节点
            else{
               treeNode = stack.pop();
               System.out.print(treeNode.val);
               treeNode = treeNode.right;


           }
        }




    }


    //类结束括号
}
