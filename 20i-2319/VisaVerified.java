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

public class VisaVerified extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisaVerified frame = new VisaVerified();
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
	public VisaVerified() {
		setTitle("Visa Verified Successfully");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel balL = new JLabel("Visa Verified");
		balL.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		balL.setForeground(Color.BLUE);
		balL.setBounds(141, 64, 166, 52);
		contentPane.add(balL);
		
		JButton okB = new JButton("OK");
		okB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				allUsersDetails aud=new allUsersDetails();
				aud.setVisible(true);
				dispose();
			}
		});
		okB.setBounds(163, 161, 89, 30);
		contentPane.add(okB);
	}

}
