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


@Entity
@Table(name="checkout")
public class CheckOut {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	int id;
	LocalDate date;
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "stay_id")
	private HotelStay hstay;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "p_id")
	Payment p;

	public void enterCheckIn(Date datetime){
		
	}
	
	public void enterCheckOut(LocalDate datetime, Reservation resId){
		//this.resId=resId;
		this.date=datetime;
	}

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


	public float getTotal() {
		return 0;
		
	}
	
	public void makePaymentmethod(String method) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		paymentFactory pf=new paymentFactory();
		p=pf.createPaymentHandler(method);
	}

	public void createPayment(float amount) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		p.createPayment(amount);
	}
}
