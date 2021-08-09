package Test7month.MapExer;

import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author wkh
 * @create 2021-07-12 16:20
 */
public class MapTest {
    /*
            一、Map实现类的知识点
            /----Map:双列数据，用于存储key-value对的数据  ---类似于高中的函数： y = f(x)
                /----HashMap:作为Map的主要实现类；线程不安全，效率高；可以存储null的key和value；
                    /----LinkedHashMap:保证在遍历Map元素时，可以按照添加的顺序实现遍历。
                                         原因：在原有的HashMap底层结构基础上，添加了一对指针，指向前一个和后一个元素。
                                         对于频繁的遍历操作，此类效率高于HashMap.
                /----TreeMap:保证按照添加的key-value对进行排序，实现排序遍历。此时考虑key的自然排序或者定制排序
                                底层使用红黑树；
                /----Hashtable:作为Map的古老实现类（1.0）；线程安全，效率低；不可以存储null的key和value；
                    /----Properties:常用来处理配置文件。key和value都是String类型


             HashMap的底层：数组+链表  jdk7之前
                           数组+链表+红黑树 jdk8

             面试题：
             1.HashMap底层实现原理？
             2.HashMap和Hashtable的异同？

         二、Map结构的理解
             Map中的key：无序、不可重复      ----->key所在的类要重写equals()和hashCode()(以hashMap为例)
             Map中的value: 无序、可重复      ----->value所在类要重写equals()
             一个键值对：key-value构成了一个Entry对象。
             Map中的entry:无序的、不可重复，使用Set存储所有的entry

         三、HashMap底层实现原理
             3.1 以jdk7为例
             HashMap map = new HashMap():
             在实例化以后，底层创建了长度为16的一维数组Entry[] table.
             ···可能已经执行过多次put··
             map.put(key1,value1):
             首先，调用key1所在类的hashCode()方法，计算哈希值，此哈希值经过某种算法得到在Entry数组中的存放位置。
             如果此位置上的数据为空，此时key1-value1添加成功。  ---情况一
             如果此位置上的数据不为空，（意味着此位置上存在一个或多个数据（以链表形式存在）），比较key1和已经存在的一个或
             多个数据的哈希值：
                        如果key1的哈希值与已经存在的数据的哈希值都不相同，此时key1-value1添加成功   ---情况二
                        如果key1的哈希值与已经存在的某一数据(k2-v2)的哈希值不相同，继续比较：调用key1所在类的equals()方法，比较：
                                如果equals()返回false：k1-v1添加成功     ---情况三
                                如果equals()返回true: 使用v1替换v2
              补充：关于情况2和情况3：此时k1-v1和原来的数据以链表的方式存储。

              在不断的添加过程中，回涉及到扩容问题，默认的扩容方式：扩容为原来容量的2倍，并将原来数据复制过来。


              jdk8相较于jdk7在底层实现方面的不同：
              1. new HashMap();底层没有创建一个长度为16的数组
              2. jdk8底层的数组： Node[],而非Entry[]
              3.首次调用put方法时，底层创建长度为16的数组
              4.jdk7底层结构：数组+链表; jdk8: 数组+链表+红黑树
                当数组的某一个索引位置上的元素以链表形式存在的数据个数>8且当前数组的长度>64时，
                此时此索引位置上的所有数据改为红黑树存储。

     */

    @Test
    public void test1(){
        Map map = new HashMap();

        map.put(1,null);
        map.put(null,null);
     //   map.put(null,1);

        System.out.println(map.size());
    }

}
