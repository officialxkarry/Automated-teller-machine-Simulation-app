
package bank.management.system;
import javax.swing.*; //frames
import java.awt.*; //bounds and locate
import java.awt.event.*; // for ActionListener
import java.util.*;
import java.sql.*;
public class MiniStatement extends JFrame implements ActionListener 
{
    String pinnumber;
    JButton back;
    MiniStatement(String pinnumber)            
    {
        this.pinnumber=pinnumber;
        setTitle("Mini Statement");
        setLayout(null);
        
        JLabel mini = new JLabel();
        mini.setBounds(20,10,400,1000);
        add(mini);
        JLabel bank = new JLabel("Bank of Moscow");
        bank.setBounds(350,20,300,20);
        bank.setFont(new Font("System",Font.BOLD,25));
        add(bank);
        JLabel card =  new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        JLabel balance = new JLabel();
        balance.setBounds(650,20,300,20);
        balance.setFont(new Font("System",Font.BOLD,25));
        add(balance);
            
        
        try
        {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
            while(rs.next())
            {
                card.setText("Card Number : "+ rs.getString("cardnumber").substring(0, 4)+" XXXX XXXX " +rs.getString("cardnumber").substring(12));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        try
        {
            Conn conn = new Conn();
            int bal=0;
            ResultSet rs = conn.s.executeQuery("select * from bank where pin =  '"+pinnumber+"'");
            String statement = "<html>";
while(rs.next())
{
    statement += rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                 rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                 rs.getString("amount") + "<br><br>";
    
    String type = rs.getString("type").trim();
                String amt = rs.getString("amount").trim();
                System.out.println("DB type: [" + type + "], amount: [" + amt + "]"); // DEBUG

                if (type.equals("Deposit")) {
                    bal += Integer.parseInt(amt);
                } else {
                    bal -= Integer.parseInt(amt);
                }
                
}
statement += "</html>";
mini.setText(statement);
balance.setText("Balance : Rs "+bal);

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        back = new JButton("Back");
        back.setBackground(Color.white);
        back.setBounds(400,50,100,30);
        back.addActionListener(this);
        add(back);
        
        
        
        setSize(900,900);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
        
    }
    
    //@Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==back)
        {
            setVisible(false);
        }
    }
    public static void main(String arg[])
    {
        new MiniStatement("");
    }
}
