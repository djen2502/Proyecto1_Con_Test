package com.example.proyecto1_con_test;

import com.example.proyecto1_con_test.DAO.BebidaDAO;
import com.example.proyecto1_con_test.modelos.Bebida;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(ApplicationExtension.class)
class BorrarTestUni {

    BebidaDAO dao = new BebidaDAO();

    Bebida bebida1 = new Bebida(26,"David",2.0,10,"4/1/2023");


    @Test
    public void borra(){

        assertEquals(true, dao.borrarBebida(bebida1));
    }



}