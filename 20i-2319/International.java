
public class International extends Flights{

	private String Country;
	private String indirectRouteCountry;
	private boolean isIndierct;
	
	public International(int srNo,String airport, String northSouth, double distance, int time_Hours, String fdate,
			String ftime,String atime ,int seat_economy, int seat_bussiness, String country, boolean isItindirect, String route) {
		super(srNo,airport, northSouth, distance, time_Hours, fdate, ftime, atime,seat_economy, seat_bussiness);
		this.Country=country;
		this.setIndierct(isItindirect);
		this.setIndirectRouteCountry(route);
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getIndirectRouteCountry() {
		return indirectRouteCountry;
	}

	public void setIndirectRouteCountry(String indirectRouteCountry) {
		this.indirectRouteCountry = indirectRouteCountry;
	}

	public boolean isIndierct() {
		return isIndierct;
	}

	public void setIndierct(boolean isIndierct) {
		this.isIndierct = isIndierct;
	}


	
	
	
	


	
	
	
}
