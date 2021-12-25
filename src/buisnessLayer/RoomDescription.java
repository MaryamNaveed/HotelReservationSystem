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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import application.Main;
import services.PersistanceFactory;
import services.PersistanceHandler;
import services.persistanceMethod;


@Entity
@Table(name="roomdescription")
public class RoomDescription {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int roomdescId;
	
	@Column(name="roomRent")
	private float roomRent;
	
	
	@Column(name="type")
	private String type;
	
	 @OneToMany(cascade = CascadeType.ALL)
	private List<Room> rooms= new ArrayList<Room>();
	 
	 
	 
	
	
	
	public RoomDescription() {
		
	}

	



	public int getRoomdescId() {
		return roomdescId;
	}





	public void setRoomdescId(int roomdescId) {
		this.roomdescId = roomdescId;
	}





	public RoomDescription(float roomRent, String type) {
		this.roomRent = roomRent;
		this.type = type;
	}





	public float getRoomRent() {
		return roomRent;
	}



	public void setRoomRent(float roomRent) {
		this.roomRent = roomRent;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public List<Room> getRooms() {
		return rooms;
	}



	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	
	public void addRoom(Room room) {
		
		this.rooms.add(room);

	}



	

	public ArrayList<Room> searchAvailableRooms(String type) {
		ArrayList<Room> availablerooms= new ArrayList<Room>();
		
		for(int i=0; i<rooms.size(); i++) {
			Room r1=rooms.get(i).isRoomAvailable();
			if(r1!=null)
			availablerooms.add(r1);
		}
		return availablerooms;
		
	}
	public void save() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		PersistanceFactory pf= PersistanceFactory.getInstance();
		PersistanceHandler ph=pf.createPersistanceHandler(persistanceMethod.persistane);
		
		ph.saveRoomDesc(this);
	}
	
	public List<RoomDescription> populate() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		PersistanceFactory pf= PersistanceFactory.getInstance();
		PersistanceHandler ph=pf.createPersistanceHandler(persistanceMethod.persistane);
		
		
		
		return ph.loadAllRoomDesc();
		
		
	}
	
	public void update() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		PersistanceFactory pf= PersistanceFactory.getInstance();
		PersistanceHandler ph=pf.createPersistanceHandler(persistanceMethod.persistane);
		
		
		ph.updateRoomDesc(this);
		
		
	}

}
