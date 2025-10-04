package bank.management.system;
import javax.swing.*; //frames
import java.awt.*; //bounds and locate
import java.awt.event.*; // for ActionListener
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class SignupThree  extends JFrame implements ActionListener
{
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3 ;
    JButton submit,cancel;
    String formno;

    SignupThree(String formno)
    {
        this.formno=formno;
        setTitle("Account detail form");
        setSize(850,800);
        setVisible(true);
        setLocation(550,150);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel L1 = new JLabel("Page 3 : Account Details");
        L1.setFont (new Font("Raleway",Font.BOLD,22));
        L1.setBounds(290,80,400,30);
        add(L1);
        
        JLabel type = new JLabel("Account Type :");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,140,200,30);
        add(type);
 
        r1=new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.white);
        r1.setBounds(100,180,150,20);
        add(r1);
        r2=new JRadioButton("FD Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.white);
        r2.setBounds(350,180,150,20);
        add(r2);
        r3=new JRadioButton("Current  Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.white);
        r3.setBounds(100,220,170,20);
        add(r3);
        r4=new JRadioButton("RD Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.white);
        r4.setBounds(350,220,150,20);
        add(r4);
        ButtonGroup groupAccount=new ButtonGroup();
        groupAccount.add(r1);
        groupAccount.add(r2);
        groupAccount.add(r3);
        groupAccount.add(r4);
        
            JLabel card = new JLabel("Card Number :");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,300,200,30);
        add(card);
        JLabel carddetail = new JLabel("Your 16 Digit Card Number");
        carddetail.setFont(new Font("Raleway",Font.BOLD,12));
        carddetail.setBounds(100,330,200,20);
        add(carddetail);
        JLabel number = new JLabel("XXXX-XXXX-XXXX-1374");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(330,300,300,30);
        add(number);
        
            JLabel pin = new JLabel("Pin :");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,370,200,30);
        add(pin);
        JLabel pindetail = new JLabel("Your 4 Digit Pin ");
        pindetail.setFont(new Font("Raleway",Font.BOLD,12));
        pindetail.setBounds(100,400,200,20);
        add(pindetail);
        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pnumber.setBounds(330,370,200,30);
        add(pnumber);
        
         JLabel services = new JLabel("Services Required :");
        services.setFont(new Font("Raleway",Font.BOLD,22));
        services.setBounds(100,450,200,30);
        add(services);
        c1 = new JCheckBox("Atm Card");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,500,200,30);
        add(c1);
        c2 = new JCheckBox("Cheque Book");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,500,200,30);
        add(c2);
        c3 = new JCheckBox("I hereby declares that the above entered information are correct to the best of my Knowledge. ");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Raleway",Font.BOLD,12));
        c3.setBounds(100,680,600,30);
        add(c3);
     
        submit = new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setBounds(220, 720 , 100, 30);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        add(submit);
        submit.addActionListener(this);
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setBounds(420, 720 , 100, 30);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        add(cancel);
          cancel.addActionListener(this);
        getContentPane().setBackground(Color.white);
     
        
    }
    
    public static void main(String arg[])
    {
        new SignupThree("");
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==submit)
        {
            String accountType=null;
            if(r1.isSelected())
            {
                accountType="Saving Account";
            }
            else if(r2.isSelected())
            {
                  accountType="FD Account";
            }
            else if(r3.isSelected())
            {
                  accountType="Current Account";
            }
            else if(r4.isSelected())
            {
                  accountType="RD Account";
            }
            Random random = new Random();
//            String cardnumber =  ""  +  Math.abs((random.nextLong() % 90000000L))  +  5040936000000000L;
//            String pinnumber = "" + Math.abs((random.nextLong() % 9000L)) + 1000L;
//String cardnumber = String.format("%012d", new Random().nextLong() % 1_000_000_000_000L);
//String pinnumber = String.format("%04d", new Random().nextInt(10_000));
String cardnumber = String.format("%012d",ThreadLocalRandom.current().nextLong(0L, 1_000_000_000_000L));
String pinnumber = String.format("%04d",ThreadLocalRandom.current().nextInt(0, 10_000));      
String facility = "";
            if(c1.isSelected())
            {
                facility = facility + "Atm Card ";
            }
            if(c2.isSelected())
            {
                facility = facility + "Cheque Book ";
            }
            try
            {
               
                    Conn conn = new Conn();
                    String query1 = "insert into signupthree  values ('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')" ;
                    String query2= "insert into login  values ('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    setVisible(false);
                            new Deposit(pinnumber).setVisible(true);
                    JOptionPane.showMessageDialog(null, "Card Number : "+ cardnumber + " \n Pin Number  : " + pinnumber);
//                    new SignupThree(formno).setVisible(true);
                
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(ae.getSource()==cancel)
        {
            setVisible(false);
        }
    }

    
}
