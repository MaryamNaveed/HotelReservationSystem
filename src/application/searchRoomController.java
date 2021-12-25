package application;

import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class searchRoomController implements Initializable {

	@FXML
    private AnchorPane Mysearchroom;
	
	@FXML 
    private Stage stage;
	private Scene scene;
	private Parent root;
	
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
	    void switchTomenu(ActionEvent ae) throws IOException
	  	{
		 
		// System.out.println(type);
	  		root = FXMLLoader.load(getClass().getResource("menu.fxml"));
	  		stage=(Stage)((Node)ae.getSource()).getScene().getWindow();
	  		scene=new Scene(root);
	  		stage.setScene(scene);
	  		stage.show();
	  	}


	 @FXML
	    void searchRoom(ActionEvent event) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		 String type = null;
		 try {
			 RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
			 type = selectedRadioButton.getText();
		 }
		 catch(Exception e) {
			 
		 }
		
		Hotel h=new Hotel();
		h.start();
		
		List<Room> rooms=h.SearchRoom(type);
		
		stage = (Stage) Mysearchroom.getScene().getWindow();
		stage.close();
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(getClass().getResource("searchRoomResult.fxml"));
		
		root = loader.load();
		
  		//stage=(Stage)((Node)event.getSource()).getScene().getWindow();
  		scene=new Scene(root);
  		stage.setScene(scene);
  		
		searchRoomResultController controller=loader.getController();
		controller.initData(rooms);
		
		stage.show();
	 }
}



