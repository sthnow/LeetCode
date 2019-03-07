package user.hash.map;

/**
 * HashMap的基类接口
 * @param <K>
 * @param <V>
 */
public interface BashMap<K,V> {
    //将HashMap最重要的两个方法提出来

    //存
    public V put(K k, V v);
    //取
    public V get(K k);
}
