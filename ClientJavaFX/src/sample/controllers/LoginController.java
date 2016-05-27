package sample.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import sample.connection.ServerAuthentication;

/**
 * Created by ruslanzigansin on 26.05.16.
 */
public class LoginController extends AbstractController {


    public Pane pane;
    public TextField login;
    public PasswordField password;
    public Label error;
    public Button buttonLog;

    public void handleSubmitAction(ActionEvent actionEvent) {
        ServerAuthentication authentication = new ServerAuthentication();
        System.out.println(login.getText());
        System.out.println(password.getText());
        if (authentication.tryAuth(login.getText(), password.getText())) {
            switch (ServerAuthentication.role){
                case ROLE_ADMIN:
                    app.change("admin/Comics");
                    break;
//                case ROLE_STAFF:
//                    app.change("staff/ordersPage");
//                    break;
//
//                case ROLE_CLIENT:
//                    app.change("client/comicsPage");
//                    break;

                default:app.change("login");
            }

        } else {
            error.setText(" Invalid login or password");
        }
    }
}
