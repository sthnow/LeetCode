package user.hash.map;


/**
 * BashEntry的实现类
 * HashMap是通过数组+链表实现的，这里实现的是链表
 * @param <K>
 * @param <V>
 */
public class Entry<K,V> implements BaseEntry<K,V> {
    K k;
    V v;
    Entry<K,V> next;

    //构造器
    public Entry(K k,V v){
        this.k = k;
        this.v = v;
        this.next = next;
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
