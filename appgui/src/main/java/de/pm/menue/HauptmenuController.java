package de.pm.menue;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HauptmenuController implements Initializable, ControlledSceneController {

    
@FXML
private Label lb_user;
@FXML
private Button bt_abmelden;
    private ScreensController myController;

    @Override
    public void setScreenParent(ScreensController screensController) {
        this.myController = screensController;
    }

    @Override
    public void initData() {

        if (myController.getCurrentUser() != null) {
        lb_user.setText("Willkommen " +
            myController.getCurrentUser().getUsername());
    }

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    }

    public void logout(ActionEvent event) {
    myController.setCurrentUser(null);
    myController.setScreen("login");
}


  
}


