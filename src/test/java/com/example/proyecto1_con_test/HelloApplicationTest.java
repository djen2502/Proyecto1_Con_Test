package com.example.proyecto1_con_test;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxAssert;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.control.ButtonMatchers;
import org.testfx.matcher.control.TextInputControlMatchers;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
//import static org.testfx.util.NodeQueryUtils.hasTest
@ExtendWith(ApplicationExtension.class)
class HelloApplicationTest {

    String valor ="11";

    FXMLLoader mainroot;
    Scene mainstage;


    @Start
    public void start(Stage stage) throws IOException {
        mainroot = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        mainstage = new Scene(mainroot.load(), 620, 600);
        stage.setTitle("Hello!");
        stage.setScene(mainstage);
        stage.show();
    }

/*
    @Test
    void validarEscribirValorEncampoTexto(FxRobot robot) throws InterruptedException {
        robot.clickOn("#txtNombre");
        robot.write("sa");
        // robot.wait(50000);
        FxAssert.verifyThat("#txtNombre", TextInputControlMatchers.hasText("sa"));
        robot.clickOn("#buttonBNombre");

    }

    @Test
    void validarEscribirValorEncampoTexto2(FxRobot robot) throws InterruptedException {
        robot.clickOn("#txtNombre");
        robot.write("David");
        // robot.wait(50000);
        FxAssert.verifyThat("#txtNombre", TextInputControlMatchers.hasText("David"));
        robot.clickOn("#buttonBNombre");

    }
*/
    @Test
    void aniadir(FxRobot robot) {
        robot.clickOn("#aniadir");
        robot.clickOn("#txtNombre");
        robot.write("David");
        robot.clickOn("#txtPrecio");
        robot.write("2");
        robot.clickOn("#txtCantidad");
        robot.write("10");
        robot.clickOn("#txtEncargo");
        robot.write("4/1/2023");
        robot.clickOn("#aniadirButton");
    }


    @Test
    void borrar(FxRobot robot) {
        robot.clickOn("#txtID");
        robot.write(valor.toString());
        robot.clickOn("#borrar");
        robot.clickOn("Sí");
        robot.clickOn("Aceptar");

    }

}