package application;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import buisnessLayer.CheckIn;
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
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class HaveReservationCheckInController implements Initializable {

	@FXML
	private AnchorPane MyForm;

	@FXML
	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML
	private TextField id;

	@FXML
	private DatePicker cDate;

	@FXML
	void GotoCheckIn(ActionEvent event) throws IOException, NumberFormatException, InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		Hotel h = new Hotel();
		h.start();
		if (!isInt(id.getText())) {
			Alert a = new Alert(AlertType.NONE);

			a.setAlertType(AlertType.ERROR);

			a.setHeaderText("Enter numerical reservation id");

			a.show();
		} else {
			Reservation r = h.verifyReservation(Integer.parseInt(id.getText()));
			if (r != null) {
				CheckIn cin = h.enterCheckIn(r, cDate.getValue());
				Button button = (Button) event.getSource();
				String buttonText = button.getText();
				h.makePaymentmethod(cin, buttonText);
				stage = (Stage) MyForm.getScene().getWindow();
				stage.close();
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("payment.fxml"));

				root = loader.load();

				// stage=(Stage)((Node)event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);

				paymentController controller = loader.getController();
				controller.initData(h, cin, "CheckIn", null);

				stage.show();
			}

			else {
				Alert a = new Alert(AlertType.NONE);

				a.setAlertType(AlertType.ERROR);

				a.setHeaderText("No such reservation exist");

				a.show();
			}

		}
	}

	@FXML
	void GotoCheckInCard(ActionEvent event) throws IOException, NumberFormatException, InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		Hotel h = new Hotel();
		h.start();
		if (!isInt(id.getText())) {
			Alert a = new Alert(AlertType.NONE);

			a.setAlertType(AlertType.ERROR);

			a.setHeaderText("Enter numerical reservation id");

			a.show();
		} else {
			Reservation r = h.verifyReservation(Integer.parseInt(id.getText()));
			if (r != null) {
				CheckIn cin = h.enterCheckIn(r, cDate.getValue());
				Button button = (Button) event.getSource();
				String buttonText = button.getText();
				h.makePaymentmethod(cin, buttonText);
				stage = (Stage) MyForm.getScene().getWindow();
				stage.close();
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("cardPayment.fxml"));

				root = loader.load();

				// stage=(Stage)((Node)event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);

				cardpaymentController controller = loader.getController();
				controller.initData(h, cin, "CheckIn", null);

				stage.show();
			}

			else {
				Alert a = new Alert(AlertType.NONE);

				a.setAlertType(AlertType.ERROR);

				a.setHeaderText("No such reservation exist");

				a.show();
			}

		}
	}

	@FXML
	void Switchtomenu(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("menu.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cDate.setValue(LocalDate.now());
	}

	private static boolean isInt(String str) {
		try {
			int d = Integer.parseInt(str);
			if (d < 0) {
				return false;
			}
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
}
