module com.example.proyecto1_con_test {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.mariadb.jdbc;


    opens com.example.proyecto1_con_test to javafx.fxml;
    exports com.example.proyecto1_con_test;
    opens com.example.proyecto1_con_test.controladores to javafx.fxml;
    exports com.example.proyecto1_con_test.controladores;
    opens com.example.proyecto1_con_test.modelos to javafx.fxml;
    exports com.example.proyecto1_con_test.modelos;
}