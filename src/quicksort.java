import java.lang.reflect.Array;
import java.util.Arrays;

public class quicksort {


    static quicksort qs = new quicksort();
    private int[] less;
    private int[] greater;

    public static void main(String[] args) {
        int[] result =qs.sort(new int[]{6,5,4,3,2,1});
        System.out.println(Arrays.toString(result));
    }

    public int[] sort(int[] num) {
        /**
         * 使用了递归的思想
         * 步骤
         *      1.基线条件：若数组中的数小于2，则结束递归（若数组中只有一个数就不用排序）
         *      2.递归条件：在数组中选取一个基准值，将数组分为小于该基准的部分和大于该基准的部分
         */
        //int[] basenum = new int[]{num[0]};
        int[] less = new int[0];
        int[] greater = new int[0];

        if (num.length < 2) {
            return num;
        } else {
            int[] combition = new int[0];
            for (int i = 0; i < num.length - 1; i++) {
                int base = num[0];
                if (base >= num[i]) {
                     less = new int[i + 1];
                    for (int j = 0; j <= i; j++) {
                        less[j] = num[j];
                    }
                }

                if (base < num[i]) {
                     greater = new int[i + 1];
                    for (int j = 0; j <= i; j++) {
                        less[j] = num[j];
                    }
                }

                //合并数组
                int length = less.length + 1 + greater.length;
                combition = new int[length];
                //将less放入数组
                for (int j = 0; j < less.length - 1; j++) {
                    combition[j] = less[j];
                }
                //将基准值放入数组
                combition[less.length] = base;
                //将greater放入数组
                for (int k = 0; k < greater.length - 1; k++) {
                    combition[less.length + 1 + k] = greater[k];
                }

                //返回合数组

            }
            return qs.sort(combition);
        }
    }
}
