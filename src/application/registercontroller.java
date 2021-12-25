package application;

import java.io.IOException;

import buisnessLayer.Hotel;
import buisnessLayer.Login;
import buisnessLayer.Staff;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class registercontroller {

	@FXML

	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML
	private TextField name;

	@FXML
	private TextField email;

	@FXML
	private TextField password;

	@FXML
	private TextField pass;

	@FXML
	private TextField phone;

	@FXML
	private TextArea address;

	@FXML
	void Register(ActionEvent event) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		
//		System.out.print("Registering");
		String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
//		System.out.println(name.getText());
		if (name.getText() == null || name.getText() == "" || email.getText() == null || email.getText() == "" || password.getText() == null || password.getText() == "") {
			Alert a = new Alert(AlertType.NONE);

			a.setAlertType(AlertType.ERROR);
			if (name.getText() == null || name.getText() == "") {
				a.setHeaderText("Name is required");
			}
			if (email.getText() == null || email.getText() == "") {
				a.setHeaderText("Email is required");
			}
			if (password.getText() == null || password.getText() == "") {
				a.setHeaderText("Pasword is required");
			}
			
			a.show();
		}
		
		else if (!(password.getText().equals(pass.getText()))) {
			Alert a = new Alert(AlertType.NONE);

			a.setAlertType(AlertType.ERROR);
		
			
			a.setHeaderText("Password and Confirm pasword are different");

			
			a.show();
		}
		
		

		else if(!email.getText().matches(regex)) {
			Alert a = new Alert(AlertType.NONE);

			a.setAlertType(AlertType.ERROR);
		
			
			a.setHeaderText("Invalid Email Format");

			
			a.show();
		}

		else {
		
			Staff s= new Staff(name.getText(), address.getText(), new Login(email.getText(), password.getText()),phone.getText());
			Hotel h= new Hotel();
			h.register(s);
			
			root = FXMLLoader.load(getClass().getResource("login.fxml"));
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
	}

	@FXML
	public void Switchtomenu(ActionEvent ae) throws IOException {
		root = FXMLLoader.load(getClass().getResource("login.fxml"));
		stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

}
