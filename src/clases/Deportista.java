package clases;

import java.util.Scanner;
import java.text.DecimalFormat;

public class Deportista extends Persona{
    //Atributos propios de la clase Deportista
    DecimalFormat df = new DecimalFormat("#.00");
    private int ritmoCardiaco;
    private String frecuenciaEntrenamiento;
    private String tipoEjercicio;

    
    //Constructores
    //Constructor con parametros
    public Deportista(int cedula, String nombre, int edad, char sexo, double peso, double altura, String direccion,int ritmoCardiaco, String frecuenciaEntrenamiento, String tipoEjercicio) {
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
    
    
    
    //Metodos
    //Validar Ritmo Cardiaco
    public boolean validarRitmoCardiaco(){      
        if(ritmoCardiaco<0 || ritmoCardiaco>1000){
            return false;
        }
            return true;
    }
    //Validar Frecuencia
    public boolean validarFrecuenciaEntrenamiento(){      
        if(!(frecuenciaEntrenamiento.equalsIgnoreCase("diario")) && !(frecuenciaEntrenamiento.equalsIgnoreCase("semanal"))){
            return false;
        }
            return true;
    }
    
    //Validar Tipo de Ejercicio
    public boolean validarTipoEjercicio(){     
        if(!(tipoEjercicio.equalsIgnoreCase("tonificacion")) && !(tipoEjercicio.equalsIgnoreCase("reduccion de peso")) && !(tipoEjercicio.equalsIgnoreCase("reduccion de medidas")) && !(tipoEjercicio.equalsIgnoreCase("cardio")) && !(tipoEjercicio.equalsIgnoreCase("pesas")) && !(tipoEjercicio.equalsIgnoreCase("flexibilidad y equilibrio")) && !(tipoEjercicio.equalsIgnoreCase("relajacion"))){
            return false;
        }
            return true;
    }

    //Leer datos de la clase Persona + los atributos propios de Deportista que serian Ritmo cardíaco, Frecuencia de entrenamiento, Tipo de ejercicio 
    @Override
    public void leerDatosPer(){
        super.leerDatosPer();
        Scanner entrada = new Scanner(System.in);
        //Leer correctamente el ritmo cardiaco 
        do{ 
            System.out.print("\nIngrese su ritmo cardiaco (LPM): ");
            while(!entrada.hasNextInt()){
                System.out.println("ERROR : Ese no es un numero! Ingrese solo numeros");
                System.out.print("\nIngrese su ritmo cardiaco (LPM) nuevamente: ");
                entrada.next();
            }
            ritmoCardiaco = entrada.nextInt();
            if(validarRitmoCardiaco()==false){
                System.out.println("\nHa ingresado ritmo cardiaco fuera de rango, ingrese solo un ritmo cardiaco mayor o igual a 0 (LPM) y menor de 1000 (LPM)");
            }
       }while(validarRitmoCardiaco()==false);
        
        //Leer correctamente Frecuencia de entrenamiento
        entrada.nextLine();
        do{ 
            System.out.print("\nIngrese su Frecuencia de entrenamiento (diario o semanal): ");
            frecuenciaEntrenamiento = entrada.nextLine();
            if(validarFrecuenciaEntrenamiento()==false){
                System.out.println("\nHa ingresado una frecuencia de entrenamiento incorrecta, ingrese solo diario o semanal");
            }
        }while(validarFrecuenciaEntrenamiento()==false);
        
        //Leer correctamente Tipo de Ejercicio
        do{ 
            System.out.print("\nIngrese su Tipo de Ejercicio (tonificacion, reduccion de peso, reduccion de medidas, cardio, pesas,flexibilidad y equilibrio, relajacion): ");
            tipoEjercicio = entrada.nextLine();
            if(validarTipoEjercicio()==false){
                System.out.println("\nHa ingresado un Tipo de Ejercicio incorrecto, ingrese solo tonificacion, reduccion de peso, reduccion de medidas, cardio, pesas,flexibilidad y equilibrio, o relajacion");
            }
       }while(validarTipoEjercicio()==false);
 
    }
    

    //Imprimir atributos de la clase Persona + los atributos propios de Deportista que serian Ritmo cardíaco, Frecuencia de entrenamiento, Tipo de ejercicio 
    @Override
    public void imprimirDatosPer() {
        System.out.println("\n----DATOS DEL DEPORTISTA----");
        System.out.println("Nombre: " + super.getNombre() + " \nCedula: " + super.getCedula() + " \nEdad: " + super.getEdad() + " años \nSexo: " + super.getSexo() + " \nPeso: " + super.getPeso() + "kg \nAltura: " + super.getAltura() + "m \nDirecion: " + super.getDireccion());
        System.out.println("Ritmo cardíaco: "+ritmoCardiaco+" (LPM)");
        System.out.println("Frecuencia de entrenamiento: "+frecuenciaEntrenamiento);
        System.out.println("Tipo de ejercicio: "+tipoEjercicio);
        System.out.println("IMC: "+ df.format(imcDeportista()));
        System.out.println("Porcentaje de grasa: "+df.format(calcularIMC())+"%");
        diagnosticoPorcentajeGrasa(calcularIMC());
    }
          
 
    public double imcDeportista(){
        return (super.calcularIMC());
    }
    
    // Sobrescribir el método calcularIMC() de la Clase Persona que ahora calcula el porcentaje de grasa
    @Override
    public double calcularIMC(){    
        double porcentajeGrasa;
        
        if(getSexo()=='M' || getSexo()=='m'){ //Si es masculino se multiplica *1 en la formula, si es femenino se multiplica *0
            porcentajeGrasa = ((1.20*super.calcularIMC()) + (0.23*getEdad())-(10.8*1)-5.4);
        }else{
            porcentajeGrasa = ((1.20*super.calcularIMC()) + (0.23*getEdad())-(10.8*0)-5.4);
        }
   
        return porcentajeGrasa;
    }
    
    //Dar diagnostico en base al porcentaje de grasa calculado
    public void diagnosticoPorcentajeGrasa(double porcentajeGrasa){
        System.out.print("\nSu diagnostico en base a su porcentaje de grasa es: ");
        if(getSexo()=='F' || getSexo()=='f'){//Diagnostico del Porcentaje de grasa para mujeres
            if(porcentajeGrasa<25){
                System.out.println("Es una persona delgada");
            }
            if(porcentajeGrasa>=25 && porcentajeGrasa<=30){
                System.out.println("Es una persona normal");
            }
            if(porcentajeGrasa>30){
                System.out.println("Tiene exceso de grasa corporal");
            }
        }else{ //Diagnostico del Porcentaje de grasa para hombres
            if(porcentajeGrasa<15){
                System.out.println("Es una persona delgada");
            }
            if(porcentajeGrasa>=15 && porcentajeGrasa<=20){
                System.out.println("Es una persona normal");
            }
            if(porcentajeGrasa>20){
                System.out.println("Tiene exceso de grasa corporal");
            }
        }
    }
    
    //Verificar ritmo cardiaco alto en reposo (>100pm) y se le da una recomendacion si entrenar o no hoy
    public void verificarRitmoCardiacoAlto(){
        if(ritmoCardiaco>100){//Si esta alto, se le recomienda no realizar entrenamiento hoy
            System.out.println ("\n----RECOMENDACION: No realizar entrenamiento hoy----");
        }else{                //Si esta bajo, se le recomienda realizar entrenamiento hoy
            System.out.println ("\n----RECOMENDACION: Realizar entrenamiento hoy----");
        }              
    }          
    
}