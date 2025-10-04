package bank.management.system;
import java.sql.*;
public class Conn 
{
    Connection c;
    Statement s;
    public Conn()
    {
        try
        {
           // Class.forName(com.mysql.cj.jdbc.Driver); NOT REQUIRED anymore due to tech
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","221120");
            s = c.createStatement();
        } catch (Exception e)
        {
            System.out.print(e);
        }
    }
    
}
