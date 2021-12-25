package buisnessLayer;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import application.Main;
import services.PersistanceFactory;
import services.PersistanceHandler;
import services.persistanceMethod;

@Entity
@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cust_id")
	private int id;
	
	@Column(name="cnic")
	private String cnic;
	
	@Column(name="name")
	private String name;
	
	@Column(name="address")
	private String address;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone")
	private String phone;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "customer", fetch = FetchType.LAZY)
		private Defaulter defaulter;
	

	@OneToMany(cascade = CascadeType.ALL)
	 List<Reservation> reservations= new ArrayList<Reservation>();
	
	
	
	public Customer() {
		
	}
	
	




	public String getCnic() {
		return cnic;
	}

	public void saveCustomer() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		PersistanceFactory pf= PersistanceFactory.getInstance();
		PersistanceHandler ph=pf.createPersistanceHandler(persistanceMethod.persistane);
		
		ph.saveCustomer(this);
	}


	public void setCnic(String cnic) {
		this.cnic = cnic;
	}



	public Customer(String name, String address, String email, String phone) {
		this.name = name;
		this.address = address;
		this.email = email;
		this.phone = phone;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	public Defaulter getDefaulter() {
		return defaulter;
	}

	public void setDefaulter(Defaulter defaulter) {
		this.defaulter = defaulter;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	

}
