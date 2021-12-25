package testCases;


import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import application.Main;
import buisnessLayer.Customer;
import buisnessLayer.Hotel;
import buisnessLayer.Login;
import buisnessLayer.Reservation;
import buisnessLayer.Room;




public class testCase {
	Hotel h;
	@Before
	public void setUp() throws Exception {
		h=new Hotel();
	
	}
	
	
	@Test
	public void test1() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		Customer c=new Customer("Maryam", "G-11","abc@gmail.com", "0334123456");
		h.makeNewReservation(c);
		h.addRoom(new Room("available","ground", 1100, "Base Level"));
		List<Room> r=new ArrayList<Room>();
		r=h.getCatalog().getRooms();
		h.addRoomItem(1, 2, LocalDate.now(), LocalDate.now().plusDays(2), "Base Level");
		h.endReservation();
		List<Reservation> r1=h.getReservations();
		
		assertEquals(1, r1.size());
		

		
	}
	
	@Test
	public void test2() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		
		h.addRoom(new Room("available","ground", 1100, "Base Level"));
		List<Room> r=new ArrayList<Room>();
		r=h.getCatalog().getRooms();
		
		
		
		Room r1= new Room();
		assertNotEquals(null,r1.get(r.get(0).getRoomId()));
	}
	
	@Test
	public void test3() throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		Customer c=new Customer("Maryam", "G-11","abc@gmail.com", "0334123456");
		h.makeNewReservation(c);
		h.addRoom(new Room("available","ground", 1100, "Base Level"));
		List<Room> r=new ArrayList<Room>();
		r=h.getCatalog().getRooms();
		h.addRoomItem(1, 2, LocalDate.now(), LocalDate.now().plusDays(2), "Base Level");
		h.endReservation();
		List<Reservation> r1=h.getReservations();
		
		int id=r1.get(0).getReservationId();
		
		h.cancelReservation(r1.get(0),"", LocalDate.now());
		
		assertEquals(null, h.verifyReservation(id));
		
		
		
	}
	
	@Test
	public void test4() throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		String e="maryam@yahoo.com";
		String pass="1234";
		Login l1= new Login(e, pass);
		l1.save();
		assertNotEquals(null,h.verifylogin(e, pass));
		
		
	}
}
