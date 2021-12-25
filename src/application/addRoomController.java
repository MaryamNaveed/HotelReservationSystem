package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import buisnessLayer.Hotel;
import buisnessLayer.Room;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class addRoomController implements Initializable {
	
	@FXML
    private TextField rent;

    @FXML
    private TextField floor;

    @FXML
    private TextField status;
	
	@FXML 
    private Stage stage;
	private Scene scene;
	private Parent root;

    @FXML
    private RadioButton r1;

    @FXML
    private RadioButton r4;

    @FXML
    private RadioButton r2;

    @FXML
    private RadioButton r5;

    @FXML
    private RadioButton r3;

    @FXML
    private RadioButton r6;
    
    ToggleGroup group = new ToggleGroup();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		 
		    r1.setToggleGroup(group);
		    r2.setToggleGroup(group);
		    r3.setToggleGroup(group);
		    r4.setToggleGroup(group);
		    r5.setToggleGroup(group);
		    r6.setToggleGroup(group);
		
	}

    @FXML
    void Switchtomanagerooms(ActionEvent event) throws IOException {
    	root = FXMLLoader.load(getClass().getResource("ManageRooms.fxml"));
  		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
  		scene=new Scene(root);
  		stage.setScene(scene);
  		stage.show();
    }

    @FXML
    void addRoom(ActionEvent event) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
    	
    	String type = null;
		 try {
			 RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
			 type = selectedRadioButton.getText();
		 }
		 catch(Exception e) {
			 
		 }
		 float roomRent= Float.parseFloat(rent.getText());
		 Hotel h=new Hotel();
		 h.start();
		 
		 Room roomid=new Room(status.getText(), floor.getText(), roomRent, type);
		 
		 h.addRoom(roomid);
		 
		 

    }

}
