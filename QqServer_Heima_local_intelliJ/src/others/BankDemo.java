package others;

public class BankDemo {
    public static void main(String[] args) {
        Custom c = new Custom();
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);

        t1.start();
        t2.start();
    }

}

class Bank{
    private int sum;
    public synchronized void add(int n){

            sum +=n;

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Sum= " + sum);


    }
}

class Custom implements Runnable{
    private Bank b = new Bank();

    @Override
    public void run() {
        for(int i=0;i<500;i+=100){
            System.out.println(Thread.currentThread().getName() + " add" + i);
            b.add(i);
        }
    }
}