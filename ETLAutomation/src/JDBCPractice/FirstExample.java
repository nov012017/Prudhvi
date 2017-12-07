package JDBCPractice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.math.* ; // for BigDecimal and BigInteger support
public class FirstExample 
{
	//Database Connection 
	static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
	static final String DB_URL = "jdbc:sqlserver://35.164.49.234";
	 //Update done
	 //Database Credentials
	 static final String USER = "maqplex";
	 static final String PASS = "India@123";
	public static void main(String[] args)
	{
		Connection conn = null;
		Statement stmt = null;
		try
		{
		//STEP 2: Register JDBC Connection
		Class.forName(JDBC_DRIVER);
		//STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);
	    //STEP 4: Execute a query
	      System.out.println("Creating statement...");
	      stmt = conn.createStatement();
	      String sql;
	      sql = "SELECT COUNT(*) as Count FROM employees.dbo.departments";
	      ResultSet rs = stmt.executeQuery(sql);
	    //STEP 5: Extract data from result set
	      while(rs.next())
	      {
	          //Retrieve by column name
	          int count  = rs.getInt("Count");
	          //Display values
	          System.out.print("Target Count: " + count);
	       }
	    //STEP 6: Clean-up environment
	      rs.close();
	      stmt.close();
	      conn.close();
		}
		catch(SQLException se)
		{
		   //Handle errors for JDBC
		   se.printStackTrace();
		}
		catch(Exception e)
		{
		      //Handle errors for Class.forName
		      e.printStackTrace();
		}
		finally
		{
		      //finally block used to close resources
		   try
		   {
		       if(stmt!=null)
		       stmt.close();
		    }
		   catch(SQLException se2)
		   {
		   }// nothing we can do
		   try
		   {
		         if(conn!=null)
		            conn.close();
		   }
		   catch(SQLException se)
		   {
		         se.printStackTrace();
		    }//end finally try
		 }
	}

}
