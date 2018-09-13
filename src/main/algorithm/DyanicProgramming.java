public class DyanicProgramming {


    /**
     * 给出一个数组，选取其中的数字使得和为最大
     * 条件：选取一个数字后不能再选择相邻的两个数字
     *
     * @param arr
     * @param i
     * @return
     */


    //首先使用递归的方式解答
    public int rec_opt(int[] arr, int i) {

        //边界条件
        if (i == 0)
            return arr[0];
        if (i == 1)
            return Math.max(arr[0], arr[1]);

        //接下来使用递归的方式

        //选取了当前的数
        int a = rec_opt(arr, i - 2) + arr[i];

        //不选取当前的数
        int b = rec_opt(arr, i - 1);

        return Math.max(a, b);
    }


    /**
     * 给出一个数组，选取其中的数字使得和为最大
     *  条件：选取一个数字后不能再选择相邻的两个数字
     * 使用非递归的方式完成
     *
     * @param arr
     * @param i
     * @return
     */
    //使用非递归的方式完成
    public int opt_dp(int[] arr, int i) {


        int[] tem = new int[arr.length];
        tem[0] = arr[0];
        tem[1] = Math.max(arr[0], arr[1]);


        for (int j = 2; j <= i; j++) {
            int a = tem[j - 2] + arr[j];
            int b = tem[j - 1];
            tem[j] = Math.max(a, b);
        }


        return tem[tem.length -1];
    }



    /**
     * 给出一个数组和一个目标值，判断数组里的数之和能够等于目标值

     * @return
     */
    public boolean rec_subset(int[] arr, int i ,int s){
        if(i == 0)
            return   arr[0] == s ?  true :  false;
        else if(s == 0)
            return true;

        else if (arr[i] > s)
            return rec_subset(arr, i - 1, s);

        else
         return  rec_subset(arr,i-1,s-arr[i]) || rec_subset(arr,i-1,s);
    }


    /**
     * 给出一个数组和一个目标值，判断数组里的数之和能够等于目标值
     * @param arr   给出的一个数组
     * @param S     给出的目标值
     * @return
     */
    public boolean dp_subset(int[] arr,int S){
        boolean subset[][] = new boolean[arr.length][S+1];


            //subset[i].length 表示i行的列数
        for (int i = 0; i < subset[0].length ; i++) {
            subset[0][i] = false;
        }
        //subset.length表示行数
        for (int i = 0; i < subset.length; i++) {
            subset[i][0] = true;

        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < S+1 ; j++) {
                if(arr[i] > j)
                    subset[i][j] = subset[i-1][j];
                else {
                    //选择第i个数
                    subset[i][j] = subset[i - 1][j - arr[i]] || subset[i-1][j];
                }
            }
        }
        int i = subset.length - 1;
        int j = subset[subset.length - 1].length -1;
       return  subset[subset.length - 1][subset[subset.length - 1].length -1];
    }

    /**
     * 爬楼梯
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     *
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     *
     * 注意：给定 n 是一个正整数。
     *
     * 示例 1：
     *
     * 输入： 2
     * 输出： 2
     * 解释： 有两种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶
     * 2.  2 阶
     * 示例 2：
     *
     * 输入： 3
     * 输出： 3
     * 解释： 有三种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶 + 1 阶
     * 2.  1 阶 + 2 阶
     * 3.  2 阶 + 1 阶
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        //处理错误输入
        if(n < 1)
            return 0;

        //边界条件
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;


//        使用递归的方法
//        int way = 0;
//        way = climbStairs(n -1) + climbStairs(n -2);
//
//        return way;


        //使用动态规划法
        int[] way = new int[n];
        way[0] = 1;
        way[1] = 2;

        for (int i = 2; i <n ; i++) {
            way[i] = way[i-1] + way[i-2];
        }
        return way[n-1];
    }


    /**
     * 打家劫舍
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     *
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
     *
     * 示例 1:
     *
     * 输入: [1,2,3,1]
     * 输出: 4
     * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     * 示例 2:
     *
     * 输入: [2,7,9,3,1]
     * 输出: 12
     * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        //处理错误和特殊输入
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return Math.max(nums[0],nums[1]);

        //使用动态规划的方式
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

//        for (int i = 2; i < nums.length; i++) {
//            int a = nums[i-2] + nums[i];
//            int b = nums[i-1];
//            nums[i] = Math.max(a,b);
//        }

        for (int i = 2; i < nums.length ; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i],dp[i-1]);
        }
        return dp[dp.length-1];
    }


}

