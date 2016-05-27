package sample.scenes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;

/**
 * Created by ruslanzigansin on 26.05.16.
 */
public class Buttons extends TableCell<Button,Boolean> {


        private final Button button;
        private final TableView table;


        public Buttons(String name, TableView table) {
            button = new Button(name);
            this.table = table;

            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent actionEvent) {
                    table.getSelectionModel().select(getTableRow().getIndex());
                }
            });
        }


        @Override
        protected void updateItem(Boolean item, boolean empty) {
            super.updateItem(item, empty);
            if (!empty) {
                setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                setGraphic(button);
            } else {
                setGraphic(null);
            }
        }

    }

