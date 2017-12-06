package DepartmentTable;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class DepartmentDatabaseMetadata{
 
    public static void main(String a[]) throws ClassNotFoundException{
         
        Connection con = null;
        try {
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String userName = "maqplex";
            String password = "India@123";
            String url = "jdbc:sqlserver://35.164.49.234";
            con = DriverManager.getConnection(url, userName, password);
            DatabaseMetaData dm = con.getMetaData();
            System.out.println(dm.getDriverVersion());
            System.out.println(dm.getDriverName());
            System.out.println(dm.getDatabaseProductName());
            System.out.println(dm.getDatabaseProductVersion());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally{
            if(con != null){}
                try {
                    con.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
