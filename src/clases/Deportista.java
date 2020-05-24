package clases;

import java.util.Scanner;

public class Deportista extends Persona{
    //Atributos propios de la clase Deportista
    private int ritmoCardiaco;
    private String frecuenciaEntrenamiento;
    protected String tipoEjercicio;

    
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
            ritmoCardiaco = entrada.nextInt();
            if(validarRitmoCardiaco()==false){
                System.out.println("\nHa ingresado ritmo cardiaco fuera de rango, ingrese solo un ritmo cardiaco mayor o igual a 0 (lpm) y menor de 1000 (lpm)");
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
        super.imprimirDatosPer();
        System.out.println("Ritmo cardíaco: "+ritmoCardiaco+" (LPM)");
        System.out.println("Frecuencia de entrenamiento: "+frecuenciaEntrenamiento);
        System.out.println("Tipo de ejercicio: "+tipoEjercicio);
    }
          
    /*
    public int leerGenero(){
        int genero;
        Scanner entrada = new Scanner (System.in);
        do{
            System.out.println("Introduzca el numero 1 si es hombre y 0 si es mujer");
            genero = entrada.nextInt();
            if(genero!=1 || genero!=0){
                System.out.println("Error! Solo se permite 1 para hombre y 0 para mujer, intentelo nuevamente");
            }
        }while(genero!=1 || genero!=0);
        return genero;
    }*/
    
    
    public double imcDeportista(){
        return (super.calcularIMC());
    }
    
    // Sobrescribir el método calcularIMC() de la Clase Persona que ahora calcula el porcentaje de grasa
    @Override
    public double calcularIMC(){    
        //int genero = leerGenero();
        double porcentajeGrasa;
        
        if(sexo=='M' || sexo=='m'){ //Si es masculino se multiplica *1 en la formula, si es femenino se multiplica *0
            porcentajeGrasa = ((1.20*super.calcularIMC()) + (0.23*edad)-(10.8*1)-5.4);
        }else{
            porcentajeGrasa = ((1.20*super.calcularIMC()) + (0.23*edad)-(10.8*0)-5.4);
        }
   
        return porcentajeGrasa;
    }
    
    //Dar diagnostico en base al porcentaje de grasa calculado
    public void diagnosticoPorcentajeGrasa(double porcentajeGrasa){
        System.out.println("\nDiagnotico:");
        
        if(sexo=='F' || sexo=='f'){//Diagnostico del Porcentaje de grasa para mujeres
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
    
    //Verificar ritmo cardiaco alto en reposo (>100pm)
    public void verificarRitmoCardiacoAlto(){
        if(ritmoCardiaco>100){//Si esta alto, se le recomienda no realizar entrenamiento hoy
            System.out.println ("\n----RECOMENDACION: No realizar entrenamiento hoy----");
        }else{                //Si esta bajo, se le recomienda realizar entrenamiento hoy
            System.out.println ("\n----RECOMENDACION: Realizar entrenamiento hoy----");
        }              
    }          
    
}