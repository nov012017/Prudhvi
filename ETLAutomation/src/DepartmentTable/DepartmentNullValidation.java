package DepartmentTable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.sql.CallableStatement;
import java.sql.ResultSetMetaData;

public class DepartmentNullValidation 
{
	public static void main(String[] args) 
	{
		int nullcount = 0;
		Connection con=null;
		Statement s1 = null;
		
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String userName = "maqplex";
            String password = "India@123";
            String url = "jdbc:sqlserver://35.164.49.234";
            con = DriverManager.getConnection(url, userName, password);
            String Sourcequery="select COUNT(dept_no) from [employees].[dbo].[departments] where Dept_no is null\r\n" + 
            		"union\r\n" + 
            		"select COUNT(dept_name) from [employees].[dbo].[departments] where dept_name is null; ";
            
            s1 = con.createStatement();
            ResultSet rs = s1.executeQuery(Sourcequery);
          
            
            while (rs.next()) 
            {
            	System.out.println(rs.getString(1));
            	if (Integer.parseInt(rs.getString(1))==0)
            	{
            		System.out.println("No null values are not present");
            	}
            	else
            	{
            		System.out.println("No null values are present");
            	}
       
            }
           
          
		}
		catch (ClassNotFoundException e) 
		{
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		catch (SQLException e1)
		{
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
		
		finally
		{
            try
            {
                if(s1 != null) s1.close();
                if(con != null) con.close();
            } catch(Exception ex){}
        }
	}

}
