package com.example.proyecto1_con_test;

import com.example.proyecto1_con_test.DAO.BebidaDAO;
import com.example.proyecto1_con_test.controladores.Detalle;
import com.example.proyecto1_con_test.modelos.Bebida;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.converter.LocalDateStringConverter;
import javafx.util.converter.NumberStringConverter;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class HelloController {

    @FXML
    private BebidaDAO BebidaDAO = new BebidaDAO();
    @FXML
    private Bebida productoAux;
    @FXML
    private ObservableList<Bebida> datos;



    @FXML
    private TextField txtID;
    @FXML
    private TableView tvBebidas;
    @FXML
    private TextField txtNombre;

    @FXML
    private TableColumn tcID;
    @FXML
    private TableColumn tcNombre;
    @FXML
    private TableColumn tcPrecio;
    @FXML
    private TableColumn tcCantidad;
    @FXML
    private TableColumn tcProxEncargo;


    public void initialize()  {

        cargarDatosTabla();

        productoAux = new Bebida(0, "", 0d,
                0, "");

        realizarBindingsProductoAux(productoAux);
        cargarGestorCLick();
        onAbrirDetalle();


    }


    @FXML
    private void buscarBebidaID() {
        datos = BebidaDAO.obtenerProductos();

        System.out.println(datos.size());

        Predicate<Bebida> Filtro = i -> i.getID().toString().equals(txtID.getText());

        tcID.setCellValueFactory(new PropertyValueFactory<Bebida, Integer>("ID"));
        tcNombre.setCellValueFactory(new PropertyValueFactory<Bebida, String>("Nombre"));
        tcPrecio.setCellValueFactory(new PropertyValueFactory<Bebida, Double>("Precio"));
        tcCantidad.setCellValueFactory(new PropertyValueFactory<Bebida, Integer>("Cantidad"));
        tcProxEncargo.setCellValueFactory(new PropertyValueFactory<Bebida, String>("ProxEncargo"));


        FilteredList<Bebida> items = new FilteredList<>(datos);
        tvBebidas.setItems(items);
        Predicate<Bebida> filter = Filtro;
        items.setPredicate(filter);

    }

    @FXML
    private void buscarBebidaNombre(){
        datos = BebidaDAO.obtenerProductos();

        System.out.println(datos.size());

        Predicate<Bebida> Filtro = i -> i.getNombre().equals(txtNombre.getText());

        tcID.setCellValueFactory(new PropertyValueFactory<Bebida, Integer>("ID"));
        tcNombre.setCellValueFactory(new PropertyValueFactory<Bebida, String>("Nombre"));
        tcPrecio.setCellValueFactory(new PropertyValueFactory<Bebida, Double>("Precio"));
        tcCantidad.setCellValueFactory(new PropertyValueFactory<Bebida, Integer>("Cantidad"));
        tcProxEncargo.setCellValueFactory(new PropertyValueFactory<Bebida, String>("ProxEncargo"));


        FilteredList<Bebida> items = new FilteredList<>(datos);
        tvBebidas.setItems(items);
        Predicate<Bebida> filter = Filtro;
        items.setPredicate(filter);
    }

    @FXML
    private void cargarDatosTabla () {

        datos = BebidaDAO.obtenerProductos();

        System.out.println(datos.size());

        tcID.setCellValueFactory(new PropertyValueFactory<Bebida, Integer>("ID"));
        tcNombre.setCellValueFactory(new PropertyValueFactory<Bebida, String>("Nombre"));
        tcPrecio.setCellValueFactory(new PropertyValueFactory<Bebida, Double>("Precio"));
        tcCantidad.setCellValueFactory(new PropertyValueFactory<Bebida, Integer>("Cantidad"));
        tcProxEncargo.setCellValueFactory(new PropertyValueFactory<Bebida, String>("ProxEncargo"));


        tvBebidas.setItems(datos);
    }



    //Abre nueva ventana para dar la alta
    @FXML
    protected void onAbrirAlta(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("alta.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setTitle("Agregar");
            stage.setScene(new Scene(root1));
            stage.show();
            stage.setOnHiding( event -> {cargarDatosTabla();} );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        cargarDatosTabla();
    }



    //Abre nueva ventana para hacer la edicion
    @FXML
    protected void onAbrirEdicion(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("edicion.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Editar");
            stage.setResizable(false);
            stage.setScene(new Scene(root1));
            stage.show();
            stage.setOnHiding( event -> {cargarDatosTabla();} );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    //Abre nueva ventana para abrir los detalles
    @FXML
    private void onAbrirDetalle() {
        tvBebidas.setRowFactory(tv -> {
            TableRow<Bebida> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    try {

                        Node node = (Node) event.getSource();
                        Stage stage = (Stage) node.getScene().getWindow();


                        Bebida u = new Bebida(row.getItem().getID(), row.getItem().getNombre(), row.getItem().getPrecio(), row.getItem().getCantidad(), row.getItem().getProxEncargo());


                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Detalle.fxml"));
                        Parent root1 = (Parent) fxmlLoader.load();

                        stage.setUserData(u);
                        stage.setResizable(false);
                        stage.setTitle("Detalles");
                        Scene scene = new Scene(root1);
                        stage.setScene(scene);
                        stage.show();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            return row;
        });
    }















    // Detectar el doble click en la tabla y cargar los datos en los campos de edición
    private void cargarGestorCLick () {
        tvBebidas.setRowFactory(tv -> {
            TableRow<Bebida> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (!row.isEmpty())) {
                    productoAux.setID(row.getItem().getID());
                    productoAux.setNombre(row.getItem().getNombre());
                    productoAux.setPrecio(row.getItem().getPrecio());
                    productoAux.setCantidad(row.getItem().getCantidad());
                    productoAux.setProxEncargo(row.getItem().getProxEncargo());

                }
            });
            return row;
        });
    }



    private void realizarBindingsProductoAux ( Bebida producto) {

        txtID.textProperty().bindBidirectional(producto.IDProperty(),new NumberStringConverter());
        txtNombre.textProperty().bindBidirectional(producto.NombreProperty());

    }


    @FXML
    public void onBorrarClicked(ActionEvent actionEvent) {

        Alert alert;

        if ( ! productoAux.getID().equals("") || productoAux.getID()!=null ) {

            alert = new Alert(Alert.AlertType.CONFIRMATION, "¿ Desea borrar el producto con el código '"
                    + productoAux.getID() + "' ?.", ButtonType.YES, ButtonType.NO );

            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {

                if (BebidaDAO.borrarBebida(productoAux)) {
                    cargarDatosTabla();
                } else {
                    alert = new Alert(Alert.AlertType.INFORMATION, "No se ha encontrado un producto con el código '"
                            + productoAux.getID() + "' .", ButtonType.OK );
                    alert.showAndWait();
                }
            }
        }
        else {
            alert = new Alert(Alert.AlertType.INFORMATION, "Debe indicar el código del producto a borrar.", ButtonType.OK );
            alert.showAndWait();
        }
    }


}
