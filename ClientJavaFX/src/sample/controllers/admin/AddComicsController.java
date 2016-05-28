package sample.controllers.admin;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.controllers.AbstractController;
import sample.controllers.Validation;
import sample.entities.ComicsEntity;

/**
 * Created by ruslanzigansin on 27.05.16.
 */
public class AddComicsController extends AbstractController {
    public TextField name;
    public TextField price;
    public TextField publisher;
    public TextField description;
    public Label errorField;


    public void handleComicsAddAction(ActionEvent actionEvent) {
        if (Validation.validateNumber(price.getText()) && !(name.getText().isEmpty()) && !(publisher.getText().isEmpty()) && !(description.getText().isEmpty())) {
            ComicsEntity comicsEntity = new ComicsEntity();
            comicsEntity.setName(name.getText());
            comicsEntity.setPrice(Integer.parseInt(price.getText()));
            comicsEntity.setPublisher(publisher.getText());
            comicsEntity.setDescription(description.getText());
            comicsEntity.setPath("hehehe");
            server.postNewComics(comicsEntity);

            System.out.println(comicsEntity.getName());

            app.change("admin/Comics");
        }
        else    {
            errorField.setText("Invalid data");
        }

    }

}
