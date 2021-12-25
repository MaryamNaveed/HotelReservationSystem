package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import CustomExceptions.NotAnIntegerException;
import CustomExceptions.IncorrectEmailFormat;
import buisnessLayer.Customer;
import buisnessLayer.Defaulter;
import buisnessLayer.Hotel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class makereservation implements Initializable {

	 @FXML 
     private TextField password;
     private Stage stage;
 	private Scene scene;
 	private Parent root;
 	
 	@FXML
    private DatePicker ArrivalDate;

    @FXML
    private TextField name;

    @FXML
    private TextField email;

    @FXML
    private TextField address;

    @FXML
    private TextField nguests;

    @FXML
    private TextField nrooms;

    @FXML
    private DatePicker DepartureDate;

    @FXML
    private RadioButton r1;

    @FXML
    private RadioButton r2;

    @FXML
    private RadioButton r3;

    @FXML
    private RadioButton r4;

    @FXML
    private RadioButton r5;

    @FXML
    private RadioButton r6;

    @FXML
    private TextField phone;
    
    ToggleGroup group = new ToggleGroup();
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		 System.out.println("Entered");
		
			 r1.setToggleGroup(group);
			    r2.setToggleGroup(group);
			    r3.setToggleGroup(group);
			    r4.setToggleGroup(group);
			    r5.setToggleGroup(group);
			    r6.setToggleGroup(group);
		 
		    
		    
		
	}
	

    @FXML
    void Reserve(ActionEvent event) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
    	 String type = null;
		 try {
			 RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
			 type = selectedRadioButton.getText();
		 }
		 catch(Exception e) {
			 
		 }
    	String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
//		System.out.println(name.getText());
		if (name.getText() == null || type==null || DepartureDate==null || ArrivalDate==null || nguests.getText()==null || nguests.getText()=="" || nrooms.getText()==null || nrooms.getText()==""  || name.getText() == "" || email.getText() == null || email.getText() == "" || phone.getText() == null || phone.getText() == "") {
			Alert a = new Alert(AlertType.NONE);

			a.setAlertType(AlertType.ERROR);
		
				a.setHeaderText("Please Fill Complete form");
	
			
			a.show();
		}
		else {
		try {
			checkEmail();
		
		
		
			boolean val =false, val1=false;
			try{
				val=isInt(nguests.getText());
				val1=isInt(nrooms.getText());
				if(!val || !val1) {
					Alert a = new Alert(AlertType.NONE);
					
					 a.setAlertType(AlertType.WARNING);
					 
					 a.setHeaderText("Enter positive in no of guests and rooms");
					
					              
					  a.show();
				}
				else {
					Hotel h=new Hotel();
					h.start();
					Customer c= new Customer(name.getText(), address.getText(), email.getText(), phone.getText());
					
					Defaulter d=h.verifyCustomer(c);
					if(d!=null) {
						Alert a = new Alert(AlertType.NONE);
						
						 a.setAlertType(AlertType.ERROR);
						 
						 a.setHeaderText("Customer is a defaulter");
						
						              
						  a.show();
					}
					else {
						String type1 = null;
						 try {
							 RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
							 type1 = selectedRadioButton.getText();
						 }
						 catch(Exception e) {
							 
						 }
						h.makeNewReservation(c);
						float a=h.addRoomItem(Integer.parseInt(nrooms.getText()), Integer.parseInt(nguests.getText()), ArrivalDate.getValue(), DepartureDate.getValue(), type1);

						if(a==-1) {
							Alert a1 = new Alert(AlertType.NONE);
							
							 a1.setAlertType(AlertType.WARNING);
							 
							 a1.setHeaderText("Given number of rooms not available");
							
							              
							  a1.show();
						}
						else {
							h.endReservation();
							
							Alert a1 = new Alert(AlertType.NONE);
							
							 a1.setAlertType(AlertType.INFORMATION);
							 
							 a1.setHeaderText("Reservation made succesfully.\n Total Amount is: "+ a);
							
							              
							  a1.show();
						}
						
					
					}
					
				}
			}
			catch(Exception e) {
				Alert a = new Alert(AlertType.NONE);
				
				 a.setAlertType(AlertType.WARNING);
				 
				 a.setHeaderText("Enter numeric value in no of guests and rooms");
				
				              
				  a.show();
			}
		}
		catch(Exception e) {
			Alert a = new Alert(AlertType.NONE);

			a.setAlertType(AlertType.ERROR);
		
			
			a.setHeaderText("Invalid Email Format");

			
			a.show();
		}
		}
		

		
		
    }

	@FXML
  	public void Switchtomenu(ActionEvent ae) throws IOException
  	{
  		root = FXMLLoader.load(getClass().getResource("menu.fxml"));
  		stage=(Stage)((Node)ae.getSource()).getScene().getWindow();
  		scene=new Scene(root);
  		stage.setScene(scene);
  		stage.show();
  	}
	
	private static boolean isInt(String str) {
        try {
           int d=Integer.parseInt(str);
           if(d<=0) {
           	return false;
           }
        } catch (NumberFormatException nfe) {
            throw new NotAnIntegerException("The Value is not an Integer");
        }
        return true;
    }
	
	private void checkEmail() {
		String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
		if(email.getText().matches(regex)) {
			return;
		}
		throw new IncorrectEmailFormat("Email format is incorrect");
	}
}
