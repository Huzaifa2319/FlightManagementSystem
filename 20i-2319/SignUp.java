import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.Format;
import java.util.ArrayList;

public class SignUp extends JFrame {

	private JPanel contentPaneU;
	private JTextField nameTF;
	private JTextField cnicTF;
	private JPasswordField passwordTF;
	private JPasswordField conPassTF;
	private JTextField usernameTF;

	static int userid=1;
	
	static ArrayList<User> u=new ArrayList<>();
	private JTextField passportTF;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		setTitle("SIGNUP");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1400, 800);
		contentPaneU = new JPanel();
		contentPaneU.setBackground(Color.ORANGE);
		contentPaneU.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneU);
		contentPaneU.setLayout(null);

		JLabel Signup = new JLabel("PASSENGER SIGN UP");
		Signup.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		Signup.setBounds(541, 29, 242, 35);
		contentPaneU.add(Signup);
		
		JLabel NameL = new JLabel("Name: ");
		NameL.setFont(new Font("Tahoma", Font.BOLD, 11));
		NameL.setBounds(301, 92, 123, 14);
		contentPaneU.add(NameL);
		
		JLabel CNICL = new JLabel("CNIC: ");
		CNICL.setFont(new Font("Tahoma", Font.BOLD, 11));
		CNICL.setBounds(301, 196, 123, 14);
		contentPaneU.add(CNICL);
		
		JLabel GenderL = new JLabel("Gender:");
		GenderL.setFont(new Font("Tahoma", Font.BOLD, 11));
		GenderL.setBounds(301, 310, 123, 14);
		contentPaneU.add(GenderL);
		
		JLabel AgeL = new JLabel("Age: ");
		AgeL.setFont(new Font("Tahoma", Font.BOLD, 11));
		AgeL.setBounds(301, 366, 123, 14);
		contentPaneU.add(AgeL);
		
		JLabel PassL = new JLabel("Password: ");
		PassL.setFont(new Font("Tahoma", Font.BOLD, 11));
		PassL.setBounds(301, 423, 123, 14);
		contentPaneU.add(PassL);
		
		JLabel conPassL = new JLabel("Confirm Password: ");
		conPassL.setFont(new Font("Tahoma", Font.BOLD, 11));
		conPassL.setBounds(301, 481, 123, 14);
		contentPaneU.add(conPassL);
		
		JLabel cnichelp = new JLabel("(13 digit without -)");
		cnichelp.setBounds(497, 224, 161, 14);
		contentPaneU.add(cnichelp);
		
		nameTF = new JTextField();
		nameTF.setBounds(497, 92, 266, 20);
		contentPaneU.add(nameTF);
		nameTF.setColumns(10);
		
		cnicTF = new JTextField();
		cnicTF.setToolTipText("");
		cnicTF.setColumns(10);
		cnicTF.setBounds(497, 193, 266, 20);
		contentPaneU.add(cnicTF);
		
		JRadioButton maleB = new JRadioButton("Male");
		maleB.setFont(new Font("Tahoma", Font.BOLD, 11));
		maleB.setBackground(Color.ORANGE);
		maleB.setBounds(497, 306, 78, 23);
		contentPaneU.add(maleB);
		
		JRadioButton femaleB = new JRadioButton("Female");
		femaleB.setFont(new Font("Tahoma", Font.BOLD, 11));
		femaleB.setBackground(Color.ORANGE);
		femaleB.setBounds(595, 306, 85, 23);
		contentPaneU.add(femaleB);
		
		JRadioButton customB = new JRadioButton("Custom");
		customB.setFont(new Font("Tahoma", Font.BOLD, 11));
		customB.setBackground(Color.ORANGE);
		customB.setBounds(689, 306, 109, 23);
		contentPaneU.add(customB);
		
		ButtonGroup gen=new ButtonGroup();
		gen.add(customB);
		gen.add(maleB);
		gen.add(femaleB);
		
		JComboBox ageCB = new JComboBox();
		ageCB.setModel(new DefaultComboBoxModel(new String[] {"-", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100"}));
		ageCB.setBounds(497, 362, 55, 22);
		contentPaneU.add(ageCB);
		
		passwordTF = new JPasswordField();
		passwordTF.setBounds(497, 420, 266, 20);
		contentPaneU.add(passwordTF);
		
		conPassTF = new JPasswordField();
		conPassTF.setBounds(497, 475, 266, 20);
		contentPaneU.add(conPassTF);
		
		JLabel msg1 = new JLabel("");
		msg1.setFont(new Font("Tahoma", Font.BOLD, 11));
		msg1.setForeground(Color.RED);
		msg1.setBounds(786, 92, 310, 14);
		contentPaneU.add(msg1);
		
		JLabel msg2 = new JLabel("");
		msg2.setForeground(Color.RED);
		msg2.setFont(new Font("Tahoma", Font.BOLD, 11));
		msg2.setBounds(819, 143, 310, 14);
		contentPaneU.add(msg2);
		
		JLabel msg3 = new JLabel("");
		msg3.setForeground(Color.RED);
		msg3.setFont(new Font("Tahoma", Font.BOLD, 11));
		msg3.setBounds(819, 196, 310, 14);
		contentPaneU.add(msg3);
		
		JLabel msg4 = new JLabel("");
		msg4.setForeground(Color.RED);
		msg4.setFont(new Font("Tahoma", Font.BOLD, 11));
		msg4.setBounds(819, 310, 310, 14);
		contentPaneU.add(msg4);
		
		JLabel msg5 = new JLabel("");
		msg5.setForeground(Color.RED);
		msg5.setFont(new Font("Tahoma", Font.BOLD, 11));
		msg5.setBounds(819, 426, 371, 14);
		contentPaneU.add(msg5);
		
		JLabel msg6 = new JLabel("");
		msg6.setForeground(Color.RED);
		msg6.setFont(new Font("Tahoma", Font.BOLD, 11));
		msg6.setBounds(819, 481, 310, 14);
		contentPaneU.add(msg6);
		
		JLabel msg7 = new JLabel("");
		msg7.setForeground(Color.RED);
		msg7.setFont(new Font("Tahoma", Font.BOLD, 11));
		msg7.setBounds(819, 546, 310, 14);
		contentPaneU.add(msg7);
		
		JLabel msg8 = new JLabel("");
		msg8.setForeground(Color.RED);
		msg8.setFont(new Font("Tahoma", Font.BOLD, 11));
		msg8.setBounds(819, 366, 310, 14);
		contentPaneU.add(msg8);
		
		JLabel passportL = new JLabel("Passport no: ");
		passportL.setFont(new Font("Tahoma", Font.BOLD, 11));
		passportL.setBounds(301, 252, 123, 14);
		contentPaneU.add(passportL);
		
		passportTF = new JTextField();
		passportTF.setToolTipText("");
		passportTF.setColumns(10);
		passportTF.setBounds(497, 249, 266, 20);
		contentPaneU.add(passportTF);
		
		JLabel passporthelp = new JLabel("(9 digit without -)");
		passporthelp.setBounds(497, 280, 161, 14);
		contentPaneU.add(passporthelp);
		
		JLabel msg9 = new JLabel("");
		msg9.setForeground(Color.RED);
		msg9.setFont(new Font("Tahoma", Font.BOLD, 11));
		msg9.setBounds(828, 252, 310, 14);
		contentPaneU.add(msg9);
		
		JCheckBox understandCB = new JCheckBox("I Understand all the terms and conditions");
		understandCB.setBackground(Color.ORANGE);
		understandCB.setBounds(301, 546, 271, 23);
		contentPaneU.add(understandCB);
		
		JLabel UserL = new JLabel("USERNAME: ");
		UserL.setFont(new Font("Tahoma", Font.BOLD, 11));
		UserL.setBounds(301, 143, 123, 14);
		contentPaneU.add(UserL);
		
		usernameTF = new JTextField();
		usernameTF.setColumns(10);
		usernameTF.setBounds(497, 143, 266, 20);
		contentPaneU.add(usernameTF);
						
		JButton SignupB = new JButton("SIGNUP");
		SignupB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean nameformat;
				boolean namelength;
				boolean useravailable;
				boolean cniclength;
				boolean cnicavailable;
				boolean passportlength;
				boolean passportformat;
				boolean cnicformat;
				boolean gendercheck = false;
				boolean agecheck = false;
				boolean passlength;
				boolean passformat;
				boolean passMatch;
				String gender = null;
				int age = 0;
				String name = null;
				String pass = null;
				String userName = null;
				String cnic = null;
				String passport=null;
				
				if(understandCB.isSelected()) {
			
					namelength=Formats.Namelength(nameTF.getText());
					nameformat=Formats.NameFormatFun(nameTF.getText());
					useravailable=Formats.usernameAvailable(u, usernameTF.getText());
					cniclength=Formats.cniclength(cnicTF.getText());
					cnicformat=Formats.cnicFormat(cnicTF.getText());
					cnicavailable=Formats.cnicavailable(u, cnicTF.getText());
					passportlength=Formats.Passportlength(passportTF.getText());
					passportformat=Formats.passportFormat(passportTF.getText());
					passlength=Formats.Passwordlength(passwordTF.getText());
					passformat=Formats.PasswordFormat(passwordTF.getText());
					passMatch=Formats.Passwordmatch(passwordTF.getText(), conPassTF.getText());
					
					if(!namelength) {
						msg1.setText("Name must be less than 37 characters");
					}
					else if(!nameformat){
						msg1.setText("Name must not contain special characters or numbers");	
					}
					else {
						msg1.setText(" ");	
					}
					
					
					if(!useravailable) {
						msg2.setText("Account already exists on this username");
					}
					else if(useravailable) {
						userName=usernameTF.getText();
						msg2.setText(" ");	
					}
				
					
					if(cnicTF.getText().isEmpty()) {
						msg3.setText(" ");
					}
					else if(!cniclength) {
						msg3.setText("CNIC must be of 13 digit");
					}
					else if(!cnicformat){
						msg3.setText("CNIC must contain number only");	
					}
					else if(!cnicavailable){
						msg3.setText("Account already exists on this cnic");	
					}
					else {
						msg3.setText(" ");	
					}
					
					if(!passportlength) {
						msg9.setText("Passport number must be of 9 digit");
					}
					else if(!passportformat){
						msg9.setText("Passport must contain number only");	
					}
					else {
						msg9.setText(" ");	
					}
					
					if(ageCB.getSelectedItem().equals("-") ) {
						msg8.setText("select age plz");
					}
					else {
						agecheck=true;
						String a=(String) ageCB.getSelectedItem();
						age=Integer.parseInt(a);
						msg8.setText(" ");
					}
					
					
					if(maleB.isSelected()) {
						gender="M";
						gendercheck=true;
					}
					else if(femaleB.isSelected()) {
						gender="F";
						gendercheck=true;
					}
					else if(customB.isSelected()) {
						gender=customB.getText();
						gendercheck=true;
					}
					
					if(!gendercheck) {
						msg4.setText("Please select your Gender");		
					}
					else {
						msg4.setText(" ");		
					}
					
					
					if(!passlength) {
						msg5.setText("please enter minimum 8 character");
					}
					else if(!passformat){
						msg5.setText("password should contain atleast 1 capital,small letter, number and special character ");	
					}
					else {
						msg5.setText(" ");	
					}
					
					if(!passMatch) {
						msg6.setText("Password Doesn't Match");	
					}
					else {
						msg6.setText(" ");	
					}
					
					
					if(namelength && nameformat) {
						name=nameTF.getText();
					}
					
					if(passMatch && passformat && passlength) {
						pass=passwordTF.getText();
					}
					
					if(cniclength && cnicformat && cnicavailable) {
						cnic=cnicTF.getText();
					}
					
					if(passportlength && passportformat) {
						passport=passportTF.getText();
					}

					if(namelength && nameformat && passlength && passformat && passMatch && cniclength && cnicformat && cnicavailable && gendercheck && agecheck && useravailable && passportlength && passportformat) {
						User temp =new User(userid,name,userName,cnic,gender,age,pass,passport);
						userid++;
						u.add(temp);
						SuccessfulSignupBox ssb=new SuccessfulSignupBox();
						ssb.setVisible(true);
						dispose();
					}
					
				}
				else {
					msg7.setText("Check the box to continue");
				}
			}
		});
		SignupB.setBounds(499, 604, 138, 23);
		contentPaneU.add(SignupB);
		
		JButton MainB = new JButton("Main Menu");
		MainB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainMenu m=new MainMenu();
				m.setVisible(true);
				dispose();
			}
		});
		MainB.setBounds(497, 669, 140, 23);
		contentPaneU.add(MainB);
		
		JButton instruction = new JButton("?");
		instruction.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PassportInstruction pi=new PassportInstruction();
				pi.setVisible(true);
			}
		});
		instruction.setBounds(773, 248, 45, 23);
		contentPaneU.add(instruction);
		
	}
	
	static public void  addsomeUsers() {
		User u1=new User(userid,"Huzaifa","ranahuzaifa","3650247203719","Male",21,"Huzaif@111","090078601");userid++;
		User u2=new User(userid,"Umar","byumar","1234567890123","Male",22,"Carbon12>","121212121");userid++;
		User u3=new User(userid,"Wajahat","iamwajahat","9876543210876","Male",20,"Xylafer1<","555666777");userid++;
		User u4=new User(userid,"Moiz","mueezism","1112223334445","Male",19,"Imaan*1","123456789");userid++;
		
		u.add(u1);
		u.add(u2);
		u.add(u3);
		u.add(u4);
	}
}
