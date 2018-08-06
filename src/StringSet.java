public class StringSet {
    public void reverseString(String s) {
        //定义变量
        String rs = "";
        StringBuffer sb = new StringBuffer();
        String[] array = s.split("");
        String[] reArray = new String[array.length];

        //颠倒字符串
        for (int i = 0; i < array.length; i++) {
            reArray[i] = array[array.length - i];
            sb.append(reArray[i]);
        }
        rs = sb.toString();
        //输出
        System.out.println(rs);

    }
}

