package application;

import java.io.IOException;

import buisnessLayer.Hotel;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class hotelcontroller {

      @FXML 
      private TextField email;
      
      @FXML 
      private TextField password;
      private Stage stage;
  	private Scene scene;
  	private Parent root;
      
  	
  	@FXML
      public void login(ActionEvent ae)
      {
    	  String setemail=email.getText();
    	  String pass=password.getText();
      }
      
  	@FXML
  	public void Switchtomakereservation(ActionEvent ae) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException
  	{
  		Hotel h=new Hotel();
  		try {
  		boolean verify=h.verifylogin(email.getText(), password.getText());
  		
  			root = FXMLLoader.load(getClass().getResource("menu.fxml"));
  	  		stage=(Stage)((Node)ae.getSource()).getScene().getWindow();
  	  		scene=new Scene(root);
  	  		stage.setScene(scene);
  	  		stage.show();
  		}
  		catch(Exception e) {
  			Alert a = new Alert(AlertType.NONE);

			a.setAlertType(AlertType.ERROR);
		
			
			a.setHeaderText("Invalid Email address or Password");

			
			a.show();
  		}
  	}
	@FXML
  	public void Switchtoregister(ActionEvent ae) throws IOException
  	{
  		root = FXMLLoader.load(getClass().getResource("registeration.fxml"));
  		stage=(Stage)((Node)ae.getSource()).getScene().getWindow();
  		scene=new Scene(root);
  		stage.setScene(scene);
  		stage.show();
  	}
}
