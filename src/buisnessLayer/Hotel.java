package buisnessLayer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import CustomExceptions.IncorrectLogin;

public class Hotel {

	
	private HotelCatalog catalog= new HotelCatalog();
	List<Defaulter> defaulters=new ArrayList<Defaulter>();
	List<HotelStay> hstay=new ArrayList<HotelStay>();
	
	List<Staff> staff=new ArrayList<Staff>();
	List<Reservation> reservations=new ArrayList<Reservation>();
	Reservation currentReservation;
	HotelStay currentStay;
	

	
	
	
	public HotelCatalog getCatalog() {
		return catalog;
	}

	public void setCatalog(HotelCatalog catalog) {
		this.catalog = catalog;
	}

	public List<Defaulter> getDefaulters() {
		return defaulters;
	}

	public void setDefaulters(List<Defaulter> defaulters) {
		this.defaulters = defaulters;
	}

	public List<HotelStay> getHstay() {
		return hstay;
	}

	public void setHstay(List<HotelStay> hstay) {
		this.hstay = hstay;
	}

	public List<Staff> getStaff() {
		return staff;
	}

	public void setStaff(List<Staff> staff) {
		this.staff = staff;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Reservation getCurrentReservation() {
		return currentReservation;
	}

	public void setCurrentReservation(Reservation currentReservation) {
		this.currentReservation = currentReservation;
	}

	public ArrayList<Room> SearchRoom(String type) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		return catalog.searchAvailableRooms(type);
		
	}
	
	public Reservation verifyReservation(int resId) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Reservation r= new Reservation();
		return r.verifyReservation(resId);
		
	}
	
	public void start() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		catalog.populateRoomdescs();
		catalog.populateRooms();
		
		currentReservation = new Reservation();
		
		reservations= currentReservation.populate();
		
		
		
	}
	
	public boolean verifylogin(String email, String password) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Staff s=new Staff();
		if(s.verifylogin(email, password)) {
			return true;
		}
		throw new IncorrectLogin("Incorrect Login");
	}
	
	public void register(Staff s) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		s.createStaff();
		staff.add(s);
		s.save();
		
	}
	public void populatedefaulter() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Defaulter def=new Defaulter();
		defaulters=def.populate();
		
	}
	public Defaulter verifyCustomer(Customer customerId) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		populatedefaulter();
		for(int i=0; i<defaulters.size(); i++) {
			Defaulter def=defaulters.get(i).customerVerification(customerId);
			if(def!=null) {
				return def;
			}
		}
		
		customerId.saveCustomer();
		
		return null;
		
	}
	
	public void makeNewReservation(Customer c) {
		
		currentReservation=new Reservation();
		
		//currentReservation.setCust(c);
		
		
	}
	
	public float addRoomItem(int nrooms, int nguests, LocalDate aDate, LocalDate dDate, String roomType) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		List<Room> r=catalog.searchAvailableRoomAt(roomType, aDate, dDate);
		
		if(r==null || r.size()<nrooms) {
			return -1;
		}
		
		
		currentReservation.setNoOfguests(nguests);
		currentReservation.setArrivaldate(aDate);
		currentReservation.setDeparturedate(dDate);
		
		return currentReservation.addRoomItem(r, nrooms);
		
		
		
		
	}
	
	
	public void endReservation() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		currentReservation.setStatus("Reserved");
		
		reservations.add(currentReservation);
		currentReservation.save();
	}
	
	public void makePayment(float amount) {
		
	}
	
	public void makePaymentmethod(CheckIn cin,String method) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		cin.makePaymentmethod(method);
	}
	
	public void makePaymentmethod(CheckOut cout,String method) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		cout.makePaymentmethod(method);
	}
	
	public void makePayment(CheckIn cin, float amount) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		cin.createPayment(amount);
	}
	
	public void makePayment(CheckOut cout, float amount) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		cout.createPayment(amount);
	}
	

	public void EndCheckIn(CheckIn c) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		currentStay.setCin(c);
		currentStay.EndCheckIn();
		this.hstay.add(currentStay);
	}

	public void EndCheckOut() {
		
	}
	
	public void addRoom(Room roomid) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		catalog.addRoom(roomid);
	}
	
	public void deleteRoom(Room roomid) {
			
	}
		
	public void updateRoom(Room roomid, Room updatedRoom) {
		
	}
	public void cancelReservation(Reservation resId, String reason, LocalDate date) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		resId.cancelReservation(reason, date);
	}
	
	public CheckIn enterCheckIn(Reservation reservationId, LocalDate datetime) {
		currentStay=new HotelStay();

		return currentStay.createCheckIn(datetime, reservationId);
	}
	
	public CheckOut enterCheckOut(Reservation reservationId, LocalDate datetime) {
		currentStay=new HotelStay();
		return currentStay.createCheckOut(datetime, reservationId);
		
	}
	public void enterClearanceDetails(Reservation reservationId) {
		
	}
	
	public void generateReceipt() {
		
	}

}
