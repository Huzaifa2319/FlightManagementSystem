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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteBlockInter extends JFrame {

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
					DeleteBlockInter frame = new DeleteBlockInter();
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
	public DeleteBlockInter() {
		setTitle("Delete/Block International Flight ");		
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
		
		JLabel interdeleteL = new JLabel("Delete/Block International Flight");
		interdeleteL.setForeground(Color.BLUE);
		interdeleteL.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		interdeleteL.setBounds(493, 67, 326, 46);
		contentPane.add(interdeleteL);
		
		JLabel msgL = new JLabel("");
		msgL.setForeground(Color.RED);
		msgL.setFont(new Font("Tahoma", Font.BOLD, 16));
		msgL.setBounds(444, 413, 417, 30);
		contentPane.add(msgL);
		
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
		
		JButton deleteB = new JButton("Delete International Flight");
		deleteB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		deleteB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				AdminLogin al=new AdminLogin();
				
				if(table.getSelectedRow()==-1) {
					msgL.setText("Please Select a flight to delete");
				}
				else {
					String srno_inString=table.getValueAt(table.getSelectedRow(), 0).toString();
					String id_inString=table.getValueAt(table.getSelectedRow(),1).toString();
	
					int serial=Integer.parseInt(srno_inString);
					int idtodelete=Integer.parseInt(id_inString);
					al.admin.removeinternational(serial,idtodelete);
					
					interdeletebox  idb=new interdeletebox ();
					idb.setVisible(true);
					dispose();
				}
			}
		});
		deleteB.setBounds(225, 524, 222, 38);
		contentPane.add(deleteB);
		
		JButton blockB = new JButton("Block International Flight");
		blockB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				AdminLogin al=new AdminLogin();
				
				if(table.getSelectedRow()==-1) {
					msgL.setText("Please Select a flight to Block");
				}
				else {
					String id_inString=table.getValueAt(table.getSelectedRow(),1).toString();
	
					int idtoBlock=Integer.parseInt(id_inString);
					al.admin.blockinterflight(idtoBlock);;
					
					interblockbox ibb=new interblockbox();
					ibb.setVisible(true);
					dispose();
					}
			}
		});
		blockB.setBounds(549, 524, 212, 38);
		contentPane.add(blockB);
		
		JButton backB = new JButton("BACK");
		backB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminLoginSuccess als=new AdminLoginSuccess ();
				als.setVisible(true);
				dispose();
			}
		});
		backB.setBounds(578, 619, 161, 38);
		contentPane.add(backB);
		
		JButton openB = new JButton("Open International Flight");
		openB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
	AdminLogin al=new AdminLogin();
				
				if(table.getSelectedRow()==-1) {
					msgL.setText("Please Select a flight to Block");
				}
				else {
					String id_inString=table.getValueAt(table.getSelectedRow(),1).toString();
	
					int idtoopen=Integer.parseInt(id_inString);
					al.admin.openinterflight(idtoopen);;
					
					interopenbox ito=new interopenbox();
					ito.setVisible(true);
					dispose();
					}
			}
		});
		openB.setBounds(879, 524, 212, 38);
		contentPane.add(openB);
	}
}
