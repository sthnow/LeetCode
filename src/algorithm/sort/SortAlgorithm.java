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


}
