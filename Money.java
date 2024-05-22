package com.exercise.demo;

public class Money {
    // money的面值有1美元和2美元两种
    private int value;
    // money的属性为真或者为假
    private boolean realCoin;

    public Money() {

    }

    // money的构造方法
    public Money(int level) {
        // 如果level不是3,6,9,12
        if (level % 3 != 0) {
            // value的值为1或者为2
            value = (int) (Math.random() * 2) + 1;
            double probability = Math.random();
            if (probability <= 0.7) {
                realCoin = true;
            } else {
                realCoin = false;
            }
        } else {
            realCoin = true;
            value = 2;
        }
    }

    // get和set方法
    public int getValue() {
        return value;
    }

    public boolean getrealCoin() {
        return realCoin;
    }

}
