import java.util.*;

public class Flights {
	
	protected int SerialNo;
	protected int id;
	protected String Airport;
	protected String NorthSouth;
	protected double distance;
	protected int time_Hours;
	protected String fdate;
	protected String ftime;
	protected String arrivalTime;
	protected int seat_economy;
	protected int seat_bussiness;
	protected boolean isOpen;
	
	public Flights(int srNo,String airport, String northSouth, double distance, int time_Hours, String fdate,
			String ftime, String atime ,int seat_economy, int seat_bussiness) {
		this.SerialNo=srNo;
		this.id=random();
		this.Airport = airport;
		this.NorthSouth = northSouth;
		this.distance = distance;
		this.time_Hours = time_Hours;
		this.fdate = fdate;
		this.ftime = ftime;
		this.arrivalTime=atime;
		this.seat_economy = seat_economy;
		this.seat_bussiness = seat_bussiness;
		this.isOpen = true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAirport() {
		return Airport;
	}

	public void setAirport(String airport) {
		Airport = airport;
	}

	public String getNorthSouth() {
		return NorthSouth;
	}

	public void setNorthSouth(String northSouth) {
		NorthSouth = northSouth;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public int getTime_Hours() {
		return time_Hours;
	}

	public void setTime_Hours(int time_Hours) {
		this.time_Hours = time_Hours;
	}

	public String getFdate() {
		return fdate;
	}

	public void setFdate(String fdate) {
		this.fdate = fdate;
	}

	public String getFtime() {
		return ftime;
	}

	public void setFtime(String ftime) {
		this.ftime = ftime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getSeat_economy() {
		return seat_economy;
	}

	public void setSeat_economy(int seat_economy) {
		this.seat_economy = seat_economy;
	}

	public int getSeat_bussiness() {
		return seat_bussiness;
	}

	public void setSeat_bussiness(int seat_bussiness) {
		this.seat_bussiness = seat_bussiness;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public int getSerialNo() {
		return SerialNo;
	}

	public void setSerialNo(int serialNo) {
		SerialNo = serialNo;
	}
	
	
	public int random() {
		Random random=new Random();
		int num=random.nextInt(2000)+1000;
		return num;
	}
	
	
}







