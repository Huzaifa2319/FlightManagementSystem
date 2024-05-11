import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class VisaMsg extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisaMsg frame = new VisaMsg();
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
	public VisaMsg() {
		setTitle("Visa not Verified");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Your Passport doesn't have stamp of VISA");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(42, 44, 491, 52);
		contentPane.add(lblNewLabel);
		
		JButton okB = new JButton("OKAY");
		okB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		okB.setBounds(210, 207, 89, 23);
		contentPane.add(okB);	
		
		JLabel lblYouCannotTravell = new JLabel("You cannot travell Internationaly");
		lblYouCannotTravell.setForeground(Color.BLUE);
		lblYouCannotTravell.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblYouCannotTravell.setBounds(75, 97, 491, 52);
		contentPane.add(lblYouCannotTravell);
	}
}
