import java.lang.reflect.Array;
import java.util.Arrays;

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

    /**
     * 买卖股票的最佳时机
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     *
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
     *
     * 注意你不能在买入股票前卖出股票。
     *
     * 示例 1:
     *
     * 输入: [7,1,5,3,6,4]
     * 输出: 5
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
     * 示例 2:
     *
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        //处理错误和特殊输入
        if(prices == null || prices.length == 0)
            return 0;


        //当只允许交易一次时，全局最优解等于局部最优解
//        int local = 0;
//        int global = 0;
//
//        for (int i = 0; i <prices.length-1 ; i++) {
//            //状态转移方程
//            local= Math.max(local+prices[i+1]-prices[i],0);
//            global = Math.max(local,global);

        //第二种解法
        //不断寻找最大的利润
        //遍历数组，动态的找到最小值，遍历每个数与最小值的差值
        int profit = 0;
        int min = prices[0];
        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(prices[i]- min,profit);
            min = Math.min(prices[i],min);
        }
        return profit;
        //return global;
    }


    /**
     * 最大子序和
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 示例:
     *
     * 输入: [-2,1,-3,4,-1,2,1,-5,4],
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     * 进阶:
     *
     * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
       //处理错误和特殊输入
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];

//
//        //第一种方法，暴力求解法
//        //时间复杂度为O(n^3)
//        //从第一个数字开始，以每个数字依次为起始，计算新的数组中最大值是多少
//        //每次遍历都能计算出新的数组中子数组的连续数字之和的最大值
//        int maxValue = nums[0];
//        for (int start = 0; start < nums.length ; start++) {
//            for (int end = start; end < nums.length; end++) {
//                int value = nums[end];
//                for (int index = start; index < end; index++) {
//                    value  += nums[index];
//                }
//                if(value > maxValue)
//                    maxValue = value;
//            }
//        }
//        return maxValue;

          //不是很对
//        //第二种解法
//
//        int maxSum = nums[0];
//        int thisSum = nums[0];
//
//        for (int i = 1; i < nums.length; i++) {
//
//
//            thisSum += nums[i];
//
//            if(thisSum < 0){
//                thisSum = 0;
//            }else if(thisSum > maxSum){
//                maxSum = thisSum;
//            }
//        }
//        return maxSum;

        //第三种解法
        /*
        * 求和，然后判断和是否小于0，如果小于0，后面的一个数加上这个数则必定小于后面的数
        * 所以又重新求和，并和之前的最大子序和相比较*/
        int sum = nums[0],maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if(sum < 0 )
                sum = 0;
            sum += nums[i];
            maxSum = Math.max(maxSum,sum);
        }
        return maxSum;
    }


    /**
     *  零钱兑换
     * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
     *
     * 示例 1:
     *
     * 输入: coins = [1, 2, 5], amount = 11
     * 输出: 3
     * 解释: 11 = 5 + 5 + 1
     * 示例 2:
     *
     * 输入: coins = [2], amount = 3
     * 输出: -1
     * 说明:
     * 你可以认为每种硬币的数量是无限的。
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {


        /*
        * 　很显然，这是一道动态规划问题。和第279完全平方数的解法如出一辙。

　　我们求11的硬币数，相当于求n=10,n=9,n=6的银币数中的最小值+1.

　　道理明白以后，这里我们倒着填并不是明智的。因为n=10,n=9,n=6的数据都是空的，同样前面的数也都是空的。

　　所以我们采取自下而上的填充测略，可以减省空间的消耗。*/
        //更容易理解的一种方法

        if(amount==0||coins.length<=0)
            return 0;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        Arrays.sort(coins);
        for(int i=1;i<=amount;i++)
        {
            for(int j=0;j<coins.length;j++)
            {
                if(i-coins[j]==0)
                    dp[i]=1;
                else if(i-coins[j]>0){

                    //不能兑换零钱的数值 i ， dp[i] 中存放的数字都是最大兑换数目 +1 ，防止了错误产生
                    dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];


  /*      //处理错误情况
        if(amount==0){
            return 0;
        }

        int len=coins.length;

        //dp数组存放兑换 i 元时所需要的最少数量
        //0-amount 为 amount+1 个
        int []dp=new int[amount+1];

        //给dp数组赋值，这里赋值赋超出最大兑换数量的值，不会对结果造成影响
        for(int p=1;p<amount+1;p++){
            dp[p]=p+1;
        }

        //兑换 0 元 所需的最少数量为 0
        dp[0]=0;

        //从 1 元到 amount 元遍历
        //依次表示兑换 i 元
        for(int i=1;i<=amount;++i){

            //h 不选择dp[i]时兑换钱的数量
            //初始一个不可能的数，即超出最大兑换数量的数
            int h=amount+1;

            //依次遍历 coins 中存放的钱数
            for(int j=0;j<len;++j){

                //如果 coins[j] 小于 i 元钱，表示能够兑换
                //同时需要兑换 i-coins[j]钱的数量不等于 -1，表示可以兑换
                // 都满足后，继续循环
                if(coins[j]<=i && dp[i-coins[j]]!=-1){

                    //不选择dp[i]，选择了dp[i-coins[j],兑换钱的数量要加 1
                    // 如果兑换 i-conins[j]钱的数量小于等于 h
                    if(dp[i-coins[j]]<=h){
                        h=dp[i-coins[j]];
                    }
                }
            }
            if(h<=i){
                dp[i]=h+1;
            }else{dp[i]=-1;}
        }
        return dp[amount];*/

    }


    /**
     * 跳跃游戏
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     *
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     *
     * 判断你是否能够到达最后一个位置。
     *
     * 示例 1:
     *
     * 输入: [2,3,1,1,4]
     * 输出: true
     * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
     * 示例 2:
     *
     * 输入: [3,2,1,0,4]
     * 输出: false
     * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        /*
        思路
        * 如果nums数组中全部数字都不为0，肯定可以走到最后
        * 能走到位置n，需要能走到n-1的位置，
        * 能走到n-1的位置，需要能走到n-2的位置....
        * 能走到2的位置，需要1的位置不为0   此为边界条件
        * */

        //处理错误及特殊情况
        if(nums.length == 1 )
            return true;

        //开始计算
        int length = nums.length;
        boolean[] jump = new boolean[length ];
        jump[0] = true;

        for (int i = 0; i < length; i++) {
            if (jump[i]) {
                for (int j = i; j <= i + nums[i] && j < length ; j++) {
                    jump[j] = true;
                }
            }
        }
        return jump[length-1];
    }
    //类结束括号
}

