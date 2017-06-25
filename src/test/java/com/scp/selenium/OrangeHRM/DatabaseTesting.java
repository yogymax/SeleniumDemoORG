/**
 * 
 */
package com.scp.selenium.OrangeHRM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author Progvaltion_11
 *
 */
public class DatabaseTesting {

	
	public static void main(String[] args) throws Exception {
		
		/**
		 * Make sure database jar is present in a classpath
		 * 1. Download db specific jar from net
		 * 2. Right click on ur proj > Build path > Configure build path
		 * >Add Library > User library > Add/New > Specify some name > Add External jars> point it to the
		 * downloaded jar file
		 * 3. Search db connection string i.e. url on internet
		 */
		
		/**
		 * Database Connectivity Steps
		 * 1.Load the database drivers
		 * 2.Create the connection  (It's just an acknowledment,means handshaking done)
		 * 		Param1 > Database URL
		 * 					1. Protocol
		 * 					2. DB ip Address
		 * 					3. Port
		 * 					4. DB schema name
		 * 		Param2 > DB Username
		 * 		Param3 > DB Password
		 * 3.Create the statement/PreparedStatement (Communication channel between java n db to execute the query)
		 * 4.Execute query and get Resultset
		 * 5. Close the connection
		 * 
		 * 
		 * 
		 * Java								DB
		 * int	long float double			Number
		 * String							varchar
		 * To hold Larger String			CLOB  > Character large Object
		 * To hold images or binary data	BLOB  > Binary large Object
		 * 
		 * 
		 * 
		 * String to BLOB
		 *	String strContent = s;
    		byte[] byteConent = strContent.getBytes();
    		Blob blob = connection.createBlob();//Where connection is the connection to db object. 
    		blob.setBytes(1, byteContent);
    		
    		
		 */
		
		String hsqlDBUrl ="jdbc:hsqldb:hsql://localhost/";
		String dbUsername = "SA";
		String dbPassword ="";
		String dbQuery="select * from empcaching where empid=2";
		
		Class.forName("org.hsqldb.jdbcDriver"); //1
		Connection connection = DriverManager.getConnection(hsqlDBUrl,dbUsername,dbPassword);//2
		Statement stmt = connection.createStatement();//3
		ResultSet resultset = stmt.executeQuery(dbQuery);//4
		while(resultset.next()){
			System.out.println();
			System.out.print("	EmpID : "+resultset.getString("empid"));
			System.out.print("|	EmpEmpName : "+resultset.getString("empname"));
			System.out.print("|	EmpAddress : "+resultset.getString("empaddress"));
		}
		stmt.close();//5
		resultset.close();//5
		connection.close();//5
		
		
	}
	
}
