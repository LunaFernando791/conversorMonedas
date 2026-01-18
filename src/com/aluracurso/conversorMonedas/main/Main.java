package com.aluracurso.conversorMonedas.main;

import com.aluracurso.conversorMonedas.service.Conversor;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Conversor converter = new Conversor();
        converter.userMenu();
        System.out.println("¡Gracias por usar el conversor de monedas!");
    }
}