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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class allUsersDetails extends JFrame {

	private JPanel contentPane;
	private JTable userTable;
	private JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					allUsersDetails frame = new allUsersDetails();
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
	public allUsersDetails() {
		setTitle("All Users Details");		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1400, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel tittleL = new JLabel("New-PAK Airline Flight System (NPAFS)");
		tittleL.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		tittleL.setBounds(417, 0, 492, 63);
		contentPane.add(tittleL);
		
		JLabel localdetailsL = new JLabel("Users Details");
		localdetailsL.setForeground(Color.BLUE);
		localdetailsL.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		localdetailsL.setBounds(515, 61, 326, 46);
		contentPane.add(localdetailsL);
		
		JLabel msgL = new JLabel("");
		msgL.setForeground(Color.RED);
		msgL.setFont(new Font("Tahoma", Font.BOLD, 16));
		msgL.setBounds(449, 419, 412, 24);
		contentPane.add(msgL);
		
		String[] heading= {"User ID","Name","UserName","CNIC","Gender","Age","Passport no","Visa (status)"};
		
		String [][] users2D =new String[SignUp.u.size()][8];
		
		for(int i=0;i<SignUp.u.size();i++) {
			for(int j=0;j<8;j++) {
				
				String id=String.valueOf(SignUp.u.get(i).id);
				String age=String.valueOf(SignUp.u.get(i).age);
				String visaverified=Boolean.toString(SignUp.u.get(i).isVisa());
				
				users2D[i][0]=id;
				users2D[i][1]=SignUp.u.get(i).Name;
				users2D[i][2]=SignUp.u.get(i).userName;
				users2D[i][3]=SignUp.u.get(i).CNIC;
				users2D[i][4]=SignUp.u.get(i).Gender;
				users2D[i][5]=age;
				users2D[i][6]=SignUp.u.get(i).getPassport_no();
				users2D[i][7]=visaverified;
			}
		}
		
		DefaultTableModel modeltable = new DefaultTableModel(users2D,heading){
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 162, 1330, 218);
		contentPane.add(scrollPane);
		
		userTable = new JTable(modeltable);
		scrollPane.setViewportView(userTable);
		userTable.setFillsViewportHeight(true);
		userTable.setSurrendersFocusOnKeystroke(true);
		userTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		userTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JButton verifyB = new JButton("Verify Visa");
		verifyB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(userTable.getSelectedRow()==-1) {
					msgL.setText("Please Select a User first");
				}
				else {
					String userid=userTable.getValueAt(userTable.getSelectedRow(), 0).toString();
					int idtoGiveVisa=Integer.parseInt(userid);
					
					for(int i=0;i<SignUp.u.size();i++) {
						if(SignUp.u.get(i).id==idtoGiveVisa) {
							SignUp.u.get(i).setVisa(true);
							VisaVerified vv=new VisaVerified();
							vv.setVisible(true);
							dispose();
						}
					}
				}
			}
		});
		verifyB.setBounds(530, 475, 166, 38);
		contentPane.add(verifyB);
		
		JButton backB = new JButton("BACK");
		backB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminLoginSuccess als=new AdminLoginSuccess();
				als.setVisible(true);
				dispose();
			}
		});
		backB.setBounds(554, 568, 117, 38);
		contentPane.add(backB);
		
	}

}
