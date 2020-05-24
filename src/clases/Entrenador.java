package clases;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Entrenador extends Persona {

    //Atributos propios de la clase Entrenador
    DecimalFormat df = new DecimalFormat("#.00");
    private int experienciaLaboral;
    private String especialidad;

    //Constructor
    //Constructor con parametros
    public Entrenador(int cedula, String nombre, int edad, char sexo, double peso, double altura, String direccion, int experienciaLaboral, String especialidad) {
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
    public boolean validarExperienciaLaboral() {
        if (experienciaLaboral < 0 || experienciaLaboral >= edad) {
            return false;
        }
        return true;
    }

    //Validar Experiencia Laboral
    public void validarEspecialidad() {

    }

    //Leer datos de la clase Persona + los atributos propios de Entrenador que serian experienciaLaboral y especialidad 
    @Override
    public void leerDatosPer() {
        super.leerDatosPer();
        Scanner entrada = new Scanner(System.in);

        //Validacion de la experiencia laboral 
        do {
            System.out.print("\nIngrese su experiencia laboral (en años): ");
            while(!entrada.hasNextInt()){
                System.out.println("ERROR : Ese no es un numero! Ingrese solo numeros");
                System.out.print("\nIngrese su experiencia laboral (en años) nuevamente: ");
                entrada.next();
            }
            experienciaLaboral = entrada.nextInt();

            if (validarExperienciaLaboral() == false) {
                System.out.println("\nHa ingresado una cantidad fuera de rango, ingrese solo una cantidad mayor o igual a 0 y menor que su edad");
            }

        } while (validarExperienciaLaboral() == false);

        //Leer la especialidad
        System.out.print("\nIngrese su especialidad: ");
        entrada.nextLine();
        especialidad = entrada.nextLine();

    }

    //Imprimir atributos de la clase Persona + los atributos propios de Entrenador que serian experienciaLaboral y especialidad  
    @Override
    public void imprimirDatosPer() {
        super.imprimirDatosPer();
        System.out.println("Experiencia Laboral: " + experienciaLaboral + " años");
        System.out.println("Especialidad: " + especialidad);
    }

    //Determinar la rutina a practicar al Entrenador
    public void determinarRutina(double imcDeportista, double grasaCorporal, String tipoEjercicio) {
        System.out.println("\n----RUTINA RECOMENDADA----");
        System.out.println("IMC: " + df.format(imcDeportista));
        System.out.println("Tipo Ejercicio: " + tipoEjercicio);
        System.out.println("Porcentaje de Grasa Corporal : " + df.format(grasaCorporal) + "%");
        System.out.print("RUTINA RECOMENDADA : ");
        if (imcDeportista >= 0 && imcDeportista < 18) {
            if (grasaCorporal < 15) {
                if (tipoEjercicio.equalsIgnoreCase("tonificacion")) {
                    System.out.println("Yoga");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de peso")) {
                    System.out.println("Zumba");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de medidas")) {
                    System.out.println("Bailoterapia");
                }
                if (tipoEjercicio.equalsIgnoreCase("cardio")) {
                    System.out.println("Inductores");
                }
                if (tipoEjercicio.equalsIgnoreCase("pesas")) {
                    System.out.println("Spinning");
                }
                if (tipoEjercicio.equalsIgnoreCase("flexibilidad y equilibrio")) {
                    System.out.println("Jumping Jack");
                }
                if (tipoEjercicio.equalsIgnoreCase("relajacion")) {
                    System.out.println("Ejercicios de estiramientos ");
                }
            }
            if (grasaCorporal >= 15 && grasaCorporal <= 20) {
                if (tipoEjercicio.equalsIgnoreCase("tonificacion")) {
                    System.out.println("Yoga");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de peso")) {
                    System.out.println("Zumba");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de medidas")) {
                    System.out.println("Bailoterapia");
                }
                if (tipoEjercicio.equalsIgnoreCase("cardio")) {
                    System.out.println("Inductores");
                }
                if (tipoEjercicio.equalsIgnoreCase("pesas")) {
                    System.out.println("Spinning");
                }
                if (tipoEjercicio.equalsIgnoreCase("flexibilidad y equilibrio")) {
                    System.out.println("Jumping Jack");
                }
                if (tipoEjercicio.equalsIgnoreCase("relajacion")) {
                    System.out.println("Ejercicios de estiramientos ");
                }
            }
            if (grasaCorporal >= 20 && grasaCorporal <= 25) {
                if (tipoEjercicio.equalsIgnoreCase("tonificacion")) {
                    System.out.println("Yoga");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de peso")) {
                    System.out.println("Zumba");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de medidas")) {
                    System.out.println("Bailoterapia");
                }
                if (tipoEjercicio.equalsIgnoreCase("cardio")) {
                    System.out.println("Inductores");
                }
                if (tipoEjercicio.equalsIgnoreCase("pesas")) {
                    System.out.println("Spinning");
                }
                if (tipoEjercicio.equalsIgnoreCase("flexibilidad y equilibrio")) {
                    System.out.println("Jumping Jack");
                }
                if (tipoEjercicio.equalsIgnoreCase("relajacion")) {
                    System.out.println("Ejercicios de estiramientos ");
                }
            }
            if (grasaCorporal >= 25 && grasaCorporal <= 30) {
                if (tipoEjercicio.equalsIgnoreCase("tonificacion")) {
                    System.out.println("Yoga");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de peso")) {
                    System.out.println("Zumba");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de medidas")) {
                    System.out.println("Bailoterapia");
                }
                if (tipoEjercicio.equalsIgnoreCase("cardio")) {
                    System.out.println("Inductores");
                }
                if (tipoEjercicio.equalsIgnoreCase("pesas")) {
                    System.out.println("Spinning");
                }
                if (tipoEjercicio.equalsIgnoreCase("flexibilidad y equilibrio")) {
                    System.out.println("Jumping Jack");
                }
                if (tipoEjercicio.equalsIgnoreCase("relajacion")) {
                    System.out.println("Ejercicios de estiramientos ");
                }
            }
            if (grasaCorporal > 30) {
                if (tipoEjercicio.equalsIgnoreCase("tonificacion")) {
                    System.out.println("Yoga");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de peso")) {
                    System.out.println("Zumba");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de medidas")) {
                    System.out.println("Bailoterapia");
                }
                if (tipoEjercicio.equalsIgnoreCase("cardio")) {
                    System.out.println("Inductores");
                }
                if (tipoEjercicio.equalsIgnoreCase("pesas")) {
                    System.out.println("Spinning");
                }
                if (tipoEjercicio.equalsIgnoreCase("flexibilidad y equilibrio")) {
                    System.out.println("Jumping Jack");
                }
                if (tipoEjercicio.equalsIgnoreCase("relajacion")) {
                    System.out.println("Ejercicios de estiramientos ");
                }
            }

        }
        if (imcDeportista >= 18 && imcDeportista < 25) {
            if (grasaCorporal < 15) {
                if (tipoEjercicio.equalsIgnoreCase("tonificacion")) {
                    System.out.println("Yoga");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de peso")) {
                    System.out.println("Zumba");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de medidas")) {
                    System.out.println("Bailoterapia");
                }
                if (tipoEjercicio.equalsIgnoreCase("cardio")) {
                    System.out.println("Inductores");
                }
                if (tipoEjercicio.equalsIgnoreCase("pesas")) {
                    System.out.println("Spinning");
                }
                if (tipoEjercicio.equalsIgnoreCase("flexibilidad y equilibrio")) {
                    System.out.println("Jumping Jack");
                }
                if (tipoEjercicio.equalsIgnoreCase("relajacion")) {
                    System.out.println("Ejercicios de estiramientos ");
                }
            }
            if (grasaCorporal >= 15 && grasaCorporal <= 20) {
                if (tipoEjercicio.equalsIgnoreCase("tonificacion")) {
                    System.out.println("Yoga");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de peso")) {
                    System.out.println("Zumba");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de medidas")) {
                    System.out.println("Bailoterapia");
                }
                if (tipoEjercicio.equalsIgnoreCase("cardio")) {
                    System.out.println("Inductores");
                }
                if (tipoEjercicio.equalsIgnoreCase("pesas")) {
                    System.out.println("Spinning");
                }
                if (tipoEjercicio.equalsIgnoreCase("flexibilidad y equilibrio")) {
                    System.out.println("Jumping Jack");
                }
                if (tipoEjercicio.equalsIgnoreCase("relajacion")) {
                    System.out.println("Ejercicios de estiramientos ");
                }
            }
            if (grasaCorporal >= 20 && grasaCorporal <= 25) {
                if (tipoEjercicio.equalsIgnoreCase("tonificacion")) {
                    System.out.println("Yoga");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de peso")) {
                    System.out.println("Zumba");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de medidas")) {
                    System.out.println("Bailoterapia");
                }
                if (tipoEjercicio.equalsIgnoreCase("cardio")) {
                    System.out.println("Inductores");
                }
                if (tipoEjercicio.equalsIgnoreCase("pesas")) {
                    System.out.println("Spinning");
                }
                if (tipoEjercicio.equalsIgnoreCase("flexibilidad y equilibrio")) {
                    System.out.println("Jumping Jack");
                }
                if (tipoEjercicio.equalsIgnoreCase("relajacion")) {
                    System.out.println("Ejercicios de estiramientos ");
                }
            }
            if (grasaCorporal >= 25 && grasaCorporal <= 30) {
                if (tipoEjercicio.equalsIgnoreCase("tonificacion")) {
                    System.out.println("Yoga");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de peso")) {
                    System.out.println("Zumba");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de medidas")) {
                    System.out.println("Bailoterapia");
                }
                if (tipoEjercicio.equalsIgnoreCase("cardio")) {
                    System.out.println("Inductores");
                }
                if (tipoEjercicio.equalsIgnoreCase("pesas")) {
                    System.out.println("Spinning");
                }
                if (tipoEjercicio.equalsIgnoreCase("flexibilidad y equilibrio")) {
                    System.out.println("Jumping Jack");
                }
                if (tipoEjercicio.equalsIgnoreCase("relajacion")) {
                    System.out.println("Ejercicios de estiramientos ");
                }
            }
            if (grasaCorporal > 30) {
                if (tipoEjercicio.equalsIgnoreCase("tonificacion")) {
                    System.out.println("Yoga");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de peso")) {
                    System.out.println("Zumba");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de medidas")) {
                    System.out.println("Bailoterapia");
                }
                if (tipoEjercicio.equalsIgnoreCase("cardio")) {
                    System.out.println("Inductores");
                }
                if (tipoEjercicio.equalsIgnoreCase("pesas")) {
                    System.out.println("Spinning");
                }
                if (tipoEjercicio.equalsIgnoreCase("flexibilidad y equilibrio")) {
                    System.out.println("Jumping Jack");
                }
                if (tipoEjercicio.equalsIgnoreCase("relajacion")) {
                    System.out.println("Ejercicios de estiramientos ");
                }
            }
        }
        if (imcDeportista >= 25 && imcDeportista < 40) {
            if (grasaCorporal < 15) {
                if (tipoEjercicio.equalsIgnoreCase("tonificacion")) {
                    System.out.println("Yoga");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de peso")) {
                    System.out.println("Zumba");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de medidas")) {
                    System.out.println("Bailoterapia");
                }
                if (tipoEjercicio.equalsIgnoreCase("cardio")) {
                    System.out.println("Inductores");
                }
                if (tipoEjercicio.equalsIgnoreCase("pesas")) {
                    System.out.println("Spinning");
                }
                if (tipoEjercicio.equalsIgnoreCase("flexibilidad y equilibrio")) {
                    System.out.println("Jumping Jack");
                }
                if (tipoEjercicio.equalsIgnoreCase("relajacion")) {
                    System.out.println("Ejercicios de estiramientos ");
                }
            }
            if (grasaCorporal >= 15 && grasaCorporal <= 20) {
                if (tipoEjercicio.equalsIgnoreCase("tonificacion")) {
                    System.out.println("Yoga");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de peso")) {
                    System.out.println("Zumba");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de medidas")) {
                    System.out.println("Bailoterapia");
                }
                if (tipoEjercicio.equalsIgnoreCase("cardio")) {
                    System.out.println("Inductores");
                }
                if (tipoEjercicio.equalsIgnoreCase("pesas")) {
                    System.out.println("Spinning");
                }
                if (tipoEjercicio.equalsIgnoreCase("flexibilidad y equilibrio")) {
                    System.out.println("Jumping Jack");
                }
                if (tipoEjercicio.equalsIgnoreCase("relajacion")) {
                    System.out.println("Ejercicios de estiramientos ");
                }
            }
            if (grasaCorporal >= 20 && grasaCorporal <= 25) {
                if (tipoEjercicio.equalsIgnoreCase("tonificacion")) {
                    System.out.println("Yoga");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de peso")) {
                    System.out.println("Zumba");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de medidas")) {
                    System.out.println("Bailoterapia");
                }
                if (tipoEjercicio.equalsIgnoreCase("cardio")) {
                    System.out.println("Inductores");
                }
                if (tipoEjercicio.equalsIgnoreCase("pesas")) {
                    System.out.println("Spinning");
                }
                if (tipoEjercicio.equalsIgnoreCase("flexibilidad y equilibrio")) {
                    System.out.println("Jumping Jack");
                }
                if (tipoEjercicio.equalsIgnoreCase("relajacion")) {
                    System.out.println("Ejercicios de estiramientos ");
                }
            }
            if (grasaCorporal >= 25 && grasaCorporal <= 30) {
                if (tipoEjercicio.equalsIgnoreCase("tonificacion")) {
                    System.out.println("Yoga");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de peso")) {
                    System.out.println("Zumba");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de medidas")) {
                    System.out.println("Bailoterapia");
                }
                if (tipoEjercicio.equalsIgnoreCase("cardio")) {
                    System.out.println("Inductores");
                }
                if (tipoEjercicio.equalsIgnoreCase("pesas")) {
                    System.out.println("Spinning");
                }
                if (tipoEjercicio.equalsIgnoreCase("flexibilidad y equilibrio")) {
                    System.out.println("Jumping Jack");
                }
                if (tipoEjercicio.equalsIgnoreCase("relajacion")) {
                    System.out.println("Ejercicios de estiramientos ");
                }
            }
            if (grasaCorporal > 30) {
                if (tipoEjercicio.equalsIgnoreCase("tonificacion")) {
                    System.out.println("Yoga");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de peso")) {
                    System.out.println("Zumba");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de medidas")) {
                    System.out.println("Bailoterapia");
                }
                if (tipoEjercicio.equalsIgnoreCase("cardio")) {
                    System.out.println("Inductores");
                }
                if (tipoEjercicio.equalsIgnoreCase("pesas")) {
                    System.out.println("Spinning");
                }
                if (tipoEjercicio.equalsIgnoreCase("flexibilidad y equilibrio")) {
                    System.out.println("Jumping Jack");
                }
                if (tipoEjercicio.equalsIgnoreCase("relajacion")) {
                    System.out.println("Ejercicios de estiramientos ");
                }
            }
        }
        if (imcDeportista >= 40) {
            if (grasaCorporal < 15) {
                if (tipoEjercicio.equalsIgnoreCase("tonificacion")) {
                    System.out.println("Yoga");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de peso")) {
                    System.out.println("Zumba");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de medidas")) {
                    System.out.println("Bailoterapia");
                }
                if (tipoEjercicio.equalsIgnoreCase("cardio")) {
                    System.out.println("Inductores");
                }
                if (tipoEjercicio.equalsIgnoreCase("pesas")) {
                    System.out.println("Spinning");
                }
                if (tipoEjercicio.equalsIgnoreCase("flexibilidad y equilibrio")) {
                    System.out.println("Jumping Jack");
                }
                if (tipoEjercicio.equalsIgnoreCase("relajacion")) {
                    System.out.println("Ejercicios de estiramientos ");
                }
            }
            if (grasaCorporal >= 15 && grasaCorporal <= 20) {
                if (tipoEjercicio.equalsIgnoreCase("tonificacion")) {
                    System.out.println("Yoga");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de peso")) {
                    System.out.println("Zumba");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de medidas")) {
                    System.out.println("Bailoterapia");
                }
                if (tipoEjercicio.equalsIgnoreCase("cardio")) {
                    System.out.println("Inductores");
                }
                if (tipoEjercicio.equalsIgnoreCase("pesas")) {
                    System.out.println("Spinning");
                }
                if (tipoEjercicio.equalsIgnoreCase("flexibilidad y equilibrio")) {
                    System.out.println("Jumping Jack");
                }
                if (tipoEjercicio.equalsIgnoreCase("relajacion")) {
                    System.out.println("Ejercicios de estiramientos ");
                }
            }
            if (grasaCorporal >= 20 && grasaCorporal <= 25) {
                if (tipoEjercicio.equalsIgnoreCase("tonificacion")) {
                    System.out.println("Yoga");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de peso")) {
                    System.out.println("Zumba");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de medidas")) {
                    System.out.println("Bailoterapia");
                }
                if (tipoEjercicio.equalsIgnoreCase("cardio")) {
                    System.out.println("Inductores");
                }
                if (tipoEjercicio.equalsIgnoreCase("pesas")) {
                    System.out.println("Spinning");
                }
                if (tipoEjercicio.equalsIgnoreCase("flexibilidad y equilibrio")) {
                    System.out.println("Jumping Jack");
                }
                if (tipoEjercicio.equalsIgnoreCase("relajacion")) {
                    System.out.println("Ejercicios de estiramientos ");
                }
            }
            if (grasaCorporal >= 25 && grasaCorporal <= 30) {
                if (tipoEjercicio.equalsIgnoreCase("tonificacion")) {
                    System.out.println("Yoga");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de peso")) {
                    System.out.println("Zumba");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de medidas")) {
                    System.out.println("Bailoterapia");
                }
                if (tipoEjercicio.equalsIgnoreCase("cardio")) {
                    System.out.println("Inductores");
                }
                if (tipoEjercicio.equalsIgnoreCase("pesas")) {
                    System.out.println("Spinning");
                }
                if (tipoEjercicio.equalsIgnoreCase("flexibilidad y equilibrio")) {
                    System.out.println("Jumping Jack");
                }
                if (tipoEjercicio.equalsIgnoreCase("relajacion")) {
                    System.out.println("Ejercicios de estiramientos ");
                }
            }
            if (grasaCorporal > 30) {
                if (tipoEjercicio.equalsIgnoreCase("tonificacion")) {
                    System.out.println("Yoga");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de peso")) {
                    System.out.println("Zumba");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de medidas")) {
                    System.out.println("Bailoterapia");
                }
                if (tipoEjercicio.equalsIgnoreCase("cardio")) {
                    System.out.println("Inductores");
                }
                if (tipoEjercicio.equalsIgnoreCase("pesas")) {
                    System.out.println("Spinning");
                }
                if (tipoEjercicio.equalsIgnoreCase("flexibilidad y equilibrio")) {
                    System.out.println("Jumping Jack");
                }
                if (tipoEjercicio.equalsIgnoreCase("relajacion")) {
                    System.out.println("Ejercicios de estiramientos ");
                }
            }
        }
    }

    //Determinar objetivos de rutina al Entrenador (metodo sobrecargado)
    public void determinarRutina(String tipoEjercicio) {
        System.out.println("\n----OBJETIVOS RECOMENDADOS A CUMPLIR----");
        if (tipoEjercicio.equalsIgnoreCase("tonificacion")) {
            System.out.println(tipoEjercicio + " + Zumba");
        }
        if (tipoEjercicio.equalsIgnoreCase("reduccion de peso")) {
            System.out.println(tipoEjercicio + " + Aerobic");
        }
        if (tipoEjercicio.equalsIgnoreCase("reduccion de medidas")) {
            System.out.println(tipoEjercicio + " + Salsa");
        }
        if (tipoEjercicio.equalsIgnoreCase("cardio")) {
            System.out.println(tipoEjercicio + " + Inductores");
        }
        if (tipoEjercicio.equalsIgnoreCase("pesas")) {
            System.out.println(tipoEjercicio + " + Spinning");
        }
        if (tipoEjercicio.equalsIgnoreCase("flexibilidad y equilibrio")) {
            System.out.println(tipoEjercicio + " + Jumping Jack");
        }
        if (tipoEjercicio.equalsIgnoreCase("relajacion")) {
            System.out.println(tipoEjercicio + " + Ejercicios de estiramientos");
        }
    }

}
