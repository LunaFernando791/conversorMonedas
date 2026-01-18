package com.aluracurso.conversorMonedas.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.aluracurso.conversorMonedas.calculates.Calculator;
import com.aluracurso.conversorMonedas.models.Currency;

public class Conversor {
    String opc;
    Double amount = 0.0;
    Boolean isTrue = true;
    ApiConsume api = new ApiConsume();
    Scanner sc = new Scanner(System.in);
    Calculator calculator = new Calculator();
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void setOption(String opc)
    {
        this.opc = opc;
    }
    public void setIsTrue(Boolean isTrue)
    {
        this.isTrue = isTrue;
    }
    public void setAmount(Double amount)
    {
        this.amount = amount;
    }

    public void userMenu() throws IOException, InterruptedException {
        do {
            System.out.println(
                    """
                                   ******************************************************
                                    Sea bienvenido/a al Conversor de Moneda =]:
                                    1) Dolar =>> Peso Argentino
                                    2) Peso Argentino =>> Dolar
                                    3) Dolar =>> Real brasileño
                                    4) Real brasileño =>> Dolar
                                    5) Dolar =>> Peso Colombiano
                                    6) Peso Colombiano =>> Dolar
                                    7) Salir
                                    Elija una opción valida: "
                                    ******************************************************
                                   """
            );
            this.setOption(sc.nextLine());
            this.menuOptions();
        } while (isTrue);
    }
    private void menuOptions () throws IOException, InterruptedException {
        switch (this.opc) {
            case "1":
                processConversion("USD", "ARS");
                break;
            case "2" :
                processConversion("ARS", "USD");
                break;
            case "3" :
                processConversion("USD", "BRL");
                break;
            case "4" :
                processConversion("BRL", "USD");
                break;
            case "5" :
                processConversion("USD", "COP");
                break;
            case "6" :
                processConversion("COP", "USD");
                break;
            case "7" :
                System.out.println("Saliendo...");
                this.setIsTrue(false);
                break;
            default:
                System.out.println("Opción invalida, intentalo de nuevo");
                break;
        }
    }
    private void chooseAmount() {
        boolean incorrectLecture = false;

        while (!incorrectLecture) {
            try {
                System.out.println("Ingresa la cantidad: ");
                this.setAmount(sc.nextDouble());
                sc.nextLine();
                incorrectLecture = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número válido.");
                sc.nextLine();
            }
        }
    }
    private void processConversion(String base_code, String target_code) throws IOException, InterruptedException {
        this.chooseAmount();
        double resultado = this.conversion(base_code, target_code);
        System.out.printf("La conversión de $%.2f [%s] es =>> $%.2f [%s]%n",
                this.amount, base_code, resultado, target_code);
    }
    private double conversion(String base_code, String target_code) throws IOException, InterruptedException {
        Dotenv dotenv = Dotenv.load();
        String api_key = dotenv.get("EXCHANGE_RATE_API_KEY");
        String url = "https://v6.exchangerate-api.com/v6/"
                + api_key
                + "/pair/" +
                base_code +
                "/" +
                target_code;

        String json = api.getData(url);
        Currency currency = this.getData(json, Currency.class);
        return this.calculator.converter(this.amount, currency.conversion_rate());
    }

    public <T> T getData (String json, Class<T> classOfT)
    {
        return gson.fromJson(json, classOfT);
    }
}
