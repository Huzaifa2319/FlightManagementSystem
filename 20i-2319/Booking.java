import java.util.Random;

public abstract class Booking {

	protected int booking_id;
	protected int Bseats;
	protected int Eseats;
	protected double cost;
	protected double GovtTAX;
	protected double ammountToPay;
	protected boolean isCancelled;
	
	public Booking(int bseats, int eseats) {
		this.Bseats = bseats;
		this.Eseats=eseats;
		this.booking_id=RandomIdGenerate();
	}
	
	public abstract double calculateCost() ;	//One abstract Method
	public abstract double calculateTax();		//second abstract method
	
	
	public double TotalBill() {
		ammountToPay=calculateCost()+calculateTax();
		return ammountToPay;		
	}
	
	public int RandomIdGenerate() {
		Random rand=new Random();
		int id=rand.nextInt(100)+999;
		return id;
	}
	
	
}

class localBooking extends Booking {

	Local bookflight;
	
	public localBooking( Local bf,int bseats,int eseats) {
		super(bseats, eseats);
		this.bookflight=bf;
	}

	
	public double calculateCost() {
		int bussiness=bookflight.time_Hours*10000*Bseats;
		int economy=bookflight.time_Hours*8000*Eseats;
		cost= bussiness+economy;
		return cost;
	}


	@Override
	public double calculateTax() {
		GovtTAX=cost*5/100;
		return GovtTAX;
	}
	
}

class interBooking extends Booking {
	
	International bookflight;
	
	public interBooking( International bf,int bseats,int eseats) {
		super(bseats, eseats);
		this.bookflight=bf;
	}
	
	public double calculateCost() {
		int bussiness=bookflight.time_Hours*10000*Bseats;
		int economy=bookflight.time_Hours*8000*Eseats;
		cost= bussiness+economy;
		return cost;
	}

	@Override
	public double calculateTax() {
		GovtTAX=cost*10/100;
		return GovtTAX;
	}
	
}



