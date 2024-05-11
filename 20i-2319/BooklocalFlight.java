import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BooklocalFlight extends JFrame {

	private JPanel contentPane;
	private JTable searchTable;
	private JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BooklocalFlight frame = new BooklocalFlight();
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
	public BooklocalFlight() {
		setTitle("Book Local Flight ");		
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
		
		JLabel localdetailsL = new JLabel("Book Local Flights");
		localdetailsL.setForeground(Color.BLUE);
		localdetailsL.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		localdetailsL.setBounds(493, 67, 326, 46);
		contentPane.add(localdetailsL);
		
		String[] heading= {"Serial#","Flight id","Departure","Airport Branch","Destination","Distance(km)","Hours","Date","Departure Time","Arrival Time","Economy Available","Business Available","Open Status"};
		
		String [][] searched2d =new String[SearchLocal.searchedlocal.size()][13];

		for(int i=0;i<SearchLocal.searchedlocal.size();i++) {
			for(int j=0;j<13;j++) {
				
				String serialno=String.valueOf(SearchLocal.searchedlocal.get(i).SerialNo)	;
				String flightid=String.valueOf(SearchLocal.searchedlocal.get(i).id)	;
				String distance=String.valueOf(SearchLocal.searchedlocal.get(i).distance);
				String Hours=String.valueOf(SearchLocal.searchedlocal.get(i).time_Hours);								
				String Eseats=String.valueOf(SearchLocal.searchedlocal.get(i).seat_economy);
				String Bseats=String.valueOf(SearchLocal.searchedlocal.get(i).seat_bussiness);
				String isopen=Boolean.toString(SearchLocal.searchedlocal.get(i).isOpen);
				
				searched2d [i][0]=serialno;
				searched2d [i][1]=flightid;
				searched2d [i][2]=SearchLocal.searchedlocal.get(i).Airport;
				searched2d [i][3]=SearchLocal.searchedlocal.get(i).NorthSouth;
				searched2d [i][4]=Admin.FM.localFlights.get(i).getCity();
				searched2d [i][5]=distance;
				searched2d [i][6]=Hours;
				searched2d [i][7]=SearchLocal.searchedlocal.get(i).fdate;
				searched2d [i][8]=SearchLocal.searchedlocal.get(i).ftime;
				searched2d [i][9]=SearchLocal.searchedlocal.get(i).arrivalTime;
				searched2d [i][10]=Eseats;
				searched2d [i][11]=Bseats;
				searched2d [i][12]=isopen;
			}
		}
		
		DefaultTableModel localtable = new DefaultTableModel(searched2d,heading){
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 162, 1330, 218);
		contentPane.add(scrollPane);
		
		searchTable = new JTable(localtable);
		scrollPane.setViewportView(searchTable);
		searchTable.setFillsViewportHeight(true);
		searchTable.setSurrendersFocusOnKeystroke(true);
		searchTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		searchTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JRadioButton bussinessB = new JRadioButton("Bussiness");
		bussinessB.setBackground(Color.ORANGE);
		bussinessB.setFont(new Font("Tahoma", Font.BOLD, 11));
		bussinessB.setForeground(Color.BLACK);
		bussinessB.setBounds(475, 475, 109, 23);
		contentPane.add(bussinessB);
		
		JRadioButton economyB = new JRadioButton("Economy");
		economyB.setForeground(Color.BLACK);
		economyB.setFont(new Font("Tahoma", Font.BOLD, 11));
		economyB.setBackground(Color.ORANGE);
		economyB.setBounds(661, 475, 109, 23);
		contentPane.add(economyB);
		
		ButtonGroup bb=new ButtonGroup();
		bb.add(economyB);
		bb.add(bussinessB);
		
		JLabel msgL = new JLabel("");
		msgL.setFont(new Font("Tahoma", Font.BOLD, 18));
		msgL.setForeground(Color.RED);
		msgL.setBounds(492, 415, 371, 31);
		contentPane.add(msgL);
		
		JLabel msg2L = new JLabel("");
		msg2L.setForeground(Color.RED);
		msg2L.setFont(new Font("Tahoma", Font.BOLD, 18));
		msg2L.setBounds(492, 505, 371, 31);
		contentPane.add(msg2L);
		
		JButton btnNewButton = new JButton("Confirm Booking");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean buttoncheck=false;
				
				if(searchTable.getSelectedRow()==-1) {
					msgL.setText("Select a Flight to Book");
				}
				else {
					msgL.setText(" ");
				}
				
				if(!bussinessB.isSelected() && !economyB.isSelected()) {
					msg2L.setText("Select your seat class");
				}
				
				if(bussinessB.isSelected() || economyB.isSelected()) {
					buttoncheck=true;
					msg2L.setText(" ");
				}
				
				if(searchTable.getSelectedRow()!=-1 && buttoncheck) {
					int row=searchTable.getSelectedRow();
					int col=1;//for getting id
					String id_in_String=searchTable.getValueAt(row, col).toString();
					int id_to_buy=Integer.parseInt(id_in_String);
					
					Local flight_to_buy;
					int buss=0;
					int econ=0;
					
					if(bussinessB.isSelected()) {
						buss=1;
					}
					if(economyB.isSelected()) {
						econ=1;
					}
					
					for(int i=0;i<Admin.FM.localFlights.size();i++) {
						if(Admin.FM.localFlights.get(i).getId()==id_to_buy) {
							flight_to_buy=Admin.FM.localFlights.get(i);
							Admin.FM.localFlights.get(i).setSeat_bussiness(Admin.FM.localFlights.get(i).getSeat_bussiness()-buss);
							Admin.FM.localFlights.get(i).setSeat_economy(Admin.FM.localFlights.get(i).getSeat_economy()-econ);
							
							
							for(int j=0;j<SignUp.u.size();j++) {
								if(SignUp.u.get(j).login_status==true) {
									SignUp.u.get(j).Book_Local(flight_to_buy, buss, econ);
									SuccessfullyPurchased sp=new SuccessfullyPurchased();
									sp.setVisible(true);
									dispose();
								}
							}
						}
					}
				}
				
			}
		});
		btnNewButton.setBounds(524, 559, 159, 37);
		contentPane.add(btnNewButton);
		
		JButton backB = new JButton("Back");
		backB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SearchLocal sl=new SearchLocal();
				sl.setVisible(true);
				dispose();
			}
		});
		backB.setBounds(558, 625, 99, 31);
		contentPane.add(backB);
		
		
		
		}
}
