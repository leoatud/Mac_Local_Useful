package others;

import java.io.ObjectOutputStream;
import java.net.Socket;

public class TestClient {
    public static void main(String[] args) {

        TestClient tc = new TestClient();
    }

    public TestClient(){

        try{
            System.out.println("here start in client");
            Socket s = new Socket("127.0.0.1",3456);
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            UserFake u = new UserFake();
            u.setName("LEOATUD");
            u.setPass("123456");
            oos.writeObject(u);
            s.close();


        } catch(Exception e){
            e.printStackTrace();
        } finally{

        }
    }

}
