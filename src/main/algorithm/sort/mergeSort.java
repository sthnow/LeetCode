package sort;

public class mergeSort {
    public int[] sort(int[] a, int l, int r) {
        int mid = (r + l) / 2;
//        分割结束条件：当左引用等于大于右引用时，表示分割完毕
        if (l < r) {
//        分割数组左边的部分
            sort(a, l, mid);
//        分割数组右边的部分
            sort(a, mid + 1, r);
//        归并并排序
            mergeSort(a, l, mid, r);
        }
            return a;
    }

    public void mergeSort(int[] a, int l, int mid, int r) {
        int low = l, high = mid + 1, i = 0;
        int[] tem = new int[r - l + 1];
//        终止条件，当左引用l走完数组，或者右引用走完数组
        while (low <= mid && high <= r) {
            if (a[low] < a[high]){
                tem[i] = a[low];
                i++; low++;
            }else {
                tem[i] = a[high];
                i++; high++;
            }
        }
//        如果左边数组没有比较完
        while(low <= mid){
            tem[i] = a[low];
            i++; low++;
        }
//        如果右边没有比较完
        while (high <= r){
            tem[i] = a[high];
            i++; high++;
        }
//        将排好序的子数组放到原数组对应的子数组位置中
        for (int j = 0; j < tem.length; j++) {
            a[j + l] = tem[j];
        }
    }
}
