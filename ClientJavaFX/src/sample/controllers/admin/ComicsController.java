package sample.controllers.admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.controllers.AbstractController;
import sample.entities.ComicsEntity;

/**
 * Created by ruslanzigansin on 27.05.16.
 */
public class ComicsController extends AbstractController {
    public TableView<ComicsEntity> comicsTable;
    public TableColumn<ComicsEntity,String> idColumn;
    public TableColumn<ComicsEntity,String> nameColumn;
    public TableColumn<ComicsEntity,String> priceColumn;
    public TableColumn<ComicsEntity,String> descriptionColumn;
    public TableColumn<ComicsEntity,String> publisherColumn;

    @FXML
    private void initialize(){
        idColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(String.valueOf(cellData.getValue().getId())));

        nameColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty( cellData.getValue().getName()));

        priceColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(String.valueOf(cellData.getValue().getPrice())));

        descriptionColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getDescription()));

        publisherColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty( cellData.getValue().getPublisher()));

        descriptionColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty( cellData.getValue().getDescription()));



        ObservableList<ComicsEntity> list = FXCollections.observableArrayList();
        list.addAll(server.getComics());

        comicsTable.setItems(list);

    }


}
