
package bank.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class BalanceEnquiry  extends JFrame implements ActionListener
{
    String pinnumber;
    JButton back;
    BalanceEnquiry(String pinnumber)
    {
        this.pinnumber=pinnumber;
          ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        Conn c = new Conn();
           int balance = 0;
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
           while (rs.next()) {
    String type = rs.getString("type").trim();
    int amount = Integer.parseInt(rs.getString("amount").trim());

    if (type.equalsIgnoreCase("Deposit")) {
        balance += amount;
    } else {
        balance -= amount;
    }
}//while closing
        }//closing Try
        catch(Exception e)
        {
            System.out.println(e);
        }//closing catch
      JLabel text = new JLabel("Your current Account Balance is : Rs "+ balance);
        text.setBounds(170,300,400,30);
        text.setForeground(Color.white);
        image.add(text);
        
        setTitle("Balance Enquiry");
        setSize(900,900);
        setLocation(300,0);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);    
         setVisible(true); 
    }//constructor Closing
    public static void main(String arg[])
        {
            new BalanceEnquiry("");
        }//main method Closing

//    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
    
}   
