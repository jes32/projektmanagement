package de.pm.loginverwaltng;

import java.net.URL;
import java.util.ResourceBundle;

import de.pm.awk.model.Benutzer;
import de.pm.menue.ControlledSceneController;
import de.pm.menue.HauptmenueService;
import de.pm.menue.ScreensController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterController implements Initializable, ControlledSceneController {

    @FXML
    private TextField tf_username;

    @FXML
    private PasswordField tf_password;

    @FXML
    private Button bt_register;

    @FXML
    private Button bt_back;

    @FXML
    private Label lb_error;

    private ScreensController myController;

    @Override
    public void setScreenParent(ScreensController screenPage) {
        this.myController = screenPage;
    }

    @Override
    public void initData() {
        tf_username.setText("");
        tf_password.setText("");
        lb_error.setVisible(false);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void handleRegister(ActionEvent event) {

        String username = tf_username.getText();
        String password = tf_password.getText();

        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            lb_error.setText("Bitte alle Felder ausfüllen");
            lb_error.setVisible(true);
            return;
        }

      

        try {
            HauptmenueService.getLoginverwaltung()
                    .registrieren(username, password);

            System.out.println("User registriert: " + username);

            myController.setScreen("login");

        } catch(IllegalArgumentException e) {

        // 👉 DAS ist der wichtige Teil
        lb_error.setText(e.getMessage());
        lb_error.setVisible(true);

    }catch (Exception e) {
            lb_error.setText("unerwarteter Fehler");
            lb_error.setVisible(true);
           // e.printStackTrace();
        }
    }

    public void backToLogin(ActionEvent event) {
        myController.setScreen("login");
    }
}