package com.cristian.bit_currency.principal;

import com.cristian.bit_currency.excepcion.ErrorValorAConvertirException;
import com.cristian.bit_currency.modelos.Conversor;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws Exception {
        Scanner user_entrance = new Scanner(System.in);

        Conversor convertidor = new Conversor();

        while (true){
            try {
                System.out.println("Bienvenido a tu conversor mundial de monedas");
                System.out.println(convertidor.menu());
                int option = user_entrance.nextInt();

                if (option != 13 && option != 14){
                    String operador = convertidor.operador(option);
                    System.out.println(operador);
                }

                if(option < 1 || option > 14 ){
                    throw new ErrorValorAConvertirException("El valor que ingresaste no es correcto");
                } else if (option == 13) {
                    //metodo para solo mostrar la lista de operaciones
                    convertidor.mostrarLista();
                    System.out.println("/////////////////////////////////\n");
                } else if (option == 14) {
                    //Mostrar lista y salir
                    convertidor.mostrarLista();
                    System.out.println("Hasta pronto :)");
                    System.out.println("/////////////////////////////////\n");
                    break;
                }

            }catch (ErrorValorAConvertirException e){
                System.out.println(e.getMessage());
            }catch (InputMismatchException e){
                System.out.println("El valor ingresado no es un número");//    En caso de que ingrese un string
                break;
            }

        }

    }
}
