import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class PassportInstruction extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PassportInstruction frame = new PassportInstruction();
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
	public PassportInstruction() {
		setTitle("Passport Help");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel balL = new JLabel("Passport and Visa Information");
		balL.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		balL.setForeground(Color.BLUE);
		balL.setBounds(63, 11, 324, 52);
		contentPane.add(balL);
		
		JLabel step1 = new JLabel("-->Enter 9 digit Passport Number.");
		step1.setFont(new Font("Tahoma", Font.BOLD, 12));
		step1.setBounds(41, 89, 324, 23);
		contentPane.add(step1);
		
		JLabel step2 = new JLabel("-->It will be verified by admin.");
		step2.setFont(new Font("Tahoma", Font.BOLD, 12));
		step2.setBounds(41, 124, 324, 23);
		contentPane.add(step2);
		
		JLabel step3 = new JLabel("-->if valid then your visa will be declared verified.");
		step3.setFont(new Font("Tahoma", Font.BOLD, 12));
		step3.setBounds(41, 159, 324, 23);
		contentPane.add(step3);
		
		JLabel step4 = new JLabel("-->Then you can enjoy international flights.");
		step4.setFont(new Font("Tahoma", Font.BOLD, 12));
		step4.setBounds(41, 193, 324, 23);
		contentPane.add(step4);
		
		
	}

}
