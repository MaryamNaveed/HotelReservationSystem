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



@Entity
@Table(name="checkIn")
public class CheckIn {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	int id;
	
	@Column(name="date")
	LocalDate date;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "p_id")
	Payment p;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "stay_id")
	private HotelStay hstay;
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "res_id")
	Reservation resId;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	public void makePaymentmethod(String method) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		paymentFactory pf=new paymentFactory();
		p=pf.createPaymentHandler(method);
	}

	public Payment getP() {
		return p;
	}

	public void setP(Payment p) {
		this.p = p;
	}

	public Reservation getResId() {
		return resId;
	}

	public void setResId(Reservation resId) {
		this.resId = resId;
	}

	public void enterCheckIn(LocalDate datetime, Reservation resId){
		this.resId=resId;
		this.date=datetime;
	}

	public float getTotal() {
		return resId.getAmount();
		
	}

	public void createPayment(float amount) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		p.createPayment(amount);
	}
}
