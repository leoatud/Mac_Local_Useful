package com.itheima;

import com.itheima.domain.Base;
import com.itheima.domain.Hero;
import com.itheima.domain.HouYi;

public class BaseTest {
    public static void main(String[] args) {
        System.out.println("simulation base been attacked");

        new Thread(new Runnable() {
            @Override
            public void run() {
                Hero hero = new HouYi();
                hero.setHeroHurt(100);

                Base base = Base.getBase();
                destroyBase(hero,base);
            }
        }).start();

    }


    //hero destroy base
    public static void destroyBase(Hero hero, Base base){


        System.out.println("hero" + hero.getHeroName()+hero.getHeroHurt());

        while(base.getLife() > 0){
            if(!base.isDestroy()){
                base.setLife(base.getLife()-hero.getHeroHurt());
                if(base.getLife()>0){
                    System.out.println(hero.getHeroName() + " is attacking...");
                } else{
                  base.setDestroy(true);
                  System.out.println("base has been destoryed by "+hero.getHeroName());
                }
            }
        }


    }
}
