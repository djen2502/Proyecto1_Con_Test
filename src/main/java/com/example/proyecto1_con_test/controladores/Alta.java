package com.example.proyecto1_con_test.controladores;

import com.example.proyecto1_con_test.DAO.BebidaDAO;
import com.example.proyecto1_con_test.modelos.Bebida;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.converter.LocalDateStringConverter;
import javafx.util.converter.NumberStringConverter;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;




public class Alta {

    @FXML
    private TextField txtPrecio;
    @FXML
    private DatePicker txtEncargo;
    @FXML
    private TextField txtCantidad;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtLinea;
    @FXML
    public Button closeButton;

    private com.example.proyecto1_con_test.DAO.BebidaDAO BebidaDAO = new BebidaDAO();
    private Bebida productoAux;


    public void initialize()  {



        productoAux = new Bebida(0, "", 0d,
                0, "");

        realizarBindingsProductoAux(productoAux);
    }



    @javafx.fxml.FXML
    public void onAltaClicked(ActionEvent actionEvent) {

        if ( ! productoAux.getNombre().trim().equals("")) {
            if (BebidaDAO.altaBebida(productoAux)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Se ha introducido la bebida correctamente.", ButtonType.OK );
                alert.showAndWait();
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Debe introducir un Nombre para el producto.", ButtonType.OK );
            alert.showAndWait();
        }


    }

    @FXML
    private void realizarBindingsProductoAux ( Bebida producto) {

        Bindings.bindBidirectional(txtLinea.textProperty(), txtEncargo.valueProperty(), new LocalDateStringConverter());

        txtNombre.textProperty().bindBidirectional(producto.NombreProperty());
        txtPrecio.textProperty().bindBidirectional(producto.PrecioProperty(), new NumberStringConverter());
        txtCantidad.textProperty().bindBidirectional(producto.CantidadProperty(),new NumberStringConverter());
        txtLinea.textProperty().bindBidirectional(producto.ProxEncargoProperty());
    }

    @FXML
    public void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }




}
