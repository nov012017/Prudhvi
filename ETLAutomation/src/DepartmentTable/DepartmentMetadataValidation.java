package DepartmentTable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
 
public class DepartmentMetadataValidation {
 
    public static void main(String a[]){
         
        Connection con = null;
        Statement st = null; 
        ResultSet rs = null;
        try {
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        	String userName = "maqplex";
            String password = "India@123";
            String url = "jdbc:sqlserver://35.164.49.234";
            con = DriverManager.getConnection(url, userName, password);
            st = con.createStatement();
            rs = st.executeQuery("select * from [employees].[dbo].[departments];");
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            for(int i=1;i<=columnCount;i++){
                System.out.println(rsmd.getColumnName(i)+"  "+
                		rsmd.getColumnType(i)+"  "+ 
                		rsmd.isNullable(i)+"  "+
                		rsmd.getColumnTypeName(i)+"  "+
                		rsmd.getColumnDisplaySize(i));  
            }
        } 
        catch (ClassNotFoundException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        catch (SQLException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        finally
        {
            try
            {
                if(rs != null) rs.close();
                if(st != null) st.close();
                if(con != null) con.close();
            } catch(Exception ex){}
        }
    }
}