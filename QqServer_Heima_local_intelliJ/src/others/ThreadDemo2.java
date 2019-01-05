package others;

import java.awt.desktop.SystemSleepEvent;

public class ThreadDemo2 {

    public static void main(String[] args) {

        ThreadTest t1 = new ThreadTest("t1");
        ThreadTest t2 = new ThreadTest("t2");
        ThreadTest t3 = new ThreadTest("t3");

        t1.start();
        t2.start();
        t3.start();

        for(int i=0;i<10;i++){

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println( "main " + i + " hello world from main");
        }
    }
}

class ThreadTest extends Thread{

    //private String threadID;

    public ThreadTest(String threadID){
        super(threadID);
      //  this.threadID = threadID;
    }




    public void run(){

        for (int i =0;i<10;i++) {

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName() + " "+i );
            System.out.println(Thread.currentThread().getName());
        }
    }
}


