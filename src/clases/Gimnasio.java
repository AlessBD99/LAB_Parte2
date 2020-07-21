package clases;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;

public class Gimnasio {

    Validación numero = new Validación();
    Entrenador entrenador = new Entrenador();
    Deportista deportista = new Deportista();
    Scanner datos = new Scanner(System.in);

    //Atributos
    private String nombreGimnasio;
    private String nombreGerente;
    private ArrayList listaPersonas = new ArrayList<>();
    private int cantidadDePersonas;

    //Constructores
    public Gimnasio(String nombreGimnasio, String nombreGerente) {
        this.nombreGimnasio = nombreGimnasio;
        this.nombreGerente = nombreGerente;
        listaPersonas = new ArrayList<>();
        cantidadDePersonas = 0;
    }

    public Gimnasio() {
        nombreGimnasio = "";
        nombreGerente = "";
        cantidadDePersonas = 0;
    }

    //Metodos
    
    public ArrayList getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(ArrayList listaPersonas) {
        this.listaPersonas = listaPersonas;
    }
    
    public void registrarDeportista(Deportista emp) {
        
        listaPersonas.add(emp);
        
       
    }

    public void registrarEntrenador(Entrenador emp) {
        listaPersonas.add(emp);
    }

    public int verTamaño() {
        return listaPersonas.size();
    }

    public void registrarDeportista() {
        //procedimiento que llena el vector varios deportistas a la vez 
        
        int i = 1;
        int n = numero.validarExpresionNumericoGimnasio();

        while (i <= n) {

            Deportista Dep = new Deportista();
            Dep.leerDatosPer();
            registrarDeportista(Dep); //invoco al método que incorpora sólo a una persona
            i++;
        }
    }

    public void registrarEntrenador() {
        //procedimiento que llena el vector varios deportistas a la vez        
        int i = 1;
        int n = numero.validarExpresionNumericoGimnasio();
        
        while (i <= n) {

            Entrenador Ent = new Entrenador();
            Ent.leerDatosPer();
            registrarEntrenador(Ent); //invoco al método que incorpora sólo a una persona
            i++;
        }
    }

    public void imprimirPersonas() {
        Iterator<Persona> it = listaPersonas.iterator();
        int i = 0;
        System.out.println(" ------ LISTA DE PERSONAS ------  ");
        while (verTamaño() > i) {
            try {
                if (listaPersonas.get(i).getClass().getSimpleName().equals("Deportista")) {
                    Deportista dep = (Deportista) listaPersonas.get(i); //Compara si el objeto que está en una casilla determinada es de tipo Deportista
                    System.out.println(" ---- DATOS DEL DEPORTISTA ----  ");
                    dep.imprimirDatosPer(); //Imprime los atributos del objeto entrenador
                } else if (listaPersonas.get(i).getClass().getSimpleName().equals("Entrenador")) {
                    Entrenador ent = (Entrenador) listaPersonas.get(i); //Compara si el objeto que está en una casilla determinada es de tipo Entrenador
                    System.out.println(" ---- DATOS DEL ENTRENADOR ----  ");
                    ent.imprimirDatosPer(); //Imprime los atributos del objeto entrenador
                }
            } catch (Exception error) {
                System.out.println(" ----  Ha ocurrido un error ---- " + error);
            }

            i++;
            System.out.println(" ");
        }

    }
}
