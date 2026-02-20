package controllers;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ListaController  implements Initializable                               {

    @FXML
    private ComboBox<?> categoríasComboID;

    @FXML
    private Button detallebotonID;

    @FXML
    private Button filtrarBotonID;

    @FXML
    private ListView<?> listadoProductosID;



    @Override
    public void initialize(URL location, ResourceBundle resources) {




    }

    public void start(Stage stage) {
        

    }
}

