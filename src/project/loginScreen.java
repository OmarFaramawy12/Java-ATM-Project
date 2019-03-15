package project;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
public class loginScreen extends JFrame implements ActionListener {
    JFrame f ;
    JPanel p,p2,p3,tot;
    JLabel l1,l2,l3;
    JTextField t1;
    JPasswordField t2;
    JButton b ;
    public loginScreen(){
        f = new JFrame();
        f.setTitle("Login");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setLayout(new BorderLayout());
        f.setSize(310,210);
        p = new JPanel();
        p.setLayout(new FlowLayout());
        l1 = new JLabel("UserName : ");
        t1 = new JTextField(16);
        t1.setEditable(true);
        p.add(l1); p.add(t1);
        //f.add(p, BorderLayout.NORTH);
        p2 = new JPanel();
        p2.setLayout(new FlowLayout());
        l2 = new JLabel("Password : ");
        t2 = new JPasswordField(16);
        t2.setEditable(true);
        p2.add(l2); p2.add(t2);
        //f.add(p2 , BorderLayout.CENTER);
        tot = new JPanel();
        tot.setLayout(new BorderLayout());
        tot.add(p , BorderLayout.NORTH);
        tot.add(p2 , BorderLayout.SOUTH);
        f.add(tot , BorderLayout.NORTH);
        p3 = new JPanel();
        p3.setLayout(new FlowLayout());
        b = new JButton("Validate CC Number");
        b.setActionCommand("validation");
        b.setToolTipText("validate the CreditCard Number");
        b.addActionListener((ActionListener) this);
        l3 = new JLabel("Not Verified Yet" );
        p3.add(b); p3.add(l3);
        f.add(p3 , BorderLayout.CENTER);
        //f.pack();
        f.setVisible(true);   
    }
    
    //method for validating the credit card Number using Lune CheckSum Algorithm
    public boolean isValid(String s) throws NumberFormatException{
        int sum = 0;
        for(int i=s.length(); i>0; i--){
            int digit = Integer.parseInt(s);
            if(i%2==0){
                digit *=2;
            }
            sum += (digit/10) + (digit%10);
        }
        return sum%10 == 0 && s.startsWith("4"); 
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        String s1 = t1.getText();
        String s2 = t2.getText();
        String result = String.valueOf(s2);
        int a = Integer.parseInt(result);
        if("1234".equals(s1) && "1234".equals(s2)){
            l3.setText("Valid CreditCard Number");
            mainMenu m = new mainMenu();
            this.setVisible(false);
        }
        else{
            l3.setText("Invalid CreditCard Number..Chcek again!");
        }
        /*
        if(isValid(s)){
            l3.setText("Valid CreditCard Number");
        }
        else{
            l3.setText("InValid CreditCard Number");
        }
        */
    }
    public static void main(String[] args){
        //mainMenu m = new mainMenu();
        new loginScreen();
    }    
}
        
   
    
    

