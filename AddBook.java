import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class AddBook extends JFrame {

	//private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	public AddBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book Name");
		lblNewLabel.setBounds(72, 51, 56, 16);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Pub Name");
		lblNewLabel_1.setBounds(72, 90, 56, 16);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Quantity");
		lblNewLabel_2.setBounds(72, 132, 56, 16);
		getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(177, 48, 116, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(177, 87, 116, 22);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(177, 122, 116, 22);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					Class.forName("com.mysql.jdbc.Drivers");
					Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/lms?user=root&pasword=shariq@123");
					String query="insert into books(name,pub,qty) values(?,?,?)";
					PreparedStatement st=cn.prepareStatement(query);
					st.setString(1,textField.getText());
					st.setString(2,textField_1.getText());
					st.setInt(3,Integer.parseInt(textField_2.getText()));
					int a=st.executeUpdate();
					cn.close();
					if(a!=0)
					{
							javax.swing.JOptionPane.showMessageDialog(null, "Data Saved");
							textField.setText("");
							textField_1.setText("");
							textField_2.setText("");
							
					}
					
				}
				catch(Exception e1)
				{
					javax.swing.JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
				
				
				
				
				
				
			}
		});
		btnSave.setBounds(122, 192, 97, 25);
		getContentPane().add(btnSave);
			
	
	
	}
}
