package buisnessLayer;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import application.Main;
import services.PersistanceFactory;
import services.PersistanceHandler;
import services.persistanceMethod;


@Entity
@Table(name="hotelstay")
public class HotelStay {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	int id;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "res_id")
	private Reservation res;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "hstay", fetch = FetchType.LAZY , orphanRemoval = true)
	private CheckIn cin;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "hstay", fetch = FetchType.LAZY , orphanRemoval = true)
	private CheckOut cout;
	
	
	
	
	public void enterClearanceDetails(Reservation reservationId) {
		
	}
	
	
	public Reservation getRes() {
		return res;
	}


	public void setRes(Reservation res) {
		this.res = res;
	}


	public CheckIn getCin() {
		return cin;
	}


	public void setCin(CheckIn cin) {
		this.cin = cin;
	}


	public CheckOut getCout() {
		return cout;
	}


	public void setCout(CheckOut cout) {
		this.cout = cout;
	}


	public void EndCheckIn() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
	
		//save();
	}
	public void save() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		PersistanceFactory pf= PersistanceFactory.getInstance();
		PersistanceHandler ph=pf.createPersistanceHandler(persistanceMethod.persistane);
		
		ph.saveHotelStay(this);
	}
	public void makePayment(float amount) {
		
	}
	
	public CheckIn createCheckIn(LocalDate datetime,Reservation reservationid) {
		this.res=reservationid;
		cin=new CheckIn();
		cin.enterCheckIn(datetime, reservationid);
		
		return cin;
		
		
	}
	
	public CheckOut createCheckOut(LocalDate datetime,Reservation reservationid) {
		cout=new CheckOut();
		cout.enterCheckOut(datetime, reservationid);
		
		return cout;
		
		
	}
}
