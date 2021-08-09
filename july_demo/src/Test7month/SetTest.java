package Test7month;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author wkh
 * @create 2021-07-08 22:31
 */
public class SetTest {
    /*
    Set(存储无序、不可重复的数据)接口下有三个主要实现类：
           /----HashSet:作为Set接口的主要实现类；线程不安全的，可以存储null值
                        {HashSet添加元素的过程：

                        }
                /-----LinkedHashSet: 作为HashSet子类；遍历其内部数据时，可以按照添加的顺序遍历
           /----TreeSet: 底层使用红黑树存储的；放入TreeSet的元素得是同一个类new的；可以按照添加对象的指定属性，进行排序

     */
    // HashSet
    @Test
    public void test1(){
        // Set中没有额外定义的新方法，使用的都是Collection中声明过的方法
        // HashSet底层数组的长度是16，底层运用了哈希排序，所以在插入的时候不是按照物理顺序来插入的（这里运用到了哈希值）
        // HashSet底层是：数组+链表
        Set set = new HashSet();
        set.add(124);
        set.add(456);
        set.add(789);
        set.add(new Person("jack",12));
        set.add("123");
        // 不可重复性：就是重写的equal(),返回false就可存入，所以相同的相同的元素只能添加一个
        set.add(new Person("jack",13));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            // 输出结果体现出来，输出的无序性（和add的顺序不一样），但是不等于无序性，最终每次输出的结果都一样
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2(){
        Set set1 = new LinkedHashSet();
        set1.add(124);
        set1.add(456);
        set1.add(789);
        set1.add(new Person("jack",12));
        set1.add("123");
        // 不可重复性：就是重写的equal(),返回false就可存入，所以相同的相同的元素只能添加一个
        set1.add(new Person("jack",13));

        Iterator iterator = set1.iterator();
        while (iterator.hasNext()){
            // 输出结果体现出来，输出的无序性（和add的顺序不一样），但是不等于无序性，最终每次输出的结果都一样
            System.out.println(iterator.next());
        }
    }




}
