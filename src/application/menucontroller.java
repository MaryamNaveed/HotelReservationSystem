package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class menucontroller {

	   @FXML
	   private Stage stage;
	  	private Scene scene;
	  	private Parent root;
	
	 public void makereservation(ActionEvent ae) throws IOException
	{
		root = FXMLLoader.load(getClass().getResource("makereservation.fxml"));
  		stage=(Stage)((Node)ae.getSource()).getScene().getWindow();
  		scene=new Scene(root);
  		stage.setScene(scene);
  		stage.show();
	}
	 @FXML
	 public void cancelreservation(ActionEvent ae) throws IOException
		{
			root = FXMLLoader.load(getClass().getResource("cancelReservation.fxml"));
	  		stage=(Stage)((Node)ae.getSource()).getScene().getWindow();
	  		scene=new Scene(root);
	  		stage.setScene(scene);
	  		stage.show();
		}
	 public void checkInButton(ActionEvent ae) throws IOException
		{
			root = FXMLLoader.load(getClass().getResource("HaveReservationCheckIn.fxml"));
	  		stage=(Stage)((Node)ae.getSource()).getScene().getWindow();
	  		scene=new Scene(root);
	  		stage.setScene(scene);
	  		stage.show();
		}
	 public void checkOut(ActionEvent ae) throws IOException
		{
			root = FXMLLoader.load(getClass().getResource("checkout.fxml"));
	  		stage=(Stage)((Node)ae.getSource()).getScene().getWindow();
	  		scene=new Scene(root);
	  		stage.setScene(scene);
	  		stage.show();
		}
	 
	 @FXML
	    void searchRoom(ActionEvent ae) throws IOException {
		 root = FXMLLoader.load(getClass().getResource("searchRoom.fxml"));
	  		stage=(Stage)((Node)ae.getSource()).getScene().getWindow();
	  		scene=new Scene(root);
	  		stage.setScene(scene);
	  		stage.show();
	    }
	 
	 @FXML
	    void manageRoom(ActionEvent event) throws IOException {
		 root = FXMLLoader.load(getClass().getResource("ManageRooms.fxml"));
	  		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
	  		scene=new Scene(root);
	  		stage.setScene(scene);
	  		stage.show();
	    }

}
