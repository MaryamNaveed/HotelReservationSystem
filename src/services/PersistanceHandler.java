package services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import buisnessLayer.Customer;
import buisnessLayer.Defaulter;
import buisnessLayer.HotelStay;
import buisnessLayer.Login;
import buisnessLayer.Payment;
import buisnessLayer.Reservation;
import buisnessLayer.Room;
import buisnessLayer.RoomDescription;
import buisnessLayer.Staff;
import buisnessLayer.cancelledReservation;

public class PersistanceHandler {

	public void saveRoom(Room roomid) {
		
		
	}
	public void updateRoom(Room r) {
	
	}
	
	public void saveorupdateRoom(Room r) {
		
	}
	public void saveStaff(Staff staffid) {
			
			
	}
	
	public void saveCustomer(Customer staffid) {
		
		
	}
	
	public void saveHotelStay(HotelStay hstay) {
		
		
	}
	public void savePayment(Payment p) {
		
		
	}
	public Room getRoom(int id) {
		return null;
	}
	
	public Reservation getReservation(int id) {
		return null;

	}
	
	public void saveLogin(Login loginid) {
		
		
	}
	
	public void saveReservation(Reservation r) {
		
	}
	
	public void saveCancellation(cancelledReservation r) {
		
	}
	
	public void updateReservation(Reservation r) {
		
	}
	
	
	public List<Reservation> loadAllReservation(){
		return null;
		
	}
	
	public List<Reservation> loadAllAvailableReservation(){
		return null;
		
	}
	public void saveRoomDesc(RoomDescription roomdescId) {
		
		
	}
	
	public List<RoomDescription> loadAllRoomDesc(){
		return null;
		
	}
	
	public List<Room> loadAllRoom(){
		return null;
		
	}
	public List<Defaulter> loadAllDefaulters() {
		return null;
	}
	
	public void updateRoomDesc(RoomDescription roomdesc) {
	}

	public Login verifyLogin(String email, String password) {
		
		return null;
	}

}
