package bank.management.system;
import javax.swing.*; //frames
import java.awt.*; //bounds and locate
import java.awt.event.*; // for ActionListener
import java.util.*;
import com.toedter.calendar.JDateChooser;
public class SignupTwo extends JFrame implements ActionListener
{
    JTextField nameTextField,fnameTextField,emailTextField,valAadharNumber,stateTextField,pcodeTextField,valPanNumber;
    JDateChooser dateChooser;
    JRadioButton syes,sno,eyes,eno,others;
    ButtonGroup genderGroup,maritalGroup;
    JButton button;
    String formno;
    JComboBox  religion,category,income,education,occupation;
    SignupTwo(String formno)
    {
        this.formno=formno; 
        //PanelBasics
        setTitle("Continue form");
        setSize(850,800);
        setVisible(true);
        setLocation(550,150);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
//        JLabel formno = new JLabel("Application Form no. "+ random );
//        formno.setFont(new Font("Raleway",Font.BOLD,38));
//        formno.setBounds(140, 20, 600, 40);
//        add(formno);
        JLabel additionalDetails = new JLabel("Page 2 : Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
        JLabel name = new JLabel("Religion  : ");
        name.setFont(new Font("Raleway",Font.BOLD,15));
        name.setBounds(100,140,100,30);
        add(name);
          String  valReligion[] = {"Hindu", "Sikh", "Muslim", "Christian", "Other" };
        religion =  new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.white);
        add(religion);
        
        JLabel fname = new JLabel("Category  : ");
        fname.setFont(new Font("Raleway",Font.BOLD,15));
        fname.setBounds(100,190,200,30);
        add(fname);
        String  valCategory[] = {"General ", "OBC", "SC", "ST", "Other" };
         category =  new JComboBox(valCategory);
        category.setBounds(300, 190, 400, 30);
        //category.setFont(new Font("Raleway",Font.BOLD,14));
        add(category);
        
        JLabel dob = new JLabel("Income  : ");
        dob.setFont(new Font("Raleway",Font.BOLD,15));
        dob.setBounds(100,240,200,30);
        add(dob);
         String  valIncome[] = {"Null ", "<1,50,5000", "<2,50,000", "<5,00,000", "<10,00,000" };
        income  = new JComboBox(valIncome);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.white);
        add(income);

                
        JLabel gender = new JLabel("Educational ");
        gender.setFont(new Font("Raleway",Font.BOLD,15));
        gender.setBounds(100,290,200,30);
        add(gender);        
        JLabel email = new JLabel("Qualification  : ");
        email.setFont(new Font("Raleway",Font.BOLD,15));
        email.setBounds(100,305,200,30);
        add(email);
        String  valEducation[] = {"Non-Graduate ", "Graduate", "Post-Graduate", "Doctrate", "Others" };
        education  = new JComboBox(valEducation);
        education.setBounds(300,300,400,30);
        education.setBackground(Color.white);
        add(education);
        
        
        JLabel mstatus = new JLabel("Occupation  : ");
        mstatus.setFont(new Font("Raleway",Font.BOLD,15));
        mstatus.setBounds(100,390,200,30);
        add(mstatus);
        String  valOccupation[] = {"Student ", "Salaried", "Self-Employed", "Bussinessman", "Retired","Others" };
        occupation  = new JComboBox(valOccupation);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.white);
        add(occupation);
       
        
        JLabel address = new JLabel("PAN Number  : ");
        address.setFont(new Font("Raleway",Font.BOLD,15));
        address.setBounds(100,440,200,30);
        add(address);
        valPanNumber = new JTextField();
        valPanNumber.setBounds(300, 440, 400, 30);
        valPanNumber.setFont(new Font("Raleway",Font.BOLD,14));
        add(valPanNumber);
        
        JLabel city = new JLabel("Aadhar Number  : ");
        city.setFont(new Font("Raleway",Font.BOLD,15));
        city.setBounds(100,490,200,30);
        add(city);
        valAadharNumber = new JTextField();
        valAadharNumber.setBounds(300, 490, 400, 30);
        valAadharNumber.setFont(new Font("Raleway",Font.BOLD,14));
        add(valAadharNumber);
        
        JLabel pcode = new JLabel("Are you a Senior Citizen  : ");
        pcode.setFont(new Font("Raleway",Font.BOLD,15));
        pcode.setBounds(100,540,200,30);
        add(pcode);
     syes = new JRadioButton("Yes");
        syes.setBounds(300,540,50,30);
        sno = new JRadioButton("No");
        sno.setBounds(390,540,50,30);
        syes.setBackground(Color.white);
        sno.setBackground(Color.white);
        add(sno);
        add(syes);
        
        genderGroup = new ButtonGroup();
        genderGroup.add(syes);
        genderGroup.add(sno);
        
        JLabel state = new JLabel("Had  a Existing Account  ?  : ");
        state.setFont(new Font("Raleway",Font.BOLD,15));
        state.setBounds(100,590,200,30);
        add(state);
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300,590,50,30);
       eno = new JRadioButton("No");
        eno.setBounds(390,590,50,30);
        eyes.setBackground(Color.white);
        eno.setBackground(Color.white);
        add(eno);
        add(eyes);
        
        genderGroup = new ButtonGroup();
        genderGroup.add(eyes);
        genderGroup.add(eno);
        
        button = new JButton("Next");
        button.setBackground(Color.black);
        button.setBounds(620,660,80,30);
        button.setForeground(Color.white);
        button.addActionListener(this);
        add(button);
        
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        String sreligion =  (String)religion.getSelectedItem(); //gets the value of textfield
        String scategory  =   (String)category.getSelectedItem();
        String sincome =  (String)income.getSelectedItem();
        String seducation = (String)education.getSelectedItem();
        String seniorCitizen = "";
        if(syes.isSelected()){
            seniorCitizen = "Yes";
        }
        else if (sno.isSelected())
        {
            seniorCitizen = "No";
        }
       String existingAccount="";
        if(eyes.isSelected()){
            existingAccount = "Yes";
        }
        else if (eno.isSelected())
        {
            existingAccount = "No";
        }
        String soccupation = (String)occupation.getSelectedItem();
        String span = valPanNumber.getText();
        String saadhar = valAadharNumber.getText();
//        String pin = pcodeTextField.getText();
        
        try
        {
            if(sreligion.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Religion  is Missing");
            }
            else if(scategory.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Category is Missing");
            }
            else if(sincome.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Income is Missing");
            }
            else if(seducation.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Education Qualification is Missing");
            }
            else if(seniorCitizen.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Senior Citizen entry  is Missing");
            }
            else if(existingAccount.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Existing Acc Detail  is Missing");
            }
            else if(soccupation.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Occupation is Missing");
            }
            else if(span.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Pan Number is Missing");
            }
            else if(saadhar.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Aadhar Number is Missing");
            }
            else
            {
                Conn c = new Conn();
                String query = "insert into signupTwo values ('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+seniorCitizen+"','"+existingAccount+"','"+soccupation+"','"+span+"','"+saadhar+"')";

                c.s.executeUpdate(query);
                setVisible(false);
                 new  SignupThree(formno).setVisible(true);
                
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public static void main(String args[])
    {
        new  SignupTwo("");
    }
}
