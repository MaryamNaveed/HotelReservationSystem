package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ManageRoomsController {

	   @FXML
	   private Stage stage;
	  	private Scene scene;
	  	private Parent root;
	
    @FXML
    void addRoom(ActionEvent event) throws IOException {
    	root = FXMLLoader.load(getClass().getResource("addRoom.fxml"));
  		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
  		scene=new Scene(root);
  		stage.setScene(scene);
  		stage.show();
    }

    @FXML
    void deleteRoom(ActionEvent event) {

    }

    @FXML
    void updateRoom(ActionEvent event) {

    }
    
    @FXML
    void switchtomenu(ActionEvent event) throws IOException {
    	root = FXMLLoader.load(getClass().getResource("menu.fxml"));
  		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
  		scene=new Scene(root);
  		stage.setScene(scene);
  		stage.show();
    }

}
