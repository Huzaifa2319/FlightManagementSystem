import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddLocal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddLocal frame = new AddLocal();
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
	public AddLocal() {
		setTitle("ADMIN");		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1400, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel tittleL = new JLabel("New-PAK Airline Flight System (NPAFS)");
		tittleL.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		tittleL.setBounds(395, 0, 492, 63);
		contentPane.add(tittleL);
		
		JLabel lblSuccessfullyLoggedIn = new JLabel("Add Local Flights");
		lblSuccessfullyLoggedIn.setForeground(Color.BLUE);
		lblSuccessfullyLoggedIn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblSuccessfullyLoggedIn.setBounds(453, 61, 326, 46);
		contentPane.add(lblSuccessfullyLoggedIn);
		
		JLabel airportL = new JLabel("AIRPORT:");
		airportL.setFont(new Font("Tahoma", Font.BOLD, 11));
		airportL.setBounds(352, 118, 130, 14);
		contentPane.add(airportL);
		
		JLabel destL = new JLabel("DESTINATION CITY: ");
		destL.setFont(new Font("Tahoma", Font.BOLD, 11));
		destL.setBounds(352, 176, 137, 14);
		contentPane.add(destL);
		
		JLabel seatsL = new JLabel("SEATS:");
		seatsL.setFont(new Font("Tahoma", Font.BOLD, 11));
		seatsL.setBounds(352, 231, 86, 14);
		contentPane.add(seatsL);
		
		JLabel distL = new JLabel("DISTANCE:");
		distL.setFont(new Font("Tahoma", Font.BOLD, 11));
		distL.setBounds(352, 283, 130, 14);
		contentPane.add(distL);
		
		JLabel timeL = new JLabel("TIME:");
		timeL.setFont(new Font("Tahoma", Font.BOLD, 11));
		timeL.setBounds(352, 339, 130, 14);
		contentPane.add(timeL);
		
		JLabel fdateL = new JLabel("FLIGHT DATE:");
		fdateL.setFont(new Font("Tahoma", Font.BOLD, 11));
		fdateL.setBounds(352, 392, 130, 14);
		contentPane.add(fdateL);
		
		JLabel ftimeL = new JLabel("FLIGHT TIME:");
		ftimeL.setFont(new Font("Tahoma", Font.BOLD, 11));
		ftimeL.setBounds(352, 446, 130, 14);
		contentPane.add(ftimeL);
		
		JComboBox airportCB = new JComboBox();
		airportCB.setModel(new DefaultComboBoxModel(new String[] {"-", "Islamabad", "Karachi", "Peshawar", "Quetta", "Lahore"}));
		airportCB.setBounds(492, 118, 121, 22);
		contentPane.add(airportCB);
		
		JComboBox nsCB = new JComboBox();
		nsCB.setModel(new DefaultComboBoxModel(new String[] {"North", "South"}));
		nsCB.setBounds(685, 118, 121, 22);
		contentPane.add(nsCB);
		
		JComboBox arrivalCB = new JComboBox();
		arrivalCB.setModel(new DefaultComboBoxModel(new String[] {"-", "Quetta", "Islamabad", "Karachi", "Peshawar", "Lahore"}));
		arrivalCB.setBounds(492, 172, 121, 22);
		contentPane.add(arrivalCB);
		
		JSpinner ecoS = new JSpinner();
		ecoS.setModel(new SpinnerNumberModel(0, 0, 50, 1));
		ecoS.setBounds(579, 228, 55, 20);
		contentPane.add(ecoS);
		
		JSpinner busS = new JSpinner();
		busS.setModel(new SpinnerNumberModel(0, 0, 50, 1));
		busS.setBounds(751, 228, 55, 20);
		contentPane.add(busS);
		
		JLabel economyL = new JLabel("Economy:");
		economyL.setFont(new Font("Tahoma", Font.BOLD, 11));
		economyL.setBounds(492, 231, 86, 14);
		contentPane.add(economyL);
		
		JLabel lblBussiness = new JLabel("Bussiness:");
		lblBussiness.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBussiness.setBounds(655, 231, 86, 14);
		contentPane.add(lblBussiness);
		
		JLabel lblInKm = new JLabel("in KM");
		lblInKm.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInKm.setBounds(567, 283, 86, 14);
		contentPane.add(lblInKm);
		
		JSpinner disS = new JSpinner();
		disS.setModel(new SpinnerNumberModel(100, 100, 100000, 1));
		disS.setBounds(492, 280, 51, 20);
		contentPane.add(disS);
		
		JComboBox hourCB = new JComboBox();
		hourCB.setModel(new DefaultComboBoxModel(new String[] {"-", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		hourCB.setBounds(492, 442, 55, 22);
		contentPane.add(hourCB);
		
		JComboBox minCB = new JComboBox();
		minCB.setModel(new DefaultComboBoxModel(new String[] {"-", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		minCB.setBounds(612, 442, 55, 22);
		contentPane.add(minCB);
		
		JComboBox daynightCB = new JComboBox();
		daynightCB.setModel(new DefaultComboBoxModel(new String[] {"-", "am", "pm"}));
		daynightCB.setBounds(728, 446, 55, 22);
		contentPane.add(daynightCB);
		
		JComboBox dayCB = new JComboBox();
		dayCB.setModel(new DefaultComboBoxModel(new String[] {"-", "01", "02", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		dayCB.setBounds(492, 388, 55, 22);
		contentPane.add(dayCB);
		
		JComboBox monthCB = new JComboBox();
		monthCB.setModel(new DefaultComboBoxModel(new String[] {"-", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		monthCB.setBounds(612, 388, 55, 22);
		contentPane.add(monthCB);
		
		JComboBox yearCB = new JComboBox();
		yearCB.setModel(new DefaultComboBoxModel(new String[] {"-", "2021", "2022", "2023"}));
		yearCB.setBounds(728, 388, 55, 22);
		contentPane.add(yearCB);
		
		JLabel lblArrivalTime = new JLabel("ARRIVAL TIME:");
		lblArrivalTime.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblArrivalTime.setBounds(352, 502, 114, 14);
		contentPane.add(lblArrivalTime);
		
		JComboBox arhourCB = new JComboBox();
		arhourCB.setModel(new DefaultComboBoxModel(new String[] {"-", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		arhourCB.setBounds(492, 498, 55, 22);
		contentPane.add(arhourCB);
		
		JComboBox arminCB = new JComboBox();
		arminCB.setModel(new DefaultComboBoxModel(new String[] {"-", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		arminCB.setBounds(612, 498, 55, 22);
		contentPane.add(arminCB);
		
		JComboBox ardaynightCB = new JComboBox();
		ardaynightCB.setModel(new DefaultComboBoxModel(new String[] {"-", "am", "pm"}));
		ardaynightCB.setBounds(728, 498, 55, 22);
		contentPane.add(ardaynightCB);
		
		JLabel timeformat_2 = new JLabel("( Hour / Min / ampm)");
		timeformat_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		timeformat_2.setBounds(832, 502, 159, 14);
		contentPane.add(timeformat_2);
		
		JLabel msg5L = new JLabel("");
		msg5L.setForeground(Color.RED);
		msg5L.setBounds(492, 534, 289, 14);
		contentPane.add(msg5L);
		
		JLabel timeformat = new JLabel("( Hour / Min / ampm)");
		timeformat.setFont(new Font("Tahoma", Font.BOLD, 11));
		timeformat.setBounds(832, 450, 159, 14);
		contentPane.add(timeformat);
		
		JLabel timeformat_1 = new JLabel("( Day / Month / Year )");
		timeformat_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		timeformat_1.setBounds(832, 392, 159, 14);
		contentPane.add(timeformat_1);
		
		JLabel inhourL = new JLabel("in Hours");
		inhourL.setFont(new Font("Tahoma", Font.BOLD, 11));
		inhourL.setBounds(567, 339, 86, 14);
		contentPane.add(inhourL);
		
		JLabel msgL = new JLabel("");
		msgL.setForeground(Color.RED);
		msgL.setBounds(876, 118, 185, 14);
		contentPane.add(msgL);
		
		JLabel msg2L = new JLabel("");
		msg2L.setForeground(Color.RED);
		msg2L.setBounds(655, 176, 367, 14);
		contentPane.add(msg2L);
		
		JLabel msg3L = new JLabel("");
		msg3L.setForeground(Color.RED);
		msg3L.setBounds(492, 421, 326, 14);
		contentPane.add(msg3L);
		
		JLabel msg4L = new JLabel("");
		msg4L.setForeground(Color.RED);
		msg4L.setBounds(490, 473, 289, 14);
		contentPane.add(msg4L);
		
		JSpinner timeS = new JSpinner();
		timeS.setModel(new SpinnerNumberModel(1, 1, 30, 1));
		timeS.setBounds(492, 336, 55, 20);
		contentPane.add(timeS);
		
		JButton addB = new JButton("ADD");
		addB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean airportcheck = false;
				boolean arrivalcheck = false;
				boolean departure_destination = false;
				boolean datecheck = false;
				boolean timecheck = false;
				boolean arrTimecheck=false;
				
				String airp = null;
				String norSouth = null;
				double dist;
				int hours;
				String fdate = null; 
				String ftime = null;
				String arrivalTime=null;
				int bseat;
				int eseat;
				String city = null;
				
				if(!airportCB.getSelectedItem().toString().equals("-")) {
					airportcheck=true;
				}
				if(!arrivalCB.getSelectedItem().toString().equals("-")) {
					arrivalcheck = true;
				}
				
				if(!dayCB.getSelectedItem().toString().equals("-") && !monthCB.getSelectedItem().toString().equals("-") && !yearCB.getSelectedItem().toString().equals("-") ) {
					datecheck=true;
				}
				if(!hourCB.getSelectedItem().toString().equals("-") && !minCB.getSelectedItem().toString().equals("-") && !daynightCB.getSelectedItem().toString().equals("-") ) {
					timecheck=true;
				}
				if(!arhourCB.getSelectedItem().toString().equals("-") && !arminCB.getSelectedItem().toString().equals("-") && !ardaynightCB.getSelectedItem().toString().equals("-") ) {
					arrTimecheck=true;
				}
				
				if(airportcheck && arrivalcheck) {
					if(!airportCB.getSelectedItem().toString().equals(arrivalCB.getSelectedItem().toString())) {
						departure_destination=true;
					}
				}
				
				if(!airportcheck) {
					msgL.setText("Select airport first");
				}
				else {
					msgL.setText(" ");
				}
				
				if(!arrivalcheck) {
					msg2L.setText("Select destination city first");
				}
				else if(!departure_destination) {
					msg2L.setText("Departure and Destination city shall not be same");
				}
				else {
					msg2L.setText(" ");
				}
				
				if(!datecheck) {
					msg3L.setText("Select Date first");
				}
				else {
					msg3L.setText(" ");
				}
				if(!timecheck) {
					msg4L.setText("Select time first");
				}
				else {
					msg4L.setText(" ");
				}
				if(!arrTimecheck) {
					msg5L.setText("Select time first");
				}
				else {
					msg5L.setText(" ");
				}
				
				
				norSouth=nsCB.getSelectedItem().toString();
				dist=Double.parseDouble(disS.getValue().toString());
				hours=Integer.parseInt(timeS.getValue().toString());
				bseat=Integer.parseInt(busS.getValue().toString());
				eseat=Integer.parseInt(ecoS.getValue().toString());

				if(airportcheck) {
					airp=airportCB.getSelectedItem().toString();
				}
				if(arrivalcheck && departure_destination) {
					city=arrivalCB.getSelectedItem().toString();
				}
				if(datecheck) {
					String day=dayCB.getSelectedItem().toString();
					String month=monthCB.getSelectedItem().toString();
					String year=yearCB.getSelectedItem().toString();
					fdate=day.concat(" / ").concat(month).concat(" / ").concat(year);
				}
				if(timecheck) {
					String hour=hourCB.getSelectedItem().toString();
					String min=minCB.getSelectedItem().toString();
					String ampm=daynightCB.getSelectedItem().toString();
					ftime=hour.concat(" : ").concat(min).concat(" ").concat(ampm);
				}
				if(arrTimecheck) {
					String hour=hourCB.getSelectedItem().toString();
					String min=minCB.getSelectedItem().toString();
					String ampm=daynightCB.getSelectedItem().toString();
					arrivalTime=hour.concat(" : ").concat(min).concat(" ").concat(ampm);
				}
				
				if(airportcheck && arrivalcheck && departure_destination && datecheck && timecheck && arrTimecheck) {
					AdminLogin al=new AdminLogin();
					al.admin.addLocal(airp, norSouth, dist, hours, fdate, ftime,arrivalTime, bseat, eseat, city);
					LocalAdded la=new LocalAdded();
					la.setVisible(true);
					dispose();
				}	
			}
		});
		addB.setBounds(492, 586, 173, 23);
		contentPane.add(addB);
		
		JButton backB = new JButton("Back");
		backB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminLoginSuccess als=new AdminLoginSuccess();
				als.setVisible(true);
				dispose();
			}
		});
		backB.setBounds(533, 661, 89, 23);
		contentPane.add(backB);
		
	}
}
