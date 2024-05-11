import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AccountSettingAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField uTF;
	private JPasswordField passTF;
	private JPasswordField confTF;
	private JPasswordField oldTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountSettingAdmin frame = new AccountSettingAdmin();
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
	public AccountSettingAdmin() {
		setTitle("Admin Account Settings");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 699);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADMIN ACCOUNT SETTINGS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(61, 48, 325, 37);
		contentPane.add(lblNewLabel);
		
		JLabel msgL = new JLabel(" ");
		msgL.setForeground(Color.RED);
		msgL.setFont(new Font("Tahoma", Font.BOLD, 12));
		msgL.setBounds(61, 483, 325, 14);
		contentPane.add(msgL);
		
		JLabel msg2L = new JLabel(" ");
		msg2L.setForeground(Color.RED);
		msg2L.setFont(new Font("Tahoma", Font.BOLD, 12));
		msg2L.setBounds(61, 519, 325, 14);
		contentPane.add(msg2L);
		
		uTF = new JTextField();
		uTF.setEditable(false);
		uTF.setBounds(159, 175, 227, 20);
		contentPane.add(uTF);
		uTF.setColumns(10);
		
		passTF = new JPasswordField();
		passTF.setEditable(false);
		passTF.setBounds(159, 325, 227, 20);
		contentPane.add(passTF);
		
		confTF = new JPasswordField();
		confTF.setEditable(false);
		confTF.setBounds(159, 374, 227, 20);
		contentPane.add(confTF);
		
		JLabel unameL = new JLabel("New Username:");
		unameL.setFont(new Font("Tahoma", Font.BOLD, 11));
		unameL.setBounds(46, 178, 103, 14);
		contentPane.add(unameL);
		
		JLabel lblNewPassword = new JLabel("New Password:");
		lblNewPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewPassword.setBounds(46, 328, 103, 14);
		contentPane.add(lblNewPassword);
		
		JLabel lblReenter = new JLabel("re-Enter:");
		lblReenter.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblReenter.setBounds(46, 377, 103, 14);
		contentPane.add(lblReenter);
		
		oldTF = new JPasswordField();
		oldTF.setBounds(159, 436, 227, 20);
		contentPane.add(oldTF);
		
		JLabel lblOldPassword = new JLabel("Old Password: ");
		lblOldPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOldPassword.setBounds(46, 439, 103, 14);
		contentPane.add(lblOldPassword);
		
		
		JRadioButton rb1 = new JRadioButton("Change Username: ");
		rb1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rb1.isSelected()) {
					uTF.setEditable(true);
				}
				if(!rb1.isSelected()) {
					uTF.setEditable(false);
				}
			}
		});
		rb1.setFont(new Font("Tahoma", Font.BOLD, 11));
		rb1.setBackground(Color.ORANGE);
		rb1.setBounds(123, 116, 171, 23);
		contentPane.add(rb1);
		
		JRadioButton rb2 = new JRadioButton("Change Password: ");
		rb2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rb2.isSelected()) {
					passTF.setEditable(true);
					confTF.setEditable(true);
				}
				if(!rb2.isSelected()) {
					passTF.setEditable(false);
					confTF.setEditable(false);
				}
			}
		});
		rb2.setFont(new Font("Tahoma", Font.BOLD, 11));
		rb2.setBackground(Color.ORANGE);
		rb2.setBounds(123, 269, 171, 23);
		contentPane.add(rb2);
		

		
		JButton confirmB = new JButton("Confirm");
		confirmB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				msgL.setText(" ");
				msg2L.setText(" ");
				
				
				AdminLogin al =new AdminLogin();
				
				boolean passformat=Formats.PasswordFormat(passTF.getText());
				boolean passlength=Formats.Passwordlength(passTF.getText());
				boolean passmatch=false;
				
				if(passTF.getText().equals(confTF.getText())){
					passmatch=true;
				}
				
			
				
				if(!rb1.isSelected() && !rb2.isSelected()) {
					msgL.setText("select atleast 1 button to change account details");
				}
				
				if(rb1.isSelected()) {
					if(oldTF.getText().equals(al.admin.getPassword())) {
						al.admin.setUserName(uTF.getText());
						msgL.setText("UserName Updated");
						DetailsUpdatedBox dup =new DetailsUpdatedBox();
						dup.setVisible(true);
					}
					else {
						msgL.setText("incorrect Old Password");
					}
				}
				
				if(rb2.isSelected()) {
						if(!passformat || !passlength) {
							msg2L.setText("minimum 8 character with upper lower num and symbols");
						}
						else if(!passmatch) {
							msg2L.setText("password doesn't Match Try Again");
						}
						else if(passmatch && passformat && passlength) {
						if(oldTF.getText().equals(al.admin.getPassword())) {
							al.admin.setPassword(passTF.getText());
							DetailsUpdatedBox dup =new DetailsUpdatedBox();
							dup.setVisible(true);
							msg2L.setText("Password Updated");
						}
						else {
							msgL.setText("incorrect Old Password");
						}
					}
				}
			}
		});
		confirmB.setBounds(159, 559, 89, 23);
		contentPane.add(confirmB);
		

		JButton backB = new JButton("Back");
		backB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			AdminLoginSuccess als=new AdminLoginSuccess();
			als.setVisible(true);
			dispose();
			}
		});
		backB.setBounds(159, 608, 89, 23);
		contentPane.add(backB);
		

	}
}
