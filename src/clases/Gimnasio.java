package clases;

public class Gimnasio {

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

    public void imprimirGimnasioPersonas() {
        System.out.println("");
        if (verificaVectorVacio() == false) { 
            System.out.println("***** Datos del Gimnasio *****");
            System.out.println("Nombre = " + nombreGimnasio + "||| Gerente = " + nombreGerente);
            System.out.println("");
            System.out.println("******  Personas del Gimnasio  ******");
            for (int i = 0; i < cantidadDePersonas; i++) {
                if (personas[i] instanceof Deportista) {
                    Deportista dep = (Deportista) personas[i];
                    dep.imprimirDatosPer();
                }

                if (personas[i] instanceof Entrenador) {
                    Entrenador ent = (Entrenador) personas[i];
                    ent.imprimirDatosPer();
                }
                System.out.println("");
            }
        } else {//Si trata de imprimir el vector de Personas del Gym pero esta vacio
            System.out.println("\nNo hay peronas almacenadas en el Gimnasio");
        }

    }

    public boolean verificaVectorVacio() {
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
