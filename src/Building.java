import java.util.Set;
public class Building{
	private int id;
	private String number;
	private String address;
	private Set<Flat> flats;
	
	public Building(){}
	public Building(String number, String address, Set<Flat> flats) {
		this.number = number;
		this.address = address;
		this.flats = flats;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Set<Flat> getFlats() {
		return flats;
	}
	public void setFlats(Set<Flat> flats) {
		this.flats = flats;
	}

}