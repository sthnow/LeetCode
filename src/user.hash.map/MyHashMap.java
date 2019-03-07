package user.hash.map;

import javax.swing.text.html.parser.Entity;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MyHashMap<K, V> implements BashMap<K, V> {
    //定义一些变量，如初始长度，负载因子，使用数组的数量

    private int defaultLength = 16;     //默认长度
    private double defaultAddFactor = 0.75;     //默认负载因子
    private double userSize;
    private MyEntry<K, V>[] table;   //Entry组成的数组

    //构造方法
    //无参构造器
    public MyHashMap() {
        this(16, 0.75);
    }

    //有参构造器
    public MyHashMap(int defaultLength, double defaultAddFactor) {
        if (defaultLength < 0) {
            throw new IllegalArgumentException("数组长度异常");
        }
        if (defaultAddFactor <= 0 || Double.isNaN(defaultAddFactor)) {
            throw new IllegalArgumentException("扩容因子异常");
        }
        this.defaultLength = defaultLength;
        this.defaultAddFactor = defaultAddFactor;
        table = new MyEntry[defaultLength];
    }

    /**
     * 使用每个object的hashCode计算hashCode
     *
     * @param hashCode
     * @return
     */
    private int hash(int hashCode) {
        hashCode = hashCode ^ ((hashCode >>> 20) ^ (hashCode >>> 12));
        return hashCode ^ ((hashCode >>> 7) ^ hashCode >>> 4);
    }

    /**
     * 获取保存位置的数组下标
     *
     * @param k
     * @param length
     * @return
     */
    private int getIndex(K k, int length) {
        int m = length - 1;
        int index = hash(k.hashCode()) & m;//取模
        return index >= 0 ? index : -index;
    }


    @Override
    public V put(K k, V v) {
        if (userSize > defaultAddFactor * defaultLength) {
            //执行扩容的方法
            dilatation();
        }
        //计算出下标
        int index = getIndex(k, table.length);
        //将对应位置的entry取出
        MyEntry<K, V> entry = table[index];
        MyEntry<K, V> newEntry = new MyEntry<>(k, v);
        //如果table表中的entry为空，则直接添加
        if (entry == null) {
            table[index] = newEntry;
            userSize++;
        }
        //如果不为空
        //比较Entry是否存在相同的键
        //如果不存在，添加新的Entry
        //如果存在，更新对应的value
        else {
            MyEntry<K, V> temp = entry;
            //如果是相同的key，修改对应的值
            //如果对象的地址相同则肯定相同，如果地址不同在调用equal方法比较值
            //对于比较两个对象来说，比较地址相同的效率要高于equal方法，因此比较对象的地址要放在前面
            if (temp.getKey() == k || (temp.getKey() != null && temp.getKey().equals(k))) {
                temp.v = v;
            } else {
                while (temp.next != null) {
                    if (temp.next.getKey() == k || (temp.getKey() != null && temp.next.getKey().equals(k))) {
                        temp.next.v = v;
                        break;
                    } else {
                        temp = temp.next;
                    }
                }
                if (temp.next == null) {
                    temp.next = newEntry;
                }
            }
        }
        return newEntry.getValue();
    }

    @Override
    //思路：
    //通过key计算出index
    //通过比较链表中的key是否与传入的key相等
    //如果不等，通过next查询
    //如果相等，返回value
    public V get(K k) {
        int index = getIndex(k, table.length);
        MyEntry<K, V> entry = table[index];
        //如果取出的entry为空
        if (entry == null) {
            throw new NullPointerException();
        }
        //如果取出的entry不为空，依次比较key是否相等
        if (entry.getKey() == k || k.equals(entry.getKey())) {
            return entry.v;
        } else {
            entry = entry.next;
        }
        //如果遍历完list还是找不到
        return null;
    }

    /**
     * 扩容的方法
     * 默认扩容倍数为原来的2倍
     */
    private void dilatation() {
        //这一部分将之前整个HashMap中的元素都添加到新的list里面
        //创建数组
        MyEntry[] newTable = new MyEntry[defaultLength * 2];
        //创建链表
        List<MyEntry<K, V>> list = new ArrayList<>();
        //遍历之前的整个HashMap，将元素都取出来，添加到list里面
        for(int i = 0; i < table.length; i++){
            //如果当前位置的链表为空，则跳过该次循环
            if(table[i] == null){
                continue;
            }
            //如果不为空，取出该entry链表，将该链表添加到新的链表里面
            MyEntry<K, V> entry = table[i];
            while(entry != null){
                list.add(entry);
                entry = entry.next;
            }
        }

        //这一部分将新的list中的元素添加到扩容后的HashMap里面
        if(list.size() > 0){
            userSize = 0;
            defaultLength = defaultLength*2;
            table = newTable;
            for(MyEntry<K,V> entry : list){
                //分离所有的entry
                if(entry.next != null){
                    entry.next = null;
                }
                put(entry.getKey(), entry.getValue());
            }

        }
    }
}
