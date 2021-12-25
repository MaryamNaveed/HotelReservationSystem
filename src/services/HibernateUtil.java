package services;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import buisnessLayer.CheckIn;
import buisnessLayer.CheckOut;
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

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();

				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/hotelApnaGhar?useSSL=false");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "1234");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

				settings.put(Environment.SHOW_SQL, "true");

				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

				settings.put(Environment.HBM2DDL_AUTO, "update");
			
				configuration.setProperties(settings);
	
				configuration.addAnnotatedClass(RoomDescription.class);
				configuration.addAnnotatedClass(Room.class);
				
				configuration.addAnnotatedClass(Staff.class);
				configuration.addAnnotatedClass(Login.class);
				

				configuration.addAnnotatedClass(Customer.class);
				configuration.addAnnotatedClass(Defaulter.class);
				
				configuration.addAnnotatedClass(Reservation.class);
				configuration.addAnnotatedClass(cancelledReservation.class);
				
				configuration.addAnnotatedClass(HotelStay.class);
				configuration.addAnnotatedClass(CheckIn.class);
				configuration.addAnnotatedClass(CheckOut.class);
				configuration.addAnnotatedClass(Payment.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				
				
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				
				

			
				
		/*		 StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		            Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
		            return metadata.getSessionFactoryBuilder().build();*/
				
				
			} catch (Exception e) {
				System.out.println("Exception : "+e.getMessage());
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}
