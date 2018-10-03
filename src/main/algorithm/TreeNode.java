public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        //有参的构造方法
        TreeNode(int x) {val = x;}
}


class Soultion{
//    public boolean isValidBST(TreeNode root){
//        TreeNode parent = root;
//        TreeNode leftParent = root;
//        TreeNode rigthParent = root;
//
//        if(parent.left == null && parent.right != null){
//
//        }
//
//        if(parent.left != null && parent.right == null)
//        if(!(parent.left.val < parent.val && parent.val < parent.right.val)){
//            return false;
//        }
//    }


    public int maxDepth(TreeNode root){

        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.left == null) return maxDepth(root.right) + 1;
        if (root.right == null) return maxDepth(root.left) + 1;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;


    }
}
