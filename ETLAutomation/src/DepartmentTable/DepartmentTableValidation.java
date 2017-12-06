package DepartmentTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DepartmentTableValidation 
{
	static int sourcecount;
	static int targetcount;
	public int sourcecount(String Sourcequery)
	{
		int count = 0;
		try
		{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String userName = "maqplex";
        String password = "India@123";
        String url = "jdbc:sqlserver://35.164.49.234";
        Connection con1 = DriverManager.getConnection(url, userName, password);
        Statement s1 = con1.createStatement();
        ResultSet rs1 = s1.executeQuery(Sourcequery);
        while (rs1.next()) 
        {
        	count=rs1.getInt(1);
        }
		}
		catch (Exception e)
		{
			System.out.println("JDBC Connection Failed");
		}
		return count;
	}
	public int targetcount(String Targetquery)
	{
		int count = 0;
		try
		{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String userName = "maqplex";
        String password = "India@123";
        String url = "jdbc:sqlserver://35.164.49.234";
        Connection con2 = DriverManager.getConnection(url, userName, password);
        Statement s2 = con2.createStatement();
        ResultSet rs2 = s2.executeQuery(Targetquery);
        while (rs2.next()) 
        {
        	count=rs2.getInt(1);
        }
		}
		catch (Exception e)
		{
			System.out.println("JDBC Connection Failed");
		}
		return count;
	}
	public static void main(String[] args) 
	{
		DepartmentTableValidation a1=new DepartmentTableValidation();
		sourcecount=a1.sourcecount("SELECT count(*) FROM employees.dbo.departments where dept_no!='d001';");
		System.out.println("Source count is "+sourcecount);
		targetcount=a1.targetcount("SELECT count(*) FROM employees.dbo.departments where dept_no!='d001';");
		System.out.println("Target count is "+targetcount);
		if (targetcount>0)
        {
			if (targetcount==sourcecount)
	        {
	     	   System.out.println("Records count matched"); 
	        }
	        else if (targetcount<sourcecount)
	        {
	     	   System.out.println("Records not completely loaded totarget"); 
	        }
	        else if (targetcount>sourcecount)
	        {
	        	System.out.println("Unwanted records loaded to target"); 
	        }
	        else
	        {
	     	   System.out.println("Records count mismatch"); 
	        }  
        }
		else
		{
			System.out.println("Records not loaded to target"); 
		}
        
		
	}

}
