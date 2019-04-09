package algorithm.greed._435;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 435. 无重叠区间
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * <p>
 * 注意:
 * <p>
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 示例 1:
 * <p>
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 * <p>
 * 输出: 1
 * <p>
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 示例 2:
 * <p>
 * 输入: [ [1,2], [1,2], [1,2] ]
 * <p>
 * 输出: 2
 * <p>
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * 示例 3:
 * <p>
 * 输入: [ [1,2], [2,3] ]
 * <p>
 * 输出: 0
 * <p>
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 */
class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public class NonoverlappingIntervals {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if(intervals.length == 0 || intervals == null)
            return 0;

        //先对数组进行排序，按照y值的升序排列
        //y值相同的元素相邻，x大的坐标排在后面
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.end != o2.end) {
                    return o1.end < o2.end ? -1 : 1;
                }
                return o1.start < o2.start ? -1 : 1;
            }

        });
        //排完序后可以发现，如果后一个元素的start小于等于前一个元素的end，则表示包含在区间内
        int res = 1;
        int pre = 0;
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i].start >= intervals[pre].end){
                res++;
                pre = i;
            }
        }

        return intervals.length - res;
    }

}
