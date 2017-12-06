package DepartmentTable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DepartmentDataValidation {

	public static void main(String[] args) 
	{
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String userName = "maqplex";
            String password = "India@123";
            String url = "jdbc:sqlserver://35.164.49.234";
            Connection con = DriverManager.getConnection(url, userName, password);
            String Datavalidation=
            		"SELECT dept_no,dept_name\r\n" + 
            		"  FROM [employees].[dbo].[departments]\r\n" + 
            		 
            		"Except\r\n" + 
            		"SELECT dept_no,dept_name\r\n" + 
            		"  FROM [employees].[dbo].[departments]\r\n" + 
            		"UNION\r\n" + 
            		"SELECT dept_no,dept_name\r\n" + 
            		"  FROM [employees].[dbo].[departments]\r\n" + 
            		"  Except\r\n" + 
            		"SELECT dept_no,dept_name\r\n" + 
            		"  FROM [employees].[dbo].[departments]\r\n" ;
            
            Statement s1 = con.createStatement();
            ResultSet rs = s1.executeQuery(Datavalidation);
            
           
            
            
            while (rs.next()) 
            {
            
            	System.out.println(rs.getString(1)+ " "+rs.getString(2));	
            }
        
            
          
		}
		catch (Exception e)
        {
            e.printStackTrace();
        }

	}

}
