package forLateLatif.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import forLateLatif.db.Contract;
import forLateLatif.db.Contract.Student;;

public class CRUDOperation {

	public static void main(String[] args) {
		

	}
	
	static public boolean insertInStudentTable(Long edrpNo,String email,Long mobileNo,
			String name,String sex,int semester,String branch,int noOfBooks)
	{
		Connection con=null;
		try {
			con = Contract.getDBConnection();
			String sql="INSERT INTO "+Contract.Student.tableName+""
					+ "("+Student.branch+", "+Student.edrpno+", "+Student.email+
					", "+Student.mobile+
					","+Student.name+","+Student.noOfBooks+","+Student.sem+","+Student.sex+") VALUES"
					+ "(?,?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, branch);
			ps.setLong(2, edrpNo);
			ps.setString(3, email);
			ps.setLong(4, mobileNo);
			ps.setString(5, name);
			ps.setInt(6, noOfBooks);
			ps.setInt(7, semester);
			ps.setString(8, sex);
			
			ps.execute();
			con.close();
			
			System.out.println("inserted");
			return true;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			return false;
		}
	}	
	
	static public List<String> selectFromStudentTable(String what,String where) throws SQLException
	{
		ArrayList<String> names = new ArrayList<String>();
			ResultSet rs=selectAllFromStudentTable(what, where);
			while(rs.next())
			{
				names.add(rs.getString(1));
			}
			
			rs.close();
			
			return names;
		
	}
	
	static public ResultSet selectAllFromStudentTable(String what,String where)
	{
		
		Connection con=null;
		ArrayList<String> names = new ArrayList<String>();
		try {
			con = Contract.getDBConnection();
			String sql;
			if(where == "")
			{
				sql="select "+what+" from "+Student.tableName+" order by "+what+";";
			}
			else
			{
				 sql="select "+what+" from "+Student.tableName+" where "+ where+";";
			}
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			return rs;
			
		} catch (SQLException e) {
			e.printStackTrace();
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
		
		return null;
		
	}
	}	
	public static void insertIntoIssueTable(String bookname,Date date, Long EDRPNo)
	{
				try {
					Connection con = Contract.getDBConnection();
					String sql="insert into "+Contract.BookIssued.tableName+
							" (Bookname,date,issuedby) values(?,?,?)";
					
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setString(1, bookname);
					ps.setDate(2, date);
					ps.setLong(3, EDRPNo);
					
					ps.execute();
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}	
	public static ResultSet getAllIssuedBooks()
	{
		try {
			Connection con = Contract.getDBConnection();

			String sql="select * from "+Contract.BookIssued.tableName+"";
			
			PreparedStatement ps=con.prepareStatement(sql);
			return ps.executeQuery();
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
