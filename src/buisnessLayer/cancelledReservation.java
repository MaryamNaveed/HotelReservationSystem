package buisnessLayer;

import java.time.LocalDate;
import java.util.Date;

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
@Table(name="cancelReservation")
public class cancelledReservation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	
	@Column(name="date")
	private LocalDate date;
	
	@Column(name="reason")
	private String reason;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cancel_id")
	private Reservation reservation;
	
	public void cancelReservation(Reservation resId, String reason, LocalDate date) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		reservation=resId;
		this.reason=reason;
		this.date=date;
		//save();
		
	}
	public void save() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
			PersistanceFactory pf= PersistanceFactory.getInstance();
			PersistanceHandler ph=pf.createPersistanceHandler(persistanceMethod.persistane);
			
			
			
			ph.saveCancellation(this);
		
	}

	public Reservation getRes() {
		return reservation;
	}

	public void setRes(Reservation res) {
		this.reservation = res;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
}
