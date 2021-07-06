package com.andres.tp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TpApplication {


    public static void main(String[] args) {
        SpringApplication.run(TpApplication.class, args);
        System.out.println("Hola Mundo");
        System.out.println("Web Services Iniciado...");
    }

}
