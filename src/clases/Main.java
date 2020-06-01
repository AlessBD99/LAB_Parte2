//PAREJA: ALESSANDRO BERARDI Y YAMIL GULO
package clases;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int bandera = 0;
        int seleccion = 0;

        //Creacion de objetos de tipo Entrenador, de tipo Deportista y de tipo Gimnasio
        Entrenador ent = new Entrenador();
        Deportista dep = new Deportista();
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

                //Leer datos de Deportista
                System.out.println("\n----DATOS A INGRESAR DEL DEPORTISTA----");
                dep.leerDatosPer();
                //Imprimir datos de Deportista
                dep.imprimirDatosPer();
                System.out.println(" ");
                //Recomendar si hacer o no hacer entrenamiento hoy segun su ritmo cardiaco al Deportista 
                dep.verificarRitmoCardiacoAlto();
                System.out.println(" ");

            } else if (seleccion == 2) {

                //Leer datos del Entrenador
                System.out.println("\n----DATOS A INGRESAR DEL ENTRENADOR----");
                ent.leerDatosPer();
                System.out.println(" ");
                //Imprimir datos del Entrenador
                ent.imprimirDatosPer();
                System.out.println(" ");
                //Leer datos de Deportista
                if (dep.getCedula() == 0) {
                    System.out.println("\n----DATOS A INGRESAR DEL DEPORTISTA----");
                    dep.leerDatosPer();
                }
                //Imprimir datos de Deportista
                dep.imprimirDatosPer();
                //Recomendar si hacer o no hacer entrenamiento hoy segun su ritmo cardiaco al Deportista 
                dep.verificarRitmoCardiacoAlto();
                //Determinar la rutina en base al IMC, Tipo de ejercicio y grasa corporal
                ent.determinarRutina(dep.imcDeportista(), dep.calcularIMC(), dep.getTipoEjercicio());
                System.out.println(" ");
                //Determinar la rutina en base al Tipo de Ejercicio suministrado
                ent.determinarRutina(dep.getTipoEjercicio());
                System.out.println(" ");

            } else if (seleccion == 3) {

                //Se valida si ya hay un Deportista registrado antes de agregar al vector
                if (dep.getCedula() != 0) {
                    //Se inserta el objeto dep de la clase Deportista en el vector del Gimnasio
                    gym.setPersona(dep);
                }

                //Se valida si ya hay un Entrenador registrado antes de agregar al vector
                if (ent.getCedula() != 0) {
                    //Se inserta el objeto ent de la clase Entrenador en el vector del Gimnasio
                    gym.setPersona(ent);
                }

                //Se imprime los datos de las Personas almacenadas en el vector del Gimnasio
                gym.imprimirGimnasioPersonas();

            } else if (seleccion == 4) {

                System.out.println(" ");
                System.out.println(" ****************************************************** ");
                System.out.println(" ¡ Gracias ! , vuelva pronto  ");
                System.out.println(" ****************************************************** ");
                bandera = 2;
            }

        } while (bandera != 2);
    }
}
