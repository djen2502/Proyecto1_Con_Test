package com.example.proyecto1_con_test.DAO;

import com.example.proyecto1_con_test.modelos.Bebida;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;


public class BebidaDAO {


    private final String servidor = "jdbc:mariadb://localhost:5555/noinch?useSSL=false";
    private final String usuario = "adminer";
    private final String passwd = "adminer";

    private Connection conexionBBDD;

    public ObservableList<Bebida> obtenerProductos() {

        ObservableList<Bebida> datosResultadoConsulta = FXCollections.observableArrayList();
        try {
            // Nos conectamos
            conexionBBDD = DriverManager.getConnection(servidor, usuario, passwd);
            String SQL = "SELECT * "
                    + "FROM bebida "
                    + "ORDER By ID";

            // Ejecutamos la consulta y nos devuelve una matriz de filas (registros) y columnas (datos)
            ResultSet resultadoConsulta = conexionBBDD.createStatement().executeQuery(SQL);

            // Debemos cargar los datos en el ObservableList (Que es un ArrayList especial)
            // Los datos que devuelve la consulta no son directamente cargables en nuestro objeto
            while (resultadoConsulta.next()) {
                datosResultadoConsulta.add(new Bebida(
                        resultadoConsulta.getInt("ID"),
                        resultadoConsulta.getString("Nombre"),
                        resultadoConsulta.getDouble("Precio"),
                        resultadoConsulta.getInt("Cantidad"),
                        resultadoConsulta.getString("ProxEncargo"))
                );
                System.out.println("Row [1] added " + resultadoConsulta.toString());
            }
            conexionBBDD.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error:" + e.toString());
            conexionBBDD.close();
        } finally {
            return datosResultadoConsulta;
        }
    }



    // Alta de un nuevo bebida
    //
    public Boolean altaBebida(Bebida bebida) {

        int registrosAfectadosConsulta = 0;

        try {
            // Nos conectamos
            conexionBBDD = DriverManager.getConnection(servidor, usuario, passwd);
            String SQL = "INSERT INTO bebida ("
                    + " Nombre ,"
                    + " Precio ,"
                    + " Cantidad ,"
                    + " ProxEncargo )"
                    + " VALUES ( ?, ?, ?, ?)";

            PreparedStatement st = conexionBBDD.prepareStatement(SQL);
            st.setString(1, bebida.getNombre());
            st.setDouble(2, bebida.getPrecio());
            st.setInt(3, bebida.getCantidad());
            st.setString(4, bebida.getProxEncargo().toString());


            // Ejecutamos la consulta preparada (con las ventajas de seguridad y velocidad en el servidor de BBDD
            // nos devuelve el número de registros afectados. Al ser un Insert nos debe devolver 1 si se ha hecho correctamente
            registrosAfectadosConsulta = st.executeUpdate();
            st.close();
            conexionBBDD.close();

            if (registrosAfectadosConsulta == 1) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error:" + e.toString());
            return false;
        }
    }

    // Actualizar un producto existente
    //
    public Boolean actualizarBebida(Bebida bebida) {

        int registrosAfectadosConsulta = 0;

        try {
            // Nos conectamos
            conexionBBDD = DriverManager.getConnection(servidor, usuario, passwd);
            String SQL = "UPDATE bebida "
                    + " SET "
                    + " Nombre = ? ,"
                    + " Precio = ? ,"
                    + " Cantidad = ? ,"
                    + " ProxEncargo = ? "
                    + " WHERE ID = ? ";

            PreparedStatement st = conexionBBDD.prepareStatement(SQL);

            st.setString(1, bebida.getNombre());
            st.setDouble(2, bebida.getPrecio());
            st.setInt(3, bebida.getCantidad());
            st.setString(4, bebida.getProxEncargo().toString());

            st.setInt(5, bebida.getID());

            // Ejecutamos la consulta preparada (con las ventajas de seguridad y velocidad en el servidor de BBDD
            // nos devuelve el número de registros afectados. Al ser un Update nos debe devolver 1 si se ha hecho correctamente
            registrosAfectadosConsulta = st.executeUpdate();
            st.close();
            conexionBBDD.close();

            if (registrosAfectadosConsulta == 1) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error:" + e.toString());
            return false;
        }
    }
    // Actualizar un producto existente
    //
    public Boolean borrarBebida(Bebida bebida) {

        int registrosAfectadosConsulta = 0;

        try {
            // Nos conectamos
            conexionBBDD = DriverManager.getConnection(servidor, usuario, passwd);
            String SQL = "DELETE FROM bebida "
                    + " WHERE ID = ? ";

            PreparedStatement st = conexionBBDD.prepareStatement(SQL);

            st.setInt(1, bebida.getID());

            // Ejecutamos la consulta preparada (con las ventajas de seguridad y velocidad en el servidor de BBDD
            // nos devuelve el número de registros afectados. Al ser un Delete nos debe devolver 1 si se ha hecho correctamente
            registrosAfectadosConsulta = st.executeUpdate();
            st.close();
            conexionBBDD.close();

            if (registrosAfectadosConsulta == 1) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error:" + e.toString());
            return false;
        }
    }



}
