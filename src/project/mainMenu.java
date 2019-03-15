package project;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Container;
import java.util.*;
import java.util.Deque;
import static project.transaction.deq;
public class mainMenu extends JFrame implements ActionListener{
    public static JButton b1,b2,b3,b4,b5;
    public static int flag;
    public static JLabel l;
    JFrame f1;
    JPanel p ,p2 ,p3;
//    transaction t = new transaction();
    public mainMenu(){
        String s[] = {"Withdraw","Deposit" , "Balance Inquiry" , "Previous" , "Next" };
        String s1[] = {"Withdraw","Deposit","Get your Balance" ,"Elicit history Transactions" ,"Elicit history Transactions"}; 
        f1 = new JFrame();
        f1.setTitle("Main Menu");
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setSize(new Dimension(330 , 210));
        //f.pack();
        f1.setLayout(new BorderLayout());
        p = new JPanel();
        p.setLayout(new GridLayout(5,1));
        b1 = new JButton("Withdraw");
        b1.setHorizontalAlignment(0);
        b1.setToolTipText("Withdraw");
        b1.setActionCommand("withdrawProcess");
        b1.addActionListener((ActionListener) this);
        b2 = new JButton("Deposit");
        b2.setHorizontalAlignment(0);
        b2.setToolTipText("Deposit");
        b2.setActionCommand("depositingProcess");
        b2.addActionListener((ActionListener) this);
        b3 = new JButton("Balance Inquiry");
        b3.setActionCommand("balance");
        b3.addActionListener((ActionListener) this);
        b3.setHorizontalAlignment(0);
        b2.addActionListener((ActionListener) this);
        b3 = new JButton("Balance Inquiry");
        b3.setActionCommand("balance");
        b3.addActionListener((ActionListener) this);
        b3.setToolTipText("Get your Balance");
        b4 = new JButton("Previous");
        b4.setToolTipText("Elicit history Transactions");
        b4.setHorizontalAlignment(0);
        b5 = new JButton("Next");
        b5.setHorizontalAlignment(0);
        b5.setToolTipText("Elicit history Transactions");
        p.add(b1);p.add(b2);p.add(b3);p.add(b4);p.add(b5);
        /*for(int i=0;i<5;i++){
            b[i] = new JButton(s[i]);
            b[i].setToolTipText(s1[i]);
            b[i].setHorizontalAlignment(0);
            p.add(b[i]);
        }*/
        p2 = new JPanel(new FlowLayout());
        p2.add(p);
        p3 = new JPanel();
        p3.setLayout(new FlowLayout());
        l = new JLabel("Balance");
        p3.add(l);
        f1.add(p2 , BorderLayout.NORTH);
        f1.add(p3 , BorderLayout.CENTER);
        f1.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
         if(e.getSource()==b1){
            flag = 0;   
        }
         if(e.getSource() == b2){
            flag = 1;
        }
        if(e.getSource() == b3){
            flag = 2;
        }
        if(e.getSource()== b1 || e.getSource()== b2){
            keyPad k = new keyPad();
        }
        if(e.getSource()== b3){   
            deq.addFirst(b3.getText());
            transaction t = new transaction();
            l.setText(String.valueOf(t.getCurrentBalance()));
        }
        
        if(e.getSource()== b4){
            transaction t = new transaction();
            t.previousPress  = true;
            t.prev();
        }
        if(e.getSource() == b5){
            transaction t = new transaction();
            t.nextPress = true;
            t.next();
        }
    }
}