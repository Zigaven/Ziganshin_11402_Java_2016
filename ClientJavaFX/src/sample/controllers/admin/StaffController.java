package sample.controllers.admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.controllers.AbstractController;
import sample.entities.GeneralEntity;

/**
 * Created by ruslanzigansin on 28.05.16.
 */
public class StaffController extends AbstractController {
    public TableView<GeneralEntity> staffTable;
    public TableColumn<GeneralEntity,String> idColumn;
    public TableColumn<GeneralEntity,String> firstnameColumn;
    public TableColumn<GeneralEntity,String> lastnameColumn;
    public TableColumn<GeneralEntity,String> loginColumn;
    public TableColumn<GeneralEntity,String> emailColumn;

    @FXML
    private void initialize(){
        idColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(String.valueOf(cellData.getValue().getId())));

        firstnameColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty( cellData.getValue().getFirstName()));

        lastnameColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(String.valueOf(cellData.getValue().getLastName())));

        loginColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getLogin()));

        emailColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty( cellData.getValue().getEmail()));



        ObservableList<GeneralEntity> list = FXCollections.observableArrayList();
        list.addAll(server.getStaff());

        staffTable.setItems(list);

    }

}
