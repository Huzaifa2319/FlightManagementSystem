import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FlightDetails extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlightDetails frame = new FlightDetails();
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
	public FlightDetails() {
		setTitle("Flight Schedule Details ");		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1400, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel tittleL = new JLabel("New-PAK Airline Flight System (NPAFS)");
		tittleL.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		tittleL.setBounds(384, 0, 492, 63);
		contentPane.add(tittleL);
		
		JLabel lblSuccessfullyLoggedIn = new JLabel("Flight Details");
		lblSuccessfullyLoggedIn.setForeground(Color.BLUE);
		lblSuccessfullyLoggedIn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblSuccessfullyLoggedIn.setBounds(521, 64, 326, 46);
		contentPane.add(lblSuccessfullyLoggedIn);
		
		JLabel infoL = new JLabel("You need to login to Book Flight");
		infoL.setForeground(Color.RED);
		infoL.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		infoL.setBounds(425, 121, 492, 46);
		contentPane.add(infoL);
		
		
		JButton localB = new JButton("Local Flight Details");
		localB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LocalDetailsTable ldt=new LocalDetailsTable();
				ldt.setVisible(true);
				dispose();
			}
		});
		localB.setBounds(493, 199, 188, 37);
		contentPane.add(localB);
		
		JButton interB = new JButton("International Flight Details");
		interB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			InterDetailsTable idt =new InterDetailsTable();
			idt.setVisible(true);
			dispose();
			}
		});
		interB.setBounds(493, 335, 188, 37);
		contentPane.add(interB);
		
		JButton backB = new JButton("Back");
		backB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainMenu m=new MainMenu();
				m.setVisible(true);
				dispose();
			}
		});
		backB.setBounds(493, 466, 188, 37);
		contentPane.add(backB);
	}
}
