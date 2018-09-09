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

    public boolean dp_subset(int[] arr,int S){
        boolean subset[][] = new boolean[arr.length][S+1];


            //subset[i].length 表示i行的列数
        for (int i = 0; i < subset[0].length ; i++) {
            subset[0][i] = false;
        }

        for (int i = 0; i < subset.length; i++) {
            subset[i][0] = true;

        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < S+1 ; j++) {
                if(arr[i] > j)
                    subset[i][j] = subset[i-1][j];
                else {
                    subset[i][j] = subset[i - 1][j - arr[i]] || subset[i -rec_subset() 1][j];
                }
            }
        }
        int i = subset.length - 1;
        int j = subset[subset.length - 1].length -1;
       return  subset[subset.length - 1][subset[subset.length - 1].length -1];
    }
}

