package bank.management.system; 
import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Transactions extends JFrame implements ActionListener{
    JButton deposit,withdrawl,fastcash,ministatement,exit,pinchange,balanceenquiry;
    String pinnumber;
    Transactions(String pinnumber)
    {
        this.pinnumber=pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
         setTitle("Transaction Page");
        setSize(900,900);
        setVisible(true);
        setLocation(300,0);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel Text = new JLabel("Please select your Transaction") ;
        Text.setBounds(210,300,700,35);
        Text.setFont(new Font("System",Font.BOLD,16));
        Text.setForeground(Color.white);
        image.add(Text);
    
        
         deposit = new JButton("Deposit");
        deposit.setBounds(150,398,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
         withdrawl  = new JButton("Cash Withdrawl");
        withdrawl.setBounds(355,398,150,30);
        withdrawl.addActionListener(this);    
        image.add(withdrawl);
         fastcash = new JButton("Fast Cash");
        fastcash.setBounds(150,431,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
         ministatement = new JButton("Mini Statement");
        ministatement.setBounds(355,431,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);
         pinchange = new JButton("Pin Change");
        pinchange.setBounds(150,464,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
         balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.setBounds(355,464,150,30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
         exit = new JButton("Exit");
        exit.setBounds(150,497,355,30);
        exit.addActionListener(this);
        image.add(exit);
        
    }
    
   public static void main(String arg[])
   {
        new Transactions("");
   }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource ()==exit)
        {
           System.exit(0); 
        }
        else if(ae.getSource()==deposit)
        {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==withdrawl)
        {
                        setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }
           else if(ae.getSource()==fastcash)
        {
                        setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }
           else if(ae.getSource()==pinchange)
        {
                        setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }
           else if(ae.getSource()==balanceenquiry)
        {
                        setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }
           else if(ae.getSource()==ministatement)
        {
            new MiniStatement(pinnumber).setVisible(true);
        }
    }//clossing of ActionPerformed
}
