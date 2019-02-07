import java.util.List;
import java.util.Set;
import java.util.HashSet;
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Manage {
	private static SessionFactory factory; 
	public static void main(String[] args) {

		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) { 
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex); 
		}

		Manage ME = new Manage();
		ME.addBuilding();
		ME.listBuilding();
	}

	public Integer addBuilding(){
		Session session = factory.openSession();
		Transaction tx = null;
		Integer flatID = null;

		try {
			tx = session.beginTransaction();
			Set<Image> images = new HashSet<Image>(); 
			images.add(new Image("image_url1"));
			images.add(new Image("image_url2"));
			images.add(new Image("image_url3"));
			Set<Video> videos = new HashSet<Video>(); 
			videos.add(new Video("video_url1"));
			videos.add(new Video("video_url2"));
			videos.add(new Video("video_url3"));
			Set<Owner> owners = new HashSet<Owner>();
			owners.add(new Owner("Sumon", "01714366349", "Mirpur Dhaka"));
			owners.add(new Owner("Emon", "01714351709", "43/1 vooter goli"));
			Set<Flat> flats = new HashSet<Flat>();
			flats.add(new Flat("1",owners, images, videos));
			Building building = new Building("43/A", "Mirpur", flats);
			flatID = (Integer) session.save(building); 
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
		return flatID;
	}

	public void listBuilding(){
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<Flat> flats = session.createQuery("FROM Flat").list(); 
			for (Flat flat : flats) {
				System.out.println("=========================Flat=====================");
				System.out.println("Flat number: " + flat.getNumber());
				Set<Owner> owners = flat.getOwners();
				
				for (Owner owner : owners) {
					System.out.println("Flat Onwner Name: " + owner.getName());
					System.out.println("Flat Onwner Phone Number: " + owner.getMobileNumber());
					System.out.println("Flat Onwner Address: " + owner.getAddress());
				}
				
				Set<Image> images = flat.getImages();
				for (Image image : images) {
					System.out.println("Flat image url : " + image.getUrl());
				}
				
				Set<Video> videos = flat.getVideos();
				for (Video video : videos) {
					System.out.println("Flat Video url : " + video.getUrl());
				}
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
	}

	/* Method to UPDATE salary for an employee */
	//   public void updateEmployee(Integer EmployeeID, int salary ){
	//      Session session = factory.openSession();
	//      Transaction tx = null;
	//      
	//      try {
	//         tx = session.beginTransaction();
	//         Employee employee = (Employee)session.get(Employee.class, EmployeeID); 
	//         employee.setSalary( salary );
	//		 session.update(employee); 
	//         tx.commit();
	//      } catch (HibernateException e) {
	//         if (tx!=null) tx.rollback();
	//         e.printStackTrace(); 
	//      } finally {
	//         session.close(); 
	//      }
	//   }

	/* Method to DELETE an employee from the records */
	//   public void deleteEmployee(Integer EmployeeID){
	//      Session session = factory.openSession();
	//      Transaction tx = null;
	//      
	//      try {
	//         tx = session.beginTransaction();
	//         Employee employee = (Employee)session.get(Employee.class, EmployeeID); 
	//         session.delete(employee); 
	//         tx.commit();
	//      } catch (HibernateException e) {
	//         if (tx!=null) tx.rollback();
	//         e.printStackTrace(); 
	//      } finally {
	//         session.close(); 
	//      }
	//   }
}