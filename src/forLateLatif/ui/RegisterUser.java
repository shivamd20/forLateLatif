package forLateLatif.ui;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.UIManager;

import forLateLatif.db.CRUDOperation;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;

public class RegisterUser extends JFrame implements ActionListener{
	private JTextField edrpNoTextField;
	private JTextField emailTextField;
	private JTextField mobileNoTextField;
	JComboBox<String> semComboBox,branchComboBox,noOfBooksComboBox,sexComboBox;
	
	public static void main(String ...args)
	{
		new RegisterUser().setVisible(true);
	}

	public RegisterUser()
	{
		getContentPane().setBackground(Color.BLUE);
		
		this.setBounds((int)getToolkit().getScreenSize().getWidth()/3, (int)getToolkit().getScreenSize().getWidth()/4, 500, 300);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblRegisterUser = new JLabel("REGISTER USER");
		lblRegisterUser.setFont(new Font("Snap ITC", Font.BOLD, 20));
		panel.add(lblRegisterUser);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLUE);
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("EDRP NO.");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBackground(Color.BLUE);
		panel_1.add(lblNewLabel);
		
		edrpNoTextField = new JTextField();
		edrpNoTextField.addFocusListener(new FocusListener() {
			
			@Override
			public void focusGained(FocusEvent e) {
				edrpNoTextField.setBackground(Color.red);
			}
			@Override
			public void focusLost(FocusEvent e) {
				edrpNoTextField.setBackground(Color.BLUE);
			}
		});
		edrpNoTextField.setFont(new Font("Arial", Font.PLAIN, 17));
		edrpNoTextField.setForeground(Color.WHITE);
		edrpNoTextField.setBackground(Color.BLUE);
		panel_1.add(edrpNoTextField);
		edrpNoTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Email Address");
		lblNewLabel_1.setToolTipText("email addresss must have to be in proper format");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBackground(Color.BLUE);
		panel_1.add(lblNewLabel_1);
		
		emailTextField = new JTextField();
		emailTextField.setForeground(Color.WHITE);
		emailTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				emailTextField.setBackground(Color.red);
			}
			@Override
			public void focusLost(FocusEvent e) {
				emailTextField.setBackground(Color.BLUE);
			}
		});
		emailTextField.setToolTipText("");
		emailTextField.setFont(new Font("Arial", Font.PLAIN, 17));
		emailTextField.setBackground(Color.BLUE);
		panel_1.add(emailTextField);
		emailTextField.setColumns(10);
		
		JLabel lblMobileNo = new JLabel("Mobile No.");
		lblMobileNo.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblMobileNo.setBackground(Color.BLUE);
		panel_1.add(lblMobileNo);
		
		mobileNoTextField = new JTextField();
		mobileNoTextField.setForeground(Color.WHITE);
		mobileNoTextField.setToolTipText("enter 10 digits only");
		mobileNoTextField.setFont(new Font("Arial", Font.PLAIN, 17));
		mobileNoTextField.setBackground(Color.BLUE);
		panel_1.add(mobileNoTextField);
		mobileNoTextField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_1.add(lblNewLabel_3);
		
		nameTextField = new JTextField();
		nameTextField.setForeground(Color.WHITE);
		nameTextField.setBackground(Color.BLUE);
		nameTextField.setFont(new Font("Arial", Font.PLAIN, 17));
		nameTextField.setText("");
		panel_1.add(nameTextField);
		nameTextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("SEX");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_1.add(lblNewLabel_2);
		
		 sexComboBox = new JComboBox<String>();
		 sexComboBox.setForeground(Color.WHITE);
		sexComboBox.setFont(new Font("Arial", Font.PLAIN, 17));
		sexComboBox.setBackground(Color.BLUE);
		panel_1.add(sexComboBox);
		
		JLabel lblNewLabel_4 = new JLabel("semester");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_1.add(lblNewLabel_4);
		
		 semComboBox = new JComboBox<String>();
		 semComboBox.setForeground(Color.WHITE);
		 semComboBox.setBackground(Color.BLUE);
		semComboBox.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_1.add(semComboBox);
		
		JLabel lblNewLabel_5 = new JLabel("branch");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_1.add(lblNewLabel_5);
		
		branchComboBox = new JComboBox<String>();
		branchComboBox.setForeground(Color.WHITE);
		branchComboBox.setBackground(Color.BLUE);
		branchComboBox.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_1.add(branchComboBox);
		
		JLabel lblNewLabel_6 = new JLabel("No of books");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_1.add(lblNewLabel_6);
		
		 noOfBooksComboBox = new JComboBox<String>();
		 noOfBooksComboBox.setForeground(Color.WHITE);
		 noOfBooksComboBox.setBackground(Color.BLUE);
		noOfBooksComboBox.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_1.add(noOfBooksComboBox);
		
		mobileNoTextField.addFocusListener(new FocusListener() {
			
			@Override
			public void focusGained(FocusEvent e) {
				mobileNoTextField.setBackground(Color.red);
			}
			@Override
			public void focusLost(FocusEvent e) {
				mobileNoTextField.setBackground(Color.BLUE);
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.ORANGE);
		getContentPane().add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.LINE_AXIS));
		
		JButton submitBtn = new JButton("SUBMIT");
		submitBtn.addActionListener(this);
		submitBtn.setForeground(Color.GRAY);
		submitBtn.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 18));
		submitBtn.setActionCommand("Submit");
		submitBtn.setBorder(UIManager.getBorder("EditorPane.border"));
		submitBtn.setAlignmentX(Component.RIGHT_ALIGNMENT);
		submitBtn.setHorizontalAlignment(SwingConstants.RIGHT);
		submitBtn.setVerticalAlignment(SwingConstants.BOTTOM);
		panel_2.add(submitBtn);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		fillInComboBoxes();
		
		
	}

	
	void fillInComboBoxes()
	{
		sexComboBox.addItem("male");
		sexComboBox.addItem("female");
		sexComboBox.addItem("other");
		
		semComboBox.addItem("1st Sem");
		semComboBox.addItem("2nd Sem");
		semComboBox.addItem("3rd Sem");
		semComboBox.addItem("4th Sem");
		semComboBox.addItem("5th Sem");
		semComboBox.addItem("6th Sem");
		semComboBox.addItem("7th Sem");
		semComboBox.addItem("8th Sem");
		semComboBox.addItem("OTHER");
		
		branchComboBox.addItem("CSE");
		branchComboBox.addItem("MECH");
		branchComboBox.addItem("ET&T");
		branchComboBox.addItem("CIVIL");
		branchComboBox.addItem("IT");
		branchComboBox.addItem("E&I");
		branchComboBox.addItem("OTHER");
		
		branchComboBox.addActionListener(comboLis);
		semComboBox.addActionListener(comboLis);
		
		for(int i=1;i<6;i++)
		{
			noOfBooksComboBox.addItem(i+"");
		}
	}
	
	ActionListener comboLis=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			JComboBox<String> cmb=(JComboBox<String>)e.getSource();
			
			String str=(String) cmb.getSelectedItem();
			
			if(str=="OTHER")
			{
			str=JOptionPane.showInputDialog(rU, "please specify");
			
			cmb.addItem(str);
			cmb.setSelectedItem(str);
			}
		}
	};
	
	public boolean registerUser(Long edrpNo,String email,Long mobileNo,String name,String sex,int semester,String branch,int noOfBooks)
	{
		return new CRUDOperation().insertInStudentTable(edrpNo, email, mobileNo, name, sex, semester, branch, noOfBooks);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try
		{
			String temp=edrpNoTextField.getText();
				long edrpNo=Long.parseLong(temp);
					
				temp=mobileNoTextField.getText();
				long mobileNo=Long.parseLong(mobileNoTextField.getText());
				
				
		if(!emailTextField.getText().contains("@"))
		throw new Exception("email address format is not valid");
		
		if(nameTextField.getText().length()<2)
			throw new Exception("name too short");
		
		if(temp.length()!=10) throw new Exception("mobile no is not of proper length");

		if(registerUser(edrpNo,
				emailTextField.getText(), 
				mobileNo,
				nameTextField.getText(),
				(String)sexComboBox.getSelectedItem(), 
				Integer.parseInt(((String)semComboBox.getSelectedItem()).charAt(0)+""),
				(String)branchComboBox.getSelectedItem(), Integer.parseInt((String)noOfBooksComboBox.getSelectedItem())))
		{
			JOptionPane.showMessageDialog(rU, "user registered successfully");
		}
		else{
			JOptionPane.showMessageDialog(rU, "error in registering");
		}
		
		}
		catch(NumberFormatException e78)
		{
			JOptionPane.showMessageDialog(rU, "number in valid format");
			e78.printStackTrace();
			
		}
		catch(Exception e75)
		{
			JOptionPane.showMessageDialog(rU, e75.getMessage());
			e75.printStackTrace();
		}
	}
	RegisterUser rU=this;
	private JTextField nameTextField;
}
