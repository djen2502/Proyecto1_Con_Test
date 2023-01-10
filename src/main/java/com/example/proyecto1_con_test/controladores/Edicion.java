package com.example.proyecto1_con_test.controladores;

import com.example.proyecto1_con_test.DAO.BebidaDAO;
import com.example.proyecto1_con_test.modelos.Bebida;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.converter.LocalDateStringConverter;
import javafx.util.converter.NumberStringConverter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Edicion {

    @FXML
    private TextField txtPrecio;
    @FXML
    private DatePicker txtEncargo;
    @FXML
    private TextField txtCantidad;

    @FXML
    private TextField txtID;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtLinea;
    @FXML
    public Button closeButton;



    private Bebida productoAux;

    private com.example.proyecto1_con_test.DAO.BebidaDAO BebidaDAO = new BebidaDAO();

    public void initialize()  {



        productoAux = new Bebida(0, "", 0d,
                0, "");

        realizarBindingsProductoAux(productoAux);

    }


    @FXML
    private void realizarBindingsProductoAux ( Bebida producto) {
        Bindings.bindBidirectional(txtLinea.textProperty(), txtEncargo.valueProperty(), new LocalDateStringConverter());
        txtID.textProperty().bindBidirectional(producto.IDProperty(), new NumberStringConverter());
        txtNombre.textProperty().bindBidirectional(producto.NombreProperty());
        txtPrecio.textProperty().bindBidirectional(producto.PrecioProperty(), new NumberStringConverter());
        txtCantidad.textProperty().bindBidirectional(producto.CantidadProperty(),new NumberStringConverter());
        txtLinea.textProperty().bindBidirectional(producto.ProxEncargoProperty());
    }



    @javafx.fxml.FXML
    public void onActualizarClicked(ActionEvent actionEvent) {

        if (!productoAux.getNombre().trim().equals("")) {
            if (BebidaDAO.actualizarBebida(productoAux)) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Se ha actualizado exitosamente la bebida con el código '"
                        + productoAux.getID() + "' .", ButtonType.OK);
                alert.showAndWait();

            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "No se ha encontrado un producto con el código '"
                        + productoAux.getID() + "' .", ButtonType.OK);
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Debe indicar el código del producto a actualizar.", ButtonType.OK);
            alert.showAndWait();
        }
    }

    @FXML
    public void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }



}

