import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SearchBook extends JFrame {
	private JTextField textField;

	public SearchBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 432);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String s="";
				try
				{
					Class.forName("com.mysql.jdbc.Drivers");
					Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/lms?user=root&pasword=shariq@123");
					String query="search from books where name is like '%'"+s+"'%'";
					PreparedStatement st=cn.prepareStatement(query);
					s=textField.getText();
					ResultSet rs=st.executeQuery();
					while(rs.next())
					{
						System.out.println(rs.getString(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4));
					}
					cn.close();
					
				}
				catch(Exception e1)
				{
					javax.swing.JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
				
				
				
			}
		});
		contentPane.add(textField, BorderLayout.NORTH);
		textField.setColumns(10);
	}

}
