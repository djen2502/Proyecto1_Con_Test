package com.example.proyecto1_con_test;

import com.example.proyecto1_con_test.DAO.BebidaDAO;
import com.example.proyecto1_con_test.modelos.Bebida;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(ApplicationExtension.class)
class AniadirTestUni {

    BebidaDAO dao = new BebidaDAO();

    Bebida bebida1 = new Bebida(26,"Saapo",200.0,10,"4/1/2023");


    @Test
    public void alta(){

        assertEquals(true, dao.altaBebida(bebida1));
    }

}