package services;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import buisnessLayer.Customer;
import buisnessLayer.Defaulter;
import buisnessLayer.HotelStay;
import buisnessLayer.Login;
import buisnessLayer.Payment;
import buisnessLayer.Reservation;
import buisnessLayer.Room;
import buisnessLayer.RoomDescription;
import buisnessLayer.Staff;
import buisnessLayer.cancelledReservation;
public class FileHandler extends PersistanceHandler {
	
	public void saveRoom(Room roomid) {
		try {
		      FileWriter myWriterfile = new FileWriter("Roomrecord.txt", true);
		      myWriterfile.write("\n"+roomid.getRoomId()+", "+ roomid.getFloor()+", "+ roomid.getRoomRent()+ ", "+ roomid.getRoomStatus()+ ", "+ roomid.getType()+"\n");
		
		      System.out.println("Successfully wrote to the file.");
		    } 
		catch (IOException e) {
		      System.out.println("An error occurred.");
		      System.out.println(e.getMessage());
		     
		
		}
	}
	
	public void saveReservation(Reservation r) {
		try {
	      FileWriter myWriterfile = new FileWriter("Reservationrecord.txt", true);
	      myWriterfile.write("\n"+r.getReservationId()+", "+ r.getNoOfguests()+", "+ r.getArrivaldate()+ ", "+ r.getDeparturedate()+ ", "+ r.getStatus()+"\n");
	
	      System.out.println("Successfully wrote to the file.");
	    } 
	catch (IOException e) {
	      System.out.println("An error occurred.");
	      System.out.println(e.getMessage());
	     
	
	}
	}

/*
	public void saveRoom(Room roomid) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			
			session.save(roomid);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public void savePayment(Payment p) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			
			session.save(p);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		
	}
	public void saveorupdateRoom(Room roomid) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			
			session.saveOrUpdate(roomid);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public void saveRoomDesc(RoomDescription roomdescid) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

		
			session.save(roomdescid);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public void updateRoom(Room r) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			
			session.merge(r);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public Room getRoom(int id) {

		Transaction transaction = null;
		Room roomid = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an course object
			roomid = session.get(Room.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return roomid;
	}

	public RoomDescription getRoomdesc(int id) {

		Transaction transaction = null;
		RoomDescription roomdescid = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an instructor object
			roomdescid = session.get(RoomDescription.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return roomdescid;
	}

	public List<RoomDescription> loadAllRoomDesc() {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			return session.createQuery("from RoomDescription", RoomDescription.class).list();
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}

	public List<Room> loadAllRoom() {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			return session.createQuery("from Room", Room.class).list();
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}

	public List<Staff> getstaff() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from Staff", Staff.class).list();
		}
	}

	public void saveReservation(Reservation r) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// save the student object
			session.merge(r);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Exception e: " + e.getMessage());
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public void saveHotelStay(HotelStay hstay) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			
			session.merge(hstay);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Exception e: " + e.getMessage());
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

	}

	public void saveCustomer(Customer r) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// save the student object
			session.merge(r);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Exception e: " + e.getMessage());
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public void saveCancellation(cancelledReservation r) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// save the student object
			session.merge(r);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Exception e: " + e.getMessage());
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public void updateReservation(Reservation r) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// save the student object
			session.merge(r);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Exception e: " + e.getMessage());
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public List<Reservation> loadAllReservation() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from Reservation", Reservation.class).list();
		}
	}

	public List<Reservation> loadAllAvailableReservation() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session
					.createQuery("from Reservation where arrivalDate>now() OR departureDate<now()", Reservation.class)
					.list();
		}
	}

	public void saveStaff(Staff staffid) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(staffid);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

	}

	public void saveLogin(Login loginid) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(loginid);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

	}

	public void updateRoomDesc(RoomDescription roomdesc) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.merge(roomdesc);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			System.out.print("Exception: " + e);
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public Reservation getReservation(int id) {

		Transaction transaction = null;
		Reservation r = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			r = session.get(Reservation.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return r;
	}

	public Login verifyLogin(String email, String password) {
		Transaction transaction = null;
		Login login = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// get an student object
			String hql = " FROM Login L WHERE L.email = :email AND L.password = : password";
			Query query = session.createQuery(hql);
			query.setParameter("email", email);
			query.setParameter("password", password);
			List<Login> results = query.getResultList();

			if (results != null && !results.isEmpty()) {
				login = (Login) results.get(0);
			}

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			System.out.print("Exception: " + e);
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return login;
	}

	public List<Defaulter> loadAllDefaulters() {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			return session.createQuery("from Defaulter", Defaulter.class).list();
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}*/

}
