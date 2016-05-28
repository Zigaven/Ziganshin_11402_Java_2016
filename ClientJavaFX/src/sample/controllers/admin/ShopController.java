package sample.controllers.admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.controllers.AbstractController;
import sample.entities.ShopEntity;

/**
 * Created by ruslanzigansin on 28.05.16.
 */
public class ShopController extends AbstractController {
    public TableView<ShopEntity> shopsTable;
    public TableColumn<ShopEntity,String> idColumn;
    public TableColumn<ShopEntity,String> nameColumn;
    public TableColumn<ShopEntity,String> cityColumn;
    public TableColumn<ShopEntity,String> telephoneColumn;
    public TableColumn<ShopEntity,String> addressColumn;

    @FXML
    private void initialize(){
        idColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(String.valueOf(cellData.getValue().getId())));

        nameColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty( cellData.getValue().getName()));

        cityColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(String.valueOf(cellData.getValue().getCity())));

        telephoneColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getTelephone()));

        addressColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty( cellData.getValue().getAdress()));




        ObservableList<ShopEntity> list = FXCollections.observableArrayList();
        list.addAll(server.getShops());

        shopsTable.setItems(list);

    }

}
