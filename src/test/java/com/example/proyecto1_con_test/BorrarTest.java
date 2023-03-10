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

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(ApplicationExtension.class)
class BorrarTest {

    String valor ="1";
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
    void borrar(FxRobot robot) {

        robot.clickOn("#txtID");
        robot.write(valor.toString());
        robot.clickOn("#borrar");
        robot.clickOn("Sí");
        robot.clickOn("Aceptar");

    }

}