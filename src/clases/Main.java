//PAREJA: ALESSANDRO BERARDI Y YAMIL GULO
package clases;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int bandera = 0;
        int seleccion = 0;

        Gimnasio gym = new Gimnasio("Gold Gym", "Michael Jackson");

        //MENU DE OPCIONES 
        do {
            do {

                System.out.println(" \n\n******************** MENU DE OPCIONES *********************** ");
                System.out.println(" 1.Deportista  ");
                System.out.println(" 2.Entrenador  ");
                System.out.println(" 3.Gimnasio  ");
                System.out.println(" 4.Salir  ");
                System.out.println(" ************************************************************* ");
                System.out.print(" Seleccione una opcion : ");

                while (!entrada.hasNextInt()) {
                    System.out.println(" ");
                    System.out.println("ERROR : Ese no es un numero! Ingrese solo numeros");
                    System.out.print("\n Seleccione una opcion : ");
                    entrada.next();
                }
                seleccion = entrada.nextInt();

                System.out.println(" ");

                if (seleccion >= 1 && seleccion <= 4) {
                    bandera = 1;

                } else if (seleccion > 4) {

                    System.out.println(" ****************************************************** ");
                    System.out.println(" Opcion no valida ");
                    System.out.println(" ****************************************************** ");

                }

            } while (bandera == 0);

            if (seleccion == 1) {

                gym.llenarVectorDeportista();
                System.out.println(" ");

            } else if (seleccion == 2) {

                gym.llenarVectorEntrenador();
                System.out.println(" ");

            } else if (seleccion == 3) {

//                //Se imprime los datos de las Personas almacenadas en el vector del Gimnasio
                gym.imprimirGimnasioPersonas();

            } else if (seleccion == 4) {

                System.out.println(" ****************************************************** ");
                System.out.println(" ¡ Gracias ! , vuelva pronto  ");
                System.out.println(" ****************************************************** ");
                bandera = 2;
            }

        } while (bandera != 2);
    }
}
