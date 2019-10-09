package viewFX;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class PersonOverviewController implements Initializable{
	
	@FXML
	private Label labelEmployeesDetails;
	
	@FXML
	private void handleButtonAddNewAction(ActionEvent event) {
		System.out.println("You clicked me!");
		labelEmployeesDetails.setText("Klikl jsi na pøidat.");
	}
	@FXML
	private void handleButtonEditAction(ActionEvent event) {
		System.out.println("You clicked me!");
		labelEmployeesDetails.setText("Klikl jsi na upravit.");
	}
	@FXML
	private void handleButtonDelteAction(ActionEvent event) {
		System.out.println("You clicked me!");
		labelEmployeesDetails.setText("Klikl jsi na smazat.");
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
	}

}
