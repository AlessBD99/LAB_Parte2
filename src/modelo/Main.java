//PAREJA: ALESSANDRO BERARDI Y YAMIL GULO
package modelo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        Validación validar = new Validación ();
        int bandera = 0;
        int seleccion = 0;
        Gimnasio gym = new Gimnasio("Gold Gym", "Michael Jackson");

        //MENU DE OPCIONES 
        do {
            do {

                System.out.println("\n******************** MENU DE OPCIONES *********************** ");
                System.out.println(" 1.Deportista  ");
                System.out.println(" 2.Entrenador  ");
                System.out.println(" 3.Gimnasio  ");
                System.out.println(" 4.Salir  ");
                System.out.println(" ************************************************************* ");
                seleccion = validar.validarExpresionNumericoMenu();

                System.out.println(" ");

                if (seleccion >= 1 && seleccion <= 4 ) {
                    bandera = 1;

                } else if (seleccion > 4 || seleccion <= 0) {

                    System.out.println(" ****************************************************** ");
                    System.out.println(" Opcion no valida ");
                    System.out.print(" ****************************************************** ");

                }

            } while (bandera == 0);

            switch (seleccion) {
                case 1:
                    gym.registrarDeportista();
                    System.out.println(" ");
                    break;
                case 2:
                    gym.registrarEntrenador();
                    System.out.println(" ");
                    break;
                case 3:
                    //Se imprime los datos de las Personas almacenadas en el vector del Gimnasio
                    if (gym.verTamaño() != 0) {
                        gym.imprimirPersonas();
                    } else {
                        System.out.println(" Gimnasio vacío ");
                    }   break;
                case 4:
                    System.out.println(" ****************************************************** ");
                    System.out.println(" ¡ Gracias ! , vuelva pronto  ");
                    System.out.println(" ****************************************************** ");
                    bandera = 2;
                    break;
                default:
                    break;
            }

        } while (bandera != 2);
    }
}
