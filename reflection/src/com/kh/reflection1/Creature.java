package com.kh.reflection1;

import java.io.Serializable;

/**
 * @author wkh
 * @create 2021-08-07 18:09
 */
public class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    private void breath(){
        System.out.println("creature呼吸");
    }

    public void eat(){
        System.out.println("creature--eat");
    }
}
