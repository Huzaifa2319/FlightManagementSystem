import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SuccessfulSignupBox extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SuccessfulSignupBox frame = new SuccessfulSignupBox();
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
	public SuccessfulSignupBox() {
		setTitle("Successfuly Signed Up");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 438, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel balL = new JLabel("Successfully Signed Up");
		balL.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		balL.setForeground(Color.BLUE);
		balL.setBounds(82, 46, 324, 52);
		contentPane.add(balL);
		
		JLabel lblNowYouCan = new JLabel("Now you can Login");
		lblNowYouCan.setForeground(Color.BLACK);
		lblNowYouCan.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNowYouCan.setBounds(117, 97, 268, 25);
		contentPane.add(lblNowYouCan);
		
		JButton loginB = new JButton("Login");
		loginB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainMenu m=new MainMenu();
				m.setVisible(true);
				dispose();
			}
		});
		loginB.setBounds(148, 150, 89, 32);
		contentPane.add(loginB);
		
	}

}
