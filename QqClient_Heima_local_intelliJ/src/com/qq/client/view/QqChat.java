package com.qq.client.view;

import com.qq.client.model.QqClientConnectServer;
import com.qq.common.Message;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;

/**
 * this frame is chatting frame window
 *
 * should be thread and reading data all the time
 */

public class QqChat extends JFrame implements ActionListener{

    JTextField jtf;
    JTextArea jta;
    JPanel jp;
    JButton jb;
    String ownerID;
    String friendID;


    public static void main(String[] args) {

        //QqChat qqChat = new QqChat("leo");
    }


    public QqChat(String ownerID, String friend){

        this.ownerID = ownerID;
        this.friendID = friend;
        jta = new JTextArea();
        jtf = new JTextField(15);
        jb = new JButton("Send");
        jp = new JPanel();
        jb.addActionListener(this);
        jp.add(jtf);
        jp.add(jb);

        this.add(jta,"Center");
        this.add(jp,"South");
        this.setSize(400,300);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int)(dimension.getWidth()/2);
        int y = (int)(dimension.getHeight()/2);
        this.setVisible(true);
        this.setLocation(x,y);
        this.setTitle(ownerID + " chatting with " + friend);
        this.setIconImage(new ImageIcon("image/qq2.jpg").getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //if user push jb:send button
        if(e.getSource() == jb){
            Message ms = new Message();
            ms.setSender(this.ownerID);
            //ms.setMesType();
            ms.setReceiver(this.friendID);
            ms.setContent(jtf.getText());
            ms.setSendTime(LocalDateTime.now().toString());


            try {
                ObjectOutputStream oos = new ObjectOutputStream(QqClientConnectServer.s.getOutputStream());
                oos.writeObject(ms);
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }
    }

//    @Override
//    public void run() {
//
//
//        while (true) {
//
//            try {
//                ObjectInputStream ois = new ObjectInputStream(QqClientConnectServer.s.getInputStream());
//                Message ms = (Message)ois.readObject();
//                String info = ms.getSender() + " to " + ms.getReceiver() +
//                        " say " + ms.getContent() + " in " + ms.getSendTime();
//                this.jta.append(info);
//
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
