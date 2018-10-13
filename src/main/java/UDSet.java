import java.util.HashSet;
import java.util.Iterator;

public class UDSet {
    public static void main(String[] args) {

        //HashSet使用HashMap实现，key为用户输入的key，value为生成的一个PRESEANT
        java.util.Set<String> hashSet = new HashSet<>();

        //添加key
        hashSet.add("1");
        hashSet.add("2");
        hashSet.add("3");

        //打印HashSet
        System.out.println(hashSet);

        //添加重复元素，如果返回false表示添加失败
        System.out.println(hashSet.add("1"));

        //输出hashSet的长度
        System.out.println(hashSet.size());

        //查看hashSet中是否包含对应的元素
        System.out.println(hashSet.contains("1"));

        //从hashSet中删除元素
        System.out.println(hashSet.remove("2"));

        //打印hashSet
        System.out.println(hashSet);


        //使用迭代器使出hashSet
        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());

            //Iterator的hashcode值返回的似乎只是iterator的hashcode值，而不是key的hashcode值
            System.out.println(iterator.hashCode());
            System.out.println("===");
        }

        //使用增强for循环输出hashSet
        for (String s : hashSet) {
            System.out.println(s);

            //用增强for循环可以看到，返回的是 key 的hashcode值
            //而且String类型的hashcode并不是返回一个固定长度的int值，而是随着value的长度改变
            //String中hashcode的方法

            /* public int hashCode() {
            //hash值默认是0
                int h = hash;
                if (h == 0 && value.length > 0) {
                    char val[] = value;

                //从这段可以看到hash值并不是一个固定长度的int值，会随着h和value的长度改变而改变
                    for (int i = 0; i < value.length; i++) {
                        h = 31 * h + val[i];
                    }
                    hash = h;
                }
                return h;
            }*/
            System.out.println(s.hashCode());
            System.out.println("++++++");
        }

        //查看对应 Stirng 对象的hashSet
        /*
        * 插曲：
        * String对象的值是使用
        * final char[]修饰，因此String对象的值不可改变
        * 若修改string的值，实际上是新建了一个String实例，使对象的引用指向了这个实例*/
        System.out.println(new String("1").hashCode());
        System.out.println("2".hashCode());
        System.out.println("3".hashCode());
        System.out.println("12".hashCode());

    }
}
