package algorithm.sort;


/**
 * 常见的排序算法
 * 说明：
 * 稳定的排序：当两个相同的数字经过排序以后不会改变排列顺序，那么这个算法就是稳定的
 */
public class SortAlgorithm {


    /**
     * 冒泡排序
     * - 将小的元素往前调或者把大的元素网后调，
     * - 因为在调整的过程中不会改变相等元素的排列顺序，因此冒泡排序也是一种稳定的算法
     */
    public int[] bubbleSort(int[] unsort) {
        if (unsort.length == 0) return unsort;

        for (int i = 0; i < unsort.length; i++) {
            for (int j = i + 1; j < unsort.length; j++) {
                if (unsort[i] > unsort[j]) {
                    int temp = unsort[i];
                    unsort[i] = unsort[j];
                    unsort[j] = temp;
                }
            }
        }
        return unsort;
    }

    /**
     * 选择排序
     * - 选择排序就是给当前位置选择一个数组中最小的元素，然后依次递推直到n-1个元素
     * - 选择排序是不稳定的排序
     *
     * @param unsort
     * @return
     */
    public int[] selectSort(int[] unsort) {
        if (unsort.length <= 1) return unsort;

        for (int i = 0; i < unsort.length; i++) {
            int min = unsort[i];
            int x = i;
            for (int j = i + 1; j < unsort.length; j++) {
                if (min > unsort[j]) {
                    min = unsort[j];
                    x = j;
                }
            }
            swap(unsort, i, x);
        }
        return unsort;
    }

    public void swap(int[] tempArr, int i, int j) {
        int temp = tempArr[i];
        tempArr[i] = tempArr[j];
        tempArr[j] = temp;
    }

    /**
     * 插入排序
     * 是在一个已经有序的小序列的基础上，一次插入一个元素。当然，刚开始这个有序的小序列只有1个元素，就是第一个元素。
     * 比较是从有序序列的末尾开始，也就是想要插入的元素和已经有序的最大者开始比起，
     * 如果比它大则直接插入在其后面，否则一直往前找直到找到它该插入的位置。
     * 如果碰见一个和插入元素相等的，那么插入元素把想插入的元素放在相等元素的后面。
     * 所以，相等元素的前后顺序没有改变，从原无序序列出去的顺序就是排好序后的顺序，
     * 所以插入排序是稳定的。
     *
     * @param unsort
     * @return
     */
    public int[] insertSort(int[] unsort) {
        if (unsort.length <= 1) return unsort;

        for (int i = 1; i < unsort.length; i++) {
            int j = i - 1;
            int x = unsort[i];

            while (j >= 0 && unsort[j] > x) {
                unsort[j + 1] = unsort[j];
                j--;
            }
            unsort[j + 1] = x;
        }
        return unsort;
    }


    public void quickSort(int[] unsort, int head, int tail) {

        //判断不合法的情况
        if (head >= tail || unsort == null || unsort.length <= 1)
            return;

        int i = head, j = tail, privot = unsort[(head + tail) / 2];

        while (i < j) {
            while (unsort[i] < privot) {
                i++;
            }

            while (unsort[j] > privot) {
                j--;
            }

            if (i < j) {
                int temp = unsort[j];
                unsort[j] = unsort[i];
                unsort[i] = temp;
                i++;
                j--;
            }
        }
        quickSort(unsort, head, i - 1);
        quickSort(unsort, j + 1, tail);
    }
}
