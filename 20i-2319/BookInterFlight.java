import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
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
import javax.swing.JRadioButton;

public class BookInterFlight extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookInterFlight frame = new BookInterFlight();
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
	public BookInterFlight() {
		setTitle("Book International Flight");		
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
		
		JLabel interdetailsL = new JLabel("Book International Flights");
		interdetailsL.setForeground(Color.BLUE);
		interdetailsL.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		interdetailsL.setBounds(493, 67, 326, 46);
		contentPane.add(interdetailsL);
		
		JLabel msg2L = new JLabel("");
		msg2L.setForeground(Color.RED);
		msg2L.setFont(new Font("Tahoma", Font.BOLD, 18));
		msg2L.setBounds(502, 483, 371, 31);
		contentPane.add(msg2L);
		
		JLabel msgL = new JLabel("");
		msgL.setForeground(Color.RED);
		msgL.setFont(new Font("Tahoma", Font.BOLD, 18));
		msgL.setBounds(502, 407, 371, 31);
		contentPane.add(msgL);
		

String[] heading= {"Serial#","Flight id","Departure","Airport Branch","Indirect","in Between Country","Destination","Distance(km)","Hours","Date","Departure Time","Arrival Time","Economy Available","Business Available","Open Status"};
		
		String [][] searched2d =new String[SearchInternational.searchedinter.size()][15];
		
		for(int i=0;i<SearchInternational.searchedinter.size();i++) {
			for(int j=0;j<15;j++) {
				
				String serialno=String.valueOf(SearchInternational.searchedinter.get(i).SerialNo);
				String flightid=String.valueOf(SearchInternational.searchedinter.get(i).id)	;
				String distance=String.valueOf(SearchInternational.searchedinter.get(i).distance);
				String Hours=String.valueOf(SearchInternational.searchedinter.get(i).time_Hours);								
				String Eseats=String.valueOf(SearchInternational.searchedinter.get(i).seat_economy);
				String Bseats=String.valueOf(SearchInternational.searchedinter.get(i).seat_bussiness);
				String indirectbool=Boolean.toString(SearchInternational.searchedinter.get(i).isIndierct());
				String isopen=Boolean.toString(SearchInternational.searchedinter.get(i).isOpen);
				
						searched2d[i][0]=serialno;					
						searched2d[i][1]=flightid;					
						searched2d[i][2]=SearchInternational.searchedinter.get(i).Airport;
						searched2d[i][3]=SearchInternational.searchedinter.get(i).NorthSouth;
						searched2d[i][4]=indirectbool;	
						searched2d[i][5]=SearchInternational.searchedinter.get(i).getIndirectRouteCountry();
						searched2d[i][6]=SearchInternational.searchedinter.get(i).getCountry();				
						searched2d[i][7]=distance;		
						searched2d[i][8]=Hours;			
						searched2d[i][9]=SearchInternational.searchedinter.get(i).fdate;		
						searched2d[i][10]=SearchInternational.searchedinter.get(i).ftime;				
						searched2d[i][11]=SearchInternational.searchedinter.get(i).arrivalTime;					
						searched2d[i][12]=Eseats;			
						searched2d[i][13]=Bseats;						
						searched2d[i][14]=isopen;			
			}
				
		}
		
		DefaultTableModel intertable = new DefaultTableModel(searched2d,heading){
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 155, 1350, 218);
		contentPane.add(scrollPane);
		
		table = new JTable(intertable);
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setSurrendersFocusOnKeystroke(true);
		
		JButton backB = new JButton("BACK");
		backB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SearchInternational si=new SearchInternational();
				si.setVisible(true);
				si.searchedinter.clear();
				dispose();
			}
		});
		backB.setBounds(554, 647, 117, 38);
		contentPane.add(backB);
		
		JRadioButton bussinessB = new JRadioButton("Bussiness");
		bussinessB.setForeground(Color.BLACK);
		bussinessB.setFont(new Font("Tahoma", Font.BOLD, 11));
		bussinessB.setBackground(Color.ORANGE);
		bussinessB.setBounds(460, 445, 109, 23);
		contentPane.add(bussinessB);
		
		JRadioButton economyB = new JRadioButton("Economy");
		economyB.setForeground(Color.BLACK);
		economyB.setFont(new Font("Tahoma", Font.BOLD, 11));
		economyB.setBackground(Color.ORANGE);
		economyB.setBounds(667, 445, 109, 23);
		contentPane.add(economyB);
		
		ButtonGroup bb=new ButtonGroup();
		bb.add(economyB);
		bb.add(bussinessB);
		
		JButton btnNewButton = new JButton("Confirm Booking");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean buttoncheck=false;
				
				if(table.getSelectedRow()==-1) {
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
				
				if(table.getSelectedRow()!=-1 && buttoncheck) {
					int row=table.getSelectedRow();
					int col=1;//for getting id
					String id_in_String=table.getValueAt(row, col).toString();
					int id_to_buy=Integer.parseInt(id_in_String);
					
					International flight_to_buy;
					int buss=0;
					int econ=0;
					
					if(bussinessB.isSelected()) {
						buss=1;
					}
					if(economyB.isSelected()) {
						econ=1;
					}
					
					for(int i=0;i<Admin.FM.interFlights.size();i++) {
						if(Admin.FM.interFlights.get(i).getId()==id_to_buy) {
							for(int j=0;j<SignUp.u.size();j++) {
								if(SignUp.u.get(j).login_status==true) {
									if(SignUp.u.get(j).isVisa()==true) {
									
									flight_to_buy=Admin.FM.interFlights.get(i);
									Admin.FM.interFlights.get(i).setSeat_bussiness(Admin.FM.interFlights.get(i).getSeat_bussiness()-buss);
									Admin.FM.interFlights.get(i).setSeat_economy(Admin.FM.interFlights.get(i).getSeat_economy()-econ);
									SignUp.u.get(j).Book_Inter(flight_to_buy, buss, econ);
									
									SuccessfullyPurchased sp=new SuccessfullyPurchased();
									sp.setVisible(true);
									dispose();
									}
									else {
										VisaMsg vm=new VisaMsg();
										vm.setVisible(true);
									}
								}
							}
						}
					}
				}
				
			}
		});
		btnNewButton.setBounds(533, 557, 159, 37);
		contentPane.add(btnNewButton);
	}

}
