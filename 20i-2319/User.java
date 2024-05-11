import java.util.ArrayList;

public class User extends Person{

	
	private boolean visa=false;
	private String passport_no;
	private double balance;
	final ArrayList <localBooking> Localbooked; 
	final ArrayList <interBooking> Interbooked; 
	
		public User(int id, String name, String userName, String cNIC, String gender, int age, String password,String passport) {
		super(id, name, userName, cNIC, gender, age, password);
		this.passport_no=passport;
		this.setBalance(1000000);
		Localbooked=new ArrayList<>();
		Interbooked=new ArrayList<>();
		}



		public boolean isVisa() {
			return visa;
		}


		public void setVisa(boolean visa) {
			this.visa = visa;
		}


		public String getPassport_no() {
			return passport_no;
		}


		public void setPassport_no(String passport_no) {
			this.passport_no = passport_no;
		}


		public double getBalance() {
			return balance;
		}


		public void setBalance(double balance) {
			this.balance = balance;
		}
		
	
		public void Book_Local(Local flight ,int bseats,int eseats) {
			localBooking lb=new localBooking(flight,bseats,eseats);
			lb.cost=lb.calculateCost();
			lb.GovtTAX=lb.calculateTax();
			lb.ammountToPay=lb.TotalBill();;
			Localbooked.add(lb);
			
			balance=balance-lb.ammountToPay;
		}
	
		public void Book_Inter(International flight ,int bseats,int eseats) {
			interBooking ib=new interBooking(flight,bseats,eseats);
			ib.cost=ib.calculateCost();
			ib.GovtTAX=ib.calculateTax();
			ib.ammountToPay=ib.TotalBill();;
			Interbooked.add(ib);
			
			balance=balance-ib.ammountToPay;
		}
	
		
		public boolean cancelLocal(int id) {
			for(int i=0;i<Localbooked.size();i++) {
				if(Localbooked.get(i).booking_id==id) {
					if(Localbooked.get(i).isCancelled==false) {
					Localbooked.get(i).isCancelled=true;
					double refund=Localbooked.get(i).ammountToPay*75/100;
					balance=balance+refund;
					return true;
					}
				}
			}
			return false;
		}
		
		public boolean cancelinter(int id) {
			for(int i=0;i<Interbooked.size();i++) {
				if(Interbooked.get(i).booking_id==id) {
					if(Interbooked.get(i).isCancelled==false) {
					Interbooked.get(i).isCancelled=true;
					double refund=Interbooked.get(i).ammountToPay*75/100;
					balance=balance+refund;
					return true;
				}
			}
		}
			return false;
	}
		
		
		
}
