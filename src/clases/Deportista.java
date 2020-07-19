package clases;

import java.util.Scanner;
import java.text.DecimalFormat;

public class Deportista extends Persona {

    Entrenador entrenador = new Entrenador();
    //Atributos propios de la clase Deportista
    DecimalFormat df = new DecimalFormat("#.00");
    private int ritmoCardiaco;
    private String frecuenciaEntrenamiento;
    private String tipoEjercicio;
    private String numCadena;
    private boolean comprobar;

    //Constructores
    //Constructor con parametros
    public Deportista(int cedula, String nombre, int edad, String sexo, double peso, double altura, String direccion, int ritmoCardiaco, String frecuenciaEntrenamiento, String tipoEjercicio) {
        super(cedula, nombre, edad, sexo, peso, altura, direccion);
        this.ritmoCardiaco = ritmoCardiaco;
        this.frecuenciaEntrenamiento = frecuenciaEntrenamiento;
        this.tipoEjercicio = tipoEjercicio;
    }

    //Constructor sin parametros
    public Deportista() {
        super();
        ritmoCardiaco = 0;
        frecuenciaEntrenamiento = "";
        tipoEjercicio = "";
    }

    //Getters y Setters
    public int getRitmoCardiaco() {
        return ritmoCardiaco;
    }

    public void setRitmoCardiaco(int ritmoCardiaco) {
        this.ritmoCardiaco = ritmoCardiaco;
    }

    public String getFrecuenciaEntrenamiento() {
        return frecuenciaEntrenamiento;
    }

    public void setFrecuenciaEntrenamiento(String frecuenciaEntrenamiento) {
        this.frecuenciaEntrenamiento = frecuenciaEntrenamiento;
    }

    public String getTipoEjercicio() {
        return tipoEjercicio;
    }

    public void setTipoEjercicio(String tipoEjercicio) {
        this.tipoEjercicio = tipoEjercicio;
    }

    //Validar Frecuencia
    public boolean validarFrecuenciaEntrenamiento() {
        if (!(frecuenciaEntrenamiento.equalsIgnoreCase("diario")) && !(frecuenciaEntrenamiento.equalsIgnoreCase("semanal"))) {
            return false;
        }
        return true;
    }

    //Validar Tipo de Ejercicio
    public boolean validarTipoEjercicio() {
        if (!(tipoEjercicio.equalsIgnoreCase("tonificacion")) && !(tipoEjercicio.equalsIgnoreCase("reduccion de peso")) && !(tipoEjercicio.equalsIgnoreCase("reduccion de medidas")) && !(tipoEjercicio.equalsIgnoreCase("cardio")) && !(tipoEjercicio.equalsIgnoreCase("pesas")) && !(tipoEjercicio.equalsIgnoreCase("flexibilidad y equilibrio")) && !(tipoEjercicio.equalsIgnoreCase("relajacion"))) {
            return false;
        }
        return true;
    }

    //Leer datos de la clase Persona + los atributos propios de Deportista que serian Ritmo cardíaco, Frecuencia de entrenamiento, Tipo de ejercicio 
    @Override
    public void leerDatosPer() {
        
//        System.out.println("\n------- DEPORTISTA -------");
        super.leerDatosPer();
        Scanner entrada = new Scanner(System.in);
        //Leer correctamente el ritmo cardiaco 
        do {
            System.out.print("\nIngrese su ritmo cardiaco (LPM): ");
                numCadena = entrada.nextLine();
                comprobar = Validación.validarRitmoCardiaco(numCadena); 
            
            
            if (comprobar) {
                ritmoCardiaco = Integer.parseInt(numCadena);
                if (ritmoCardiaco < 60 && ritmoCardiaco > 1000){
                    System.out.println("Ingrese solo un ritmo cardiaco mayor o igual a 60 (LPM) y menor de 1000 (LPM) ");
                }
            }else {
                System.err.println("ERROR : Ingrese nuevamente su ritmo cardiaco");
            }
        } while (ritmoCardiaco < 60 || ritmoCardiaco > 1000);

        //Leer correctamente Frecuencia de entrenamiento
       
       
        do {
            System.out.print("\nIngrese su Frecuencia de entrenamiento (diario o semanal): ");
            String frecuenciaEntrenamientoString = entrada.nextLine();
            String frecuenciaEntrenamientoStringMinusc = frecuenciaEntrenamientoString.toLowerCase();
            comprobar = Validación.validarFrecuenciaEntrenamiento( frecuenciaEntrenamientoStringMinusc);

            if (comprobar) {        
                frecuenciaEntrenamiento = frecuenciaEntrenamientoStringMinusc;
            } else {
                System.err.println("ERROR : Ingrese nuevamente su frecuencia de entrenamiento");
            }
        } while (comprobar == false);

        //Leer correctamente Tipo de Ejercicio
        
        do {
            
            System.out.print("\nIngrese un tipo de ejercicio ( tonificacion, reduccion de peso, reduccion de medidas, cardio, pesas,flexibilidad y equilibrio, o relajacion ) :");
            String tipoEjercicioString = entrada.nextLine();
            String tipoEjercicioStringMinusc = tipoEjercicioString.toLowerCase();
            comprobar = Validación.validarTipoEjercicio( tipoEjercicioStringMinusc);
            if (comprobar) {          
                tipoEjercicio = tipoEjercicioStringMinusc;
            } else {
                System.err.println("ERROR : Ingrese nuevamente su tipo de ejercicio " );
            }
            
        } while (comprobar == false);

    }

    //Imprimir atributos de la clase Persona + los atributos propios de Deportista que serian Ritmo cardíaco, Frecuencia de entrenamiento, Tipo de ejercicio 
    @Override
    public void imprimirDatosPer() {

        System.out.println("Nombre: " + super.getNombre() + " \nCedula: " + super.getCedula() + " \nEdad: " + super.getEdad() + " años \nSexo: " + super.getSexo() + " \nPeso: " + super.getPeso() + "kg \nAltura: " + super.getAltura() + "m \nDirecion: " + super.getDireccion());
        System.out.println("Ritmo cardíaco: " + ritmoCardiaco + " (LPM)");
        System.out.println("Frecuencia de entrenamiento: " + frecuenciaEntrenamiento);
        System.out.println("Tipo de ejercicio: " + tipoEjercicio);
        System.out.println("IMC: " + df.format(imcDeportista()));
        System.out.println("Porcentaje de grasa: " + df.format(calcularIMC()) + "%");
        diagnosticoPorcentajeGrasa(calcularIMC());
        entrenador.determinarRutina(imcDeportista(), calcularIMC(), getTipoEjercicio());
        //Determinar la rutina en base al Tipo de Ejercicio suministrado
        entrenador.determinarRutina(getTipoEjercicio());
    }

    public double imcDeportista() {
        return (super.calcularIMC());
    }

    // Sobrescribir el método calcularIMC() de la Clase Persona que ahora calcula el porcentaje de grasa
    @Override
    public double calcularIMC() {
        double porcentajeGrasa;

        if (getSexo().equals("masculino")) { //Si es masculino se multiplica *1 en la formula, si es femenino se multiplica *0
            porcentajeGrasa = ((1.20 * super.calcularIMC()) + (0.23 * getEdad()) - (10.8 * 1) - 5.4);
        } else {
            porcentajeGrasa = ((1.20 * super.calcularIMC()) + (0.23 * getEdad()) - (10.8 * 0) - 5.4);
        }

        return porcentajeGrasa;
    }

    //Dar diagnostico en base al porcentaje de grasa calculado
    public void diagnosticoPorcentajeGrasa(double porcentajeGrasa) {
        System.out.print("\nSu diagnostico en base a su porcentaje de grasa es: ");
        if (getSexo().equals("femenino")) {//Diagnostico del Porcentaje de grasa para mujeres
            if (porcentajeGrasa < 25) {
                System.out.println("Es una persona delgada");
            }
            if (porcentajeGrasa >= 25 && porcentajeGrasa <= 30) {
                System.out.println("Es una persona normal");
            }
            if (porcentajeGrasa > 30) {
                System.out.println("Tiene exceso de grasa corporal");
            }
        } else { //Diagnostico del Porcentaje de grasa para hombres
            if (porcentajeGrasa < 15) {
                System.out.println("Es una persona delgada");
            }
            if (porcentajeGrasa >= 15 && porcentajeGrasa <= 20) {
                System.out.println("Es una persona normal");
            }
            if (porcentajeGrasa > 20) {
                System.out.println("Tiene exceso de grasa corporal");
            }
        }
    }

    //Verificar ritmo cardiaco alto en reposo (>100pm) y se le da una recomendacion si entrenar o no hoy
    public void verificarRitmoCardiacoAlto() {
        if (ritmoCardiaco > 100) {//Si esta alto, se le recomienda no realizar entrenamiento hoy
            System.out.println("\n----RECOMENDACION: No realizar entrenamiento hoy----");
        } else {                //Si esta bajo, se le recomienda realizar entrenamiento hoy
            System.out.println("\n----RECOMENDACION: Realizar entrenamiento hoy----");
        }
    }

    
    
    
}
