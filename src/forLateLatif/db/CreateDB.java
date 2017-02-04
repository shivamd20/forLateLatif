package forLateLatif.db;

import java.awt.print.Book;
import java.sql.Connection;
import forLateLatif.db.Contract;
import forLateLatif.db.Contract.BookIssued;
import forLateLatif.db.Contract.Student;

import java.sql.SQLException;
import java.sql.Statement;

public class CreateDB {

	public static void main(String ...args)
	{
		CreateDB db=new CreateDB();
		
		db.createIssueTable();
	}
	public boolean createStudentTable()
	{
		Connection con=null;
		try {
			con = Contract.getDBConnection();
		} catch (SQLException e) {
			return false;
		}
		
		String sql="CREATE TABLE "+Contract.Student.tableName+" ("
				+""+Contract.Student.edrpno+"	INTEGER UNIQUE,"+
				""+Contract.Student.email+"	TEXT NOT NULL UNIQUE,"+
				""+Contract.Student.mobile+"	INTEGER NOT NULL UNIQUE,"
				+""+Contract.Student.name+"	TEXT NOT NULL,"
				+""+Contract.Student.sex+"	TEXT NOT NULL,"
				+""+Contract.Student.sem+"	TEXT NOT NULL,"
				+""+Contract.Student.branch+"	TEXT NOT NULL,"
				+""+Contract.Student.noOfBooks+"	INTEGER NOT NULL,"
				+" PRIMARY KEY("+Student.edrpno+")"
			+");";
		Statement st;
		try {
			st = con.createStatement();
			st.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		System.out.println("student table created"); 
		
		return true;
	}
	public boolean createIssueTable()
	{
		Connection con=null;
		try{
	
		try {
			con = Contract.getDBConnection();
		} catch (SQLException e) {
			return false;
		}
		
		String sql="CREATE TABLE "+BookIssued.tableName+" ("
				+""+BookIssued.bookName+"	TEXT NOT NULL,"+
				""+BookIssued.date+"	DATE NOT NULL,"+
				""+Contract.BookIssued.issuedby+"	TEXT NOT NULL,"
				+""+Contract.BookIssued.id+"	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT"
			+");";
		Statement st;
		try {
			st = con.createStatement();
			st.execute(sql);
			System.out.println("issue table created");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	finally
	{
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
}
