import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserLogin extends JFrame {

	private JPanel contentPane;
	private JTextField userTF;
	private JPasswordField passTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLogin frame = new UserLogin();
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
	public UserLogin() {
		setTitle("USER LOGIN");		
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
		
		JLabel userL = new JLabel("USERNAME:");
		userL.setFont(new Font("Tahoma", Font.BOLD, 11));
		userL.setBounds(504, 219, 106, 14);
		contentPane.add(userL);
		
		JLabel passL = new JLabel("PASSWORD:");
		passL.setFont(new Font("Tahoma", Font.BOLD, 11));
		passL.setBounds(504, 309, 106, 14);
		contentPane.add(passL);
		
		userTF = new JTextField();
		userTF.setBounds(669, 216, 211, 20);
		contentPane.add(userTF);
		userTF.setColumns(10);
		
		passTF = new JPasswordField();
		passTF.setBounds(669, 306, 211, 20);
		contentPane.add(passTF);
		
		JLabel msgL = new JLabel("");
		msgL.setForeground(Color.RED);
		msgL.setBounds(669, 349, 211, 14);
		contentPane.add(msgL);
		
		JButton loginB = new JButton("LOGIN");
		loginB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean canLogin=false;
				canLogin=canLogin(userTF.getText(),passTF.getText());

				if(canLogin) {
					UserLoginSuccess uls=new UserLoginSuccess();
					uls.setVisible(true);
					dispose();
				}
				else {
					msgL.setText("Incorrect email or password");	
				}
				
			}
		});
		loginB.setBounds(669, 424, 132, 33);
		contentPane.add(loginB);
		
		JLabel lblUserLoginMenu = new JLabel("USER LOGIN MENU");
		lblUserLoginMenu.setForeground(Color.BLUE);
		lblUserLoginMenu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblUserLoginMenu.setBounds(563, 110, 231, 33);
		contentPane.add(lblUserLoginMenu);
		
		JButton MainMenuB = new JButton("Main Menu");
		MainMenuB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainMenu m=new MainMenu();
				m.setVisible(true);
				dispose();
			}
		});
		MainMenuB.setBounds(669, 566, 132, 33);
		contentPane.add(MainMenuB);
	}

	public boolean canLogin(String uname,String pass) {
		for(int i=0;i<SignUp.u.size();i++) {
			if(SignUp.u.get(i).userName.equals(uname) && SignUp.u.get(i).password.equals(pass) ) {
				SignUp.u.get(i).setLogin_status(true);
				return true;
			}
		}
		return false;
	}
	
	
	
}


 

