package others;

import java.awt.font.TextHitInfo;

public class TicketTest {
    public static void main(String[] args) {


        Ticket t = new Ticket("t1");

        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        t1.start();

        try {
            Thread.sleep(10 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.flag = false;
        t2.start();



/*        Ticket t1 = new Ticket("t1");
        Ticket t2 = new Ticket("t2");
        Ticket t3 = new Ticket("t3");
        Ticket t4 = new Ticket("t4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();*/

    }
}


class Ticket implements Runnable{


    private static int ticketNum = 200;

    public boolean flag = true;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ticket(String name){
        this.name = name;
    }

    Object o = new Object();

    public synchronized void show(){


        synchronized (o) {
            if (ticketNum > 0) {

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " show:...... " + ticketNum--);
            }
        }

    }
    public void run(){

        if (flag) {
            while(true){

                    synchronized (o) {
                        show();
                    }
            }
        }else{
            while(true)
                show();
        }


    }
}
