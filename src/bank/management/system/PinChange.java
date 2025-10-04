package bank.management.system;
import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
public class PinChange extends JFrame implements ActionListener
{
    String pinnumber;
    JTextField pin,repin;
    JButton change,back;
    PinChange(String pinnumber)
    {
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 =  i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        
          setTitle("PinChange Page");
        setSize(900,900);
        setVisible(true);
        setLocation(300,0);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("Change your Pin");
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(270,280,500,35);
        image.add(text);
        JLabel pintext = new JLabel("New Pin : ");
        pintext.setForeground(Color.white);
        pintext.setFont(new Font("System",Font.BOLD,16));
        pintext.setBounds(165,320,180,25);
        image.add(pintext);
        
         pin = new JTextField();
        pin.setFont(new Font("System",Font.BOLD,25));
        pin.setBounds(330,320,180,25);
        image.add(pin);
        
        JLabel repintext = new JLabel("Confirm new Pin : ");
        repintext.setForeground(Color.white);
        repintext.setFont(new Font("System",Font.BOLD,16));
        repintext.setBounds(165,360,180,25);
        image.add(repintext);
        
           repin = new JTextField();
    repin.setFont(new Font("System",Font.BOLD,25));
        repin.setBounds(330,360,180,25);
        image.add(repin);
        
         change = new JButton("Change");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);
         back = new JButton("Back");
        back.setBounds(355,520,150,30);
         back.addActionListener(this);
        image.add(back);
    }
    public static void main(String arg[])
    {
        new PinChange("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource()==back)
        {
            setVisible(false);
            new Transactions("pinnumber").setVisible(true);
        }
            else if (ae.getSource()==change)      
                    {
                     try
            {
                String npin = pin.getText();
                String rpin = repin.getText();
                if (!npin.equals(rpin)) {
    JOptionPane.showMessageDialog(null, "Entered PINs do not match");
    return;
}
if (npin.equals("")) {
    JOptionPane.showMessageDialog(null, "Enter new PIN");
    return;
}
if (rpin.equals("")) {
    JOptionPane.showMessageDialog(null, "Re-enter new PIN");
    return;
}
                Conn conn = new Conn();
          String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
String query2 = "update login set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"'";
String query3 = "update signupthree set pin = '"+rpin+"' where pin = '"+pinnumber+"'";

              conn.s.executeUpdate(query1);
              conn.s.executeUpdate(query2);
              conn.s.executeUpdate(query3);
              JOptionPane.showMessageDialog(null,"Pin changed successfully");  
              setVisible(false);
              new Transactions(pinnumber).setVisible(true);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
                    }
        }
        
      //  throw new UnsupportedOperationException("Not supported yet."); 
    }
    


