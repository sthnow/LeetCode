import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    //有参的构造方法
    TreeNode(int x) {
        val = x;
    }
}


class Soultion {


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
    public void inOrder(TreeNode root,List<Integer> list){
        if(root == null) return;
        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);


    }


    public boolean isValidBST(TreeNode root) {
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
    public int maxDepth(TreeNode root) {

        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.left == null) return maxDepth(root.right) + 1;
        if (root.right == null) return maxDepth(root.left) + 1;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


    //类结束括号
}
