package buisnessLayer;

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
@Table(name="login")
public class Login {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="email", unique=true)
	private String email;
	
	@Column(name="password")
	private String password;
	
	

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "staff_id")
	private Staff staff;
	
	
	
	public Login() {
		
	}
	public Login(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public boolean verifylogin(String email, String password) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		PersistanceFactory pf= PersistanceFactory.getInstance();
		PersistanceHandler ph=pf.createPersistanceHandler(persistanceMethod.persistane);
		
		if(ph.verifyLogin(email,password)!=null){
			return true;
		}
		return false;
	}
	
	public void save() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		PersistanceFactory pf= PersistanceFactory.getInstance();
		PersistanceHandler ph=pf.createPersistanceHandler(persistanceMethod.persistane);
		
		ph.saveLogin(this);
		
	}
	
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
