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

public class InterDetailsTable extends JFrame {

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
					InterDetailsTable frame = new InterDetailsTable();
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
	public InterDetailsTable() {
		setTitle("International Flight Schedule Details ");		
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
		
		JLabel interdetailsL = new JLabel("International Flight Details");
		interdetailsL.setForeground(Color.BLUE);
		interdetailsL.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		interdetailsL.setBounds(493, 67, 326, 46);
		contentPane.add(interdetailsL);
		

String[] heading= {"Serial#","Flight id","Departure","Airport Branch","Indirect","in Between Country","Destination","Distance(km)","Hours","Date","Departure Time","Arrival Time","Economy Available","Business Available","Open Status"};
		
		String [][] inter2d =new String[Admin.FM.interFlights.size()][15];
		
		for(int i=0;i<Admin.FM.interFlights.size();i++) {
			for(int j=0;j<15;j++) {
				
				String serialno=String.valueOf(Admin.FM.interFlights.get(i).SerialNo);
				String flightid=String.valueOf(Admin.FM.interFlights.get(i).id)	;
				String distance=String.valueOf(Admin.FM.interFlights.get(i).distance);
				String Hours=String.valueOf(Admin.FM.interFlights.get(i).time_Hours);								
				String Eseats=String.valueOf(Admin.FM.interFlights.get(i).seat_economy);
				String Bseats=String.valueOf(Admin.FM.interFlights.get(i).seat_bussiness);
				String indirectbool=Boolean.toString(Admin.FM.interFlights.get(i).isIndierct());
				String isopen=Boolean.toString(Admin.FM.interFlights.get(i).isOpen);
				
						inter2d[i][0]=serialno;					
						inter2d[i][1]=flightid;					
						inter2d[i][2]=Admin.FM.interFlights.get(i).Airport;
						inter2d[i][3]=Admin.FM.interFlights.get(i).NorthSouth;
						inter2d[i][4]=indirectbool;	
						inter2d[i][5]=Admin.FM.interFlights.get(i).getIndirectRouteCountry();
						inter2d[i][6]=Admin.FM.interFlights.get(i).getCountry();				
						inter2d[i][7]=distance;		
						inter2d[i][8]=Hours;			
						inter2d[i][9]=Admin.FM.interFlights.get(i).fdate;		
						inter2d[i][10]=Admin.FM.interFlights.get(i).ftime;				
						inter2d[i][11]=Admin.FM.interFlights.get(i).arrivalTime;					
						inter2d[i][12]=Eseats;			
						inter2d[i][13]=Bseats;						
						inter2d[i][14]=isopen;			
			}
				
		}
		
		DefaultTableModel intertable = new DefaultTableModel(inter2d,heading){
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
				FlightDetails fd=new FlightDetails();
				fd.setVisible(true);
				dispose();
			}
		});
		backB.setBounds(554, 568, 117, 38);
		contentPane.add(backB);
	}
}

