package com.qq.client.model;

public class TicketTest {
    public static void main(String[] args) {
        TicketWindow tw1 = new TicketWindow();
        TicketWindow tw2 = new TicketWindow();
        TicketWindow tw3 = new TicketWindow();

        Thread t1 = new Thread(tw1);
        Thread t2 = new Thread(tw1);
        Thread t3 = new Thread(tw1);

        t1.start();
        t2.start();
        t3.start();
    }
}

class Dog{} //watch dog


class TicketWindow implements Runnable{
    private static int nums = 100;
    private Dog myDog = new Dog();
    public void run(){
        while(true) {
            synchronized (myDog) {

                if (nums > 0) {
                    System.out.println(Thread.currentThread().getName() + "selling ticket" + nums);


                    try {
                        Thread.sleep(300);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    nums--;
                } else {
                    System.out.println("no ticket anymore, please wait");
                    break;
                }
            }
        }
    }
}
