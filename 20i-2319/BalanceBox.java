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

public class BalanceBox extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BalanceBox frame = new BalanceBox();
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
	public BalanceBox() {
		setTitle("Account Balance");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel balL = new JLabel("Balance(rs): ");
		balL.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		balL.setForeground(Color.BLUE);
		balL.setBounds(10, 77, 140, 52);
		contentPane.add(balL);
		
		String userbalance = null;
		
		for(int i=0;i<SignUp.u.size();i++) {
			if(SignUp.u.get(i).login_status==true ) {
				userbalance= String.valueOf(SignUp.u.get(i).getBalance());
			}
		}
		
		JLabel balance = new JLabel("");
		balance.setForeground(Color.BLUE);
		balance.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		balance.setBounds(188, 77, 236, 52);
		contentPane.add(balance);
		balance.setText(userbalance);
		
		JButton okB = new JButton("OKAY");
		okB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		okB.setBounds(156, 181, 89, 23);
		contentPane.add(okB);
	}
}
