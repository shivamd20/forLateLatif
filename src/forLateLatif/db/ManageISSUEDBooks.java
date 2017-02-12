package forLateLatif.db;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.awt.BorderLayout;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;

public class ManageISSUEDBooks extends JFrame{
	private JTable table=new JTable();
	public ManageISSUEDBooks() {
		
		 table= setDataFromDataBase();
		 JScrollPane scrollPane= new  JScrollPane(table);
		getContentPane().add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		scrollPane.setColumnHeaderView(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tekton Pro", Font.BOLD, 17));
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setBackground(Color.BLUE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JButton btnNewButton = new JButton("New button");
		panel_1.add(btnNewButton);

		   setSize(300,400);    
		   setVisible(true);
		   setDefaultCloseOperation(EXIT_ON_CLOSE);

		   TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
		   table.setRowSorter(sorter);	
	}

	JTable setDataFromDataBase()
	{
		ResultSet rs=CRUDOperation.getAllIssuedBooks();
		Vector<Vector<String>> data=new Vector<>();
		try {
			while(rs.next())
			{
				Vector<String> row=new Vector<>();
				Date date=rs.getDate(Contract.BookIssued.date);
				
				SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
				
				row.addElement(rs.getString(Contract.BookIssued.bookName));
				row.addElement(dateFormat.format(date));
				row.addElement(rs.getString(Contract.BookIssued.issuedby));
				row.addElement(rs.getString(Contract.BookIssued.id));
				data.add(row);
				}
			Vector<String> colmNm=new Vector<>();
			
			colmNm.addElement("BOOK NAME");

			colmNm.addElement("DATE");

			colmNm.addElement("ISSUEDBY");

			colmNm.addElement("ID");
			
			table=new JTable(data,colmNm);
			
			rs.close();
			return table;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public static void main(String[] args) {
		new ManageISSUEDBooks().setVisible(true);
		// TODO Auto-generated method stub

	}
	

}
