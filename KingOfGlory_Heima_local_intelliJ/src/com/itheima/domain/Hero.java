package com.itheima.domain;


import com.itheima.Skill.ISkill;

// abstract class
public abstract class Hero {
    private String heroName;

    private int heroHurt;

    public int getHeroHurt() {
        return heroHurt;
    }

    public void setHeroHurt(int heroHurt) {
        this.heroHurt = heroHurt;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    private ISkill iskill;

    public ISkill getIskill() {
        return iskill;
    }

    public void setIskill(ISkill iskill) {
        this.iskill = iskill;
    }

    public abstract void display();

    public abstract void normalAttack();

    public void skill(){
        iskill.useSkill();
    }


}
