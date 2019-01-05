package com.qq.client.view;


import com.qq.client.model.QqClientConnectServer;
import com.qq.client.model.QqClientUser;
import com.qq.common.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * function of login page
 */

public class QqClientLogin extends JFrame implements ActionListener {
    //define north
    JLabel jbl1;

    //define mid
    JTabbedPane jtp;
    JPanel jp2,jp3,jp4;

    //define south
    JPanel jp1;
    JButton jp1_jb1, jp1_jb2,jp1_jb3;
    JLabel jp2_jbl1,jp2_jbl2,jp2_jbl3,jp2_jbl4;
    JButton jp2_jb1;
    JTextField jp2_jtf;
    JPasswordField jp2_jpf;
    JCheckBox jp2_jcb1,jp2_jcb2;


    public static void main(String[] args) {
        QqClientLogin qqClientLogin = new QqClientLogin();

    }


    public QqClientLogin(){

        //North
        jbl1 = new JLabel((new ImageIcon("image/iconfinder_JD-03_2224663.png")));
        this.add(jbl1,"North");
        this.setSize(350,248);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //mid
        jp2 = new JPanel(new GridLayout(3,3));
        jp2_jbl1 = new JLabel("QQ Number",JLabel.CENTER);
        jp2_jbl2 = new JLabel("QQ Password",JLabel.CENTER);
        jp2_jbl3 = new JLabel("Forget Password",JLabel.CENTER);
        jp2_jbl3.setForeground(Color.blue);
        jp2_jbl4 = new JLabel("Apply Password Protection",JLabel.CENTER);
        jp2_jb1 = new JButton("clear all input message");
        jp2_jpf = new JPasswordField();
        jp2_jtf = new JFormattedTextField();
        jp2_jcb1 = new JCheckBox("Annoymous");
        jp2_jcb2 = new JCheckBox("remember the password");
        //add all component into jp2: (following the order)
        jp2.add(jp2_jbl1);
        jp2.add(jp2_jtf);
        jp2.add(jp2_jb1);
        jp2.add(jp2_jbl2);
        jp2.add(jp2_jpf);
        jp2.add(jp2_jbl3);
        jp2.add(jp2_jcb1);
        jp2.add(jp2_jcb2);
        jp2.add(jp2_jbl4);
        jtp = new JTabbedPane();
        jtp.add("QQ Number",jp2);
        jp3 = new JPanel();
        jtp.add("Phone Number",jp3);
        jp4 = new JPanel();
        jtp.add("Email Address",jp4);


        this.add(jtp,"Center");



        //South
        jp1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        //listener of login
        jp1_jb1 = new JButton("Login");
        jp1_jb1.addActionListener(this);

        jp1_jb2 = new JButton("Cancel");
        jp1_jb3 = new JButton("MoreInfo");
        //add into panel:
        jp1.add(jp1_jb1);
        jp1.add(jp1_jb2);
        jp1.add(jp1_jb3);
        this.add(jp1,"South");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jp1_jb1){
            QqClientUser qqClientUser = new QqClientUser();
            User u = new User();
            u.setUserId(jp2_jtf.getText().trim());
            u.setPasswd(new String(jp2_jpf.getPassword()));

            if(qqClientUser.checkUser(u)){
                new QqFriendList(u.getUserId());
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(this,"please try again");
            }
        }

    }
}


