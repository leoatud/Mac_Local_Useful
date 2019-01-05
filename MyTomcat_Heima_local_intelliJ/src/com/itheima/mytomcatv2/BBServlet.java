package com.itheima.mytomcatv2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BBServlet implements Servlet {
    @Override
    public void init() {
        System.out.println("BB init");
    }

    @Override
    public void Service(InputStream io, OutputStream os) throws IOException {
        System.out.println("BB service");
        os.write("i am bb".getBytes());
        os.flush();

    }

    @Override
    public void destory() {
        System.out.println("BB destroy");


    }
}
