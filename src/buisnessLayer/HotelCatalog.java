package buisnessLayer;

import java.util.ArrayList;
import java.util.List;
import java.time.*;

import application.Main;
import services.PersistanceFactory;
import services.PersistanceHandler;
import services.persistanceMethod;

public class HotelCatalog {
	
	private List<RoomDescription> roomdescs= new ArrayList<RoomDescription>();
	private List<Room> rooms= new ArrayList<Room>();
	
	public ArrayList<Room> searchAvailableRooms(String type) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		PersistanceFactory pf= PersistanceFactory.getInstance();
		PersistanceHandler ph=pf.createPersistanceHandler(persistanceMethod.persistane);
		
		
		List<Reservation> allreservations=ph.loadAllReservation();
	//	List<Reservation> reservations=ph.loadAllAvailableReservation();
		ArrayList<Room> availablerooms= new ArrayList<Room>();
		
		for(int i=0; i<roomdescs.size(); i++) {
			if(roomdescs.get(i).getType().equalsIgnoreCase(type)) {
				for(int j=0; j<roomdescs.get(i).getRooms().size(); j++) {
					boolean available=true;
						for(int k=0; k<allreservations.size(); k++) {
							if(allreservations.get(k).getStatus().equalsIgnoreCase("reserved") || allreservations.get(k).getStatus().equalsIgnoreCase("reserved")) {
							for(int l=0; l<allreservations.get(k).getReservedRooms().size(); l++) {
								if(roomdescs.get(i).getRooms().get(j).getRoomId()==allreservations.get(k).getReservedRooms().get(l).getRoomId()) {
									System.out.println("same id");
									if( (LocalDate.now().isAfter(allreservations.get(k).getArrivaldate()) || LocalDate.now().isEqual(allreservations.get(k).getArrivaldate())) && (LocalDate.now().isBefore(allreservations.get(k).getDeparturedate()) || LocalDate.now().isEqual(allreservations.get(k).getDeparturedate()))) {
										System.out.println("not available");
										available=false;
									}
								}
							}
							}
						}
						if(available) {
							availablerooms.add(roomdescs.get(i).getRooms().get(j));
						}
					}
				}
		}
		
		System.out.println(allreservations.size());
		
		for(int i=0; i<allreservations.size(); i++) {
			
			System.out.println(allreservations.get(i).getReservedRooms().size());
			for(int l=0; l<allreservations.get(i).getReservedRooms().size(); l++) 
				System.out.println(allreservations.get(i).getReservedRooms());//.get(l).getRoomId());
		}
		
		
		
		/*for(int i=0; i<roomdescs.size(); i++) {
			if(roomdescs.get(i).getType().equalsIgnoreCase(type))
				availablerooms.addAll(roomdescs.get(i).searchAvailableRooms(type));
		}*/
		return availablerooms;
		
	}
	
	public List<Room> searchAvailableRoomAt(String roomType, LocalDate adate, LocalDate ddate) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		PersistanceFactory pf= PersistanceFactory.getInstance();
		PersistanceHandler ph=pf.createPersistanceHandler(persistanceMethod.persistane);
		
		
		List<Reservation> allreservations=ph.loadAllReservation();
		ArrayList<Room> availablerooms= new ArrayList<Room>();
		
		for(int i=0; i<roomdescs.size(); i++) {
			if(roomdescs.get(i).getType().equalsIgnoreCase(roomType)) {
				for(int j=0; j<roomdescs.get(i).getRooms().size(); j++) {
					boolean available=true;
					
						for(int k=0; k<allreservations.size(); k++) {
							if(allreservations.get(k).getStatus().equalsIgnoreCase("reserved") || allreservations.get(k).getStatus().equalsIgnoreCase("reserved")) {
							for(int l=0; l<allreservations.get(k).getReservedRooms().size(); l++) {
								
								if(roomdescs.get(i).getRooms().get(j).getRoomId()==allreservations.get(k).getReservedRooms().get(l).getRoomId()) {
									System.out.println("same id");
									
									for (LocalDate date = adate; date.isBefore(ddate); date = date.plusDays(1))
									{
										if( (date.isAfter(allreservations.get(k).getArrivaldate()) || date.isEqual(allreservations.get(k).getArrivaldate())) && (date.isBefore(allreservations.get(k).getDeparturedate()) || date.isEqual(allreservations.get(k).getDeparturedate()))) {
											System.out.println("not available");
											available=false;
										}
									}
									/*if( ((adate.isAfter(allreservations.get(k).getArrivaldate()) || adate.isEqual(allreservations.get(k).getArrivaldate())) && (adate.isBefore(allreservations.get(k).getDeparturedate()) || adate.isEqual(allreservations.get(k).getDeparturedate()))) || ((ddate.isAfter(allreservations.get(k).getArrivaldate()) || ddate.isEqual(allreservations.get(k).getArrivaldate())) && (ddate.isBefore(allreservations.get(k).getDeparturedate()) || ddate.isEqual(allreservations.get(k).getDeparturedate())))) {
										System.out.println("not avail");
										available=false;
									}*/
								}
							}
							}
						}
						if(available==true) {
							availablerooms.add(roomdescs.get(i).getRooms().get(j));
						}
					}
				}
		}
		
		
		/*for(int i=0; i<reservations.size(); i++) {
			System.out.println(reservations.get(i).getReservationId());
		}*/
		
		
		
		/*for(int i=0; i<roomdescs.size(); i++) {
			if(roomdescs.get(i).getType().equalsIgnoreCase(type))
				availablerooms.addAll(roomdescs.get(i).searchAvailableRooms(type));
		}*/
		return availablerooms;
	}
	
	public void addRoom(Room roomid) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		boolean isexist=false;
		rooms.add(roomid);
		roomid.save();
		for(int i=0; i<roomdescs.size(); i++) {
			if(roomdescs.get(i).getType().equalsIgnoreCase(roomid.getType())) {
				roomdescs.get(i).addRoom(roomid);
				isexist=true;
				roomdescs.get(i).update();
			
			}
		}
		
		if(isexist==false) {
			roomdescs.add(new RoomDescription(roomid.getRoomRent(),roomid.getType()));
			roomdescs.get(roomdescs.size()-1).addRoom(roomid);
			roomdescs.get(roomdescs.size()-1).save();
		}
		
	}

	public List<RoomDescription> getRoomdescs() {
		return roomdescs;
	}

	public void setRoomdescs(ArrayList<RoomDescription> roomdescs) {
		this.roomdescs = roomdescs;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;
	}
	
	
	public void populateRoomdescs() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		RoomDescription r1= new RoomDescription();
		roomdescs=r1.populate();
	}


	public void populateRooms() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Room r1= new Room();
		rooms=r1.populate();
	}

}
