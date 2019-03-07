package user.hash.map;


/**
 * BashEntry的实现类
 * HashMap是通过数组+链表实现的，这里实现的是链表
 * @param <K>
 * @param <V>
 */
public class MyEntry<K,V> implements BaseEntry<K,V> {
    K k;
    V v;
    MyEntry<K,V> next;

    //构造器
    public MyEntry(K k,V v, MyEntry<K,V> next){
        this.k = k;
        this.v = v;
        this.next = next;
    }

    public MyEntry(K k, V v) {
    }

    @Override
    public K getKey() {
        return k;
    }

    @Override
    public V getValue() {
        return v;
    }
}
