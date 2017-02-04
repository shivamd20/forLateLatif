package forLateLatif.db;

import java.sql.Connection;
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
	
	public boolean insertInStudentTable(Long edrpNo,String email,Long mobileNo,
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
	
	public List<String> selectFromStudentTable(String what,String where) throws SQLException
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
	
	public ResultSet selectAllFromStudentTable(String what,String where)
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
}}
