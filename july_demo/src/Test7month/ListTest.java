package Test7month;

import org.junit.Test;

import javax.xml.bind.SchemaOutputResolver;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author wkh
 * @create 2021-07-08 15:13
 */
public class ListTest {

    // List接口下的三个实现类ArrayList LinkedList Vector
    /*
    三个类存储数据的特点相同：存储可重复的，有序的数据
    ArrayList：作为List接口的主要实现类,线程不安全，效率高；底层使用Object[] elementData存储
    LinkedList：对于频繁的插入和删除操作使用此类比ArrayList高，底层使用的双向链表存储；
    Vector：作为List接口的古老的实现类，线程安全，效率不高；底层使用Object[]存储
    相同方法名的方法叫做重载，区分于重写、构造方法
    add(obj);  add(int,obj)   方法的重载
    addAll(list);
    get(index) 获取
    indexOf(obj) 获取第一次出现的位置索引
    remove(int index) : 按照索引删除元素  返回删除的元素
    set(int i,obj)  做修改
    sublist(int fromIndex,int toIndex) 左闭右开，返回一个子List集合
    总结：常用方法
    增：add(obj)
    删：remove(int index) / remove(obj)
    改：set(int index,Object obj)
    查：get(int index)
    插：add(int index,Object obj)
    长度：size()
    遍历：①Iterator迭代器方式
         ②增强for循环/普通循环


     */

    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("abc");
        // 方式一：Iterator迭代器循环方式搭配while()使用
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("********************************");
        boolean removeElement = list.remove((Integer)123);
      //  Object removeElement = list.remove(123);
        System.out.println(removeElement);
        // 方式二：增强for循环
        for (Object obj:list) {
            System.out.println(obj);
        }
        System.out.println("********************************");
        // 方式三：普通for循环
        for (int i = 0;i<list.size();i++){
            System.out.println(list.get(i));
        }

    }





}
