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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import application.Main;
import services.PersistanceFactory;
import services.PersistanceHandler;
import services.persistanceMethod;


@Entity
@Table(name="payment")
public class Payment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Pid")
	private int Pid;
	
	@Column(name="amount")
	private float amount;
	
	@Column(name="date")
	private LocalDate date;

	

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "p", fetch = FetchType.LAZY)
	private CheckIn checkin;
	

	
	public float getTotal() {
		return amount;
		
	}
	public void setCardnumber(String c) {
		
		
	}
	public void createPayment(float amount) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		this.amount=amount;
		this.date=LocalDate.now();
		//save();
		
	}
	public void save() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		PersistanceFactory pf= PersistanceFactory.getInstance();
		PersistanceHandler ph=pf.createPersistanceHandler(persistanceMethod.persistane);
		
		ph.savePayment(this);
	}
	
	

}
