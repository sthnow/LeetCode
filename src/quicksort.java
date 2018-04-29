import com.sun.deploy.util.ArrayUtil;

public class quicksort {

    private int[] less;
    quicksort qs = new quicksort();
    private int[] greater;

    public int[] sort(int[] num){
        /**
         * 使用了递归的思想
         * 步骤
         *      1.基线条件：若数组中的数小于2，则结束递归（若数组中只有一个数就不用排序）
         *      2.递归条件：在数组中选取一个基准值，将数组分为小于该基准的部分和大于该基准的部分
         */
        int[] basenum = new int[]{num[0]};
        if(num.length <2){
            return num;
        }else{
            for (int i = 0; i < num.length; i++) {
                int base = num[0];
                if( base >= num[i]){
                    int[] less = new int[i];
                    less[i] = num[i+1];
                }

                if(base <= num[i]){
                    int[] greater = new int[num.length - i];
                    greater[i] = num[num.length - 1 - i];
                }

                //合并数组
                for (int j = 0; j <  ; j++) {

                }
            }
        }
    }
}
