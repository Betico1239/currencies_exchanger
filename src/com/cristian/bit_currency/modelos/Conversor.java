package com.cristian.bit_currency.modelos;

import com.cristian.bit_currency.excepcion.ErrorValorAConvertirException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;


public class Conversor {
    private ArrayList<Operator> historial_operaciones = new ArrayList<>();//Para llevar un historial
    private List<Float> valores = new ArrayList<>(); //vector para guardar los valores que se han convertido
    private  List<LocalDateTime> fechas = new ArrayList<>();

    public String operador(int opcion) throws Exception {
        var base = "";
        var target = "";
        var to_convert = 0.0;

        LocalDateTime fechaHoraActual = LocalDateTime.now();
        Scanner convertir = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##");

        var direccion = "";

        HttpResponse<String> response = null;

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        switch (opcion){
            case 1:
                //de DOLAR a PESO ARGENTINO
                base = "USD";
                target = "ARS";
                break;
            case 2:
                //de PESO ARGENTINO a DOLAR
                base = "ARS";
                target = "USD";
                break;
            case 3:
                //de DOLAR a REAL BRASILEÑO
                base = "USD";
                target = "BRL";
                break;
            case 4:
                //de REAL BRASILEÑO a DOLAR
                base = "BRL";
                target = "USD";
                break;
            case 5:
                //de PESO COLOMBIANO a DOLAR
                base = "COP";
                target = "USD";
                break;
            case 6:
                //de DOLAR a PESO COLOMBIANO
                base = "USD";
                target = "COP";
                break;
            case 7:
                //de PESO CHILENO a DOLAR
                base = "CLP";
                target = "USD";
                break;
            case 8:
                //de DOLAR a PESO CHILENO
                base = "USD";
                target = "CLP";
                break;
            case 9:
                //de EURO a DOLAR
                base = "EUR";
                target = "USD";
                break;
            case 10:
                //de DOLAR a EURO
                base = "USD";
                target = "EUR";
                break;
            case 11:
                //de RUPIA INDIA a PESO COLOMBIANO
                base = "INR";
                target = "COP";
                break;
            case 12:
                //de YENES a PESO COLOMBIANO
                base = "JPY";
                target = "COP";
                break;
            default:
                System.out.println("Algo salió mal en el switch");
                throw new ErrorValorAConvertirException("El valor que ingresaste no es correcto");

        }

        System.out.println("Digita el valor en " +"[" + base + "]'s " +" que deseas convertir a "
                + "[" + target + "]'s " + "ejemplo(25.19)");

        to_convert = convertir.nextFloat();

        direccion= "https://v6.exchangerate-api.com/v6/d680848942394dc669d09538/pair/"
                + base + "/" + target + "/" + to_convert;

        //Validar las monedas de cambio

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();

            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        }catch (InputMismatchException e){
            System.out.println("El valor ingresado no es correcto, verifica que sea flotante o entero");
        } catch (Exception e){
            throw new Exception();
        }
        assert response != null;

        var json =  gson.fromJson(response.body(), Operator.class);

        historial_operaciones.add(json);
        valores.add((float) to_convert);
        fechas.add(fechaHoraActual);

        var valor_convertido =  df.format(Float.parseFloat(json.conversion_result()));

        return "El valor de " + Float.parseFloat(df.format(to_convert))  +" " + "[" +json.base_code()+ "]"
                +" " + "refiere a un valor final de " + valor_convertido + " " + "[" + json.target_code() + "]";
    }

    public String menu(){
        return """
                ************************************
                Digita el valor correspondiente a la operación que quieres realizar:
                1) Dólar => Peso Argentino
                2) Peso Argentino => Dólar
                3) Dólar => Real Brasileño
                4) Real Brasileño => Dólar
                5) Peso Colombiano => Dólar
                6) Dólar => Peso Colombiano
                7) Peso Chileno => Dólar
                8) Dólar => Peso Chileno
                9) Euro => Dólar
                10) Dólar => Euro
                11) Rupia India => Peso Colombiano
                12) Yenes => Peso Colombiano
                13) Mostrar historial de operaciones
                14) Salir
                *************************************
                \n""";
    }

    public ArrayList<Operator> getHistorial_operaciones() {
        return historial_operaciones;
    }

    public List<Float> getValores() {
        return valores;
    }

    public List<LocalDateTime> getFechas() {
        return fechas;
    }

    public void mostrarLista() {
        System.out.println("\nHistorial de operaciones");
        System.out.println("//////////////////////////////");
        for (int i = 0; i < getHistorial_operaciones().size(); i++) {
            System.out.println("El valor de " + getValores().get(i) + " [" +
                    getHistorial_operaciones().get(i).base_code() + "] dió un resultado de " +
                    getHistorial_operaciones().get(i).conversion_result() + " [" +
                    getHistorial_operaciones().get(i).target_code() + "]. Fecha de consulta: " + getFechas().get(i));
        }
    }
}
