package others;

public class ThreadDeme extends Thread{

    public static void main(String[] args) {
        ThreadDeme td = new ThreadDeme();
        td.run();
        for(int i =0;i<20;i++){
            System.out.println("Hello World");

            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Thread tt = new Thread();
        tt.start();

    }

    @Override
    public void run() {
        //super.run();


        for (int i=0;i<20;i++) {
            System.out.println("demo run");

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
