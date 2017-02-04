package forLateLatif.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Contract {

	public static final String  dbName="studAck";
	
	public class Student{
		
		public final static String tableName="student";
		
	public final static String email="email";

	public final static String mobile="mobile";

	public final static String name="name";

	public final static String sex="sex";

	public final static String branch="branch";

	public final static String edrpno="edrpno";
	
	public final static String sem="sem";
	
	public final static String noOfBooks="noofbooks";
	
	
	}
	
	public class BookIssued{
		

		public final static String tableName="bookissued";
		
	public final static String bookName="bookname";

	public final static String date="date";

	public final static String issuedby="issuedby";
	
	public final static String id="id";
	
	}
	
	static Connection getDBConnection() throws SQLException
	{ 
		    try {
		      Class.forName("org.sqlite.JDBC");
		   return DriverManager.getConnection("jdbc:sqlite:"+dbName+".db");
		    } catch ( Exception e ) {
		     
		    }
		  return null;
	}
	
}
