package com.qq.common;

public class ThreadTest {

    public static void main(String[] args){
        MultiThread m1 = new MultiThread();


        Haha haha = new Haha();
        Thread m1 = new Thread(haha,"haha");
        Thread.sleep(1000);




        try {
            t1.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t1.start();
        System.out.println(t1.getState() + " is t1 state");
        System.out.println(t2.getState() + " is t2 state");


        t2.start();

    }



}


class Haha implements  Runnable{
    @Override
    public void run() {

    }
}

class MultiThread implements Runnable{
    private static int i;

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(i + " " + Thread.currentThread().getState() +Thread.currentThread().getName() + " is my current thread");
        }
    }
}