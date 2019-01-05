package com.qq.common;

import javax.lang.model.element.NestingKind;

public class DemoThread {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread1 = new MyThread("t1");

        MyThread myThread2 = new MyThread("t2");

        System.out.println(myThread1.getState());

        myThread1.start();

        myThread1.wait(1000);
        System.out.println(myThread1.getState());

        myThread2.start();

        System.out.println(myThread1.getState());
    }
}


class MyThread extends Thread{
    private String myName;
    public MyThread(String myName){super(myName);}

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    @Override
    public void run() {
        System.out.println();
        long beginTime = System.currentTimeMillis();
        while(System.currentTimeMillis() - beginTime < 5000){

        }
        System.out.println(this.myName + " " +
                   Thread.currentThread().getState() + "is"
                            + Thread.currentThread().getName());
    }
}