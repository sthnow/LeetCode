import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TreeNode<T> {
    int val;
    TreeNode<T> left;
    TreeNode<T> right;

    //有参的构造方法
    TreeNode(int x) {
        val = x;
    }

    TreeNode() {
    }
}


class Soultion<T> {


    private static boolean isSymmetrical(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }

        return isSymmetrical(left.left, right.right) && isSymmetrical(left.right, right.left);
    }

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
    public void inOrder(TreeNode<T> root, List<Integer> list) {
        if (root == null) return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);


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

    public boolean isValidBST(TreeNode<T> root) {
        //将所用的数都保存到一个链表里，然后依次判断顺序

        //创建一个链表，用来保存二叉树中的所用数据
        List<Integer> list = new ArrayList<Integer>();

        //中序遍历二叉树，保存值到链表中
        inOrder(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;

    }

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
     *
     * @param root
     */
    public void inOrder(TreeNode<T> root) {
        if (root == null) return;

        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    /**
     * 前序遍历二叉树
     * 前序遍历-根，左，右
     *
     * @param root
     */
    public void preOrder(TreeNode<T> root) {
        if (root == null) return;

        System.out.print(root.val + " ");

        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder(TreeNode<T> root) {
        if (root == null) return;

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
        if (root == null) {
            return result;
        }
        recursion(root, result, 0);
        return result;
    }
    //类结束括号

    public void recursion(TreeNode<T> node, List<List<Integer>> list, int dep) {
        if (node == null) {
            return;
        }
        if (dep == list.size()) {
            list.add(new ArrayList<Integer>());
        }
        list.get(dep).add(node.val);
        recursion(node.left, list, dep + 1);
        recursion(node.right, list, dep + 1);

    }

    /**
     * 前序遍历二叉树（非递归）
     *
     * @param root
     */
    public void PrintBinaryTreePreUnrecur(TreeNode<T> root) {
        TreeNode treeNode = root;
        LinkedList<TreeNode> stack = new LinkedList<>();

        //当栈不为空，或者treenode ！= null的时候
        while (treeNode != null || !stack.isEmpty()) {
            //如果当前节点不为空，压入栈中，并将左子节点给当前节点
            if (treeNode != null) {
                stack.push(treeNode);
                System.out.print(treeNode.val + " ");
                treeNode = treeNode.left;
            }
            //如果当前左子节点为空，此时的栈顶元素是他的父节点
            //如果右子节点为空，此时的栈顶元素爷爷节点及以上

            //取出栈顶元素，将右子节点赋给他
            else {
                treeNode = stack.pop();
                treeNode = treeNode.right;
            }
        }
    }

    /**
     * 中序遍历二叉树
     *
     * @param root
     */
    public void PrintBinaryTreeMidUnrecur(TreeNode<T> root) {
        TreeNode<T> treeNode = root;

        //创建堆栈，用于存放遍历过程中的节点
        LinkedList<TreeNode> stack = new LinkedList<>();

        //当treenode != null 或者 stack不为空时，将左子节点给treenode

        while (treeNode != null || !stack.isEmpty()) {
            if (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }


            //当左子节点为空时,弹出父节点
            //当右子节点为空时,弹出爷爷节点
            else {
                treeNode = stack.pop();
                System.out.print(treeNode.val);
                treeNode = treeNode.right;


            }
        }

    }



    /*
     * 层次遍历，非递归方式实现
     * */

    /*
     * 后序遍历二叉树（非递归）
     *
     */
    public void PrintBinaryTreeBacUnrecur(TreeNode<T> root) {
        class NodeFlag<T> {
            TreeNode<T> node;
            char tag;

            public NodeFlag(TreeNode<T> node, char tag) {
                super();
                this.node = node;
                this.tag = tag;
            }
        }
        LinkedList<NodeFlag<T>> stack = new LinkedList<>();
        TreeNode<T> p = root;
        NodeFlag<T> bt;
        //栈不空或者p不空时循环
        while (p != null || !stack.isEmpty()) {
            //遍历左子树
            while (p != null) {
                bt = new NodeFlag(p, 'L');
                stack.push(bt);
                p = p.left;
            }
            //左右子树访问完毕访问根节点
            while (!stack.isEmpty() && stack.getFirst().tag == 'R') {
                bt = stack.pop();
                System.out.print(bt.node.val);
            }
            //遍历右子树
            if (!stack.isEmpty()) {
                bt = stack.peek();

                //如果左子节点为空，将其父节点的状态改为 输出
                bt.tag = 'R';
                p = bt.node;

                //遍历到其右子节点，
                // 如果右子节点不为null，则继续向下遍历，状态为不可输出
                //如果左子节点为null，则输出其父节点，根据其父节点的状态判断是否输出
                p = p.right;
            }
        }
    }

    public void PrintBinaryTreeLayerUnrecur(TreeNode<T> root) {

        //遍历的时候，将遍历过的节点放在队列中
        //使用LinkedList实现队列

        LinkedList<TreeNode> queue = new LinkedList<>();

        TreeNode<T> treeNode;

        queue.push(root);

        while (!queue.isEmpty()) {
            treeNode = queue.removeFirst();
            System.out.println(treeNode.val);

            if (treeNode.left != null) {
                queue.addLast(treeNode.left);
            }

            if (treeNode.right != null) {
                queue.addLast(treeNode.right);
            }
        }
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {

        //新建一个总list
        List<List<Integer>> lists = new ArrayList<>();


        if (root == null)
            return null;
        //使用recursion函数迭代逐层,从左往右访问所有节点

        recursion2(lists, root, 0);
        return lists;

    }

    /**
     * 通过recursion函数迭代,将对应层数的节点放入对应的list中
     *
     * @param treenode
     * @param dep
     * @return
     */
    public List<List<Integer>> recursion2(List<List<Integer>> list, TreeNode<T> treenode, int dep) {

        //如果传入的节点为null,即上一个节点没有子节点

        if (treenode == null) return null;


        //如果传入的list没有对应的层数,新建对应该层的list
        if (list.size() == dep) {
            List<Integer> sublist = new ArrayList<>();
            list.add(sublist);
        }

        list.get(dep).add(treenode.val);

        //迭代放入节点
        recursion2(list, treenode.left, dep + 1);
        recursion2(list, treenode.right, dep + 1);

        return list;
    }

    /**
     * 对称二叉树
     * 给定一个二叉树，检查它是否是镜像对称的。
     * <p>
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     * <p>
     * 1
     * / \
     * 2   2
     * / \ / \
     * 3  4 4  3
     * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
     * <p>
     * 1
     * / \
     * 2   2
     * \   \
     * 3    3
     * 说明:
     * <p>
     * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return isSymmetrical(root, root);
    }

    /**
     * 中序遍历二叉树
     * 给定一个二叉树，返回它的中序 遍历。
     * <p>
     * 示例:
     * <p>
     * 输入: [1,null,2,3]
     * 1
     * \
     * 2
     * /
     * 3
     * <p>
     * 输出: [1,3,2]
     * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode<T> root) {
        //迭代算法

        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();

        TreeNode<T> treeNode = root;


        while (treeNode != null || !stack.isEmpty()) {
            if (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            } else {
                treeNode = stack.pop();
                list.add(treeNode.val);
                treeNode = treeNode.right;
            }

        }
        return list;
    }


    /**
     * 二叉树的锯齿形层次遍历——使用LinkedList实现
     * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     * <p>
     * 例如：
     * 给定二叉树 [3,9,20,null,null,15,7],
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回锯齿形层次遍历如下：
     * <p>
     * [
     * [3],
     * [20,9],
     * [15,7]
     * ]
     *
     * @param root
     * @return
     */

    public List<LinkedList<Integer>> zigzagLevelOrder(TreeNode root) {
        List<LinkedList<Integer>> allList = new LinkedList<>();

        recursion1(allList, root, 0);
        return allList;
    }


    //使用迭代的方法将节点的值放如linkedList中
    public List<LinkedList<Integer>> recursion1(List<LinkedList<Integer>> allList, TreeNode<T> treeNode, int dep) {
        //LinkedList为双向链表，可以被当作堆栈，队列或者双端队列使用
        /*
         * 实现方法
         *   如果dep为奇数，将节点的值添加到表尾
         *   如果dep为偶数，将节点的值添加到表头
         */

        if (treeNode == null) return null;


        if (dep == allList.size()) {
            LinkedList<Integer> subList = new LinkedList<>();
            allList.add(subList);
        }

        //如果dep为奇数
        if (dep % 2 != 0) {
            allList.get(dep).addFirst(treeNode.val);
        } else {
            allList.get(dep).addLast(treeNode.val);
        }

        recursion1(allList, treeNode.left, dep + 1);
        recursion1(allList, treeNode.right, dep + 1);

        return allList;
    }


    /**
     * 二叉树的锯齿形层次遍历——使用List实现
     * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     * <p>
     * 例如：
     * 给定二叉树 [3,9,20,null,null,15,7],
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回锯齿形层次遍历如下：
     * <p>
     * [
     * [3],
     * [20,9],
     * [15,7]
     * ]
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrderList(TreeNode root) {
        List<List<Integer>> allList = new LinkedList<>();

        recursionZig(allList, root, 0);
        return allList;
    }


    //使用迭代的方法将节点的值放如linkedList中
    public List<List<Integer>> recursionZig(List<List<Integer>> allList, TreeNode<T> treeNode, int dep) {
        //LinkedList为双向链表，可以被当作堆栈，队列或者双端队列使用
        /*
         * 实现方法
         *   如果dep为奇数，将节点的值添加到表尾
         *   如果dep为偶数，将节点的值添加到表头
         */

        if (treeNode == null) return null;


        if (dep == allList.size()) {
            List<Integer> subList = new LinkedList<>();
            allList.add(subList);
        }

        //如果dep为奇数
        if (dep % 2 != 0) {
            allList.get(dep).add(0, treeNode.val);
        } else {
            allList.get(dep).add(allList.get(dep).size(), treeNode.val);
        }

        recursionZig(allList, treeNode.left, dep + 1);
        recursionZig(allList, treeNode.right, dep + 1);

        return allList;
    }


    /**
     * 二叉搜索树中第K小的元素
     * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
     * <p>
     * 说明：
     * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: root = [3,1,4,null,2], k = 1
     * 3
     * / \
     * 1   4
     * \
     * 2
     * 输出: 1
     * 示例 2:
     * <p>
     * 输入: root = [5,3,6,2,4,null,null,1], k = 3
     * 5
     * / \
     * 3   6
     * / \
     * 2   4
     * /
     * 1
     * 输出: 3
     * 进阶：
     * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        /*
         * 思路：
         * 先将遍历二叉树，将二叉树的值放入ArrayList中
         * 然后再将ArrayList转化为数组，将输入排序，返回第 k 个值*/

        //处理特殊情况
        if (root == null)
            return 0;

        List<Integer> arraylist = new ArrayList<>();

        //通过中序遍历-非迭代的方式遍历二叉树
        //声明一个堆栈,使用LinkedList实现，用于中序遍历的中间过程

        List<TreeNode> linkedList = new LinkedList<>();

        while (root != null || !linkedList.isEmpty()) {
            if (root != null) {
                linkedList.add(root);
                root = root.left;
            } else {
                TreeNode treeNode = ((LinkedList<TreeNode>) linkedList).pollLast();

                //      System.out.println(treeNode.val );

                arraylist.add(treeNode.val);

                root = treeNode.right;
            }
        }

        Integer[] nums = arraylist.toArray(new Integer[arraylist.size()]);
        Arrays.sort(nums);
        System.out.println(nums[k - 1]);
        return nums[k - 1];


        /*网上的一种写法,性能更好
        * class Solution {
            int res = 0;
            int count = 0;
            public int kthSmallest(TreeNode root, int k) {
            count = k;
            dfs(root);
            return res;
         }
             public void dfs(TreeNode root){
            if(root == null)
                return;
            //if(root!=null){
            dfs(root.left);
            count--;
            if(count==0){
                res = root.val;
                return;
            }
            dfs(root.right);
    }
}*/
    }


    /**
     * 从前序与中序遍历序列构造二叉树
     * 根据一棵树的前序遍历与中序遍历构造二叉树。
     *
     * 注意:
     * 你可以假设树中没有重复的元素。
     *
     * 例如，给出
     *
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     * 返回如下的二叉树：
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, 0, inorder.length - 1);
    }

    /**
     * @param preorder 完整的先序遍历
     * @param inorder  完整的中序遍历
     * @param preSt    子树先序遍历起始点
     * @param inSt     子树中序遍历起始点
     * @param inEnd    子树中序遍历结束点
     * @return
     */
    private TreeNode build(int[] preorder, int[] inorder, int preSt, int inSt, int inEnd) {
        //递归临界点
        if (preSt > preorder.length - 1 || inSt > inEnd) {
            return null;
        }
        //先序遍历首节点为根节点
        TreeNode rootNode = new TreeNode(preorder[preSt]);
        //根节点在中序遍历的索引
        int rootIndex = 0;
        for (int i = inSt; i <= inEnd; i++) {
            if (inorder[i] == rootNode.val) {
                rootIndex = i;
                break;
            }
        }
        //左子树长度
        int leftLength = rootIndex - inSt;
        //右子树在完整先序遍历起始点
        int preStRight = preSt + leftLength + 1;
        int preStLeft = preSt + 1;

        rootNode.left = build(preorder, inorder, preStLeft, inSt, rootIndex - 1);
        rootNode.right = build(preorder, inorder, preStRight, rootIndex + 1, inEnd);
        return rootNode;
    }
    //类结束括号
}

