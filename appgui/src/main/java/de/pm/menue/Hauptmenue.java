package de.pm.menue;

import java.util.Optional;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

    
public class Hauptmenue extends Application {

    private Stage mainStage;
	
	public static final String MAIN_SCREEN = "main";
	public static final String MAIN_SCREEN_FXML = "menue/hauptmenue.fxml";
    public static final String LOGIN_SCREEN = "login";
    public static final String LOGIN_SCREEN_FXML= "loginverwaltung/login.fxml";
    public static final String REGISTRIERUNG_SCREEN ="registrierung";
    public static final String REGISTRIERUNG_SCREEN_FXML = "loginverwaltung/registrierung.fxml";
   

	
	@Override
	public void start(Stage primaryStage) {
		
        new HauptmenueService();

		this.mainStage = primaryStage;
		
		ScreensController mainContainer = new ScreensController();
		mainContainer.loadScreen(Hauptmenue.MAIN_SCREEN, Hauptmenue.MAIN_SCREEN_FXML);
        mainContainer.loadScreen(Hauptmenue.LOGIN_SCREEN, Hauptmenue.LOGIN_SCREEN_FXML);
        mainContainer.loadScreen(Hauptmenue.REGISTRIERUNG_SCREEN, Hauptmenue.REGISTRIERUNG_SCREEN_FXML);
        
		
		
		mainContainer.print();
		
		mainContainer.setScreen(Hauptmenue.LOGIN_SCREEN);
		Group root = new Group();
//		BorderPane root = new BorderPane();
		root.getChildren().addAll(mainContainer);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setOnCloseRequest(confirmCloseEventHandler);
		primaryStage.show();
		
	}
	
    private EventHandler<WindowEvent> confirmCloseEventHandler = event -> {
    	//Quelle: http://stackoverflow.com/questions/29710492/javafx-internal-close-request
        Alert closeConfirmation = new Alert(
                Alert.AlertType.CONFIRMATION,
                "Are you sure you want to exit?"
        );
        Button exitButton = (Button) closeConfirmation.getDialogPane().lookupButton(
                ButtonType.OK
        );
        exitButton.setText("Exit");
        closeConfirmation.setHeaderText("Confirm Exit");
        closeConfirmation.initModality(Modality.APPLICATION_MODAL);
        closeConfirmation.initOwner(mainStage);

        // normally, you would just use the default alert positioning,
        // but for this simple sample the main stage is small,
        // so explicitly position the alert so that the main window can still be seen.
        closeConfirmation.setX(mainStage.getX() + 150);
        closeConfirmation.setY(mainStage.getY() - 300 + mainStage.getHeight());

        Optional<ButtonType> closeResponse = closeConfirmation.showAndWait();
        if (!ButtonType.OK.equals(closeResponse.get())) {
            event.consume();
        }
    };
	
	public static void main(String[] args) {
		launch(args);
	}
}


