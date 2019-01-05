package com.itheima.mytomcatv2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class AAServlet implements Servlet {
    @Override
    public void init() {
        System.out.println("AA init");
    }

    @Override
    public void Service(InputStream io, OutputStream os) throws IOException {
        System.out.println("AA service");
        os.write("I am AA".getBytes());
        os.flush();

    }

    @Override
    public void destory() {
        System.out.println("AA destroy");
    }
}
