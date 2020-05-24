package clases;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Entrenador extends Persona{
    //Atributos propios de la clase Entrenador
    DecimalFormat df = new DecimalFormat("#.00");
    private int experienciaLaboral;
    private String especialidad;

    //Constructor
    //Constructor con parametros
    public Entrenador(int cedula, String nombre, int edad, char sexo, double peso, double altura, String direccion, int experienciaLaboral,String especialidad) {
        super(cedula, nombre, edad, sexo, peso, altura, direccion);
        this.experienciaLaboral = experienciaLaboral;
        this.especialidad = especialidad;
    }
    
    //Constructor sin parametros
    public Entrenador() {
        super();
        experienciaLaboral = 0;
        especialidad = "";
    }
    
    //Metodos
    //Validar experienciaLaboral
    //POR REVISAR
    public boolean validarExperienciaLaboral(){      
        if(experienciaLaboral<0 || experienciaLaboral>=edad){
            return false;
        }
            return true;
    }
    
    //Validar experienciaLaboral
    //POR HACER
    public void validarEspecialidad(){
        
    }
    
    //Leer datos de la clase Persona + los atributos propios de Entrenador que serian experienciaLaboral y especialidad 
    //POR REVISAR
    @Override
    public void leerDatosPer(){
        super.leerDatosPer();
        Scanner entrada = new Scanner(System.in);
        
        //Validacion de la experiencia laboral 
        do{ 
            System.out.print("\nIngrese su experiencia laboral (en años): ");
            experienciaLaboral = entrada.nextInt();
            
            if(validarExperienciaLaboral()==false){
                System.out.println("\nHa ingresado una cantidad fuera de rango, ingrese solo una cantidad mayor o igual a 0 y menor que su edad");
            }

       }while(validarExperienciaLaboral()==false );
        
        //Leer la especialidad
        System.out.print("\nIngrese su especialidad: ");
        entrada.nextLine();
        especialidad = entrada.nextLine();
        
    }
    
    
    //Imprimir atributos de la clase Persona + los atributos propios de Entrenador que serian experienciaLaboral y especialidad  
    //POR REVISAR
    @Override
    public void imprimirDatosPer() {
        super.imprimirDatosPer();
        System.out.println("Experiencia Laboral: "+experienciaLaboral);
        System.out.println("Especialidad: "+especialidad);
    }
    
    //IMPORTANTE REVISAR LOS DOS METODOS !!!!
    //Determinar la rutina a practicar al Entrenador
    public void determinarRutina(double imcDeportista,double grasaCorporal, String tipoEjercicio){
        System.out.println("\n----RUTINA RECOMENDADA----");
        System.out.println("IMC: "+df.format(imcDeportista));
        System.out.println("Tipo Ejercicio: "+tipoEjercicio);
        System.out.println("Porcentaje de Grasa Corporal : "+ df.format(grasaCorporal) +"%");
    }
    
    //Determinar objetivos de rutina al Entrenador (metodo sobrecargado)
    public void determinarRutina(double imcDeportista){
        System.out.println("\n----OBJETIVOS RECOMENDADOS A CUMPLIR----");
        System.out.println("IMC: "+ df.format(imcDeportista));       
    } 

}