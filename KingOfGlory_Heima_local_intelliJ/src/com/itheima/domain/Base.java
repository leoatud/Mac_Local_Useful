package com.itheima.domain;

public class Base {

    //constructor private
    private Base(){

    }
    //only create one private

    private static Base base = null;
    //provide public getinstance

    public synchronized static Base getBase(){
        if(base == null){
            base = new Base();
        }
        return base;
    }


    private boolean destroy = false;
    private int life = 999;

    public static void setBase(Base base) {
        Base.base = base;
    }

    public boolean isDestroy() {
        return destroy;
    }

    public void setDestroy(boolean destroy) {
        this.destroy = destroy;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
}
