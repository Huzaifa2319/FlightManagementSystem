import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LocalDetailsTable extends JFrame {

	private JPanel contentPane;
	private JTable LocalTable;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LocalDetailsTable frame = new LocalDetailsTable();
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
	public LocalDetailsTable() {
		setTitle("Local Flight Schedule Details ");		
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
		
		JLabel localdetailsL = new JLabel("Local Flight Details");
		localdetailsL.setForeground(Color.BLUE);
		localdetailsL.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		localdetailsL.setBounds(493, 67, 326, 46);
		contentPane.add(localdetailsL);
		
		
		String[] heading= {"Serial#","Flight id","Departure","Airport Branch","Destination","Distance(km)","Hours","Date","Departure Time","Arrival Time","Economy Available","Business Available","Open Status"};
		
		String [][] local2d =new String[Admin.FM.localFlights.size()][13];
		
		for(int i=0;i<Admin.FM.localFlights.size();i++) {
			for(int j=0;j<13;j++) {
				
				String serialno=String.valueOf(Admin.FM.localFlights.get(i).SerialNo)	;
				String flightid=String.valueOf(Admin.FM.localFlights.get(i).id)	;
				String distance=String.valueOf(Admin.FM.localFlights.get(i).distance);
				String Hours=String.valueOf(Admin.FM.localFlights.get(i).time_Hours);								
				String Eseats=String.valueOf(Admin.FM.localFlights.get(i).seat_economy);
				String Bseats=String.valueOf(Admin.FM.localFlights.get(i).seat_bussiness);
				String isopen=Boolean.toString(Admin.FM.localFlights.get(i).isOpen);
				
				local2d [i][0]=serialno;
				local2d [i][1]=flightid;
				local2d [i][2]=Admin.FM.localFlights.get(i).Airport;
				local2d [i][3]=Admin.FM.localFlights.get(i).NorthSouth;
				local2d [i][4]=Admin.FM.localFlights.get(i).getCity();
				local2d [i][5]=distance;
				local2d [i][6]=Hours;
				local2d [i][7]=Admin.FM.localFlights.get(i).fdate;
				local2d [i][8]=Admin.FM.localFlights.get(i).ftime;
				local2d [i][9]=Admin.FM.localFlights.get(i).arrivalTime;
				local2d [i][10]=Eseats;
				local2d [i][11]=Bseats;
				local2d [i][12]=isopen;
			}
		}
		
		DefaultTableModel localtable = new DefaultTableModel(local2d,heading){
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 162, 1330, 218);
		contentPane.add(scrollPane);
		
		LocalTable = new JTable(localtable);
		scrollPane.setViewportView(LocalTable);
		LocalTable.setFillsViewportHeight(true);
		LocalTable.setSurrendersFocusOnKeystroke(true);
		LocalTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		LocalTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JButton backB = new JButton("BACK");
		backB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FlightDetails fd=new FlightDetails();
				fd.setVisible(true);
				dispose();
			}
		});
		backB.setBounds(554, 568, 117, 38);
		contentPane.add(backB);
		

	}
}
