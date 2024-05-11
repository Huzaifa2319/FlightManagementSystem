
public class Local extends Flights{

	private String City;
	
	public Local(int srNo,String airport, String northSouth, double distance, int time_Hours, String fdate, String ftime,
			String atime,int seat_economy, int seat_bussiness, String city) {
		super(srNo, airport, northSouth, distance, time_Hours, fdate, ftime, atime,seat_economy, seat_bussiness);
		this.City=city;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	
}

