package com.qq.client.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * friend list including all strangers and block list
 */


//change JFrame to card layout
public class QqFriendList extends JFrame implements ActionListener, MouseListener {

    //first card
    JPanel jphy1, jphy2, jphy3;
    JButton jphy_jb1, jphy_jb2, jphy_jb3;
    JScrollPane jsp1;

    //second card == staranger
    JPanel jpst1, jpst2, jpst3;
    JButton jpst_jb1, jpst_jb2, jpst_jb3;
    JScrollPane jsp2;

    CardLayout c1;

    String ownerID;


    //center window:
    public static void centerWindow(Window frame){
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int)((dimension.getWidth() - frame.getWidth())/2);
        int y = (int)((dimension.getHeight() - frame.getHeight())/2);
        frame.setLocation(x,y);
    }



    public static void main(String[] args) {

       // QqFriendList qqFriendList = new QqFriendList();
    }

    //constructor new all obj
    public QqFriendList(String ownerID){

        /**
         *  deal with first card all init
         */
        //three basic button
        this.ownerID = ownerID;
        jphy_jb1 = new JButton("MyFriends");
        jphy_jb2 = new JButton("Stranger");
        jphy_jb2.addActionListener(this);
        jphy_jb3 = new JButton("BlockList");

        //deal first card
        jphy1 = new JPanel(new BorderLayout());
        //suppose have 50 friends
        jphy2 = new JPanel(new GridLayout(50,1,4,4));
        //init 50 friends:
        JLabel[] jbls = new JLabel[50];
        for(int i =0;i<jbls.length;i++){
            jbls[i] = new JLabel(i+1+"",new ImageIcon("/image/qq2.jpg"),JLabel.LEFT);
            jbls[i].addMouseListener(this);
            jphy2.add(jbls[i]);
        }
        //stranger and block list
        jphy3 = new JPanel(new GridLayout(2,1));
        jphy3.add(jphy_jb2);
        jphy3.add(jphy_jb3);

        jsp1 = new JScrollPane(jphy2);

        jphy1.add(jphy_jb1,"North");
        jphy1.add(jsp1,"Center");
        jphy1.add(jphy3,"South");


        /**
         *  deal with second card all init
         */
        jpst_jb1 = new JButton("MyFriends");
        jpst_jb1.addActionListener(this);
        jpst_jb2 = new JButton("Stranger");
        jpst_jb3 = new JButton("BlockList");

        //deal first card
        jpst1 = new JPanel(new BorderLayout());
        //suppose have 50 friends
        jpst2 = new JPanel(new GridLayout(20,1,4,4));
        //init 50 friends:
        JLabel[] jbls2 = new JLabel[20];
        for(int i =0;i<jbls2.length;i++){
            jbls2[i] = new JLabel(i+1+"",new ImageIcon("/image/qq2.jpg"),JLabel.LEFT);
            jpst2.add(jbls2[i]);
        }
        //stranger and block list
        jpst3 = new JPanel(new GridLayout(2,1));
        jpst3.add(jpst_jb1);
        jpst3.add(jpst_jb2);

        jsp2 = new JScrollPane(jpst2);

        jpst1.add(jpst3,"North");
        jpst1.add(jsp2,"Center");
        jpst1.add(jpst_jb3,"South");



        //good point to change layout:
        c1 = new CardLayout();
        this.setLayout(c1);
        this.add(jphy1,"1");
        this.add(jpst1,"2");
        //add "chatting with whom"
        this.setTitle(ownerID);

        centerWindow(this);
        this.setSize(150,500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        // if button 2 touch --> stranger --> display card2
        if(e.getSource() == jphy_jb2){
            c1.show(this.getContentPane(),"2");
        }
        if(e.getSource() == jpst_jb1){
            c1.show(this.getContentPane(),"1");
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        //double click event and get friend id
        if(e.getClickCount()==2){
            String friendNum = ((JLabel)e.getSource()).getText();
            QqChat qqChat = new QqChat(this.ownerID, friendNum);
            //Thread thread = new Thread(qqChat);
            //thread.start();
            System.out.println(" chatting with " + friendNum );
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JLabel j1 = (JLabel)e.getSource();
        j1.setForeground(Color.RED);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JLabel j1 = (JLabel)e.getSource();
        j1.setForeground(Color.BLACK);
    }
}
