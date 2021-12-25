package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import buisnessLayer.Room;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class searchRoomResultController  implements Initializable {
	
	@FXML 
    private Stage stage;
	private Scene scene;
	private Parent root;
	
	List<Room> rooms= new ArrayList<Room>(); 
	
	List<List<TextField>> l = new ArrayList<List<TextField>>(); 
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	   @FXML
	   private GridPane g;

	    @FXML
	    void switchtosearchRoom(ActionEvent event) throws IOException {
	    	root = FXMLLoader.load(getClass().getResource("searchRoom.fxml"));
	  		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
	  		scene=new Scene(root);
	  		stage.setScene(scene);
	  		stage.show();
	    }
	
	public void initData(List<Room> r) {
		this.rooms=r;
		
		for(int i=0; i<rooms.size(); i++) {
			
				l.add(new ArrayList<TextField>());
		
				l.get(i).add(new TextField());
				l.get(i).get(0).setText(String.valueOf(rooms.get(i).getRoomId()));
				l.get(i).get(0).setEditable(false);
				g.add(l.get(i).get(0), 0, i+1);
			
				
				l.get(i).add(new TextField());
				l.get(i).get(1).setText(rooms.get(i).getFloor());
				l.get(i).get(1).setEditable(false);
				g.add(l.get(i).get(1), 1, i+1);
				

				l.get(i).add(new TextField());
				l.get(i).get(2).setText(String.valueOf(rooms.get(i).getRoomRent()));
				l.get(i).get(2).setEditable(false);
				g.add(l.get(i).get(2), 2, i+1);
				

				l.get(i).add(new TextField());
				l.get(i).get(3).setText(rooms.get(i).getType());
				l.get(i).get(3).setEditable(false);
				g.add(l.get(i).get(3), 3, i+1);
				g.addRow(i+1);
		
			
			
			
		}
	}
}
