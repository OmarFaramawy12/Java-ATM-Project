package project;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.util.Deque;
import static project.transaction.deq;
import static project.transaction.deqNext;
public class keyPad extends JFrame implements ActionListener {
    transaction tr = new transaction();
    JButton b[] = new JButton[9];
    public static JButton c1,c2,c3;
    JLabel l1;
    JTextField t;
    static String dialed = "";
    mainMenu m = new mainMenu();
    public keyPad(){
        JFrame f2 = new JFrame();
        f2.setTitle("keyPad Dialing");
        f2.setSize(new Dimension(250,200));
        //f2.pack();
        f2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(3,3));
        for(int i=0;i<9;i++){
            b[i] = new JButton("" + (i+1));
            b[i].addActionListener((ActionListener) this);
            p.add(b[i]);
        }
        JPanel tot = new JPanel();
        tot.setLayout(new BorderLayout());
        tot.add(p , BorderLayout.NORTH);
        JPanel p3 = new JPanel();
        p3.setLayout(new GridLayout(1,3));
        c1 = new JButton("Submit");
        c1.addActionListener((ActionListener) this);
        c2 = new JButton("0");
        c2.addActionListener((ActionListener) this);
        c3 = new JButton("Clear");
        c3.addActionListener((ActionListener) this);
        p3.add(c1);p3.add(c2);p3.add(c3);
        tot.add(p3 , BorderLayout.CENTER);
        f2.add(tot , BorderLayout.CENTER);
        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout());
        l1 = new JLabel("Enter Amount : ");
        t = new JTextField(10);
        p2.add(l1);p2.add(t);
        f2.add(p2 , BorderLayout.NORTH);
        f2.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
       
        for(int i=0; i<9;i++){
            if(e.getSource()==b[i]){
                dialed += e.getActionCommand();
                t.setText(dialed);
            }
        }
        if(e.getSource()== c2){
            dialed += e.getActionCommand();
            t.setText(dialed);
        }
        
        if( m.flag == 0 && e.getSource()==c1){
            
            int a = Integer.parseInt(dialed);
            tr.withdraw(a);
            if(a < tr.getCurrentBalance()){
                deq.addFirst(m.b1.getText());   
            }
            mainMenu m = new mainMenu();
            m.l.setText( "You withdrawed : "+ dialed + " L.E " +  "Your current balance is : " + tr.getCurrentBalance());  
        }
        if(m.flag == 1 && e.getSource()==c1){
            deq.addFirst(m.b2.getText());
            int a = Integer.parseInt(dialed);
            tr.deposit(a);
            mainMenu m = new mainMenu();
            m.l.setText(("You deposited : " + dialed + "L.E " + "Your current balance is : " + tr.getCurrentBalance()));
        }
        if(e.getSource()==c3){
            t.setText("");
            dialed = "";
        }
        while(deqNext.size() > 0){
            if(m.flag == 0 && e.getSource() == c1){
                deqNext.peek();
                deq.add(m.b1.getText());
                deqNext.pop();
            }
            if(m.flag == 1 &&e.getSource() == c1){
                deqNext.peek();
                deq.add(m.b2.getText());
                deqNext.pop();
            }
            if(e.getSource()== m.b3){
                deqNext.peek();
                deq.add(m.b3.getText());
                deqNext.pop();
            }
        }
        if(deq.size() == 5){
            deq.pollFirst();
        }
        System.out.println(deq + "\n");
        
        
    }
}
