import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LocalAdded extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LocalAdded frame = new LocalAdded();
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
	public LocalAdded() {
		setTitle("Successfully Added");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton addB = new JButton("Add another");
		addB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddLocal al=new AddLocal();
				al.setVisible(true);
			}
		});
		addB.setBounds(249, 192, 137, 23);
		contentPane.add(addB);
		
		JButton MainB = new JButton("Main Menu");
		MainB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainMenu m=new MainMenu();
				m.setVisible(true);
				dispose();
			}
		});
		MainB.setBounds(60, 192, 130, 23);
		contentPane.add(MainB);
		
		JLabel TittleL = new JLabel("Local Flight Added Successfully");
		TittleL.setForeground(Color.BLUE);
		TittleL.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		TittleL.setBounds(75, 77, 326, 34);
		contentPane.add(TittleL);
	}

}
