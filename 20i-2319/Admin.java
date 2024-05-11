
public class Admin extends Person{

	public Admin() {
		 id=2319;
		 Name="admin";
		 age=21;
		 Gender="Male";
		 userName="admin";
		 password="admin";
		 login_status=false;
	}
	
	public Admin(int id,String name,int age,String user,String pass) {
		this.id=id;
		this.Name=name;
		this.age=age;
		this.userName=user;
		this.password=pass;
		login_status=false;
	}
	

	static FlightReservationMenu FM=new FlightReservationMenu();
	
	public void addLocal(String airport, String northSouth, double distance, int time_Hours, String fdate, String ftime,String atime,
			int seat_economy, int seat_bussiness, String city) {
		
		Local lflight=new Local(FM.localSerialNo,airport,northSouth,distance,time_Hours,fdate,ftime,atime,seat_economy,seat_bussiness,city);
		FM.localFlights.add(lflight);
		FM.localSerialNo++;
	}
	
	public void addInternational(String airport, String northSouth, double distance, int time_Hours, String fdate,
			String ftime,String atime,int seat_economy, int seat_bussiness, String country,boolean isitIndirect,String route) {
		
		International iflight=new International(FM.InterSerialNo ,airport, northSouth, distance, time_Hours, fdate,ftime,atime,seat_economy,seat_bussiness,country,isitIndirect,route);
		FM.interFlights.add(iflight);
		FM.InterSerialNo++;
	}
	
	public void removelocal(int serialno,int id) {
		for(int i=0;i<FM.localFlights.size();i++) {
			if(FM.localFlights.get(i).getId()==id) {
				FM.localFlights.remove(i);
			}
		}
		
		for(int j=serialno;j<FM.localFlights.size();j++) {
			FM.localFlights.get(j).setSerialNo(j);;
		}
		
		FM.localSerialNo--;
	}
	
	public void removeinternational(int serialno,int id) {
		for(int i=0;i<FM.interFlights.size();i++) {
			if(FM.interFlights.get(i).getId()==id) {
				FM.interFlights.remove(i);
			}
		}
		
		for(int j=serialno;j<FM.interFlights.size();j++) {
			FM.interFlights.get(j-1).setSerialNo(j);;
		}
		
		FM.InterSerialNo--;
	}
	
	public void blocklocalflight(int id) {
		for(int i=0;i<FM.localFlights.size();i++) {
			if(FM.localFlights.get(i).getId()==id) {
				FM.localFlights.get(i).setOpen(false);;
			}
		}
	}
	
	public void blockinterflight(int id) {
		for(int i=0;i<FM.interFlights.size();i++) {
			if(FM.interFlights.get(i).getId()==id) {
				FM.interFlights.get(i).setOpen(false);
			}
		}
	}
	
	public void openlocalflight(int id) {
		for(int i=0;i<FM.localFlights.size();i++) {
			if(FM.localFlights.get(i).getId()==id) {
				FM.localFlights.get(i).setOpen(true);;
			}
		}
	}
	
	public void openinterflight(int id) {
		for(int i=0;i<FM.interFlights.size();i++) {
			if(FM.interFlights.get(i).getId()==id) {
				FM.interFlights.get(i).setOpen(true);
			}
		}
	}

	 static void loc() {
		Local l1=new Local(FM.localSerialNo,"Lahore","North",300,2,"20 / 12 / 2021","3:20 am","5:20 am",40,20,"Islamabad");FM.localSerialNo++;
		Local l2=new Local(FM.localSerialNo,"Lahore","South",700,4,"21 / 12 / 2021","1:30 am","5:30 am",20,20,"Karachi");FM.localSerialNo++;
		Local l3=new Local(FM.localSerialNo,"Karachi","South",700,4,"22 / 12 / 2021","12:00 am","4:00 am",30,30,"Lahore");FM.localSerialNo++;
		Local l4=new Local(FM.localSerialNo,"Peshawar","North",300,2,"23 / 12 / 2021","3:20 am","5:20 am",30,20,"Quetta");FM.localSerialNo++;
		Local l5=new Local(FM.localSerialNo,"Quetta","South",300,2,"24 / 12 / 2021","8:50 pm","10:50 pm",40,20,"Karachi");FM.localSerialNo++;
		Local l6=new Local(FM.localSerialNo,"Islamabad","North",900,5,"25 / 12 / 2021","7:20 pm","11:20 pm",40,20,"Karachi");FM.localSerialNo++;
	
		FM.localFlights.add(l1);
		FM.localFlights.add(l2);
		FM.localFlights.add(l3);
		FM.localFlights.add(l4);
		FM.localFlights.add(l5);
		FM.localFlights.add(l6);
	}
	
	 static void inter() {
		 International i1 =new International(FM.InterSerialNo,"Islamabad","South",2000,3,"20 / 12 / 2021","3:20 am","6:20 am",30,20,"India",false,null);FM.InterSerialNo++;
		 International i2 =new International(FM.InterSerialNo,"Karachi","South",3000,4,"23 / 12 / 2021","8:50 pm","12:50 am",40,20,"China",false,null);FM.InterSerialNo++;
		 International i3 =new International(FM.InterSerialNo,"Lahore","North",4000,6,"21 / 12 / 2021","1:30 am","7:30 am",30,20,"Dubai",true,"UAE");FM.InterSerialNo++;
		 International i4 =new International(FM.InterSerialNo,"Peshawar","North",1500,3,"22 / 12 / 2021","12:00 am","3:00 am",30,20,"Turkey",true,"China");FM.InterSerialNo++;
		 International i5 =new International(FM.InterSerialNo,"Quetta","South",3000,5,"24 / 12 / 2021","8:10 pm","1:10 am",30,20,"India",false,null);FM.InterSerialNo++;
		 International i6 =new International(FM.InterSerialNo,"Islamabad","South",1000,1,"25 / 12 / 2021","7:20 pm","8:20 pm",30,20,"Oman",true,"Turkey");FM.InterSerialNo++;

		 FM.interFlights.add(i1);
		 FM.interFlights.add(i2);
		 FM.interFlights.add(i3);
		 FM.interFlights.add(i4);
		 FM.interFlights.add(i5);
		 FM.interFlights.add(i6);
	 }
	
	
}
