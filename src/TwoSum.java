import java.util.Scanner;

public class TwoSum {


    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        Integer[] num = twoSum.input1();
        int target = twoSum.input2();
        String[] strings = twoSum.add(num, target);

        System.out.print("和对应的序号为:" + strings[0] + "," + strings[1]);
    }

    //输入数组的代码
    public Integer[] input1() {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数组的值:");
        String[] numS = sc.next().split(",");

        //先将字符数组转换成字符串,在使用Interger的parseInt方法将字符串转换成数字
        //  int num =  Integer.parseInt(String.valueOf(numS));
        //  return num;

        //将字符数组转换成int数组
        Integer[] num = new Integer[numS.length];
        for (int i = 0; i < numS.length; i++) {
            num[i] = Integer.valueOf(numS[i]);
        }
        return num;
    }

    //输入target值的代码
    public int input2() {
        System.out.println("请输入二者之和的值:");
        Scanner sc = new Scanner(System.in);
        String target = sc.next();
        sc.close();
        return Integer.valueOf(target);
    }

    //处理逻辑的代码
    public String[] add(Integer[] num, int target) {

        int i, j = 0;
        String[] strings = new String[2];
        outer:
        for (i = 0; i <= num.length - 1; i++) {
            for (j = i + 1; j <= num.length - 1; j++) {
                if (num[i] + num[j] == target) {
                    //一个break语句只能结束一个循环
                    //如果想要结束外层循环需要加outer标签
                    break outer;
                }
            }
        }
        /**
         * 异常有两种情况:
         *      1.目标值太大
         *      2.目标值太小
         * 处理这两种异常有两中方法
         *      1.要么在for循环里面遍历,先遍历一遍每个值的和是否能满足target,在遍历一遍寻找target的值
         *      2.要么在原来的代码末尾加上if语句,因为遍历寻找完成后,如果没能找到target的值,i和j的值都是5,根据这个特点可以加上
         *      下文的if语句,还有target太小的情况,从num[0]开始算起即可
         */
        if (num[i - 1] + num[j - 2] < target || num[0] + num[1] > target)
            throw new RuntimeException("数组内两个值之和不能等于对应的目标值");
        // System.out.println(i + "," + j);
        strings[0] = String.valueOf(i);
        strings[1] = String.valueOf(j);
        return strings;
    }
}

