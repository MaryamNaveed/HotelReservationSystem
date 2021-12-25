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
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import application.Main;
import services.PersistanceFactory;
import services.PersistanceHandler;
import services.persistanceMethod;


@Entity
@Table(name="room")
public class Room {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int roomId;
	
	@Column(name="rooomStatus")
	private String roomStatus;
	
	
	
	@Column(name="floor")
	private String floor;
	
	@Column(name="roomRent")
	private float roomRent;
	
	@Column(name="type")
	private String type;
	
	@ManyToMany(mappedBy = "reservedRooms")
    List<Reservation> reservation = new ArrayList<Reservation>();
	
	
	public Room() {
	
	}

	
	
	public Room(String roomStatus, String floor, float roomRent, String type) {
		
		this.roomStatus = roomStatus;
		this.floor = floor;
		this.roomRent = roomRent;
		this.type = type;
	}



	public Room isRoomAvailable() {
		if(roomStatus.equalsIgnoreCase("available")) {
			return this;
		}
		return null;
		
	}
	
	
	
	
	



	@Override
	public String toString() {
		return "Room [roomId=" + roomId  + ", floor=" + floor + ", roomRent=" + roomRent
				+ ", type=" + type + "]";
	}



	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
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

	public Room getRoom() {
		return this;
	}
	
	public void cancelRoom() {
		
	}
	
	public void createRoom(Room roomid) {
		
	}
	
	public void deleteRoom(Room roomid) {
		
	}
	
	public void updateRoom(Room roomid, Room updatedRoom) {
		
	}
	
	public float addRoomItem(String roomId, int noOfDays) {
		return 0;
		
	}
	
	public void save() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		PersistanceFactory pf= PersistanceFactory.getInstance();
		PersistanceHandler ph=pf.createPersistanceHandler(persistanceMethod.persistane);
		
		ph.saveRoom(this);
	}
	
	public Room get(int id) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		PersistanceFactory pf= PersistanceFactory.getInstance();
		PersistanceHandler ph=pf.createPersistanceHandler(persistanceMethod.persistane);
		
		return ph.getRoom(id);
	}
	
	public List<Room> populate() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		PersistanceFactory pf= PersistanceFactory.getInstance();
		PersistanceHandler ph=pf.createPersistanceHandler(persistanceMethod.persistane);
		
		
		
		return ph.loadAllRoom();
		
		
	}
	
	public void saveorUpdate() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		PersistanceFactory pf= PersistanceFactory.getInstance();
				PersistanceHandler ph=pf.createPersistanceHandler(persistanceMethod.persistane);
				
				
				
				ph.saveorupdateRoom(this);
	}
	
	public void update() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		PersistanceFactory pf= PersistanceFactory.getInstance();
		PersistanceHandler ph=pf.createPersistanceHandler(persistanceMethod.persistane);
		
		
		
		ph.updateRoom(this);;
	}

}
