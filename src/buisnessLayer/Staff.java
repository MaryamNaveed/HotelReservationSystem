package buisnessLayer;

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
@Table(name="staff")
public class Staff {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	

	@Column(name="name")
	private String name;
	
	@Column(name="address")
	private String address;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "staff", fetch = FetchType.LAZY)
	private Login loginInfo;
	
	@Column(name="phone")
	private String phone;
	
	
	public Login getLoginInfo() {
		return loginInfo;
	}
	public void setLoginInfo(Login loginInfo) {
		this.loginInfo = loginInfo;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void save() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		PersistanceFactory pf= PersistanceFactory.getInstance();
		PersistanceHandler ph=pf.createPersistanceHandler(persistanceMethod.persistane);
		
		ph.saveStaff(this);
		
	}
	public void createStaff() {
		this.loginInfo.setStaff(this);
	}
	
	public boolean verifylogin(String email, String password) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Login login=new Login();
		return login.verifylogin(email, password);
	}
	
	public Staff(String name, String address, Login loginInfo, String phone) {
		this.name = name;
		this.address = address;
		this.loginInfo = loginInfo;
		this.phone = phone;
	}
	public Staff() {
	
	}
	
	

}
