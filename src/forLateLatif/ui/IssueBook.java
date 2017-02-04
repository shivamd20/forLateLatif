package forLateLatif.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import forLateLatif.db.CRUDOperation;
import forLateLatif.db.Contract;
import javafx.scene.layout.Border;

import java.awt.Dimension;
import javax.swing.border.TitledBorder;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.BoxLayout;
import javax.swing.border.BevelBorder;

public class IssueBook extends JFrame implements ActionListener{
	private JTextField bookNameTextField;
	private JComboBox<String> edrpTextField;
	JDateChooser dateChooser=new JDateChooser();
	JLabel sexlabel = new JLabel("");
	JLabel noofbookslable = new JLabel("");
	JLabel mobileNoLable = new JLabel("");
	JButton btnIssueBook = new JButton("ISSUE BOOK");
	JLabel branchlable = new JLabel("");
	JLabel emailLabel = new JLabel("");
	JLabel semLable = new JLabel("");
	
	
	
	public IssueBook() {
		searchByEDRPField.setColumns(10);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(40, 400));
		panel.setForeground(Color.LIGHT_GRAY);
		panel.setBackground(Color.ORANGE);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lblBookIssue = new JLabel("BOOK ISSUE");
		lblBookIssue.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookIssue.setHorizontalTextPosition(SwingConstants.CENTER);
		lblBookIssue.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		panel.add(lblBookIssue);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setMaximumSize(new Dimension(30, 100));
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Myriad Pro", Font.BOLD, 20));
		
		panel_1.add(lblNewLabel_1);
		
		panel_1.add(searchByEDRPField);
		
		JLabel lblNewLabel = new JLabel("BOOK NAME");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Myriad Pro", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel);
		
		bookNameTextField = new JTextField();
		panel_1.add(bookNameTextField);
		bookNameTextField.setColumns(10);
		
		JLabel lblEdrpNo = new JLabel("EDRP NO");
		lblEdrpNo.setForeground(Color.BLACK);
		panel_1.add(lblEdrpNo);
		lblEdrpNo.setFont(new Font("Myriad Pro", Font.BOLD, 20));
		lblEdrpNo.setHorizontalAlignment(SwingConstants.CENTER);
		
		edrpTextField = new JComboBox<String>();
		panel_1.add(edrpTextField);
		
		JLabel lblDate = new JLabel("DATE");
		lblDate.setForeground(Color.BLACK);
		lblDate.setFont(new Font("Myriad Pro", Font.BOLD, 20));
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblDate);
		
		panel_1.add(dateChooser);
		
		edrpTextField.addActionListener(edrpActionLis);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		studentDetailsPanel.setPreferredSize(new Dimension(10, 250));
		studentDetailsPanel.setMaximumSize(new Dimension(500, 500));
		studentDetailsPanel.setBackground(Color.DARK_GRAY);
		panel_2.add(studentDetailsPanel);
		
		
		studentDetailsPanel.setBorder(new TitledBorder(null, "Student Detail", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		studentDetailsPanel.setLayout(new GridLayout(0, 2, 0, 0));
		nameLabel.setBackground(SystemColor.inactiveCaptionText);
		studentDetailsPanel.add(nameLabel);
		nameLabel.setFont(new Font("Ebrima", Font.PLAIN, 15));
		nameLabel.setForeground(Color.WHITE);
		sexlabel.setFont(new Font("Ebrima", Font.PLAIN, 15));
		sexlabel.setForeground(Color.WHITE);
		sexlabel.setBackground(SystemColor.inactiveCaptionText);
		studentDetailsPanel.add(sexlabel);
		emailLabel.setFont(new Font("Ebrima", Font.PLAIN, 15));
		emailLabel.setForeground(Color.WHITE);
		emailLabel.setBackground(SystemColor.inactiveCaptionText);
		studentDetailsPanel.add(emailLabel);
		mobileNoLable.setFont(new Font("Ebrima", Font.PLAIN, 15));
		mobileNoLable.setForeground(Color.WHITE);
		mobileNoLable.setBackground(SystemColor.inactiveCaptionText);
		studentDetailsPanel.add(mobileNoLable);
		semLable.setFont(new Font("Ebrima", Font.PLAIN, 15));
		semLable.setForeground(Color.WHITE);
		semLable.setBackground(SystemColor.inactiveCaptionText);
		studentDetailsPanel.add(semLable);
		branchlable.setFont(new Font("Ebrima", Font.PLAIN, 15));
		branchlable.setForeground(Color.WHITE);
		branchlable.setBackground(SystemColor.inactiveCaptionText);
		studentDetailsPanel.add(branchlable);
		noofbookslable.setFont(new Font("Ebrima", Font.PLAIN, 15));
		noofbookslable.setForeground(Color.WHITE);
		noofbookslable.setBackground(SystemColor.inactiveCaptionText);
		studentDetailsPanel.add(noofbookslable);
		
		setEdrpNo();
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setBounds(20, 20, 500, 500);
		

		studentDetailsPanel.setMaximumSize(new Dimension(500, 500));
		studentDetailsPanel.setBackground(Color.DARK_GRAY);
		btnIssueBook.setBackground(Color.ORANGE);
		btnIssueBook.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		studentDetailsPanel.add(btnIssueBook);
	}

	public void setEdrpNo()
	{
		ArrayList<String> list;
		try {
			list = (ArrayList<String>) new CRUDOperation().selectFromStudentTable(Contract.Student.edrpno,"");
			for(String X:list)
			{
				edrpTextField.addItem(X);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	ActionListener edrpActionLis=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				ResultSet rs = new CRUDOperation().selectAllFromStudentTable("*",Contract.Student.edrpno+"=="
									+(String)edrpTextField.getSelectedItem()+"");
				
				if(rs.next())
				{
					semLable.setText("SEM:   "+rs.getString(Contract.Student.sem));
					sexlabel.setText("GENDER:   "+rs.getString(Contract.Student.sex));
					emailLabel.setText("EMAIL:   "+rs.getString(Contract.Student.email));
					mobileNoLable.setText("MOB:   "+rs.getString(Contract.Student.mobile));
					noofbookslable.setText("Can Issue No. of Books:  "+rs.getString(Contract.Student.noOfBooks));
					branchlable.setText("BRNCH:   "+rs.getString(Contract.Student.branch));
					nameLabel.setText("NAME:   "+rs.getString(Contract.Student.name));
				}
				
				rs.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	};
	
	public static void main(String[] args) {
		
				new IssueBook().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(bookNameTextField.getText()!="")
		{
			
		}
		else{
			JOptionPane.showMessageDialog(iB, "enter book name");
		}
	}

	IssueBook iB=this;
	private final JLabel nameLabel = new JLabel("");
	private final JPanel studentDetailsPanel = new JPanel();
	private final JLabel lblNewLabel_1 = new JLabel("Search By EDRP No");
	private final JTextField searchByEDRPField = new JTextField();
}
