package com.qq.server.view;

import com.qq.server.model.MyQqServer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * this is server controller
 * monitor users, contoller of users
 */

public class MyServerFrame extends JFrame implements ActionListener {

    JPanel jp1;
    JButton jb1, jb2;


    public static void main(String[] args) {
        MyServerFrame myServerFrame = new MyServerFrame();
    }


    public MyServerFrame(){
        jp1 = new JPanel();
        jb1 = new JButton("Start server");
        jb2 = new JButton("Close server");
        jb1.addActionListener(this);
        jb2.addActionListener(this);



        this.add(jp1);
        this.add(jb1,"North");

        this.add(jb2,"South");
        this.setSize(500,400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(400,400);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jb1){
            System.out.println("start server button pushed");
            new MyQqServer();
        }

        if(e.getSource() == jb2){
            System.exit(-1);
        }
    }
}
