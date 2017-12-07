package JDBCPractice;
import java.sql.*; 

public class PreparedStmt 
{
	static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
	static final String DB_URL = "jdbc:sqlserver://35.164.49.234";
	 
	 //Database Credentials
	 static final String USER = "maqplex";
	 static final String PASS = "India@123";
	public static void main(String[] args) 
	{
		Connection conn = null;
		Statement stmt = null;
		try
		{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println("Creting query1");
			PreparedStatement pstmt=conn.prepareStatement("select count(*) as Count from employees.dbo.departments"); 
			System.out.println("Creting query2");
			ResultSet rs=pstmt.executeQuery();  
			System.out.println("Creting query3");
			while(rs.next())
		      {
		          //Retrieve by column name
		          int count  = rs.getInt("Count");
		          //Display values
		          System.out.print("Target Count: " + count);
		       }
		}
		catch (Exception e)
		{
			
		}
		// TODO Auto-generated method stub

	}

}
