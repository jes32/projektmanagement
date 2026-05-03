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

public class LoginController implements Initializable, ControlledSceneController {

    @FXML
    private TextField tf_username;

    @FXML
    private PasswordField tf_password;

    @FXML
    private Button bt_login;

    @FXML
    private Button bt_register;

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

    public void login(ActionEvent event) {

        //   String username = tf_username.getText();
        // String password = tf_password.getText();

        // if (username == null || username.isEmpty()
        //         || password == null || password.isEmpty()) {

        //     lb_error.setText("Bitte alle Felder ausfüllen");
        //     lb_error.setVisible(true);
        //     return;
        // }

        // Benutzer user = HauptmenueService.getLoginverwaltung()
        //         .login(username, password);

        // if (user != null) {

        //     System.out.println("Login erfolgreich: " + user.getUsername());


        //     myController.setCurrentUser(user);

        //     myController.setScreen("main");

        // } else {

        //     // lb_error.setText("Login fehlgeschlagen"); lb_error.setVisible(true);
        //     // }

        //      // Benutzer separat laden um Grund herauszufinden
        // Benutzer b = HauptmenueService.getLoginverwaltung().findByUsername(username);

        // if (b == null) {
        //     lb_error.setText("Benutzer existiert nicht");
        // }
        // else if (b.isGesperrt()) {
        //     lb_error.setText("Benutzerkonto ist nach 3 Fehlversuchen gesperrt");
        // }
        // else {
        //     lb_error.setText("Passwort falsch! Fehlversuch: " + b.getFehlversuche() + " von 3");
        // }

        // lb_error.setVisible(true);
        // }

        try {

        String username = tf_username.getText();
        String password = tf_password.getText();

        if (username == null || username.isEmpty()
                || password == null || password.isEmpty()) {

            lb_error.setText("Bitte alle Felder ausfüllen");
            lb_error.setVisible(true);
            return;
        }

        Benutzer user = HauptmenueService.getLoginverwaltung().login(username, password);

        if (user != null) {

            System.out.println("Login erfolgreich: " + user.getUsername());

            myController.setCurrentUser(user);
            myController.setScreen("main");

        } else {

            Benutzer b = HauptmenueService.getLoginverwaltung().findByUsername(username);

            if (b == null) {
                lb_error.setText("Benutzer existiert nicht");
            }
            else if (b.isGesperrt()) {
                lb_error.setText("Benutzerkonto ist nach 3 Fehlversuchen gesperrt");
            }
            else {
                lb_error.setText("Passwort falsch! Fehlversuch: " + b.getFehlversuche() + " von 3");
            }

            lb_error.setVisible(true);
        }

    } catch (Exception e) {
        lb_error.setText("Fehler beim Login: " + e.getMessage());
        lb_error.setVisible(true);
    }
    }

    public void openRegister(ActionEvent event) {
        myController.setScreen("registrierung");
    }
}

