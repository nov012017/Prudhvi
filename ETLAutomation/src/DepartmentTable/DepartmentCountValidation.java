package DepartmentTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DepartmentCountValidation 
{
	static int sourcecount;
	static int targetcount;
	static String Result;

	/*	String userName = "maqplex";
	String password = "India@123";
	String url = "jdbc:sqlserver://35.164.49.234";
	 */	
	static String userName = "maqplex";
	static String password = "India@123";
	static String url = "jdbc:sqlserver://35.164.49.234";


	public int sourcecount(String Sourcequery, String TargetQuery) //to get the column count of Source Table
	{

		int count = 0;
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
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
	public int targetcount(String Targetquery) //to get the column count of Target Table
	{
		int count = 0;
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
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
	public String validation(String Sourcequery,  String TargetQuery)
	{
		DepartmentTableValidation a1=new DepartmentTableValidation();
		//Calling Source Count Method
		sourcecount=a1.sourcecount(Sourcequery);
		System.out.println("Source count is "+sourcecount);
		//Calling Target Count Method
		targetcount=a1.targetcount(TargetQuery);
		System.out.println("Target count is "+targetcount);
		if (targetcount>0)
		{
			if (targetcount==sourcecount)
			{
				System.out.println("Records count matched");

				Result="Records count matched";
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

		return Result;
	}
	/*public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con1 = DriverManager.getConnection(url, userName, password);
	     s1 = con1.createStatement();
	}*/

}
