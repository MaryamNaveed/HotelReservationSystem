package buisnessLayer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import application.Main;
import services.PersistanceFactory;
import services.PersistanceHandler;
import services.persistanceMethod;



@Entity
@Table(name="reservation")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int reservationId;
	
	@Column(name="arrivalDate")
	private LocalDate arrivaldate;
	@Column(name="departureDate")
	private LocalDate departuredate;
	
	@Column(name="nGuests")
	private int noOfguests;
	
	@Column(name="Status")
	private String Status;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "reservation", fetch = FetchType.LAZY , orphanRemoval = true)
	private cancelledReservation cres;
	
	@Column(name="amount")
	private float amount;
	

	
	//private Customer cust;
	
	@ManyToMany(cascade = { CascadeType.ALL },  fetch = FetchType.EAGER)
	@JoinTable(
	        name = "Reservation_Room", 
	        joinColumns = { @JoinColumn(referencedColumnName = "id") }, 
	        inverseJoinColumns = { @JoinColumn(referencedColumnName = "id") }
	    )
	List<Room> reservedRooms= new ArrayList<Room>();
	
	public Reservation create() {
		return this;
		
	}
	
	
	
	public int getReservationId() {
		return reservationId;
	}



	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}



	/*public Customer getCust() {
		return cust;
	}



	public void setCust(Customer cust) {
		this.cust = cust;
	}*/



	public LocalDate getArrivaldate() {
		return arrivaldate;
	}



	public void setArrivaldate(LocalDate arrivaldate) {
		this.arrivaldate = arrivaldate;
	}



	public LocalDate getDeparturedate() {
		return departuredate;
	}



	public void setDeparturedate(LocalDate departuredate) {
		this.departuredate = departuredate;
	}



	public int getNoOfguests() {
		return noOfguests;
	}



	public void setNoOfguests(int noOfguests) {
		this.noOfguests = noOfguests;
	}



	public String getStatus() {
		return Status;
	}



	public void setStatus(String status) {
		Status = status;
	}



	public List<Room> getReservedRooms() {
		return reservedRooms;
	}



	public void setReservedRooms(List<Room> reservedRooms) {
		this.reservedRooms = reservedRooms;
	}



	public void cancelReservation(String reason, LocalDate date) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		cres=new cancelledReservation();
		cres.cancelReservation(this, reason, date);
		this.Status="Cancelled";
		
		update();
		
	}
	
	
	
	
	public float getAmount() {
		return amount;
	}



	public void setAmount(float amount) {
		this.amount = amount;
	}



	public void update() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		PersistanceFactory pf= PersistanceFactory.getInstance();
		PersistanceHandler ph=pf.createPersistanceHandler(persistanceMethod.persistane);
		
		
		
		ph.updateReservation(this);
	}
	
	
	public List<Reservation> populate() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		PersistanceFactory pf= PersistanceFactory.getInstance();
		PersistanceHandler ph=pf.createPersistanceHandler(persistanceMethod.persistane);
		
		
		
		return ph.loadAllReservation();
		
		
	}
	

	public void save() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		PersistanceFactory pf= PersistanceFactory.getInstance();
		PersistanceHandler ph=pf.createPersistanceHandler(persistanceMethod.persistane);
		
		ph.saveReservation(this);
	}	
	
	
	public Reservation verifyReservation(int resid) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		PersistanceFactory pf= PersistanceFactory.getInstance();
		PersistanceHandler ph=pf.createPersistanceHandler(persistanceMethod.persistane);
		
		Reservation r= ph.getReservation(resid);
		

		
		if(r==null || r.Status.equalsIgnoreCase("cancelled") || r.Status.equalsIgnoreCase("checkout")) {
			System.out.println("cancelledd");
			return null;
		}
		return r;
		
	}
	
	public float addRoomItem(List<Room> roomId, int nrooms) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
	
		
		for(int i=0; i<roomId.size() && i<nrooms; i++) {
			roomId.get(i).reservation.add(this);
			roomId.get(i).update();
			reservedRooms.add(roomId.get(i));
			amount+=roomId.get(i).getRoomRent();
		}
		
		return amount;
		
	}
	
	

}
