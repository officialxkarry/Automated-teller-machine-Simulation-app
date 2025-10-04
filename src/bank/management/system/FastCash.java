package bank.management.system; 
import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
public class FastCash extends JFrame implements ActionListener{
    JButton deposit,withdrawl,fastcash,ministatement,exit,pinchange,balanceenquiry;
    String pinnumber;
    FastCash(String pinnumber)
    {
        this.pinnumber=pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
         setTitle("FastCash  Page");
        setSize(900,900);
        setVisible(true);
        setLocation(300,0);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel Text = new JLabel("Please select your Withdrawl Amount") ;
        Text.setBounds(210,300,700,35);
        Text.setFont(new Font("System",Font.BOLD,16));
        Text.setForeground(Color.white);
        image.add(Text);
    
        
         deposit = new JButton("Rs 100");
        deposit.setBounds(150,398,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
         withdrawl  = new JButton("Rs 500");
        withdrawl.setBounds(355,398,150,30);
        withdrawl.addActionListener(this);    
        image.add(withdrawl);
         fastcash = new JButton("Rs 1000");
        fastcash.setBounds(150,431,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
         ministatement = new JButton("Rs 2000");
        ministatement.setBounds(355,431,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);
         pinchange = new JButton("Rs 5000");
        pinchange.setBounds(150,464,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
         balanceenquiry = new JButton("Rs 10000");
        balanceenquiry.setBounds(355,464,150,30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
         exit = new JButton("Back");
        exit.setBounds(150,497,355,30);
        exit.addActionListener(this);
        image.add(exit);
        
    }
    
   public static void main(String arg[])
   {
        new FastCash("");
   }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        if (ae.getSource() == exit) {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    } else {
        String amount = ((JButton)ae.getSource()).getText().substring(3).trim();
        System.out.println("Amount string before parsing: [" + amount + "]"); // DEBUG

        Conn c = new Conn();
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            int balance = 0;
            while (rs.next()) {
                String type = rs.getString("type").trim();
                String amt = rs.getString("amount").trim();
                System.out.println("DB type: [" + type + "], amount: [" + amt + "]"); // DEBUG

                if (type.equals("Deposit")) {
                    balance += Integer.parseInt(amt);
                } else {
                    balance -= Integer.parseInt(amt);
                }
            }

            if (balance < Integer.parseInt(amount)) {
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
                return;
            }

            Date date = new Date();
            String query = "insert into bank values('" + pinnumber + "', '" + date + "', 'Withdraw', '" + amount + "')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Rs " + amount + " Debited Successfully");
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    }//clossing of ActionPerformed
}
