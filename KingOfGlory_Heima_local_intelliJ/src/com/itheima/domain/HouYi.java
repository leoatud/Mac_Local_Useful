package com.itheima.domain;

public class HouYi extends Hero {
    public HouYi() {
        super.setHeroName("HouYi");
    }

    @Override
    public void display() {
        System.out.println("hahahahahaha,my name is housyi");
    }

    @Override
    public void normalAttack() {
        System.out.println("I am hou yi");
    }

    @Override
    public void skill() {
        super.skill();
    }
}
