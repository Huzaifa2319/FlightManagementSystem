import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminLoginSuccess extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLoginSuccess frame = new AdminLoginSuccess();
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
	public AdminLoginSuccess() {
		setTitle("ADMIN");		
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
		
		JLabel lblSuccessfullyLoggedIn = new JLabel("ADMIN Successfully Logged in");
		lblSuccessfullyLoggedIn.setForeground(Color.BLUE);
		lblSuccessfullyLoggedIn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblSuccessfullyLoggedIn.setBounds(494, 104, 326, 63);
		contentPane.add(lblSuccessfullyLoggedIn);
		
		JButton AddLocalB = new JButton("Add Flight Local");
		AddLocalB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddLocal al=new AddLocal();
				al.setVisible(true);
				dispose();
			}
		});
		AddLocalB.setBounds(284, 217, 217, 43);
		contentPane.add(AddLocalB);
		
		JButton addInterB = new JButton("Add Flight InterNational");
		addInterB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addInter ai=new addInter();
				ai.setVisible(true);
				dispose();
			}
		});
		addInterB.setBounds(284, 329, 217, 43);
		contentPane.add(addInterB);
		
		JButton removeLocalB = new JButton("Delete or Block Local Flight");
		removeLocalB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DeleteBlockLocal dbl=new DeleteBlockLocal();
				dbl.setVisible(true);
				dispose();
			}
		});
		removeLocalB.setBounds(284, 447, 217, 43);
		contentPane.add(removeLocalB);
		
		JButton removeInterB = new JButton("Delete or Block International Flight");
		removeInterB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			DeleteBlockInter dbi=new DeleteBlockInter();
			dbi.setVisible(true);
			dispose();
			}
		});
		removeInterB.setBounds(284, 572, 217, 43);
		contentPane.add(removeInterB);		
		
		JButton MainB = new JButton("Main Menu");
		MainB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainMenu m =new MainMenu();
				m.setVisible(true);
				dispose();
			}
		});
		MainB.setBounds(720, 447, 224, 43);
		contentPane.add(MainB);
		
		JButton logoutB = new JButton("Logout");
		logoutB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminLogin al =new AdminLogin();
				al.admin.setLogin_status(false);
				dispose();
				LogoutBox lb=new LogoutBox();
				lb.setVisible(true);
			}
		});
		logoutB.setBounds(720, 572, 224, 43);
		contentPane.add(logoutB);
		
		JButton settingB = new JButton("Account Settings");
		settingB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AccountSettingAdmin as=new AccountSettingAdmin();
				as.setVisible(true);
				dispose();
			}
		});
		settingB.setBounds(720, 329, 217, 43);
		contentPane.add(settingB);
		
		JButton userdetailsB = new JButton("Users Details");
		userdetailsB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				allUsersDetails aud=new allUsersDetails();
				aud.setVisible(true);
				dispose();
			}
		});
		userdetailsB.setBounds(720, 217, 217, 43);
		contentPane.add(userdetailsB);
	}

}
