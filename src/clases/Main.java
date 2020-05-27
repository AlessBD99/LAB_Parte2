//PAREJA: ALESSANDRO BERARDI Y YAMIL GULO
package clases;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int bandera = 0;
        int seleccion = 0;

        //Creacion de los objetos
        Persona paciente1 = new Persona(26250408, "Yamil", 21, 'M', 120, 1.80, "CATIA");
        paciente1.esMayorDeEdad();
        //Impresion de datos
        System.out.println("\n----DATOS DEL PACIENTE 1----");
        paciente1.imprimirDatosPer();
        paciente1.diagnosticoIMC();

        //Creacion del objeto 2
        Persona paciente2 = new Persona();
        System.out.println("\n----DATOS A INGRESAR DEL PACIENTE 2----");
        //Solicita los datos
        paciente2.leerDatosPer();
        //Se le cambia la Direccion usando un Metodo Setter
        paciente2.setDireccion("CARACAS");
        //Impresion de datos
        System.out.println("\n----DATOS DEL PACIENTE 2----");
        paciente2.imprimirDatosPer();
        paciente2.diagnosticoIMC();

        //Creacion de objetos de tipo Entrenador y de tipo Deportista
        
        Entrenador ent = new Entrenador();
        Deportista dep = new Deportista();

        //MENU DE OPCIONES 
        do {
            do {

                System.out.println(" ******************** MENU DE OPCIONES *********************** ");
                System.out.println(" 1.Deportista  ");
                System.out.println(" 2.Entrenador  ");
                System.out.println(" 3.Salir  ");
                System.out.println(" ************************************************************* ");
                System.out.print(" Seleccione una opcion : ");
                seleccion = entrada.nextInt();
                System.out.println(" ");

                if (seleccion >= 1 && seleccion <= 3) {
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
                System.out.println("\n----DATOS DEL DEPORTISTA----");
                dep.imprimirDatosPer();
                System.out.println(" ");
                //Recomendar si hacer o no hacer entrenamiento hoy segun su ritmo cardiaco al Deportista 
                dep.verificarRitmoCardiacoAlto();
                dep.diagnosticoPorcentajeGrasa(dep.calcularIMC());
                System.out.println(" ");
                
            } else if (seleccion == 2) {
                
                //Leer datos del Entrenador
                System.out.println("\n----DATOS A INGRESAR DEL ENTRENADOR----");
                ent.leerDatosPer();
                System.out.println(" ");
                //Imprimir datos del Entrenador
                System.out.println("\n----DATOS DEL ENTRENADOR----");
                ent.imprimirDatosPer();
                System.out.println(" ");
                //Leer datos de Deportista
                System.out.println("\n----DATOS A INGRESAR DEL DEPORTISTA----");
                dep.leerDatosPer();
                //Imprimir datos de Deportista
                System.out.println("\n----DATOS DEL DEPORTISTA----");
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
                
                System.out.println(" ");
                System.out.println(" ****************************************************** ");
                System.out.println(" ¡ Gracias ! , vuelva pronto  ");
                System.out.println(" ****************************************************** ");
                bandera = 2;
            }

        } while (bandera != 2);
    }
}
