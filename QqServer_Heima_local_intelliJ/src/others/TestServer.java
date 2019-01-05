package others;


import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
    public static void main(String[] args) {
        TestServer ts = new TestServer();
    }


    public TestServer(){
        try{
            System.out.println("here start in Server");
            ServerSocket ss = new ServerSocket(3456);
            Socket s = ss.accept();
            //suppose dealing with stream:::
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            UserFake u = (UserFake)ois.readObject();
            System.out.println(u.getName() + u.getPass() + "end here");
            s.close();
            ss.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
