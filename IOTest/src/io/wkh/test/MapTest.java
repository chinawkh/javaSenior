package io.wkh.test;

import org.junit.Test;

import java.util.HashSet;

/**
 * @author wkh
 * @create 2021-07-30 21:48
 */
public class MapTest {
    @Test
    public void test1(){
        HashSet set = new HashSet();
        Person p1 = new Person("AA",1001);
        Person p2 = new Person("BB",1002);
        set.add(p1);
        set.add(p2);
        p1.setName("CC");
        boolean remove = set.remove(p1);
        System.out.println(remove);
        System.out.println(set);
        set.add(new Person("CC",1001));
        System.out.println(set);
        set.add(new Person("AA",1001));
        System.out.println(set);
    }
}
