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

    
    //Getters y Setters
    public int getExperienciaLaboral() {
        return experienciaLaboral;
    }

    public void setExperienciaLaboral(int experienciaLaboral) {
        this.experienciaLaboral = experienciaLaboral;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    
    
    //Metodos
    //Validar experienciaLaboral
    public boolean validarExperienciaLaboral() {
        if (experienciaLaboral < 0 || experienciaLaboral >= getEdad()) {
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
                    System.out.println("YOGA");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de peso")) {
                    System.out.println("ZUMBA");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de medidas")) {
                    System.out.println("BAILOTERAPIA");
                }
                if (tipoEjercicio.equalsIgnoreCase("cardio")) {
                    System.out.println("Inductores");
                }
                if (tipoEjercicio.equalsIgnoreCase("pesas")) {
                    System.out.println("SPINNING");
                }
                if (tipoEjercicio.equalsIgnoreCase("flexibilidad y equilibrio")) {
                    System.out.println("JUMPING JACK");
                }
                if (tipoEjercicio.equalsIgnoreCase("relajacion")) {
                    System.out.println("EJERCICIO DE ESTIRAMIENTO");
                }
            }
            if (grasaCorporal >= 15 && grasaCorporal <= 20) {
                if (tipoEjercicio.equalsIgnoreCase("tonificacion")) {
                    System.out.println("PRESS INCLINADO CON BARRA");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de peso")) {
                    System.out.println("PRESS PLANO/DECLINADO CON MANCUERNAS");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de medidas")) {
                    System.out.println("PRESS MILITAR CON BARRA");
                }
                if (tipoEjercicio.equalsIgnoreCase("cardio")) {
                    System.out.println("APERTURAS EN POLEA");
                }
                if (tipoEjercicio.equalsIgnoreCase("pesas")) {
                    System.out.println("ELEVACIONES LATERALES");
                }
                if (tipoEjercicio.equalsIgnoreCase("flexibilidad y equilibrio")) {
                    System.out.println("EXTENSIONES DE TRÍCEPS POR ENCIMA DE LA CABEZA CON POLEA");
                }
                if (tipoEjercicio.equalsIgnoreCase("relajacion")) {
                    System.out.println("AB WHEEL");
                }
            }
            if (grasaCorporal >= 20 && grasaCorporal <= 25) {
                if (tipoEjercicio.equalsIgnoreCase("tonificacion")) {
                    System.out.println("DOMINADAS");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de peso")) {
                    System.out.println("REMO CON BARRA");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de medidas")) {
                    System.out.println("ENCOGIMIENTOS CON BARRA");
                }
                if (tipoEjercicio.equalsIgnoreCase("cardio")) {
                    System.out.println("NECK-PULL");
                }
                if (tipoEjercicio.equalsIgnoreCase("pesas")) {
                    System.out.println("CURL DE BÍCEPS (RECOMIENDO POLEA)");
                }
                if (tipoEjercicio.equalsIgnoreCase("flexibilidad y equilibrio")) {
                    System.out.println("CURL MARTILLO CON POLEA");
                }
                if (tipoEjercicio.equalsIgnoreCase("relajacion")) {
                    System.out.println("LAGARTIJAS");
                }
            }
            if (grasaCorporal >= 25 && grasaCorporal <= 30) {
                if (tipoEjercicio.equalsIgnoreCase("tonificacion")) {
                    System.out.println("SENTADILLA");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de peso")) {
                    System.out.println("SENTADILLA BÚLGARA");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de medidas")) {
                    System.out.println("CURL FEMORAL");
                }
                if (tipoEjercicio.equalsIgnoreCase("cardio")) {
                    System.out.println("HIP THRUST");
                }
                if (tipoEjercicio.equalsIgnoreCase("pesas")) {
                    System.out.println("ELEVACIONES GEMELO");
                }
                if (tipoEjercicio.equalsIgnoreCase("flexibilidad y equilibrio")) {
                    System.out.println("PLANCHAS LASTRADAS");
                }
                if (tipoEjercicio.equalsIgnoreCase("relajacion")) {
                    System.out.println("ABDOMINALES");
                }
            }
            if (grasaCorporal > 30) {
                if (tipoEjercicio.equalsIgnoreCase("tonificacion")) {
                    System.out.println("PRESS MILITAR CON BARRA");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de peso")) {
                    System.out.println("PRESS MILITAR CON MANCUERNA");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de medidas")) {
                    System.out.println("PRESS PLANO CON MANCUERNA");
                }
                if (tipoEjercicio.equalsIgnoreCase("cardio")) {
                    System.out.println("ELEVACIONES LATERALES");
                }
                if (tipoEjercicio.equalsIgnoreCase("pesas")) {
                    System.out.println("APERTURAS INCLINADAS CON POLEA");
                }
                if (tipoEjercicio.equalsIgnoreCase("flexibilidad y equilibrio")) {
                    System.out.println("EXTENSIONES DE TRÍCEPS POR ENCIMA DE LA CABEZA CON POLEA");
                }
                if (tipoEjercicio.equalsIgnoreCase("relajacion")) {
                    System.out.println("AB WHEEL");
                }
            }

        }
        if (imcDeportista >= 18 && imcDeportista < 25) {
            if (grasaCorporal < 15) {
                if (tipoEjercicio.equalsIgnoreCase("tonificacion")) {
                    System.out.println("REMO CON BARRA");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de peso")) {
                    System.out.println("JALÓN AL PECHO");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de medidas")) {
                    System.out.println("PULLOVERS CON POLEA");
                }
                if (tipoEjercicio.equalsIgnoreCase("cardio")) {
                    System.out.println("ENCOGIMIENTOS CON BARRA");
                }
                if (tipoEjercicio.equalsIgnoreCase("pesas")) {
                    System.out.println("FACEPULLS");
                }
                if (tipoEjercicio.equalsIgnoreCase("flexibilidad y equilibrio")) {
                    System.out.println("CURL DE BÍCEPS (RECOMIENDO POLEA)");
                }
                if (tipoEjercicio.equalsIgnoreCase("relajacion")) {
                    System.out.println("ECURL MARTILLO CON POLEA");
                }
            }
            if (grasaCorporal >= 15 && grasaCorporal <= 20) {
                if (tipoEjercicio.equalsIgnoreCase("tonificacion")) {
                    System.out.println("PESO MUERTO");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de peso")) {
                    System.out.println("SENTADILLA FRONTAL");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de medidas")) {
                    System.out.println("CURL FEMORAL");
                }
                if (tipoEjercicio.equalsIgnoreCase("cardio")) {
                    System.out.println("HIP THRUST");
                }
                if (tipoEjercicio.equalsIgnoreCase("pesas")) {
                    System.out.println("ELEVACIONES GEMELO");
                }
                if (tipoEjercicio.equalsIgnoreCase("flexibilidad y equilibrio")) {
                    System.out.println("PRESS VERTICAL");
                }
                if (tipoEjercicio.equalsIgnoreCase("relajacion")) {
                    System.out.println("PLANCHAS LASTRADAS");
                }
            }
            if (grasaCorporal >= 20 && grasaCorporal <= 25) {
                if (tipoEjercicio.equalsIgnoreCase("tonificacion")) {
                    System.out.println("PRESS HORIZONTAL");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de peso")) {
                    System.out.println("VARIANTE DE SENTADILLA");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de medidas")) {
                    System.out.println("EJERCICIO UNILATERAL PIERNA");
                }
                if (tipoEjercicio.equalsIgnoreCase("cardio")) {
                    System.out.println("EJERCICIO ACCESORIO TORSO 1");
                }
                if (tipoEjercicio.equalsIgnoreCase("pesas")) {
                    System.out.println("EJERCICIO ACCESORIO PIERNA");
                }
                if (tipoEjercicio.equalsIgnoreCase("flexibilidad y equilibrio")) {
                    System.out.println("EJERCICIO ACCESORIO TORSO 2 (OPCIONAL)");
                }
                if (tipoEjercicio.equalsIgnoreCase("relajacion")) {
                    System.out.println("TIRÓN VERTICAL");
                }
            }
            if (grasaCorporal >= 25 && grasaCorporal <= 30) {
                if (tipoEjercicio.equalsIgnoreCase("tonificacion")) {
                    System.out.println("TIRÓN HORIZONTAL");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de peso")) {
                    System.out.println("EJERCICIO DE FLEXIÓN DE RODILLA	");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de medidas")) {
                    System.out.println("EJERCICIO DE EXTENSIÓN DE CADERA	");
                }
                if (tipoEjercicio.equalsIgnoreCase("cardio")) {
                    System.out.println("EJERCICIO ACCESORIO TORSO 1");
                }
                if (tipoEjercicio.equalsIgnoreCase("pesas")) {
                    System.out.println("EJERCICIO ACCESORIO PIERNA");
                }
                if (tipoEjercicio.equalsIgnoreCase("flexibilidad y equilibrio")) {
                    System.out.println("EJERCICIO ACCESORIO TORSO 2 (OPCIONAL)");
                }
                if (tipoEjercicio.equalsIgnoreCase("relajacion")) {
                    System.out.println("VARIANTE DE SENTADILLA");
                }
            }
            if (grasaCorporal > 30) {
                if (tipoEjercicio.equalsIgnoreCase("tonificacion")) {
                    System.out.println("VARIANTE DE PRENSA DE CUÁDRICEPS");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de peso")) {
                    System.out.println("PRESS HORIZONTAL");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de medidas")) {
                    System.out.println("EJERCICIO ACCESORIO PIERNA 1");
                }
                if (tipoEjercicio.equalsIgnoreCase("cardio")) {
                    System.out.println("PRESS VERTICAL");
                }
                if (tipoEjercicio.equalsIgnoreCase("pesas")) {
                    System.out.println("EJERCICIO ACCESORIO TORSO");
                }
                if (tipoEjercicio.equalsIgnoreCase("flexibilidad y equilibrio")) {
                    System.out.println("EJERCICIO ACCESORIO PIERNA 2 (OPCIONAL)");
                }
                if (tipoEjercicio.equalsIgnoreCase("relajacion")) {
                    System.out.println("VARIANTE PESO MUERTO");
                }
            }
        }
        if (imcDeportista >= 25 && imcDeportista < 40) {
            if (grasaCorporal < 15) {
                if (tipoEjercicio.equalsIgnoreCase("tonificacion")) {
                    System.out.println("EJERCICIO FLEXIÓN DE RODILLA");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de peso")) {
                    System.out.println("TIRÓN A ELECCIÓN (VERTICAL U HORIZONTAL)");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de medidas")) {
                    System.out.println("VARIANTE FACEPULL");
                }
                if (tipoEjercicio.equalsIgnoreCase("cardio")) {
                    System.out.println("EJERCICIO ACCESORIO PIERNA 1");
                }
                if (tipoEjercicio.equalsIgnoreCase("pesas")) {
                    System.out.println("EJERCICIO ACCESORIO TORSO");
                }
                if (tipoEjercicio.equalsIgnoreCase("flexibilidad y equilibrio")) {
                    System.out.println("EJERCICIO ACCESORIO PIERNA 2 (OPCIONAL)");
                }
                if (tipoEjercicio.equalsIgnoreCase("relajacion")) {
                    System.out.println("PRESS MILITAR CON BARRA");
                }
            }
            if (grasaCorporal >= 15 && grasaCorporal <= 20) {
                if (tipoEjercicio.equalsIgnoreCase("tonificacion")) {
                    System.out.println("PRESS PLANO CON BARRA");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de peso")) {
                    System.out.println("FRONT SQUAT");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de medidas")) {
                    System.out.println("SENTADILLA BÚLGARA");
                }
                if (tipoEjercicio.equalsIgnoreCase("cardio")) {
                    System.out.println("ELEVACIONES LATERALES CON POLEA	");
                }
                if (tipoEjercicio.equalsIgnoreCase("pesas")) {
                    System.out.println("ELEVACIONES DE GEMELO SENTADO");
                }
                if (tipoEjercicio.equalsIgnoreCase("flexibilidad y equilibrio")) {
                    System.out.println("APERTURAS INCLINADAS");
                }
                if (tipoEjercicio.equalsIgnoreCase("relajacion")) {
                    System.out.println("DOMINADAS SUPINAS LASTRADAS");
                }
            }
            if (grasaCorporal >= 20 && grasaCorporal <= 25) {
                if (tipoEjercicio.equalsIgnoreCase("tonificacion")) {
                    System.out.println("REMO CON MANCUERNA");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de peso")) {
                    System.out.println("CURL FEMORAL ESTIRADO");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de medidas")) {
                    System.out.println("HIP THRUST");
                }
                if (tipoEjercicio.equalsIgnoreCase("cardio")) {
                    System.out.println("CURL DE BÍCEPS EN BANCO SCOTT");
                }
                if (tipoEjercicio.equalsIgnoreCase("pesas")) {
                    System.out.println("CABLE PULLTHOUGH");
                }
                if (tipoEjercicio.equalsIgnoreCase("flexibilidad y equilibrio")) {
                    System.out.println("PULLOVER EN POLEA");
                }
                if (tipoEjercicio.equalsIgnoreCase("relajacion")) {
                    System.out.println("SENTADILLA TRASERA");
                }
            }
            if (grasaCorporal >= 25 && grasaCorporal <= 30) {
                if (tipoEjercicio.equalsIgnoreCase("tonificacion")) {
                    System.out.println("HACK SQUAT EN MÁQUINA");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de peso")) {
                    System.out.println("PRESS INCLINADO");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de medidas")) {
                    System.out.println("PRESS MILITAR CON LANDMINE");
                }
                if (tipoEjercicio.equalsIgnoreCase("cardio")) {
                    System.out.println("ELEVACIONES DE GEMELO");
                }
                if (tipoEjercicio.equalsIgnoreCase("pesas")) {
                    System.out.println("PRESS FRANCÉS");
                }
                if (tipoEjercicio.equalsIgnoreCase("flexibilidad y equilibrio")) {
                    System.out.println("ZANCADAS CON DESPLAZAMIENTO");
                }
                if (tipoEjercicio.equalsIgnoreCase("relajacion")) {
                    System.out.println("PESO MUERTO RUMANO");
                }
            }
            if (grasaCorporal > 30) {
                if (tipoEjercicio.equalsIgnoreCase("tonificacion")) {
                    System.out.println("CURL FEMORAL SENTADO");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de peso")) {
                    System.out.println("REMO AL MENTÓN");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de medidas")) {
                    System.out.println("FACEPULL EN POLEA CON CUERDA");
                }
                if (tipoEjercicio.equalsIgnoreCase("cardio")) {
                    System.out.println("HIP THRUST");
                }
                if (tipoEjercicio.equalsIgnoreCase("pesas")) {
                    System.out.println("CURL AGARRE MARTILLO");
                }
                if (tipoEjercicio.equalsIgnoreCase("flexibilidad y equilibrio")) {
                    System.out.println("FULLBODY");
                }
                if (tipoEjercicio.equalsIgnoreCase("relajacion")) {
                    System.out.println("TORSO");
                }
            }
        }
        if (imcDeportista >= 40) {
            if (grasaCorporal < 15) {
                if (tipoEjercicio.equalsIgnoreCase("tonificacion")) {
                    System.out.println("PIERNA");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de peso")) {
                    System.out.println("EMPUJES");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de medidas")) {
                    System.out.println("TRACCIONES");
                }
                if (tipoEjercicio.equalsIgnoreCase("cardio")) {
                    System.out.println("PUSH");
                }
                if (tipoEjercicio.equalsIgnoreCase("pesas")) {
                    System.out.println("LEGS");
                }
                if (tipoEjercicio.equalsIgnoreCase("flexibilidad y equilibrio")) {
                    System.out.println("PULLk");
                }
                if (tipoEjercicio.equalsIgnoreCase("relajacion")) {
                    System.out.println("WEIDER");
                }
            }
            if (grasaCorporal >= 15 && grasaCorporal <= 20) {
                if (tipoEjercicio.equalsIgnoreCase("tonificacion")) {
                    System.out.println("PHAT");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de peso")) {
                    System.out.println("CUADRICEPS");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de medidas")) {
                    System.out.println("PRESS BANCA");
                }
                if (tipoEjercicio.equalsIgnoreCase("cardio")) {
                    System.out.println("REMO INCLINADO CON BARRA");
                }
                if (tipoEjercicio.equalsIgnoreCase("pesas")) {
                    System.out.println("ABDOMINALES");
                }
                if (tipoEjercicio.equalsIgnoreCase("flexibilidad y equilibrio")) {
                    System.out.println("PRESS FRANCES");
                }
                if (tipoEjercicio.equalsIgnoreCase("relajacion")) {
                    System.out.println("CURL FEMORAL");
                }
            }
            if (grasaCorporal >= 20 && grasaCorporal <= 25) {
                if (tipoEjercicio.equalsIgnoreCase("tonificacion")) {
                    System.out.println("PESO MUERTO");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de peso")) {
                    System.out.println("Sentadilla Profunda");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de medidas")) {
                    System.out.println("Press Militar");
                }
                if (tipoEjercicio.equalsIgnoreCase("cardio")) {
                    System.out.println("Remo Inclinado con Barra");
                }
                if (tipoEjercicio.equalsIgnoreCase("pesas")) {
                    System.out.println("Press Banca Agarre Estrecho");
                }
                if (tipoEjercicio.equalsIgnoreCase("flexibilidad y equilibrio")) {
                    System.out.println("Curl Bíceps con Barra");
                }
                if (tipoEjercicio.equalsIgnoreCase("relajacion")) {
                    System.out.println("Abs");
                }
            }
            if (grasaCorporal >= 25 && grasaCorporal <= 30) {
                if (tipoEjercicio.equalsIgnoreCase("tonificacion")) {
                    System.out.println("Planchas o Cruches");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de peso")) {
                    System.out.println("Chin-Ups ");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de medidas")) {
                    System.out.println("Flexiones");
                }
                if (tipoEjercicio.equalsIgnoreCase("cardio")) {
                    System.out.println("Goblet Squat");
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
                    System.out.println("Planchas");
                }
                if (tipoEjercicio.equalsIgnoreCase("reduccion de medidas")) {
                    System.out.println("FOAM ROLLER EN LA BANDA ILIOTIBIAL");
                }
                if (tipoEjercicio.equalsIgnoreCase("cardio")) {
                    System.out.println("PELOTA EN EL GLÚTEO");
                }
                if (tipoEjercicio.equalsIgnoreCase("pesas")) {
                    System.out.println("GIROS DE CINTURA CON PIERNAS DOBLADAS");
                }
                if (tipoEjercicio.equalsIgnoreCase("flexibilidad y equilibrio")) {
                    System.out.println("ROLLOVERS ACABADOS EN V");
                }
                if (tipoEjercicio.equalsIgnoreCase("relajacion")) {
                    System.out.println("ESTIRAMIENTO DE LA RANA (ROCKING FROG)");
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
