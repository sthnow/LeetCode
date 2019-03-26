package com.hauwei;

import java.util.Scanner;

/**
 * 坐标移动
 * 题目描述
 * 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
 *
 *
 *
 * 输入：
 *
 *
 *
 * 合法坐标为A(或者D或者W或者S) + 数字（两位以内）
 *
 *
 *
 * 坐标之间以;分隔。
 *
 *
 *
 * 非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
 *
 *
 *
 * 下面是一个简单的例子 如：
 *
 *
 *
 * A10;S20;W10;D30;X;A1A;B10A11;;A10;
 *
 *
 *
 * 处理过程：
 *
 *
 *
 * 起点（0,0）
 *
 *
 *
 * +   A10   =  （-10,0）
 *
 *
 *
 * +   S20   =  (-10,-20)
 *
 *
 *
 * +   W10  =  (-10,-10)
 *
 *
 *
 * +   D30  =  (20,-10)
 *
 *
 *
 * +   x    =  无效
 *
 *
 *
 * +   A1A   =  无效
 *
 *
 *
 * +   B10A11   =  无效
 *
 *
 *
 * +  一个空 不影响
 *
 *
 *
 * +   A10  =  (10,-10)
 *
 *
 *
 *
 *
 *
 *
 * 结果 （10， -10）
 *
 *
 * 输入描述:
 * 一行字符串
 *
 * 输出描述:
 * 最终坐标，以,分隔
 *
 * 示例1
 * 输入
 * 复制
 * A10;S20;W10;D30;X;A1A;B10A11;;A10;
 */

    public class ZuoBiaoYiDong  {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
            while (scanner.hasNext()) {
                String input = scanner.nextLine();
                System.out.println(move(input));
            }

            scanner.close();
        }

        private static String move(String input) {
            String[] steps = input.split(";");
            int[] result = new int[2];

            for (String step : steps) {
                move(step, result);
            }


            return result[0] + "," + result[1];
        }

        private static void move(String input, int[] result) {

            if (input.matches("(A|D|W|S)[0-9]{1,2}")) {
                // 方向
                char direction = input.charAt(0);
                // 步数
                int step = Integer.parseInt(input.substring(1));
                switch (direction) {
                    case 'A':
                        result[0] -= step;
                        break;
                    case 'D':
                        result[0] += step;
                        break;
                    case 'W':
                        result[1] += step;
                        break;
                    case 'S':
                        result[1] -= step;
                        break;
                }
            }
        }
    }
