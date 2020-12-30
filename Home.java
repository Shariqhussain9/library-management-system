import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 519);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnBook = new JMenu("Book");
		menuBar.add(mnBook);
		
		JMenuItem mntmAdd = new JMenuItem("Add");
		mntmAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddBook a1=new AddBook();
				a1.setVisible(true);
			}
		});
		mnBook.add(mntmAdd);
		
		JMenuItem mntmSearch = new JMenuItem("Search");
		mntmSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchBook a2=new SearchBook();
				a2.setVisible(true);
			}
		});
		mnBook.add(mntmSearch);
		
		JMenu mnCustomer = new JMenu("Customer");
		menuBar.add(mnCustomer);
		
		JMenuItem mntmAdd_1 = new JMenuItem("Add");
		mnCustomer.add(mntmAdd_1);
		
		JMenuItem mntmSearch_1 = new JMenuItem("Search");
		mnCustomer.add(mntmSearch_1);
		
		JMenu mnTransaction = new JMenu("Transaction");
		menuBar.add(mnTransaction);
		
		JMenuItem mntmIssueBook = new JMenuItem("Issue book");
		mnTransaction.add(mntmIssueBook);
		
		JMenuItem mntmReturnBook = new JMenuItem("Return book");
		mnTransaction.add(mntmReturnBook);
		
		JMenuItem mntmDefaulters = new JMenuItem("Defaulters");
		mnTransaction.add(mntmDefaulters);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
