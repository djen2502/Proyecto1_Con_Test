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
import org.testfx.matcher.control.TextInputControlMatchers;

import java.io.IOException;

//import static org.testfx.util.NodeQueryUtils.hasTest
@ExtendWith(ApplicationExtension.class)
class BusquedaTest {


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
    void validarEscribirValorEncampoTexto(FxRobot robot) throws InterruptedException {
        robot.clickOn("#txtNombre1");
        robot.write("sa");
        // robot.wait(50000);
        FxAssert.verifyThat("#txtNombre1", TextInputControlMatchers.hasText("sa"));
        robot.clickOn("#buttonBNombre");
    }

    @Test
    void validarEscribirValorEncampoTexto2(FxRobot robot) throws InterruptedException {
        robot.clickOn("#txtNombre1");
        robot.write("David");
        // robot.wait(50000);
        FxAssert.verifyThat("#txtNombre1", TextInputControlMatchers.hasText("David"));
        robot.clickOn("#buttonBNombre");

    }



}