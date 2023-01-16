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

    Bebida bebida1 = new Bebida(1,"Saapo",2.0,10,"4/1/2023");


    @Test
    public void alta(){


        System.out.println("-----> Existen "+dao.obtenerProductos().size()+" productos antes de la operacion.");
        assertEquals(true, dao.altaBebida(bebida1));
        System.out.println("-----> Existen "+dao.obtenerProductos().size()+" productos despues de la operacion.");

        dao.obtenerProductos().forEach((cif -> {
            if(bebida1.getNombre().equals(cif.getNombre()) && bebida1.getCantidad().equals(cif.getCantidad()) && bebida1.getPrecio().equals(cif.getPrecio()) && bebida1.getProxEncargo().equals(cif.getProxEncargo())){
                System.out.println(cif);
            }

        }));
    }

}