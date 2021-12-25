package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import buisnessLayer.CheckIn;
import buisnessLayer.CheckOut;
import buisnessLayer.Hotel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class cardpaymentController implements Initializable {
	private Stage stage;
	private Scene scene;
	private Parent root;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	@FXML
	private TextField total;

	@FXML
	private TextField paid;

	@FXML
	private TextField card;

	@FXML
	private Button done;

	String val;
	CheckIn cin;
	CheckOut cout;
	Hotel h;

	@FXML
	void Donebutton(ActionEvent event) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		if (!isFloat(paid.getText())) {
			Alert a1 = new Alert(AlertType.NONE);

			a1.setAlertType(AlertType.INFORMATION);

			a1.setHeaderText("Please enter positive numeric values");

			a1.show();
		} else if (cin == null) {
			h.makePayment(cout, Float.parseFloat(paid.getText()));
			h.EndCheckOut();

		} else {
			cin.getP().setCardnumber(card.getText());
			h.makePayment(cin, Float.parseFloat(paid.getText()));
			h.EndCheckIn(cin);
			Alert a1 = new Alert(AlertType.NONE);

			a1.setAlertType(AlertType.INFORMATION);

			a1.setHeaderText("ChekedIn");

			a1.show();
			switchtomenu(event);
		}
	}

	public void initData(Hotel h, CheckIn a, String val, CheckOut c) {
		this.h = h;
		this.cin = a;
		this.cout = c;
		this.val = val;
		done.setText(val);

		if (cin == null)
			total.setText(String.valueOf(this.cout.getTotal()));
		else
			total.setText(String.valueOf(this.cin.getTotal()));

		total.setEditable(false);
	}

	@FXML
	void switchtomenu(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("menu.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	private static boolean isFloat(String str) {
		try {
			float d = Float.parseFloat(str);
			if (d < 0) {
				return false;
			}
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
}
