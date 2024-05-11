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
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CancelBookedFlight extends JFrame {

	private JPanel contentPane;
	private JTable LocalTable;
	private JScrollPane scrollPane;
	private JTable table;
	private JScrollPane scrollPane2; 
	private JLabel msgL;
	private JLabel msg2L;
	private JButton localCancelB;
	private JButton interCancelB;
	private JButton backB;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CancelBookedFlight frame = new CancelBookedFlight();
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
	public CancelBookedFlight() {
		setTitle("Cancel Booked Flights Menu");		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1400, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel tittleL = new JLabel("New-PAK Airline Flight System (NPAFS)");
		tittleL.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		tittleL.setBounds(434, 11, 492, 63);
		contentPane.add(tittleL);
		
		JLabel lblSuccessfullyLoggedIn = new JLabel("Cancel Booked Flights (Local)");
		lblSuccessfullyLoggedIn.setForeground(Color.BLUE);
		lblSuccessfullyLoggedIn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblSuccessfullyLoggedIn.setBounds(483, 61, 366, 63);
		contentPane.add(lblSuccessfullyLoggedIn);
		
		String [][] Lbooked2d=null;
		String [][] Ibooked2d=null;
		
		String[] heading= {"Booking ID","Flight id","Departure","Airport Branch","Destination","Distance(km)","Hours","Date","Departure Time","Arrival Time","Seat Class","Cost","Tax","TotalPaid (pkr)","Booking Status"};
		String[] interheading= {"Booking ID","Flight id","Departure","Airport Branch","Destination","inbetween country","Distance(km)","Hours","Date","Departure Time","Arrival Time","Seat Class","Cost","Tax","TotalPaid (pkr)","Booking Status"};
		
		for(int x=0;x<SignUp.u.size();x++) {
			if(SignUp.u.get(x).login_status) {
				Lbooked2d =new String[SignUp.u.get(x).Localbooked.size()][15];
				
		for(int i=0;i<SignUp.u.get(x).Localbooked.size();i++) {
			for(int j=0;j<15;j++) {
				
				String BookingId=String.valueOf(SignUp.u.get(x).Localbooked.get(i).booking_id);
				String flightid=String.valueOf(SignUp.u.get(x).Localbooked.get(i).bookflight.id);
				String distance=String.valueOf(SignUp.u.get(x).Localbooked.get(i).bookflight.distance);
				String Hours=String.valueOf(SignUp.u.get(x).Localbooked.get(i).bookflight.time_Hours);	
				String cost=String.valueOf(SignUp.u.get(x).Localbooked.get(i).cost);
				String tax=String.valueOf(SignUp.u.get(x).Localbooked.get(i).GovtTAX);
				String totalPaid=String.valueOf(SignUp.u.get(x).Localbooked.get(i).ammountToPay);

				String seatClass = null;
				if(SignUp.u.get(x).Localbooked.get(i).Bseats==1) {
					seatClass="Bussiness";
				}
				else if(SignUp.u.get(x).Localbooked.get(i).Eseats==1) {
					seatClass="Economy";
				}
				
				String bookingstatus = null;
				if(SignUp.u.get(x).Localbooked.get(i).isCancelled==false) {
					bookingstatus="Booked";
				}
				else if(SignUp.u.get(x).Localbooked.get(i).isCancelled) {
					bookingstatus="Cancelled";
				}
				
				Lbooked2d [i][0]=BookingId;
				Lbooked2d [i][1]=flightid;
				Lbooked2d [i][2]=SignUp.u.get(x).Localbooked.get(i).bookflight.Airport;
				Lbooked2d [i][3]=SignUp.u.get(x).Localbooked.get(i).bookflight.NorthSouth;
				Lbooked2d [i][4]=SignUp.u.get(x).Localbooked.get(i).bookflight.getCity();
				Lbooked2d [i][5]=distance;
				Lbooked2d [i][6]=Hours;
				Lbooked2d [i][7]=SignUp.u.get(x).Localbooked.get(i).bookflight.fdate;
				Lbooked2d [i][8]=SignUp.u.get(x).Localbooked.get(i).bookflight.ftime;
				Lbooked2d [i][9]=SignUp.u.get(x).Localbooked.get(i).bookflight.arrivalTime;
				Lbooked2d [i][10]=seatClass;
				Lbooked2d [i][11]=cost;
				Lbooked2d [i][12]=tax;
				Lbooked2d [i][13]=totalPaid;
				Lbooked2d [i][14]=bookingstatus;
			}
		}
		
			}
		}
		
		DefaultTableModel localtable = new DefaultTableModel(Lbooked2d,heading){
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		
		
		
		for(int x=0;x<SignUp.u.size();x++) {
			if(SignUp.u.get(x).login_status) {

				Ibooked2d=new String[SignUp.u.get(x).Interbooked.size()][16];

		for(int i=0;i<SignUp.u.get(x).Interbooked.size();i++) {
			for(int j=0;j<15;j++) {
				
				String BookingId=String.valueOf(SignUp.u.get(x).Interbooked.get(i).booking_id);
				String flightid=String.valueOf(SignUp.u.get(x).Interbooked.get(i).bookflight.id);
				String distance=String.valueOf(SignUp.u.get(x).Interbooked.get(i).bookflight.distance);
				String Hours=String.valueOf(SignUp.u.get(x).Interbooked.get(i).bookflight.time_Hours);	
				String cost=String.valueOf(SignUp.u.get(x).Interbooked.get(i).cost);
				String tax=String.valueOf(SignUp.u.get(x).Interbooked.get(i).GovtTAX);
				String totalPaid=String.valueOf(SignUp.u.get(x).Interbooked.get(i).ammountToPay);

				String seatClass = null;
				if(SignUp.u.get(x).Interbooked.get(i).Bseats==1) {
					seatClass="Bussiness";
				}
				else if(SignUp.u.get(x).Interbooked.get(i).Eseats==1) {
					seatClass="Economy";
				}
				
				String bookingstatus = null;
				if(SignUp.u.get(x).Interbooked.get(i).isCancelled==false) {
					bookingstatus="Booked";
				}
				else if(SignUp.u.get(x).Interbooked.get(i).isCancelled) {
					bookingstatus="Cancelled";
				}
				
				Ibooked2d [i][0]=BookingId;
				Ibooked2d [i][1]=flightid;
				Ibooked2d [i][2]=SignUp.u.get(x).Interbooked.get(i).bookflight.Airport;
				Ibooked2d [i][3]=SignUp.u.get(x).Interbooked.get(i).bookflight.NorthSouth;
				Ibooked2d [i][4]=SignUp.u.get(x).Interbooked.get(i).bookflight.getCountry();
				Ibooked2d [i][5]=SignUp.u.get(x).Interbooked.get(i).bookflight.getIndirectRouteCountry();
				Ibooked2d [i][6]=distance;
				Ibooked2d [i][7]=Hours;
				Ibooked2d [i][8]=SignUp.u.get(x).Interbooked.get(i).bookflight.fdate;
				Ibooked2d [i][9]=SignUp.u.get(x).Interbooked.get(i).bookflight.ftime;
				Ibooked2d [i][10]=SignUp.u.get(x).Interbooked.get(i).bookflight.arrivalTime;
				Ibooked2d [i][11]=seatClass;
				Ibooked2d [i][12]=cost;
				Ibooked2d [i][13]=tax;
				Ibooked2d [i][14]=totalPaid;
				Ibooked2d [i][15]=bookingstatus;
			}
		}
		
			}
		}
		
		
		DefaultTableModel intertable = new DefaultTableModel(Ibooked2d,interheading){
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 114, 1330, 142);
		contentPane.add(scrollPane);
		
		LocalTable = new JTable(localtable);
		scrollPane.setViewportView(LocalTable);
		LocalTable.setFillsViewportHeight(true);
		LocalTable.setSurrendersFocusOnKeystroke(true);
		LocalTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		LocalTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JLabel lblBookedFlightsinternational = new JLabel("Booked Flights (International)");
		lblBookedFlightsinternational.setForeground(Color.BLUE);
		lblBookedFlightsinternational.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblBookedFlightsinternational.setBounds(434, 347, 382, 45);
		contentPane.add(lblBookedFlightsinternational);
		
		scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(10, 392, 1328, 157);
		contentPane.add(scrollPane2);
		
		table = new JTable(intertable);
		scrollPane2.setViewportView(table);
		table.setSurrendersFocusOnKeystroke(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		msgL = new JLabel("");
		msgL.setForeground(Color.RED);
		msgL.setFont(new Font("Tahoma", Font.BOLD, 14));
		msgL.setBounds(328, 267, 413, 29);
		contentPane.add(msgL);
		
		msg2L = new JLabel("");
		msg2L.setForeground(Color.RED);
		msg2L.setFont(new Font("Tahoma", Font.BOLD, 14));
		msg2L.setBounds(367, 560, 413, 29);
		contentPane.add(msg2L);
		
		localCancelB = new JButton("Confirm Cancel");
		localCancelB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(LocalTable.getSelectedRow()==-1) {
					msgL.setText("Firstly Select a booking to cancel");
				}
				else if(LocalTable.getSelectedRow()!=-1) {
					int row=LocalTable.getSelectedRow();
					int col=0;//for getting booking id
					String id_in_String=LocalTable.getValueAt(row, col).toString();
					int id_to_Cancel=Integer.parseInt(id_in_String);
					
					for(int j=0;j<SignUp.u.size();j++) {
						if(SignUp.u.get(j).login_status==true) {
							if(SignUp.u.get(j).cancelLocal(id_to_Cancel)) {
							CancelRefundBox crb=new CancelRefundBox();
							crb.setVisible(true);
							dispose();
							}
						}
						else {
							msgL.setText("Already Cancelled");
						}
					}
				}
			}
		});
		localCancelB.setBounds(482, 307, 113, 29);
		contentPane.add(localCancelB);
		
		interCancelB = new JButton("Confirm Cancel");
		interCancelB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(table.getSelectedRow()==-1) {
					msg2L.setText("Firstly Select a booking to cancel");
				}
				else if(table.getSelectedRow()!=-1) {
					int row=table.getSelectedRow();
					int col=0;//for getting booking id
					String id_in_String=table.getValueAt(row, col).toString();
					int id_to_Cancel=Integer.parseInt(id_in_String);
					
					for(int j=0;j<SignUp.u.size();j++) {
						if(SignUp.u.get(j).login_status==true) {
							if(SignUp.u.get(j).cancelinter(id_to_Cancel)) {
							CancelRefundBox crb=new CancelRefundBox();
							crb.setVisible(true);
							dispose();
							}
							else {
								msg2L.setText("Already Cancelled");
							}
						}
					}
				}
			}
		});
		interCancelB.setBounds(483, 600, 113, 29);
		contentPane.add(interCancelB);
		
		backB = new JButton("Go Back");
		backB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UserLoginSuccess uls=new UserLoginSuccess();
				uls.setVisible(true);
				dispose();
			}
		});
		backB.setBounds(483, 666, 113, 29);
		contentPane.add(backB);
	}

}
