package GenericUtility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.OracleDriver;

public class DbUtility {
	static ResultSet result;
	static Connection con;
	static FileUtility fu = new FileUtility();

//	1.Create program for connect to db
	
	public static void connectToDbL() throws IOException {
		Driver driverRef;
		
		try {
			driverRef = new OracleDriver();
			DriverManager.registerDriver(driverRef);
			con = DriverManager.getConnection(fu.getDataFromPropertiesFile("DB_URL"),fu.getDataFromPropertiesFile("DB_Username"),fu.getDataFromPropertiesFile("DB_Password"));
		} catch (SQLException e) {
            e.printStackTrace();
		}
	}
//	2. disconnec to db
	
	public static void closeDb() throws SQLException {
		con.close();
	}
//	3. executer query in the db
	
	public static ResultSet executeQuery(String query) throws SQLException {
		try {
			
				result = con.createStatement().executeQuery(query);
				return result;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		return result;
	}
	
	//4 executequery and verify
	
	public static boolean executeQueryVerifyAndGetData(String query, int columnIndex, String expectedData) throws SQLException {
		boolean flag = false;
		result = con.createStatement().executeQuery(query);
		while(result.next()) {
			if(result.getString(columnIndex).equals(expectedData)) {
				flag=true;
				break;
			}
		}
		if(flag) {
			System.out.println(expectedData +"==> data is verified form db");
			return true;
		}else {
			System.out.println(expectedData +"==> data is not verified form db");
			return false;
		}
	}
}
