import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JTextField nameTF;
	private JPasswordField passTF;
	
	static ArrayList<Admin> ad=new ArrayList<>();
	
	static Admin admin=new Admin();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
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
	public AdminLogin() {
		setTitle("ADMIN LOGIN");		
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
		
		JLabel userL = new JLabel("ADMIN USERNAME:");
		userL.setFont(new Font("Tahoma", Font.BOLD, 11));
		userL.setBounds(467, 219, 143, 14);
		contentPane.add(userL);
		
		JLabel passL = new JLabel("PASSWORD:");
		passL.setFont(new Font("Tahoma", Font.BOLD, 11));
		passL.setBounds(467, 309, 143, 14);
		contentPane.add(passL);
		
		JLabel lblUserLoginMenu = new JLabel("ADMIN LOGIN MENU");
		lblUserLoginMenu.setForeground(Color.BLUE);
		lblUserLoginMenu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblUserLoginMenu.setBounds(563, 110, 231, 33);
		contentPane.add(lblUserLoginMenu);
		
		nameTF = new JTextField();
		nameTF.setBounds(667, 216, 213, 20);
		contentPane.add(nameTF);
		nameTF.setColumns(10);
		
		passTF = new JPasswordField();
		passTF.setBounds(667, 306, 213, 20);
		contentPane.add(passTF);
		
		JLabel msgL = new JLabel("");
		msgL.setForeground(Color.RED);
		msgL.setBounds(669, 349, 211, 14);
		contentPane.add(msgL);
		
		JButton loginB = new JButton("LOGIN");
				
		loginB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(nameTF.getText().equals(admin.userName) && passTF.getText().equals(admin.password)) {
					AdminLoginSuccess als=new AdminLoginSuccess();
					als.setVisible(true);
					admin.login_status=true;
					dispose();
				}
				else {
					msgL.setText("Incorrect UserName or Password");
				}
			}
		});
		loginB.setBounds(669, 424, 132, 33);
		contentPane.add(loginB);
		
		
		
		JButton MainB = new JButton("Main Menu");
		MainB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainMenu m=new MainMenu();
				m.setVisible(true);
				dispose();
			}
		});
		MainB.setBounds(669, 542, 132, 33);
		contentPane.add(MainB);
	}
	
	static void addSomeAdmins() {
		Admin admin2=new Admin(1769,"Wajahat",20,"admin2","admin2");
		Admin admin3=new Admin(222,"Rayed",20,"admin3","admin3");
		Admin admin4=new Admin(333,"Moiz",19,"admin4","admin4");
		Admin admin5=new Admin(444,"Umar",22,"admin5","admin5");
		Admin admin6=new Admin(555,"Haider",21,"admin6","admin6");	
		
		ad.add(admin2);
		ad.add(admin3);
		ad.add(admin4);
		ad.add(admin5);
		ad.add(admin6);
	}

}
