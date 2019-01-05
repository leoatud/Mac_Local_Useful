package com.itheima.testBS;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
    public static void main(String[] args) {
        ServerSocket serverSocket;
        Socket socket;
        OutputStream ops;
        try {
            serverSocket = new ServerSocket(8080);
            socket = serverSocket.accept();
            ops = socket.getOutputStream();
            ops.write("".getBytes());
            ops.write("".getBytes());
            ops.write("".getBytes());
            ops.write("".getBytes());
            StringBuffer sb = new StringBuffer();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }


    }
}
