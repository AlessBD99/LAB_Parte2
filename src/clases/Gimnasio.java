package clases;

/**
 *
 * @author Alessandro
 */
public class Gimnasio {

    //Atributos
    private Persona[] personas;
    private int cantidadpersonas;
    //Constructores

    public Gimnasio() {
        cantidadpersonas = 0;
    }

    //Setters y Getters
    public Persona getPersonas(int i) {
        return personas[i];
    }

    public void setPersonas(Persona per) {

        int i = cantidadpersonas++;
        if (per instanceof Deportista) //la cláusula instance of permite determinar a que clase pertenece un
        // objeto
        {
            personas[i] = (Deportista) per;
        } else {
            personas[i] = (Entrenador) per;
        }

    }

    public void imprimirGimnasio() {
        System.out.println("");
        System.out.println("***** Datos de las Personas *****");
        System.out.println("");
        for (int i = 0; i < cantidadpersonas; i++) {
            if (personas[i] instanceof Deportista) {

                Deportista deportista = (Deportista) personas[i];
                deportista.imprimirDatosPer();

            }
            if (personas[i] instanceof Entrenador) {

                Entrenador entrenador = (Entrenador) personas[i];
                entrenador.imprimirDatosPer();
            }
            System.out.println("");
        }
    }

}
