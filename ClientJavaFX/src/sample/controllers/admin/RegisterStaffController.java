package sample.controllers.admin;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.controllers.AbstractController;
import sample.controllers.Validation;
import sample.entities.GeneralEntity;
import sample.entities.roles.Role;

/**
 * Created by ruslanzigansin on 27.05.16.
 */
public class RegisterStaffController extends AbstractController {
    public PasswordField password;
    public TextField firstname;
    public TextField lastname;
    public TextField login;
    public TextField email;
    public Label errorField;



    public void handleStaffRegister(ActionEvent actionEvent) {
        if (Validation.validateEmail(email.getText())) {
            GeneralEntity usersEntity = new GeneralEntity();
            usersEntity.setLogin(login.getText());
            usersEntity.setPassword(password.getText());
            usersEntity.setRole(Role.ROLE_STAFF);
            usersEntity.setFirstName(firstname.getText());
            usersEntity.setLastName(lastname.getText());
            usersEntity.setEmail(email.getText());

            server.postNewStaff(usersEntity);
            app.change("admin/staff");
        }
        else {
            errorField.setText("Invalid email");

        }

    }

}
