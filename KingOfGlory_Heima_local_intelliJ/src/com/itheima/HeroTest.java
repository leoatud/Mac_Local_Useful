package com.itheima;

import com.itheima.Skill.impl.JiPao;
import com.itheima.domain.Hero;
import com.itheima.domain.HouYi;

import java.util.logging.Logger;

public class HeroTest {
    public static void main(String[] args) {

        //1.choose hero
        Hero hero = new HouYi();
        //2.introduce
        System.out.println(hero.getHeroName());
        hero.display();
        //3.main situation
        hero.setIskill(new JiPao());
        //4.start game
        System.out.println("start game");
        //5.normal attack
        hero.normalAttack();
        //6.special attack
        hero.skill();
    }
}
