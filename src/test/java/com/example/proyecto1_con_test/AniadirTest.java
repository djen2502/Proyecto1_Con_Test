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
import org.testfx.matcher.control.TableViewMatchers;
import org.testfx.matcher.control.TextInputControlMatchers;

import java.io.IOException;

//import static org.testfx.util.NodeQueryUtils.hasTest

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(ApplicationExtension.class)
class AniadirTest {

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




    @Test
    void aniadir(FxRobot robot) {
        robot.clickOn("#aniadir");
        robot.clickOn("#txtNombre");
        robot.write("David");
        FxAssert.verifyThat("#txtNombre", TextInputControlMatchers.hasText("David"));
        robot.doubleClickOn("#txtPrecio");
        robot.write("2");
        FxAssert.verifyThat("#txtPrecio", TextInputControlMatchers.hasText("2"));
        robot.doubleClickOn("#txtCantidad");
        robot.write("10");
        FxAssert.verifyThat("#txtCantidad", TextInputControlMatchers.hasText("10"));
        robot.clickOn("#txtEncargo");
        robot.write("4/1/2023");
        robot.clickOn("#aniadirButton");
        robot.clickOn("Aceptar");
        robot.clickOn("Cancelar");
        FxAssert.verifyThat("#tvBebidas", TableViewMatchers.containsRow(1, "David", 2.0, 10, "4/1/2023"));
    }


    @Test
    void aniadir2(FxRobot robot) {
        robot.clickOn("#aniadir");
        robot.doubleClickOn("#txtPrecio");
        robot.write("2");
        FxAssert.verifyThat("#txtPrecio", TextInputControlMatchers.hasText("2"));
        robot.doubleClickOn("#txtCantidad");
        robot.write("10");
        FxAssert.verifyThat("#txtCantidad", TextInputControlMatchers.hasText("10"));
        robot.clickOn("#txtEncargo");
        robot.write("4/1/2023");
        robot.clickOn("#aniadirButton");
        robot.clickOn("Aceptar");
        robot.clickOn("Cancelar");
    }

}