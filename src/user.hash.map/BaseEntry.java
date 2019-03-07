package user.hash.map;

/**
 * Entry的基类接口
 */
public interface BaseEntry<K,V> {
    //获取键
    public K getKey();
    //获取值
    public V getValue();
}
