package sample.controllers.admin;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.controllers.AbstractController;
import sample.controllers.Validation;
import sample.entities.ShopEntity;

/**
 * Created by ruslanzigansin on 28.05.16.
 */
public class AddShopController extends AbstractController {
    public TextField name;
    public TextField city;
    public TextField telephone;
    public TextField address;
    public Label errorField;


    public void handleShopAddAction(ActionEvent actionEvent) {
        if (Validation.validateTelephone(telephone.getText()) && !(name.getText().isEmpty()) && !(city.getText().isEmpty()) && !(address.getText().isEmpty())) {
            ShopEntity shopEntity = new ShopEntity();
            shopEntity.setName(name.getText());
            shopEntity.setCity(city.getText());
            shopEntity.setTelephone(telephone.getText());
            shopEntity.setAdress(address.getText());
            shopEntity.setLease(222);
            server.postNewShop(shopEntity);


            app.change("admin/Shop");
        }
        else    {
            errorField.setText("Invalid data");
        }

    }
}
