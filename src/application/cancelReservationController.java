package application;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import buisnessLayer.Hotel;
import buisnessLayer.Reservation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class cancelReservationController implements Initializable  {

    @FXML
    private TextField id;

    @FXML
    private DatePicker cDate;

    @FXML
    private TextArea reason;
    
    private Stage stage;
   	private Scene scene;
   	private Parent root;
   	
   	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		cDate.setValue(LocalDate.now());
		
	
		
		
	}

    @FXML
    void Switchtomenu(ActionEvent event) throws IOException {
    	root = FXMLLoader.load(getClass().getResource("menu.fxml"));
  		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
  		scene=new Scene(root);
  		stage.setScene(scene);
  		stage.show();
    }

    @FXML
    void cancel(ActionEvent event) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
    	Hotel h=new Hotel();
    	h.start();
    	
    	Reservation r=h.verifyReservation(Integer.parseInt(id.getText()));
    	if(r!=null) {
    		h.cancelReservation(r, reason.getText(), cDate.getValue());
    		Alert a = new Alert(AlertType.NONE);
			
			 a.setAlertType(AlertType.INFORMATION);
			 
			 a.setHeaderText("Cancellation succesful");
			
			              
			  a.show();
    	}
    	else {
			Alert a = new Alert(AlertType.NONE);

			a.setAlertType(AlertType.ERROR);
		
				a.setHeaderText("No such reservation exist");
	
			
			a.show();
    	}
    	
    	
    }

}
