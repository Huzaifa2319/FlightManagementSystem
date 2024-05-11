import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
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
	public MainMenu() {
		setTitle("New-PAK Airline Flight System (NPAFS)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1400, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel tittleL = new JLabel("New-PAK Airline Flight System (NPAFS)");
		tittleL.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		tittleL.setBounds(467, 30, 492, 63);
		contentPane.add(tittleL);
		
		JButton signB = new JButton("SIGN UP");
		signB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignUp s=new SignUp();
				s.setVisible(true);
				dispose();
			}
		});
		signB.setBounds(573, 177, 232, 48);
		contentPane.add(signB);
		
		JButton userloginB = new JButton("USER LOGIN");
		userloginB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(isanyoneLoggedin()) {
					UserLoginSuccess uls =new UserLoginSuccess();
					uls.setVisible(true);
					dispose();
				}
				else if(!isanyoneLoggedin()) {
					UserLogin ul=new UserLogin();
					ul.setVisible(true);
					dispose();
				}
			}
		});
		userloginB.setBounds(573, 316, 232, 48);
		contentPane.add(userloginB);
		
		JButton adminloginB = new JButton("ADMIN LOGIN");
		adminloginB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			AdminLogin al =new AdminLogin();
			if(al.admin.login_status==true) {
				AdminLoginSuccess als=new AdminLoginSuccess();
				als.setVisible(true);
				dispose();
			}
			else {
			al.setVisible(true);
			dispose();
			}
			}
		});
		adminloginB.setBounds(573, 451, 232, 48);
		contentPane.add(adminloginB);
		
		JButton withoutloginB = new JButton("CONTINUE WITHOUT LOGGING IN");
		withoutloginB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FlightDetails fd =new FlightDetails();
				fd.setVisible(true);
				dispose();
			}
		});
		withoutloginB.setBounds(573, 583, 232, 48);
		contentPane.add(withoutloginB);
		
		JLabel lblHomePage = new JLabel("HOME PAGE");
		lblHomePage.setForeground(Color.BLUE);
		lblHomePage.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblHomePage.setBounds(592, 93, 197, 63);
		contentPane.add(lblHomePage);
	}
	
		boolean isanyoneLoggedin() {
			for(int i=0;i<SignUp.u.size();i++) {
				if(SignUp.u.get(i).login_status==true ) {
					return true;
				}
			}
			return false;
		}
	
	

}
