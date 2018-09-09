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
    public int rec_opt_dp(int[] arr, int i) {


        int[] tem = new int[arr.length];
        tem[0] = arr[0];
        tem[1] = Math.max(arr[0], arr[1]);


        for (int j = 2; j <= i; j++) {
            int a = tem[j - 2] + arr[j];
            int b = tem[j - 1];
            tem[j] = Math.max(a, b);
        }

        //边界条件

//        if(i == 0)
//            return arr[0];
//        if(i == 1)
//            return Math.max(arr[0], arr[1]);


//        Map<Integer, Integer> tem = new HashMap<Integer, Integer>();
//        if(tem.containsKey(i)) {
//            return  tem.get(i);
//        }else{
//            tem.put(i,arr[i]);
        return tem[tem.length -1];
    }
}

