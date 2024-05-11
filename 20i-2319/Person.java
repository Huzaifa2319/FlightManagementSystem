
public class Person {

	protected int id;
	protected String Name;
	protected String CNIC;
	protected int age;
	protected String Gender;
	protected String userName;
	protected String password;
	protected boolean login_status=false;
	 
	
	 public Person(){

	 }


	public Person(int id, String name,String userName ,String cNIC,String gender ,int age, String password) {
		this.id = id;
		Name = name;
		CNIC = cNIC;
		this.age = age;
		Gender = gender;
		this.userName = userName;
		this.password = password;
		this.login_status = false;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getCNIC() {
		return CNIC;
	}


	public void setCNIC(String cNIC) {
		CNIC = cNIC;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getGender() {
		return Gender;
	}


	public void setGender(String gender) {
		Gender = gender;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isLogin_status() {
		return login_status;
	}


	public void setLogin_status(boolean login_status) {
		this.login_status = login_status;
	}
	
	
}
