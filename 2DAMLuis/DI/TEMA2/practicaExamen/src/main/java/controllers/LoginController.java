package controllers;

import DAO.UsuarioDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Button botonLoginID;

    @FXML
    private TextField correotextID;

    @FXML
    private TextField passtextID;
    public void initialize(URL location, ResourceBundle resources) {
        eventosLogin();




    }

   //para gesstionar el login
    public void eventosLogin(){
     String correo = correotextID.getText();
     String password = passtextID.getText();
     if(correo.isEmpty() || password.isEmpty()){
         Alert alert = new Alert(Alert.AlertType.ERROR);
         alert.setTitle("Error");
         alert.setHeaderText("Error al iniciar sesión");
         alert.setContentText("Por favor, completa todos los campos");
         alert.showAndWait();
     }
     else{
         // lo llevara a listaController
         botonLoginID.setOnAction(event -> {
             // lo lleva a listaController
             ListaController listaController = new ListaController();
             listaController.start(new Stage());

         });

         

     }

    }






















}
