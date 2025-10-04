package bank.management.system;
import javax.swing.*; //frames
import java.awt.*; //bounds and locate
import java.awt.event.*; // for ActionListener
import java.sql.*;
public class Login extends JFrame implements ActionListener
{
    JButton login , clear , signup; //declaring globally so can be used in ActionPerformed
    JTextField cardTextField; //same reason as above
    JPasswordField pinTextField; //password entered will be hidden using this (same reason to globally initialize)
    Login()
    {
        setTitle("Automated teller machine");
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100 , Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);
        getContentPane().setBackground(Color.WHITE);
        
        add(label);
        JLabel text = new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);
        
        JLabel cardno = new JLabel("Card Number : ");
        cardno.setFont(new Font("Raleway",Font.BOLD,20));
        cardno.setBounds(120,150,400,40);
        add(cardno);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(300,150,230,40);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);
        
        JLabel pin = new JLabel("PIN : ");
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBounds(120,220,400,40);
        add(pin);
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 230, 40);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);
        
        login = new JButton("Sign In");
        login.setBounds(300,300,100,30);
        add(login);
        login.addActionListener(this);
        
        clear = new JButton("Reset");
        clear.setBounds(430,300,100,30);
        add(clear);
        clear.addActionListener(this);
        
        signup = new JButton("Register");
        signup.setBounds(300,350,230,30);
        add(signup);
        signup.addActionListener(this);
        
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
        
    }
    //overriding ActionPerformed so our code can run without error to use ActionListerner
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()== clear)
        {
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if(ae.getSource()==login)
        {
        Conn conn = new Conn();
        String cardnumber =     cardTextField.getText();
        String pinnumber = pinTextField.getText();
        String query = "select * from login where cardnumber  = '"+cardnumber+"' and pinnumber = '"+pinnumber+"' ";
        try{
            ResultSet rs = conn.s.executeQuery(query);
            if(rs.next())
            {
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Incorrect CardNumber or Pin");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        }
        else if(ae.getSource()==signup)
        {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    
    
    public static void main(String arg[])
    {
        new Login();
    }
}
