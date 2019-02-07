public class Owner {
	private int id;
	private String name;
	private String mobileNumber;
	private String address;
	
	public Owner(){}
	
	public Owner(String name, String mobileNumber, String address) {
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


}