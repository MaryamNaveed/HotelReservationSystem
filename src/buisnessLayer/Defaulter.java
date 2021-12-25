package buisnessLayer;

import java.util.List;

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
@Table(name="defaulter")
public class Defaulter {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	
	public Defaulter customerVerification(Customer customerid) {
		if(this.customer.getCnic().equalsIgnoreCase(customerid.getCnic())){
			return this;
		}
		return null;
	}
	public Defaulter() {
	}


	public Defaulter(Customer defaulter1) {
		this.customer = defaulter1;
	}


	public int getId() {
		return id;
	}

	public List<Defaulter> populate() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		PersistanceFactory pf= PersistanceFactory.getInstance();
		PersistanceHandler ph=pf.createPersistanceHandler(persistanceMethod.persistane);
		
		
		
		return ph.loadAllDefaulters();
	}

	public void setId(int id) {
		this.id = id;
	}


	public Customer getDefaulter1() {
		return customer;
	}


	public void setDefaulter1(Customer defaulter1) {
		this.customer = defaulter1;
	}
	
	
}
