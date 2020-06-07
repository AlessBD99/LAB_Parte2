package clases;

import java.util.Scanner;

public class Gimnasio {

    Entrenador entrenador = new Entrenador();

    //Atributos
    private String nombreGimnasio;
    private String nombreGerente;
    private Persona[] personas;
    private int cantidadDePersonas;

    //Constructores
    public Gimnasio(String nombreGimnasio, String nombreGerente) {
        this.nombreGimnasio = nombreGimnasio;
        this.nombreGerente = nombreGerente;
        personas = new Persona[1500];
        cantidadDePersonas = 0;
    }

    public Gimnasio() {
        nombreGimnasio = "";
        nombreGerente = "";
        cantidadDePersonas = 0;
    }

    //Metodos
    public Persona getPersona(int i) {
        //Permite consultar la Persona ubicado en la posición i del vector
        return personas[i];
    }

    public void setPersona(Persona per) {
        //Método que permitirá asociar el objeto Persona con su respectiva clase hija en el vector
        int i = cantidadDePersonas++;
        if (per instanceof Deportista) //la cláusula instance of permite determinar a que clase pertenece un objeto
        {
            personas[i] = (Deportista) per;
        } else {
            personas[i] = (Entrenador) per;
        }
    }

    public void llenarVectorDeportista() {
        //procedimiento que llena el vector varios deportistas a la vez 
        Scanner datos = new Scanner(System.in);
        int i = 1;
        System.out.print("Indica número de Deportistas a ser incorporados: ");

        while (!datos.hasNextInt()) {
            System.out.println(" ");
            System.out.println("ERROR : Ese no es un numero! Ingrese solo numeros");
            System.out.print("\nIndica número de Deportistas a ser incorporados: ");
            datos.next();
        }
        int n = datos.nextInt();

        while (i <= n) {

            Deportista Dep = new Deportista();

            Dep.leerDatosPer(); //Metodo que permite actualizar los atributos
            //Recomendar si hacer o no hacer entrenamiento hoy segun su ritmo cardiaco al Deportista 
            Dep.verificarRitmoCardiacoAlto();
            setPersona(Dep); //invoco al método que incorpora sólo a una persona
            i++;
            System.out.println(" ");
        }
    }

    public void llenarVectorEntrenador() {

        //procedimiento que llena el vector varios entrenadores a la vez 
        Scanner datos = new Scanner(System.in);
        int i = 1;
        System.out.print("Indica número de Entrenadores a ser incorporados: ");

        while (!datos.hasNextInt()) {
            System.out.println(" ");
            System.out.println("ERROR : Ese no es un numero! Ingrese solo numeros");
            System.out.print("\nIndica número de Entrenadores a ser incorporados: ");
            datos.next();
        }
        int n = datos.nextInt();

        while (i <= n) {

            Entrenador Ent = new Entrenador();
            Ent.leerDatosPer(); //Metodo que permite actualizar los atributos
            setPersona(Ent); //invoco al método que incorpora sólo a una persona
            i++;
            System.out.println(" ");
        }
    }

    public void imprimirGimnasioPersonas() {
        //Metodo que Imprime el vector con todas las personas del Gimnasio
        System.out.println(" ");
        if (verificaVectorVacio() == false) {
            System.out.println("***** Datos del Gimnasio *****");
            System.out.println("Nombre = " + nombreGimnasio + " Gerente = " + nombreGerente);
            System.out.println(" ");

            for (int i = 0; i < cantidadDePersonas; i++) {
                if (personas[i] instanceof Deportista) {
                    Deportista dep = (Deportista) personas[i]; //Compara si el objeto que está en una casilla determinada es de tipo Deportista
                    System.out.println(" ---- DATOS DEL DEPORTISTA " + (i + 1) + "----");
                    dep.imprimirDatosPer(); //Imprime los atributos del objeto entrenador
                    //Determinar la rutina en base al IMC, Tipo de ejercicio y grasa corporal
                    entrenador.determinarRutina(dep.imcDeportista(), dep.calcularIMC(), dep.getTipoEjercicio());
                    //Determinar la rutina en base al Tipo de Ejercicio suministrado
                    entrenador.determinarRutina(dep.getTipoEjercicio());
                }

                if (personas[i] instanceof Entrenador) {

                    Entrenador ent = (Entrenador) personas[i]; //Compara si el objeto que está en una casilla determinada es de tipo Entrenador
                    System.out.println(" ---- DATOS DEL ENTRENADOR " + (i + 1) + "----");
                    ent.imprimirDatosPer(); //Imprime los atributos del objeto entrenador
                }
                System.out.println(" ");
            }
        } else {//Si trata de imprimir el vector de Personas del Gym pero esta vacio
            System.out.println("\nNo hay peronas almacenadas en el Gimnasio");
        }

    }

    public boolean verificaVectorVacio() {
        //Comprueba si el vector esta vacio
        if (cantidadDePersonas == 0) {
            return true;
        } else {
            return false;
        }
    }

    //Getters y Setters
    public String getNombreGimnasio() {
        return nombreGimnasio;
    }

    public void setNombreGimnasio(String nombreGimnasio) {
        this.nombreGimnasio = nombreGimnasio;
    }

    public String getNombreGerente() {
        return nombreGerente;
    }

    public void setNombreGerente(String nombreGerente) {
        this.nombreGerente = nombreGerente;
    }

    public Persona[] getPersonas() {
        return personas;
    }

    public void setPersonas(Persona[] personas) {
        this.personas = personas;
    }

    public int getCantidadDePersonas() {
        return cantidadDePersonas;
    }

    public void setCantidadDePersonas(int cantidadDePersonas) {
        this.cantidadDePersonas = cantidadDePersonas;
    }

}
