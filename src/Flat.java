import java.util.Set;
public class Flat{
	private int id;
	private String number;
	private Set<Owner> owners;
	private Set<Image> images;
	private Set<Video> videos;
	
	public Flat(){}
	public Flat(String number, Set<Owner> owners, Set<Image> images, Set<Video> videos) {
		this.number = number;
		this.owners = owners;
		this.images = images;
		this.videos = videos;
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

	public Set<Owner> getOwners() {
		return owners;
	}
	public void setOwners(Set<Owner> owners) {
		this.owners = owners;
	}
	
	public Set<Image> getImages() {
		return images;
	}

	public void setImages(Set<Image> images) {
		this.images = images;
	}
	
	public Set<Video> getVideos() {
		return videos;
	}

	public void setVideos(Set<Video> videos) {
		this.videos = videos;
	}

}