package sample.controllers;

import javafx.event.ActionEvent;
import sample.Main;
import sample.connection.ServerConnection;

/**
 * Created by ruslanzigansin on 26.05.16.
 */
public abstract class AbstractController {

    public void setApp(Main app) {
        this.app = app;
    }

    protected Main app;

    protected ServerConnection server = new ServerConnection();


    public void handleRegisterStaffPage(ActionEvent actionEvent) {
        app.change("admin/registerStaff");
    }

    public void handleStaffPage(ActionEvent actionEvent) {
        app.change("admin/staff");
    }

    public void handleAddNewShopPage(ActionEvent actionEvent) {
        app.change("admin/addShop");

    }

    public void handleShopsPage(ActionEvent actionEvent) {
        app.change("admin/shop");

    }

    public void handleAddNewComicsPage(ActionEvent actionEvent) {
        app.change("admin/addComics");
    }


    public void handleComicsPage(ActionEvent actionEvent) {
        app.change("admin/comics");
    }





}
