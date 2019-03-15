package project;
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.awt.*;
import javax.swing.*;
import java.util.Deque;
import java.util.*;
import static project.keyPad.c1;
import static project.mainMenu.flag;
import static project.mainMenu.b1;
import static project.mainMenu.b2;
import static project.mainMenu.b3;
import static project.mainMenu.l;
public class transaction extends JFrame implements Iatm {
    static int balance ;
    
    ActionEvent e;
    static boolean nextPress = false;
    static boolean previousPress = false;
    public static Deque<String> deq = new LinkedList<String>();
    public static Deque<String> deqNext = new LinkedList<String>();
    public void setCurrentBalance(int balance){
         this.balance = balance;
    }
    @Override
    public int getCurrentBalance(){
        return (balance);
    }
    @Override
    public void withdraw(int amount){
        //int am = Integer.parseInt(amount);
        if(amount>balance){
            JOptionPane.showMessageDialog(null, "Error the amount you want to withdraw is more than your currentBalance");
        }
        else{
             balance = balance - amount;
             setCurrentBalance(balance);
        }
    }
    @Override
    public void deposit(int amount){
        balance = balance + amount;    
        setCurrentBalance(balance);
        getCurrentBalance();
    }
     
    @Override
    public void prev() {
        if(deq.size() > 0){
            if(nextPress){
                if(flag == 0 && e.getSource() == c1){
                    deq.peekLast();
                    deq.add(b1.getText());
                    deq.pollLast();
                }
                if(flag == 1 &&e.getSource() == c1){
                    deq.peekLast();
                    deq.add(b2.getText());
                    deq.pollLast();
                }
                if(e.getSource()== b3){
                    deq.peekLast();
                    deq.add(b3.getText());
                    deq.pollLast();
                }   
            }
            if(deq.size() > 0){
                if(flag == 0 && e.getSource() == c1){
                    deq.peekLast();
                    l.setText(b1.getText());
                    deqNext.add(b1.getText());
                    deq.pollLast();
                }
                if(flag == 1 &&e.getSource() == c1){
                    deq.peekLast();
                    l.setText(b2.getText());
                    deqNext.add(b2.getText());
                    deq.pollLast();
                }
                if(e.getSource()== b3){
                    deq.peekLast();
                    l.setText(b3.getText());
                    deqNext.add(b3.getText());
                    deq.pollLast();
                }   
                nextPress = false;
                previousPress = true;
            }
        }
    }

    @Override
    public void next(){
        if(deqNext.size() > 0){
            if(previousPress){
                if(flag == 0 && e.getSource() == c1){
                    deqNext.peekLast();
                    l.setText(b1.getText());
                    deq.add(b1.getText());
                    deqNext.pollLast();
                }
                if(flag == 1 &&e.getSource() == c1){
                    deqNext.peekLast();
                    l.setText(b2.getText());
                    deq.add(b2.getText());
                    deqNext.pollLast();
                }
                if(e.getSource()== b3){
                    deqNext.peekLast();
                    l.setText(b3.getText());
                    deq.add(b3.getText());
                    deqNext.pollLast();
                }   
            }
            if(deqNext.size() > 0){
                if(flag == 0 && e.getSource() == c1){
                    deqNext.peekLast();
                    
                    deq.add(b1.getText());
                    deqNext.pollLast();
                }
                if(flag == 1 &&e.getSource() == c1){
                    deqNext.peekLast();
                    deq.add(b2.getText());
                    deqNext.pollLast();
                }
                if(e.getSource()== b3){
                    deqNext.peekLast();
                    deq.add(b3.getText());
                    deqNext.pollLast();
                }   
                nextPress = true;
                previousPress = false;
            }
        }
    }   
}
 

