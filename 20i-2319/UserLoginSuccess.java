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
import javax.swing.JList;

public class UserLoginSuccess extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLoginSuccess frame = new UserLoginSuccess();
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
	public UserLoginSuccess() {
		setTitle("USER");		
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
		
		JLabel lblSuccessfullyLoggedIn = new JLabel("Successfully Logged in");
		lblSuccessfullyLoggedIn.setForeground(Color.BLUE);
		lblSuccessfullyLoggedIn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblSuccessfullyLoggedIn.setBounds(544, 104, 262, 63);
		contentPane.add(lblSuccessfullyLoggedIn);
		
		JButton BookInterB = new JButton("Reserve Flight (International)");
		BookInterB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SearchInternational si=new SearchInternational();
				si.setVisible(true);
				dispose();
			}
		});
		BookInterB.setBounds(355, 311, 190, 42);
		contentPane.add(BookInterB);
		
		JButton btnAccountSettings = new JButton("Current Booked Flights");
		btnAccountSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CurrentBookedFlights cbf=new CurrentBookedFlights();
				cbf.setVisible(true);
				dispose();
			}
		});
		btnAccountSettings.setBounds(355, 562, 190, 42);
		contentPane.add(btnAccountSettings);
		
		JButton btnCancelReservation = new JButton("Cancel Reservation");
		btnCancelReservation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CancelBookedFlight cbl=new CancelBookedFlight();
				cbl.setVisible(true);
				dispose();
			}
		});
		btnCancelReservation.setBounds(355, 445, 190, 42);
		contentPane.add(btnCancelReservation);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for(int i=0;i<SignUp.u.size();i++) {
					if(SignUp.u.get(i).login_status==true ) {
						SignUp.u.get(i).setLogin_status(false);
					}
				}
				LogoutBox lb=new LogoutBox();
				lb.setVisible(true);
				dispose();
			}
		});
		btnLogout.setBounds(725, 562, 190, 42);
		contentPane.add(btnLogout);
		
		JButton btnAccountSettings_1 = new JButton("Account Settings");
		btnAccountSettings_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AccountSettingUser asu=new AccountSettingUser();
				asu.setVisible(true);
				dispose();
			}
		});
		btnAccountSettings_1.setBounds(725, 311, 190, 42);
		contentPane.add(btnAccountSettings_1);
		
		JButton mainB = new JButton("Main Menu");
		mainB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainMenu m = new MainMenu();
				m.setVisible(true);
				dispose();
			}
		});
		mainB.setBounds(725, 445, 190, 42);
		contentPane.add(mainB);
		
		JButton balanceB = new JButton("Check Balance");
		balanceB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BalanceBox bb=new BalanceBox();
				bb.setVisible(true);
			}
		});
		balanceB.setBounds(725, 207, 190, 42);
		contentPane.add(balanceB);
		
		JButton BookLocalB = new JButton("Reserve Flight(Local)");
		BookLocalB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SearchLocal sl=new SearchLocal();
				sl.setVisible(true);
				dispose();
			}
		});
		BookLocalB.setBounds(355, 207, 190, 42);
		contentPane.add(BookLocalB);
	}
}
