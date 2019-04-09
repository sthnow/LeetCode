package algorithm.greed._406;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 406. 根据身高重建队列
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 *
 * 注意：
 * 总人数少于1100人。
 *
 * 示例
 *
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class QueueReconstructionbyHeight {
    public static int[][] reconstructQueue(int[][] people) {
        /*
        先按照身高降序排列，排完以后第i个数组前面的身高都是大于或等于它，然后在根据k值插入到响应的位置即可
         */
        //首先要保证数组的行和列不为0，即people这个二维数组不能是个空数组
        if(people.length == 0 || people[0].length == 0)return new int[0][0];
        //按照身高降序排列，重写比较器
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        for(int[] i : people){
            list.add(i[1],i);
        }
        return list.toArray(new int[list.size()][]);
//        if (0 == people.length || 0 == people[0].length)
//            return new int[0][0];
//        //按照身高降序 K升序排序
//        Arrays.sort(people, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
//            }
//        });
//        List<int[]> list = new ArrayList<>();
//        //K值定义为 排在h前面且身高大于或等于h的人数
//        //因为从身高降序开始插入，此时所有人身高都大于等于h
//        //因此K值即为需要插入的位置
//        for (int[] i : people) {
//            list.add(i[1], i);
//        }
//        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int[][] people = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        System.out.println(reconstructQueue(people));
    }
}
