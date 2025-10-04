package bank.management.system;
import javax.swing.*; //frames
import java.awt.*; //bounds and locate
import java.awt.event.*; // for ActionListener
import java.util.*;
import com.toedter.calendar.JDateChooser;
public class SignupOne extends JFrame implements ActionListener
{
    JTextField nameTextField,fnameTextField,emailTextField,cityTextField,stateTextField,pcodeTextField,addressTextField;
    JDateChooser dateChooser;
    JRadioButton male,female,maried,unmaried,others;
    ButtonGroup genderGroup,maritalGroup;
    JButton button;
    long random;
    SignupOne()
    {
        //PanelBasics
        setTitle("REGISTER A NEW CUSTOMER");
        setSize(850,800);
        setVisible(true);
        setLocation(550,150);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        Random ran = new Random();
        random = Math.abs((ran.nextLong()%9000L)+1000L);
        JLabel formno = new JLabel("Application Form no. "+ random );
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);
        JLabel personalDetails = new JLabel("Page 1 : User's Details");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personalDetails.setBounds(290,80,400,30);
        add(personalDetails);
        
        JLabel name = new JLabel("Full Name : ");
        name.setFont(new Font("Raleway",Font.BOLD,15));
        name.setBounds(100,140,100,30);
        add(name);
        nameTextField = new JTextField();
        nameTextField.setBounds(300, 140, 400, 30);
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        add(nameTextField);
        
        JLabel fname = new JLabel("Father's Name : ");
        fname.setFont(new Font("Raleway",Font.BOLD,15));
        fname.setBounds(100,190,200,30);
        add(fname);
        fnameTextField = new JTextField();
        fnameTextField.setBounds(300, 190, 400, 30);
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        add(fnameTextField);
        
        JLabel dob = new JLabel("Date of Birth : ");
        dob.setFont(new Font("Raleway",Font.BOLD,15));
        dob.setBounds(100,240,200,30);
        add(dob);
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        add(dateChooser);
        dateChooser.setForeground(Color.BLACK);
                
        JLabel gender = new JLabel("Gender : ");
        gender.setFont(new Font("Raleway",Font.BOLD,15));
        gender.setBounds(100,290,200,30);
        add(gender);
        male = new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        female = new JRadioButton("Female");
        female.setBounds(390,290,70,30);
        male.setBackground(Color.white);
        female.setBackground(Color.white);
        add(female);
        add(male);
        
        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        
        JLabel email = new JLabel("Email ID : ");
        email.setFont(new Font("Raleway",Font.BOLD,15));
        email.setBounds(100,340,200,30);
        add(email);
        emailTextField = new JTextField();
        emailTextField.setBounds(300, 340, 400, 30);
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        add(emailTextField);
        
        
        JLabel mstatus = new JLabel("Marital Status : ");
        mstatus.setFont(new Font("Raleway",Font.BOLD,15));
        mstatus.setBounds(100,390,200,30);
        add(mstatus);
        
        unmaried = new JRadioButton("Unmarried");
        unmaried.setBounds(300,390,90,30);
        maried = new JRadioButton("Married");
        maried.setBounds(390,390,70,30);
        others = new JRadioButton("Others");
        others.setBounds(460,390,70,30);
        maried.setBackground(Color.white);
        others.setBackground(Color.white);
        unmaried.setBackground(Color.white);
        add(maried);
        add(unmaried);
        add(others);
        
        maritalGroup = new ButtonGroup();
        maritalGroup.add(maried);
        maritalGroup.add(unmaried);
        maritalGroup.add(others);
        
        JLabel address = new JLabel("Address : ");
        address.setFont(new Font("Raleway",Font.BOLD,15));
        address.setBounds(100,440,200,30);
        add(address);
        addressTextField = new JTextField();
        addressTextField.setBounds(300, 440, 400, 30);
        addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        add(addressTextField);
        
        JLabel city = new JLabel("City : ");
        city.setFont(new Font("Raleway",Font.BOLD,15));
        city.setBounds(100,490,200,30);
        add(city);
        cityTextField = new JTextField();
        cityTextField.setBounds(300, 490, 400, 30);
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        add(cityTextField);
        
        JLabel pcode = new JLabel("Pincode : ");
        pcode.setFont(new Font("Raleway",Font.BOLD,15));
        pcode.setBounds(100,540,200,30);
        add(pcode);
        pcodeTextField = new JTextField();
        pcodeTextField.setBounds(300, 540, 400, 30);
        pcodeTextField.setFont(new Font("Raleway",Font.BOLD,14));
        add(pcodeTextField);
        
        JLabel state = new JLabel("State : ");
        state.setFont(new Font("Raleway",Font.BOLD,15));
        state.setBounds(100,590,200,30);
        add(state);
        stateTextField = new JTextField();
        stateTextField.setBounds(300, 590, 400, 30);
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        add(stateTextField);
        
        button = new JButton("Next");
        button.setBackground(Color.black);
        button.setBounds(620,660,80,30);
        button.setForeground(Color.white);
        button.addActionListener(this);
        add(button);
        
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        String formno = "" + random; //its a long value
        String name = nameTextField.getText(); //gets the value of textfield
        String fname = fnameTextField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "male";
        }
        else if (female.isSelected())
        {
            gender = "female";
        }
        String email = emailTextField.getText();
        String marital = null;
          if(maried.isSelected()){
            marital = "Married";
        }
        else if (unmaried.isSelected())
        {
            marital = "Unmarried";
        }
        else if (others.isSelected())
        {
            marital = "Other";
        }
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pcodeTextField.getText();
        
        try
        {
            if(name.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Name is Missing");
            }
            else if(fname.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Father's Name is Missing");
            }
            else if(city.equals(""))
            {
                JOptionPane.showMessageDialog(null,"City is Missing");
            }
            else if(state.equals(""))
            {
                JOptionPane.showMessageDialog(null,"State is Missing");
            }
            else if(email.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Email is Missing");
            }
            else if(pin.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Pincode is Missing");
            }
            else if(address.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Address is Missing");
            }
            else if(gender.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Gender is Missing");
            }
            else if(marital.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Marital Status is Missing");
            }
            else
            {
                Conn c = new Conn();
                String query = "insert into signup values ('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+city+"','"+state+"','"+marital+"','"+pin+"','"+address+"')";

                c.s.executeUpdate(query);
                setVisible(false);
                new  SignupTwo(formno).setVisible(true);
                
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public static void main(String args[])
    {
        new  SignupOne();
    }
}
